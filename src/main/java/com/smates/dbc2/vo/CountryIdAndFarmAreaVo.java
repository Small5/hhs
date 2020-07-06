package com.smates.dbc2.vo;

public class CountryIdAndFarmAreaVo {

	private String countryId;
	private String projectId;
	private String farmArea;
	private String wetLand;
	private String sprinkArea;

	public CountryIdAndFarmAreaVo() {
		super();
	}

	public CountryIdAndFarmAreaVo(String countryId, String projectId, String farmArea, String wetLand,
			String sprinkArea) {
		super();
		this.countryId = countryId;
		this.projectId = projectId;
		this.farmArea = farmArea;
		this.wetLand = wetLand;
		this.sprinkArea = sprinkArea;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getFarmArea() {
		return farmArea;
	}

	public void setFarmArea(String farmArea) {
		this.farmArea = farmArea;
	}

	public String getWetLand() {
		return wetLand;
	}

	public void setWetLand(String wetLand) {
		this.wetLand = wetLand;
	}

	public String getSprinkArea() {
		return sprinkArea;
	}

	public void setSprinkArea(String sprinkArea) {
		this.sprinkArea = sprinkArea;
	}

}
