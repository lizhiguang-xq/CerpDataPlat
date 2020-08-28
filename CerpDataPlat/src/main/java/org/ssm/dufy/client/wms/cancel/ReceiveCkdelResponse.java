
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
 *         &lt;element name="ReceiveCkdelResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "receiveCkdelResult"
})
@XmlRootElement(name = "ReceiveCkdelResponse")
public class ReceiveCkdelResponse {

    @XmlElement(name = "ReceiveCkdelResult")
    protected String receiveCkdelResult;

    /**
     * Gets the value of the receiveCkdelResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiveCkdelResult() {
        return receiveCkdelResult;
    }

    /**
     * Sets the value of the receiveCkdelResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiveCkdelResult(String value) {
        this.receiveCkdelResult = value;
    }

}
