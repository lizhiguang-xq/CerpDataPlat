package org.ssm.dufy.service.impl;

import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.goodsinfo.GOODSINFO;
import org.ssm.cxf.struct.goodsinfo.GOODSINFOREQ;
import org.ssm.cxf.struct.goodsinfo.GOODSINFORESP;
import org.ssm.cxf.struct.goodsinfo_normal.GOODSINFONORMALREQ;
import org.ssm.cxf.struct.goodsinfo_normal.GOODSINFONORMALRESP;
import org.ssm.cxf.struct.goodsinfo_normal.GoodsItem;
import org.ssm.cxf.struct.goodsinfo_normal.GoodsinfoNormal;
import org.ssm.cxf.struct.stock.STOCKINFO;
import org.ssm.cxf.struct.stock.STOCKINFOREQ;
import org.ssm.cxf.struct.stock.STOCKINFORESP;
import org.ssm.dufy.dao.IGoodsDao;
import org.ssm.dufy.dao.IStockDao;
import org.ssm.dufy.entity.cerppojo.Goods;
import org.ssm.dufy.entity.cerppojo.Stock;
import org.ssm.dufy.service.IGoodsService;

@Service("goodsService")
public class IGoodsServiceImpl implements IGoodsService {

	@Autowired
	public IGoodsDao goodsdao;
	
	@Autowired
	public IStockDao stockdao;
	
	@Override
	public Goods getGoodsById(int id) {
		return null;
	}

	@Override
	public List<Goods> getGoodsByParam(String entryid, String goodsid, String sys_modifydate, int ym) {
		
		@SuppressWarnings("unchecked")
		List<Goods> goodslist = (List<Goods>) goodsdao.getGoodsByParam(entryid, goodsid, sys_modifydate, ym);
		return goodslist;
	}

