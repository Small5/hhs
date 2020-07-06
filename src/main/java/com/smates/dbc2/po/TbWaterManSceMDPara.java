package com.smates.dbc2.po;

import java.util.UUID;

/**
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 上午11:18:46
 */
public class TbWaterManSceMDPara {
	private String id;
	private String fldWatershedCode;
	private String fldProjectCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldWaterUseMid;
	private double fldWaterUseDown;

	public TbWaterManSceMDPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode, String fldDate,
			double fldWaterUseMid, double fldWaterUseDown) {
		this.id = UUID.randomUUID().toString();
		this.fldWatershedCode = fldWatershedCode;
		this.fldProjectCode = fldProjectCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldWaterUseMid = fldWaterUseMid;
		this.fldWaterUseDown = fldWaterUseDown;
	}

	public TbWaterManSceMDPara() {
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
}
