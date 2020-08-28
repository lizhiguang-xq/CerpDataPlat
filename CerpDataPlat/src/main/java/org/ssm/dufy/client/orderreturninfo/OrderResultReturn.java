
package org.ssm.dufy.client.orderreturninfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderResultReturn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderResultReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderResultInfo" type="{http://service.erp.oms.tasly.com/}orderReturnInfoReqObj" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderResultReturn", propOrder = {
    "orderResultInfo"
})
public class OrderResultReturn {

    @XmlElement(name = "OrderResultInfo")
    protected OrderReturnInfoReqObj orderResultInfo;

    /**
     * Gets the value of the orderResultInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OrderReturnInfoReqObj }
     *     
     */
    public OrderReturnInfoReqObj getOrderResultInfo() {
        return orderResultInfo;
    }

    /**
     * Sets the value of the orderResultInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReturnInfoReqObj }
     *     
     */
    public void setOrderResultInfo(OrderReturnInfoReqObj value) {
        this.orderResultInfo = value;
    }

}
