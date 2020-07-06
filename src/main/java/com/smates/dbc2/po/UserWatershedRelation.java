package com.smates.dbc2.po;

/**
 * 用户和默认项目的相关关系
 * 
 * @author baijw
 */
public class UserWatershedRelation {

	private String username;
	private String autowatershedid;

	public UserWatershedRelation() {
		super();
	}

	public UserWatershedRelation(String username, String autowatershedid) {
		super();
		this.username = username;
		this.autowatershedid = autowatershedid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAutowatershedid() {
		return autowatershedid;
	}

	public void setAutowatershedid(String autowatershedid) {
		this.autowatershedid = autowatershedid;
	}

	@Override
	public String toString() {
		return "UserWatershedRelation [username=" + username + ", autowatershedid=" + autowatershedid + "]";
	}

	
}
