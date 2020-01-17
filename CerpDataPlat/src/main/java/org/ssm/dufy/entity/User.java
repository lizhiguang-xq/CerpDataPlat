package org.ssm.dufy.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -807558236280225969L;

	private Integer id;

    private String user_name;

    private String password;

    private Integer entryid;
    
    private String opers;

	public User() {
	}

	public User(String userName, String password) {
		super();
		this.user_name = userName;
		this.password = password;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getUserName() {
//        return user_name;
//    }
//
//    public void setUserName(String userName) {
//        this.user_name = userName == null ? null : userName.trim();
//    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getEntryid() {
        return entryid;
    }

    public void setEntryid(Integer entryid) {
        this.entryid = entryid;
    }
    
    public String getOpers() {
		return opers;
	}

	public void setOpers(String opers) {
		this.opers = opers;
	}
}