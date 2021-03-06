
package org.ssm.dufy.client.orderreturninfo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "OrderReturnInfoServiceImplService", targetNamespace = "http://impl.service.erp.oms.tasly.com/", wsdlLocation = "http://10.9.5.72:8080/tasly-oms/services/orderreturninfo?wsdl")
public class OrderReturnInfoServiceImplService
    extends Service
{

    private final static URL ORDERRETURNINFOSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException ORDERRETURNINFOSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName ORDERRETURNINFOSERVICEIMPLSERVICE_QNAME = new QName("http://impl.service.erp.oms.tasly.com/", "OrderReturnInfoServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
//        try {
//            url = new URL("http://10.9.5.72:8080/tasly-oms/services/orderreturninfo?wsdl");
//        } catch (MalformedURLException ex) {
//            e = new WebServiceException(ex);
//        }
        ORDERRETURNINFOSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        ORDERRETURNINFOSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public OrderReturnInfoServiceImplService() {
        super(__getWsdlLocation(), ORDERRETURNINFOSERVICEIMPLSERVICE_QNAME);
    }

    public OrderReturnInfoServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ORDERRETURNINFOSERVICEIMPLSERVICE_QNAME, features);
    }

    public OrderReturnInfoServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, ORDERRETURNINFOSERVICEIMPLSERVICE_QNAME);
    }

    public OrderReturnInfoServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ORDERRETURNINFOSERVICEIMPLSERVICE_QNAME, features);
    }

    public OrderReturnInfoServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrderReturnInfoServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IOrderReturnInfoService
     */
    @WebEndpoint(name = "OrderReturnInfoServiceImplPort")
    public IOrderReturnInfoService getOrderReturnInfoServiceImplPort() {
        return super.getPort(new QName("http://impl.service.erp.oms.tasly.com/", "OrderReturnInfoServiceImplPort"), IOrderReturnInfoService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IOrderReturnInfoService
     */
    @WebEndpoint(name = "OrderReturnInfoServiceImplPort")
    public IOrderReturnInfoService getOrderReturnInfoServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.service.erp.oms.tasly.com/", "OrderReturnInfoServiceImplPort"), IOrderReturnInfoService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ORDERRETURNINFOSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw ORDERRETURNINFOSERVICEIMPLSERVICE_EXCEPTION;
        }
        return ORDERRETURNINFOSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
