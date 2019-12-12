//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.12.12 时间 04:31:52 PM CST 
//


package org.ssm.cxf.struct.suinvno;

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
 *         &lt;element ref="{}iodtlid"/>
 *         &lt;element ref="{}invcode"/>
 *         &lt;element ref="{}invno"/>
 *         &lt;element ref="{}kprq"/>
 *         &lt;element ref="{}xfmc"/>
 *         &lt;element ref="{}xfsh"/>
 *         &lt;element ref="{}gfmc"/>
 *         &lt;element ref="{}gfsh"/>
 *         &lt;element ref="{}fphszje"/>
 *         &lt;element ref="{}lplx"/>
 *         &lt;element ref="{}shtxdh"/>
 *         &lt;element ref="{}fpmxbm"/>
 *         &lt;element ref="{}hsje"/>
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
    "kprq",
    "xfmc",
    "xfsh",
    "gfmc",
    "gfsh",
    "fphszje",
    "lplx",
    "shtxdh",
    "fpmxbm",
    "hsje"
})
@XmlRootElement(name = "jhinvnodetil")
public class SUINVNODETIL {

    @XmlElement(required = true)
    protected String iodtlid;
    @XmlElement(required = true)
    protected String invcode;
    @XmlElement(required = true)
    protected String invno;
    @XmlElement(required = true)
    protected String kprq;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String xfmc;
    @XmlElement(required = true)
    protected String xfsh;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String gfmc;
    @XmlElement(required = true)
    protected String gfsh;
    @XmlElement(required = true)
    protected String fphszje;
    @XmlElement(required = true)
    protected String lplx;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shtxdh;
    @XmlElement(required = true)
    protected String fpmxbm;
    @XmlElement(required = true)
    protected String hsje;

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
     * 获取kprq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKprq() {
        return kprq;
    }

    /**
     * 设置kprq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKprq(String value) {
        this.kprq = value;
    }

    /**
     * 获取xfmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXfmc() {
        return xfmc;
    }

    /**
     * 设置xfmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXfmc(String value) {
        this.xfmc = value;
    }

    /**
     * 获取xfsh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXfsh() {
        return xfsh;
    }

    /**
     * 设置xfsh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXfsh(String value) {
        this.xfsh = value;
    }

    /**
     * 获取gfmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGfmc() {
        return gfmc;
    }

    /**
     * 设置gfmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGfmc(String value) {
        this.gfmc = value;
    }

    /**
     * 获取gfsh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGfsh() {
        return gfsh;
    }

    /**
     * 设置gfsh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGfsh(String value) {
        this.gfsh = value;
    }

    /**
     * 获取fphszje属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFphszje() {
        return fphszje;
    }

    /**
     * 设置fphszje属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFphszje(String value) {
        this.fphszje = value;
    }

    /**
     * 获取lplx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLplx() {
        return lplx;
    }

    /**
     * 设置lplx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLplx(String value) {
        this.lplx = value;
    }

    /**
     * 获取shtxdh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShtxdh() {
        return shtxdh;
    }

    /**
     * 设置shtxdh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShtxdh(String value) {
        this.shtxdh = value;
    }

    /**
     * 获取fpmxbm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFpmxbm() {
        return fpmxbm;
    }

    /**
     * 设置fpmxbm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFpmxbm(String value) {
        this.fpmxbm = value;
    }

    /**
     * 获取hsje属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHsje() {
        return hsje;
    }

    /**
     * 设置hsje属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHsje(String value) {
        this.hsje = value;
    }

}
