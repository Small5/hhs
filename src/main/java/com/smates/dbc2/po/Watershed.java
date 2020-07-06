package com.smates.dbc2.po;

/**
 * 流域
 * @author baijw
 *
 */
public class Watershed {
	
	private String username;
	private String id;
	private String name;
	private String describe;
	
	public Watershed() {
	}

	public Watershed(String username,String id, String name, String describe) {
		this.username = username;
		this.id = id;
		this.name = name;
		this.describe = describe;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "Watershed [username=" + username + ", id=" + id + ", name=" + name + ", describe=" + describe + "]";
	}
	
}
