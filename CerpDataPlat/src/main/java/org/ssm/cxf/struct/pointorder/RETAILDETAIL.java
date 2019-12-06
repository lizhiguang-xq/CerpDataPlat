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
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}GOODSID"/>
 *         &lt;element ref="{}QTY"/>
 *         &lt;element ref="{}INTEGRAL"/>
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
    "goodsid",
    "qty",
    "integral",
    "goodsname"
})
@XmlRootElement(name = "RETAILDETAIL")
public class RETAILDETAIL {

    @XmlElement(name = "GOODSID", required = true)
    protected String goodsid;
    @XmlElement(name = "QTY", required = true)
    protected String qty;
    @XmlElement(name = "INTEGRAL", required = true)
    protected String integral;
    @XmlElement(name = "GOODSNAME", required = true)
    protected String goodsname;

    /**
     * ��ȡgoodsid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGOODSID() {
        return goodsid;
    }

    /**
     * ����goodsid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGOODSID(String value) {
        this.goodsid = value;
    }

    /**
     * ��ȡqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQTY() {
        return qty;
    }

    /**
     * ����qty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQTY(String value) {
        this.qty = value;
    }

    /**
     * ��ȡintegral���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTEGRAL() {
        return integral;
    }

    /**
     * ����integral���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTEGRAL(String value) {
        this.integral = value;
    }
    
    
    public String getGOODSNAME() {
        return goodsname;
    }
    public void setGOODSNAME(String value) {
        this.goodsname = value;
    }

}
