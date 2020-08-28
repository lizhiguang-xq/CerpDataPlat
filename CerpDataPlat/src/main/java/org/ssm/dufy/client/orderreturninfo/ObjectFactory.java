
package org.ssm.dufy.client.orderreturninfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ssm.dufy.client.orderreturninfo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ORDERRETURNINFODATA_QNAME = new QName("http://service.erp.oms.tasly.com/", "ORDER_RETURN_INFO_DATA");
    private final static QName _OrderResultReturn_QNAME = new QName("http://service.erp.oms.tasly.com/", "OrderResultReturn");
    private final static QName _REQUEST_QNAME = new QName("http://service.erp.oms.tasly.com/", "REQUEST");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ssm.dufy.client.orderreturninfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderReturnInfoReqObj }
     * 
     */
    public OrderReturnInfoReqObj createOrderReturnInfoReqObj() {
        return new OrderReturnInfoReqObj();
    }

    /**
     * Create an instance of {@link ORDERRETURNINFODATA }
     * 
     */
    public ORDERRETURNINFODATA createORDERRETURNINFODATA() {
        return new ORDERRETURNINFODATA();
    }

    /**
     * Create an instance of {@link OrderResultReturn }
     * 
     */
    public OrderResultReturn createOrderResultReturn() {
        return new OrderResultReturn();
    }

    /**
     * Create an instance of {@link BASEINFO }
     * 
     */
    public BASEINFO createBASEINFO() {
        return new BASEINFO();
    }

    /**
     * Create an instance of {@link OrderReturnInfoReqObj.MESSAGE }
     * 
     */
    public OrderReturnInfoReqObj.MESSAGE createOrderReturnInfoReqObjMESSAGE() {
        return new OrderReturnInfoReqObj.MESSAGE();
    }

    /**
     * Create an instance of {@link ORDERRETURNINFODATA.ORDERITEMS }
     * 
     */
    public ORDERRETURNINFODATA.ORDERITEMS createORDERRETURNINFODATAORDERITEMS() {
        return new ORDERRETURNINFODATA.ORDERITEMS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ORDERRETURNINFODATA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.erp.oms.tasly.com/", name = "ORDER_RETURN_INFO_DATA")
    public JAXBElement<ORDERRETURNINFODATA> createORDERRETURNINFODATA(ORDERRETURNINFODATA value) {
        return new JAXBElement<ORDERRETURNINFODATA>(_ORDERRETURNINFODATA_QNAME, ORDERRETURNINFODATA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderResultReturn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.erp.oms.tasly.com/", name = "OrderResultReturn")
    public JAXBElement<OrderResultReturn> createOrderResultReturn(OrderResultReturn value) {
        return new JAXBElement<OrderResultReturn>(_OrderResultReturn_QNAME, OrderResultReturn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderReturnInfoReqObj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.erp.oms.tasly.com/", name = "REQUEST")
    public JAXBElement<OrderReturnInfoReqObj> createREQUEST(OrderReturnInfoReqObj value) {
        return new JAXBElement<OrderReturnInfoReqObj>(_REQUEST_QNAME, OrderReturnInfoReqObj.class, null, value);
    }

}
