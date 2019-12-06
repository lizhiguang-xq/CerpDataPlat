package org.ssm.dufy.entity.cerpbusi;

import java.io.Serializable;
import java.util.Date;

public class CerpStIoDtl implements Serializable {

	private static final long serialVersionUID = -4153646416474189650L;

	private Integer iodtlid;

    private Integer inoutid;
    
    private Integer batchid;
    
    private Integer lotid;
    
    private Integer posid;
    
    private Integer goodsdtlid;
    
    private Integer goodsstatusid;
    
    private Double dtlgoodsqty;

	public Integer getIodtlid() {
		return iodtlid;
	}

	public void setIodtlid(Integer iodtlid) {
		this.iodtlid = iodtlid;
	}

	public Integer getInoutid() {
		return inoutid;
	}

	public void setInoutid(Integer inoutid) {
		this.inoutid = inoutid;
	}

	public Integer getBatchid() {
		return batchid;
	}

	public void setBatchid(Integer batchid) {
		this.batchid = batchid;
	}

	public Integer getLotid() {
		return lotid;
	}

	public void setLotid(Integer lotid) {
		this.lotid = lotid;
	}

	public Integer getPosid() {
		return posid;
	}

	public void setPosid(Integer posid) {
		this.posid = posid;
	}

	public Integer getGoodsdtlid() {
		return goodsdtlid;
	}

	public void setGoodsdtlid(Integer goodsdtlid) {
		this.goodsdtlid = goodsdtlid;
	}

	public Integer getGoodsstatusid() {
		return goodsstatusid;
	}

	public void setGoodsstatusid(Integer goodsstatusid) {
		this.goodsstatusid = goodsstatusid;
	}

	public Double getDtlgoodsqty() {
		return dtlgoodsqty;
	}

	public void setDtlgoodsqty(Double dtlgoodsqty) {
		this.dtlgoodsqty = dtlgoodsqty;
	}
    
    
}
