package org.ssm.dufy.service;

public interface ICommonIntefaceServcie {

    public String getGoodsQty(String entryid, String xmldata);

    public String createOrder(String entryid, String xmldata);

    public String cancelOrder(String entryid, String xmldata);

}
