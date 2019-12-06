package org.ssm.dufy.entity.cerpbusi;

import java.io.Serializable;
import java.util.Date;

public class CerpStIoDoc implements Serializable {
	
	private static final long serialVersionUID = 1900401612629288310L;

	private Integer inoutid;

    private Date credate;
    
    private Integer comefrom;
    
    private Integer sourcetable;
    
    private Integer sourceid;
    
    private Integer companyid;
    
    private Date keepdate;
    
    private Integer keepmanid;
    
    private Integer goodsid;
    
    private Integer storageid;
    
    private Integer inoutflag;
    
    private Double outqty;
    
    private Double oldoutqty;
    
    private String goodsunit;
    
    private Integer usestatus;
    
    private Integer entryid;
    
    private Integer preparestatus;
    
    private Date sys_modifydate;

	public Integer getInoutid() {
		return inoutid;
	}

	public void setInoutid(Integer inoutid) {
		this.inoutid = inoutid;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	public Integer getComefrom() {
		return comefrom;
	}

	public void setComefrom(Integer comefrom) {
		this.comefrom = comefrom;
	}

	public Integer getSourcetable() {
		return sourcetable;
	}

	public void setSourcetable(Integer sourcetable) {
		this.sourcetable = sourcetable;
	}

	public Integer getSourceid() {
		return sourceid;
	}

	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Date getKeepdate() {
		return keepdate;
	}

	public void setKeepdate(Date keepdate) {
		this.keepdate = keepdate;
	}

	public Integer getKeepmanid() {
		return keepmanid;
	}

	public void setKeepmanid(Integer keepmanid) {
		this.keepmanid = keepmanid;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getStorageid() {
		return storageid;
	}

	public void setStorageid(Integer storageid) {
		this.storageid = storageid;
	}

	public Integer getInoutflag() {
		return inoutflag;
	}

	public void setInoutflag(Integer inoutflag) {
		this.inoutflag = inoutflag;
	}

	public Double getOutqty() {
		return outqty;
	}

	public void setOutqty(Double outqty) {
		this.outqty = outqty;
	}

	public Double getOldoutqty() {
		return oldoutqty;
	}

	public void setOldoutqty(Double oldoutqty) {
		this.oldoutqty = oldoutqty;
	}

	public String getGoodsunit() {
		return goodsunit;
	}

	public void setGoodsunit(String goodsunit) {
		this.goodsunit = goodsunit;
	}

	public Integer getUsestatus() {
		return usestatus;
	}

	public void setUsestatus(Integer usestatus) {
		this.usestatus = usestatus;
	}

	public Integer getEntryid() {
		return entryid;
	}

	public void setEntryid(Integer entryid) {
		this.entryid = entryid;
	}

	public Integer getPreparestatus() {
		return preparestatus;
	}

	public void setPreparestatus(Integer preparestatus) {
		this.preparestatus = preparestatus;
	}

	public Date getSys_modifydate() {
		return sys_modifydate;
	}

	public void setSys_modifydate(Date sys_modifydate) {
		this.sys_modifydate = sys_modifydate;
	}
}
