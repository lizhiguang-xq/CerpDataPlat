//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.07.03 时间 08:57:47 AM CST 
//


package org.ssm.cxf.struct.oms.order;

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
 *         &lt;element ref="{}ECC_SALES_ORG"/>
 *         &lt;element ref="{}COMEFORM"/>
 *         &lt;element ref="{}OPERATION_TYPE"/>
 *         &lt;element ref="{}ENTRYID"/>
 *         &lt;element ref="{}PLACEPOINTID"/>
 *         &lt;element ref="{}CREDATE"/>
 *         &lt;element ref="{}TOTALMONEY"/>
 *         &lt;element ref="{}RECEIVALMONEY"/>
 *         &lt;element ref="{}REALMONEY"/>
 *         &lt;element ref="{}THREE_PART_FAVOUR"/>
 *         &lt;element ref="{}ZX_ORDERNO"/>
 *         &lt;element ref="{}ECC_SHIPTO_REGION"/>
 *         &lt;element ref="{}ECC_SHIPTO_CITY"/>
 *         &lt;element ref="{}ECC_SHIPTO_DISTRICT"/>
 *         &lt;element ref="{}ADDRESS"/>
 *         &lt;element ref="{}SHOUH_PHONE"/>
 *         &lt;element ref="{}SHOUH_STAFF"/>
 *         &lt;element ref="{}POSTCODE"/>
 *         &lt;element ref="{}SHUIP_TYPE"/>
 *         &lt;element ref="{}INVOICE_TITLE"/>
 *         &lt;element ref="{}DANJ_NO_WSDD"/>
 *         &lt;element ref="{}BILL_NUMBER"/>
 *         &lt;element ref="{}SUB_ORDER_NUMBER"/>
 *         &lt;element ref="{}INVOICE_NUMBER"/>
 *         &lt;element ref="{}INVOICE_CONTENT"/>
 *         &lt;element ref="{}SHAD_CITY"/>
 *         &lt;element ref="{}SHAD_CITY_DISTRICT"/>
 *         &lt;element ref="{}POSTAL_ZONE"/>
 *         &lt;element ref="{}SHAD_RESIDENTIAL"/>
 *         &lt;element ref="{}SHAD_RESIDENTIAL_NUMBER"/>
 *         &lt;element ref="{}SOCIAL_SECURITY_NUMBER"/>
 *         &lt;element ref="{}SEX"/>
 *         &lt;element ref="{}AGE"/>
 *         &lt;element ref="{}PAYMENT_INFO_TYPE"/>
 *         &lt;element ref="{}DELIVERY_SERVICE"/>
 *         &lt;element ref="{}DRUG_HISTORY"/>
 *         &lt;element ref="{}HAVE_ALLERGY"/>
 *         &lt;element ref="{}DRUG_EFFECT"/>
 *         &lt;element ref="{}PAYMENT"/>
 *         &lt;element ref="{}PHARMACISTS_OPINIONS"/>
 *         &lt;element ref="{}IS_NEED_SECOND_REIMURSEMENT"/>
 *         &lt;element ref="{}IS_PRESCRIBE"/>
 *         &lt;element ref="{}DELIVERY_DATE"/>
 *         &lt;element ref="{}SETTLEMENT_DATE"/>
 *         &lt;element ref="{}BILLS_TYPE"/>
 *         &lt;element ref="{}VENDORMEMO"/>
 *         &lt;element ref="{}BUYERMEMO"/>
 *         &lt;element ref="{}CARRIER_ID"/>
 *         &lt;element ref="{}CARRIER_NAME"/>
 *         &lt;element ref="{}ZYUNFEI"/>
 *         &lt;element ref="{}DISCOUNT_FEE"/>
 *         &lt;element ref="{}CODFEE"/>
 *         &lt;element ref="{}SPLITTYPE"/>
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
    "comeform",
    "operationtype",
    "entryid",
    "placepointid",
    "credate",
    "totalmoney",
    "receivalmoney",
    "realmoney",
    "threepartfavour",
    "zxorderno",
    "eccshiptoregion",
    "eccshiptocity",
    "eccshiptodistrict",
    "address",
    "shouhphone",
    "shouhstaff",
    "postcode",
    "shuiptype",
    "invoicetitle",
    "danjnowsdd",
    "billnumber",
    "subordernumber",
    "invoicenumber",
    "invoicecontent",
    "shadcity",
    "shadcitydistrict",
    "postalzone",
    "shadresidential",
    "shadresidentialnumber",
    "socialsecuritynumber",
    "sex",
    "age",
    "paymentinfotype",
    "deliveryservice",
    "drughistory",
    "haveallergy",
    "drugeffect",
    "payment",
    "pharmacistsopinions",
    "isneedsecondreimursement",
    "isprescribe",
    "deliverydate",
    "settlementdate",
    "billstype",
    "vendormemo",
    "buyermemo",
    "manualalloc",
    "prescriptionhospital",
    "carrierid",
    "carriername",
    "zyunfei",
    "discountfee",
    "eccsalesorg",
    "codfee",
    "splittype",
    "products"
})
@XmlRootElement(name = "OMS_APPLYORDER_REQ")
public class OMSAPPLYORDERREQ {

