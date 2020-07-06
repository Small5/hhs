package com.smates.dbc2.po;

import java.util.UUID;

/**
 * 气候情景数据表(月)
 * @author baijw
 *
 */
public class TblClimateScenarioMonth {
	
	private String id;
	private String username;
	private String fldWatershedCode;
	private String fldCountyCode;
	private String fldCRPType;
	private String fldDate;
	private double fldPrecipitation;
	private double fldAvgTemperature;
	private double fldMaxTemp;
	private double fldMinTemp;
	
	
	public TblClimateScenarioMonth() {
	}

	public TblClimateScenarioMonth(String username,String fldWatershedCode, String fldCountyCode, String fldCRPType,
			String fldDate, double fldPrecipitation, double fldAvgTemperature, double fldMaxTemp, double fldMinTemp) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.fldWatershedCode = fldWatershedCode;
		this.fldCountyCode = fldCountyCode;
		this.fldCRPType = fldCRPType;
		this.fldDate = fldDate;
		this.fldPrecipitation = fldPrecipitation;
		this.fldAvgTemperature = fldAvgTemperature;
		this.fldMaxTemp = fldMaxTemp;
		this.fldMinTemp = fldMinTemp;
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

	public String getFldCRPType() {
		return fldCRPType;
	}

	public void setFldCRPType(String fldCRPType) {
		this.fldCRPType = fldCRPType;
	}

	public String getFldDate() {
		return fldDate;
	}

	public void setFldDate(String fldDate) {
		this.fldDate = fldDate;
	}

	public double getFldPrecipitation() {
		return fldPrecipitation;
	}

	public void setFldPrecipitation(double fldPrecipitation) {
		this.fldPrecipitation = fldPrecipitation;
	}

	public double getFldAvgTemperature() {
		return fldAvgTemperature;
	}

	public void setFldAvgTemperature(double fldAvgTemperature) {
		this.fldAvgTemperature = fldAvgTemperature;
	}

	public double getFldMaxTemp() {
		return fldMaxTemp;
	}

	public void setFldMaxTemp(double fldMaxTemp) {
		this.fldMaxTemp = fldMaxTemp;
	}

	public double getFldMinTemp() {
		return fldMinTemp;
	}

	public void setFldMinTemp(double fldMinTemp) {
		this.fldMinTemp = fldMinTemp;
	}

	@Override
	public String toString() {
		return "TblClimateScenarioMonth [id=" + id + ", username=" + username + ", fldWatershedCode=" + fldWatershedCode
				+ ", fldCountyCode=" + fldCountyCode + ", fldCRPType=" + fldCRPType + ", fldDate=" + fldDate
				+ ", fldPrecipitation=" + fldPrecipitation + ", fldAvgTemperature=" + fldAvgTemperature
				+ ", fldMaxTemp=" + fldMaxTemp + ", fldMinTemp=" + fldMinTemp + "]";
	}
	
}
