package com.smates.dbc2.po;

public class IndicatorWeight {
	public IndicatorWeight() {}
	public IndicatorWeight(String projectId, String countyId, String indicatorindex, String weight) {
		super();
		this.projectId = projectId;
		this.countyId = countyId;
		this.indicatorindex = indicatorindex;
		this.weight = weight;
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
	public String getIndicatorindex() {
		return indicatorindex;
	}
	public void setIndicatorindex(String indicatorindex) {
		this.indicatorindex = indicatorindex;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	private String projectId;
	private String countyId;
	private String indicatorindex;
	private String weight;
}
