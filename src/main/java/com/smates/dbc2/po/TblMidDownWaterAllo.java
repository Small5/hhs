package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 流域中下游水分配
 * 
 * @author baijw
 *
 */
public class TblMidDownWaterAllo {

	private String id;
	private String username;
	private String fldWatershedCode;
	private String fldDate;
	private double fldWaterUseMid;
	private double fldWaterUseDown;

	public TblMidDownWaterAllo() {
	}

	public TblMidDownWaterAllo(String username,String fldWatershedCode, String fldDate, double fldWaterUseMid,
			double fldWaterUseDown) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldDate = fldDate;
		this.fldWaterUseMid = fldWaterUseMid;
		this.fldWaterUseDown = fldWaterUseDown;
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

	public String getFldDate() {
		return fldDate;
	}

	public void setFldDate(String fldDate) {
		this.fldDate = fldDate;
	}

	public double getFldWaterUseMid() {
		return fldWaterUseMid;
	}

	public void setFldWaterUseMid(double fldWaterUseMid) {
		this.fldWaterUseMid = fldWaterUseMid;
	}

	public double getFldWaterUseDown() {
		return fldWaterUseDown;
	}

	public void setFldWaterUseDown(double fldWaterUseDown) {
		this.fldWaterUseDown = fldWaterUseDown;
	}

	@Override
	public String toString() {
		return "TblMidDownWaterAllo [id=" + id + ", username=" + username + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldDate=" + fldDate + ", fldWaterUseMid=" + fldWaterUseMid + ", fldWaterUseDown=" + fldWaterUseDown
				+ "]";
	}
	
}
