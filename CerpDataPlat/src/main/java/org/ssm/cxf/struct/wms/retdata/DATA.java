//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.08.03 时间 02:47:10 PM CST 
//


package org.ssm.cxf.struct.wms.retdata;

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
 *         &lt;element ref="{}RETDATA"/>
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
    "retdata"
})
@XmlRootElement(name = "DATA")
public class DATA {

    @XmlElement(name = "RETDATA", required = true)
    protected RETDATA retdata;

    /**
     * 获取retdata属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RETDATA }
     *     
     */
    public RETDATA getRETDATA() {
        return retdata;
    }

    /**
     * 设置retdata属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RETDATA }
     *     
     */
    public void setRETDATA(RETDATA value) {
        this.retdata = value;
    }

}
