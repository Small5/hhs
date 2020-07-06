package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 土地种类
 * @author baijw
 *
 */
public class TblLandUseSce {
	
	private String username;
	private String id;
	private String fldWatershedCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldFarmArea;
	private double fldWetlandArea;
	private double fldForestArea;
	private double fldGrassArea;
	private double fldHuYangArea;
	private double idfldWaterArea;
	
	public TblLandUseSce() {
	}

	public TblLandUseSce(String username,String fldWatershedCode, String fldCountyCode, String fldDate, double fldFarmArea,
			double fldWetlandArea, double fldForestArea, double fldGrassArea, double fldHuYangArea,
			double idfldWaterArea) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldFarmArea = fldFarmArea;
		this.fldWetlandArea = fldWetlandArea;
		this.fldForestArea = fldForestArea;
		this.fldGrassArea = fldGrassArea;
		this.fldHuYangArea = fldHuYangArea;
		this.idfldWaterArea = idfldWaterArea;
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

	public double getFldFarmArea() {
		return fldFarmArea;
	}

	public void setFldFarmArea(double fldFarmArea) {
		this.fldFarmArea = fldFarmArea;
	}

	public double getFldWetlandArea() {
		return fldWetlandArea;
	}

	public void setFldWetlandArea(double fldWetlandArea) {
		this.fldWetlandArea = fldWetlandArea;
	}

	public double getFldForestArea() {
		return fldForestArea;
	}

	public void setFldForestArea(double fldForestArea) {
		this.fldForestArea = fldForestArea;
	}

	public double getFldGrassArea() {
		return fldGrassArea;
	}

	public void setFldGrassArea(double fldGrassArea) {
		this.fldGrassArea = fldGrassArea;
	}

	public double getFldHuYangArea() {
		return fldHuYangArea;
	}

	public void setFldHuYangArea(double fldHuYangArea) {
		this.fldHuYangArea = fldHuYangArea;
	}

	public double getIdfldWaterArea() {
		return idfldWaterArea;
	}

	public void setIdfldWaterArea(double idfldWaterArea) {
		this.idfldWaterArea = idfldWaterArea;
	}

	@Override
	public String toString() {
		return "TblLandUseSce [username=" + username + ", id=" + id + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldCountyCode=" + fldCountyCode + ", fldDate=" + fldDate + ", fldFarmArea=" + fldFarmArea
				+ ", fldWetlandArea=" + fldWetlandArea + ", fldForestArea=" + fldForestArea + ", fldGrassArea="
				+ fldGrassArea + ", fldHuYangArea=" + fldHuYangArea + ", idfldWaterArea=" + idfldWaterArea + "]";
	}
	
}
