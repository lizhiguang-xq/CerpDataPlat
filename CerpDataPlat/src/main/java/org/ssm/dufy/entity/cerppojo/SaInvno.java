package org.ssm.dufy.entity.cerppojo;

import java.io.Serializable;

public class SaInvno implements Serializable {
	
	private static final long serialVersionUID = -8951247863034702458L;

	private String iodtlid;

    private String invcode;
    
    private String invno;
    
    private String zx_jsdate;
    
    private String total;
    
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

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

	public String getZx_jsdate() {
		return zx_jsdate;
	}

	public void setZx_jsdate(String zx_jsdate) {
		this.zx_jsdate = zx_jsdate;
	}
}
