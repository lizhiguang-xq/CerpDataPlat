//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.08.03 时间 03:04:46 PM CST 
//


package org.ssm.cxf.struct.wms.edit;

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
 *         &lt;element ref="{}ZT_ORDER_CHG_ID"/>
 *         &lt;element ref="{}WLZX_CODE"/>
 *         &lt;element ref="{}HUOZ_ID"/>
 *         &lt;element ref="{}DANW_ID"/>
 *         &lt;element ref="{}RIQI_DATE"/>
 *         &lt;element ref="{}TIH_WAY"/>
 *         &lt;element ref="{}NOTE"/>
 *         &lt;element ref="{}ECC_SHIPTO_REGION"/>
 *         &lt;element ref="{}ECC_SHIPTO_CITY"/>
 *         &lt;element ref="{}ECC_SHIPTO_DISTRICT"/>
 *         &lt;element ref="{}ADDRESS"/>
 *         &lt;element ref="{}SHOUH_PHONE"/>
 *         &lt;element ref="{}SHOUH_STAFF"/>
 *         &lt;element ref="{}POSTCODE"/>
 *         &lt;element ref="{}PEIS_NOTES"/>
 *         &lt;element ref="{}CARRIER_ID"/>
 *         &lt;element ref="{}SHAD_CITY"/>
 *         &lt;element ref="{}SHAD_CITY_DISTRICT"/>
 *         &lt;element ref="{}POSTAL_ZONE"/>
 *         &lt;element ref="{}DELIVERY_DATE"/>
 *         &lt;element ref="{}SHAD_RESIDENTIAL"/>
 *         &lt;element ref="{}SHAD_RESIDENTIAL_NUMBER"/>
 *         &lt;element ref="{}SHUIP_TYPE"/>
 *         &lt;element ref="{}FAH_TYPE"/>
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
    "ztorderchgid",
    "wlzxcode",
    "huozid",
    "danwid",
    "riqidate",
    "tihway",
    "note",
    "eccshiptoregion",
    "eccshiptocity",
    "eccshiptodistrict",
    "address",
    "shouhphone",
    "shouhstaff",
    "postcode",
    "peisnotes",
    "carrierid",
    "carriername",
    "shadcity",
    "shadcitydistrict",
    "postalzone",
    "deliverydate",
    "shadresidential",
    "shadresidentialnumber",
    "shuiptype",
    "fahtype"
})
@XmlRootElement(name = "T_CK_KPD_MOD")
public class TCKKPDMOD {

