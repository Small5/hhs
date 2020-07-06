package com.smates.dbc2.vo;

/**
 * 查询条件
 * @author baijw
 *
 */
public class ProjectIdAndCountyId {
	private String projectId;
	private String countyId;

	public ProjectIdAndCountyId(String projectId, String countyId) {
		this.projectId = projectId;
		this.countyId = countyId;
	}

	public ProjectIdAndCountyId() {
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCountryId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	@Override
	public String toString() {
		return "ProjectIdAndCountyId [projectId=" + projectId + ", countyId=" + countyId + "]";
	}


}
