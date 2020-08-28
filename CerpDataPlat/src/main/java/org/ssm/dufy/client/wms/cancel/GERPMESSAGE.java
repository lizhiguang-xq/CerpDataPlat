
package org.ssm.dufy.client.wms.cancel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GERP_MESSAGE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GERP_MESSAGE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ARRAYSTRING" type="{http://wservice.ckdel/}GERP_ARRAYSTRING" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GERP_MESSAGE", propOrder = {
    "arraystring"
})
public class GERPMESSAGE {

    @XmlElement(name = "ARRAYSTRING")
    protected GERPARRAYSTRING arraystring;

    /**
     * Gets the value of the arraystring property.
     * 
     * @return
     *     possible object is
     *     {@link GERPARRAYSTRING }
     *     
     */
    public GERPARRAYSTRING getARRAYSTRING() {
        return arraystring;
    }

    /**
     * Sets the value of the arraystring property.
     * 
     * @param value
     *     allowed object is
     *     {@link GERPARRAYSTRING }
     *     
     */
    public void setARRAYSTRING(GERPARRAYSTRING value) {
        this.arraystring = value;
    }

}
