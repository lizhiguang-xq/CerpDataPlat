//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.11.28 ʱ�� 03:29:41 PM CST 
//


package org.ssm.cxf.struct.pointorder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}ORDERID"/>
 *         &lt;element ref="{}CREATE_TIME"/>
 *         &lt;element ref="{}OLDDISPATCHPRICE"/>
 *         &lt;element ref="{}ENTRYCOMPANYID"/>
 *         &lt;element ref="{}TOTALINTEGRAL"/>
 *         &lt;element ref="{}INSIDERID"/>
 *         &lt;element ref="{}RETAILDETAILLIST"/>
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
    "orderid",
    "createtime",
    "olddispatchprice",
    "entrycompanyid",
    "totalintegral",
    "insiderid",
    "retaildetaillist"
})
@XmlRootElement(name = "POINTORDER_REQ")
public class POINTORDERREQ {

    @XmlElement(name = "ORDERID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String orderid;
    @XmlElement(name = "CREATE_TIME", required = true)
    protected String createtime;
    @XmlElement(name = "OLDDISPATCHPRICE", required = true)
    protected String olddispatchprice;
    @XmlElement(name = "ENTRYCOMPANYID", required = true)
    protected String entrycompanyid;
    @XmlElement(name = "TOTALINTEGRAL", required = true)
    protected String totalintegral;
    @XmlElement(name = "INSIDERID", required = true)
    protected String insiderid;
    @XmlElement(name = "RETAILDETAILLIST", required = true)
    protected RETAILDETAILLIST retaildetaillist;

    /**
     * ��ȡorderid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERID() {
        return orderid;
    }

    /**
     * ����orderid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERID(String value) {
        this.orderid = value;
    }

    /**
     * ��ȡcreatetime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREATETIME() {
        return createtime;
    }

    /**
     * ����createtime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREATETIME(String value) {
        this.createtime = value;
    }

    /**
     * ��ȡolddispatchprice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOLDDISPATCHPRICE() {
        return olddispatchprice;
    }

    /**
     * ����olddispatchprice���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOLDDISPATCHPRICE(String value) {
        this.olddispatchprice = value;
    }

    /**
     * ��ȡentrycompanyid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTRYCOMPANYID() {
        return entrycompanyid;
    }

    /**
     * ����entrycompanyid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTRYCOMPANYID(String value) {
        this.entrycompanyid = value;
    }

    /**
     * ��ȡtotalintegral���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALINTEGRAL() {
        return totalintegral;
    }

    /**
     * ����totalintegral���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALINTEGRAL(String value) {
        this.totalintegral = value;
    }

    /**
     * ��ȡinsiderid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSIDERID() {
        return insiderid;
    }

    /**
     * ����insiderid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSIDERID(String value) {
        this.insiderid = value;
    }

    /**
     * ��ȡretaildetaillist���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RETAILDETAILLIST }
     *     
     */
    public RETAILDETAILLIST getRETAILDETAILLIST() {
        return retaildetaillist;
    }

    /**
     * ����retaildetaillist���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RETAILDETAILLIST }
     *     
     */
    public void setRETAILDETAILLIST(RETAILDETAILLIST value) {
        this.retaildetaillist = value;
    }

}
