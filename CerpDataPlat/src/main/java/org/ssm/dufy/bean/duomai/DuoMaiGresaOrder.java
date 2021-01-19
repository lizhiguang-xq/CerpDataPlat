package org.ssm.dufy.bean.duomai;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class DuoMaiGresaOrder {

    @JsonProperty("store_id")
    private String storeId;
    @JsonProperty("total_number")
    private String totalNumber;
    @JsonProperty("total_amount")
    private String totalAmount;
    @JsonProperty("pay_type")
    private String payType;
    private List<Detail> detail;
    private int id;
    @JsonProperty("order_time")
    private String orderTime;
    @JsonProperty("predict_total")
    private String predictTotal;
    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("order_id")
    private String orderId;
    private String platform;
    public void setStoreId(String storeId) {
         this.storeId = storeId;
     }
     public String getStoreId() {
         return storeId;
     }

    public void setTotalNumber(String totalNumber) {
         this.totalNumber = totalNumber;
     }
     public String getTotalNumber() {
         return totalNumber;
     }

    public void setTotalAmount(String totalAmount) {
         this.totalAmount = totalAmount;
     }
     public String getTotalAmount() {
         return totalAmount;
     }

    public void setPayType(String payType) {
         this.payType = payType;
     }
     public String getPayType() {
         return payType;
     }

    public void setDetail(List<Detail> detail) {
         this.detail = detail;
     }
     public List<Detail> getDetail() {
         return detail;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setOrderTime(String orderTime) {
         this.orderTime = orderTime;
     }
     public String getOrderTime() {
         return orderTime;
     }

    public void setPredictTotal(String predictTotal) {
         this.predictTotal = predictTotal;
     }
     public String getPredictTotal() {
         return predictTotal;
     }

    public void setAppId(String appId) {
         this.appId = appId;
     }
     public String getAppId() {
         return appId;
     }

    public void setOrderId(String orderId) {
         this.orderId = orderId;
     }
     public String getOrderId() {
         return orderId;
     }

    public void setPlatform(String platform) {
         this.platform = platform;
     }
     public String getPlatform() {
         return platform;
     }

}