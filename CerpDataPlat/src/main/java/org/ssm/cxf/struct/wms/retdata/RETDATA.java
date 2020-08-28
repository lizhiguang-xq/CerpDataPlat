//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.08.03 时间 02:47:10 PM CST 
//


package org.ssm.cxf.struct.wms.retdata;

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
 *         &lt;element ref="{}DANJ_NO"/>
 *         &lt;element ref="{}HANGHAO"/>
 *         &lt;element ref="{}ZFLAG"/>
 *         &lt;element ref="{}ZMESSAGE"/>
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
    "danjno",
    "hanghao",
    "zflag",
    "zmessage"
})
@XmlRootElement(name = "RETDATA")
public class RETDATA {

    @XmlElement(name = "DANJ_NO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String danjno;
    @XmlElement(name = "HANGHAO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String hanghao;
    @XmlElement(name = "ZFLAG", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zflag;
    @XmlElement(name = "ZMESSAGE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zmessage;

    /**
     * 获取danjno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDANJNO() {
        return danjno;
    }

    /**
     * 设置danjno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDANJNO(String value) {
        this.danjno = value;
    }

    /**
     * 获取hanghao属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHANGHAO() {
        return hanghao;
    }

    /**
     * 设置hanghao属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHANGHAO(String value) {
        this.hanghao = value;
    }

    /**
     * 获取zflag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZFLAG() {
        return zflag;
    }

    /**
     * 设置zflag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZFLAG(String value) {
        this.zflag = value;
    }

    /**
     * 获取zmessage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZMESSAGE() {
        return zmessage;
    }

    /**
     * 设置zmessage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZMESSAGE(String value) {
        this.zmessage = value;
    }

}
