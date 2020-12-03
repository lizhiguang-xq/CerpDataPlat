//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.11.13 时间 04:30:16 PM CST 
//


package org.ssm.cxf.struct.common.order;

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
 *         &lt;element ref="{}PLACEPOINTID"/>
 *         &lt;element ref="{}CREDATE"/>
 *         &lt;element ref="{}RECEIVALMONEY"/>
 *         &lt;element ref="{}REALMONEY"/>
 *         &lt;element ref="{}DTL_LINE"/>
 *         &lt;element ref="{}ZX_ORDERNO"/>
 *         &lt;element ref="{}CASHIER"/>
 *         &lt;element ref="{}GATHERTYPE"/>
 *         &lt;element ref="{}BUYERNAME"/>
 *         &lt;element ref="{}BUYERPHONE"/>
 *         &lt;element ref="{}SEX"/>
 *         &lt;element ref="{}MEMO"/>
 *         &lt;element ref="{}RETURNORDER"/>
 *         &lt;element ref="{}PRODUCTS"/>
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
    "placepointid",
    "credate",
    "receivalmoney",
    "realmoney",
    "dtlline",
    "zxorderno",
    "cashier",
    "gathertype",
    "buyername",
    "buyerphone",
    "sex",
    "memo",
    "returnorder",
    "products"
})
@XmlRootElement(name = "APPLYORDER_REQ")
public class APPLYORDERREQ {

    @XmlElement(name = "PLACEPOINTID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String placepointid;
    @XmlElement(name = "CREDATE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String credate;
    @XmlElement(name = "RECEIVALMONEY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String receivalmoney;
    @XmlElement(name = "REALMONEY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String realmoney;
    @XmlElement(name = "DTL_LINE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String dtlline;
    @XmlElement(name = "ZX_ORDERNO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxorderno;
    @XmlElement(name = "CASHIER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String cashier;
    @XmlElement(name = "GATHERTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String gathertype;
    @XmlElement(name = "BUYERNAME", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String buyername;
    @XmlElement(name = "BUYERPHONE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String buyerphone;
    @XmlElement(name = "SEX", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String sex;
    @XmlElement(name = "MEMO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String memo;
    @XmlElement(name = "RETURNORDER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String returnorder;
    @XmlElement(name = "PRODUCTS", required = true)
    protected PRODUCTS products;

    /**
     * 获取placepointid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLACEPOINTID() {
        return placepointid;
    }

    /**
     * 设置placepointid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLACEPOINTID(String value) {
        this.placepointid = value;
    }

    /**
     * 获取credate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDATE() {
        return credate;
    }

    /**
     * 设置credate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDATE(String value) {
        this.credate = value;
    }

    /**
     * 获取receivalmoney属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECEIVALMONEY() {
        return receivalmoney;
    }

    /**
     * 设置receivalmoney属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECEIVALMONEY(String value) {
        this.receivalmoney = value;
    }

    /**
     * 获取realmoney属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREALMONEY() {
        return realmoney;
    }

    /**
     * 设置realmoney属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREALMONEY(String value) {
        this.realmoney = value;
    }

    /**
     * 获取dtlline属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDTLLINE() {
        return dtlline;
    }

    /**
     * 设置dtlline属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDTLLINE(String value) {
        this.dtlline = value;
    }

    /**
     * 获取zxorderno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZXORDERNO() {
        return zxorderno;
    }

    /**
     * 设置zxorderno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZXORDERNO(String value) {
        this.zxorderno = value;
    }

    /**
     * 获取cashier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCASHIER() {
        return cashier;
    }

    /**
     * 设置cashier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCASHIER(String value) {
        this.cashier = value;
    }

    /**
     * 获取gathertype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGATHERTYPE() {
        return gathertype;
    }

    /**
     * 设置gathertype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGATHERTYPE(String value) {
        this.gathertype = value;
    }

    /**
     * 获取buyername属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUYERNAME() {
        return buyername;
    }

    /**
     * 设置buyername属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUYERNAME(String value) {
        this.buyername = value;
    }

    /**
     * 获取buyerphone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUYERPHONE() {
        return buyerphone;
    }

    /**
     * 设置buyerphone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUYERPHONE(String value) {
        this.buyerphone = value;
    }

    /**
     * 获取sex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEX() {
        return sex;
    }

    /**
     * 设置sex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEX(String value) {
        this.sex = value;
    }

    /**
     * 获取memo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMEMO() {
        return memo;
    }

    /**
     * 设置returnorder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETURNORDER(String value) {
        this.returnorder = value;
    }

    /**
     * 获取returnorder属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRETURNORDER() {
        return returnorder;
    }

    /**
     * 设置memo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMEMO(String value) {
        this.memo = value;
    }

    /**
     * 获取products属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PRODUCTS }
     *     
     */
    public PRODUCTS getPRODUCTS() {
        return products;
    }

    /**
     * 设置products属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PRODUCTS }
     *     
     */
    public void setPRODUCTS(PRODUCTS value) {
        this.products = value;
    }

}
