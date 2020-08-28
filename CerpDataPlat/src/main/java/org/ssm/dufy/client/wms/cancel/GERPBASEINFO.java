
package org.ssm.dufy.client.wms.cancel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GERP_BASEINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GERP_BASEINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PMSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SENDTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S_PROVINCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S_SYSYEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_PROVINCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_SYSTEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GERP_BASEINFO", propOrder = {
    "msgid",
    "pmsgid",
    "sendtime",
    "sprovince",
    "ssysyem",
    "servicename",
    "tprovince",
    "tsystem"
})
public class GERPBASEINFO {

    @XmlElement(name = "MSGID")
    protected String msgid;
    @XmlElement(name = "PMSGID")
    protected String pmsgid;
    @XmlElement(name = "SENDTIME")
    protected String sendtime;
    @XmlElement(name = "S_PROVINCE")
    protected String sprovince;
    @XmlElement(name = "S_SYSYEM")
    protected String ssysyem;
    @XmlElement(name = "SERVICENAME")
    protected String servicename;
    @XmlElement(name = "T_PROVINCE")
    protected String tprovince;
    @XmlElement(name = "T_SYSTEM")
    protected String tsystem;

    /**
     * Gets the value of the msgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGID() {
        return msgid;
    }

    /**
     * Sets the value of the msgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGID(String value) {
        this.msgid = value;
    }

    /**
     * Gets the value of the pmsgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMSGID() {
        return pmsgid;
    }

    /**
     * Sets the value of the pmsgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMSGID(String value) {
        this.pmsgid = value;
    }

    /**
     * Gets the value of the sendtime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDTIME() {
        return sendtime;
    }

    /**
     * Sets the value of the sendtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDTIME(String value) {
        this.sendtime = value;
    }

    /**
     * Gets the value of the sprovince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPROVINCE() {
        return sprovince;
    }

    /**
     * Sets the value of the sprovince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPROVINCE(String value) {
        this.sprovince = value;
    }

    /**
     * Gets the value of the ssysyem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSYSYEM() {
        return ssysyem;
    }

    /**
     * Sets the value of the ssysyem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSYSYEM(String value) {
        this.ssysyem = value;
    }

    /**
     * Gets the value of the servicename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICENAME() {
        return servicename;
    }

    /**
     * Sets the value of the servicename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICENAME(String value) {
        this.servicename = value;
    }

    /**
     * Gets the value of the tprovince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPROVINCE() {
        return tprovince;
    }

    /**
     * Sets the value of the tprovince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPROVINCE(String value) {
        this.tprovince = value;
    }

    /**
     * Gets the value of the tsystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTSYSTEM() {
        return tsystem;
    }

    /**
     * Sets the value of the tsystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTSYSTEM(String value) {
        this.tsystem = value;
    }

}
