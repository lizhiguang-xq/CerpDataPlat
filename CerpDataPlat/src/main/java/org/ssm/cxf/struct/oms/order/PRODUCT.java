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
 *         &lt;element ref="{}GOODSID"/>
 *         &lt;element ref="{}GOODSQTY"/>
 *         &lt;element ref="{}TOTAL_LINE"/>
 *         &lt;element ref="{}REALMONEY"/>
 *         &lt;element ref="{}UNITPRICE"/>
 *         &lt;element ref="{}LOT_REQUEST"/>
 *         &lt;element ref="{}PRESCRIPTION_DOSAGE"/>
 *         &lt;element ref="{}PRESCRIPTION_USAGE"/>
 *         &lt;element ref="{}DAY_OF_MEDICATION"/>
 *         &lt;element ref="{}ACTUAL_DAY_OF_MEDICATION"/>
 *         &lt;element ref="{}DISCOUNT_FEE"/>
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
    "goodsid",
    "goodsqty",
    "totalline",
    "realmoney",
    "unitprice",
    "lotrequest",
    "prescriptiondosage",
    "prescriptionusage",
    "dayofmedication",
    "actualdayofmedication",
    "discountfee"
})
@XmlRootElement(name = "PRODUCT")
public class PRODUCT {

    @XmlElement(name = "GOODSID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsid;
    @XmlElement(name = "GOODSQTY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsqty;
    @XmlElement(name = "TOTAL_LINE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String totalline;
    @XmlElement(name = "REALMONEY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String realmoney;
    @XmlElement(name = "UNITPRICE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String unitprice;
    @XmlElement(name = "LOT_REQUEST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String lotrequest;
    @XmlElement(name = "PRESCRIPTION_DOSAGE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prescriptiondosage;
    @XmlElement(name = "PRESCRIPTION_USAGE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prescriptionusage;
    @XmlElement(name = "DAY_OF_MEDICATION", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String dayofmedication;
    @XmlElement(name = "ACTUAL_DAY_OF_MEDICATION", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String actualdayofmedication;
    @XmlElement(name = "DISCOUNT_FEE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String discountfee;

    /**
     * 获取goodsid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGOODSID() {
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
    public void setGOODSID(String value) {
        this.goodsid = value;
    }

    /**
     * 获取goodsqty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGOODSQTY() {
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
    public void setGOODSQTY(String value) {
        this.goodsqty = value;
    }

    /**
     * 获取totalline属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALLINE() {
        return totalline;
    }

    /**
     * 设置totalline属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALLINE(String value) {
        this.totalline = value;
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
     * 获取unitprice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITPRICE() {
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
    public void setUNITPRICE(String value) {
        this.unitprice = value;
    }

    /**
     * 获取lotrequest属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOTREQUEST() {
        return lotrequest;
    }

    /**
     * 设置lotrequest属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOTREQUEST(String value) {
        this.lotrequest = value;
    }

    /**
     * 获取prescriptiondosage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRESCRIPTIONDOSAGE() {
        return prescriptiondosage;
    }

    /**
     * 设置prescriptiondosage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRESCRIPTIONDOSAGE(String value) {
        this.prescriptiondosage = value;
    }

    /**
     * 获取prescriptionusage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRESCRIPTIONUSAGE() {
        return prescriptionusage;
    }

    /**
     * 设置prescriptionusage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRESCRIPTIONUSAGE(String value) {
        this.prescriptionusage = value;
    }

    /**
     * 获取dayofmedication属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDAYOFMEDICATION() {
        return dayofmedication;
    }

    /**
     * 设置dayofmedication属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDAYOFMEDICATION(String value) {
        this.dayofmedication = value;
    }

    /**
     * 获取actualdayofmedication属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTUALDAYOFMEDICATION() {
        return actualdayofmedication;
    }

    /**
     * 设置actualdayofmedication属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTUALDAYOFMEDICATION(String value) {
        this.actualdayofmedication = value;
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

}
