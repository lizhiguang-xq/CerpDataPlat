package org.ssm.dufy.bean.duomai;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Detail {

    private String unit;
    private String upc;
    private String weight;
    @JsonProperty("product_fee")
    private String productFee;
    @JsonProperty("sku_id")
    private String skuId;
    private String id;
    @JsonProperty("product_price")
    private String productPrice;
    @JsonProperty("sub_order_id")
    private String subOrderId;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_amount")
    private int productAmount;
    public void setUnit(String unit) {
         this.unit = unit;
     }
     public String getUnit() {
         return unit;
     }

    public void setUpc(String upc) {
         this.upc = upc;
     }
     public String getUpc() {
         return upc;
     }

    public void setWeight(String weight) {
         this.weight = weight;
     }
     public String getWeight() {
         return weight;
     }

    public void setProductFee(String productFee) {
         this.productFee = productFee;
     }
     public String getProductFee() {
         return productFee;
     }

    public void setSkuId(String skuId) {
         this.skuId = skuId;
     }
     public String getSkuId() {
         return skuId;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setProductPrice(String productPrice) {
         this.productPrice = productPrice;
     }
     public String getProductPrice() {
         return productPrice;
     }

    public void setSubOrderId(String subOrderId) {
         this.subOrderId = subOrderId;
     }
     public String getSubOrderId() {
         return subOrderId;
     }

    public void setOrderId(String orderId) {
         this.orderId = orderId;
     }
     public String getOrderId() {
         return orderId;
     }

    public void setProductName(String productName) {
         this.productName = productName;
     }
     public String getProductName() {
         return productName;
     }

    public void setProductAmount(int productAmount) {
         this.productAmount = productAmount;
     }
     public int getProductAmount() {
         return productAmount;
     }

}