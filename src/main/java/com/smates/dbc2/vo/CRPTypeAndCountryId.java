package com.smates.dbc2.vo;

/**
 * 气候情景参数vo，用来按IPCC和县区查找气候数据
 * 
 * @author baijw
 *
 */
public class CRPTypeAndCountryId {

	private String username;
	private String fldCRPType;
	private String countryId;

	public CRPTypeAndCountryId(String username,String fldCRPType, String countryId) {
		super();
		this.username = username;
		this.fldCRPType = fldCRPType;
		this.countryId = countryId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFldCRPType() {
		return fldCRPType;
	}

	public void setFldCRPType(String fldCRPType) {
		this.fldCRPType = fldCRPType;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

}
