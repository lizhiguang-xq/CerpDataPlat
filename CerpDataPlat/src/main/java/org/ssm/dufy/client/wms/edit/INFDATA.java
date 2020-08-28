
package org.ssm.dufy.client.wms.edit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for INFDATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="INFDATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BASEINFO" type="{http://wservice.ckkpdmod/}GERP_BASEINFO" minOccurs="0"/>
 *         &lt;element name="MESSAGE" type="{http://wservice.ckkpdmod/}GERP_MESSAGE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INFDATA", propOrder = {
    "baseinfo",
    "message"
})
public class INFDATA {

    @XmlElement(name = "BASEINFO")
    protected GERPBASEINFO baseinfo;
    @XmlElement(name = "MESSAGE")
    protected GERPMESSAGE message;

    /**
     * Gets the value of the baseinfo property.
     * 
     * @return
     *     possible object is
     *     {@link GERPBASEINFO }
     *     
     */
    public GERPBASEINFO getBASEINFO() {
        return baseinfo;
    }

    /**
     * Sets the value of the baseinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link GERPBASEINFO }
     *     
     */
    public void setBASEINFO(GERPBASEINFO value) {
        this.baseinfo = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link GERPMESSAGE }
     *     
     */
    public GERPMESSAGE getMESSAGE() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link GERPMESSAGE }
     *     
     */
    public void setMESSAGE(GERPMESSAGE value) {
        this.message = value;
    }

}
