package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 水利工程数据
 * 
 * @author baijw
 *
 */
public class TblHydrEngineering {

	private String id;
	private String username;
	private String fldWatershedCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldMainCannelLeng;
	private double fldMainCanWUE;
	private double fldBranCannelLeng;
	private double fldBranCanWUE;
	private double fldDouLeng;
	private double fldDouWUE;
	private double fldNongLeng;
	private double fldNongWUE;
	private double fldMaoLeng;
	private double fldMaoWUE;
	private double fldSprinkingArea;
	private double fldSprWUE;
	private double fldDropIrrArea;
	private double fldDropWUE;

	public TblHydrEngineering() {
	}

	public TblHydrEngineering(String username,String fldWatershedCode, String fldCountyCode, String fldDate,
			double fldMainCannelLeng, double fldMainCanWUE, double fldBranCannelLeng, double fldBranCanWUE,
			double fldDouLeng, double fldDouWUE, double fldNongLeng, double fldNongWUE, double fldMaoLeng,
			double fldMaoWUE, double fldSprinkingArea, double fldSprWUE, double fldDropIrrArea, double fldDropWUE) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldMainCannelLeng = fldMainCannelLeng;
		this.fldMainCanWUE = fldMainCanWUE;
		this.fldBranCannelLeng = fldBranCannelLeng;
		this.fldBranCanWUE = fldBranCanWUE;
		this.fldDouLeng = fldDouLeng;
		this.fldDouWUE = fldDouWUE;
		this.fldNongLeng = fldNongLeng;
		this.fldNongWUE = fldNongWUE;
		this.fldMaoLeng = fldMaoLeng;
		this.fldMaoWUE = fldMaoWUE;
		this.fldSprinkingArea = fldSprinkingArea;
		this.fldSprWUE = fldSprWUE;
		this.fldDropIrrArea = fldDropIrrArea;
		this.fldDropWUE = fldDropWUE;
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

	public double getFldMainCannelLeng() {
		return fldMainCannelLeng;
	}

	public void setFldMainCannelLeng(double fldMainCannelLeng) {
		this.fldMainCannelLeng = fldMainCannelLeng;
	}

	public double getFldMainCanWUE() {
		return fldMainCanWUE;
	}

	public void setFldMainCanWUE(double fldMainCanWUE) {
		this.fldMainCanWUE = fldMainCanWUE;
	}

	public double getFldBranCannelLeng() {
		return fldBranCannelLeng;
	}

	public void setFldBranCannelLeng(double fldBranCannelLeng) {
		this.fldBranCannelLeng = fldBranCannelLeng;
	}

	public double getFldBranCanWUE() {
		return fldBranCanWUE;
	}

	public void setFldBranCanWUE(double fldBranCanWUE) {
		this.fldBranCanWUE = fldBranCanWUE;
	}

	public double getFldDouLeng() {
		return fldDouLeng;
	}

	public void setFldDouLeng(double fldDouLeng) {
		this.fldDouLeng = fldDouLeng;
	}

	public double getFldDouWUE() {
		return fldDouWUE;
	}

	public void setFldDouWUE(double fldDouWUE) {
		this.fldDouWUE = fldDouWUE;
	}

	public double getFldNongLeng() {
		return fldNongLeng;
	}

	public void setFldNongLeng(double fldNongLeng) {
		this.fldNongLeng = fldNongLeng;
	}

	public double getFldNongWUE() {
		return fldNongWUE;
	}

	public void setFldNongWUE(double fldNongWUE) {
		this.fldNongWUE = fldNongWUE;
	}

	public double getFldMaoLeng() {
		return fldMaoLeng;
	}

	public void setFldMaoLeng(double fldMaoLeng) {
		this.fldMaoLeng = fldMaoLeng;
	}

	public double getFldMaoWUE() {
		return fldMaoWUE;
	}

	public void setFldMaoWUE(double fldMaoWUE) {
		this.fldMaoWUE = fldMaoWUE;
	}

	public double getFldSprinkingArea() {
		return fldSprinkingArea;
	}

	public void setFldSprinkingArea(double fldSprinkingArea) {
		this.fldSprinkingArea = fldSprinkingArea;
	}

	public double getFldSprWUE() {
		return fldSprWUE;
	}

	public void setFldSprWUE(double fldSprWUE) {
		this.fldSprWUE = fldSprWUE;
	}

	public double getFldDropIrrArea() {
		return fldDropIrrArea;
	}

	public void setFldDropIrrArea(double fldDropIrrArea) {
		this.fldDropIrrArea = fldDropIrrArea;
	}

	public double getFldDropWUE() {
		return fldDropWUE;
	}

	public void setFldDropWUE(double fldDropWUE) {
		this.fldDropWUE = fldDropWUE;
	}

	@Override
	public String toString() {
		return "TblHydrEngineering [id=" + id + ", username=" + username + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldCountyCode=" + fldCountyCode + ", fldDate=" + fldDate + ", fldMainCannelLeng="
				+ fldMainCannelLeng + ", fldMainCanWUE=" + fldMainCanWUE + ", fldBranCannelLeng=" + fldBranCannelLeng
				+ ", fldBranCanWUE=" + fldBranCanWUE + ", fldDouLeng=" + fldDouLeng + ", fldDouWUE=" + fldDouWUE
				+ ", fldNongLeng=" + fldNongLeng + ", fldNongWUE=" + fldNongWUE + ", fldMaoLeng=" + fldMaoLeng
				+ ", fldMaoWUE=" + fldMaoWUE + ", fldSprinkingArea=" + fldSprinkingArea + ", fldSprWUE=" + fldSprWUE
				+ ", fldDropIrrArea=" + fldDropIrrArea + ", fldDropWUE=" + fldDropWUE + "]";
	}

}
