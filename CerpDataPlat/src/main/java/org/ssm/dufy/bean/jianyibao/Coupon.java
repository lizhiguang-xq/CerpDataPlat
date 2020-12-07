package org.ssm.dufy.bean.jianyibao;

public class Coupon {

    private String vipNo;
    private String couponNum;
    private String orderId;
    private String useTime;
    private String status;
    public void setVipNo(String vipNo) {
        this.vipNo = vipNo;
    }
    public String getVipNo() {
        return vipNo;
    }

    public void setCouponNum(String couponNum) {
        this.couponNum = couponNum;
    }
    public String getCouponNum() {
        return couponNum;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }
    public String getUseTime() {
        return useTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

}