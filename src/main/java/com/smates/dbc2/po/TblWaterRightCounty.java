package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 县区水权分配
 * 
 * @author baijw
 *
 */
public class TblWaterRightCounty {

	private String id;
	private String username;
	private String fldWatershedCode;
	private String fldCityCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldWaterRightRatio;

	public TblWaterRightCounty() {
	}

	public TblWaterRightCounty(String username,String fldWatershedCode, String fldCityCode, String fldCountyCode,
			String fldDate, double fldWaterRightRatio) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldCityCode = fldCityCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldWaterRightRatio = fldWaterRightRatio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFldWatershedCode() {
		return fldWatershedCode;
	}

	public void setFldWatershedCode(String fldWatershedCode) {
		this.fldWatershedCode = fldWatershedCode;
	}

	public String getFldCityCode() {
		return fldCityCode;
	}

	public void setFldCityCode(String fldCityCode) {
		this.fldCityCode = fldCityCode;
	}

	public String getFldCountyCode() {
		return fldCountyCode;
	}

	public void setFldCountyCode(String fldCountyCode) {
		this.fldCountyCode = fldCountyCode;
	}

	public String getFldDate() {
		return fldDate;
	}

	public void setFldDate(String fldDate) {
		this.fldDate = fldDate;
	}

	public double getFldWaterRightRatio() {
		return fldWaterRightRatio;
	}

	public void setFldWaterRightRatio(double fldWaterRightRatio) {
		this.fldWaterRightRatio = fldWaterRightRatio;
	}

	@Override
	public String toString() {
		return "TblWaterRightCounty [id=" + id + ", username=" + username + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldCityCode=" + fldCityCode + ", fldCountyCode=" + fldCountyCode + ", fldDate=" + fldDate
				+ ", fldWaterRightRatio=" + fldWaterRightRatio + "]";
	}

}
