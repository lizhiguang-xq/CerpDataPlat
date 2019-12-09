package org.ssm.dufy.service.impl;

import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssm.common.utility.DecimalUtils;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.pointorder.POINTORDERREQ;
import org.ssm.cxf.struct.pointorder.POINTORDERRESP;
import org.ssm.cxf.struct.pointorder.RETAILDETAIL;
import org.ssm.dufy.dao.IInsiderDao;
import org.ssm.dufy.dao.IIntegralInfoDao;
import org.ssm.dufy.dao.IPrimiumDocDao;
import org.ssm.dufy.dao.IPrimiumDtlDao;
import org.ssm.dufy.dao.IStIoDocDao;
import org.ssm.dufy.dao.IStIoDtlDao;
import org.ssm.dufy.dao.IStockDao;
import org.ssm.dufy.entity.cerpbusi.CerpStIoDoc;
import org.ssm.dufy.entity.cerpbusi.CerpStIoDtl;
import org.ssm.dufy.entity.cerpbusi.IntegralInfo;
import org.ssm.dufy.entity.cerpbusi.PrimiumDoc;
import org.ssm.dufy.entity.cerpbusi.PrimiumDtl;
import org.ssm.dufy.entity.cerppojo.Insider;
import org.ssm.dufy.entity.cerppojo.Stock;
import org.ssm.dufy.service.IPrimiumOrderService;

@Service("primiumOrderService")
public class IPrimiumOrderServiceImpl implements IPrimiumOrderService {
	
	@Autowired
	public IInsiderDao insiderdao;
	
	@Autowired
	public IStockDao stockdao;
	
	@Autowired
	public IPrimiumDocDao primiumdocdao;
	
	@Autowired
	public IPrimiumDtlDao primiumdtldao;
	
	@Autowired
	public IIntegralInfoDao integralInfodao;
	
	@Autowired
	public IStIoDocDao stIodocdao;
	
	@Autowired
	public IStIoDtlDao stIodtldao;
	
