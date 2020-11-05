/**
 * Copyright 2020 bejson.com
 */
package org.ssm.cxf.struct.pjyj.recv;
import java.util.List;

/**
 * Auto-generated: 2020-10-20 14:56:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RecInfoJsonBean {

    private String orderno;
    private String broker;
    private List<Goods> goods;
    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
    public String getOrderno() {
        return orderno;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }
    public String getBroker() {
        return broker;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
    public List<Goods> getGoods() {
        return goods;
    }

}