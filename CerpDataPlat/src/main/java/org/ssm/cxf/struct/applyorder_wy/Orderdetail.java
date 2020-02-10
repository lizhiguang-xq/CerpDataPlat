//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.02.10 时间 02:52:15 PM CST 
//


package org.ssm.cxf.struct.applyorder_wy;

import java.math.BigDecimal;
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
 *         &lt;element ref="{}zx_outersys_orderid"/>
 *         &lt;element ref="{}zx_outersys_orderindex"/>
 *         &lt;element ref="{}zx_outersys_memo"/>
 *         &lt;element ref="{}goodsid"/>
 *         &lt;element ref="{}goodsqty"/>
 *         &lt;element ref="{}unitprice"/>
 *         &lt;element ref="{}total_line"/>
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
    "zxOutersysOrderid",
    "zxOutersysOrderindex",
    "zxOutersysMemo",
    "goodsid",
    "goodsqty",
    "unitprice",
    "totalLine"
})
@XmlRootElement(name = "orderdetail")
public class Orderdetail {

    @XmlElement(name = "zx_outersys_orderid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysOrderid;
    @XmlElement(name = "zx_outersys_orderindex", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysOrderindex;
    @XmlElement(name = "zx_outersys_memo", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysMemo;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String goodsqty;
    @XmlElement(required = true)
    protected BigDecimal unitprice;
    @XmlElement(name = "total_line", required = true)
    protected BigDecimal totalLine;

    /**
     * 获取zxOutersysOrderid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysOrderid() {
        return zxOutersysOrderid;
    }

    /**
     * 设置zxOutersysOrderid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysOrderid(String value) {
        this.zxOutersysOrderid = value;
    }

    /**
     * 获取zxOutersysOrderindex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysOrderindex() {
        return zxOutersysOrderindex;
    }

    /**
     * 设置zxOutersysOrderindex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysOrderindex(String value) {
        this.zxOutersysOrderindex = value;
    }

    /**
     * 获取zxOutersysMemo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysMemo() {
        return zxOutersysMemo;
    }

    /**
     * 设置zxOutersysMemo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysMemo(String value) {
        this.zxOutersysMemo = value;
    }

    /**
     * 获取goodsid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsid() {
        return goodsid;
    }

    /**
     * 设置goodsid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsid(String value) {
        this.goodsid = value;
    }

    /**
     * 获取goodsqty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsqty() {
        return goodsqty;
    }

    /**
     * 设置goodsqty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsqty(String value) {
        this.goodsqty = value;
    }

    /**
     * 获取unitprice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitprice() {
        return unitprice;
    }

    /**
     * 设置unitprice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitprice(BigDecimal value) {
        this.unitprice = value;
    }

    /**
     * 获取totalLine属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalLine() {
        return totalLine;
    }

    /**
     * 设置totalLine属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalLine(BigDecimal value) {
        this.totalLine = value;
    }

}
