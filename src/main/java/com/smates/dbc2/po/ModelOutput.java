package com.smates.dbc2.po;
//class to save model output
//author:zhanghj
public class ModelOutput 
{
	
	public ModelOutput(String projectId, String year, String countyId, String flowYLX, String flowOther, String surSup,
			String gWSup, String cropET, String wetlandArea, String argValueR, String indValueR, String serValueR,
			String landFarmR, String landCIR, String landSerR, String waterPR, String empR, String surWDR, String gWWDR,
			String argValue, String indValue, String serValue, String landFarm, String landCI, String landSer,
			String waterP, String emp, String surWD, String gWWD) {
		super();
		this.projectId = projectId;
		this.year = year;
		this.countyId = countyId;
		FlowYLX = flowYLX;
		FlowOther = flowOther;
		SurSup = surSup;
		GWSup = gWSup;
		CropET = cropET;
		WetlandArea = wetlandArea;
		ArgValueR = argValueR;
		IndValueR = indValueR;
		SerValueR = serValueR;
		LandFarmR = landFarmR;
		LandCIR = landCIR;
		LandSerR = landSerR;
		WaterPR = waterPR;
		EmpR = empR;
		SurWDR = surWDR;
		GWWDR = gWWDR;
		ArgValue = argValue;
		IndValue = indValue;
		SerValue = serValue;
		LandFarm = landFarm;
		LandCI = landCI;
		LandSer = landSer;
		WaterP = waterP;
		Emp = emp;
		SurWD = surWD;
		GWWD = gWWD;
	}
	private String projectId; //项目编码
	private String year; //年份
	private String countyId; //县区编码

	private String FlowYLX; //莺落峡流量输出 单位：亿立方米
	private String FlowOther; //其他河流流量输出 单位：亿立方米


	private String SurSup; //地表供水量 单位：亿立方米
	private String GWSup; //地下供水量 单位：亿立方米
	private String CropET; //作物蒸散发 单位：亿立方米
	private String WetlandArea; //湿地面积 单位：万亩

	private String ArgValueR; //农业产值 单位：亿元-->变化率 %
	private String IndValueR; //工业产值 单位：亿元-->变化率 %
	private String SerValueR; //服务业产值 单位：亿元-->变化率 %
	private String LandFarmR;//耕地变化率 %
	private String LandCIR; //城镇工业用地变化率 单位：%
	private String LandSerR; //服务业用地变化率 单位：%
	private String WaterPR; //水价变化率 单位：%
	private String EmpR; //就业率 单位：%
	private String SurWDR; //地表需水量变化率 单位：%
	private String GWWDR; //地下需水量变化率 单位：%
	
	private String ArgValue; //农业产值 单位：亿元
	private String IndValue; //工业产值 单位：亿元
	private String SerValue; //服务业产值 单位：亿元-
	private String LandFarm;//耕地 公顷
	private String LandCI; //城镇工业用地 公顷
	private String LandSer; //服务业用地 公顷
	private String WaterP; //水价 元/立方米
	private String Emp; //就业率  小数
	private String SurWD; //地表需水量 亿立方米
	private String GWWD; //地下需水量 亿立方米
	public ModelOutput() {}
	
	public String getArgValue() {
		return ArgValue;
	}
	public void setArgValue(String argValue) {
		ArgValue = argValue;
	}
	public String getIndValue() {
		return IndValue;
	}
	public void setIndValue(String indValue) {
		IndValue = indValue;
	}
	public String getSerValue() {
		return SerValue;
	}
	public void setSerValue(String serValue) {
		SerValue = serValue;
	}
	public String getLandFarm() {
		return LandFarm;
	}
	public void setLandFarm(String landFarm) {
		LandFarm = landFarm;
	}
	public String getLandCI() {
		return LandCI;
	}
	public void setLandCI(String landCI) {
		LandCI = landCI;
	}
	public String getLandSer() {
		return LandSer;
	}
	public void setLandSer(String landSer) {
		LandSer = landSer;
	}
	public String getWaterP() {
		return WaterP;
	}
	public void setWaterP(String waterP) {
		WaterP = waterP;
	}
	public String getEmp() {
		return Emp;
	}
	public void setEmp(String emp) {
		Emp = emp;
	}
	public String getSurWD() {
		return SurWD;
	}
	public void setSurWD(String surWD) {
		SurWD = surWD;
	}
	public String getGWWD() {
		return GWWD;
	}
	public void setGWWD(String gWWD) {
		GWWD = gWWD;
	}
	public String getLandFarmR() {
		return LandFarmR;
	}
	public void setLandFarmR(String landFarmR) {
		LandFarmR = landFarmR;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectID(String projectId) {
		this.projectId = projectId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCountyId() {
		return countyId;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
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
	public String getWetlandArea() {
		return WetlandArea;
	}
	public void setWetlandArea(String wetlandArea) {
		WetlandArea = wetlandArea;
	}
	public String getArgValueR() {
		return ArgValueR;
	}
	public void setArgValueR(String argValue) {
		ArgValueR = argValue;
	}
	public String getIndValueR() {
		return IndValueR;
	}
	public void setIndValueR(String indValue) {
		IndValueR = indValue;
	}
	public String getSerValueR() {
		return SerValueR;
	}
	public void setSerValueR(String serValue) {
		SerValueR = serValue;
	}
	public String getLandCIR() {
		return LandCIR;
	}
	public void setLandCIR(String landCIR) {
		LandCIR = landCIR;
	}
	public String getLandSerR() {
		return LandSerR;
	}
	public void setLandSerR(String landSerR) {
		LandSerR = landSerR;
	}
	public String getWaterPR() {
		return WaterPR;
	}
	public void setWaterPR(String waterPR) {
		WaterPR = waterPR;
	}
	public String getEmpR() {
		return EmpR;
	}
	public void setEmpR(String empR) {
		EmpR = empR;
	}
	public String getSurWDR() {
		return SurWDR;
	}
	public void setSurWDR(String surWDR) {
		SurWDR = surWDR;
	}
	public String getGWWDR() {
		return GWWDR;
	}
	public void setGWWDR(String gWWDR) {
		GWWDR = gWWDR;
	}
	
}
