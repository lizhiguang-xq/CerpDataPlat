//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.11.05 时间 10:19:27 AM CST 
//


package org.ssm.cxf.struct.common.goodsqty;

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
 *         &lt;element ref="{}ENTRYID"/>
 *         &lt;element ref="{}PLACEPOINTID"/>
 *         &lt;element ref="{}GOODSIDS"/>
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
    "goodsids"
})
@XmlRootElement(name = "GOODSQTY_REQ")
public class GOODSQTYREQ {

    @XmlElement(name = "ENTRYID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String entryid;
    @XmlElement(name = "PLACEPOINTID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String placepointid;
    @XmlElement(name = "GOODSIDS", required = true)
    protected String goodsids;

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
     * 获取goodsids属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGOODSIDS() {
        return goodsids;
    }

    /**
     * 设置goodsids属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGOODSIDS(String value) {
        this.goodsids = value;
    }

}
