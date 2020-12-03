//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.11.10 时间 01:56:46 PM CST 
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
 *         &lt;element ref="{}GOODSID"/>
 *         &lt;element ref="{}GOODSQTY"/>
 *         &lt;element ref="{}TOTAL_LINE"/>
 *         &lt;element ref="{}REALMONEY"/>
 *         &lt;element ref="{}PRICEID"/>
 *         &lt;element ref="{}UNITPRICE"/>
 *         &lt;element ref="{}MEMO"/>
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
    "priceid",
    "unitprice",
    "memo"
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
    @XmlElement(name = "PRICEID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String priceid;
    @XmlElement(name = "UNITPRICE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String unitprice;
    @XmlElement(name = "MEMO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String memo;

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
     * 获取priceid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRICEID() {
        return priceid;
    }

    /**
     * 设置priceid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRICEID(String value) {
        this.priceid = value;
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

}
