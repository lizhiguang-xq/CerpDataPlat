//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.06.11 时间 03:13:30 PM CST 
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
 *         &lt;element ref="{}ERRCODE"/>
 *         &lt;element ref="{}ERRMSG"/>
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
    "errcode",
    "errmsg"
})
@XmlRootElement(name = "ORDERINFO_RESP")
public class ORDERINFO_RESP {

    @XmlElement(name = "ORDERNO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String orderno;
    @XmlElement(name = "ERRCODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String errcode;
    @XmlElement(name = "ERRMSG", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String errmsg;

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
     * 获取errcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRCODE() {
        return errcode;
    }

    /**
     * 设置errcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRCODE(String value) {
        this.errcode = value;
    }

    /**
     * 获取errmsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRMSG() {
        return errmsg;
    }

    /**
     * 设置errmsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRMSG(String value) {
        this.errmsg = value;
    }

}
