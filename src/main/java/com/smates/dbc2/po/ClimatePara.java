package com.smates.dbc2.po;

public class ClimatePara {
	String projectId;
	String countyId;
	String PreChangeR;
	String TempChange;
	public ClimatePara() {
	}
	public ClimatePara(String projectId, String countyId, String preChangeR, String tempChange) {
		super();
		this.projectId = projectId;
		this.countyId = countyId;
		PreChangeR = preChangeR;
		TempChange = tempChange;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getCountyId() {
		return countyId;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	
	public String getPreChangeR() {
		return PreChangeR;
	}
	public void setPreChangeR(String preChangeR) {
		PreChangeR = preChangeR;
	}
	public String getTempChange() {
		return TempChange;
	}
	public void setTempChange(String tempChange) {
		TempChange = tempChange;
	}
	
}
