//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.02.11 时间 10:34:47 AM CST 
//


package org.ssm.cxf.struct.salesinfo_outerorderid;

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
 *         &lt;element ref="{}customid"/>
 *         &lt;element ref="{}customname"/>
 *         &lt;element ref="{}agentid"/>
 *         &lt;element ref="{}total"/>
 *         &lt;element ref="{}dtllines"/>
 *         &lt;element ref="{}details"/>
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
    "customid",
    "customname",
    "agentid",
    "total",
    "dtllines",
    "wmsnum",
    "details"
})
@XmlRootElement(name = "salesinfo")
public class Salesinfo {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String customid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String customname;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String agentid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String total;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String dtllines;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String wmsnum;
    @XmlElement(required = true)
    protected Details details;

    /**
     * 获取Wmsnum属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWmsnum() {
        return wmsnum;
    }

    /**
     * 设置Wmsnum属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWmsnum(String value) {
        this.wmsnum = value;
    }

    /**
     * 获取customid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomid() {
        return customid;
    }

    /**
     * 设置customid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomid(String value) {
        this.customid = value;
    }

    /**
     * 获取customname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomname() {
        return customname;
    }

    /**
     * 设置customname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomname(String value) {
        this.customname = value;
    }

    /**
     * 获取agentid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentid() {
        return agentid;
    }

    /**
     * 设置agentid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentid(String value) {
        this.agentid = value;
    }

    /**
     * 获取total属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotal() {
        return total;
    }

    /**
     * 设置total属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotal(String value) {
        this.total = value;
    }

    /**
     * 获取dtllines属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtllines() {
        return dtllines;
    }

    /**
     * 设置dtllines属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtllines(String value) {
        this.dtllines = value;
    }

    /**
     * 获取details属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Details }
     *     
     */
    public Details getDetails() {
        return details;
    }

    /**
     * 设置details属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Details }
     *     
     */
    public void setDetails(Details value) {
        this.details = value;
    }

}
