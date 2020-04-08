package org.ssm.dufy.service;

public interface IElemeService {

    public String getGoodsClassType(String entryid, String xmldata);

    public String getGoodsInfo(String entryid, String xmldata);

    public String getGoodsQty(String entryid, String xmldata);

    public String getGoodsPrice(String entryid, String xmldata);

    public String createOrder(String entryid, String xmldata);

    public String getUsers(String entryid, String xmldata);


}
