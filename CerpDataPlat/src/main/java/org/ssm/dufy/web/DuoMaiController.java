package org.ssm.dufy.web;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.ssm.common.utility.DecimalUtils;
import org.ssm.cxf.struct.eleme.applyorder.ELMAPPLYORDERREQ;
import org.ssm.cxf.struct.eleme.applyorder.ELMAPPLYORDERRESP;
import org.ssm.cxf.struct.eleme.applyorder.Product;
import org.ssm.cxf.struct.eleme.applyorder.Products;
import org.ssm.dufy.bean.duomai.Detail;
import org.ssm.dufy.bean.duomai.DuoMaiGresaOrder;
import org.ssm.dufy.bean.duomai.DuoMaiRetMsg;
import org.ssm.dufy.service.IElemeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/DuoMai")
public class DuoMaiController {

    @Autowired
    private IElemeService elemeService;

    private static Logger logger = LoggerFactory.getLogger("loger");

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public DuoMaiRetMsg createOrder(@RequestBody DuoMaiGresaOrder gresaOrder,
                              @RequestHeader(value="x-authorization") String authorization){

        logger.info(JSONObject.toJSONString(gresaOrder));
        DuoMaiRetMsg retMsg = new DuoMaiRetMsg();
        String platform = gresaOrder.getPlatform().toLowerCase();
        ELMAPPLYORDERREQ req = new ELMAPPLYORDERREQ();
        req.setPlacepointid(gresaOrder.getStoreId());
        req.setCredate(gresaOrder.getOrderTime());
        req.setZxOrderno(gresaOrder.getOrderId());
        req.setReceivalmoney(DecimalUtils.divide(gresaOrder.getTotalAmount(),"100",2));
        req.setRealmoney(DecimalUtils.divide(gresaOrder.getPredictTotal(),"100",2));
        req.setTotalmoney(DecimalUtils.divide(gresaOrder.getTotalAmount(),"100",2));
        if("ebai".equals(platform)) {
            req.setGathertype("144");
        } else if ("meituan".equals(platform)) {
            req.setGathertype("102");
        }else if ("jd".equals(platform)) {
            req.setGathertype("145");
        } else {
            retMsg.setReturnStatus("Error");
            retMsg.setReturnMessage("平台类型platform不支持");
            return retMsg;
        }
        req.setCashier("0");
        req.setEntryid("2");
        Products products = new Products();
        List<Product> productList = new ArrayList<Product>();
        for(Detail detail : gresaOrder.getDetail()) {
            Product product = new Product();
            product.setGoodsid(detail.getSkuId());
            product.setGoodsqty(String.valueOf(detail.getProductAmount()));
            product.setRealmoney(DecimalUtils.divide(DecimalUtils.multi(detail.getProductFee(), String.valueOf(detail.getProductAmount()),0),"100",2));
            product.setTotalLine(DecimalUtils.divide(DecimalUtils.multi(detail.getProductFee(), String.valueOf(detail.getProductAmount()),0),"100",2));
            product.setPriceid("2");
            product.setUnitprice(DecimalUtils.divide(detail.getProductFee(),"100",2));
            productList.add(product);
        }
        products.setProduct(productList);
        req.setProducts(products);

        ELMAPPLYORDERRESP resp = elemeService.createOrder("2", req);

        if("0".equals(resp.getReturncode())) {
            retMsg.setReturnStatus("Success");
            retMsg.setReturnMessage("保存成功");
        } else {
            retMsg.setReturnStatus("Error");
            retMsg.setReturnMessage(resp.getReturnmsg());
        }
        return retMsg;
    }
}
