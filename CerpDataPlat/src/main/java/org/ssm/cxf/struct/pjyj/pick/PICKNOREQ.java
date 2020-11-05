//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.10.13 时间 10:38:21 AM CST
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
 *         &lt;element ref="{}ORDERNO"/>
 *         &lt;element ref="{}ENTCODE"/>
 *         &lt;element ref="{}ENTRYID"/>
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
        "entcode",
        "entryid"
})
@XmlRootElement(name = "PICKNO_REQ")
public class PICKNOREQ {

    @XmlElement(name = "ORDERNO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String orderno;
    @XmlElement(name = "ENTCODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String entcode;
    @XmlElement(name = "ENTRYID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String entryid;

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
     * 获取entcode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getENTCODE() {
        return entcode;
    }

    /**
     * 设置entcode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setENTCODE(String value) {
        this.entcode = value;
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

}