    @XmlElement(name = "DANJ_NO", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String danjno;
    @XmlElement(name = "ZT_ORDER_CHG_ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String ztorderchgid;
    @XmlElement(name = "WLZX_CODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String wlzxcode;
    @XmlElement(name = "HUOZ_ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String huozid;
    @XmlElement(name = "DANW_ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String danwid;
    @XmlElement(name = "RIQI_DATE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String riqidate;
    @XmlElement(name = "TIH_WAY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String tihway;
    @XmlElement(name = "NOTE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String note;
    @XmlElement(name = "ECC_SHIPTO_REGION", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String eccshiptoregion;
    @XmlElement(name = "ECC_SHIPTO_CITY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String eccshiptocity;
    @XmlElement(name = "ECC_SHIPTO_DISTRICT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String eccshiptodistrict;
    @XmlElement(name = "ADDRESS", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String address;
    @XmlElement(name = "SHOUH_PHONE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shouhphone;
    @XmlElement(name = "SHOUH_STAFF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shouhstaff;
    @XmlElement(name = "POSTCODE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String postcode;
    @XmlElement(name = "PEIS_NOTES", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String peisnotes;
    @XmlElement(name = "CARRIER_ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String carrierid;
    @XmlElement(name = "CARRIER_NAME", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String carriername;
    @XmlElement(name = "SHAD_CITY", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadcity;
    @XmlElement(name = "SHAD_CITY_DISTRICT", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadcitydistrict;
    @XmlElement(name = "POSTAL_ZONE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String postalzone;
    @XmlElement(name = "DELIVERY_DATE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String deliverydate;
    @XmlElement(name = "SHAD_RESIDENTIAL", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadresidential;
    @XmlElement(name = "SHAD_RESIDENTIAL_NUMBER", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadresidentialnumber;
    @XmlElement(name = "SHUIP_TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shuiptype;
    @XmlElement(name = "FAH_TYPE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fahtype;

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
     * 获取ztorderchgid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZTORDERCHGID() {
        return ztorderchgid;
    }

    /**
     * 设置ztorderchgid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZTORDERCHGID(String value) {
        this.ztorderchgid = value;
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
     * 获取danwid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDANWID() {
        return danwid;
    }

    /**
     * 设置danwid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDANWID(String value) {
        this.danwid = value;
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
     * 获取tihway属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIHWAY() {
        return tihway;
    }

    /**
     * 设置tihway属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIHWAY(String value) {
        this.tihway = value;
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
     * 获取eccshiptoregion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECCSHIPTOREGION() {
        return eccshiptoregion;
    }

    /**
     * 设置eccshiptoregion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECCSHIPTOREGION(String value) {
        this.eccshiptoregion = value;
    }

    /**
     * 获取eccshiptocity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECCSHIPTOCITY() {
        return eccshiptocity;
    }

    /**
     * 设置eccshiptocity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECCSHIPTOCITY(String value) {
        this.eccshiptocity = value;
    }

    /**
     * 获取eccshiptodistrict属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECCSHIPTODISTRICT() {
        return eccshiptodistrict;
    }

    /**
     * 设置eccshiptodistrict属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECCSHIPTODISTRICT(String value) {
        this.eccshiptodistrict = value;
    }

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESS() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESS(String value) {
        this.address = value;
    }

    /**
     * 获取shouhphone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHOUHPHONE() {
        return shouhphone;
    }

    /**
     * 设置shouhphone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHOUHPHONE(String value) {
        this.shouhphone = value;
    }

    /**
     * 获取shouhstaff属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHOUHSTAFF() {
        return shouhstaff;
    }

    /**
     * 设置shouhstaff属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHOUHSTAFF(String value) {
        this.shouhstaff = value;
    }

    /**
     * 获取postcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTCODE() {
        return postcode;
    }

    /**
     * 设置postcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTCODE(String value) {
        this.postcode = value;
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
     * 获取carrierid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARRIERID() {
        return carrierid;
    }

    /**
     * 设置carrierid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARRIERID(String value) {
        this.carrierid = value;
    }

    /**
     * 获取carriername属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCARRIERNAME() {
        return carriername;
    }

    /**
     * 设置carriername属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCARRIERNAME(String value) {
        this.carriername = value;
    }


    /**
     * 获取shadcity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADCITY() {
        return shadcity;
    }

    /**
     * 设置shadcity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADCITY(String value) {
        this.shadcity = value;
    }

    /**
     * 获取shadcitydistrict属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADCITYDISTRICT() {
        return shadcitydistrict;
    }

    /**
     * 设置shadcitydistrict属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADCITYDISTRICT(String value) {
        this.shadcitydistrict = value;
    }

    /**
     * 获取postalzone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTALZONE() {
        return postalzone;
    }

    /**
     * 设置postalzone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTALZONE(String value) {
        this.postalzone = value;
    }

    /**
     * 获取deliverydate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYDATE() {
        return deliverydate;
    }

    /**
     * 设置deliverydate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYDATE(String value) {
        this.deliverydate = value;
    }

    /**
     * 获取shadresidential属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADRESIDENTIAL() {
        return shadresidential;
    }

    /**
     * 设置shadresidential属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADRESIDENTIAL(String value) {
        this.shadresidential = value;
    }

    /**
     * 获取shadresidentialnumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHADRESIDENTIALNUMBER() {
        return shadresidentialnumber;
    }

    /**
     * 设置shadresidentialnumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHADRESIDENTIALNUMBER(String value) {
        this.shadresidentialnumber = value;
    }

    /**
     * 获取shuiptype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHUIPTYPE() {
        return shuiptype;
    }

    /**
     * 设置shuiptype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHUIPTYPE(String value) {
        this.shuiptype = value;
    }

    /**
     * 获取fahtype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAHTYPE() {
        return fahtype;
    }

    /**
     * 设置fahtype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAHTYPE(String value) {
        this.fahtype = value;
    }

}
