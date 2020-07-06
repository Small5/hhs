package com.smates.dbc2.po;

public class IndicatorPara {
	String watershedId;
	String countyId;
	String baseNeedSurWater;
	String baseNeedGWater;
	String pop;
	String safewaterPop;
	String area;
	String farmArea;
	String forestArea;
	String grassArea;
	String popx0;
	String popxm;
	String popr;
	String urbanla;
	String urbannegak;
	String agrivalue;
	String indivalue;
	String servalue;
	String empr;
	String agriwater;
	String indiArea;
	String serArea;
	String waterPrice;
	private String FlowYLX; //莺落峡流量输出 单位：亿立方米
	private String FlowOther; //其他河流流量输出 单位：亿立方米
	private String SurSup; //地表供水量 单位：亿立方米
	private String GWSup; //地下供水量 单位：亿立方米
	private String CropET; //作物蒸散发 单位：亿立方米
	private String ecopro;
	private String forestmax;
	private String grassmax;
	private String barebase;
	private String baremax;
	
	public IndicatorPara() {
		
	}
	public IndicatorPara(String watershedId, String countyId, String baseNeedSurWater, String baseNeedGWater,
			String pop, String safewaterPop, String area, String farmArea, String forestArea, String grassArea,
			String popx0, String popxm, String popr, String urbanla, String urbannegak, String agrivalue,
			String indivalue, String servalue, String empr, String agriwater, String indiArea, String serArea,
			String waterPrice, String flowYLX, String flowOther, String surSup, String gWSup, String cropET,
			String ecopro, String forestmax, String grassmax, String barebase, String baremax) {
		super();
		this.watershedId = watershedId;
		this.countyId = countyId;
		this.baseNeedSurWater = baseNeedSurWater;
		this.baseNeedGWater = baseNeedGWater;
		this.pop = pop;
		this.safewaterPop = safewaterPop;
		this.area = area;
		this.farmArea = farmArea;
		this.forestArea = forestArea;
		this.grassArea = grassArea;
		this.popx0 = popx0;
		this.popxm = popxm;
		this.popr = popr;
		this.urbanla = urbanla;
		this.urbannegak = urbannegak;
		this.agrivalue = agrivalue;
		this.indivalue = indivalue;
		this.servalue = servalue;
		this.empr = empr;
		this.agriwater = agriwater;
		this.indiArea = indiArea;
		this.serArea = serArea;
		this.waterPrice = waterPrice;
		FlowYLX = flowYLX;
		FlowOther = flowOther;
		SurSup = surSup;
		GWSup = gWSup;
		CropET = cropET;
		this.ecopro = ecopro;
		this.forestmax = forestmax;
		this.grassmax = grassmax;
		this.barebase = barebase;
		this.baremax = baremax;
	}
	public String getWatershedId() {
		return watershedId;
	}
	public void setWatershedId(String watershedId) {
		this.watershedId = watershedId;
	}
	public String getCountyId() {
		return countyId;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	public String getBaseNeedSurWater() {
		return baseNeedSurWater;
	}
	public void setBaseNeedSurWater(String baseNeedSurWater) {
		this.baseNeedSurWater = baseNeedSurWater;
	}
	public String getBaseNeedGWater() {
		return baseNeedGWater;
	}
	public void setBaseNeedGWater(String baseNeedGWater) {
		this.baseNeedGWater = baseNeedGWater;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public String getSafewaterPop() {
		return safewaterPop;
	}
	public void setSafewaterPop(String safewaterPop) {
		this.safewaterPop = safewaterPop;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFarmArea() {
		return farmArea;
	}
	public void setFarmArea(String farmArea) {
		this.farmArea = farmArea;
	}
	public String getForestArea() {
		return forestArea;
	}
	public void setForestArea(String forestArea) {
		this.forestArea = forestArea;
	}
	public String getGrassArea() {
		return grassArea;
	}
	public void setGrassArea(String grassArea) {
		this.grassArea = grassArea;
	}
	public String getPopx0() {
		return popx0;
	}
	public void setPopx0(String popx0) {
		this.popx0 = popx0;
	}
	public String getPopxm() {
		return popxm;
	}
	public void setPopxm(String popxm) {
		this.popxm = popxm;
	}
	public String getPopr() {
		return popr;
	}
	public void setPopr(String popr) {
		this.popr = popr;
	}
	public String getUrbanla() {
		return urbanla;
	}
	public void setUrbanla(String urbanla) {
		this.urbanla = urbanla;
	}
	public String getUrbannegak() {
		return urbannegak;
	}
	public void setUrbannegak(String urbannegak) {
		this.urbannegak = urbannegak;
	}
	public String getAgrivalue() {
		return agrivalue;
	}
	public void setAgrivalue(String agrivalue) {
		this.agrivalue = agrivalue;
	}
	public String getIndivalue() {
		return indivalue;
	}
	public void setIndivalue(String indivalue) {
		this.indivalue = indivalue;
	}
	public String getServalue() {
		return servalue;
	}
	public void setServalue(String servalue) {
		this.servalue = servalue;
	}
	public String getEmpr() {
		return empr;
	}
	public void setEmpr(String empr) {
		this.empr = empr;
	}
	public String getAgriwater() {
		return agriwater;
	}
	public void setAgriwater(String agriwater) {
		this.agriwater = agriwater;
	}
	public String getIndiArea() {
		return indiArea;
	}
	public void setIndiArea(String indiArea) {
		this.indiArea = indiArea;
	}
	public String getSerArea() {
		return serArea;
	}
	public void setSerArea(String serArea) {
		this.serArea = serArea;
	}
	public String getWaterPrice() {
		return waterPrice;
	}
	public void setWaterPrice(String waterPrice) {
		this.waterPrice = waterPrice;
	}
	public String getFlowYLX() {
		return FlowYLX;
	}
	public void setFlowYLX(String flowYLX) {
		FlowYLX = flowYLX;
	}
	public String getFlowOther() {
		return FlowOther;
	}
	public void setFlowOther(String flowOther) {
		FlowOther = flowOther;
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
	public String getCropET() {
		return CropET;
	}
	public void setCropET(String cropET) {
		CropET = cropET;
	}
	public String getEcopro() {
		return ecopro;
	}
	public void setEcopro(String ecopro) {
		this.ecopro = ecopro;
	}
	public String getForestmax() {
		return forestmax;
	}
	public void setForestmax(String forestmax) {
		this.forestmax = forestmax;
	}
	public String getGrassmax() {
		return grassmax;
	}
	public void setGrassmax(String grassmax) {
		this.grassmax = grassmax;
	}
	public String getBarebase() {
		return barebase;
	}
	public void setBarebase(String barebase) {
		this.barebase = barebase;
	}
	public String getBaremax() {
		return baremax;
	}
	public void setBaremax(String baremax) {
		this.baremax = baremax;
	}
	
}