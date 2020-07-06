package com.smates.dbc2.po;

import java.util.UUID;

/**
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 上午11:20:12
 */
public class TbWaterManSceCWPara {
	private String id;
	private String fldWatershedCode;
	private String fldProjectCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldSurfaceWater;
	private double fldGroundWater;

	public TbWaterManSceCWPara() {
	}

	public TbWaterManSceCWPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode,
			String fldDate, double fldSurfaceWater, double fldGroundWater) {
		this.id = UUID.randomUUID().toString();
		this.fldWatershedCode = fldWatershedCode;
		this.fldProjectCode = fldProjectCode;
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

	public String getFldWatershedCode() {
		return fldWatershedCode;
	}

	public void setFldWatershedCode(String fldWatershedCode) {
		this.fldWatershedCode = fldWatershedCode;
	}

	public String getFldProjectCode() {
		return fldProjectCode;
	}

	public void setFldProjectCode(String fldProjectCode) {
		this.fldProjectCode = fldProjectCode;
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
}
