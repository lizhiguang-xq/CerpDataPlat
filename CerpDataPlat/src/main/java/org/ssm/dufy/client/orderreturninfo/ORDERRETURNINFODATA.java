
package org.ssm.dufy.client.orderreturninfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORDER_RETURN_INFO_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORDER_RETURN_INFO_DATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OMS_ORDER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OPERATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RESULT_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RESULT_MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECC_ORDER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDER_RETURN_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDER_ITEMS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OMS_ITEM_ID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ORDER_RETURN_INFO_DATA", propOrder = {
    "omsorderid",
    "operation",
    "resultcode",
    "resultmessage",
    "eccorderid",
    "orderreturnid",
    "orderitems"
})
public class ORDERRETURNINFODATA {

    @XmlElement(name = "OMS_ORDER_ID")
    protected String omsorderid;
    @XmlElement(name = "OPERATION")
    protected String operation;
    @XmlElement(name = "RESULT_CODE")
    protected String resultcode;
    @XmlElement(name = "RESULT_MESSAGE")
    protected String resultmessage;
    @XmlElement(name = "ECC_ORDER_ID")
    protected String eccorderid;
    @XmlElement(name = "ORDER_RETURN_ID")
    protected String orderreturnid;
    @XmlElement(name = "ORDER_ITEMS")
    protected ORDERRETURNINFODATA.ORDERITEMS orderitems;

    /**
     * Gets the value of the omsorderid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOMSORDERID() {
        return omsorderid;
    }

    /**
     * Sets the value of the omsorderid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOMSORDERID(String value) {
        this.omsorderid = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATION() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATION(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the resultcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESULTCODE() {
        return resultcode;
    }

    /**
     * Sets the value of the resultcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESULTCODE(String value) {
        this.resultcode = value;
    }

    /**
     * Gets the value of the resultmessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESULTMESSAGE() {
        return resultmessage;
    }

    /**
     * Sets the value of the resultmessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESULTMESSAGE(String value) {
        this.resultmessage = value;
    }

    /**
     * Gets the value of the eccorderid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECCORDERID() {
        return eccorderid;
    }

    /**
     * Sets the value of the eccorderid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECCORDERID(String value) {
        this.eccorderid = value;
    }

    /**
     * Gets the value of the orderreturnid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERRETURNID() {
        return orderreturnid;
    }

    /**
     * Sets the value of the orderreturnid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERRETURNID(String value) {
        this.orderreturnid = value;
    }

    /**
     * Gets the value of the orderitems property.
     * 
     * @return
     *     possible object is
     *     {@link ORDERRETURNINFODATA.ORDERITEMS }
     *     
     */
    public ORDERRETURNINFODATA.ORDERITEMS getORDERITEMS() {
        return orderitems;
    }

    /**
     * Sets the value of the orderitems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ORDERRETURNINFODATA.ORDERITEMS }
     *     
     */
    public void setORDERITEMS(ORDERRETURNINFODATA.ORDERITEMS value) {
        this.orderitems = value;
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
     *         &lt;element name="OMS_ITEM_ID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "omsitemid"
    })
    public static class ORDERITEMS {

        @XmlElement(name = "OMS_ITEM_ID")
        protected List<String> omsitemid;

        /**
         * Gets the value of the omsitemid property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the omsitemid property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOMSITEMID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getOMSITEMID() {
            if (omsitemid == null) {
                omsitemid = new ArrayList<String>();
            }
            return this.omsitemid;
        }

    }

}
