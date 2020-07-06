package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 种植结构数据表
 * 
 * @author machao
 *
 */
public class TblCropPattern {

	private String id;
	private String username;
	private String fldWatershedCode;
	private String fldCountyCode;
	private String fldDate;
	private String fldCropType;
	private double fldCropArea;
	private double fldIrrQuota;
	private double fldFertilizer;
	private double fldYieldPer;
	private double fldCropPrice;

	public TblCropPattern() {
	}

	public TblCropPattern(String username,String fldWatershedCode, String fldCountyCode, String fldDate, String fldCropType,
			double fldCropArea, double fldIrrQuota, double fldFertilizer, double fldYieldPer, double fldCropPrice) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldCropType = fldCropType;
		this.fldCropArea = fldCropArea;
		this.fldIrrQuota = fldIrrQuota;
		this.fldFertilizer = fldFertilizer;
		this.fldYieldPer = fldYieldPer;
		this.fldCropPrice = fldCropPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TblCropPattern [id=" + id + ", username=" + username + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldCountyCode=" + fldCountyCode + ", fldDate=" + fldDate + ", fldCropType=" + fldCropType
				+ ", fldCropArea=" + fldCropArea + ", fldIrrQuota=" + fldIrrQuota + ", fldFertilizer=" + fldFertilizer
				+ ", fldYieldPer=" + fldYieldPer + ", fldCropPrice=" + fldCropPrice + "]";
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

	public String getFldCropType() {
		return fldCropType;
	}

	public void setFldCropType(String fldCropType) {
		this.fldCropType = fldCropType;
	}

	public double getFldCropArea() {
		return fldCropArea;
	}

	public void setFldCropArea(double fldCropArea) {
		this.fldCropArea = fldCropArea;
	}

	public double getFldIrrQuota() {
		return fldIrrQuota;
	}

	public void setFldIrrQuota(double fldIrrQuota) {
		this.fldIrrQuota = fldIrrQuota;
	}

	public double getFldFertilizer() {
		return fldFertilizer;
	}

	public void setFldFertilizer(double fldFertilizer) {
		this.fldFertilizer = fldFertilizer;
	}

	public double getFldYieldPer() {
		return fldYieldPer;
	}

	public void setFldYieldPer(double fldYieldPer) {
		this.fldYieldPer = fldYieldPer;
	}

	public double getFldCropPrice() {
		return fldCropPrice;
	}

	public void setFldCropPrice(double fldCropPrice) {
		this.fldCropPrice = fldCropPrice;
	}


}
