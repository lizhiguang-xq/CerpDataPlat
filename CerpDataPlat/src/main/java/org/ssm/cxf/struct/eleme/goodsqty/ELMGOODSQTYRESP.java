//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.02.20 时间 10:55:19 AM CST 
//


package org.ssm.cxf.struct.eleme.goodsqty;

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
 *         &lt;element ref="{}returncode"/>
 *         &lt;element ref="{}returnmsg"/>
 *         &lt;element ref="{}goodsqtylist"/>
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
    "returncode",
    "returnmsg",
    "goodsqtylist"
})
@XmlRootElement(name = "ELM_GOODSQTY_RESP")
public class ELMGOODSQTYRESP {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String returncode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String returnmsg;
    @XmlElement(required = true)
    protected Goodsqtylist goodsqtylist;

    /**
     * 获取returncode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturncode() {
        return returncode;
    }

    /**
     * 设置returncode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturncode(String value) {
        this.returncode = value;
    }

    /**
     * 获取returnmsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnmsg() {
        return returnmsg;
    }

    /**
     * 设置returnmsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnmsg(String value) {
        this.returnmsg = value;
    }

    /**
     * 获取goodsqtylist属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Goodsqtylist }
     *     
     */
    public Goodsqtylist getGoodsqtylist() {
        return goodsqtylist;
    }

    /**
     * 设置goodsqtylist属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Goodsqtylist }
     *     
     */
    public void setGoodsqtylist(Goodsqtylist value) {
        this.goodsqtylist = value;
    }

}