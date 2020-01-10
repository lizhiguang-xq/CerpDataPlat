//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.01.07 时间 01:50:25 PM CST 
//


package org.ssm.cxf.struct.salesinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}salesid"/>
 *         &lt;element ref="{}salesdtlid"/>
 *         &lt;element ref="{}stiodate"/>
 *         &lt;element ref="{}goodsname"/>
 *         &lt;element ref="{}currencyname"/>
 *         &lt;element ref="{}goodstype"/>
 *         &lt;element ref="{}goodsunit"/>
 *         &lt;element ref="{}factoryname"/>
 *         &lt;element ref="{}lotno"/>
 *         &lt;element ref="{}goodsqty"/>
 *         &lt;element ref="{}unitprice"/>
 *         &lt;element ref="{}amount"/>
 *         &lt;element ref="{}proddate"/>
 *         &lt;element ref="{}invaliddate"/>
 *         &lt;element ref="{}zx_outersys_orderid"/>
 *         &lt;element ref="{}zx_outersys_orderindex"/>
 *         &lt;element ref="{}storageid"/>
 *         &lt;element ref="{}invcode"/>
 *         &lt;element ref="{}invno"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "salesid",
    "salesdtlid",
    "stiodate",
    "goodsid",
    "goodsname",
    "currencyname",
    "goodstype",
    "goodsunit",
    "factoryname",
    "lotno",
    "goodsqty",
    "unitprice",
    "amount",
    "proddate",
    "invaliddate",
    "zxOutersysOrderid",
    "zxOutersysOrderindex",
    "storageid",
    "invcode",
    "invno"
})
@XmlRootElement(name = "detail")
public class Detail {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String salesid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String salesdtlid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String stiodate;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsname;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String currencyname;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodstype;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsunit;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String factoryname;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String lotno;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsqty;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String unitprice;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String amount;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String proddate;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String invaliddate;
    @XmlElement(name = "zx_outersys_orderid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysOrderid;
    @XmlElement(name = "zx_outersys_orderindex", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysOrderindex;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String storageid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String invcode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String invno;

    /**
     * 获取salesid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesid() {
        return salesid;
    }

    /**
     * 设置salesid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesid(String value) {
        this.salesid = value;
    }

    /**
     * 获取salesdtlid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesdtlid() {
        return salesdtlid;
    }

    /**
     * 设置salesdtlid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesdtlid(String value) {
        this.salesdtlid = value;
    }

    /**
     * 获取stiodate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStiodate() {
        return stiodate;
    }

    /**
     * 设置stiodate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStiodate(String value) {
        this.stiodate = value;
    }

    /**
     * 获取goodsid属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGoodsid() {
        return goodsid;
    }

    /**
     * 设置goodsid属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGoodsid(String value) {
        this.goodsid = value;
    }

    /**
     * 获取goodsname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsname() {
        return goodsname;
    }

    /**
     * 设置goodsname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsname(String value) {
        this.goodsname = value;
    }

    /**
     * 获取currencyname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyname() {
        return currencyname;
    }

    /**
     * 设置currencyname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyname(String value) {
        this.currencyname = value;
    }

    /**
     * 获取goodstype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodstype() {
        return goodstype;
    }

    /**
     * 设置goodstype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodstype(String value) {
        this.goodstype = value;
    }

    /**
     * 获取goodsunit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsunit() {
        return goodsunit;
    }

    /**
     * 设置goodsunit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsunit(String value) {
        this.goodsunit = value;
    }

    /**
     * 获取factoryname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactoryname() {
        return factoryname;
    }

    /**
     * 设置factoryname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactoryname(String value) {
        this.factoryname = value;
    }

    /**
     * 获取lotno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLotno() {
        return lotno;
    }

    /**
     * 设置lotno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLotno(String value) {
        this.lotno = value;
    }

    /**
     * 获取goodsqty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsqty() {
        return goodsqty;
    }

    /**
     * 设置goodsqty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsqty(String value) {
        this.goodsqty = value;
    }

    /**
     * 获取unitprice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitprice() {
        return unitprice;
    }

    /**
     * 设置unitprice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitprice(String value) {
        this.unitprice = value;
    }

    /**
     * 获取amount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * 获取proddate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProddate() {
        return proddate;
    }

    /**
     * 设置proddate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProddate(String value) {
        this.proddate = value;
    }

    /**
     * 获取invaliddate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvaliddate() {
        return invaliddate;
    }

    /**
     * 设置invaliddate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvaliddate(String value) {
        this.invaliddate = value;
    }

    /**
     * 获取zxOutersysOrderid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysOrderid() {
        return zxOutersysOrderid;
    }

    /**
     * 设置zxOutersysOrderid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysOrderid(String value) {
        this.zxOutersysOrderid = value;
    }

    /**
     * 获取zxOutersysOrderindex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysOrderindex() {
        return zxOutersysOrderindex;
    }

    /**
     * 设置zxOutersysOrderindex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysOrderindex(String value) {
        this.zxOutersysOrderindex = value;
    }

    /**
     * 获取storageid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStorageid() {
        return storageid;
    }

    /**
     * 设置storageid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStorageid(String value) {
        this.storageid = value;
    }

    /**
     * 获取invcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvcode() {
        return invcode;
    }

    /**
     * 设置invcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvcode(String value) {
        this.invcode = value;
    }

    /**
     * 获取invno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvno() {
        return invno;
    }

    /**
     * 设置invno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvno(String value) {
        this.invno = value;
    }

}