    @XmlElement(name = "COMEFORM", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String comeform;
    @XmlElement(name = "OPERATION_TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String operationtype;
    @XmlElement(name = "ENTRYID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String entryid;
    @XmlElement(name = "PLACEPOINTID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String placepointid;
    @XmlElement(name = "CREDATE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String credate;
    @XmlElement(name = "TOTALMONEY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String totalmoney;
    @XmlElement(name = "RECEIVALMONEY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String receivalmoney;
    @XmlElement(name = "REALMONEY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String realmoney;
    @XmlElement(name = "THREE_PART_FAVOUR", required = true)
    protected String threepartfavour;
    @XmlElement(name = "ZX_ORDERNO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxorderno;
    @XmlElement(name = "ECC_SHIPTO_REGION", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String eccshiptoregion;
    @XmlElement(name = "ECC_SHIPTO_CITY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String eccshiptocity;
    @XmlElement(name = "ECC_SHIPTO_DISTRICT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String eccshiptodistrict;
    @XmlElement(name = "ADDRESS", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String address;
    @XmlElement(name = "SHOUH_PHONE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shouhphone;
    @XmlElement(name = "SHOUH_STAFF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shouhstaff;
    @XmlElement(name = "POSTCODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String postcode;
    @XmlElement(name = "SHUIP_TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shuiptype;
    @XmlElement(name = "INVOICE_TITLE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String invoicetitle;
    @XmlElement(name = "DANJ_NO_WSDD", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String danjnowsdd;
    @XmlElement(name = "BILL_NUMBER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String billnumber;
    @XmlElement(name = "SUB_ORDER_NUMBER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String subordernumber;
    @XmlElement(name = "INVOICE_NUMBER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String invoicenumber;
    @XmlElement(name = "INVOICE_CONTENT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String invoicecontent;
    @XmlElement(name = "SHAD_CITY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadcity;
    @XmlElement(name = "SHAD_CITY_DISTRICT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadcitydistrict;
    @XmlElement(name = "POSTAL_ZONE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String postalzone;
    @XmlElement(name = "SHAD_RESIDENTIAL", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadresidential;
    @XmlElement(name = "SHAD_RESIDENTIAL_NUMBER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadresidentialnumber;
    @XmlElement(name = "SOCIAL_SECURITY_NUMBER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String socialsecuritynumber;
    @XmlElement(name = "SEX", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String sex;
    @XmlElement(name = "AGE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String age;
    @XmlElement(name = "PAYMENT_INFO_TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String paymentinfotype;
    @XmlElement(name = "DELIVERY_SERVICE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String deliveryservice;
    @XmlElement(name = "DRUG_HISTORY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String drughistory;
    @XmlElement(name = "HAVE_ALLERGY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String haveallergy;
    @XmlElement(name = "DRUG_EFFECT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String drugeffect;
    @XmlElement(name = "PAYMENT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String payment;
    @XmlElement(name = "PHARMACISTS_OPINIONS", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String pharmacistsopinions;
    @XmlElement(name = "IS_NEED_SECOND_REIMURSEMENT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String isneedsecondreimursement;
    @XmlElement(name = "IS_PRESCRIBE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String isprescribe;
    @XmlElement(name = "DELIVERY_DATE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String deliverydate;
    @XmlElement(name = "SETTLEMENT_DATE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String settlementdate;
    @XmlElement(name = "BILLS_TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String billstype;
    @XmlElement(name = "VENDORMEMO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String vendormemo;
    @XmlElement(name = "BUYERMEMO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String buyermemo;
    @XmlElement(name = "MANUALALLOC", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String manualalloc;
    @XmlElement(name = "PRESCRIPTION_HOSPITAL", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prescriptionhospital;
    @XmlElement(name = "CARRIER_ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String carrierid;
    @XmlElement(name = "CARRIER_NAME", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String carriername;
    @XmlElement(name = "ZYUNFEI", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zyunfei;
    @XmlElement(name = "ECC_SALES_ORG", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String eccsalesorg;
    @XmlElement(name = "DISCOUNT_FEE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String discountfee;
    @XmlElement(name = "CODFEE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codfee;
    @XmlElement(name = "SPLITTYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String splittype;
    @XmlElement(name = "PRODUCTS", required = true)
    protected PRODUCTS products;

    /**
     * 获取comeform属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCOMEFORM() {
        return comeform;
    }

    /**
     * 设置comeform属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCOMEFORM(String value) {
        this.comeform = value;
    }
    /**
     * 获取operationtype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATIONTYPE() {
        return operationtype;
    }

    /**
     * 设置operationtype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATIONTYPE(String value) {
        this.operationtype = value;
    }

    /**
     * 获取entryid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTRYID() {
        return entryid;
    }

    /**
     * 设置entryid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTRYID(String value) {
        this.entryid = value;
    }

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
     * 获取totalmoney属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALMONEY() {
        return totalmoney;
    }

    /**
     * 设置totalmoney属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALMONEY(String value) {
        this.totalmoney = value;
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
     * 获取threepartfavour属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHREEPARTFAVOUR() {
        return threepartfavour;
    }

    /**
     * 设置threepartfavour属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHREEPARTFAVOUR(String value) {
        this.threepartfavour = value;
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
     * 获取eccshiptoregion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECCSHIPTOREGION() {
        return eccshiptoregion;
    }

    /**
     * 设置eccshiptoregion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECCSHIPTOREGION(String value) {
        this.eccshiptoregion = value;
    }

    /**
     * 获取eccshiptocity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECCSHIPTOCITY() {
        return eccshiptocity;
    }

    /**
     * 设置eccshiptocity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECCSHIPTOCITY(String value) {
        this.eccshiptocity = value;
    }

    /**
     * 获取eccshiptodistrict属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECCSHIPTODISTRICT() {
        return eccshiptodistrict;
    }

    /**
     * 设置eccshiptodistrict属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECCSHIPTODISTRICT(String value) {
        this.eccshiptodistrict = value;
    }

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESS() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESS(String value) {
        this.address = value;
    }

    /**
     * 获取shouhphone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHOUHPHONE() {
        return shouhphone;
    }

    /**
     * 设置shouhphone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHOUHPHONE(String value) {
        this.shouhphone = value;
    }

    /**
     * 获取shouhstaff属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHOUHSTAFF() {
        return shouhstaff;
    }

    /**
     * 设置shouhstaff属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHOUHSTAFF(String value) {
        this.shouhstaff = value;
    }

    /**
     * 获取postcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTCODE() {
        return postcode;
    }

    /**
     * 设置postcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTCODE(String value) {
        this.postcode = value;
    }

    /**
     * 获取shuiptype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHUIPTYPE() {
        return shuiptype;
    }

    /**
     * 设置shuiptype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHUIPTYPE(String value) {
        this.shuiptype = value;
    }

    /**
     * 获取invoicetitle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICETITLE() {
        return invoicetitle;
    }

    /**
     * 设置invoicetitle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICETITLE(String value) {
        this.invoicetitle = value;
    }

    /**
     * 获取danjnowsdd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDANJNOWSDD() {
        return danjnowsdd;
    }

    /**
     * 设置danjnowsdd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDANJNOWSDD(String value) {
        this.danjnowsdd = value;
    }

    /**
     * 获取billnumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBILLNUMBER() {
        return billnumber;
    }

    /**
     * 设置billnumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBILLNUMBER(String value) {
        this.billnumber = value;
    }

    /**
     * 获取subordernumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBORDERNUMBER() {
        return subordernumber;
    }

    /**
     * 设置subordernumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBORDERNUMBER(String value) {
        this.subordernumber = value;
    }

    /**
     * 获取invoicenumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICENUMBER() {
        return invoicenumber;
    }

    /**
     * 设置invoicenumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICENUMBER(String value) {
        this.invoicenumber = value;
    }

    /**
     * 获取invoicecontent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICECONTENT() {
        return invoicecontent;
    }

    /**
     * 设置invoicecontent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICECONTENT(String value) {
        this.invoicecontent = value;
    }

    /**
     * 获取shadcity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADCITY() {
        return shadcity;
    }

    /**
     * 设置shadcity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADCITY(String value) {
        this.shadcity = value;
    }

    /**
     * 获取shadcitydistrict属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADCITYDISTRICT() {
        return shadcitydistrict;
    }

    /**
     * 设置shadcitydistrict属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADCITYDISTRICT(String value) {
        this.shadcitydistrict = value;
    }

    /**
     * 获取postalzone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTALZONE() {
        return postalzone;
    }

    /**
     * 设置postalzone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTALZONE(String value) {
        this.postalzone = value;
    }

    /**
     * 获取shadresidential属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADRESIDENTIAL() {
        return shadresidential;
    }

    /**
     * 设置shadresidential属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADRESIDENTIAL(String value) {
        this.shadresidential = value;
    }

    /**
     * 获取shadresidentialnumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADRESIDENTIALNUMBER() {
        return shadresidentialnumber;
    }

    /**
     * 设置shadresidentialnumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADRESIDENTIALNUMBER(String value) {
        this.shadresidentialnumber = value;
    }

    /**
     * 获取socialsecuritynumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOCIALSECURITYNUMBER() {
        return socialsecuritynumber;
    }

    /**
     * 设置socialsecuritynumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOCIALSECURITYNUMBER(String value) {
        this.socialsecuritynumber = value;
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
     * 获取age属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGE() {
        return age;
    }

    /**
     * 设置age属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGE(String value) {
        this.age = value;
    }

    /**
     * 获取paymentinfotype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENTINFOTYPE() {
        return paymentinfotype;
    }

    /**
     * 设置paymentinfotype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENTINFOTYPE(String value) {
        this.paymentinfotype = value;
    }

    /**
     * 获取deliveryservice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYSERVICE() {
        return deliveryservice;
    }

    /**
     * 设置deliveryservice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYSERVICE(String value) {
        this.deliveryservice = value;
    }

    /**
     * 获取drughistory属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRUGHISTORY() {
        return drughistory;
    }

    /**
     * 设置drughistory属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRUGHISTORY(String value) {
        this.drughistory = value;
    }

    /**
     * 获取haveallergy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHAVEALLERGY() {
        return haveallergy;
    }

    /**
     * 设置haveallergy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHAVEALLERGY(String value) {
        this.haveallergy = value;
    }

    /**
     * 获取drugeffect属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRUGEFFECT() {
        return drugeffect;
    }

    /**
     * 设置drugeffect属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRUGEFFECT(String value) {
        this.drugeffect = value;
    }

    /**
     * 获取payment属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENT() {
        return payment;
    }

    /**
     * 设置payment属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENT(String value) {
        this.payment = value;
    }

    /**
     * 获取pharmacistsopinions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHARMACISTSOPINIONS() {
        return pharmacistsopinions;
    }

    /**
     * 设置pharmacistsopinions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHARMACISTSOPINIONS(String value) {
        this.pharmacistsopinions = value;
    }

    /**
     * 获取isneedsecondreimursement属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISNEEDSECONDREIMURSEMENT() {
        return isneedsecondreimursement;
    }

    /**
     * 设置isneedsecondreimursement属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISNEEDSECONDREIMURSEMENT(String value) {
        this.isneedsecondreimursement = value;
    }

    /**
     * 获取isprescribe属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISPRESCRIBE() {
        return isprescribe;
    }

    /**
     * 设置isprescribe属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISPRESCRIBE(String value) {
        this.isprescribe = value;
    }

    /**
     * 获取deliverydate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYDATE() {
        return deliverydate;
    }

    /**
     * 设置deliverydate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYDATE(String value) {
        this.deliverydate = value;
    }

    /**
     * 获取settlementdate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSETTLEMENTDATE() {
        return settlementdate;
    }

    /**
     * 设置settlementdate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSETTLEMENTDATE(String value) {
        this.settlementdate = value;
    }

    /**
     * 获取billstype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBILLSTYPE() {
        return billstype;
    }

    /**
     * 设置billstype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBILLSTYPE(String value) {
        this.billstype = value;
    }

    /**
     * 获取vendormemo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVENDORMEMO() {
        return vendormemo;
    }

    /**
     * 设置vendormemo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVENDORMEMO(String value) {
        this.vendormemo = value;
    }

    /**
     * 获取buyermemo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUYERMEMO() {
        return buyermemo;
    }

    /**
     * 设置buyermemo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUYERMEMO(String value) {
        this.buyermemo = value;
    }

    /**
     * 获取buyermemo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMANUALALLOC() {
        return manualalloc;
    }

    /**
     * 设置buyermemo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMANUALALLOC(String value) {
        this.manualalloc = value;
    }

    /**
     * 获取buyermemo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPRESCRIPTION_HOSPITAL() {
        return prescriptionhospital;
    }

    /**
     * 设置buyermemo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPRESCRIPTION_HOSPITAL(String value) {
        this.prescriptionhospital = value;
    }

    /**
     * 获取carrierid属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCARRIERID() {
        return carrierid;
    }

    /**
     * 设置carrierid属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCARRIERID(String value) {
        this.carrierid = value;
    }

    /**
     * 获取carriername属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCARRIERNAME() {
        return carriername;
    }

    /**
     * 设置carriername属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCARRIERNAME(String value) {
        this.carriername = value;
    }

    /**
     * 获取zyunfei属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getZYUNFEI() {
        return zyunfei;
    }

    /**
     * 设置zyunfei属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setZYUNFEI(String value) {
        this.zyunfei = value;
    }

    /**
     * 获取zyunfei属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getECC_SALES_ORG() {
        return eccsalesorg;
    }

    /**
     * 设置zyunfei属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setECC_SALES_ORG(String value) {
        this.eccsalesorg = value;
    }

    /**
     * 获取discountfee属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDISCOUNT_FEE() {
        return discountfee;
    }

    /**
     * 设置discountfee属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDISCOUNT_FEE(String value) {
        this.discountfee = value;
    }

    /**
     * 获取codfee属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCODFEE() {
        return codfee;
    }

    /**
     * 设置codfee属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCODFEE(String value) {
        this.codfee = value;
    }

    /**
     * 获取splittype属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSPLITTYPE() {
        return splittype;
    }

    /**
     * 设置splittype属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSPLITTYPE(String value) {
        this.splittype = value;
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
