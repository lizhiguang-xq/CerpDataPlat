package org.ssm.dufy.entity.cerppojo;

import java.io.Serializable;

public class Goods implements Serializable {
	private static final long serialVersionUID = -3739248895904063911L;
	
	private String goodsid;
	private String goodsname;
	private String goodsunit;
	private String goodstype;
	private String currencyname;
	private String factoryname;
	private String entryid;
	private String barcode;
	private String sys_modifydate;
	private String entrycompanyid;
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodsunit() {
		return goodsunit;
	}
	public void setGoodsunit(String goodsunit) {
		this.goodsunit = goodsunit;
	}
	public String getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public String getFactoryname() {
		return factoryname;
	}
	public void setFactoryname(String factoryname) {
		this.factoryname = factoryname;
	}
	public String getEntryid() {
		return entryid;
	}
	public void setEntryid(String entryid) {
		this.entryid = entryid;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getSys_modifydate() {
		return sys_modifydate;
	}
	public void setSys_modifydate(String sys_modifydate) {
		this.sys_modifydate = sys_modifydate;
	}
	
	
	public String getEntrycompanyid() {
		return entrycompanyid;
	}
	public void setEntrycompanyid(String entrycompanyid) {
		this.entrycompanyid = entrycompanyid;
	}

	
}
