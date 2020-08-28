//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.07.21 时间 11:10:18 AM CST 
//


package org.ssm.cxf.struct.wms.cancel;

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
 *         &lt;element ref="{}WLZX_CODE"/>
 *         &lt;element ref="{}HUOZ_ID"/>
 *         &lt;element ref="{}RIQI_DATE"/>
 *         &lt;element ref="{}YEW_STAFF"/>
 *         &lt;element ref="{}DANJ_NO_Y"/>
 *         &lt;element ref="{}DANJ_MX"/>
 *         &lt;element ref="{}YUANYIN"/>
 *         &lt;element ref="{}NOTE"/>
 *         &lt;element ref="{}PEIS_NOTES"/>
 *         &lt;element ref="{}TIAOM_NUM"/>
 *         &lt;element ref="{}ZT"/>
 *         &lt;element ref="{}DANJ_NO_NC"/>
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
    "wlzxcode",
    "huozid",
    "riqidate",
    "yewstaff",
    "danjnoy",
    "danjmx",
    "yuanyin",
    "note",
    "peisnotes",
    "tiaomnum",
    "zt",
    "danjnonc"
})
@XmlRootElement(name = "T_CK_KPD_DEL")
public class TCKKPDDEL {

    @XmlElement(name = "DANJ_NO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String danjno;
    @XmlElement(name = "WLZX_CODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String wlzxcode;
    @XmlElement(name = "HUOZ_ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String huozid;
    @XmlElement(name = "RIQI_DATE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String riqidate;
    @XmlElement(name = "YEW_STAFF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String yewstaff;
    @XmlElement(name = "DANJ_NO_Y", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String danjnoy;
    @XmlElement(name = "DANJ_MX", required = true)
    protected DANJMX danjmx;
    @XmlElement(name = "YUANYIN", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String yuanyin;
    @XmlElement(name = "NOTE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String note;
    @XmlElement(name = "PEIS_NOTES", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String peisnotes;
    @XmlElement(name = "TIAOM_NUM", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String tiaomnum;
    @XmlElement(name = "ZT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zt;
    @XmlElement(name = "DANJ_NO_NC", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String danjnonc;

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
     * 获取wlzxcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWLZXCODE() {
        return wlzxcode;
    }

    /**
     * 设置wlzxcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWLZXCODE(String value) {
        this.wlzxcode = value;
    }

    /**
     * 获取huozid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHUOZID() {
        return huozid;
    }

    /**
     * 设置huozid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHUOZID(String value) {
        this.huozid = value;
    }

    /**
     * 获取riqidate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRIQIDATE() {
        return riqidate;
    }

    /**
     * 设置riqidate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRIQIDATE(String value) {
        this.riqidate = value;
    }

    /**
     * 获取yewstaff属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYEWSTAFF() {
        return yewstaff;
    }

    /**
     * 设置yewstaff属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYEWSTAFF(String value) {
        this.yewstaff = value;
    }

    /**
     * 获取danjnoy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDANJNOY() {
        return danjnoy;
    }

    /**
     * 设置danjnoy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDANJNOY(String value) {
        this.danjnoy = value;
    }

    /**
     * 获取danjmx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DANJMX }
     *     
     */
    public DANJMX getDANJMX() {
        return danjmx;
    }

    /**
     * 设置danjmx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DANJMX }
     *     
     */
    public void setDANJMX(DANJMX value) {
        this.danjmx = value;
    }

    /**
     * 获取yuanyin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYUANYIN() {
        return yuanyin;
    }

    /**
     * 设置yuanyin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYUANYIN(String value) {
        this.yuanyin = value;
    }

    /**
     * 获取note属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTE() {
        return note;
    }

    /**
     * 设置note属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTE(String value) {
        this.note = value;
    }

    /**
     * 获取peisnotes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPEISNOTES() {
        return peisnotes;
    }

    /**
     * 设置peisnotes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPEISNOTES(String value) {
        this.peisnotes = value;
    }

    /**
     * 获取tiaomnum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIAOMNUM() {
        return tiaomnum;
    }

    /**
     * 设置tiaomnum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIAOMNUM(String value) {
        this.tiaomnum = value;
    }

    /**
     * 获取zt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZT() {
        return zt;
    }

    /**
     * 设置zt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZT(String value) {
        this.zt = value;
    }

    /**
     * 获取danjnonc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDANJNONC() {
        return danjnonc;
    }

    /**
     * 设置danjnonc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDANJNONC(String value) {
        this.danjnonc = value;
    }

}
