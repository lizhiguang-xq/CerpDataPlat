package org.ssm.dufy.entity.cerppojo;

import java.io.Serializable;

public class SuInvno implements Serializable {
	private static final long serialVersionUID = -4938249478488373081L;

	private String iodtlid;

    private String invcode;
    
    private String invno;
    
    private String invdate;
    
    private String supplyname;
    
    private String entryname;
    
    private String total_in;
    
    private String susetdtlid;
    
    private String total_line;;

	private String shtxdh;

	private String lplx;

	public String getIodtlid() {
		return iodtlid;
	}

	public void setIodtlid(String iodtlid) {
		this.iodtlid = iodtlid;
	}

	public String getInvcode() {
		return invcode;
	}

	public void setInvcode(String invcode) {
		this.invcode = invcode;
	}

	public String getInvno() {
		return invno;
	}

	public void setInvno(String invno) {
		this.invno = invno;
	}

	public String getInvdate() {
		return invdate;
	}

	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}

	public String getSupplyname() {
		return supplyname;
	}

	public void setSupplyname(String supplyname) {
		this.supplyname = supplyname;
	}

	public String getEntryname() {
		return entryname;
	}

	public void setEntryname(String entryname) {
		this.entryname = entryname;
	}

	public String getTotal_in() {
		return total_in;
	}

	public void setTotal_in(String total_in) {
		this.total_in = total_in;
	}

	public String getSusetdtlid() {
		return susetdtlid;
	}

	public void setSusetdtlid(String susetdtlid) {
		this.susetdtlid = susetdtlid;
	}

	public String getTotal_line() {
		return total_line;
	}

	public void setTotal_line(String total_line) {
		this.total_line = total_line;
	}

	public String getShtxdh() {
		return shtxdh;
	}

	public void setShtxdh(String shtxdh) {
		this.shtxdh = shtxdh;
	}

	public String getLplx() {
		return lplx;
	}

	public void setLplx(String lplx) {
		this.lplx = lplx;
	}
}
