package com.smates.dbc2.vo;

public class UsernameAndName {
	private String username;
	private String name;
	
	public UsernameAndName() {
	}

	public UsernameAndName(String username,String name) {
		this.username = username;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UsernameAndName [username=" + username + ", name=" + name + "]";
	}
}
