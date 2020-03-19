package org.ssm.dufy.service.impl;

import com.inca.np.gui.control.DBTableModel;
import com.inca.np.util.DecimalHelper;
import com.inca.np.util.DefaultNPParam;
import com.inca.np.util.InsertHelper;
import com.inca.np.util.SelectHelper;
import com.inca.npserver.dbcp.DBConnectPoolFactory;
import com.inca.pubsrv.NpbusiDBHelper;
import com.inca.pubsrv.NptrDBHelper;
import com.inca.resale.tools.NgpcsDBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.eleme.applyorder.ELMAPPLYORDERREQ;
import org.ssm.cxf.struct.eleme.applyorder.ELMAPPLYORDERRESP;
import org.ssm.cxf.struct.eleme.applyorder.Product;
import org.ssm.cxf.struct.eleme.classtype.Classtype;
import org.ssm.cxf.struct.eleme.classtype.Classtypes;
import org.ssm.cxf.struct.eleme.classtype.GOODSCLASSTYPEREQ;
import org.ssm.cxf.struct.eleme.classtype.GOODSCLASSTYPERESP;
import org.ssm.cxf.struct.eleme.goodsinfo.ELMGOODSREQ;
import org.ssm.cxf.struct.eleme.goodsinfo.ELMGOODSRESP;
import org.ssm.cxf.struct.eleme.goodsinfo.Goodslist;
import org.ssm.cxf.struct.eleme.goodsinfo.Item;
import org.ssm.cxf.struct.eleme.goodsprice.ELMGOODSPRICEREQ;
import org.ssm.cxf.struct.eleme.goodsprice.ELMGOODSPRICERESP;
import org.ssm.cxf.struct.eleme.goodsprice.GoodspriceItem;
import org.ssm.cxf.struct.eleme.goodsprice.Goodspricelist;
import org.ssm.cxf.struct.eleme.goodsqty.ELMGOODSQTYREQ;
import org.ssm.cxf.struct.eleme.goodsqty.ELMGOODSQTYRESP;
import org.ssm.cxf.struct.eleme.goodsqty.GoodsqtyItem;
import org.ssm.cxf.struct.eleme.goodsqty.Goodsqtylist;
import org.ssm.dufy.dao.IElemeDao;
import org.ssm.dufy.exception.BopException;
import org.ssm.dufy.service.IElemeService;

import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service("elemeService")
public class IElemeServiceImpl implements IElemeService {

    @Autowired
    private IElemeDao elemeDao;
    @Autowired
    private DataSource cerpzsdataSource;

