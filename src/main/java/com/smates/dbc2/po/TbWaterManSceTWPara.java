package com.smates.dbc2.po;

import java.util.UUID;

/**
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 上午11:14:27 类说明
 */
public class TbWaterManSceTWPara {
	private String id;
	private String fldWatershedCode;
	private String fldProjectCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldWaterUseAgr;
	private double fldWaterUseInd;
	private double fldWaterUseSer;

	public TbWaterManSceTWPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode, String fldDate,
			double fldWaterUseAgr, double fldWaterUseInd, double fldWaterUseSer) {
		this.id = UUID.randomUUID().toString();
		this.fldWatershedCode = fldWatershedCode;
		this.fldProjectCode = fldProjectCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldWaterUseAgr = fldWaterUseAgr;
		this.fldWaterUseInd = fldWaterUseInd;
		this.fldWaterUseSer = fldWaterUseSer;
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

	public double getFldWaterUseAgr() {
		return fldWaterUseAgr;
	}

	public void setFldWaterUseAgr(double fldWaterUseAgr) {
		this.fldWaterUseAgr = fldWaterUseAgr;
	}

	public double getFldWaterUseInd() {
		return fldWaterUseInd;
	}

	public void setFldWaterUseInd(double fldWaterUseInd) {
		this.fldWaterUseInd = fldWaterUseInd;
	}

	public double getFldWaterUseSer() {
		return fldWaterUseSer;
	}

	public void setFldWaterUseSer(double fldWaterUseSer) {
		this.fldWaterUseSer = fldWaterUseSer;
	}

	public TbWaterManSceTWPara() {
	}
}
