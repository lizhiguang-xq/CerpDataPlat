package org.ssm.dufy.service.impl;

import com.alibaba.fastjson.JSON;
import com.inca.np.auth.Userruninfo;
import com.inca.np.communicate.DBModel2Jdbc;
import com.inca.np.communicate.RecordTrunk;
import com.inca.np.communicate.ResultCommand;
import com.inca.np.gui.control.DBTableModel;
import com.inca.np.util.SelectHelper;
import com.inca.npbusi.tr.stin.receive.Receive_dbprocess;
import com.inca.npbusi.tr.stin.receive.Receive_detail;
import com.inca.npbusi.tr.stin.receive.Receive_master;
import com.inca.npbusi.tr.stin.receive.Receive_mde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssm.common.utility.DecimalUtils;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.applyorder.APPLYORDERRESP;
import org.ssm.cxf.struct.applyorder.APPLYORDERSXHSREQ;
import org.ssm.cxf.struct.applyorder.Orderdetail;
import org.ssm.cxf.struct.pjyj.pick.PICKNOREQ;
import org.ssm.cxf.struct.pjyj.pick.PICKNORESP;
import org.ssm.cxf.struct.pjyj.recv.Goods;
import org.ssm.cxf.struct.pjyj.recv.RecInfoJsonBean;
import org.ssm.cxf.struct.pjyj.recv.ReturnMsg;
import org.ssm.cxf.struct.salesinfo.*;
import org.ssm.dufy.dao.ISxhsCerpBmsSaDocDtlDao;
import org.ssm.dufy.entity.cerp.BmsSaConDoc;
import org.ssm.dufy.entity.cerp.BmsSaConDtl;
import org.ssm.dufy.exception.BopException;
import org.ssm.dufy.service.ISxhsCerpBmsSaDocDtlService;

import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@Service("pjcerpService")
public class ISxhsCerpBmsSaDocDtlServiceImpl implements ISxhsCerpBmsSaDocDtlService {

    @Autowired
    private ISxhsCerpBmsSaDocDtlDao sxhscerpDao;

    @Autowired
    private DataSource cerpzsdataSource;

