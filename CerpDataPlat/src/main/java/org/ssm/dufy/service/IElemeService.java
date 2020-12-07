package org.ssm.dufy.service;

import org.ssm.cxf.struct.eleme.applyorder.ELMAPPLYORDERREQ;
import org.ssm.cxf.struct.eleme.applyorder.ELMAPPLYORDERRESP;

public interface IElemeService {

    public String getGoodsClassType(String entryid, String xmldata);

    public String getGoodsInfo(String entryid, String xmldata);

    public String getGoodsQty(String entryid, String xmldata);

    public String getGoodsPrice(String entryid, String xmldata);

    public String getGoodsQtyByClasstypeid(String entryid, String xmldata);

    public String getGoodsPriceByClasstypeid(String entryid, String xmldata);

    public String createOrder(String entryid, String xmldata);

    public ELMAPPLYORDERRESP createOrder(String entryid, ELMAPPLYORDERREQ req);

    public String getUsers(String entryid, String xmldata);


}
