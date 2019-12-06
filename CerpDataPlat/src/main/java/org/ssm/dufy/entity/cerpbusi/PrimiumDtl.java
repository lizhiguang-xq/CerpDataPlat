package org.ssm.dufy.entity.cerpbusi;

import java.io.Serializable;

public class PrimiumDtl implements Serializable {
	
	private static final long serialVersionUID = 5535763067631998220L;

	private Integer primiumdocid;
	
	private Integer primiumdtlid;

    private Integer goodsid;
    
    private Double qty;
    
    private Double integral;

	public Integer getPrimiumdocid() {
		return primiumdocid;
	}

	public void setPrimiumdocid(Integer primiumdocid) {
		this.primiumdocid = primiumdocid;
	}

	public Integer getPrimiumdtlid() {
		return primiumdtlid;
	}

	public void setPrimiumdtlid(Integer primiumdtlid) {
		this.primiumdtlid = primiumdtlid;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getIntegral() {
		return integral;
	}

	public void setIntegral(Double integral) {
		this.integral = integral;
	}
}
