package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 县区用水量
 * 
 * @author baijw
 *
 */
public class TblWaterAlloCounty {

	private String id;
	private String username;
	private String fldWatershedCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldSurfaceWater;
	private double fldGroundWater;

	public TblWaterAlloCounty() {
	}

	public TblWaterAlloCounty(String username,String fldWatershedCode, String fldCountyCode, String fldDate,
			double fldSurfaceWater, double fldGroundWater) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldSurfaceWater = fldSurfaceWater;
		this.fldGroundWater = fldGroundWater;
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

	public double getFldSurfaceWater() {
		return fldSurfaceWater;
	}

	public void setFldSurfaceWater(double fldSurfaceWater) {
		this.fldSurfaceWater = fldSurfaceWater;
	}

	public double getFldGroundWater() {
		return fldGroundWater;
	}

	public void setFldGroundWater(double fldGroundWater) {
		this.fldGroundWater = fldGroundWater;
	}

	@Override
	public String toString() {
		return "TblWaterAlloCounty [id=" + id + ", username=" + username + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldCountyCode=" + fldCountyCode + ", fldDate=" + fldDate + ", fldSurfaceWater=" + fldSurfaceWater
				+ ", fldGroundWater=" + fldGroundWater + "]";
	}
	
}
