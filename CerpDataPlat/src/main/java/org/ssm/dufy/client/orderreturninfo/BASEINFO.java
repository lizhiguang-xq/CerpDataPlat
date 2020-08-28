
package org.ssm.dufy.client.orderreturninfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BASEINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BASEINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PMSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SENDTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S_SYSTEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_SYSTEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RETRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BASEINFO", propOrder = {
    "msgid",
    "pmsgid",
    "sendtime",
    "ssystem",
    "servicename",
    "tsystem",
    "retry"
})
public class BASEINFO {

    @XmlElement(name = "MSGID")
    protected String msgid;
    @XmlElement(name = "PMSGID")
    protected String pmsgid;
    @XmlElement(name = "SENDTIME")
    protected String sendtime;
    @XmlElement(name = "S_SYSTEM")
    protected String ssystem;
    @XmlElement(name = "SERVICENAME")
    protected String servicename;
    @XmlElement(name = "T_SYSTEM")
    protected String tsystem;
    @XmlElement(name = "RETRY")
    protected String retry;

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
     * Gets the value of the ssystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSYSTEM() {
        return ssystem;
    }

    /**
     * Sets the value of the ssystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSYSTEM(String value) {
        this.ssystem = value;
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

    /**
     * Gets the value of the retry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETRY() {
        return retry;
    }

    /**
     * Sets the value of the retry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETRY(String value) {
        this.retry = value;
    }

}
