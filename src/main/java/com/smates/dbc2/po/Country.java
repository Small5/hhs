package com.smates.dbc2.po;

/**
 * 县区信息
 * 
 * @author baijw
 *
 */
public class Country {

	private String countryId;
	private String countryName;

	public Country() {
		super();
	}

	public Country(String countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
