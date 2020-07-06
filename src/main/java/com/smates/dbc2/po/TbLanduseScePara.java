package com.smates.dbc2.po;

/**
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 上午10:54:43
 */
public class TbLanduseScePara extends BaseClass{

	private String projectId;
	private String countryId;
	private String fldFarmArea;
	private String fldFarmAreaChgR;
	private String wheatChgR;
	private String cornChgR;
	private String oilPlantsChgR;
	private String vegetablesChgR;
	private String orchardChgR;
	private String cottonChgR;
	private String wheatArea;
	private String cornArea;
	private String oilPlantsArea;
	private String vegetablesArea;
	private String orchardArea;
	private String cottonArea;
	private String WetlandArea;
	private String ForestArea;
	private String GrassArea;
	private String WaterArea;
	private String year;
	
	public TbLanduseScePara(String projectId, String countryId, String fldFarmArea,String fldFarmAreaChgR, String wheatChgR,
			String cornChgR, String oilPlantsChgR, String vegetablesChgR, String orchardChgR, String cottonChgR,
			String wheatArea, String cornArea, String oilPlantsArea, String vegetablesArea, String orchardArea,
			String cottonArea, String wetlandArea, String forestArea, String grassArea, String waterArea, String year) {
		this.projectId = projectId;
		this.countryId = countryId;
		this.fldFarmArea = fldFarmArea;
		this.fldFarmAreaChgR = fldFarmAreaChgR;
		this.wheatChgR = wheatChgR;
		this.cornChgR = cornChgR;
		this.oilPlantsChgR = oilPlantsChgR;
		this.vegetablesChgR = vegetablesChgR;
		this.orchardChgR = orchardChgR;
		this.cottonChgR = cottonChgR;
		this.wheatArea = wheatArea;
		this.cornArea = cornArea;
		this.oilPlantsArea = oilPlantsArea;
		this.vegetablesArea = vegetablesArea;
		this.orchardArea = orchardArea;
		this.cottonArea = cottonArea;
		WetlandArea = wetlandArea;
		ForestArea = forestArea;
		GrassArea = grassArea;
		WaterArea = waterArea;
		this.year = year;
	}

	public TbLanduseScePara() {
	}

	public String getProjectId() {
		return projectId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFldFarmArea() {
		return fldFarmArea;
	}

	public void setFldFarmArea(String fldFarmArea) {
		this.fldFarmArea = fldFarmArea;
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

	public String getFldFarmAreaChgR() {
		return fldFarmAreaChgR;
	}

	public void setFldFarmAreaChgR(String fldFarmAreaChgR) {
		this.fldFarmAreaChgR = fldFarmAreaChgR;
	}

	public String getWheatChgR() {
		return wheatChgR;
	}

	public void setWheatChgR(String wheatChgR) {
		this.wheatChgR = wheatChgR;
	}

	public String getCornChgR() {
		return cornChgR;
	}

	public void setCornChgR(String cornChgR) {
		this.cornChgR = cornChgR;
	}

	public String getOilPlantsChgR() {
		return oilPlantsChgR;
	}

	public void setOilPlantsChgR(String oilPlantsChgR) {
		this.oilPlantsChgR = oilPlantsChgR;
	}

	public String getVegetablesChgR() {
		return vegetablesChgR;
	}

	public void setVegetablesChgR(String vegetablesChgR) {
		this.vegetablesChgR = vegetablesChgR;
	}

	public String getOrchardChgR() {
		return orchardChgR;
	}

	public void setOrchardChgR(String orchardChgR) {
		this.orchardChgR = orchardChgR;
	}

	public String getCottonChgR() {
		return cottonChgR;
	}

	public void setCottonChgR(String cottonChgR) {
		this.cottonChgR = cottonChgR;
	}

	public String getWheatArea() {
		return wheatArea;
	}

	public void setWheatArea(String wheatArea) {
		this.wheatArea = wheatArea;
	}

	public String getCornArea() {
		return cornArea;
	}

	public void setCornArea(String cornArea) {
		this.cornArea = cornArea;
	}

	public String getOilPlantsArea() {
		return oilPlantsArea;
	}

	public void setOilPlantsArea(String oilPlantsArea) {
		this.oilPlantsArea = oilPlantsArea;
	}

	public String getVegetablesArea() {
		return vegetablesArea;
	}

	public void setVegetablesArea(String vegetablesArea) {
		this.vegetablesArea = vegetablesArea;
	}

	public String getOrchardArea() {
		return orchardArea;
	}

	public void setOrchardArea(String orchardArea) {
		this.orchardArea = orchardArea;
	}

	public String getCottonArea() {
		return cottonArea;
	}

	public void setCottonArea(String cottonArea) {
		this.cottonArea = cottonArea;
	}

	public String getWetlandArea() {
		return WetlandArea;
	}

	public void setWetlandArea(String wetlandArea) {
		WetlandArea = wetlandArea;
	}

	public String getForestArea() {
		return ForestArea;
	}

	public void setForestArea(String forestArea) {
		ForestArea = forestArea;
	}

	public String getGrassArea() {
		return GrassArea;
	}

	public void setGrassArea(String grassArea) {
		GrassArea = grassArea;
	}

	public String getWaterArea() {
		return WaterArea;
	}

	public void setWaterArea(String waterArea) {
		WaterArea = waterArea;
	}

}
