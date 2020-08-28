
package org.ssm.dufy.client.wms.cancel;

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
 *         &lt;element ref="{http://wservice.ckdel/}I_REQUEST" minOccurs="0"/>
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
    "irequest"
})
@XmlRootElement(name = "ReceiveCkdel")
public class ReceiveCkdel {

    @XmlElement(name = "I_REQUEST")
    protected INFDATA irequest;

    /**
     * Gets the value of the irequest property.
     * 
     * @return
     *     possible object is
     *     {@link INFDATA }
     *     
     */
    public INFDATA getIREQUEST() {
        return irequest;
    }

    /**
     * Sets the value of the irequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link INFDATA }
     *     
     */
    public void setIREQUEST(INFDATA value) {
        this.irequest = value;
    }

}