	private static Logger log = LoggerFactory.getLogger("loger");
	@Override
	@Transactional
	public String createPrimiumOrder(String entryid, String xmldata) {
		
		POINTORDERREQ pointorder_req = JAXBUtil.unmarshToObjBinding(POINTORDERREQ.class, xmldata, "UTF-8");
		POINTORDERRESP pointorderresp = new POINTORDERRESP();
		
		String retxml = "";
		String marketOrderId = pointorder_req.getORDERID(); //积分商城 订单ID
		pointorderresp.setORDERID(marketOrderId);
		
//		String create_time = pointorder_req.getCREATETIME(); //订单时间
		String entrycompanyid = pointorder_req.getENTRYCOMPANYID(); //地区ID（零售中心ID）
		String olddispatchprice = pointorder_req.getOLDDISPATCHPRICE(); //快递费
		String insiderid = pointorder_req.getINSIDERID(); //会员ID
		String totalintegral = pointorder_req.getTOTALINTEGRAL(); //订单 总积分 额
		
		List<RETAILDETAIL> retaildetaillist = pointorder_req.getRETAILDETAILLIST().getRETAILDETAIL();
		
		String goodsidList = "";
		for(RETAILDETAIL retaildetail : retaildetaillist) {
			goodsidList += retaildetail.getGOODSID() + ",";
		}
		goodsidList = goodsidList.substring(0, goodsidList.length() - 1);
		
		//1.检查地区ID是否存在对应的保管帐
		String storageid = stockdao.getStorageidByParam_Lnjfsc(entrycompanyid);
		if(StringUtil.isEmpty(storageid)) {
			throw new RuntimeException("地区ID:"+entrycompanyid+"对应的保管帐不存在!");
		}
		
		entryid = stockdao.getEntryidByStorageid(storageid);
		if(StringUtil.isEmpty(entryid)) {
			throw new RuntimeException("地区ID:"+entrycompanyid+"对应的独立单元不存在!");
		}
		
		//2.查询会员积分，锁当前会员
		List<Map<String, String>> insiderList = insiderdao.getLintegralbyId_forupdate(insiderid);
				
		if(insiderList.size() < 1) {
			throw new RuntimeException("会员ID:"+insiderid+"不存在!");
		}
		String currentintegral = String.valueOf(insiderList.get(0).get("INTEGRAL"));
		
		String remainIntegral = DecimalUtils.sub(currentintegral, totalintegral, 2);
		
		if(DecimalUtils.comparaDecimal("0", remainIntegral) >0 ) {
			throw new RuntimeException("会员ID:"+insiderid+"当前积分:"+currentintegral+"小于要消费的积分:"+totalintegral+"无法进行兑换!");
		}
		
		//3.插入 辽宁积分商城 积分兑换 总单
		int primiumdocid = primiumdocdao.getPrimiumDocSeqId();
		PrimiumDoc primiumdoc = new PrimiumDoc();
		primiumdoc.setPrimiumdocid(primiumdocid);
		primiumdoc.setEntrycompanyid(Integer.valueOf(entrycompanyid));
		primiumdoc.setEntryid(Integer.valueOf(entryid));
		primiumdoc.setInputmanid(0);
		primiumdoc.setInsiderid(Integer.valueOf(insiderid));
		primiumdoc.setJfscid(marketOrderId);
		primiumdoc.setOlddispatchprice(Double.valueOf(olddispatchprice));
		primiumdoc.setTotalintegral(Double.valueOf(totalintegral));
		
		primiumdocdao.insertPrimiumDoc(primiumdoc);
		
		//4.查询货品，锁对应赠品保管帐库存信息
		stockdao.lockStockByParam_Lnjfsc(goodsidList, storageid);
				
		for(RETAILDETAIL retaildetail : retaildetaillist) {
			String goodsid = retaildetail.getGOODSID();
			String wantqty = retaildetail.getQTY();
			String integral = retaildetail.getINTEGRAL();
			String goodsname = retaildetail.getGOODSNAME();
			//兑换赠品细单
			PrimiumDtl primiumdtl = new PrimiumDtl();
			int primiumdtlid = primiumdtldao.getPrimiumDtlSeqId();
			primiumdtl.setPrimiumdtlid(primiumdtlid);
			primiumdtl.setPrimiumdocid(primiumdocid);
			primiumdtl.setGoodsid(Integer.valueOf(goodsid));
			primiumdtl.setQty(Double.valueOf(wantqty));
			primiumdtl.setIntegral(Double.valueOf(integral));
			
			//出库单总单
			CerpStIoDoc cerpstiodoc = new CerpStIoDoc();
			int inoutid = stIodocdao.getStIoDocSeqId();
			cerpstiodoc.setInoutid(inoutid);
			cerpstiodoc.setComefrom(15);
			cerpstiodoc.setCompanyid(Integer.valueOf(entrycompanyid));
			cerpstiodoc.setEntryid(Integer.valueOf(entryid));
			cerpstiodoc.setGoodsid(Integer.valueOf(goodsid));
			cerpstiodoc.setInoutflag(0);
			cerpstiodoc.setGoodsunit("");
			cerpstiodoc.setKeepmanid(0);
			cerpstiodoc.setPreparestatus(3);
			cerpstiodoc.setOldoutqty(Double.valueOf(wantqty));
			cerpstiodoc.setOutqty(Double.valueOf(wantqty));
			cerpstiodoc.setSourcetable(15);
			cerpstiodoc.setSourceid(primiumdtlid);
			cerpstiodoc.setStorageid(Integer.valueOf(storageid));
			cerpstiodoc.setUsestatus(2);
			stIodocdao.insertStIoDoc(cerpstiodoc);
			
			//1) 查询可销库存
			//zx_lnjfsc_stqty_sum_v
			List<Stock> stQtySumList = stockdao.getStQtySumStock_Lnjfsc(goodsid, storageid);
			
			//2) 配货，减库存
			for(Stock stQty : stQtySumList) {
				
				if(DecimalUtils.comparaDecimal(wantqty, "0") <= 0) break;
				
				String dtlgoodsqty = stQty.getQty();
				String remainqty = dtlgoodsqty;
				
				//出库单细单
				CerpStIoDtl cerpstiodtl = new CerpStIoDtl();
				cerpstiodtl.setInoutid(inoutid);
				cerpstiodtl.setBatchid(Integer.valueOf(stQty.getBatchid()));
				cerpstiodtl.setGoodsdtlid(Integer.valueOf(stQty.getBatchid()));
				cerpstiodtl.setGoodsstatusid(Integer.valueOf(stQty.getGoodsstatusid()));
				cerpstiodtl.setLotid(Integer.valueOf(stQty.getLotid()));
				cerpstiodtl.setPosid(Integer.valueOf(stQty.getPosid()));
				
				if(DecimalUtils.comparaDecimal(wantqty, dtlgoodsqty) >= 0) {
					//当前库存明细，不够或正好等于订单需求数量
					cerpstiodtl.setDtlgoodsqty(Double.valueOf(dtlgoodsqty));
					wantqty = DecimalUtils.sub(wantqty, dtlgoodsqty, 2);
					//删除bms_st_qty_lst 当前库存记录
					stockdao.deleteBmsStQtyLstByParam(stQty);
				} else {
					//当前库存明细，大于订单需求数量
					cerpstiodtl.setDtlgoodsqty(Double.valueOf(wantqty));
					remainqty = DecimalUtils.sub(dtlgoodsqty, wantqty, 2);
					stQty.setQty(remainqty);
					wantqty = "0";
					//remainqty更新到 bms_st_qty_lst
					stockdao.updateBmsStQtyLstByParam(stQty);
				}
				//查出出库细单表
				stIodtldao.insertStIoDtl(cerpstiodtl);
			}
			if(DecimalUtils.comparaDecimal(wantqty, "0") > 0) {
				throw new RuntimeException("货品:"+goodsname+"("+goodsid+"), 差"+wantqty+",库存不足无法进行兑换!");
			}
			
			//3) 插入出库单，插入业务单据表
			primiumdtldao.insertPrimiumDtl(primiumdtl);
		}
		
		//减会员积分
		Insider insider = new Insider();
		insider.setInsiderid(insiderid);
		insider.setIntegral(remainIntegral);
		insiderdao.updateIntegralById(insider);
		
		//插入积分使用历史
		IntegralInfo integralinfo = new IntegralInfo();
		integralinfo.setComefrom(20);
		integralinfo.setDocid(primiumdocid);
		integralinfo.setInsiderid(Integer.valueOf(insiderid));
		integralinfo.setDebitintegal(Double.valueOf(totalintegral));
		integralInfodao.insertIntegralInfo(integralinfo);
		
		pointorderresp.setErporderid(String.valueOf(primiumdocid));
		pointorderresp.setStatus("1");
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(POINTORDERRESP.class, pointorderresp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return retxml;
	}
}
