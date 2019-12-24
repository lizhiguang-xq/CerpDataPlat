//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.12.23 ʱ�� 12:08:18 PM CST 
//


package org.ssm.cxf.struct.suinvno;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}jhglgxdetil" maxOccurs="unbounded"/>
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
    "jhglgxdetil"
})
@XmlRootElement(name = "jhglgxinfo")
public class SUGLGXINFO {

    @XmlElement(required = true)
    protected List<SUGLGXDETIL> jhglgxdetil;

    /**
     * Gets the value of the jhglgxdetil property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jhglgxdetil property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJhglgxdetil().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SUGLGXDETIL }
     * 
     * 
     */
    public List<SUGLGXDETIL> getJhglgxdetil() {
        if (jhglgxdetil == null) {
            jhglgxdetil = new ArrayList<SUGLGXDETIL>();
        }
        return this.jhglgxdetil;
    }

}
