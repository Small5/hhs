package com.smates.dbc2.po;

import java.util.UUID;

/**
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 上午10:57:56 类说明
 */
public class TbLanduseSceCropPara {
	private String id;
	private String fldWatershedCode;
	private String fldProjectCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldAreaChgRatio;
	private double fldCropArea;

	public TbLanduseSceCropPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode, String fldDate,
			double fldAreaChgRatio, double fldCropArea) {
		this.id = UUID.randomUUID().toString();
		this.fldWatershedCode = fldWatershedCode;
		this.fldProjectCode = fldProjectCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldAreaChgRatio = fldAreaChgRatio;
		this.fldCropArea = fldCropArea;
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

	public double getFldAreaChgRatio() {
		return fldAreaChgRatio;
	}

	public void setFldAreaChgRatio(double fldAreaChgRatio) {
		this.fldAreaChgRatio = fldAreaChgRatio;
	}

	public double getFldCropArea() {
		return fldCropArea;
	}

	public void setFldCropArea(double fldCropArea) {
		this.fldCropArea = fldCropArea;
	}

	public TbLanduseSceCropPara() {
		super();
	}

}
