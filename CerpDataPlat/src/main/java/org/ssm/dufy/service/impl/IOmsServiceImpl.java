package org.ssm.dufy.service.impl;

import com.inca.np.gui.control.DBTableModel;
import com.inca.np.util.*;
import com.inca.pubsrv.NpbusiDBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.oms.order.OMSAPPLYORDERREQ;
import org.ssm.cxf.struct.oms.order.PRODUCT;
import org.ssm.cxf.struct.wms.cancel.ARRAYOFTCKKPDDEL;
import org.ssm.cxf.struct.wms.cancel.DANJMX;
import org.ssm.cxf.struct.wms.cancel.MINGXI;
import org.ssm.cxf.struct.wms.cancel.TCKKPDDEL;
import org.ssm.cxf.struct.wms.edit.ARRAYOFTCKKPDMOD;
import org.ssm.cxf.struct.wms.edit.TCKKPDMOD;
import org.ssm.cxf.struct.wms.retdata.DATA;
import org.ssm.cxf.struct.wms.retdata.RETDATA;
import org.ssm.dufy.client.orderreturninfo.*;
import org.ssm.dufy.client.wms.cancel.WmsCkdel;
import org.ssm.dufy.client.wms.cancel.WmsCkdelSoap;
import org.ssm.dufy.client.wms.edit.*;
import org.ssm.dufy.exception.BopException;
import org.ssm.dufy.service.IOmsService;

import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service("omsService")
public class IOmsServiceImpl implements IOmsService {

    @Autowired
    private DataSource cerpzsdataSource;
    private static Logger log = LoggerFactory.getLogger("loger");


