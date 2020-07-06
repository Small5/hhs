package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 水资源面积
 * 
 * @author baijw
 *
 */
public class TblWaterResManSce {

	private String id;
	private String username;
	private String fldWatershedCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldWaterManArea;
	private double fldTransCoopArea;

	public TblWaterResManSce() {
	}

	public TblWaterResManSce(String username,String fldWatershedCode, String fldCountyCode, String fldDate,
			double fldWaterManArea, double fldTransCoopArea) {
		this.id = UUID.randomUUID().toString();
		this.username =username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldWaterManArea = fldWaterManArea;
		this.fldTransCoopArea = fldTransCoopArea;
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

	public double getFldWaterManArea() {
		return fldWaterManArea;
	}

	public void setFldWaterManArea(double fldWaterManArea) {
		this.fldWaterManArea = fldWaterManArea;
	}

	public double getFldTransCoopArea() {
		return fldTransCoopArea;
	}

	public void setFldTransCoopArea(double fldTransCoopArea) {
		this.fldTransCoopArea = fldTransCoopArea;
	}

	@Override
	public String toString() {
		return "TblWaterResManSce [id=" + id + ", username=" + username + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldCountyCode=" + fldCountyCode + ", fldDate=" + fldDate + ", fldWaterManArea=" + fldWaterManArea
				+ ", fldTransCoopArea=" + fldTransCoopArea + "]";
	}

}
