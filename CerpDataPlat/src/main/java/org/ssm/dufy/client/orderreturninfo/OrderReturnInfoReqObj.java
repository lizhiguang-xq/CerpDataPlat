
package org.ssm.dufy.client.orderreturninfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderReturnInfoReqObj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderReturnInfoReqObj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BASEINFO" type="{http://service.erp.oms.tasly.com/}BASEINFO" minOccurs="0"/>
 *         &lt;element name="MESSAGE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ORDERRETURNINFO" type="{http://service.erp.oms.tasly.com/}ORDER_RETURN_INFO_DATA" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderReturnInfoReqObj", propOrder = {
    "baseinfo",
    "message"
})
public class OrderReturnInfoReqObj {

    @XmlElement(name = "BASEINFO")
    protected BASEINFO baseinfo;
    @XmlElement(name = "MESSAGE")
    protected OrderReturnInfoReqObj.MESSAGE message;

    /**
     * Gets the value of the baseinfo property.
     * 
     * @return
     *     possible object is
     *     {@link BASEINFO }
     *     
     */
    public BASEINFO getBASEINFO() {
        return baseinfo;
    }

    /**
     * Sets the value of the baseinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BASEINFO }
     *     
     */
    public void setBASEINFO(BASEINFO value) {
        this.baseinfo = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link OrderReturnInfoReqObj.MESSAGE }
     *     
     */
    public OrderReturnInfoReqObj.MESSAGE getMESSAGE() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReturnInfoReqObj.MESSAGE }
     *     
     */
    public void setMESSAGE(OrderReturnInfoReqObj.MESSAGE value) {
        this.message = value;
    }


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
     *         &lt;element name="ORDERRETURNINFO" type="{http://service.erp.oms.tasly.com/}ORDER_RETURN_INFO_DATA" maxOccurs="unbounded" minOccurs="0"/>
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
        "orderreturninfo"
    })
    public static class MESSAGE {

        @XmlElement(name = "ORDERRETURNINFO")
        protected List<ORDERRETURNINFODATA> orderreturninfo;

        /**
         * Gets the value of the orderreturninfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the orderreturninfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getORDERRETURNINFO().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ORDERRETURNINFODATA }
         * 
         * 
         */
        public List<ORDERRETURNINFODATA> getORDERRETURNINFO() {
            if (orderreturninfo == null) {
                orderreturninfo = new ArrayList<ORDERRETURNINFODATA>();
            }
            return this.orderreturninfo;
        }

    }

}
