package org.ssm.dufy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.goodsinfo_normal.GOODSINFONORMALREQ;
import org.ssm.cxf.struct.goodsinfo_normal.GOODSINFONORMALRESP;
import org.ssm.cxf.struct.goodsinfo_normal.GoodsItem;
import org.ssm.cxf.struct.goodsinfo_normal.GoodsinfoNormal;
import org.ssm.cxf.struct.salesinfo_normal.SALESINFONORMALREQ;
import org.ssm.cxf.struct.salesinfo_normal.SALESINFONORMALRESP;
import org.ssm.cxf.struct.salesinfo_normal.SalesNormal;
import org.ssm.cxf.struct.salesinfo_normal.SalseItem;
import org.ssm.dufy.dao.IGoodsDao;
import org.ssm.dufy.dao.ISalesInfoDao;
import org.ssm.dufy.service.ISalesInfoService;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Map;

@Service
public class SalesInfoServiceImpl implements ISalesInfoService {


    @Autowired
    public ISalesInfoDao salesinfodao;

    @Override
    public String selectNotTranslateCodeAndNotApplyOrderSalesInfo(String entryid, String xmldata) {
        SALESINFONORMALREQ req = JAXBUtil.unmarshToObjBinding(SALESINFONORMALREQ.class, xmldata, "UTF-8");
        String salesid = req.getSalesid();
        entryid = req.getEntryid();
        String retxml = "";
        SALESINFONORMALRESP resp = new SALESINFONORMALRESP();
        List<Map<String,Object>> lists = salesinfodao.selectNotTranslateCodeAndNotApplyOrderAndOnlyUpload(entryid, salesid);
        if(lists.size()==0){
            resp.setReturncode("-1");
            resp.setReturnmsg("未查询到数据");
        }else{
            SalesNormal sales = new SalesNormal();
            resp.setSalesNormal(sales);
            List<SalseItem> list = resp.getSalesNormal().getSalseItem();
            for(Map<String,Object> map:lists){
                SalseItem item = new SalseItem();
                item.setEntryid(StringUtil.doNullStr(map.get("ENTRYID")));   //独立单元id
                item.setCustomid(StringUtil.doNullStr(map.get("CUSTOMID")));  //客户ID  NUMBER(10)
                item.setCustomname(StringUtil.doNullStr(map.get("CUSTOMNAME")));  //客户名称 VARCHAR2(200)
                item.setSalesid(StringUtil.doNullStr(map.get("SALESID")));  //销售单号 NUMBER(10)
                item.setSalesdtlid(StringUtil.doNullStr(map.get("SALESDTLID")));   //销售细单单号  NUMBER(10)
                item.setIodtlid(StringUtil.doNullStr(map.get("IODTLID")));   //出库细单单号（确定唯一性）  NUMBER(10)
                item.setGoodsid(StringUtil.doNullStr(map.get("GOODSID")));  //货品ID  NUMBER(10)
                item.setGoodsname(StringUtil.doNullStr(map.get("GOODSNAME")));  //通用名  VARCHAR2(100)
                item.setGoodstype(StringUtil.doNullStr(map.get("GOODSTYPE")));   //规格  VARCHAR2(200)
                item.setGoodsunit(StringUtil.doNullStr(map.get("GOODSUNIT")));  //单位 VARCHAR2(10)
                item.setPackname(StringUtil.doNullStr(map.get("PACKNAME"))); //外包装单位 VARCHAR2(10)
                item.setPacksize(StringUtil.doNullStr(map.get("PACKSIZE"))); //转换率 NUMBER(16,6)
                item.setUnitprice(StringUtil.doNullStr(map.get("UNITPRICE")));  //含税单价  NUMBER(20,10)
                item.setDtlgoodsqty(StringUtil.doNullStr(map.get("DTLGOODSQTY")));  //数量 NUMBER(16,6)
                item.setLotno(StringUtil.doNullStr(map.get("LOTNO")));  //批号  VARCHAR2(100)
                item.setProddate(StringUtil.doNullStr(map.get("PRODDATE")));  //生产日期
                item.setInvaliddate(StringUtil.doNullStr(map.get("INVALIDDATE")));  //有效期
                item.setSxq(StringUtil.doNullStr(map.get("SXQ")));  //失效期
                item.setKilllotno(StringUtil.doNullStr(map.get("KILLLOTNO"))); //灭菌批号
                item.setKilldate(StringUtil.doNullStr(map.get("KILLDATE"))); //灭菌日期
                item.setInvcode(StringUtil.doNullStr(map.get("INVCODE")));  //发票代码 VARCHAR2(20)
                item.setInvno(StringUtil.doNullStr(map.get("INVNO")));  //发票号  VARCHAR2(20)
                item.setInvtype(StringUtil.doNullStr(map.get("INVTYPE"))); //发票类型
                item.setZxJsdate(StringUtil.doNullStr(map.get("ZXJSDATE")));  //发票日期  DATE
                item.setCredate(StringUtil.doNullStr(map.get("CREDATE")));    //业务日期
                item.setTotal(StringUtil.doNullStr(map.get("TOTAL")));      //总金额
                item.setTaxrate(StringUtil.doNullStr(map.get("TAXRATE")));  //税率 NUMBER(3,2)
                item.setDtlLines(StringUtil.doNullStr(map.get("DTLLINES"))); //细单条数
                list.add(item);
            }
            resp.setReturncode("0");
            resp.setReturnmsg("查询成功");
        }
        try {
            retxml = JAXBUtil.marshToXmlBinding(SALESINFONORMALRESP.class, resp, "UTF-8");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return retxml;
    }

}
