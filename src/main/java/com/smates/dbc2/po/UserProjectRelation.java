package com.smates.dbc2.po;

/**
 * 用户和默认项目的相关关系
 * 
 * @author baijw
 */
public class UserProjectRelation {

	private String userName;
	private String autoProjectId;

	public UserProjectRelation() {
		super();
	}

	public UserProjectRelation(String userName, String autoProjectId) {
		super();
		this.userName = userName;
		this.autoProjectId = autoProjectId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAutoProjectId() {
		return autoProjectId;
	}

	public void setAutoProjectId(String autoProjectId) {
		this.autoProjectId = autoProjectId;
	}

}
