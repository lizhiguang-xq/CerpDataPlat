
package org.ssm.dufy.client.wms.cancel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WmsCkdelSoap", targetNamespace = "http://wservice.ckdel/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WmsCkdelSoap {


    /**
     * 
     * @param iREQUEST
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ReceiveCkdel", action = "http://wservice.ckdel/ReceiveCkdel")
    @WebResult(name = "ReceiveCkdelResult", targetNamespace = "http://wservice.ckdel/")
    @RequestWrapper(localName = "ReceiveCkdel", targetNamespace = "http://wservice.ckdel/", className = "org.ssm.dufy.client.wms.cancel.ReceiveCkdel")
    @ResponseWrapper(localName = "ReceiveCkdelResponse", targetNamespace = "http://wservice.ckdel/", className = "org.ssm.dufy.client.wms.cancel.ReceiveCkdelResponse")
    public String receiveCkdel(
        @WebParam(name = "I_REQUEST", targetNamespace = "http://wservice.ckdel/")
        INFDATA iREQUEST);

}
