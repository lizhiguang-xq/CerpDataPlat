//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.23 ʱ�� 12:08:18 PM CST 
//


package org.ssm.cxf.struct.suinvno;

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
 *         &lt;element ref="{}returncode"/>
 *         &lt;element ref="{}returnmsg"/>
 *         &lt;element ref="{}jhinvnoinfo"/>
 *         &lt;element ref="{}jhglgxinfo"/>
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
    "returncode",
    "returnmsg",
    "jhinvnoinfo",
    "jhglgxinfo"
})
@XmlRootElement(name = "SUINVNOINFO_RESP")
public class SUINVNOINFORESP {

    @XmlElement(required = true)
    protected String returncode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String returnmsg;
    @XmlElement(required = true)
    protected SUINVNOINFO jhinvnoinfo;
    @XmlElement(required = true)
    protected SUGLGXINFO jhglgxinfo;

    /**
     * ��ȡreturncode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturncode() {
        return returncode;
    }

    /**
     * ����returncode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturncode(String value) {
        this.returncode = value;
    }

    /**
     * ��ȡreturnmsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnmsg() {
        return returnmsg;
    }

    /**
     * ����returnmsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnmsg(String value) {
        this.returnmsg = value;
    }

    /**
     * ��ȡjhinvnoinfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SUINVNOINFO }
     *     
     */
    public SUINVNOINFO getJhinvnoinfo() {
        return jhinvnoinfo;
    }

    /**
     * ����jhinvnoinfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SUINVNOINFO }
     *     
     */
    public void setJhinvnoinfo(SUINVNOINFO value) {
        this.jhinvnoinfo = value;
    }

    /**
     * ��ȡjhglgxinfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SUGLGXINFO }
     *     
     */
    public SUGLGXINFO getJhglgxinfo() {
        return jhglgxinfo;
    }

    /**
     * ����jhglgxinfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SUGLGXINFO }
     *     
     */
    public void setJhglgxinfo(SUGLGXINFO value) {
        this.jhglgxinfo = value;
    }

}
