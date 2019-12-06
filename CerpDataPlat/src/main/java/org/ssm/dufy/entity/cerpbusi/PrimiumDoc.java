package org.ssm.dufy.entity.cerpbusi;

import java.io.Serializable;
import java.util.Date;

public class PrimiumDoc implements Serializable {
	
	private static final long serialVersionUID = 1657236176337492249L;

	private Integer primiumdocid;

    private Integer insiderid;
    
    private Integer entrycompanyid;
    
    private String jfscid;
    
    private Double totalintegral;
    
    private Double olddispatchprice;
    
    private Date credate;
    
    private Integer inputmanid;
    
    private Integer entryid;

	public Integer getPrimiumdocid() {
		return primiumdocid;
	}

	public void setPrimiumdocid(Integer primiumdocid) {
		this.primiumdocid = primiumdocid;
	}

	public Integer getInsiderid() {
		return insiderid;
	}

	public void setInsiderid(Integer insiderid) {
		this.insiderid = insiderid;
	}

	public Integer getEntrycompanyid() {
		return entrycompanyid;
	}

	public void setEntrycompanyid(Integer entrycompanyid) {
		this.entrycompanyid = entrycompanyid;
	}

	public String getJfscid() {
		return jfscid;
	}

	public void setJfscid(String jfscid) {
		this.jfscid = jfscid;
	}

	public Double getTotalintegral() {
		return totalintegral;
	}

	public void setTotalintegral(Double totalintegral) {
		this.totalintegral = totalintegral;
	}

	public Double getOlddispatchprice() {
		return olddispatchprice;
	}

	public void setOlddispatchprice(Double olddispatchprice) {
		this.olddispatchprice = olddispatchprice;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	public Integer getInputmanid() {
		return inputmanid;
	}

	public void setInputmanid(Integer inputmanid) {
		this.inputmanid = inputmanid;
	}

	public Integer getEntryid() {
		return entryid;
	}

	public void setEntryid(Integer entryid) {
		this.entryid = entryid;
	}

    
    

}
