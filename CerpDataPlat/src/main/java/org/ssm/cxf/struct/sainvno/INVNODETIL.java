//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.12.09 时间 03:05:36 PM CST 
//


package org.ssm.cxf.struct.sainvno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}iodtlid"/>
 *         &lt;element ref="{}invcode"/>
 *         &lt;element ref="{}invno"/>
 *         &lt;element ref="{}zx_jsdate"/>
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
    "iodtlid",
    "invcode",
    "invno",
    "zxJsdate"
})
@XmlRootElement(name = "invnodetil")
public class INVNODETIL {

    @XmlElement(required = true)
    protected String iodtlid;
    @XmlElement(required = true)
    protected String invcode;
    @XmlElement(required = true)
    protected String invno;
    @XmlElement(name = "zx_jsdate", required = true)
    protected String zxJsdate;

    /**
     * 获取iodtlid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIodtlid() {
        return iodtlid;
    }

    /**
     * 设置iodtlid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIodtlid(String value) {
        this.iodtlid = value;
    }

    /**
     * 获取invcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvcode() {
        return invcode;
    }

    /**
     * 设置invcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvcode(String value) {
        this.invcode = value;
    }

    /**
     * 获取invno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvno() {
        return invno;
    }

    /**
     * 设置invno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvno(String value) {
        this.invno = value;
    }

    /**
     * 获取zxJsdate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxJsdate() {
        return zxJsdate;
    }

    /**
     * 设置zxJsdate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxJsdate(String value) {
        this.zxJsdate = value;
    }

}
