//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.02.10 时间 02:52:15 PM CST 
//


package org.ssm.cxf.struct.applyorder_wy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}customid"/>
 *         &lt;element ref="{}entryid"/>
 *         &lt;element ref="{}agentid"/>
 *         &lt;element ref="{}contype"/>
 *         &lt;element ref="{}inputmanid"/>
 *         &lt;element ref="{}zx_outersys_orderid"/>
 *         &lt;element ref="{}zx_outersys_credate"/>
 *         &lt;element ref="{}zx_outersys_storageaddress"/>
 *         &lt;element ref="{}zx_outersys_storagename"/>
 *         &lt;element ref="{}zx_stsetid"/>
 *         &lt;element ref="{}memo"/>
 *         &lt;element ref="{}zx_outersys_id"/>
 *         &lt;element ref="{}zx_receiveman"/>
 *         &lt;element ref="{}zx_receivephone"/>
 *         &lt;element ref="{}zx_receiveaddr"/>
 *         &lt;element ref="{}orderinfo"/>
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
    "customid",
    "entryid",
    "agentid",
    "contype",
    "inputmanid",
    "zxOutersysOrderid",
    "zxOutersysCredate",
    "zxOutersysStorageaddress",
    "zxOutersysStoragename",
    "zxStsetid",
    "memo",
    "zxOutersysId",
    "zxReceiveman",
    "zxReceivephone",
    "zxReceiveaddr",
    "orderinfo"
})
@XmlRootElement(name = "APPLYORDER_WY_REQ")
public class APPLYORDERWYREQ {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String customid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String entryid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String agentid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String contype;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String inputmanid;
    @XmlElement(name = "zx_outersys_orderid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysOrderid;
    @XmlElement(name = "zx_outersys_credate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysCredate;
    @XmlElement(name = "zx_outersys_storageaddress", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysStorageaddress;
    @XmlElement(name = "zx_outersys_storagename", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysStoragename;
    @XmlElement(name = "zx_stsetid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxStsetid;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String memo;
    @XmlElement(name = "zx_outersys_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxOutersysId;
    @XmlElement(name = "zx_receiveman", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxReceiveman;
    @XmlElement(name = "zx_receivephone", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxReceivephone;
    @XmlElement(name = "zx_receiveaddr", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String zxReceiveaddr;
    @XmlElement(required = true)
    protected Orderinfo orderinfo;

    /**
     * 获取customid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomid() {
        return customid;
    }

    /**
     * 设置customid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomid(String value) {
        this.customid = value;
    }

    /**
     * 获取entryid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryid() {
        return entryid;
    }

    /**
     * 设置entryid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryid(String value) {
        this.entryid = value;
    }

    /**
     * 获取agentid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentid() {
        return agentid;
    }

    /**
     * 设置agentid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentid(String value) {
        this.agentid = value;
    }

    /**
     * 获取contype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContype() {
        return contype;
    }

    /**
     * 设置contype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContype(String value) {
        this.contype = value;
    }

    /**
     * 获取inputmanid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputmanid() {
        return inputmanid;
    }

    /**
     * 设置inputmanid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputmanid(String value) {
        this.inputmanid = value;
    }

    /**
     * 获取zxOutersysOrderid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysOrderid() {
        return zxOutersysOrderid;
    }

    /**
     * 设置zxOutersysOrderid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysOrderid(String value) {
        this.zxOutersysOrderid = value;
    }

    /**
     * 获取zxOutersysCredate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysCredate() {
        return zxOutersysCredate;
    }

    /**
     * 设置zxOutersysCredate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysCredate(String value) {
        this.zxOutersysCredate = value;
    }

    /**
     * 获取zxOutersysStorageaddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysStorageaddress() {
        return zxOutersysStorageaddress;
    }

    /**
     * 设置zxOutersysStorageaddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysStorageaddress(String value) {
        this.zxOutersysStorageaddress = value;
    }

    /**
     * 获取zxOutersysStoragename属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysStoragename() {
        return zxOutersysStoragename;
    }

    /**
     * 设置zxOutersysStoragename属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysStoragename(String value) {
        this.zxOutersysStoragename = value;
    }

    /**
     * 获取zxStsetid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxStsetid() {
        return zxStsetid;
    }

    /**
     * 设置zxStsetid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxStsetid(String value) {
        this.zxStsetid = value;
    }

    /**
     * 获取memo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置memo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemo(String value) {
        this.memo = value;
    }

    /**
     * 获取zxOutersysId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxOutersysId() {
        return zxOutersysId;
    }

    /**
     * 设置zxOutersysId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxOutersysId(String value) {
        this.zxOutersysId = value;
    }

    /**
     * 获取zxReceiveman属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxReceiveman() {
        return zxReceiveman;
    }

    /**
     * 设置zxReceiveman属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxReceiveman(String value) {
        this.zxReceiveman = value;
    }

    /**
     * 获取zxReceivephone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxReceivephone() {
        return zxReceivephone;
    }

    /**
     * 设置zxReceivephone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxReceivephone(String value) {
        this.zxReceivephone = value;
    }

    /**
     * 获取zxReceiveaddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZxReceiveaddr() {
        return zxReceiveaddr;
    }

    /**
     * 设置zxReceiveaddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZxReceiveaddr(String value) {
        this.zxReceiveaddr = value;
    }

    /**
     * 获取orderinfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Orderinfo }
     *     
     */
    public Orderinfo getOrderinfo() {
        return orderinfo;
    }

    /**
     * 设置orderinfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Orderinfo }
     *     
     */
    public void setOrderinfo(Orderinfo value) {
        this.orderinfo = value;
    }

}
