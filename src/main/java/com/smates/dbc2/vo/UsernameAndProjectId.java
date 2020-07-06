package com.smates.dbc2.vo;

public class UsernameAndProjectId {

	private String username;
	private String id;
	
	public UsernameAndProjectId() {
	}

	public UsernameAndProjectId(String username,String id) {
		this.username = username;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UsernameAndProjectId [username=" + username + ", id=" + id + "]";
	}
}
