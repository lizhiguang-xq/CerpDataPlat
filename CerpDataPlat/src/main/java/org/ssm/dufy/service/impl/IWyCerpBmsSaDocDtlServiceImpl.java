package org.ssm.dufy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.applyorder.APPLYORDERRESP;
import org.ssm.cxf.struct.applyorder_wy.APPLYORDERWYREQ;
import org.ssm.cxf.struct.applyorder_wy.Orderdetail;
import org.ssm.dufy.dao.IWyCerpBmsSaDocDtlDao;
import org.ssm.dufy.entity.cerp.BmsSaConDoc;
import org.ssm.dufy.entity.cerp.BmsSaConDtl;
import org.ssm.dufy.service.IWyCerpBmsSaDocDtlService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("wycerpService")
public class IWyCerpBmsSaDocDtlServiceImpl implements IWyCerpBmsSaDocDtlService {


    @Autowired
    private IWyCerpBmsSaDocDtlDao wycerpDao;

    @Override
    @Transactional
    public String createApplyOrder(String entryid, String xmldata) {
        APPLYORDERRESP resp = new APPLYORDERRESP();

        APPLYORDERWYREQ order_req = JAXBUtil.unmarshToObjBinding(APPLYORDERWYREQ.class, xmldata, "UTF-8");
        entryid = order_req.getEntryid();
        String customid = order_req.getCustomid();
        String outersysid = order_req.getZxOutersysId();
//        String orderid = order_req.getZxOutersysOrderid();

        //验证订单号是否重复  根据订单号查询，此字段未加索引，暂时不判断
//        List<Map<String, Object>> applyorders = sxhscerpDao.checkapplayorder(entryid,customid,orderid);
//        if(applyorders.size()>0){
//            resp.setReturncode("-1");
//            resp.setReturnmsg("订单号已存在，请勿重复发送");
//            return resp.toXml();
//        }

        List<Map<String, Object>> outersyslist = wycerpDao.getentryoutersysid(entryid, outersysid);
        if(outersyslist.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未获取到外接系统ID");
            return resp.toXml();
        }

        String usestatus = "1"; //0:作废 1:临时 2:正式 3:完成
        String invtype = "2"; //2:增值税普通发票
        String settletypeid = "3"; //3:公司电汇
        String delivermethod = "3"; //3:市内配送

        //验证 外接客户ID 是否已经在ERP中有对应customId: 不存在直接返回错误信息。
        List<Map<String, Object>> customlist = wycerpDao.getcustominfo(entryid, order_req.getCustomid());
        if(customlist.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未获取到客户信息");
            return resp.toXml();
        }
        String customname = StringUtil.doNullStr(customlist.get(0).get("CUSTOMNAME"));
        String priceid = StringUtil.doNullStr(customlist.get(0).get("PRICEID"));
        String reqprintquflag = StringUtil.doNullStr(customlist.get(0).get("REQPRINTQUFLAG"));
        invtype = null==customlist.get(0).get("INVTYPE")?invtype:StringUtil.doNullStr(customlist.get(0).get("INVTYPE"));
        //获取委托人信息。
        List<Map<String, Object>> agentlist = wycerpDao.getagentinfo(entryid, order_req.getAgentid());
        if(agentlist.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未获取到委托人信息");
            return resp.toXml();
        }
        String agentid = StringUtil.doNullStr(agentlist.get(0).get("AGENTID"));
        String salerid = StringUtil.doNullStr(agentlist.get(0).get("SALERID"));
        String salesdeptid = StringUtil.doNullStr(agentlist.get(0).get("DEPTID"));
        String contactman = StringUtil.doNullStr(agentlist.get(0).get("CONTACTMAN"));
        //获取资信 根据 客户，委托人
        List<Map<String, Object>> credidlist = wycerpDao.getCredit(order_req.getCustomid(), order_req.getAgentid());
        if(credidlist.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未获取到资信");
            return resp.toXml();
        }
        String credit = StringUtil.doNullStr(credidlist.get(0).get("CURRENTMONEY"));
        String creditdays = StringUtil.doNullStr(credidlist.get(0).get("CURRENTDAYS"));
        //获取ERP送货地
        Long tranposid = wycerpDao.getTranPosId(entryid, customid, order_req.getZxOutersysStorageaddress());
        if(null==tranposid){
            List<Long>  tranposidlist =  wycerpDao.getChooseTranPosId(entryid, customid);
            if(tranposidlist.size()>0){
                tranposid = tranposidlist.get(0);
            }
        }

        BigDecimal total = new BigDecimal("0");
        List<BmsSaConDtl> dtllist = new ArrayList<>();
        for(Orderdetail detail : order_req.getOrderinfo().getOrderdetail()){
            List<Map<String, Object>> gooodslist = wycerpDao.getErpGoodsInfo(entryid, detail.getGoodsid());
            if(gooodslist.size()==0){
                break;
            }
            String goodsid = StringUtil.doNullStr(gooodslist.get(0).get("GOODSID"));
            String goodsdtlid = StringUtil.doNullStr(gooodslist.get(0).get("GOODSDTLID"));
            BmsSaConDtl dtl = new BmsSaConDtl();
            dtl.setGoodsid(Long.valueOf(goodsid));
            dtl.setGoodsdtlid(Long.valueOf(goodsdtlid));
            dtl.setPriceid(Long.valueOf(priceid));
            dtl.setGoodsqty(new BigDecimal(detail.getGoodsqty()));
            dtl.setTotalLine(detail.getTotalLine());
            dtl.setUnitprice(detail.getUnitprice());
            dtl.setDiscount(new BigDecimal("1.0000"));
            dtl.setZxOutersysOrderid(detail.getZxOutersysOrderid());
            dtl.setZxOutersysOrderindex(detail.getZxOutersysOrderindex());
            dtl.setZxOutersysGoodsid(goodsid);
            dtl.setZxOutersysCustomid(order_req.getCustomid());
            dtl.setZxOutersysMemo(detail.getZxOutersysMemo());
            dtl.setReqprintquflag(Long.valueOf(reqprintquflag));
            total = total.add(detail.getTotalLine());
            dtllist.add(dtl);
        }
        //判断是不是全部已经对码
        if(order_req.getOrderinfo().getOrderdetail().size()!=dtllist.size()){
            resp.setReturncode("-1");
            resp.setReturnmsg("商品编码错误");
            return resp.toXml();
        }

        Long seq = wycerpDao.getdocseqvalue();
        if(null!=seq){
            BmsSaConDoc doc = new BmsSaConDoc();
            doc.setConid(seq);
            doc.setCustomid(Long.valueOf(customid));
            doc.setCustomname(customname);
            doc.setSalerid(Long.valueOf(salerid));
            doc.setSalesdeptid(Long.valueOf(salesdeptid));
            doc.setAgentid(Long.valueOf(agentid));
            doc.setContactman(contactman);
            doc.setCredit(new BigDecimal(credit));
            doc.setCreditdays(Long.valueOf(creditdays));
            doc.setInvtype(Long.valueOf(invtype));
            doc.setSettletypeid(Long.valueOf(settletypeid));
            doc.setDelivermethod(Long.valueOf(delivermethod));
            doc.setInputmanid(Long.valueOf(order_req.getInputmanid()));
            doc.setEntryid(Long.valueOf(entryid));
            doc.setUsestatus(Long.valueOf(usestatus));
            doc.setTargetposid(tranposid);
            doc.setFmid(0L);
            doc.setComefrom(1L);
            doc.setApproveflag(0L);
            doc.setZxIsb2bsend("Y");
            doc.setContype(Long.valueOf(order_req.getContype()));
            doc.setZxOutersysOrderid(order_req.getZxOutersysOrderid());
            doc.setZxOutersysCredate(order_req.getZxOutersysCredate());
            doc.setZxOutersysStorageaddress(order_req.getZxOutersysStorageaddress());
            doc.setZxOutersysStoragename(order_req.getZxOutersysStoragename());
            doc.setZxStsetid(Long.valueOf(order_req.getZxStsetid()));
            doc.setMemo(order_req.getMemo());
            doc.setExchange(new BigDecimal("1"));
            doc.setDtlLines(dtllist.size());
            doc.setTotal(total);
            doc.setZxOutersysId(Long.valueOf(outersysid));
            doc.setZxReceiveaddr(order_req.getZxReceiveaddr());
            doc.setZxReceiveman(order_req.getZxReceiveman());
            doc.setZxReceivephone(order_req.getZxReceivephone());

            int docresult = wycerpDao.insertDoc(doc);
            if(docresult==1){
                for(BmsSaConDtl dtl : dtllist){
                    dtl.setConid(seq);
                    wycerpDao.insertDtl(dtl);
                }
                resp.setReturncode("0");
                resp.setReturnmsg("订单保存成功");
            }else{
                resp.setReturncode("-1");
                resp.setReturnmsg("主单序列插入失败");
            }
        }else{
            resp.setReturncode("-1");
            resp.setReturnmsg("主单序列获取失败");
        }
        return resp.toXml();
    }

}
