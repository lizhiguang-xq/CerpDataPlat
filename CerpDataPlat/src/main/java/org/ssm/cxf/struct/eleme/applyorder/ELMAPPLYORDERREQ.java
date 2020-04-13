//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.03.02 时间 01:52:04 PM CST 
//


package org.ssm.cxf.struct.eleme.applyorder;

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
 *         &lt;element ref="{}entryid"/>
 *         &lt;element ref="{}placepointid"/>
 *         &lt;element ref="{}credate"/>
 *         &lt;element ref="{}receivalmoney"/>
 *         &lt;element ref="{}realmoney"/>
 *         &lt;element ref="{}gathertype"/>
 *         &lt;element ref="{}dtl_lines"/>
 *         &lt;element ref="{}zx_orderno"/>
 *         &lt;element ref="{}products"/>
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
    "entryid",
    "placepointid",
    "credate",
    "receivalmoney",
    "realmoney",
    "gathertype",
    "dtlLines",
    "zxOrderno",
    "products"
})
@XmlRootElement(name = "ELM_APPLYORDER_REQ")
public class ELMAPPLYORDERREQ {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String entryid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String placepointid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String credate;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String receivalmoney;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String realmoney;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String gathertype;
    @XmlElement(name = "dtl_lines", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String dtlLines;
    @XmlElement(name = "zx_orderno", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOrderno;
    @XmlElement(required = true)
    protected Products products;

    /**
     * 获取entryid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryid() {
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
    public void setEntryid(String value) {
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
    public String getPlacepointid() {
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
    public void setPlacepointid(String value) {
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
    public String getCredate() {
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
    public void setCredate(String value) {
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
    public String getReceivalmoney() {
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
    public void setReceivalmoney(String value) {
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
    public String getRealmoney() {
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
    public void setRealmoney(String value) {
        this.realmoney = value;
    }

    /**
     * 获取gathertype属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGathertype() {
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
    public void setGathertype(String value) {
        this.gathertype = value;
    }

    /**
     * 获取dtlLines属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtlLines() {
        return dtlLines;
    }

    /**
     * 设置dtlLines属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtlLines(String value) {
        this.dtlLines = value;
    }

    /**
     * 获取zxOrderno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOrderno() {
        return zxOrderno;
    }

    /**
     * 设置zxOrderno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOrderno(String value) {
        this.zxOrderno = value;
    }

    /**
     * 获取products属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Products }
     *     
     */
    public Products getProducts() {
        return products;
    }

    /**
     * 设置products属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Products }
     *     
     */
    public void setProducts(Products value) {
        this.products = value;
    }

}
