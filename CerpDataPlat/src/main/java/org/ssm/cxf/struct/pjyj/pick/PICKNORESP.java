//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.10.12 时间 04:40:15 PM CST
//


package org.ssm.cxf.struct.pjyj.pick;

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
 *         &lt;element ref="{}RET_CODE"/>
 *         &lt;element ref="{}RET_REASON"/>
 *         &lt;element ref="{}TYPE_INOUT"/>
 *         &lt;element ref="{}CUST_CODE"/>
 *         &lt;element ref="{}CUSTOMER_NAME"/>
 *         &lt;element ref="{}USER_NO"/>
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
        "retcode",
        "retreason",
        "typeinout",
        "custcode",
        "customername",
        "userno"
})
@XmlRootElement(name = "PICKNO_RESP")
public class PICKNORESP {

    @XmlElement(name = "RET_CODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String retcode;
    @XmlElement(name = "RET_REASON", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String retreason;
    @XmlElement(name = "TYPE_INOUT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String typeinout;
    @XmlElement(name = "CUST_CODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String custcode;
    @XmlElement(name = "CUSTOMER_NAME", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String customername;
    @XmlElement(name = "USER_NO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String userno;

    /**
     * 获取retcode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRETCODE() {
        return retcode;
    }

    /**
     * 设置retcode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRETCODE(String value) {
        this.retcode = value;
    }

    /**
     * 获取retreason属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRETREASON() {
        return retreason;
    }

    /**
     * 设置retreason属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRETREASON(String value) {
        this.retreason = value;
    }

    /**
     * 获取typeinout属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTYPEINOUT() {
        return typeinout;
    }

    /**
     * 设置typeinout属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTYPEINOUT(String value) {
        this.typeinout = value;
    }

    /**
     * 获取custcode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCUSTCODE() {
        return custcode;
    }

    /**
     * 设置custcode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCUSTCODE(String value) {
        this.custcode = value;
    }

    /**
     * 获取customername属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCUSTOMERNAME() {
        return customername;
    }

    /**
     * 设置customername属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCUSTOMERNAME(String value) {
        this.customername = value;
    }

    /**
     * 获取userno属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUSERNO() {
        return userno;
    }

    /**
     * 设置userno属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUSERNO(String value) {
        this.userno = value;
    }

}
