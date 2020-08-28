//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.07.21 时间 11:10:18 AM CST 
//


package org.ssm.cxf.struct.wms.cancel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}T_CK_KPD_DEL"/>
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
    "tckkpddel"
})
@XmlRootElement(name = "ARRAYOFT_CK_KPD_DEL")
public class ARRAYOFTCKKPDDEL {

    @XmlElement(name = "T_CK_KPD_DEL", required = true)
    protected TCKKPDDEL tckkpddel;

    /**
     * 获取tckkpddel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TCKKPDDEL }
     *     
     */
    public TCKKPDDEL getTCKKPDDEL() {
        return tckkpddel;
    }

    /**
     * 设置tckkpddel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TCKKPDDEL }
     *     
     */
    public void setTCKKPDDEL(TCKKPDDEL value) {
        this.tckkpddel = value;
    }

}
