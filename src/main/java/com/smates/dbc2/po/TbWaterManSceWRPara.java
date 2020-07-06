package com.smates.dbc2.po;

/**
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 上午11:16:21 类说明
 */
public class TbWaterManSceWRPara {
	private String fldWatershedCode;
	private String fldProjectCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldWaterRightRatio;

	public TbWaterManSceWRPara() {
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

	public double getFldWaterRightRatio() {
		return fldWaterRightRatio;
	}

	public void setFldWaterRightRatio(double fldWaterRightRatio) {
		this.fldWaterRightRatio = fldWaterRightRatio;
	}

	public TbWaterManSceWRPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode, String fldDate,
			double fldWaterRightRatio) {
		this.fldWatershedCode = fldWatershedCode;
		this.fldProjectCode = fldProjectCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldWaterRightRatio = fldWaterRightRatio;
	}
}
