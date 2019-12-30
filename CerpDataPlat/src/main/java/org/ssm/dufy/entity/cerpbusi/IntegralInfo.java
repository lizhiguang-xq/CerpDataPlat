package org.ssm.dufy.entity.cerpbusi;

import java.io.Serializable;
import java.util.Date;

public class IntegralInfo implements Serializable {
	
	private static final long serialVersionUID = -1878427827665605322L;
	private Integer infoid;
	private Integer insiderid;
	private Integer comefrom;
	private Integer docid;
	private Date credate ;
	private Double  debitintegal;
	private Double  lenderintegal;
	private Integer placepointid;
	
	
	public Double getLenderintegal() {
		return lenderintegal;
	}
	public void setLenderintegal(Double lenderintegal) {
		this.lenderintegal = lenderintegal;
	}
	public Integer getInfoid() {
		return infoid;
	}
	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}
	public Integer getInsiderid() {
		return insiderid;
	}
	public void setInsiderid(Integer insiderid) {
		this.insiderid = insiderid;
	}
	public Integer getComefrom() {
		return comefrom;
	}
	public void setComefrom(Integer comefrom) {
		this.comefrom = comefrom;
	}
	public Integer getDocid() {
		return docid;
	}
	public void setDocid(Integer docid) {
		this.docid = docid;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	public Double getDebitintegal() {
		return debitintegal;
	}
	public void setDebitintegal(Double debitintegal) {
		this.debitintegal = debitintegal;
	}
	public Integer getPlacepointid() {
		return placepointid;
	}
	public void setPlacepointid(Integer placepointid) {
		this.placepointid = placepointid;
	}

}