    @Override
    @Transactional
    public String createApplyOrder(String entryid, String xmldata) {
        APPLYORDERRESP resp = new APPLYORDERRESP();

        APPLYORDERSXHSREQ order_req = JAXBUtil.unmarshToObjBinding(APPLYORDERSXHSREQ.class, xmldata, "UTF-8");
        entryid = order_req.getEntryid();
        String customid = order_req.getCustomid();
//        String orderid = order_req.getZxOutersysOrderid();

        //验证订单号是否重复  根据订单号查询，此字段未加索引，暂时不判断
//        List<Map<String, Object>> applyorders = sxhscerpDao.checkapplayorder(entryid,customid,orderid);
//        if(applyorders.size()>0){
//            resp.setReturncode("-1");
//            resp.setReturnmsg("订单号已存在，请勿重复发送");
//            return resp.toXml();
//        }

        String usestatus = "1"; //0:作废 1:临时 2:正式 3:完成
        String invtype = "2"; //2:增值税普通发票
        String settletypeid = "3"; //3:公司电汇
        String delivermethod = "3"; //3:市内配送

        //验证 外接客户ID 是否已经在ERP中有对应customId: 不存在直接返回错误信息。
        List<Map<String, Object>> customlist = sxhscerpDao.getcustominfo(entryid, order_req.getCustomid());
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
        List<Map<String, Object>> agentlist = sxhscerpDao.getagentinfo(entryid, order_req.getAgentid());
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
        List<Map<String, Object>> credidlist = sxhscerpDao.getCredit(order_req.getCustomid(), order_req.getAgentid());
        if(credidlist.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未获取到资信");
            return resp.toXml();
        }
        String credit = StringUtil.doNullStr(credidlist.get(0).get("CURRENTMONEY"));
        String creditdays = StringUtil.doNullStr(credidlist.get(0).get("CURRENTDAYS"));
        //获取ERP送货地
        Long tranposid = sxhscerpDao.getTranPosId(entryid, customid, order_req.getZxOutersysStorageaddress());
        if(null==tranposid){
            List<Long>  tranposidlist =  sxhscerpDao.getChooseTranPosId(entryid, customid);
            if(tranposidlist.size()>0){
                tranposid = tranposidlist.get(0);
            }
        }

        BigDecimal total = new BigDecimal("0");
        List<BmsSaConDtl> dtllist = new ArrayList<>();
        for(Orderdetail detail : order_req.getOrderinfo().getOrderdetail()){
            List<Map<String, Object>> gooodslist = sxhscerpDao.getErpGoodsInfo(entryid, detail.getGoodsid());
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

        Long seq = sxhscerpDao.getdocseqvalue();
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

            int docresult = sxhscerpDao.insertDoc(doc);
            if(docresult==1){
                for(BmsSaConDtl dtl : dtllist){
//                    Long dtlseq = sxhscerpDao.getdtlseqvalue();
                    dtl.setConid(seq);
//                    dtl.setCondtlid(dtlseq);
                    sxhscerpDao.insertDtl(dtl);
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

    @Override
    public String getSaInvno_Sxhs(String entryid, String xmldata) {
        SALESINFORESP resp = new SALESINFORESP();
        SALESINFOREQ req = JAXBUtil.unmarshToObjBinding(SALESINFOREQ.class, xmldata, "UTF-8");
        entryid = req.getEntryid();
        String salesid = req.getSalesid();
        List<Map<String, Object>> lists = sxhscerpDao.select(entryid, salesid);
        if(lists.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("没有数据");
        }else{
            resp.setReturncode("0");
            resp.setReturnmsg("成功");
            Salesinfo sales = new Salesinfo();
            Details details = new Details();
            resp.setSalesinfo(sales);
            sales.setDetails(details);
            List<Detail> detaillist = details.getDetail();

            sales.setSalesid(StringUtil.doNullStr(lists.get(0).get("SALESID")));
            sales.setConfirmdate(StringUtil.doNullStr(lists.get(0).get("CONFIRMDATE")));
            sales.setCustomid(StringUtil.doNullStr(lists.get(0).get("CUSTOMID")));
            sales.setCustomname(StringUtil.doNullStr(lists.get(0).get("CUSTOMNAME")));
            sales.setAgentid(StringUtil.doNullStr(lists.get(0).get("AGENTID")));
            sales.setTotal(StringUtil.doNullStr(lists.get(0).get("TOTAL")));
            sales.setDtllines(StringUtil.doNullStr(lists.get(0).get("DTLLINES")));
            sales.setInputmanname(StringUtil.doNullStr(lists.get(0).get("INPUTMANNAME")));
            sales.setConfirmanname(StringUtil.doNullStr(lists.get(0).get("CONFIRMANNAME")));
            for(Map<String, Object> map: lists){
                Detail detail = new Detail();
                detail.setSalesid(StringUtil.doNullStr(map.get("SALESID")));
                detail.setSalesdtlid(StringUtil.doNullStr(map.get("SALESDTLID")));
                detail.setStiodate(StringUtil.doNullStr(map.get("STIODATE")));
                detail.setGoodsid(StringUtil.doNullStr(map.get("GOODSID")));
                detail.setGoodsname(StringUtil.doNullStr(map.get("GOODSNAME")));
                detail.setCurrencyname(StringUtil.doNullStr(map.get("CURRENCYNAME")));
                detail.setGoodsqty(StringUtil.doNullStr(map.get("GOODSQTY")));
                detail.setGoodsunit(StringUtil.doNullStr(map.get("GOODSUNIT")));
                detail.setFactoryname(StringUtil.doNullStr(map.get("FACTORYNAME")));
                detail.setLotno(StringUtil.doNullStr(map.get("LOTNO")));
                detail.setGoodstype(StringUtil.doNullStr(map.get("GOODSTYPE")));
                detail.setUnitprice(StringUtil.doNullStr(map.get("UNITPRICE")));
                detail.setAmount(StringUtil.doNullStr(map.get("AMOUNT")));
                detail.setProddate(StringUtil.doNullStr(map.get("PRODDATE")));
                detail.setInvaliddate(StringUtil.doNullStr(map.get("INVALIDDATE")));
                detail.setZxOutersysOrderid(StringUtil.doNullStr(map.get("ZX_OUTERSYS_ORDERID")));
                detail.setZxOutersysOrderindex(StringUtil.doNullStr(map.get("ZX_OUTERSYS_ORDERINDEX")));
                detail.setStorageid(StringUtil.doNullStr(map.get("STORAGEID")));
                detail.setInvcode(StringUtil.doNullStr(map.get("INVCODE")));
                detail.setInvno(StringUtil.doNullStr(map.get("INVNO")));
                detaillist.add(detail);
            }
        }

        String retxml= "";
        try {
            retxml = JAXBUtil.marshToXmlBinding(SALESINFORESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    @Override
    public String getPickInfo_pjyj(String entryid, String xmldata) {
        PICKNORESP resp = new PICKNORESP();
        PICKNOREQ req = JAXBUtil.unmarshToObjBinding(PICKNOREQ.class, xmldata, "UTF-8");
        entryid = req.getENTRYID();
        String pickdocid = req.getORDERNO();
        List<Map<String, Object>> lists = sxhscerpDao.getPickInfo_pjyj(pickdocid);
        if(lists.size()==0){
            resp.setRETCODE("0");
            resp.setRETREASON("没有数据");
        }else{
            resp.setRETCODE("1");
            resp.setRETREASON("成功");
            resp.setCUSTCODE(StringUtil.doNullStr(lists.get(0).get("PLACEPOINTID")));
            resp.setCUSTOMERNAME(StringUtil.doNullStr(lists.get(0).get("PLACEPOINTNAME")));
            resp.setTYPEINOUT("2");
            resp.setUSERNO(StringUtil.doNullStr(lists.get(0).get("PICKMAN")));
        }

        String retxml= "";
        try {
            retxml = JAXBUtil.marshToXmlBinding(PICKNORESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    @Override
    public String updateRecInfo_pjyj(String entryid, String jsonData) {
        Connection con = null;
        ReturnMsg returnMsg = new ReturnMsg();
        RecInfoJsonBean recInfoJsonBean = JSON.parseObject(jsonData,RecInfoJsonBean.class);
        String reid = recInfoJsonBean.getOrderno();
        Collections.sort(recInfoJsonBean.getGoods());
        try {
            con = cerpzsdataSource.getConnection();
            con.setAutoCommit(false);

            String sql = "select * from bms_st_re_doc_v where reid = ?";
            SelectHelper sh = new SelectHelper(sql);
            sh.bindParam(reid);
            DBTableModel tmpMasterModel = sh.executeSelect(con);

            if(tmpMasterModel==null || tmpMasterModel.getRowCount()<1) {
                returnMsg.setRet_code("0");
                returnMsg.setRet_reason("收货总单:"+reid+" 不存在");
                return JSON.toJSONString(returnMsg);
            }

            sql = "select * from bms_st_re_dtl_v where reid = ? order by redtlid";
            sh = new SelectHelper(sql);
            sh.bindParam(reid);
            DBTableModel tmpDetailModel = sh.executeSelect(con);
            tmpDetailModel.createIndex(new String[] {"redtlid"});

            Receive_mde mde = new Receive_mde(null, "");
            Receive_master master = new Receive_master(null, mde);
            Receive_detail detail = new Receive_detail(null, mde);
            DBTableModel mastermodel = master.getDBtableModel();
            mastermodel.appendRow();
            mastermodel.bindDbmodel(0, tmpMasterModel, 0);
            mastermodel.setdbStatus(0, RecordTrunk.DBSTATUS_MODIFIED);

            String tmppkid = mastermodel.getTmppkid(0);

            DBTableModel recDtlmodel = detail.getDBtableModel();

            String tmpredtlid = "0";
            String redtlid = "";
            int[] frs = null;
            String rectotalqty = "";
            String sutotalqty = "";
            //循环常青发过来的收货结果list(已按照收货细单号由小到大，数量由大到小排序)
            for(Goods goods : recInfoJsonBean.getGoods()) {
                redtlid = goods.getRowid();
                //取到新的收货细单（和上一条不一样）
                if(!tmpredtlid.equals(redtlid)) {
                    tmpredtlid = redtlid;
                    rectotalqty = goods.getQty();
                    //在CERP原结果集里找
                    frs = tmpDetailModel.searchByindex(new String[] {redtlid});
                    //没找到，不理，继续循环
                    if (frs == null || frs.length == 0) {
                        continue;
                    } else {//找到了
                        //包装大小
                        String packsize = tmpDetailModel.getItemValue(frs[0], "packsize");
                        sutotalqty = tmpDetailModel.getItemValue(frs[0], "SUCONGOODSQTY");
                        if(DecimalUtils.comparaDecimal(rectotalqty,sutotalqty)>0) {
                            returnMsg.setRet_code("0");
                            returnMsg.setRet_reason("货品:"+goods.getGoodscode()+" 收货数量:"+rectotalqty+" 大于采购数量:"+sutotalqty);
                            return JSON.toJSONString(returnMsg);
                        }
                        //保存结果集增加一行
                        int i = recDtlmodel.getRowCount();
                        recDtlmodel.appendRow();
                        //将原记录复制
                        recDtlmodel.bindDbmodel(i, tmpDetailModel, frs[0]);
                        //改数量(根据常青回传的数量)
                        recDtlmodel.setItemValue(i, "scatterqty", goods.getQty());
                        recDtlmodel.setItemValue(i, "goodsqty", goods.getQty());
                        recDtlmodel.setItemValue(i, "RECIEVEQTY", goods.getQty());
                        recDtlmodel.setItemValue(i, "PACKQTY", DecimalUtils.divide(goods.getQty(), packsize, 6));
                        recDtlmodel.setItemValue(i, "RECIEVEPACKQTY", DecimalUtils.divide(goods.getQty(), packsize, 6));
                        sql = "select lotid from bms_lot_def where lotno = ? and goodsid = ?";
                        sh = new SelectHelper(sql);
                        sh.bindParam(goods.getBatchno());
                        sh.bindParam(goods.getGoodscode());
                        DBTableModel lotModel = sh.executeSelect(con);
                        if(lotModel!=null && lotModel.getRowCount()>0) {
                            recDtlmodel.setItemValue(i, "lotid", lotModel.getItemValue(0, "lotid"));
                        } else {
                            recDtlmodel.setItemValue(i,"lotno",goods.getBatchno());
                            recDtlmodel.setItemValue(i,"proddate",goods.getProducedate());
                            recDtlmodel.setItemValue(i,"invaliddate",goods.getValidate());
                        }
                        recDtlmodel.setdbStatus(i, RecordTrunk.DBSTATUS_MODIFIED);

                        recDtlmodel.getRecordThunk(i).setRelatevalue(tmppkid);
                    }

                } else {//取到和上一条一样的收货细单

                    rectotalqty = DecimalUtils.add(rectotalqty,goods.getQty(),0);
                    if(DecimalUtils.comparaDecimal(rectotalqty,sutotalqty)>0) {
                        returnMsg.setRet_code("0");
                        returnMsg.setRet_reason("货品:"+goods.getGoodscode()+" 收货数量:"+rectotalqty+" 大于采购数量:"+sutotalqty);
                        return JSON.toJSONString(returnMsg);
                    }
                    if (frs == null || frs.length == 0) {
                        continue;
                    } else {//找到了
                        //包装大小
                        String packsize = tmpDetailModel.getItemValue(frs[0], "packsize");
                        //保存结果集增加一行
                        int i = recDtlmodel.getRowCount();
                        recDtlmodel.appendRow();
                        //将原记录复制
                        recDtlmodel.bindDbmodel(i, tmpDetailModel, frs[0]);
                        //改数量(根据常青回传的数量)
                        String newredtlid = DBModel2Jdbc.getSeqvalue(con, "bms_st_re_dtl_seq");
                        recDtlmodel.setItemValue(i, "redtlid", newredtlid);
                        recDtlmodel.setItemValue(i, "scatterqty", goods.getQty());
                        recDtlmodel.setItemValue(i, "goodsqty", goods.getQty());
                        recDtlmodel.setItemValue(i, "RECIEVEQTY", goods.getQty());
                        recDtlmodel.setItemValue(i, "PACKQTY", DecimalUtils.divide(goods.getQty(), packsize, 6));
                        recDtlmodel.setItemValue(i, "RECIEVEPACKQTY", DecimalUtils.divide(goods.getQty(), packsize, 6));
                        sql = "select lotid from bms_lot_def where lotno = ? and goodsid = ?";
                        sh = new SelectHelper(sql);
                        sh.bindParam(goods.getBatchno());
                        sh.bindParam(goods.getGoodscode());
                        DBTableModel lotModel = sh.executeSelect(con);
                        if(lotModel!=null && lotModel.getRowCount()>0) {
                            recDtlmodel.setItemValue(i, "lotid", lotModel.getItemValue(0, "lotid"));
                        } else {
                            recDtlmodel.setItemValue(i,"lotno",goods.getBatchno());
                            recDtlmodel.setItemValue(i,"proddate",goods.getProducedate());
                            recDtlmodel.setItemValue(i,"invaliddate",goods.getValidate());
                        }
                        recDtlmodel.setdbStatus(i, RecordTrunk.DBSTATUS_NEW);
                        recDtlmodel.getRecordThunk(i).setRelatevalue(tmppkid);
                    }
                }
            }

            Receive_dbprocess process = new Receive_dbprocess();
            Vector<ResultCommand> results = new Vector<ResultCommand>();

            Userruninfo userRunInfo = new Userruninfo();
            userRunInfo.setUserid("0");
            userRunInfo.setEntryid("2");

            process.doSave(con, userRunInfo, mastermodel, recDtlmodel, results,
                    false);
            ResultCommand mresult = results.elementAt(0);
            if (mresult.getResult() != 0) {
                returnMsg.setRet_code("0");
                returnMsg.setRet_reason("生成总单失败");
                return JSON.toJSONString(returnMsg);
            }

            ResultCommand dresult = results.elementAt(1);
            if (dresult.getResult() != 0) {
                returnMsg.setRet_code("0");
                returnMsg.setRet_reason("生成细单失败");
                return JSON.toJSONString(returnMsg);
            }
            con.commit();
            returnMsg.setRet_code("1");
            returnMsg.setRet_reason("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            //回传操作结果
            returnMsg.setRet_code("0");
            returnMsg.setRet_reason(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return JSON.toJSONString(returnMsg);
    }
}
