//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.11.05 时间 08:57:35 AM CST 
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
 *         &lt;element ref="{}RETURNCODE"/>
 *         &lt;element ref="{}RETURNMSG"/>
 *         &lt;element ref="{}QTYLIST"/>
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
    "qtylist"
})
@XmlRootElement(name = "GOODSQTY_RESP")
public class GOODSQTYRESP {

    @XmlElement(name = "RETURNCODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String returncode;
    @XmlElement(name = "RETURNMSG", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String returnmsg;
    @XmlElement(name = "QTYLIST", required = true)
    protected QTYLIST qtylist;

    /**
     * 获取returncode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETURNCODE() {
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
    public void setRETURNCODE(String value) {
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
    public String getRETURNMSG() {
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
    public void setRETURNMSG(String value) {
        this.returnmsg = value;
    }

    /**
     * 获取qtylist属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QTYLIST }
     *     
     */
    public QTYLIST getQTYLIST() {
        return qtylist;
    }

    /**
     * 设置qtylist属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QTYLIST }
     *     
     */
    public void setQTYLIST(QTYLIST value) {
        this.qtylist = value;
    }

}
