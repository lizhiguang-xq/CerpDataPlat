
package org.ssm.dufy.client.wms.edit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GERP_ARRAYSTRING complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GERP_ARRAYSTRING">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infmsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GERP_ARRAYSTRING", propOrder = {
    "infmsg"
})
public class GERPARRAYSTRING {

    protected String infmsg;

    /**
     * Gets the value of the infmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfmsg() {
        return infmsg;
    }

    /**
     * Sets the value of the infmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfmsg(String value) {
        this.infmsg = value;
    }

}
