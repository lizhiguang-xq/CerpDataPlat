package org.ssm.dufy.entity.cerppojo;

import java.io.Serializable;

public class PointPolicy implements Serializable {
	private static final long serialVersionUID = 5527506999538165254L;

	private String repintegraldefid;

    private String goodsid;
    
    private String integral;
    
    private String entrycompanyid;
    
    private String begindate;
    
    private String enddate;

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
