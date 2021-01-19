package org.ssm.dufy.service.impl;

import com.inca.np.gui.control.DBTableModel;
import com.inca.np.util.DecimalHelper;
import com.inca.np.util.InsertHelper;
import com.inca.np.util.SelectHelper;
import com.inca.np.util.UpdateHelper;
import com.inca.pubsrv.NpbusiDBHelper;
import com.inca.pubsrv.NptrDBHelper;
import com.inca.resale.tools.NgpcsDBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.common.goodsqty.GOODSQTYREQ;
import org.ssm.cxf.struct.common.goodsqty.GOODSQTYRESP;
import org.ssm.cxf.struct.common.goodsqty.ITEM;
import org.ssm.cxf.struct.common.goodsqty.QTYLIST;
import org.ssm.cxf.struct.common.order.APPLYORDERREQ;
import org.ssm.cxf.struct.common.order.APPLYORDERRESP;
import org.ssm.cxf.struct.common.order.PRODUCT;
import org.ssm.dufy.exception.BopException;
import org.ssm.dufy.service.ICommonIntefaceServcie;

import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("commonInterfaceService")
public class CommonIntefaceServcieImpl implements ICommonIntefaceServcie {

    @Autowired
    private DataSource cerpzsdataSource;

    @Override
    public String getGoodsQty(String entryid, String xmldata) {
        GOODSQTYRESP resp = new GOODSQTYRESP();
        GOODSQTYREQ req = JAXBUtil.unmarshToObjBinding(GOODSQTYREQ.class, xmldata, "UTF-8");
        String placepointid = req.getPLACEPOINTID();
        String goodsidstr = req.getGOODSIDS();
        entryid = req.getENTRYID();
        String retxml = "";
        if(StringUtil.isEmpty(goodsidstr)){
            resp.setRETURNCODE("-1");
            resp.setRETURNMSG("货品ID不能为空");
        } else if (StringUtil.isEmpty(placepointid)) {
            resp.setRETURNCODE("-1");
            resp.setRETURNMSG("门店ID不能为空");
        }else {
            String[] goodsids = goodsidstr.split(",");
            if (goodsids.length <= 1000) {
                Map<String, Object> maplist = new HashMap<>();
                for(int i=0;i<goodsids.length;i++){
                    maplist.put(goodsids[i], "0");
                }
                Connection con = null;
                try {
                    con = cerpzsdataSource.getConnection();
                    con.setAutoCommit(false);
                    QTYLIST goodslist = new QTYLIST();
                    resp.setQTYLIST(goodslist);
                    List<ITEM> itemlist = resp.getQTYLIST().getITEM();
                    String sql = " select  " +
                            " b.goodsid,  " +
                            " floor(nvl(sum(nvl(b.goodsqty,0)), 0)) goodsqty " +
                            " from gpcs_placepoint a, " +
                            " resa_stqty_sum_v b " +
                            " where a.storageid=b.storageid(+) " +
                            " and a.placepointid= "+placepointid +
                            " and b.goodsid in ("+goodsidstr + ") " +
                            " and nvl(b.invaliddays(+),0) > 0   " +
                            " and nvl(b.statususeflag(+),0) = 1  " +
                            " group by b.goodsid ";
                    SelectHelper sh = new SelectHelper(sql);
                    DBTableModel stockmodel = sh.executeSelect(con, 0, 9999);
                    if(null!=stockmodel&&stockmodel.getRowCount()>0) {
                        for (int i=0;i<stockmodel.getRowCount();i++) {
                            String goodsid = StringUtil.doNullStr(stockmodel.getItemValue(i,"goodsid"));
                            String goodsqty = StringUtil.doNullStr(stockmodel.getItemValue(i,"goodsqty"));
                            maplist.put(goodsid, goodsqty);
                        }
                    }
                    for (String key : maplist.keySet()) {
                        ITEM item = new ITEM();
                        item.setGOODSID(StringUtil.doNullStr(key));
                        item.setGOODSQTY(StringUtil.doNullStr(maplist.get(key)));
                        itemlist.add(item);
                    }
                    if (itemlist.size() == 0) {
                        resp.setRETURNCODE("-1");
                        resp.setRETURNMSG("未查询到数据");
                    } else {
                        resp.setRETURNCODE("0");
                        resp.setRETURNMSG("查询成功");
                    }
                } catch (Exception e){
                    e.printStackTrace();
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
            }else {
                resp.setRETURNCODE("-1");
                resp.setRETURNMSG("查询失败，单次查询货品数量不能超过9999");
            }
        }
        try {
            retxml = JAXBUtil.marshToXmlBinding(GOODSQTYRESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    @Override
    public String createOrder(String entryid, String xmldata) {
        APPLYORDERRESP resp = new APPLYORDERRESP();

        APPLYORDERREQ req = JAXBUtil.unmarshToObjBinding(APPLYORDERREQ.class, xmldata, "UTF-8");
        String placepointid = req.getPLACEPOINTID();
        Connection con = null;
        String sql = "";
        try {
            con = cerpzsdataSource.getConnection();
            con.setAutoCommit(false);

            //判断是否是重复订单
            String zxsql = "select * from gresa_sa_doc where zx_orderno = ?";
            SelectHelper docsh = new SelectHelper(zxsql);
            docsh.bindParam(req.getZXORDERNO());
            DBTableModel docmodel = docsh.executeSelect(con, 0, 1);
            if(docmodel.getRowCount()>0){
                throw new BopException("-99", "该订单号已生成零售单，请勿重复发送！");
            }
            if(DecimalHelper.comparaDecimal(req.getRECEIVALMONEY(), "0")<=0){
                System.out.println("订单【"+req.getZXORDERNO()+"】错误，应收金额不能为0或负数！");
                throw new BopException("-2", "订单【"+req.getZXORDERNO()+"】错误，应收金额不能为0或负数！");
            }
            if(DecimalHelper.comparaDecimal(req.getREALMONEY(), "0")<=0){
                System.out.println("订单【"+req.getZXORDERNO()+"】错误，实收金额不能为0或负数！");
                throw new BopException("-2", "订单【"+req.getZXORDERNO()+"】错误，实收金额不能为0或负数！");
            }
            if(!checkMoney(req)){
                System.out.println("订单【"+req.getZXORDERNO()+"】金额错误！");
                throw new BopException("-2", "订单【"+req.getZXORDERNO()+"】金额错误！");
            }
            String cashierid = req.getCASHIER();
            String docid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_doc_seq");//零售总单ID
            //生成零售总单.BEGIN.
            InsertHelper ih = new InsertHelper("gresa_sa_doc");
            ih.bindParam("rsaid", docid);
            ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));//创建时间
            ih.bindParam("placepointid", placepointid);//门店ID
            ih.bindParam("receivalmoney", req.getRECEIVALMONEY());//应收
            ih.bindParam("realmoney", req.getREALMONEY());//实收
            ih.bindParam("dtl_lines", String.valueOf(req.getPRODUCTS().getPRODUCT().size()));//细单条数
            ih.bindParam("usestatus", "1");//使用状态
            ih.bindDateParam("useday", getUseDay(con));//逻辑日
            ih.bindParam("rsatype", "1");//销售类型 零售.
            ih.bindParam("cashierid", cashierid);//收款员ID
            ih.bindParam("rsaclass", getRsaClass(con));//班次
            ih.bindParam("zx_orderno", req.getZXORDERNO());//微医订单号.
            ih.executeInsert(con);

            String storageid = getStorageID(con,placepointid).getItemValue(0, "storageid");//获取保管账ID
            if(storageid == null || storageid.equals("")){
                System.out.println("门店ID【"+placepointid+"】在INCA系统中不存在！");
                throw new BopException("-2", "门店ID【"+placepointid+"】在INCA系统中不存在！");
            }
            List<PRODUCT> lists = req.getPRODUCTS().getPRODUCT();
            for (PRODUCT pro : lists) {
                CreateSaDtl(con, pro, docid, placepointid, storageid, req.getZXORDERNO(), cashierid, entryid);
            }
            //进行调价
//            tiaojia(con, docid, req.getRECEIVALMONEY());
            setDtllines(con, docid);//设置明细条数

            //生成收款明细数据
            InsertHelper payh = new InsertHelper("gresa_sa_lst");
            String rsalstid = NgpcsDBHelper.getSeqValue(con, "gresa_sa_lst_seq");
            payh.bindParam("rsalstid", rsalstid);
            payh.bindParam("rsaid", docid);
            payh.bindParam("gathertype", req.getGATHERTYPE());//先默认一个收款方式.线上微信支付.
            payh.bindParam("recmoney", req.getRECEIVALMONEY());//总单应收款
            payh.bindParam("realmoney",req.getREALMONEY());//总单实际收款
            payh.bindParam("changemoney", "0");
            payh.executeInsert(con);

            con.commit();
            resp.setRETURNCODE("0");
            resp.setRETURNMSG("零售单生成成功");
        } catch (BopException e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            resp.setRETURNCODE("-1");
            resp.setRETURNMSG(e.getErrMsg());
        } catch (Exception e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            resp.setRETURNCODE("-7");
            resp.setRETURNMSG("生成零售单失败");
        }finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        String retxml = "";
        try {
            retxml = JAXBUtil.marshToXmlBinding(APPLYORDERRESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }


    private void tiaojia(Connection con, String docid, String total_realmoney) throws Exception {
        //进行调价
        String sql = "select * from gresa_sa_dtl where rsaid = ?";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(docid);
        DBTableModel dtls = sh.executeSelect(con, 0, 9999);
        String total_real = "";
        for(int i=0;i<dtls.getRowCount();i++){
            total_real  = DecimalHelper.add(total_real, dtls.getItemValue(i,"total_line"), 2);
        }
        String diff = DecimalHelper.sub(total_realmoney, total_real, 2);
        if(DecimalHelper.comparaDecimal(diff, "0")==1) {
            String dtlrealmoney = DecimalHelper.add(dtls.getItemValue(0,"total_line"), diff, 2);
            String useprice = DecimalHelper.divide(dtlrealmoney, dtls.getItemValue(0,"goodsqty"), 10);
            sql = "update gresa_sa_dtl set total_line=?,realmoney=?,useprice=?,resaprice=?,unitprice=? where rsadtlid =?";
            UpdateHelper uh = new UpdateHelper(sql);
            uh.bindParam(dtlrealmoney);
            uh.bindParam(dtlrealmoney);
            uh.bindParam(useprice);
            uh.bindParam(useprice);
            uh.bindParam(useprice);
            uh.bindParam(dtls.getItemValue(0,"rsadtlid"));
            uh.executeUpdate(con);
        }else if(DecimalHelper.comparaDecimal(diff, "0")==-1) {
            for(int z=0;z<dtls.getRowCount();z++){
                String dtlrealmoney = DecimalHelper.add(dtls.getItemValue(z,"total_line"), diff, 2);
                if(DecimalHelper.comparaDecimal(dtlrealmoney, "0")>=0) {
                    String useprice = DecimalHelper.divide(dtlrealmoney, dtls.getItemValue(z,"goodsqty"), 10);
                    sql = "update gresa_sa_dtl set total_line=?,realmoney=?,useprice=?,resaprice=?,unitprice=? where rsadtlid =?";
                    UpdateHelper uh = new UpdateHelper(sql);
                    uh.bindParam(dtlrealmoney);
                    uh.bindParam(dtlrealmoney);
                    uh.bindParam(useprice);
                    uh.bindParam(useprice);
                    uh.bindParam(useprice);
                    uh.bindParam(dtls.getItemValue(z,"rsadtlid"));
                    uh.executeUpdate(con);
                    break;
                }
            }
        }

        //更新细单条数
        sql = "update gresa_sa_doc set dtl_lines=? where rsaid =?";
        UpdateHelper uh = new UpdateHelper(sql);
        uh.bindParam(String.valueOf(dtls.getRowCount()));
        uh.bindParam(docid);
        uh.executeUpdate(con);
    }


    private void setDtllines(Connection con, String docid) throws Exception {
        //进行调价
        String sql = "select * from gresa_sa_dtl where rsaid = ?";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(docid);
        DBTableModel dtls = sh.executeSelect(con, 0, 9999);

        //更新细单条数
        sql = "update gresa_sa_doc set dtl_lines=? where rsaid =?";
        UpdateHelper uh = new UpdateHelper(sql);
        uh.bindParam(String.valueOf(dtls.getRowCount()));
        uh.bindParam(docid);
        uh.executeUpdate(con);
    }

    /**
     * 生成零售细单
     * @param con
     * @param pro
     * @param docid
     * @param orderid
     * @param storageid
     * @throws Exception
     */
    private void CreateSaDtl(Connection con, PRODUCT pro, String docid,String placepointid, String storageid, String orderid, String cashierid, String entryid) throws Exception {
        String goodsid = pro.getGOODSID();
        String goodsqty = pro.getGOODSQTY();
        String price = pro.getUNITPRICE();
        String total_line = pro.getTOTALLINE();
        String priceid = pro.getPRICEID();

        if(DecimalHelper.comparaDecimal(total_line, "0")<=0){
            System.out.println("货品【"+goodsid+"】明细错误，明细总金额不能为0或负数！");
            throw new BopException("-2", "订单【"+goodsid+"】明细错误，明细总金额不能为0或负数！");
        }

        String cansaleqty = "";//可销库存数量
        //查询当前门店该货品的可销库存.//出库时按近效期的批号规则出库.
        String sql = "select * from resa_stqty_sum_v where goodsid = ? and nvl(invaliddays,0) > 0 and nvl(statususeflag,0) = 1 and storageid = ? order by invaliddate";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(goodsid);
        sh.bindParam(storageid);
        DBTableModel cansalemd = sh.executeSelect(con, 0, 9999);
        if(cansalemd != null && cansalemd.getRowCount() > 0){
            if(cansalemd.getRowCount() == 1){//当只有一条可销库存记录时.
                cansaleqty = cansalemd.getItemValue(0, "goodsqty");
                if(DecimalHelper.comparaDecimal(cansaleqty, goodsqty) < 0){
                    System.out.println("当前货品ID【"+goodsid+"】的可销库存为【"+cansaleqty+"】,不够订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
                    throw new BopException("-1", "当前货品ID【"+goodsid+"】的可销库存为【"+cansaleqty+"】,不够订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
                }
                String rsadtlid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_dtl_seq");
                InsertHelper ih = new InsertHelper("gresa_sa_dtl");
                ih.bindParam("rsadtlid", rsadtlid);//细单ID
                ih.bindParam("rsaid",docid);//总单ID
                ih.bindParam("goodsid", goodsid);//货品ID
                ih.bindParam("goodsqty", goodsqty);//数量
                ih.bindParam("realmoney", pro.getREALMONEY());//实收金额
                ih.bindParam("total_line", total_line);//应收金额
                ih.bindParam("storageid", storageid);//保管账ID
                ih.bindParam("useprice", price);//单价
                ih.bindParam("placepointid", placepointid);//门店ID
                ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                ih.bindParam("resaprice", price);//单价
                ih.bindParam("unitprice", price);//原单价
                String zx_taxrate =getgoodstaxrate(con, placepointid, goodsid);
                if(zx_taxrate.equals("")){
                    zx_taxrate = getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate");
                }
                ih.bindParam("taxrate", zx_taxrate);//税率
                String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                String presentflag="5".equals(accflag)?"1":"0";
                ih.bindParam("presentflag",presentflag);//货品属性.
                ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                ih.bindParam("lotid",cansalemd.getItemValue(0, "lotid"));//货品批号ID.
                ih.bindParam("batchid",cansalemd.getItemValue(0, "batchid"));//货品批次ID.
                ih.bindParam("posid",cansalemd.getItemValue(0, "posid"));//货品货位ID.
                ih.bindParam("goodsdtlid",cansalemd.getItemValue(0, "goodsdtlid"));//货品明细ID.
                ih.bindParam("goodsstatusid","1");//货品状态
                ih.bindParam("memo","该零售细单由接口订单生成！");//备注
                ih.bindParam("clerkerid",cashierid);//营业员ID
                ih.executeInsert(con);

                String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                if (presentflag.equals("0") || presstockflag.equals("1")) {
                    String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                    NpbusiDBHelper.gencerttmp(con, rsadtlid, "gresa_sa_dtl", "1", "1", transactionid);

                    String inoutid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_doc_seq");
                    ih = new InsertHelper("bms_st_io_doc_tmp");
                    ih.bindParam("inoutid",inoutid);
                    ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));
                    ih.bindParam("comefrom","40");//零售出
                    ih.bindParam("sourcetable","40");//零售出
                    ih.bindParam("sourceid",rsadtlid);
                    ih.bindParam("companyid",placepointid);//门店ID
                    ih.bindParam("companyname",getStorageID(con,placepointid).getItemValue(0, "placepointname"));//门店名称
                    ih.bindParam("goodsid",goodsid);//货品ID
                    ih.bindParam("storageid",storageid);//保管账ID
                    ih.bindParam("inoutflag","0");//出库标志 , 1代表入库
                    ih.bindParam("outqty",goodsqty);//出入库数量
                    ih.bindParam("oldqty",goodsqty);//原数量数量
                    ih.bindParam("goodsunit",getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                    ih.bindParam("usestatus", "1");//状态
                    ih.bindParam("entryid", getStorageID(con,placepointid).getItemValue(0, "entryid"));//独立单元ID
                    ih.executeInsert(con);

                    String iodtlid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_dtl_seq");
                    ih = new InsertHelper("bms_st_io_dtl_tmp");
                    ih.bindParam("inoutid",inoutid);//出库总单ID
                    ih.bindParam("iodtlid",iodtlid);//出库细单ID
                    ih.bindParam("lotid",cansalemd.getItemValue(0, "lotid"));//货品批号ID.
                    ih.bindParam("batchid",cansalemd.getItemValue(0, "batchid"));//货品批次ID.
                    ih.bindParam("posid",cansalemd.getItemValue(0, "posid"));//货品货位ID.
                    ih.bindParam("goodsdtlid",cansalemd.getItemValue(0, "goodsdtlid"));//货品明细ID.
                    ih.bindParam("goodsstatusid", "1");//货品状态
                    ih.bindParam("dtlgoodsqty", goodsqty);//货品数量
                    ih.executeInsert(con);

                    NptrDBHelper.keepout(con, inoutid, "0");//出库记账
                }
            }else{//当记录条数大于1时,按近效期的规则进行出库.
                //获取cansalemd中符合出库的记录数.
                int mdcount = getModelRowCounts(cansalemd,goodsqty);
                String tmpqty = "";//临时变量.
                String accqty = "";//已出库数量.
                for(int c = 0; c < mdcount; c ++){
                    tmpqty = cansalemd.getItemValue(c, "goodsqty");
                    if(DecimalHelper.comparaDecimal(tmpqty, DecimalHelper.sub(goodsqty, accqty, 2)) >= 0){//如果第一条记录满足出库数量,则生成对应零售单及出库.
                        String rsadtlid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_dtl_seq");
                        InsertHelper ih = new InsertHelper("gresa_sa_dtl");
                        ih.bindParam("rsadtlid", rsadtlid);//细单ID
                        ih.bindParam("rsaid",docid);//总单ID
                        ih.bindParam("goodsid", goodsid);//货品ID
                        ih.bindParam("goodsqty", DecimalHelper.sub(goodsqty, accqty, 2));//数量
//                        ih.bindParam("total_line", DecimalHelper.multi(unitprice, DecimalHelper.sub(goodsqty, accqty, 2), 2));//应收金额
//                        ih.bindParam("realmoney", DecimalHelper.multi(price, DecimalHelper.sub(goodsqty, accqty, 2), 2));//实收金额

                        String realmoney = DecimalHelper.multi(price, DecimalHelper.sub(goodsqty, accqty, 2), 2);
                        ih.bindParam("realmoney", realmoney);//实收金额
                        ih.bindParam("total_line", realmoney);//应收金额

                        ih.bindParam("storageid", storageid);//保管账ID
                        ih.bindParam("useprice", price);//单价
                        ih.bindParam("placepointid", placepointid);//门店ID
                        ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                        ih.bindParam("resaprice", price);//单价
                        ih.bindParam("unitprice", price);//原单价
                        String zx_taxrate =getgoodstaxrate(con, placepointid, goodsid);
                        if(zx_taxrate.equals("")){
                            zx_taxrate = getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate");
                        }
                        ih.bindParam("taxrate", zx_taxrate);//税率
                        String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                        String presentflag="5".equals(accflag)?"1":"0";
                        ih.bindParam("presentflag",presentflag);//货品属性.
                        ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                        ih.bindParam("lotid",cansalemd.getItemValue(c, "lotid"));//货品批号ID.
                        ih.bindParam("batchid",cansalemd.getItemValue(c, "batchid"));//货品批次ID.
                        ih.bindParam("posid",cansalemd.getItemValue(c, "posid"));//货品货位ID.
                        ih.bindParam("goodsdtlid",cansalemd.getItemValue(c, "goodsdtlid"));//货品明细ID.
                        ih.bindParam("goodsstatusid","1");//货品状态
                        ih.bindParam("memo","该零售细单由接口订单生成！");//备注
                        ih.bindParam("clerkerid",cashierid);//营业员ID
                        ih.executeInsert(con);

                        String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                        if (presentflag.equals("0") || presstockflag.equals("1")) {
                            String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                            NpbusiDBHelper.gencerttmp(con, rsadtlid, "gresa_sa_dtl", "1", "1", transactionid);

                            String inoutid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_doc_seq");
                            ih = new InsertHelper("bms_st_io_doc_tmp");
                            ih.bindParam("inoutid",inoutid);
                            ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));
                            ih.bindParam("comefrom","40");//零售出
                            ih.bindParam("sourcetable","40");//零售出
                            ih.bindParam("sourceid",rsadtlid);
                            ih.bindParam("companyid",placepointid);//门店ID
                            ih.bindParam("companyname",getStorageID(con,placepointid).getItemValue(0, "placepointname"));//门店名称
                            ih.bindParam("goodsid",goodsid);//货品ID
                            ih.bindParam("storageid",storageid);//保管账ID
                            ih.bindParam("inoutflag","0");//出库标志 , 1代表入库
                            ih.bindParam("outqty",DecimalHelper.sub(goodsqty, accqty, 2));//出入库数量
                            ih.bindParam("oldqty",goodsqty);//原数量数量
                            ih.bindParam("goodsunit",getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                            ih.bindParam("usestatus", "1");//状态
                            ih.bindParam("entryid", getStorageID(con,placepointid).getItemValue(0, "entryid"));//独立单元ID
                            ih.executeInsert(con);

                            String iodtlid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_dtl_seq");
                            ih = new InsertHelper("bms_st_io_dtl_tmp");
                            ih.bindParam("inoutid",inoutid);//出库总单ID
                            ih.bindParam("iodtlid",iodtlid);//出库细单ID
                            ih.bindParam("lotid",cansalemd.getItemValue(c, "lotid"));//货品批号ID.
                            ih.bindParam("batchid",cansalemd.getItemValue(c, "batchid"));//货品批次ID.
                            ih.bindParam("posid",cansalemd.getItemValue(c, "posid"));//货品货位ID.
                            ih.bindParam("goodsdtlid",cansalemd.getItemValue(c, "goodsdtlid"));//货品明细ID.
                            ih.bindParam("goodsstatusid", "1");//货品状态
                            ih.bindParam("dtlgoodsqty", DecimalHelper.sub(goodsqty, accqty, 2));//货品数量
                            ih.executeInsert(con);

                            NptrDBHelper.keepout(con, inoutid, "0");//出库记账

                            accqty = goodsqty;//已出库数量.
                        }
                    }else{
                        String rsadtlid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_dtl_seq");
                        InsertHelper ih = new InsertHelper("gresa_sa_dtl");
                        ih.bindParam("rsadtlid", rsadtlid);//细单ID
                        ih.bindParam("rsaid",docid);//总单ID
                        ih.bindParam("goodsid", goodsid);//货品ID
                        ih.bindParam("goodsqty", tmpqty);//数量

                        String realmoney = DecimalHelper.multi(price, tmpqty, 2);
                        ih.bindParam("realmoney", realmoney);//实收金额
                        ih.bindParam("total_line", realmoney);//应收金额

                        ih.bindParam("storageid", storageid);//保管账ID
                        ih.bindParam("useprice", price);//单价
                        ih.bindParam("placepointid", placepointid);//门店ID
                        ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                        ih.bindParam("resaprice", price);//单价
                        ih.bindParam("unitprice", price);//原单价
                        String zx_taxrate =getgoodstaxrate(con, placepointid, goodsid);
                        if(zx_taxrate.equals("")){
                            zx_taxrate = getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate");
                        }
                        ih.bindParam("taxrate", zx_taxrate);//税率
                        String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                        String presentflag="5".equals(accflag)?"1":"0";
                        ih.bindParam("presentflag",presentflag);//货品属性.
                        ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                        ih.bindParam("lotid",cansalemd.getItemValue(c, "lotid"));//货品批号ID.
                        ih.bindParam("batchid",cansalemd.getItemValue(c, "batchid"));//货品批次ID.
                        ih.bindParam("posid",cansalemd.getItemValue(c, "posid"));//货品货位ID.
                        ih.bindParam("goodsdtlid",cansalemd.getItemValue(c, "goodsdtlid"));//货品明细ID.
                        ih.bindParam("goodsstatusid","1");//货品状态
                        ih.bindParam("memo","该零售细单由接口订单生成！");//备注
                        ih.bindParam("clerkerid",cashierid);//营业员ID
                        ih.executeInsert(con);

                        String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                        if (presentflag.equals("0") || presstockflag.equals("1")) {
                            String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                            NpbusiDBHelper.gencerttmp(con, rsadtlid, "gresa_sa_dtl", "1", "1", transactionid);

                            String inoutid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_doc_seq");
                            ih = new InsertHelper("bms_st_io_doc_tmp");
                            ih.bindParam("inoutid",inoutid);
                            ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));
                            ih.bindParam("comefrom","40");//零售出
                            ih.bindParam("sourcetable","40");//零售出
                            ih.bindParam("sourceid",rsadtlid);
                            ih.bindParam("companyid",placepointid);//门店ID
                            ih.bindParam("companyname",getStorageID(con,placepointid).getItemValue(0, "placepointname"));//门店名称
                            ih.bindParam("goodsid",goodsid);//货品ID
                            ih.bindParam("storageid",storageid);//保管账ID
                            ih.bindParam("inoutflag","0");//出库标志 , 1代表入库
                            ih.bindParam("outqty",tmpqty);//出入库数量
                            ih.bindParam("oldqty",goodsqty);//原数量数量
                            ih.bindParam("goodsunit",getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                            ih.bindParam("usestatus", "1");//状态
                            ih.bindParam("entryid", getStorageID(con,placepointid).getItemValue(0, "entryid"));//独立单元ID
                            ih.executeInsert(con);

                            String iodtlid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_dtl_seq");
                            ih = new InsertHelper("bms_st_io_dtl_tmp");
                            ih.bindParam("inoutid",inoutid);//出库总单ID
                            ih.bindParam("iodtlid",iodtlid);//出库细单ID
                            ih.bindParam("lotid",cansalemd.getItemValue(c, "lotid"));//货品批号ID.
                            ih.bindParam("batchid",cansalemd.getItemValue(c, "batchid"));//货品批次ID.
                            ih.bindParam("posid",cansalemd.getItemValue(c, "posid"));//货品货位ID.
                            ih.bindParam("goodsdtlid",cansalemd.getItemValue(c, "goodsdtlid"));//货品明细ID.
                            ih.bindParam("goodsstatusid", "1");//货品状态
                            ih.bindParam("dtlgoodsqty", tmpqty);//货品数量
                            ih.executeInsert(con);

                            NptrDBHelper.keepout(con, inoutid, "0");//出库记账

                            accqty = DecimalHelper.add(accqty, tmpqty, 2);//已出库数量.
                        }
                    }
                }

                if(DecimalHelper.comparaDecimal(accqty, goodsqty) != 0){
                    System.out.println("当前货品ID【"+goodsid+"】的可销库存为【"+cansaleqty+"】,不够订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
                    throw new BopException("-1", "当前货品ID【"+goodsid+"】的可销库存为【"+accqty+"】,不够订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
                }
            }
        }else{
            System.out.println("当前货品ID【"+goodsid+"】已无库存！");
            throw new BopException("-1", "当前货品ID【"+goodsid+"】已无库存！");
        }
    }

    /**
     * 获取cansalemd中符合记录的条数.
     * @param cansalemd
     * @param goodsqty
     * @return
     */
    private int getModelRowCounts(DBTableModel cansalemd, String goodsqty) {
        String tmpqty = "";
        for(int count = 0; count < cansalemd.getRowCount(); count ++){
            tmpqty = DecimalHelper.add(cansalemd.getItemValue(count, "goodsqty"), tmpqty, 2);
            if(DecimalHelper.comparaDecimal(tmpqty, goodsqty) >= 0){
                return count+1;
            }
        }
        return 1;
    }

    /**
     * 获取逻辑日
     * @param con
     * @throws Exception
     */
    public static String getUseDay(Connection con) throws Exception{
        String useday = "";
        String sql = "select trunc(sysdate) from dual";
        SelectHelper sh = new SelectHelper(sql);
        DBTableModel usedaymodel = sh.executeSelect(con, 0, 1);
        useday = usedaymodel.getItemValue(0, 0).substring(0, 10);
        return useday;
    }
    /**
     * 获取班次
     * @param con
     */
    public static String getRsaClass(Connection con) throws Exception{
        String rsaclass = "";
        // 查询班次
        String sql = "select rsaclass from resa_class a order by "
                + "sign(to_date(to_char(sysdate,'yyyymmdd')||a.endhour||':'||a.endminute,'yyyymmddhh24:mi')-sysdate) desc,"
                + "sign(sysdate-to_date(to_char(sysdate,'yyyymmdd')||a.starthour||':'||a.startminute,'yyyymmddhh24:mi')) desc";
        SelectHelper sh = new SelectHelper(sql);
        DBTableModel model = sh.executeSelect(con);
        rsaclass = model.getItemValue(0, "rsaclass");
        return rsaclass;
    }
    /**
     * 根据门店获取门店的信息
     * @param con
     * @param placepointid
     */
    public static DBTableModel getStorageID(Connection con,String placepointid) throws Exception{
        String sql = "select * from gpcs_placepoint where placepointid = ?";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(placepointid);
        DBTableModel dbm = sh.executeSelect(con, 0, 1);
        return dbm;
    }
    /**
     * 查询货品信息
     * @param goodsid
     */
    public static DBTableModel getGoodsInfo(Connection con,String goodsid) throws Exception{
        DBTableModel goodsInfoModel = null;
        //查询货品信息
        String sql_otc = "select * from pub_goods t where t.goodsid = ?";
        SelectHelper sh = new SelectHelper(sql_otc);
        sh.bindParam(goodsid);
        goodsInfoModel = sh.executeSelect(con,0,1);
        if (goodsInfoModel == null || goodsInfoModel.getRowCount() == 0) {
            System.out.println("未查询到货品ID=" + goodsid + "的货品主档信息");
        }
        return goodsInfoModel;
    }

    /**
     * 小规模不同地区按照货品分类取税率
     * by ltq 20200601
     * @param con
     * @param placepointid
     * @param goodsid
     * @return
     * @throws Exception
     */
    private String getgoodstaxrate(Connection con, String placepointid,String goodsid) throws Exception {
        String goodstaxrate ="";
        String sql="select nvl(c.miniaturetaxpayerflag, 0),c.entryid " +
                "   from gpcs_placepoint c " +
                "   where placepointid = ? and nvl(c.miniaturetaxpayerflag, 0)=1 ";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(placepointid);
        DBTableModel checkmodel=sh.executeSelect(con, 0, 1);
        if(null!=checkmodel&&checkmodel.getRowCount()>0){
            String entryid = checkmodel.getItemValue(0, "entryid");
            String classtypeid="";
            if("2".equals(entryid)||"22".equals(entryid)){//平嘉地区和康利新
                classtypeid = "27";
            }else{
                classtypeid = "19999";
            }
            sql="select a.goodsid, b.taxrate " +
                    "  from pub_goods_class_dtl a, zx_minitaxpayersa_def b " +
                    " where a.classid = b.classid " +
                    "   and a.classtypeid = ? " +
                    "   and a.goodsid = ? " +
                    "   and b.entryid = ?";
            sh = new SelectHelper(sql);
            sh.bindParam(classtypeid);
            sh.bindParam(goodsid);
            sh.bindParam(entryid);
//			sh.bindParam(placepointid);
            DBTableModel serialModel=sh.executeSelect(con, 0, 1);
            if(null!=serialModel&&serialModel.getRowCount()>0){
                goodstaxrate = serialModel.getItemValue(0, "taxrate");
            }
        }
        return goodstaxrate;
    }

    @Override
    public String cancelOrder(String entryid, String xmldata) {
        APPLYORDERRESP resp = new APPLYORDERRESP();

        APPLYORDERREQ req = JAXBUtil.unmarshToObjBinding(APPLYORDERREQ.class, xmldata, "UTF-8");
        String placepointid = req.getPLACEPOINTID();
        Connection con = null;
        String sql = "";
        try {
            con = cerpzsdataSource.getConnection();
            con.setAutoCommit(false);
            if(DecimalHelper.comparaDecimal(req.getRECEIVALMONEY(), "0")>=0){
                System.out.println("退款订单【"+req.getZXORDERNO()+"】错误，应退金额不能应为0或正数！");
                throw new BopException("-2", "订单【"+req.getZXORDERNO()+"】错误，应收金额不能为0或正数！");
            }
            if(DecimalHelper.comparaDecimal(req.getREALMONEY(), "0")>=0){
                System.out.println("订单【"+req.getZXORDERNO()+"】错误，实退金额不能应为0或正数！");
                throw new BopException("-2", "订单【"+req.getZXORDERNO()+"】错误，实收金额不能为0或正数！");
            }
            if(!checkMoney(req)){
                System.out.println("订单【"+req.getZXORDERNO()+"】金额错误！");
                throw new BopException("-2", "订单【"+req.getZXORDERNO()+"】金额错误！");
            }
            //判断是否存在正向订单
            String zxsql = "select * from gresa_sa_doc where zx_orderno = ? and rsatype=1 ";
            SelectHelper docsh = new SelectHelper(zxsql);
            docsh.bindParam(req.getZXORDERNO());
            DBTableModel docmodel = docsh.executeSelect(con, 0, 1);
            if(null==docmodel||docmodel.getRowCount()==0){
                throw new BopException("-99", "该订单号未生成零售单，请勿重复发送！");
            }
            //判断是否是重复退货订单
            String thzxsql = "select * from gresa_sa_doc where zx_orderno = ? and rsatype=2 ";
            SelectHelper thdocsh = new SelectHelper(thzxsql);
            thdocsh.bindParam(req.getRETURNORDER());
            DBTableModel thdocmodel = thdocsh.executeSelect(con, 0, 1);
            if(null!=thdocmodel&&thdocmodel.getRowCount()>0){
                throw new BopException("-99", "该退货单已退货成功，请勿重复发送！");
            }
            String olddocid = docmodel.getItemValue(0,"rsaid");
            String storageid = getStorageID(con,placepointid).getItemValue(0, "storageid");//获取保管账ID
            String cashierid = req.getCASHIER();
            String docid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_doc_seq");//零售总单ID
            //生成零售总单.BEGIN.
            InsertHelper ih = new InsertHelper("gresa_sa_doc");
            ih.bindParam("rsaid", docid);
            ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));//创建时间
            ih.bindParam("placepointid", placepointid);//门店ID
            ih.bindParam("receivalmoney", req.getRECEIVALMONEY());//应收
            ih.bindParam("realmoney", req.getREALMONEY());//实收
            ih.bindParam("dtl_lines", String.valueOf(req.getPRODUCTS().getPRODUCT().size()));//细单条数
            ih.bindParam("usestatus", "1");//使用状态
            ih.bindDateParam("useday", getUseDay(con));//逻辑日
            ih.bindParam("cashierid", cashierid);//收款员ID
            ih.bindParam("rsaclass", getRsaClass(con));//班次
            ih.bindParam("zx_orderno", req.getRETURNORDER());//订单号.
//            ih.bindParam("zx_deductrealmoney", req.getRECEIVALMONEY());
            ih.bindParam("rsatype", "2");//
            ih.executeInsert(con);

            List<PRODUCT> lists = req.getPRODUCTS().getPRODUCT();
            for (PRODUCT pro : lists) {
                CreateBackSaDtl(con, pro, docid, olddocid, storageid, placepointid, cashierid, entryid);
            }
            //进行调价
//            tiaojia(con, docid, req.getRECEIVALMONEY());

            //生成收款明细数据
            InsertHelper payh = new InsertHelper("gresa_sa_lst");
            String rsalstid = NgpcsDBHelper.getSeqValue(con, "gresa_sa_lst_seq");
            payh.bindParam("rsalstid", rsalstid);
            payh.bindParam("rsaid", docid);
            payh.bindParam("gathertype", req.getGATHERTYPE());//先默认一个收款方式.线上微信支付.
            payh.bindParam("recmoney", req.getRECEIVALMONEY());//总单应收款
            payh.bindParam("realmoney",req.getREALMONEY());//总单实际收款
            payh.bindParam("changemoney", "0");
            payh.executeInsert(con);

            con.commit();
            resp.setRETURNCODE("0");
            resp.setRETURNMSG("退货成功");
        } catch (BopException e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            resp.setRETURNCODE("-1");
            resp.setRETURNMSG(e.getErrMsg());
        } catch (Exception e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            resp.setRETURNCODE("-1");
            resp.setRETURNMSG("退货失败");
        }finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        String retxml = "";
        try {
            retxml = JAXBUtil.marshToXmlBinding(APPLYORDERRESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    /**
     * 生成零售细单
     * @param con
     * @param pro
     * @param docid
     * @throws Exception
     */
    private void CreateBackSaDtl(Connection con, PRODUCT pro, String docid, String olddocid, String storageid, String placepointid, String cashierid, String entryid) throws Exception {
        String goodsid = pro.getGOODSID();
        String goodsqty = pro.getGOODSQTY();
        if(DecimalHelper.comparaDecimal(goodsqty, "0")>=0){
            System.out.println("货品【"+goodsid+"退货数量不能为0或正数！");
            throw new BopException("-2", "货品【"+goodsid+"】退货数量不能为0或正数！");
        }
        String price = pro.getUNITPRICE();
        String total_line = pro.getTOTALLINE();
        if(DecimalHelper.comparaDecimal(total_line, "0")>=0){
            System.out.println("货品【"+goodsid+"】明细总金额错误，明细总金额不能为0或正数！");
            throw new BopException("-2", "货品【"+goodsid+"】明细总金额错误，明细总金额不能为0或正数！");
        }
        String priceid = pro.getPRICEID();
        //查询当前门店该货品的可销库存.//出库时按近效期的批号规则出库.
        String sql = " select " +
                " a.rsadtlid, " +
                " a.goodsid, " +
                " a.useprice, " +
                " a.goodsqty, " +
                " sum(nvl(b.goodsqty,0)) sub_goodsqty, "+
                " a.total_line, " +
                " sum(b.total_line) sub_total_line, "+
                " a.realmoney, " +
                " sum(b.realmoney) sub_realmoney, " +
                " a.taxrate, " +
                " a.goodsunit, " +
                " a.lotid, " +
                " a.batchid, " +
                " a.posid, " +
                " a.goodsdtlid " +
                " from " +
                " gresa_sa_dtl a, gresa_sa_dtl b " +
                " where a.rsadtlid=b.oldrsadtlid(+)  " +
                " and a.rsaid=? " +
                " and a.goodsid=? " +
                " and a.useprice=? " +
                " group by a.rsadtlid,a.goodsid,a.useprice,a.goodsqty, " +
                " a.total_line,a.realmoney,a.taxrate,a.goodsunit,a.lotid,a.batchid,a.posid,a.goodsdtlid ";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(olddocid);
        sh.bindParam(goodsid);
        sh.bindParam(price);
        DBTableModel cansalemd = sh.executeSelect(con, 0, 9999);
        if(cansalemd != null && cansalemd.getRowCount() > 0){
            //获取cansalemd中符合出库的记录数.
            String accqty = goodsqty;//剩余退货数量
            for(int i=0;i<cansalemd.getRowCount();i++){
                if(DecimalHelper.comparaDecimal(accqty, "0")!=0){
                    String oldrsadtlid = cansalemd.getItemValue(i, "rsadtlid");
                    String tmpqty = DecimalHelper.add(cansalemd.getItemValue(i, "goodsqty"), cansalemd.getItemValue(i, "sub_goodsqty"), 2);
                    if(DecimalHelper.comparaDecimal(tmpqty, "0")>0){
                        if(DecimalHelper.comparaDecimal(DecimalHelper.add(accqty, tmpqty, 2), "0") <= 0){
                            //本条数据全部退货
                            String rsadtlid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_dtl_seq");
                            InsertHelper ih = new InsertHelper("gresa_sa_dtl");
                            ih.bindParam("rsadtlid", rsadtlid);//细单ID
                            ih.bindParam("rsaid",docid);//总单ID
                            ih.bindParam("goodsid", goodsid);//货品ID
                            ih.bindParam("goodsqty", DecimalHelper.sub("0", tmpqty, 2));//数量
                            String realmoney = DecimalHelper.multi(price, DecimalHelper.sub("0", tmpqty, 2), 2);
                            ih.bindParam("realmoney", realmoney);//实收金额
                            ih.bindParam("total_line", realmoney);//应收金额
                            ih.bindParam("storageid", storageid);//保管账ID
                            ih.bindParam("useprice", price);//单价
                            ih.bindParam("placepointid", placepointid);//门店ID
                            ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                            ih.bindParam("resaprice", price);//单价
                            ih.bindParam("unitprice", price);//原单价
                            ih.bindParam("oldrsadtlid", oldrsadtlid);//原零售单明细ID
                            String zx_taxrate =getgoodstaxrate(con, placepointid, goodsid);
                            if(zx_taxrate.equals("")){
                                zx_taxrate = getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate");
                            }
                            ih.bindParam("taxrate", zx_taxrate);//税率
                            String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                            String presentflag="5".equals(accflag)?"1":"0";
                            ih.bindParam("presentflag",presentflag);//货品属性.
                            ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                            ih.bindParam("lotid",cansalemd.getItemValue(i, "lotid"));//货品批号ID.
                            ih.bindParam("batchid",cansalemd.getItemValue(i, "batchid"));//货品批次ID.
                            ih.bindParam("posid",cansalemd.getItemValue(i, "posid"));//货品货位ID.
                            ih.bindParam("goodsdtlid",cansalemd.getItemValue(i, "goodsdtlid"));//货品明细ID.
                            ih.bindParam("goodsstatusid","1");//货品状态
                            ih.bindParam("memo","该零售细单由接口订单生成！");//备注
                            ih.bindParam("clerkerid",cashierid);//营业员ID
                            ih.executeInsert(con);

                            String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                            if (presentflag.equals("0") || presstockflag.equals("1")) {
                                String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                                NpbusiDBHelper.gencerttmp(con, rsadtlid, "gresa_sa_dtl", "1", "1", transactionid);

                                String inoutid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_doc_seq");
                                ih = new InsertHelper("bms_st_io_doc");
                                ih.bindParam("inoutid",inoutid);
                                ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));
                                ih.bindParam("comefrom","41");//零售退
                                ih.bindParam("sourcetable","40");//零售出
                                ih.bindParam("sourceid",rsadtlid);
                                ih.bindParam("companyid",placepointid);//门店ID
                                ih.bindParam("companyname",getStorageID(con,placepointid).getItemValue(0, "placepointname"));//门店名称
                                ih.bindParam("goodsid",goodsid);//货品ID
                                ih.bindParam("storageid",storageid);//保管账ID
                                ih.bindParam("inoutflag","1");//出库标志 , 1代表入库
                                ih.bindParam("inqty",tmpqty);//出入库数量
                                ih.bindParam("oldqty",DecimalHelper.sub("0", goodsqty, 2));//原数量数量
                                ih.bindParam("goodsunit",getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                                ih.bindParam("usestatus", "1");//状态
                                ih.bindParam("entryid", getStorageID(con,placepointid).getItemValue(0, "entryid"));//独立单元ID
                                ih.executeInsert(con);

                                String iodtlid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_dtl_seq");
                                ih = new InsertHelper("bms_st_io_dtl");
                                ih.bindParam("inoutid",inoutid);//出库总单ID
                                ih.bindParam("iodtlid",iodtlid);//出库细单ID
                                ih.bindParam("lotid",cansalemd.getItemValue(i, "lotid"));//货品批号ID.
                                ih.bindParam("batchid",cansalemd.getItemValue(i, "batchid"));//货品批次ID.
                                ih.bindParam("posid",cansalemd.getItemValue(i, "posid"));//货品货位ID.
                                ih.bindParam("goodsdtlid",cansalemd.getItemValue(i, "goodsdtlid"));//货品明细ID.
                                ih.bindParam("goodsstatusid", "1");//货品状态
                                ih.bindParam("dtlgoodsqty", tmpqty);//货品数量
                                ih.executeInsert(con);
                                NptrDBHelper.keepin(con, inoutid, "0");//出库记账
                            }
                            accqty = DecimalHelper.add(accqty, tmpqty, 2);
                        }else{

                            String rsadtlid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_dtl_seq");
                            InsertHelper ih = new InsertHelper("gresa_sa_dtl");
                            ih.bindParam("rsadtlid", rsadtlid);//细单ID
                            ih.bindParam("rsaid",docid);//总单ID
                            ih.bindParam("goodsid", goodsid);//货品ID
                            ih.bindParam("goodsqty", accqty);//数量
                            String realmoney = DecimalHelper.multi(price, accqty, 2);
                            ih.bindParam("realmoney", realmoney);//实收金额
                            ih.bindParam("total_line", realmoney);//应收金额
                            ih.bindParam("storageid", storageid);//保管账ID
                            ih.bindParam("useprice", price);//单价
                            ih.bindParam("placepointid", placepointid);//门店ID
                            ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                            ih.bindParam("resaprice", price);//单价
                            ih.bindParam("unitprice", price);//原单价
                            ih.bindParam("oldrsadtlid", oldrsadtlid);//原零售单明细ID
                            String zx_taxrate =getgoodstaxrate(con, placepointid, goodsid);
                            if(zx_taxrate.equals("")){
                                zx_taxrate = getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate");
                            }
                            ih.bindParam("taxrate", zx_taxrate);//税率
                            String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                            String presentflag="5".equals(accflag)?"1":"0";
                            ih.bindParam("presentflag",presentflag);//货品属性.
                            ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                            ih.bindParam("lotid",cansalemd.getItemValue(i, "lotid"));//货品批号ID.
                            ih.bindParam("batchid",cansalemd.getItemValue(i, "batchid"));//货品批次ID.
                            ih.bindParam("posid",cansalemd.getItemValue(i, "posid"));//货品货位ID.
                            ih.bindParam("goodsdtlid",cansalemd.getItemValue(i, "goodsdtlid"));//货品明细ID.
                            ih.bindParam("goodsstatusid","1");//货品状态
                            ih.bindParam("memo","该零售细单由接口订单生成！");//备注
                            ih.bindParam("clerkerid",cashierid);//营业员ID
                            ih.executeInsert(con);

                            String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                            if (presentflag.equals("0") || presstockflag.equals("1")) {
                                String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                                NpbusiDBHelper.gencerttmp(con, rsadtlid, "gresa_sa_dtl", "1", "1", transactionid);

                                String inoutid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_doc_seq");
                                ih = new InsertHelper("bms_st_io_doc");
                                ih.bindParam("inoutid",inoutid);
                                ih.bindDateParam("credate", NpbusiDBHelper.getSysdate(con));
                                ih.bindParam("comefrom","41");//零售退
                                ih.bindParam("sourcetable","40");//零售出
                                ih.bindParam("sourceid",rsadtlid);
                                ih.bindParam("companyid",placepointid);//门店ID
                                ih.bindParam("companyname",getStorageID(con,placepointid).getItemValue(0, "placepointname"));//门店名称
                                ih.bindParam("goodsid",goodsid);//货品ID
                                ih.bindParam("storageid",storageid);//保管账ID
                                ih.bindParam("inoutflag","1");//出库标志 , 1代表入库
                                ih.bindParam("inqty",DecimalHelper.sub("0", accqty, 2));//出入库数量
                                ih.bindParam("oldqty",DecimalHelper.sub("0", accqty, 2));//原数量数量
                                ih.bindParam("goodsunit",getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                                ih.bindParam("usestatus", "1");//状态
                                ih.bindParam("entryid", getStorageID(con,placepointid).getItemValue(0, "entryid"));//独立单元ID
                                ih.executeInsert(con);

                                String iodtlid = NpbusiDBHelper.getSeqValue(con, "bms_st_io_dtl_seq");
                                ih = new InsertHelper("bms_st_io_dtl");
                                ih.bindParam("inoutid",inoutid);//出库总单ID
                                ih.bindParam("iodtlid",iodtlid);//出库细单ID
                                ih.bindParam("lotid",cansalemd.getItemValue(i, "lotid"));//货品批号ID.
                                ih.bindParam("batchid",cansalemd.getItemValue(i, "batchid"));//货品批次ID.
                                ih.bindParam("posid",cansalemd.getItemValue(i, "posid"));//货品货位ID.
                                ih.bindParam("goodsdtlid",cansalemd.getItemValue(i, "goodsdtlid"));//货品明细ID.
                                ih.bindParam("goodsstatusid", "1");//货品状态
                                ih.bindParam("dtlgoodsqty", DecimalHelper.sub("0", accqty, 2));//货品数量
                                ih.executeInsert(con);
                                NptrDBHelper.keepin(con, inoutid, "0");//出库记账
                            }

                            accqty = "0";
                        }
                    }
                }
            }
            if(DecimalHelper.comparaDecimal(accqty, "0") != 0){
                System.out.println("当前货品ID【"+goodsid+"】退货数量大于未退数量.");
                throw new BopException("-1", "当前货品ID【"+goodsid+"】退货数量大于未退数量.");
            }

        }else{
            System.out.println("未在零售单中查到货品【"+goodsid+"】！");
            throw new BopException("-1", "未在零售单中查到货品【"+goodsid+"】！");
        }
    }


    private boolean checkMoney(APPLYORDERREQ req){
        String realmoney = req.getREALMONEY();
        String receivemoney = req.getRECEIVALMONEY();
        if(DecimalHelper.comparaDecimal(realmoney, receivemoney)!=0){
            return false;
        }
        String total = "";
        List<PRODUCT> lists = req.getPRODUCTS().getPRODUCT();
        for(int i=0;i<lists.size();i++){
            PRODUCT pro = lists.get(i);
            String prototallineline = pro.getTOTALLINE();
            if(DecimalHelper.comparaDecimal(prototallineline, pro.getREALMONEY())!=0){
                return false;
            }
            String totalline = DecimalHelper.multi(pro.getGOODSQTY(), pro.getUNITPRICE(),2);
            if(DecimalHelper.comparaDecimal(prototallineline, totalline)!=0){
                return false;
            }
            total = DecimalHelper.add(total, prototallineline, 2);
        }
        if(DecimalHelper.comparaDecimal(receivemoney, total)!=0){
            return false;
        }
        return true;
    }



}
