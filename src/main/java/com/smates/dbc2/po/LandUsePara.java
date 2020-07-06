package com.smates.dbc2.po;

/**
 * 土地种类
 * @author baijw
 *
 */
public class LandUsePara {
	
	private String projectId;
	private String countyId;
	private String LandFarmR;
	private String LandForestR;
	private String LandGrassR;
	private String WaterArea;
	private String LandBareR;
	private String LandCityR;
	private String CPWhR;
	private String CPCornR;
	private String CPOilR;
	private String CPVegR;
	private String CPFTR;
	private String CPCotR;
	
	public LandUsePara() {
	}

	public LandUsePara(String projectId,String countyId, String LandFarmR, String LandForestR, 
			String LandGrassR,String WaterArea,String LandBareR,String LandCityR,String CPWhR,
			String CPCornR,String CPOilR,String CPVegR,String CPFTR,String CPCotR) {
		this.projectId = projectId;
		this.countyId =countyId;
		this.LandFarmR = LandFarmR;
		this.LandForestR = LandForestR;
		this.LandGrassR = LandGrassR;
		this.WaterArea = WaterArea;
		this.LandBareR =LandBareR;
		this.LandCityR = LandCityR;
		this.CPWhR = CPWhR;
		this.CPCornR =CPCornR;
		this.CPOilR =CPOilR;
		this.CPVegR = CPVegR;
		this.CPFTR = CPFTR;
		this.CPCotR =CPCotR;
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

	public String getLandFarmR() {
		return LandFarmR;
	}

	public void setLandFarmR(String landFarmR) {
		LandFarmR = landFarmR;
	}

	public String getLandForestR() {
		return LandForestR;
	}

	public void setLandForestR(String landForestR) {
		LandForestR = landForestR;
	}

	public String getLandGrassR() {
		return LandGrassR;
	}

	public void setLandGrassR(String landGrassR) {
		LandGrassR = landGrassR;
	}

	public String getWaterArea() {
		return WaterArea;
	}

	public void setWaterArea(String waterArea) {
		WaterArea = waterArea;
	}

	public String getLandBareR() {
		return LandBareR;
	}

	public void setLandBareR(String landBareR) {
		LandBareR = landBareR;
	}

	public String getLandCityR() {
		return LandCityR;
	}

	public void setLandCityR(String landCityR) {
		LandCityR = landCityR;
	}

	public String getCPWhR() {
		return CPWhR;
	}

	public void setCPWhR(String cPWhR) {
		CPWhR = cPWhR;
	}

	public String getCPCornR() {
		return CPCornR;
	}

	public void setCPCornR(String cPCornR) {
		CPCornR = cPCornR;
	}

	public String getCPOilR() {
		return CPOilR;
	}

	public void setCPOilR(String cPOilR) {
		CPOilR = cPOilR;
	}

	public String getCPVegR() {
		return CPVegR;
	}

	public void setCPVegR(String cPVegR) {
		CPVegR = cPVegR;
	}

	public String getCPFTR() {
		return CPFTR;
	}

	public void setCPFTR(String cPFTR) {
		CPFTR = cPFTR;
	}

	public String getCPCotR() {
		return CPCotR;
	}

	public void setCPCotR(String cPCotR) {
		CPCotR = cPCotR;
	}

	@Override
	public String toString() {
		return "TblLandUseSce [projectId=" + projectId + ", countyId=" + countyId + ", LandFarmR=" + LandFarmR
				+ ", LandForestR=" + LandForestR + ", LandGrassR=" + LandGrassR + ", WaterArea=" + WaterArea
				+ ", LandBareR=" + LandBareR + ", LandCityR=" + LandCityR + ", CPWhR=" + CPWhR + ", CPCornR=" + CPCornR+ 
				", CPOilR=" + CPOilR + ", CPVegR=" + CPVegR + ", CPFTR=" + CPFTR + ", CPCotR=" + CPCotR + "]";
	}
	
}
