
package org.ssm.dufy.client.wms.edit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ssm.dufy.client.wms.edit package. 
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

    private final static QName _IREQUEST_QNAME = new QName("http://wservice.ckkpdmod/", "I_REQUEST");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ssm.dufy.client.wms.edit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceiveCkkpdMod }
     * 
     */
    public ReceiveCkkpdMod createReceiveCkkpdMod() {
        return new ReceiveCkkpdMod();
    }

    /**
     * Create an instance of {@link INFDATA }
     * 
     */
    public INFDATA createINFDATA() {
        return new INFDATA();
    }

    /**
     * Create an instance of {@link ReceiveCkkpdModResponse }
     * 
     */
    public ReceiveCkkpdModResponse createReceiveCkkpdModResponse() {
        return new ReceiveCkkpdModResponse();
    }

    /**
     * Create an instance of {@link GERPARRAYSTRING }
     * 
     */
    public GERPARRAYSTRING createGERPARRAYSTRING() {
        return new GERPARRAYSTRING();
    }

    /**
     * Create an instance of {@link GERPBASEINFO }
     * 
     */
    public GERPBASEINFO createGERPBASEINFO() {
        return new GERPBASEINFO();
    }

    /**
     * Create an instance of {@link GERPMESSAGE }
     * 
     */
    public GERPMESSAGE createGERPMESSAGE() {
        return new GERPMESSAGE();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link INFDATA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wservice.ckkpdmod/", name = "I_REQUEST")
    public JAXBElement<INFDATA> createIREQUEST(INFDATA value) {
        return new JAXBElement<INFDATA>(_IREQUEST_QNAME, INFDATA.class, null, value);
    }

}