	@Override
	public String getGoods(String entryid, String xmldata) {		
		GOODSINFOREQ goodsinfo_req= JAXBUtil.unmarshToObjBinding(GOODSINFOREQ.class, xmldata, "UTF-8");
		String goodsid = goodsinfo_req.getGOODSID();
		String sys_modifydate = goodsinfo_req.getSYSMODIFYDATE();
		String ym = goodsinfo_req.getYM();		
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Goods> goodslist = (List<Goods>) goodsdao.getGoodsByParam(entryid, goodsid, sys_modifydate, Integer.valueOf(ym));
		GOODSINFORESP goodsinforesp = new GOODSINFORESP();
		List<GOODSINFO> goodsinfolist = goodsinforesp.getGOODSINFO();
		
		for(Goods g : goodslist) {
			GOODSINFO goodsinfo = new GOODSINFO();
			goodsinfo.setGoodsid(g.getGoodsid());
			goodsinfo.setGoodsname(g.getGoodsname());
			goodsinfo.setGoodstype(g.getGoodstype());
			goodsinfo.setGoodsunit(g.getGoodsunit());
			goodsinfo.setCurrencyname(g.getCurrencyname());
			goodsinfo.setEntryid(g.getEntryid());
			goodsinfo.setBarcode(g.getBarcode());
			goodsinfo.setFactoryname(g.getFactoryname());
			goodsinfo.setSysModifydate(g.getSys_modifydate());
			goodsinfolist.add(goodsinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(GOODSINFORESP.class, goodsinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return retxml;
	}

	@Override
	public String getGoods_Lnjfsc(String entryid, String xmldata) {
		GOODSINFOREQ goodsinfo_req= JAXBUtil.unmarshToObjBinding(GOODSINFOREQ.class, xmldata, "UTF-8");
		String goodsid = goodsinfo_req.getGOODSID();
		String sys_modifydate = goodsinfo_req.getSYSMODIFYDATE();
		String entrycompanyid = goodsinfo_req.getENTRYCOMPANYID();
		String ym = goodsinfo_req.getYM();		
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Goods> goodslist = (List<Goods>) goodsdao.getGoods_Lnjfsc(entrycompanyid, goodsid, sys_modifydate, Integer.valueOf(ym));
		GOODSINFORESP goodsinforesp = new GOODSINFORESP();
		List<GOODSINFO> goodsinfolist = goodsinforesp.getGOODSINFO();
		
		for(Goods g : goodslist) {
			GOODSINFO goodsinfo = new GOODSINFO();
			goodsinfo.setGoodsid(g.getGoodsid());
			goodsinfo.setGoodsname(g.getGoodsname());
			goodsinfo.setGoodstype(g.getGoodstype());
			goodsinfo.setGoodsunit(g.getGoodsunit());
			goodsinfo.setCurrencyname(g.getCurrencyname());
			goodsinfo.setEntryid(g.getEntryid());
			goodsinfo.setBarcode(g.getBarcode());
			goodsinfo.setFactoryname(g.getFactoryname());
			goodsinfo.setSysModifydate(g.getSys_modifydate());
			goodsinfo.setEntrycompanyid(g.getEntrycompanyid());
			goodsinfolist.add(goodsinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(GOODSINFORESP.class, goodsinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return retxml;
	}

	@Override
	public String getStock(String entryid, String xmldata) {
		STOCKINFOREQ stockinfo_req = JAXBUtil.unmarshToObjBinding(STOCKINFOREQ.class, xmldata, "UTF-8");
		String goodsid = stockinfo_req.getGOODSID();
		String storageid = stockinfo_req.getSTORAGEID();
		String placepoint = stockinfo_req.getPLACEPOINTID();
		String ym = stockinfo_req.getYM();		
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Stock> stocklist = (List<Stock>) stockdao.getStockByParam(goodsid, storageid, placepoint, Integer.valueOf(ym));
		STOCKINFORESP stockinforesp = new STOCKINFORESP();
		List<STOCKINFO> stockinfolist = stockinforesp.getSTOCKINFO();
		
		for(Stock s : stocklist) {
			STOCKINFO stockinfo = new STOCKINFO();
			stockinfo.setGoodsid(s.getGoodsid());
			stockinfo.setQty(s.getQty());
			stockinfolist.add(stockinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(STOCKINFORESP.class, stockinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}
	
	@Override
	public String getStock_Lnjfsc(String entryid, String xmldata) {
		STOCKINFOREQ stockinfo_req = JAXBUtil.unmarshToObjBinding(STOCKINFOREQ.class, xmldata, "UTF-8");
		String goodsid = stockinfo_req.getGOODSID();
		String entrycompanyid = stockinfo_req.getENTRYCOMPANYID();
		String ym = stockinfo_req.getYM();
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Stock> stocklist = (List<Stock>) stockdao.getStock_Lnjfsc(goodsid, entrycompanyid, Integer.valueOf(ym));
		STOCKINFORESP stockinforesp = new STOCKINFORESP();
		List<STOCKINFO> stockinfolist = stockinforesp.getSTOCKINFO();
		
		for(Stock s : stocklist) {
			STOCKINFO stockinfo = new STOCKINFO();
			stockinfo.setGoodsid(s.getGoodsid());
			stockinfo.setQty(s.getQty());
			stockinfolist.add(stockinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(STOCKINFORESP.class, stockinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}

	@Override
	public String getGoods_normal(String entryid, String xmldata) {
		GOODSINFONORMALREQ req = JAXBUtil.unmarshToObjBinding(GOODSINFONORMALREQ.class, xmldata, "UTF-8");
		String str = req.getGoodsid();
		entryid = req.getEntryid();
		String[] goodsids = str.split(",");
		String goodsid = "";
		if(goodsids.length==1){
			goodsid = goodsids[0];
		}
		String retxml = "";
		GOODSINFONORMALRESP resp = new GOODSINFONORMALRESP();
		List<Map<String,Object>> lists = goodsdao.getGoods_gdzcfy(entryid, goodsid, goodsids);
		if(lists.size()==0){
			resp.setReturncode("-1");
			resp.setReturnmsg("未查询到数据");
		}else{
			GoodsinfoNormal goods = new GoodsinfoNormal();
			resp.setGoodsinfoNormal(goods);
			List<GoodsItem> list = resp.getGoodsinfoNormal().getGoodsItem();
			for(Map<String,Object> map:lists){
				GoodsItem item = new GoodsItem();
				item.setGoodsid(StringUtil.doNullStr(map.get("GOODSID")));
				item.setOpcode(StringUtil.doNullStr(map.get("OPCODE")));
				item.setGoodsname(StringUtil.doNullStr(map.get("GOODSNAME")));
				item.setGoodsinvname(StringUtil.doNullStr(map.get("GOODSINVNAME")));
				item.setGoodstype(StringUtil.doNullStr(map.get("GOODSTYPE")));
				item.setGoodspinyin(StringUtil.doNullStr(map.get("GOODSPINYIN")));
				item.setCurrencyname(StringUtil.doNullStr(map.get("CURRENCYNAME")));
				item.setGoodsengname(StringUtil.doNullStr(map.get("GOODSENGNAME")));
				item.setGoodsshortname(StringUtil.doNullStr(map.get("GOODSSHORTNAME")));
				item.setGoodsunit(StringUtil.doNullStr(map.get("GOODSUNIT")));
				item.setProdarea(StringUtil.doNullStr(map.get("PRODAREA")));
				item.setFactoryid(StringUtil.doNullStr(map.get("FACTORYID")));
				item.setFactoryname(StringUtil.doNullStr(map.get("FACTORYNAME")));
				item.setStoragecondition(StringUtil.doNullStr(map.get("STORAGECONDITION")));
				item.setBarcode(StringUtil.doNullStr(map.get("BARCODE")));
				item.setApprovedocno(StringUtil.doNullStr(map.get("APPROVEDOCNO")));
				item.setRegistdocno(StringUtil.doNullStr(map.get("REGISTDOCNO")));
				item.setUsestatus(StringUtil.doNullStr(map.get("USESTATUS")));
				item.setPacksize(StringUtil.doNullStr(map.get("PACKSIZE")));
				list.add(item);
			}
			resp.setReturncode("0");
			resp.setReturnmsg("查询成功");
		}
		try {
			retxml = JAXBUtil.marshToXmlBinding(GOODSINFONORMALRESP.class, resp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}

}
