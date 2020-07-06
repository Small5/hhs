package com.smates.dbc2.po;

public class WaterPara {

	private String projectId;
	private String countyId;
	private String Upstreamwater;
	private String FlowDown;
	private String Waterdistribution;
	private String SurSup;
	private String GWSup;
	private String SupWater;
	
	public WaterPara() {
		
	}
	
	public WaterPara(String projectId, String countyId,String Upstreamwater,String FlowDown,
			String Waterdistribution,String SurSup,String GWSup,String SupWater) {
		this.projectId = projectId;
		this.countyId = countyId;
		this.Upstreamwater = Upstreamwater;
		this.FlowDown = FlowDown;
		this.Waterdistribution = Waterdistribution;
		this.SurSup = SurSup;
		this.GWSup =GWSup;
		this.SupWater =SupWater;
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

	public String getUpstreamwater() {
		return Upstreamwater;
	}

	public void setUpstreamwater(String upstreamwater) {
		Upstreamwater = upstreamwater;
	}

	public String getFlowDown() {
		return FlowDown;
	}

	public void setFlowDown(String flowDown) {
		FlowDown = flowDown;
	}

	public String getWaterdistribution() {
		return Waterdistribution;
	}

	public void setWaterdistribution(String waterdistribution) {
		Waterdistribution = waterdistribution;
	}

	public String getSurSup() {
		return SurSup;
	}

	public void setSurSup(String surSup) {
		SurSup = surSup;
	}

	public String getGWSup() {
		return GWSup;
	}

	public void setGWSup(String gWSup) {
		GWSup = gWSup;
	}

	public String getSupWater() {
		return SupWater;
	}

	public void setSupWater(String supWater) {
		SupWater = supWater;
	}

	@Override
	public String toString() {
		return "WaterPara [projectId=" + projectId + ", countyId=" + countyId + ", Upstreamwater=" + Upstreamwater
				+ ", FlowDown=" + FlowDown + ", Waterdistribution=" + Waterdistribution + ", SurSup=" + SurSup
				+ ", GWSup=" + GWSup + ", SupWater=" + SupWater + "]";
	}
}
