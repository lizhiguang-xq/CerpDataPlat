package org.ssm.dufy.entity.cerppojo;

import java.io.Serializable;

public class Insider implements Serializable {
	
	private static final long serialVersionUID = 4955604010137888654L;

	private String insiderid;

    private String insidername;
    
    private String sex;
    
    private String birthdate;
    
    private String integral;
    
    private String entrycompanyid;
    
    private String mobile;

	public String getInsiderid() {
		return insiderid;
	}

	public void setInsiderid(String insiderid) {
		this.insiderid = insiderid;
	}

	public String getInsidername() {
		return insidername;
	}

	public void setInsidername(String insidername) {
		this.insidername = insidername;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
