//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.20 at 04:35:20 ���� CST 
//


package org.ssm.cxf.struct.pointpolicy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "repintegraldefid",
    "goodsid",
    "integral",
    "entrycompanyid",
    "begindate",
    "enddate"
})
@XmlRootElement(name = "POINTPOLICYINFO")
public class POINTPOLICYINFO {

    @XmlElement(required = true)
    protected String repintegraldefid;
    
    @XmlElement(required = true)
    protected String goodsid;
    
    @XmlElement(required = true)
    protected String integral;
    
    @XmlElement(required = true)
    protected String entrycompanyid;
    
    @XmlElement(required = true)
    protected String begindate;
    
    @XmlElement(required = true)
    protected String enddate;

	public String getRepintegraldefid() {
		return repintegraldefid;
	}

	public void setRepintegraldefid(String repintegraldefid) {
		this.repintegraldefid = repintegraldefid;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getEntrycompanyid() {
		return entrycompanyid;
	}

	public void setEntrycompanyid(String entrycompanyid) {
		this.entrycompanyid = entrycompanyid;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

}
