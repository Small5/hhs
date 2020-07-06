package com.smates.dbc2.vo;

public class UserAndLandUse {
	private String username;
	private String countryId;

	public UserAndLandUse(String username, String countryId) {
		super();
		this.username = username;
		this.countryId = countryId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "UserAndLandUse [username=" + username + ", countryId=" + countryId + "]";
	}
}