    @Override
    public String applyOrder(String entryid, String xmldata) {
        String msg = "";
        ORDERRETURNINFODATA orderreturninfodata = new ORDERRETURNINFODATA();


        OMSAPPLYORDERREQ req = JAXBUtil.unmarshToObjBinding(OMSAPPLYORDERREQ.class, xmldata, "UTF-8");
        String operationtype = req.getOPERATIONTYPE();
        Connection con = null;
        SelectHelper sh = null;
        InsertHelper ih = null;
        UpdateHelper uh = null;
        DeleteHelper dh = null;
        String sql = "";

        orderreturninfodata.setOMSORDERID(req.getZXORDERNO());
        orderreturninfodata.setOPERATION(operationtype);
        try {
            con = cerpzsdataSource.getConnection();
            con.setAutoCommit(false);
            if(StringUtil.doNullInt(operationtype)==1){
                //新增
                String docid = CreateSaDocDtl(con, sh, ih, uh, sql, req);
                orderreturninfodata.setECCORDERID(docid);
            }else if(StringUtil.doNullInt(operationtype)==3){
                //修改
                String docid = EditSaDocDtl(con, sh, uh, sql, req);
                orderreturninfodata.setECCORDERID(docid);
            }else if(StringUtil.doNullInt(operationtype)==2){
                //取消
                String docid = CancelSaDocDtl(con, sh, uh, dh, sql, req);
                orderreturninfodata.setECCORDERID(docid);
            }else{
                throw new BopException("-1", "不能识别此操作类型！");
            }
            con.commit();
            //回传操作结果
            orderreturninfodata.setRESULTCODE("S");
            orderreturninfodata.setRESULTMESSAGE("操作成功");
            msg = "ok";
        } catch (BopException e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            //回传操作结果
            orderreturninfodata.setRESULTCODE("E");
            orderreturninfodata.setRESULTMESSAGE(e.getErrMsg());
        } catch (Exception e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            //回传操作结果
            orderreturninfodata.setRESULTCODE("E");
            orderreturninfodata.setRESULTMESSAGE("操作失败");
        }finally {
            CreateLog(con, ih, orderreturninfodata);//将回传记录写入回传记录表
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return msg;
    }
    private void CreateLog(Connection con, InsertHelper ih, ORDERRETURNINFODATA orderreturninfodata){
        try {
            ih = new InsertHelper("gresa_sa_ds_doc_log");
            String logid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_ds_doc_log_seq");
            ih.bindParam("logid", logid);//
            ih.bindParam("omsorderid", orderreturninfodata.getOMSORDERID());//
            ih.bindParam("operation",orderreturninfodata.getOPERATION());//
            ih.bindParam("resultcode",orderreturninfodata.getRESULTCODE());//
            ih.bindParam("resultmessage",orderreturninfodata.getRESULTMESSAGE());//
            ih.bindParam("eccorderid",orderreturninfodata.getECCORDERID());//
            ih.bindParam("orderreturnid",orderreturninfodata.getORDERRETURNID());//
            ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));//创建时间
            ih.executeInsert(con);
            con.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private String CreateSaDocDtl(Connection con, SelectHelper sh, InsertHelper ih, UpdateHelper uh, String sql, OMSAPPLYORDERREQ req) throws Exception{
        sql = "select * from gresa_sa_ds_doc where zx_orderno = ?";
        sh = new SelectHelper(sql);
        sh.bindParam(req.getZXORDERNO());
        DBTableModel docmodel = sh.executeSelect(con, 0, 1);
        String docid = "";
        if(null!=docmodel&&docmodel.getRowCount()>0){
            docid = docmodel.getItemValue(0, "rsaid");
        }else{
            List<PRODUCT> list = req.getPRODUCTS().getPRODUCT();
            if(list.size()==0){
                throw new BopException("-2", "未查询到明细信息！");
            }
            docid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_doc_ds_seq");//零售订单总单ID
            ih = new InsertHelper("gresa_sa_ds_doc");
            ih.bindParam("rsaid", docid);
            ih.bindParam("comefrom", req.getCOMEFORM());
            ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));//创建时间
            ih.bindDateParam("oms_credate", TimeStampToDate(req.getCREDATE()));//创建时间
            ih.bindParam("placepointid", req.getPLACEPOINTID());//门店ID
            ih.bindParam("totalmoney", req.getTOTALMONEY());//订单总金额
            String THREE_PART_FAVOUR = req.getTHREEPARTFAVOUR();
            ih.bindParam("THREE_PART_FAVOUR", THREE_PART_FAVOUR);
            ih.bindParam("receivemoney", req.getRECEIVALMONEY());//应收
            ih.bindParam("realmoney", req.getREALMONEY());//实收
            ih.bindParam("ZX_ORDERNO", req.getZXORDERNO());
            ih.bindParam("ECC_SHIPTO_REGION", req.getECCSHIPTOREGION());
            ih.bindParam("ECC_SHIPTO_CITY", req.getECCSHIPTOCITY());
            ih.bindParam("ECC_SHIPTO_DISTRICT", req.getECCSHIPTODISTRICT());
            ih.bindParam("ADDRESS", req.getADDRESS());
            ih.bindParam("SHOUH_PHONE", req.getSHOUHPHONE());
            ih.bindParam("SHOUH_STAFF", req.getSHOUHSTAFF());
            ih.bindParam("POSTCODE", req.getPOSTCODE());
            ih.bindParam("SHUIP_TYPE", req.getSHUIPTYPE());
            ih.bindParam("INVOICE_TITLE", req.getINVOICETITLE());
            ih.bindParam("DANJ_NO_WSDD", req.getDANJNOWSDD());
            ih.bindParam("BILL_NUMBER", req.getBILLNUMBER());
            ih.bindParam("SUB_ORDER_NUMBER", req.getSUBORDERNUMBER());
            String invno = req.getINVOICENUMBER();
            if(null!=req.getECC_SALES_ORG()&&req.getECC_SALES_ORG().equals("1991")){
                if(null!=invno&&!invno.equals("")){
                    sql = "select t.rsaid from gresa_sa_ds_doc t where t.invoice_number='"+invno+"' and t.usestatus!=3";
                    sh = new SelectHelper(sql);
                    DBTableModel chmodel = sh.executeSelect(con, 0, 1);
                    if(null!=chmodel&&chmodel.getRowCount()>0){
                        throw new BopException("-3", "发票号码重复！");
                    }
                }else{
                    throw new BopException("-3", "发票号不能为空！");
                }
            }
            ih.bindParam("INVOICE_NUMBER", invno);
            ih.bindParam("INVOICE_CONTENT", req.getINVOICECONTENT());
            ih.bindParam("SHAD_CITY", req.getSHADCITY());
            ih.bindParam("SHAD_CITY_DISTRICT", req.getSHADCITYDISTRICT());
            ih.bindParam("POSTAL_ZONE", req.getPOSTALZONE());
            ih.bindParam("SHAD_RESIDENTIAL", req.getSHADRESIDENTIAL());
            ih.bindParam("SHAD_RESIDENTIAL_NUMBER", req.getSHADRESIDENTIALNUMBER());
            ih.bindParam("SOCIAL_SECURITY_NUMBER", req.getSOCIALSECURITYNUMBER());
            ih.bindParam("SEX", req.getSEX());
            ih.bindParam("AGE", req.getAGE());
            ih.bindParam("PAYMENT_INFO_TYPE", req.getPAYMENTINFOTYPE());
            ih.bindParam("DELIVERY_SERVICE", req.getDELIVERYSERVICE());
            ih.bindParam("DRUG_HISTORY", req.getDRUGHISTORY());
            ih.bindParam("HAVE_ALLERGY", req.getHAVEALLERGY());
            ih.bindParam("DRUG_EFFECT", req.getDRUGEFFECT());
            ih.bindParam("PAYMENT", req.getPAYMENT());
            ih.bindParam("PHARMACISTS_OPINIONS", req.getPHARMACISTSOPINIONS());
            ih.bindParam("IS_NEED_SECOND_REIMURSEMENT", req.getISNEEDSECONDREIMURSEMENT());
            ih.bindParam("IS_PRESCRIBE", req.getISPRESCRIBE());
            ih.bindParam("DELIVERY_DATE", req.getDELIVERYDATE());
            ih.bindParam("SETTLEMENT_DATE", req.getSETTLEMENTDATE());
            ih.bindParam("BILLS_TYPE", req.getBILLSTYPE());
            ih.bindParam("VENDORMEMO", req.getVENDORMEMO());
            ih.bindParam("BUYERMEMO", req.getBUYERMEMO());
            ih.bindParam("DTL_LINES", StringUtil.doNullStr(req.getPRODUCTS().getPRODUCT().size()));
            ih.bindParam("ISMANPLACEQTY", req.getMANUALALLOC());
            ih.bindParam("PRESCRIPTION_HOSPITAL", req.getPRESCRIPTION_HOSPITAL());
            ih.bindParam("CARRIER_ID", req.getCARRIERID());
            ih.bindParam("CARRIER_NAME", req.getCARRIERNAME());
            String yunfei = req.getZYUNFEI();
            ih.bindParam("ZYUNFEI", yunfei);
            ih.bindParam("ECC_SALES_ORG", req.getECC_SALES_ORG());
            ih.bindParam("DISCOUNT_FEE", req.getDISCOUNT_FEE());
            String codfee = req.getCODFEE();
            ih.bindParam("CODFEE", codfee);

            String discount_fee_total = req.getDISCOUNT_FEE();//订单总折扣
            String discount_fee = req.getDISCOUNT_FEE();//整单折扣
            String total = "";
            String average_discount_total = "";//已分配折扣金额
            String average_yunfei_total = "";//已分运费金额
            String average_codfee_total = "";//已分服务费金额
            for(int i=0;i<list.size();i++){
                PRODUCT pro = list.get(i);
                discount_fee_total = DecimalHelper.add(discount_fee_total, pro.getDISCOUNT_FEE(),4);
                String line_total = DecimalHelper.sub(pro.getTOTALLINE(), pro.getDISCOUNT_FEE(), 4);
                total = DecimalHelper.add(total, line_total,4);
            }
            ih.bindParam("DISCOUNT_FEE_TOTAL", discount_fee_total);

            boolean bool = false;
            if ("10812021".equals(req.getCOMEFORM())) {
                for(int i = 0; i < list.size(); i++) {
                    PRODUCT pro = list.get(i);
                    sql = "select * from gresa_sa_ds_doc_split_rule where goodsid = ? and placepointid=? and comefromid=? ";
                    sh = new SelectHelper(sql);
                    sh.bindParam(pro.getGOODSID());
                    sh.bindParam(req.getPLACEPOINTID());
                    sh.bindParam(req.getCOMEFORM());
                    DBTableModel dtlsmodel = sh.executeSelect(con, 0, 1);
                    if (null != dtlsmodel && dtlsmodel.getRowCount() > 0) {
                        bool = true;
                        break;
                    }
                }
            }
            if ("1".equals(req.getSPLITTYPE())) {
                bool = true;
            }
            if (bool) {
                ih.bindParam("USESTATUS", "4");
                ih.bindParam("ISSEND_WMS", "0");
            } else {
                ih.bindParam("USESTATUS", "1");
                if (req.getPLACEPOINTID().equals("95")) {
                    ih.bindParam("ISSEND_WMS", "0");
                } else {
                    ih.bindParam("ISSEND_WMS", "1");
                }
            }
            ih.bindParam("SPLITTYPE", "0");
            ih.bindParam("SENDSTATE_WMS", "0");
            ih.bindParam("PLACEQTYSTATE", "0");
            ih.bindParam("ZX_ISBACK", "0");
            ih.bindParam("ISCREATE", "0");
            ih.bindParam("ERRORTIME", "0");
            ih.bindParam("ERRORFLAG", "0");
            ih.bindParam("ordertype", "0");
            ih.executeInsert(con);
            for(int i=0;i<list.size();i++){
                PRODUCT pro = list.get(i);
                String rsadtlid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_dtl_ds_seq");
                ih = new InsertHelper("gresa_sa_ds_dtl");
                ih.bindParam("rsadtlid", rsadtlid);//细单ID
                ih.bindParam("rsaid",docid);//总单ID
                ih.bindParam("goodsid", pro.getGOODSID());//货品ID
                ih.bindParam("goodsqty", pro.getGOODSQTY());//数量
                ih.bindParam("total_line", pro.getTOTALLINE());//应收金额
                ih.bindParam("UNITPRICE", pro.getUNITPRICE());
                ih.bindParam("LOT_REQUEST", pro.getLOTREQUEST());
                ih.bindParam("PRESCRIPTION_DOSAGE", pro.getPRESCRIPTIONDOSAGE());
                ih.bindParam("PRESCRIPTION_USAGE", pro.getPRESCRIPTIONUSAGE());
                ih.bindParam("DAY_OF_MEDICATION", pro.getDAYOFMEDICATION());
                ih.bindParam("ACTUAL_DAY_OF_MEDICATION", pro.getACTUALDAYOFMEDICATION());
                ih.bindParam("DISCOUNT_FEE", pro.getDISCOUNT_FEE());
                ih.bindParam("USESTATUS", "0");
                String average_discount = "";
                String average_yunfei = "";
                String average_codfee = "";
                if(DecimalHelper.comparaDecimal(discount_fee, "0")==1){
                    String line_t = DecimalHelper.sub(pro.getTOTALLINE(), pro.getDISCOUNT_FEE(), 4);
                    if(DecimalHelper.comparaDecimal(line_t, "0")==1){
                        String rate = DecimalHelper.divide(line_t, total, 6);
                        average_discount = DecimalHelper.multi(discount_fee, rate, 2);
                        ih.bindParam("average_discount", average_discount);
                        average_discount_total = DecimalHelper.add(average_discount_total, average_discount, 2);
                    }
                }
                if(DecimalHelper.comparaDecimal(yunfei, "0")==1){
                    String line_t = DecimalHelper.sub(pro.getTOTALLINE(), pro.getDISCOUNT_FEE(), 4);
                    if(DecimalHelper.comparaDecimal(line_t, "0")==1){
                        String rate = DecimalHelper.divide(line_t, total, 6);
                        average_yunfei = DecimalHelper.multi(yunfei, rate, 2);
                        ih.bindParam("average_yunfei", average_yunfei);
                        average_yunfei_total = DecimalHelper.add(average_yunfei_total, average_yunfei, 2);
                    }
                }
                if(DecimalHelper.comparaDecimal(codfee, "0")==1){
                    String line_t = DecimalHelper.sub(pro.getTOTALLINE(), pro.getDISCOUNT_FEE(), 4);
                    if(DecimalHelper.comparaDecimal(line_t, "0")==1){
                        String rate = DecimalHelper.divide(line_t, total, 6);
                        average_codfee = DecimalHelper.multi(codfee, rate, 2);
                        ih.bindParam("average_codfee", average_codfee);
                        average_codfee_total = DecimalHelper.add(average_codfee_total, average_codfee, 2);
                    }
                }
                String r1 = DecimalHelper.sub(pro.getTOTALLINE(), pro.getDISCOUNT_FEE(), 2);// r1 = 细单总金额 - 细单折扣
                String r2 = DecimalHelper.sub(r1, average_discount, 2);// r2 = r1 - 细单折扣
                String r3 = DecimalHelper.add(r2, average_yunfei, 2);// r3 = r2 + 运费平摊金额
                String realmoney = DecimalHelper.add(r3, average_codfee, 2);// realmoney = r3 + 服务费平摊金额

                ih.bindParam("realmoney", realmoney);//实收金额
                String useprice = DecimalHelper.divide(realmoney, pro.getGOODSQTY(), 10);
                ih.bindParam("useprice", useprice);//实际单价
                ih.executeInsert(con);
            }
            String yue = DecimalHelper.sub(discount_fee, average_discount_total, 2);
            int compara = DecimalHelper.comparaDecimal(yue, "0");
            if(compara!=0){
                sql = "select * from gresa_sa_ds_dtl where rsaid = ?";
                sh = new SelectHelper(sql);
                sh.bindParam(docid);
                DBTableModel dtlsmodel = sh.executeSelect(con, 0, 9999);
                if(null!=dtlsmodel&&dtlsmodel.getRowCount()>0){
                    for(int i=0;i<dtlsmodel.getRowCount();i++){
                        if(DecimalHelper.comparaDecimal(dtlsmodel.getItemValue(i, "average_discount"), "0")!=0){
                            String tline = DecimalHelper.sub(DecimalHelper.sub(dtlsmodel.getItemValue(i, "total_line"), dtlsmodel.getItemValue(i, "discount_fee"), 2), dtlsmodel.getItemValue(i, "average_discount"), 2);
                            if(DecimalHelper.comparaDecimal(tline, yue)==1){
                                String  average_discount = DecimalHelper.add(dtlsmodel.getItemValue(i, "average_discount"), yue, 2);
                                String  realmoney = DecimalHelper.sub(dtlsmodel.getItemValue(i, "realmoney"), yue, 2);
                                String useprice = DecimalHelper.divide(realmoney, dtlsmodel.getItemValue(i, "goodsqty"), 10);
                                sql=" update gresa_sa_ds_dtl set average_discount=?,realmoney=?,useprice=? where rsadtlid=? ";
                                uh = new UpdateHelper(sql);
                                uh.bindParam(average_discount);
                                uh.bindParam(realmoney);
                                uh.bindParam(useprice);
                                uh.bindParam(dtlsmodel.getItemValue(i, "rsadtlid"));
                                uh.executeUpdate(con);
                                break;
                            }
                        }
                    }
                }
            }
            String yunfei_yue = DecimalHelper.sub(yunfei, average_yunfei_total, 2);
            int yunfei_compara = DecimalHelper.comparaDecimal(yunfei_yue, "0");
            if(yunfei_compara!=0){
                sql = "select * from gresa_sa_ds_dtl where rsaid = ?";
                sh = new SelectHelper(sql);
                sh.bindParam(docid);
                DBTableModel dtlsmodel = sh.executeSelect(con, 0, 9999);
                if(null!=dtlsmodel&&dtlsmodel.getRowCount()>0){
                    String  average_yunfei = DecimalHelper.add(dtlsmodel.getItemValue(0, "average_yunfei"), yunfei_yue, 2);
                    String  realmoney = DecimalHelper.add(dtlsmodel.getItemValue(0, "realmoney"), yunfei_yue, 2);
                    String useprice = DecimalHelper.divide(realmoney, dtlsmodel.getItemValue(0, "goodsqty"), 10);
                    sql=" update gresa_sa_ds_dtl set average_yunfei=?,realmoney=?,useprice=? where rsadtlid=? ";
                    uh = new UpdateHelper(sql);
                    uh.bindParam(average_yunfei);
                    uh.bindParam(realmoney);
                    uh.bindParam(useprice);
                    uh.bindParam(dtlsmodel.getItemValue(0, "rsadtlid"));
                    uh.executeUpdate(con);
                }
            }
            String codfee_yue = DecimalHelper.sub(codfee, average_codfee_total, 2);
            int codfee_compara = DecimalHelper.comparaDecimal(codfee_yue, "0");
            if(codfee_compara!=0){
                sql = "select * from gresa_sa_ds_dtl where rsaid = ?";
                sh = new SelectHelper(sql);
                sh.bindParam(docid);
                DBTableModel dtlsmodel = sh.executeSelect(con, 0, 9999);
                if(null!=dtlsmodel&&dtlsmodel.getRowCount()>0){
                    String  average_codfee = DecimalHelper.add(dtlsmodel.getItemValue(0, "average_yunfei"), codfee_yue, 2);
                    String  realmoney = DecimalHelper.add(dtlsmodel.getItemValue(0, "realmoney"), codfee_yue, 2);
                    String useprice = DecimalHelper.divide(realmoney, dtlsmodel.getItemValue(0, "goodsqty"), 10);
                    sql=" update gresa_sa_ds_dtl set average_codfee=?,realmoney=?,useprice=? where rsadtlid=? ";
                    uh = new UpdateHelper(sql);
                    uh.bindParam(average_codfee);
                    uh.bindParam(realmoney);
                    uh.bindParam(useprice);
                    uh.bindParam(dtlsmodel.getItemValue(0, "rsadtlid"));
                    uh.executeUpdate(con);
                }
            }
        }
        return docid;
    }

    private String EditSaDocDtl(Connection con, SelectHelper sh, UpdateHelper uh, String sql, OMSAPPLYORDERREQ req) throws Exception{
        String rsaid = "";
        sql = "select * from gresa_sa_ds_doc where zx_orderno = ? for update";
        sh = new SelectHelper(sql);
        sh.bindParam(req.getZXORDERNO());
        DBTableModel docmodel = sh.executeSelect(con, 0, 9999);
        if(null==docmodel || docmodel.getRowCount()<1){
            throw new BopException("-98", "未查询到零售订单！");
        }
        String errmsg = "";
        for(int i = 0; i < docmodel.getRowCount(); ++i) {
            String docid = docmodel.getItemValue(i, "rsaid");
            try {
                rsaid = rsaid + "," + docid;
                if(StringUtil.doNullInt(docmodel.getItemValue(i, "USESTATUS"))==3){
                    throw new BopException("-1", "订单已取消，修改失败！");
                }
                if(StringUtil.doNullInt(docmodel.getItemValue(i, "ISCREATE"))==1){
                    throw new BopException("-1", "订单信息已生成零售单，修改失败！");
                }
                if(StringUtil.doNullInt(docmodel.getItemValue(i, "SENDSTATE_WMS"))==0){
                    updateDoc2(con, uh, sql, req, docid);
                }else if(StringUtil.doNullInt(docmodel.getItemValue(i, "SENDSTATE_WMS"))==1){
                    //调用物流接口，下发取消信息
                    INFDATA infdate = new INFDATA();
                    GERPBASEINFO gerpbaseinfo = new GERPBASEINFO();
                    String msgid = StringUtil.doNullStr(new Date().getTime());
                    gerpbaseinfo.setMSGID(msgid);
                    gerpbaseinfo.setSENDTIME(msgid);
                    gerpbaseinfo.setSERVICENAME("CERP");
                    gerpbaseinfo.setTSYSTEM("WMS_2020");
                    gerpbaseinfo.setSSYSYEM("CERP_WMS");
                    infdate.setBASEINFO(gerpbaseinfo);
                    GERPMESSAGE gerpmessage = new GERPMESSAGE();
                    GERPARRAYSTRING gerparraystring = new GERPARRAYSTRING();
                    gerpmessage.setARRAYSTRING(gerparraystring);
                    infdate.setMESSAGE(gerpmessage);
                    sql = "select a.rsaid DANJ_NO, " +
                            "a.rsaid,c.entryid, " +
                            "b.wmscenterucode WLZX_CODE, " +
                            "b.goodsownerid HUOZ_ID, " +
                            "to_char(a.credate, 'yyyymmdd') RIQI_DATE, " +
                            "a.placepointid DANW_ID " +
                            "from gresa_sa_ds_doc a, pub_storer b, gpcs_placepoint c " +
                            "where a.placepointid = c.placepointid " +
                            "and c.placepointid=b.storerid " +
                            "and a.rsaid= ?";
                    sh = new SelectHelper(sql);
                    sh.bindParam(docid);
                    DBTableModel tckdocmodel = sh.executeSelect(con, 0, 1);
                    if(null==tckdocmodel || tckdocmodel.getRowCount()<1 ){
                        throw new BopException("-1", "查询物流信息失败！");
                    }

                    ARRAYOFTCKKPDMOD arrayoftckkpddel = new ARRAYOFTCKKPDMOD();
                    TCKKPDMOD tckkpddel = new TCKKPDMOD();
                    tckkpddel.setDANJNO("DS"+tckdocmodel.getItemValue(0, "DANJ_NO"));
                    tckkpddel.setZTORDERCHGID("");
                    tckkpddel.setWLZXCODE(tckdocmodel.getItemValue(0, "WLZX_CODE"));
                    String huozhuid = tckdocmodel.getItemValue(0, "HUOZ_ID");
                    tckkpddel.setHUOZID(huozhuid);
                    tckkpddel.setDANWID(tckdocmodel.getItemValue(0, "DANW_ID"));
                    tckkpddel.setRIQIDATE(tckdocmodel.getItemValue(0, "RIQI_DATE"));
                    if(huozhuid.equals("1991")){
                        tckkpddel.setTIHWAY("4");
                    }else if(huozhuid.equals("1990")){
                        tckkpddel.setTIHWAY("11");
                    }else if(huozhuid.equals("4508")){
                        tckkpddel.setTIHWAY("1");
                    }
                    tckkpddel.setNOTE(req.getBUYERMEMO());
                    tckkpddel.setECCSHIPTOREGION(req.getECCSHIPTOREGION());
                    tckkpddel.setECCSHIPTOCITY(req.getECCSHIPTOCITY());
                    tckkpddel.setECCSHIPTODISTRICT(req.getECCSHIPTODISTRICT());
                    tckkpddel.setADDRESS(req.getADDRESS());
                    tckkpddel.setSHOUHPHONE(req.getSHOUHPHONE());
                    tckkpddel.setSHOUHSTAFF(req.getSHOUHSTAFF());
                    tckkpddel.setPOSTCODE(req.getPOSTCODE());
                    tckkpddel.setPEISNOTES(req.getVENDORMEMO());
                    tckkpddel.setCARRIERID(req.getCARRIERID());
                    tckkpddel.setCARRIERNAME(req.getCARRIERNAME());
                    tckkpddel.setPOSTALZONE("");
                    tckkpddel.setDELIVERYDATE(docmodel.getItemValue(i, "delivery_date"));
                    if("".equals("1991")){
                        tckkpddel.setSHADCITY(docmodel.getItemValue(i, "shad_city"));
                        tckkpddel.setSHADCITYDISTRICT(docmodel.getItemValue(i, "shad_city_district"));
                        tckkpddel.setSHADRESIDENTIAL(docmodel.getItemValue(i, "shad_residential"));
                        tckkpddel.setSHADRESIDENTIALNUMBER(docmodel.getItemValue(i, "shad_residential_number"));
                    }else{
                        tckkpddel.setSHADCITY("");
                        tckkpddel.setSHADCITYDISTRICT("");
                        tckkpddel.setSHADRESIDENTIAL("");
                        tckkpddel.setSHADRESIDENTIALNUMBER("");
                    }
                    tckkpddel.setSHUIPTYPE("");
                    tckkpddel.setFAHTYPE("2");
                    arrayoftckkpddel.setTCKKPDMOD(tckkpddel);
                    String retxml = "";
                    try {
                        retxml = JAXBUtil.marshToXmlBinding(ARRAYOFTCKKPDMOD.class, arrayoftckkpddel, "UTF-8");
                        infdate.getMESSAGE().getARRAYSTRING().setInfmsg(retxml);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    //调用物流接口，下发修改信息
                    String entryid = tckdocmodel.getItemValue(0, "entryid");
                    String url =  getWebServiceUrlByEntryId(con, entryid, "22");
                    URL wsdlURL = null;
                    wsdlURL = new URL(url);
                    WmsCkkpdMod wms = new WmsCkkpdMod(wsdlURL);
                    WmsCkkpdModSoap soap = wms.getWmsCkkpdModSoap();
                    String msg = soap.receiveCkkpdMod(infdate);
                    log.info("WMS回传结果："+msg);
                    DATA rtdata = JAXBUtil.unmarshToObjBinding(DATA.class, msg, "UTF-8");
                    RETDATA rd = rtdata.getRETDATA();
                    if(null==rd){
                        throw new BopException("-1", "取消失败！");
                    }
                    if(rd.getZFLAG().equals("S")){
                        updateDoc2(con, uh, sql, req, docid);
                    }else{
                        throw new BopException("-1", rd.getZMESSAGE());
                    }
                    System.out.println(msg);
                }else if(StringUtil.doNullInt(docmodel.getItemValue(i, "SENDSTATE_WMS"))==2){
                    throw new BopException("-1", "物流已回传记账，修改失败！");
                }
            } catch (BopException e) {
                e.printStackTrace();
                errmsg = errmsg + "," + "订单：" + e.getErrMsg();
            } catch (Exception e) {
                e.printStackTrace();
                errmsg = errmsg + "," + "订单：" + docid + " 操作失败";
            }
        }
        if (errmsg.length() > 1) {
            errmsg = errmsg.substring(1, errmsg.length());
            throw new BopException("-1", errmsg);
        } else {
            return rsaid;
        }
    }

    private void updateDoc(Connection con, UpdateHelper uh, String sql, OMSAPPLYORDERREQ req) throws Exception{
        sql = "update gresa_sa_ds_doc set " +
                " ECC_SHIPTO_REGION=?,ECC_SHIPTO_CITY=?,ECC_SHIPTO_DISTRICT=?," +
                " ADDRESS=?,SHOUH_PHONE=?,POSTCODE=?,VENDORMEMO=?,BUYERMEMO=?,SHUIP_TYPE=?," +
                " INVOICE_TITLE=?,INVOICE_CONTENT=?,CARRIER_ID=?,CARRIER_NAME=?,SHOUH_STAFF=?  where zx_orderno =?";
        uh = new UpdateHelper(sql);
        uh.bindParam(req.getECCSHIPTOREGION());
        uh.bindParam(req.getECCSHIPTOCITY());
        uh.bindParam(req.getECCSHIPTODISTRICT());
        uh.bindParam(req.getADDRESS());
        uh.bindParam(req.getSHOUHPHONE());
        uh.bindParam(req.getPOSTCODE());
        uh.bindParam(req.getVENDORMEMO());
        uh.bindParam(req.getBUYERMEMO());
        uh.bindParam(req.getSHUIPTYPE());
        uh.bindParam(req.getINVOICETITLE());
        uh.bindParam(req.getINVOICECONTENT());
        uh.bindParam(req.getCARRIERID());
        uh.bindParam(req.getCARRIERNAME());
        uh.bindParam(req.getSHOUHSTAFF());
        uh.bindParam(req.getZXORDERNO());
        uh.executeUpdate(con);
    }

    private void updateDoc2(Connection con, UpdateHelper uh, String sql, OMSAPPLYORDERREQ req, String rsaid) throws Exception {
        sql = "update gresa_sa_ds_doc set  ECC_SHIPTO_REGION=?,ECC_SHIPTO_CITY=?,ECC_SHIPTO_DISTRICT=?, ADDRESS=?,SHOUH_PHONE=?,POSTCODE=?,VENDORMEMO=?,BUYERMEMO=?,SHUIP_TYPE=?, INVOICE_TITLE=?,INVOICE_CONTENT=?,CARRIER_ID=?,CARRIER_NAME=?,SHOUH_STAFF=?  where rsaid =?";
        uh = new UpdateHelper(sql);
        uh.bindParam(req.getECCSHIPTOREGION());
        uh.bindParam(req.getECCSHIPTOCITY());
        uh.bindParam(req.getECCSHIPTODISTRICT());
        uh.bindParam(req.getADDRESS());
        uh.bindParam(req.getSHOUHPHONE());
        uh.bindParam(req.getPOSTCODE());
        uh.bindParam(req.getVENDORMEMO());
        uh.bindParam(req.getBUYERMEMO());
        uh.bindParam(req.getSHUIPTYPE());
        uh.bindParam(req.getINVOICETITLE());
        uh.bindParam(req.getINVOICECONTENT());
        uh.bindParam(req.getCARRIERID());
        uh.bindParam(req.getCARRIERNAME());
        uh.bindParam(req.getSHOUHSTAFF());
        uh.bindParam(rsaid);
        uh.executeUpdate(con);
    }

    private String CancelSaDocDtl(Connection con, SelectHelper sh, UpdateHelper uh, DeleteHelper dh, String sql, OMSAPPLYORDERREQ req) throws Exception{
        String rsaid = "";
        sql = "select * from gresa_sa_ds_doc where zx_orderno = ? for update";
        sh = new SelectHelper(sql);
        sh.bindParam(req.getZXORDERNO());
        DBTableModel docmodel = sh.executeSelect(con, 0, 9999);
        if(null==docmodel || docmodel.getRowCount()<1){
            throw new BopException("-98", "未查询到零售订单！");
        }
        String errmsg = "";
        for(int k = 0; k < docmodel.getRowCount(); k++){
            String docid = docmodel.getItemValue(k, "rsaid");
            try {
                rsaid = rsaid + "," + docid;
                if(StringUtil.doNullInt(docmodel.getItemValue(k, "ISCREATE"))==1){
                    throw new BopException("-1", "订单信息已生成零售单，取消失败！");
                }
                if(StringUtil.doNullInt(docmodel.getItemValue(k, "USESTATUS"))!=3){
                    if(StringUtil.doNullInt(docmodel.getItemValue(k, "SENDSTATE_WMS"))==0){
                        sql = "update gresa_sa_ds_doc set USESTATUS=3 where rsaid =?";
                        uh = new UpdateHelper(sql);
                        uh.bindParam(docid);
                        uh.executeUpdate(con);
                        if(StringUtil.doNullInt(docmodel.getItemValue(k, "placeqtystate"))==1){
                            //删除库存占用
                            DelSTIOTMP(con, sh, dh, sql, docid);
                        }
                    }else if(StringUtil.doNullInt(docmodel.getItemValue(k, "SENDSTATE_WMS"))==1){
                        //调用物流接口，下发取消信息
                        org.ssm.dufy.client.wms.cancel.INFDATA infdate = new org.ssm.dufy.client.wms.cancel.INFDATA();
                        org.ssm.dufy.client.wms.cancel.GERPBASEINFO gerpbaseinfo = new org.ssm.dufy.client.wms.cancel.GERPBASEINFO();
                        String msgid = StringUtil.doNullStr(new Date().getTime());
                        gerpbaseinfo.setMSGID(msgid);
                        gerpbaseinfo.setSENDTIME(msgid);
                        gerpbaseinfo.setSERVICENAME("CERP");
                        gerpbaseinfo.setTSYSTEM("WMS_2020");
                        gerpbaseinfo.setSSYSYEM("CERP_WMS");
                        infdate.setBASEINFO(gerpbaseinfo);
                        org.ssm.dufy.client.wms.cancel.GERPMESSAGE gerpmessage = new org.ssm.dufy.client.wms.cancel.GERPMESSAGE();
                        org.ssm.dufy.client.wms.cancel.GERPARRAYSTRING gerparraystring = new org.ssm.dufy.client.wms.cancel.GERPARRAYSTRING();
                        gerpmessage.setARRAYSTRING(gerparraystring);
                        infdate.setMESSAGE(gerpmessage);

                        sql = "select a.rsaid,c.entryid, " +
                                "(select to_char(systimestamp, 'yyyymmddhh24missff') from dual) DANJ_NO, " +
                                "b.wmscenterucode WLZX_CODE, " +
                                "b.goodsownerid HUOZ_ID, " +
                                "to_char(a.credate, 'yyyymmdd') RIQI_DATE, " +
                                "a.rsaid DANJ_NO_Y, " +
                                "a.BUYERMEMO YUANYIN, " +
                                "null NOTE, " +
                                "a.dtl_lines TIAOM_NUM, " +
                                "'N' ZT " +
                                "from gresa_sa_ds_doc a, pub_storer b, gpcs_placepoint c " +
                                "where a.placepointid = c.placepointid " +
                                "and c.placepointid=b.storerid " +
                                "and a.rsaid= ?";
                        sh = new SelectHelper(sql);
                        sh.bindParam(docid);
                        DBTableModel tckdocmodel = sh.executeSelect(con, 0, 1);
                        if(null==tckdocmodel || tckdocmodel.getRowCount()<1 ){
                            throw new BopException("-1", "查询物流信息失败！");
                        }
                        ARRAYOFTCKKPDDEL arrayoftckkpddel = new ARRAYOFTCKKPDDEL();
                        TCKKPDDEL tckkpddel = new TCKKPDDEL();
                        tckkpddel.setDANJNO(tckdocmodel.getItemValue(0, "DANJ_NO"));
                        tckkpddel.setWLZXCODE(tckdocmodel.getItemValue(0, "WLZX_CODE"));
                        tckkpddel.setHUOZID(tckdocmodel.getItemValue(0, "HUOZ_ID"));
                        tckkpddel.setRIQIDATE(tckdocmodel.getItemValue(0, "RIQI_DATE"));
                        tckkpddel.setDANJNOY("DS"+tckdocmodel.getItemValue(0, "DANJ_NO_Y"));
                        tckkpddel.setYUANYIN(tckdocmodel.getItemValue(0, "YUANYIN"));
                        tckkpddel.setNOTE(tckdocmodel.getItemValue(0, "NOTE"));
                        tckkpddel.setTIAOMNUM(tckdocmodel.getItemValue(0, "TIAOM_NUM"));
                        tckkpddel.setZT(tckdocmodel.getItemValue(0, "ZT"));
                        tckkpddel.setYEWSTAFF("");
                        tckkpddel.setPEISNOTES("");
                        tckkpddel.setDANJNONC("");
                        DANJMX danjmx = new DANJMX();
                        tckkpddel.setDANJMX(danjmx);
                        arrayoftckkpddel.setTCKKPDDEL(tckkpddel);
                        List<MINGXI> mxlist = arrayoftckkpddel.getTCKKPDDEL().getDANJMX().getMINGXI();

                        sql = " select t.HANGHAO,t.NUM from zx_to_wms_gresa_ds_dtl_v t " +
                                " where t.docid= " + tckdocmodel.getItemValue(0, "rsaid");
                        sh = new SelectHelper(sql);
                        DBTableModel tckdtlmodel = sh.executeSelect(con, 0, 9999);
                        if(null==tckdtlmodel || tckdtlmodel.getRowCount()<1 ){
                            throw new BopException("-1", "查询明细失败！");
                        }
                        for(int i=0;i<tckdtlmodel.getRowCount();i++){
                            MINGXI mingxi = new MINGXI();
                            mingxi.setHANGHAOY(tckdtlmodel.getItemValue(i, "HANGHAO"));
                            mingxi.setNUM(tckdtlmodel.getItemValue(i, "NUM"));
                            mxlist.add(mingxi);
                        }
                        String retxml = "";
                        try {
                            retxml = JAXBUtil.marshToXmlBinding(ARRAYOFTCKKPDDEL.class, arrayoftckkpddel, "UTF-8");
                            infdate.getMESSAGE().getARRAYSTRING().setInfmsg(retxml);
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        }
                        String entryid = tckdocmodel.getItemValue(0, "entryid");
                        String url =  getWebServiceUrlByEntryId(con, entryid, "21");
                        URL wsdlURL = new URL(url);
                        WmsCkdel wms = new WmsCkdel(wsdlURL);
                        WmsCkdelSoap soap = wms.getWmsCkdelSoap();
                        String msg = soap.receiveCkdel(infdate);
                        log.info("WMS回传结果："+msg);
                        if(null==msg||msg.equals("")){
                            throw new BopException("-1", "取消失败！");
                        }
                        DATA rtdata = JAXBUtil.unmarshToObjBinding(DATA.class, msg, "UTF-8");
                        RETDATA rd = rtdata.getRETDATA();
                        if(null==rd){
                            throw new BopException("-1", "取消失败！");
                        }
                        if(rd.getZFLAG().equals("S")){
                            sql = "update gresa_sa_ds_doc set USESTATUS=3 where rsaid =?";
                            uh = new UpdateHelper(sql);
                            uh.bindParam(docid);
                            uh.executeUpdate(con);
                            //删除库存占用
                            DelSTIOTMP(con, sh, dh, sql, docid);
                        }else{
                            throw new BopException("-1", rd.getZMESSAGE());
                        }
                        System.out.println(msg);
                    }else if(StringUtil.doNullInt(docmodel.getItemValue(k, "SENDSTATE_WMS"))==2){
                        throw new BopException("-1", "物流已回传记账，取消失败！");
                    }
                }
            } catch (BopException e) {
                e.printStackTrace();
                errmsg = errmsg + "," + "订单：" + e.getErrMsg();
            } catch (Exception e) {
                e.printStackTrace();
                errmsg = errmsg + "," + "订单：" + docid + " 操作失败";
            }

        }
        if (errmsg.length() > 1) {
            errmsg = errmsg.substring(1, errmsg.length());
            throw new BopException("-1", errmsg);
        } else {
            return rsaid;
        }
    }


    private void DelSTIOTMP(Connection con, SelectHelper sh, DeleteHelper dh, String sql, String rsaid) throws Exception{
        sql = " select a.rsadtlid  "
                + " from "
                + " gresa_sa_ds_dtl a "
                + " where a.rsaid= "+rsaid;
        sh = new SelectHelper(sql);
        DBTableModel tckdtlmodel = sh.executeSelect(con, 0, 9999);
        if(null!=tckdtlmodel&&tckdtlmodel.getRowCount()>0 ){
            for(int i=0;i<tckdtlmodel.getRowCount();i++){
                String rsadtlid = tckdtlmodel.getItemValue(i, "rsadtlid");
                sql = " select a.inoutid  "
                        + " from "
                        + " bms_st_io_doc_tmp a "
                        + " where "
                        + " a.comefrom=80 "
                        + " and a.sourceid ="+rsadtlid;
                sh = new SelectHelper(sql);
                DBTableModel tmpdtlmodel = sh.executeSelect(con, 0, 9999);
                if(null!=tmpdtlmodel&&tmpdtlmodel.getRowCount()>0 ){
                    for(int j=0;j<tmpdtlmodel.getRowCount();j++){
                        sql = "delete bms_st_io_dtl_tmp where inoutid = "+tmpdtlmodel.getItemValue(j, "inoutid");
                        dh = new DeleteHelper(sql);
                        dh.executeDelete(con);
                    }
                    sql = "delete bms_st_io_doc_tmp where inoutid ="+tmpdtlmodel.getItemValue(0, "inoutid");
                    dh = new DeleteHelper(sql);
                    dh.executeDelete(con);
                }
            }
        }
    }

    /**
     * Unix时间戳转换成日期.
     * @param timestampString
     * @return
     */
    public static String TimeStampToDate(String timestampString) {
        Long timestamp = Long.parseLong(timestampString);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    public static String  getWebServiceUrlByEntryId(Connection con,String entryid,String type) throws Exception{
        String sql="select t.paramvalue from erp2wms_webservice_param t where t.entryid= ? and t.type= ?";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(entryid);
        sh.bindParam(type);
        return sh.executeSelect(con, 0, 1).getItemValue(0, "paramvalue");
    }

}