    @Override
    public String getGoodsClassType(String entryid, String xmldata) {
        GOODSCLASSTYPEREQ req = JAXBUtil.unmarshToObjBinding(GOODSCLASSTYPEREQ.class, xmldata, "UTF-8");
        String classtypeid = req.getClasstypeid();
        entryid = req.getEntryid();
        String retxml = "";
        GOODSCLASSTYPERESP resp = new GOODSCLASSTYPERESP();
        List<Map<String,Object>> lists = elemeDao.getGoodsClassType(entryid, classtypeid);
        if(lists.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未查询到数据");
        }else{
            Classtypes classtypes = new Classtypes();
            resp.setClasstypes(classtypes);
            List<Classtype> list = resp.getClasstypes().getClasstype();
            for(Map<String,Object> map:lists){
                Classtype item = new Classtype();
                item.setClassid(StringUtil.doNullStr(map.get("CLASSID")));
                item.setClassname(StringUtil.doNullStr(map.get("CLASSNAME")));
                item.setLeafflag(StringUtil.doNullStr(map.get("LEAFFLAG")));
                list.add(item);
            }
            resp.setReturncode("0");
            resp.setReturnmsg("查询成功");
        }
        try {
            retxml = JAXBUtil.marshToXmlBinding(GOODSCLASSTYPERESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    @Override
    public String getGoodsInfo(String entryid, String xmldata) {
        ELMGOODSREQ req = JAXBUtil.unmarshToObjBinding(ELMGOODSREQ.class, xmldata, "UTF-8");
        String classid = req.getClassid();
        String placepointid = req.getPlacepointid();
        String priceid = req.getPriceid();
        entryid = req.getEntryid();
        String retxml = "";
        ELMGOODSRESP resp = new ELMGOODSRESP();
        List<Map<String,Object>> lists = elemeDao.getGoods(entryid, classid, placepointid, priceid);
        if(lists.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未查询到数据");
        }else{
            Goodslist goodslist = new Goodslist();
            resp.setGoodslist(goodslist);
            List<Item> list = resp.getGoodslist().getItem();
            for(Map<String,Object> map:lists){
                Item item = new Item();
                item.setPlacepointid(StringUtil.doNullStr(map.get("PLACEPOINTID")));
                item.setGoodsid(StringUtil.doNullStr(map.get("GOODSID")));
                item.setOpcode(StringUtil.doNullStr(map.get("OPCODE")));
                item.setGoodsname(StringUtil.doNullStr(map.get("GOODSNAME")));
                item.setGoodstype(StringUtil.doNullStr(map.get("GOODSTYPE")));
                item.setGoodsunit(StringUtil.doNullStr(map.get("GOODSUNIT")));
                item.setPriceunit(StringUtil.doNullStr(map.get("PRICEUNIT")));
                item.setBarcode(StringUtil.doNullStr(map.get("BARCODE")));
                item.setTrademark(StringUtil.doNullStr(map.get("TRADEMARK")));
                item.setPrice(StringUtil.doNullStr(map.get("PRICE")));
                item.setGoodstqty("0");
                list.add(item);
            }
            resp.setReturncode("0");
            resp.setReturnmsg("查询成功");
        }
        try {
            retxml = JAXBUtil.marshToXmlBinding(ELMGOODSRESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    @Override
    public String getGoodsQty(String entryid, String xmldata) {
        ELMGOODSQTYRESP resp = new ELMGOODSQTYRESP();
        ELMGOODSQTYREQ req = JAXBUtil.unmarshToObjBinding(ELMGOODSQTYREQ.class, xmldata, "UTF-8");
        String placepointid = req.getPlacepointid();
        String goodsidstr = req.getGoodsids();
        if(goodsidstr.length()<1){
            resp.setReturncode("-1");
            resp.setReturnmsg("货品ID不能为空");
        }
        String[] goodsids = goodsidstr.split(",");
        entryid = req.getEntryid();
        String retxml = "";
        List<Map<String,Object>> lists = elemeDao.getGoodsQty(entryid, placepointid,goodsids);
        if(lists.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未查询到数据");
        }else{
            Goodsqtylist goodslist = new Goodsqtylist();
            resp.setGoodsqtylist(goodslist);
            List<GoodsqtyItem> list = resp.getGoodsqtylist().getGoodsqtyItem();
            for(Map<String,Object> map:lists){
                GoodsqtyItem item = new GoodsqtyItem();
                item.setGoodsid(StringUtil.doNullStr(map.get("GOODSID")));
                item.setGoodsqty(StringUtil.doNullStr(map.get("GOODSQTY")));
                list.add(item);
            }
            resp.setReturncode("0");
            resp.setReturnmsg("查询成功");
        }
        try {
            retxml = JAXBUtil.marshToXmlBinding(ELMGOODSQTYRESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    @Override
    public String getGoodsPrice(String entryid, String xmldata) {
        ELMGOODSPRICERESP resp = new ELMGOODSPRICERESP();
        ELMGOODSPRICEREQ req = JAXBUtil.unmarshToObjBinding(ELMGOODSPRICEREQ.class, xmldata, "UTF-8");
        String placepointid = req.getPlacepointid();
        String priceid = req.getPriceid();
        String goodsidstr = req.getGoodsids();
        String[] goodsids = goodsidstr.split(",");
        if(goodsidstr.length()<1){
            resp.setReturncode("-1");
            resp.setReturnmsg("货品ID不能为空");
        }
        entryid = req.getEntryid();
        String retxml = "";
        List<Map<String,Object>> lists = elemeDao.getGoodsPrice(entryid, placepointid,priceid,goodsids);
        if(lists.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未查询到数据");
        }else{
            Goodspricelist goodslist = new Goodspricelist();
            resp.setGoodspricelist(goodslist);
            List<GoodspriceItem> list = resp.getGoodspricelist().getGoodspriceItem();
            for(Map<String,Object> map:lists){
                GoodspriceItem item = new GoodspriceItem();
                item.setGoodsid(StringUtil.doNullStr(map.get("GOODSID")));
                item.setPrice(StringUtil.doNullStr(map.get("PRICE")));
                list.add(item);
            }
            resp.setReturncode("0");
            resp.setReturnmsg("查询成功");
        }
        try {
            retxml = JAXBUtil.marshToXmlBinding(ELMGOODSPRICERESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

    @Override
    @Transactional
    public String createOrder(String entryid, String xmldata) {
        ELMAPPLYORDERRESP resp = new ELMAPPLYORDERRESP();

        ELMAPPLYORDERREQ req = JAXBUtil.unmarshToObjBinding(ELMAPPLYORDERREQ.class, xmldata, "UTF-8");
        String placepointid = req.getPlacepointid();
        Connection con = null;
        try {

            con = cerpzsdataSource.getConnection();
            String docid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_doc_seq");//零售总单ID
            //生成零售总单.BEGIN.
            InsertHelper ih = new InsertHelper("gresa_sa_doc");
            ih.bindParam("rsaid", docid);
            ih.bindDateParam("credate", TimeStampToDate(req.getCredate()));//创建时间
            ih.bindParam("placepointid", placepointid);//门店ID
            ih.bindParam("receivalmoney", req.getReceivalmoney());//应收
            ih.bindParam("realmoney", req.getRealmoney());//实收
            ih.bindParam("dtl_lines", String.valueOf(req.getProducts().getProduct().size()));//细单条数
            ih.bindParam("usestatus", "1");//使用状态
            ih.bindDateParam("useday", getUseDay(con));//逻辑日
            ih.bindParam("rsatype", "1");//销售类型 零售.
            ih.bindParam("cashierid", "0");//收款员ID 暂时定为系统管理员.
            ih.bindParam("rsaclass", getRsaClass(con));//班次
            ih.bindParam("zx_orderno", req.getZxOrderno());//微医订单号.
            ih.executeInsert(con);

            String storageid = getStorageID(con,placepointid).getItemValue(0, "storageid");//获取保管账ID
            if(storageid == null || storageid.equals("")){
               System.out.println("门店ID【"+placepointid+"】在INCA系统中不存在！");
               throw new BopException("-1", "门店ID【"+placepointid+"】在INCA系统中不存在！");
            }
            List<Product> lists = req.getProducts().getProduct();
            for (Product pro : lists) {
                CreateSaDtl(con, pro, docid, placepointid, req.getReceivalmoney(), storageid, req.getZxOrderno());
            }
            //生成收款明细数据
            InsertHelper payh = new InsertHelper("gresa_sa_lst");
            String rsalstid = NgpcsDBHelper.getSeqValue(con, "gresa_sa_lst_seq");
            payh.bindParam("rsalstid", rsalstid);
            payh.bindParam("rsaid", docid);
            payh.bindParam("gathertype", "120");//先默认一个收款方式.线上微信支付.
            payh.bindParam("recmoney", req.getReceivalmoney());//总单应收款
            payh.bindParam("realmoney",req.getReceivalmoney());//总单实际收款
            payh.bindParam("changemoney", "0");
            payh.executeInsert(con);

            con.commit();
            resp.setReturncode("0");
            resp.setReturnmsg("零售单生成成功");
        } catch (BopException e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            resp.setReturncode("-1");
            resp.setReturnmsg(e.getErrMsg());
        } catch (Exception e){
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            resp.setReturncode("-1");
            resp.setReturnmsg("生成零售单失败");
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        String retxml = "";
        try {
            retxml = JAXBUtil.marshToXmlBinding(ELMAPPLYORDERRESP.class, resp, "UTF-8");
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
     * @param orderid
     * @param storageid
     * @throws Exception
     */
    private void CreateSaDtl(Connection con, Product pro, String docid,String placepointid,String totalmoney, String storageid, String orderid) throws Exception {
        String goodsid = pro.getGoodsid();
        String goodsqty = pro.getGoodsqty();
        String unitprice = pro.getUnitprice();
        String priceid = pro.getPriceid();
        String cansaleqty = "";//可销库存数量
        //查询当前门店该货品的可销库存.//出库时按近效期的批号规则出库.
        String sql = "select * from resa_stqty_sum_v where goodsid = ? and nvl(accflag,0) = 1 and nvl(invaliddays,0) > 0 and nvl(statususeflag,0) = 1 and storageid = ? order by invaliddate";
        SelectHelper sh = new SelectHelper(sql);
        sh.bindParam(goodsid);
        sh.bindParam(storageid);
        DBTableModel cansalemd = sh.executeSelect(con, 0, 9999);
        if(cansalemd != null && cansalemd.getRowCount() > 0){
            if(cansalemd.getRowCount() == 1){//当只有一条可销库存记录时.
                cansaleqty = cansalemd.getItemValue(0, "goodsqty");
                if(DecimalHelper.comparaDecimal(cansaleqty, goodsqty) < 0){
                    System.out.println("当前货品ID【"+goodsid+"】的可销库存为【"+cansaleqty+"】,不够饿了么订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
                    throw new BopException("-1", "当前货品ID【"+goodsid+"】的可销库存为【"+cansaleqty+"】,不够饿了么订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
                }
                String rsadtlid = NpbusiDBHelper.getSeqValue(con, "gresa_sa_dtl_seq");
                InsertHelper ih = new InsertHelper("gresa_sa_dtl");
                ih.bindParam("rsadtlid", rsadtlid);//细单ID
                ih.bindParam("rsaid",docid);//总单ID
                ih.bindParam("goodsid", goodsid);//货品ID
                ih.bindParam("goodsqty", goodsqty);//数量
                ih.bindParam("total_line", DecimalHelper.multi(unitprice, goodsqty, 2));//应收金额
                ih.bindParam("realmoney", DecimalHelper.multi(unitprice, goodsqty, 2));//实收金额
                ih.bindParam("storageid", storageid);//保管账ID
                ih.bindParam("useprice", unitprice);//单价
                ih.bindParam("placepointid", placepointid);//门店ID
                ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                ih.bindParam("resaprice", unitprice);//单价
                ih.bindParam("unitprice", unitprice);//原单价
                ih.bindParam("taxrate", getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate"));//税率
                String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                String presentflag="5".equals(accflag)?"1":"0";
                ih.bindParam("presentflag",presentflag);//货品属性.
                ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                ih.bindParam("lotid",cansalemd.getItemValue(0, "lotid"));//货品批号ID.
                ih.bindParam("batchid",cansalemd.getItemValue(0, "batchid"));//货品批次ID.
                ih.bindParam("posid",cansalemd.getItemValue(0, "posid"));//货品货位ID.
                ih.bindParam("goodsdtlid",cansalemd.getItemValue(0, "goodsdtlid"));//货品明细ID.
                ih.bindParam("goodsstatusid","1");//货品状态
                ih.bindParam("memo","该零售细单由微医订单生成！");//备注
                ih.bindParam("clerkerid","0");//营业员ID
                ih.executeInsert(con);

                String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                if (presentflag.equals("0") || presstockflag.equals("1")) {
                    String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                    NpbusiDBHelper.gencerttmp(con, rsadtlid, "GRESA_SA_DTL", "1", "1", transactionid);

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
                        ih.bindParam("total_line", DecimalHelper.multi(unitprice, DecimalHelper.sub(goodsqty, accqty, 2), 2));//应收金额
                        ih.bindParam("realmoney", DecimalHelper.multi(unitprice, DecimalHelper.sub(goodsqty, accqty, 2), 2));//实收金额
                        ih.bindParam("storageid", storageid);//保管账ID
                        ih.bindParam("useprice", unitprice);//单价
                        ih.bindParam("placepointid", placepointid);//门店ID
                        ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                        ih.bindParam("resaprice", unitprice);//单价
                        ih.bindParam("unitprice", unitprice);//原单价
                        ih.bindParam("taxrate", getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate"));//税率
                        String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                        String presentflag="5".equals(accflag)?"1":"0";
                        ih.bindParam("presentflag",presentflag);//货品属性.
                        ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                        ih.bindParam("lotid",cansalemd.getItemValue(c, "lotid"));//货品批号ID.
                        ih.bindParam("batchid",cansalemd.getItemValue(c, "batchid"));//货品批次ID.
                        ih.bindParam("posid",cansalemd.getItemValue(c, "posid"));//货品货位ID.
                        ih.bindParam("goodsdtlid",cansalemd.getItemValue(c, "goodsdtlid"));//货品明细ID.
                        ih.bindParam("goodsstatusid","1");//货品状态
                        ih.bindParam("memo","该零售细单由饿了么订单生成！");//备注
                        ih.bindParam("clerkerid","0");//营业员ID
                        ih.executeInsert(con);

                        String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                        if (presentflag.equals("0") || presstockflag.equals("1")) {
                            String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                            NpbusiDBHelper.gencerttmp(con, rsadtlid, "GRESA_SA_DTL", "1", "1", transactionid);

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
                        ih.bindParam("total_line", DecimalHelper.multi(unitprice, tmpqty, 2));//应收金额
                        ih.bindParam("realmoney", DecimalHelper.multi(unitprice, tmpqty, 2));//实收金额
                        ih.bindParam("storageid", storageid);//保管账ID
                        ih.bindParam("useprice", unitprice);//单价
                        ih.bindParam("placepointid", placepointid);//门店ID
                        ih.bindParam("priceid", priceid);//价格类型ID 默认为2-公司零售价
                        ih.bindParam("resaprice", unitprice);//单价
                        ih.bindParam("unitprice", unitprice);//原单价
                        ih.bindParam("taxrate", getGoodsInfo(con,goodsid).getItemValue(0, "salestaxrate"));//税率
                        String accflag = getGoodsInfo(con,goodsid).getItemValue(0, "accflag");
                        String presentflag="5".equals(accflag)?"1":"0";
                        ih.bindParam("presentflag",presentflag);//货品属性.
                        ih.bindParam("goodsunit", getGoodsInfo(con,goodsid).getItemValue(0, "goodsunit"));//基本单位
                        ih.bindParam("lotid",cansalemd.getItemValue(c, "lotid"));//货品批号ID.
                        ih.bindParam("batchid",cansalemd.getItemValue(c, "batchid"));//货品批次ID.
                        ih.bindParam("posid",cansalemd.getItemValue(c, "posid"));//货品货位ID.
                        ih.bindParam("goodsdtlid",cansalemd.getItemValue(c, "goodsdtlid"));//货品明细ID.
                        ih.bindParam("goodsstatusid","1");//货品状态
                        ih.bindParam("memo","该零售细单由饿了么订单生成！");//备注
                        ih.bindParam("clerkerid","0");//营业员ID
                        ih.executeInsert(con);

                        String presstockflag = getStorageID(con,placepointid).getItemValue(0, "presstockflag");
                        if (presentflag.equals("0") || presstockflag.equals("1")) {
                            String transactionid = NpbusiDBHelper.getSeqValue(con, "BMS_CERT_DTL_TMP_TRANS_SEQ");
                            NpbusiDBHelper.gencerttmp(con, rsadtlid, "GRESA_SA_DTL", "1", "1", transactionid);

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
                    System.out.println("当前货品ID【"+goodsid+"】的可销库存为【"+cansaleqty+"】,不够饿了么订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
                    throw new BopException("-1", "当前货品ID【"+goodsid+"】的可销库存为【"+accqty+"】,不够饿了么订单【"+orderid+"】的出库数量【"+goodsqty+"】.");
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
     * Unix时间戳转换成日期.
     * @param timestampString
     * @return
     */
    public static String TimeStampToDate(String timestampString) {
        Long timestamp = Long.parseLong(timestampString);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(timestamp));
        return date;
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
}