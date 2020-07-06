package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 产业与城市发展情景
 * 
 * @author baijw
 *
 */
public class TblIndustyUrbanSce {

	private String id;
	private String fldWatershedCode;
	private String fldCountyCode;
	private String fldDate;
	private double fldFarmPop;
	private double fldNonFarmPop;
	private double fldIndOutput;
	private double fldAgrOutput;
	private double fldSerOutput;
	private double fldTourOutput;
	private double fldTechProgRatio;

	public TblIndustyUrbanSce() {
	}

	public TblIndustyUrbanSce(String fldWatershedCode, String fldCountyCode, String fldDate,
			double fldFarmPop, double fldNonFarmPop, double fldIndOutput, double fldAgrOutput, double fldSerOutput,
			double fldTourOutput, double fldTechProgRatio) {
		this.id = UUID.randomUUID().toString();
		this.fldWatershedCode = fldWatershedCode;
		this.fldCountyCode = fldCountyCode;
		this.fldDate = fldDate;
		this.fldFarmPop = fldFarmPop;
		this.fldNonFarmPop = fldNonFarmPop;
		this.fldIndOutput = fldIndOutput;
		this.fldAgrOutput = fldAgrOutput;
		this.fldSerOutput = fldSerOutput;
		this.fldTourOutput = fldTourOutput;
		this.fldTechProgRatio = fldTechProgRatio;
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

	public double getFldFarmPop() {
		return fldFarmPop;
	}

	public void setFldFarmPop(double fldFarmPop) {
		this.fldFarmPop = fldFarmPop;
	}

	public double getFldNonFarmPop() {
		return fldNonFarmPop;
	}

	public void setFldNonFarmPop(double fldNonFarmPop) {
		this.fldNonFarmPop = fldNonFarmPop;
	}

	public double getFldIndOutput() {
		return fldIndOutput;
	}

	public void setFldIndOutput(double fldIndOutput) {
		this.fldIndOutput = fldIndOutput;
	}

	public double getFldAgrOutput() {
		return fldAgrOutput;
	}

	public void setFldAgrOutput(double fldAgrOutput) {
		this.fldAgrOutput = fldAgrOutput;
	}

	public double getFldSerOutput() {
		return fldSerOutput;
	}

	public void setFldSerOutput(double fldSerOutput) {
		this.fldSerOutput = fldSerOutput;
	}

	public double getFldTourOutput() {
		return fldTourOutput;
	}

	public void setFldTourOutput(double fldTourOutput) {
		this.fldTourOutput = fldTourOutput;
	}

	public double getFldTechProgRatio() {
		return fldTechProgRatio;
	}

	public void setFldTechProgRatio(double fldTechProgRatio) {
		this.fldTechProgRatio = fldTechProgRatio;
	}

}
