package org.ssm.dufy.entity.cerppojo;

import java.io.Serializable;

public class PlacePoint implements Serializable {
	private static final long serialVersionUID = -3750630457672516533L;
	private String placepointid;
	private String placepointname;
	private String tel;
	private String address;
	public String getPlacepointid() {
		return placepointid;
	}
	public void setPlacepointid(String placepointid) {
		this.placepointid = placepointid;
	}
	public String getPlacepointname() {
		return placepointname;
	}
	public void setPlacepointname(String placepointname) {
		this.placepointname = placepointname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
