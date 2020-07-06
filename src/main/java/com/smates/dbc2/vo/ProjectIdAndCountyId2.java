package com.smates.dbc2.vo;

/**
 * 查询条件
 * @author baijw
 *
 */
public class ProjectIdAndCountyId2 {
	private String projectId;
	private String countryId;
	private String year;

	public ProjectIdAndCountyId2(String projectId, String countryId,String year) {
		this.projectId = projectId;
		this.countryId = countryId;
		this.year = year;
	}
	
	public ProjectIdAndCountyId2(String countryId,String year) {
		this.countryId = countryId;
		this.year = year;
	}

	public ProjectIdAndCountyId2() {
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
