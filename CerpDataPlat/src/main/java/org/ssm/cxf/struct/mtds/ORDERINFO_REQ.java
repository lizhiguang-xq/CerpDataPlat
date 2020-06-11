//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.06.11 时间 02:43:09 PM CST 
//


package org.ssm.cxf.struct.mtds;

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
 *         &lt;element ref="{}ORDERNO"/>
 *         &lt;element ref="{}ORDERSTATUS"/>
 *         &lt;element ref="{}USERFIELDC1"/>
 *         &lt;element ref="{}USERFIELDC2"/>
 *         &lt;element ref="{}USERFIELDC3"/>
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
    "orderno",
    "orderstatus",
    "userfieldc1",
    "userfieldc2",
    "userfieldc3"
})
@XmlRootElement(name = "ORDERINFO_REQ")
public class ORDERINFO_REQ {

    @XmlElement(name = "ORDERNO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String orderno;
    @XmlElement(name = "ORDERSTATUS", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String orderstatus;
    @XmlElement(name = "USERFIELDC1", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String userfieldc1;
    @XmlElement(name = "USERFIELDC2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String userfieldc2;
    @XmlElement(name = "USERFIELDC3", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String userfieldc3;

    /**
     * 获取orderno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERNO() {
        return orderno;
    }

    /**
     * 设置orderno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERNO(String value) {
        this.orderno = value;
    }

    /**
     * 获取orderstatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERSTATUS() {
        return orderstatus;
    }

    /**
     * 设置orderstatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERSTATUS(String value) {
        this.orderstatus = value;
    }

    /**
     * 获取userfieldc1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERFIELDC1() {
        return userfieldc1;
    }

    /**
     * 设置userfieldc1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERFIELDC1(String value) {
        this.userfieldc1 = value;
    }

    /**
     * 获取userfieldc2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERFIELDC2() {
        return userfieldc2;
    }

    /**
     * 设置userfieldc2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERFIELDC2(String value) {
        this.userfieldc2 = value;
    }

    /**
     * 获取userfieldc3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERFIELDC3() {
        return userfieldc3;
    }

    /**
     * 设置userfieldc3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERFIELDC3(String value) {
        this.userfieldc3 = value;
    }

}
