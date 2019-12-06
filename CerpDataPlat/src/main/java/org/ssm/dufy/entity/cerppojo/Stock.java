package org.ssm.dufy.entity.cerppojo;

import java.io.Serializable;

public class Stock implements Serializable {
	private static final long serialVersionUID = 4913665174419869115L;
	private String goodsid;
	private String storageid;
	private String goodsdtlid;
	private String batchid;
	private String lotid;
	private String posid;
	private String goodsstatusid;
	private String placepointid;
	private String qty;
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getStorageid() {
		return storageid;
	}
	public void setStorageid(String storageid) {
		this.storageid = storageid;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getPlacepointid() {
		return placepointid;
	}
	public void setPlacepointid(String placepointid) {
		this.placepointid = placepointid;
	}
	public String getGoodsdtlid() {
		return goodsdtlid;
	}
	public void setGoodsdtlid(String goodsdtlid) {
		this.goodsdtlid = goodsdtlid;
	}
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getLotid() {
		return lotid;
	}
	public void setLotid(String lotid) {
		this.lotid = lotid;
	}
	public String getPosid() {
		return posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
	}
	public String getGoodsstatusid() {
		return goodsstatusid;
	}
	public void setGoodsstatusid(String goodsstatusid) {
		this.goodsstatusid = goodsstatusid;
	}
	
	
}
