//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.22 at 11:00:41 ���� CST 
//


package org.ssm.cxf.struct.stock;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}GOODSID"/>
 *         &lt;element ref="{}STORAGEID"/>
 *         &lt;element ref="{}PLACEPOINTID"/>
 *         &lt;element ref="{}ENTRYID"/>
 *         &lt;element ref="{}YM"/>
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
    "goodsid",
    "storageid",
    "placepointid",
    "entrycompanyid",
    "ym"
})
@XmlRootElement(name = "STOCKINFO_REQ")
public class STOCKINFOREQ {

    @XmlElement(name = "GOODSID", required = true)
    protected String goodsid;
    @XmlElement(name = "STORAGEID", required = true)
    protected String storageid;
    @XmlElement(name = "PLACEPOINTID", required = true)
    protected String placepointid;
    @XmlElement(name = "ENTRYCOMPANYID", required = true)
    protected String entrycompanyid;
    @XmlElement(name = "YM", required = true)
    protected String ym;

    /**
     * Gets the value of the goodsid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGOODSID() {
        return goodsid;
    }

    /**
     * Sets the value of the goodsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGOODSID(String value) {
        this.goodsid = value;
    }

    /**
     * Gets the value of the storageid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTORAGEID() {
        return storageid;
    }

    /**
     * Sets the value of the storageid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTORAGEID(String value) {
        this.storageid = value;
    }

    /**
     * Gets the value of the placepointid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLACEPOINTID() {
        return placepointid;
    }

    /**
     * Sets the value of the placepointid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLACEPOINTID(String value) {
        this.placepointid = value;
    }

    /**
     * Gets the value of the entryid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTRYCOMPANYID() {
        return entrycompanyid;
    }

    /**
     * Sets the value of the entryid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTRYCOMPANYID(String value) {
        this.entrycompanyid = value;
    }

    /**
     * Gets the value of the ym property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYM() {
        return ym;
    }

    /**
     * Sets the value of the ym property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYM(String value) {
        this.ym = value;
    }

}
