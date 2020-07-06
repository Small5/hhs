package com.smates.dbc2.po;

public class TestManyOutput {
	private String projectId; //项目编码
	//温度变化℃，降水变化率%，耕地面积变化率%，农业技术进步率%，正义峡下泄量 亿立方米 5个组合变量的值
	private String tempset;//温度变化℃
	private String preset;//降水变化率%
	private String cultiarearset;//耕地面积变化率%
	private String cultitechrset;//农业技术进步率%
	private String downstreamset;//正义峡下泄量 亿立方米
	
	private String year; //年份
	private String countyId; //县区编码
    //模型输出相关
	private String FlowYLX; //莺落峡流量输出 单位：亿立方米
	private String FlowOther; //其他河流流量输出 单位：亿立方米
	private String SurSup; //地表供水量 单位：亿立方米
	private String GWSup; //地下供水量 单位：亿立方米
	private String CropET; //作物蒸散发 单位：亿立方米
	private String ArgValueR; //农业产值 单位：变化率 %
	private String IndValueR; //工业产值 单位：变化率 %
	private String SerValueR; //服务业产值 单位：变化率 %
	private String LandFarmR;//耕地变化率 %
	private String LandCIR; //城镇工业用地变化率 单位：%
	private String LandSerR; //服务业用地变化率 单位：%
	private String WaterPR; //水价变化率 单位：%
	private String EmpR; //就业率 单位：%
	private String SurWDR; //地表需水量变化率 单位：%
	private String GWWDR; //地下需水量变化率 单位：%
	//指标输出相关
	private String waterProductivity;// 提高水生产力到b%
	private String waterPressure; // 在各个层次上减小用水压力到m%
	private String safeDrinkingWaterR;// 提高流域社会安全饮用水人口比例到d%
	private String groundwaterMining;// 中游地下水开采量i 亿m3
	private String mountainGreenCoverR;// 山地绿色覆盖指数b%
	private String gdpPerCapita;// 人均GDP
	private String gdpPerCapitaEmployed;// 就业人口人均 GDP 增长率	
	private String urbanR;// 城镇化率	
	private String waterUseEffiAgri;// 农业水利用效率	
	private String waterProductivityAgri;// 农业水生产力
	private String areaCrop; // 维持可持续农业种植面积
	//评分相关
	private String totalscore;
	private String goal1score;
	private String goal2score;
	private String goal3score;
	private String totalindex;
	private String goal1index;
	private String goal2index;
	private String goal3index;
	
	//2018.10.26新加的计算真正变量值
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
	private String forestcoverR;//森林覆盖率 %
	private String barecoverR;//土地退化率%
	public String getBarecoverR() {
		return barecoverR;
	}
	public void setBarecoverR(String barecoverR) {
		this.barecoverR = barecoverR;
	}
	public String getForestcoverR() {
		return forestcoverR;
	}
	public void setForestcoverR(String forestcoverR) {
		this.forestcoverR = forestcoverR;
	}
	public TestManyOutput(String projectId, String tempset, String preset, String cultiarearset, String cultitechrset,
			String downstreamset, String year, String countyId, String flowYLX, String flowOther, String surSup,
			String gWSup, String cropET, String argValueR, String indValueR, String serValueR, String landFarmR,
			String landCIR, String landSerR, String waterPR, String empR, String surWDR, String gWWDR,
			String waterProductivity, String waterPressure, String safeDrinkingWaterR, String groundwaterMining,
			String mountainGreenCoverR, String gdpPerCapita, String gdpPerCapitaEmployed, String urbanR,
			String waterUseEffiAgri, String waterProductivityAgri, String areaCrop, String totalscore,
			String goal1score, String goal2score, String goal3score, String totalindex, String goal1index,
			String goal2index, String goal3index, String argValue, String indValue, String serValue, String landFarm,
			String landCI, String landSer, String waterP, String emp, String surWD, String gWWD,String forestcoverr,String barecoverr) {
		super();
		this.projectId = projectId;
		this.tempset = tempset;
		this.preset = preset;
		this.cultiarearset = cultiarearset;
		this.cultitechrset = cultitechrset;
		this.downstreamset = downstreamset;
		this.year = year;
		this.countyId = countyId;
		FlowYLX = flowYLX;
		FlowOther = flowOther;
		SurSup = surSup;
		GWSup = gWSup;
		CropET = cropET;
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
		this.waterProductivity = waterProductivity;
		this.waterPressure = waterPressure;
		this.safeDrinkingWaterR = safeDrinkingWaterR;
		this.groundwaterMining = groundwaterMining;
		this.mountainGreenCoverR = mountainGreenCoverR;
		this.gdpPerCapita = gdpPerCapita;
		this.gdpPerCapitaEmployed = gdpPerCapitaEmployed;
		this.urbanR = urbanR;
		this.waterUseEffiAgri = waterUseEffiAgri;
		this.waterProductivityAgri = waterProductivityAgri;
		this.areaCrop = areaCrop;
		this.totalscore = totalscore;
		this.goal1score = goal1score;
		this.goal2score = goal2score;
		this.goal3score = goal3score;
		this.totalindex = totalindex;
		this.goal1index = goal1index;
		this.goal2index = goal2index;
		this.goal3index = goal3index;
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
		forestcoverR=forestcoverr;
		barecoverR=barecoverr;
	}
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
	
	public TestManyOutput() {}
	public String getTotalindex() {
		return totalindex;
	}
	public void setTotalindex(String totalindex) {
		this.totalindex = totalindex;
	}
	public String getGoal1index() {
		return goal1index;
	}
	public void setGoal1index(String goal1index) {
		this.goal1index = goal1index;
	}
	public String getGoal2index() {
		return goal2index;
	}
	public void setGoal2index(String goal2index) {
		this.goal2index = goal2index;
	}
	public String getGoal3index() {
		return goal3index;
	}
	public void setGoal3index(String goal3index) {
		this.goal3index = goal3index;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTempset() {
		return tempset;
	}
	public void setTempset(String tempset) {
		this.tempset = tempset;
	}
	public String getPreset() {
		return preset;
	}
	public void setPreset(String preset) {
		this.preset = preset;
	}
	public String getCultiarearset() {
		return cultiarearset;
	}
	public void setCultiarearset(String cultiarearset) {
		this.cultiarearset = cultiarearset;
	}
	public String getCultitechrset() {
		return cultitechrset;
	}
	public void setCultitechrset(String cultitechrset) {
		this.cultitechrset = cultitechrset;
	}
	public String getDownstreamset() {
		return downstreamset;
	}
	public void setDownstreamset(String downstreamset) {
		this.downstreamset = downstreamset;
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
	public String getLandFarmR() {
		return LandFarmR;
	}
	public void setLandFarmR(String landFarmR) {
		LandFarmR = landFarmR;
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
	public String getWaterProductivity() {
		return waterProductivity;
	}
	public void setWaterProductivity(String waterProductivity) {
		this.waterProductivity = waterProductivity;
	}
	public String getWaterPressure() {
		return waterPressure;
	}
	public void setWaterPressure(String waterPressure) {
		this.waterPressure = waterPressure;
	}
	public String getSafeDrinkingWaterR() {
		return safeDrinkingWaterR;
	}
	public void setSafeDrinkingWaterR(String safeDrinkingWaterR) {
		this.safeDrinkingWaterR = safeDrinkingWaterR;
	}
	public String getGroundwaterMining() {
		return groundwaterMining;
	}
	public void setGroundwaterMining(String groundwaterMining) {
		this.groundwaterMining = groundwaterMining;
	}
	public String getMountainGreenCoverR() {
		return mountainGreenCoverR;
	}
	public void setMountainGreenCoverR(String mountainGreenCoverR) {
		this.mountainGreenCoverR = mountainGreenCoverR;
	}
	public String getGdpPerCapita() {
		return gdpPerCapita;
	}
	public void setGdpPerCapita(String gdpPerCapita) {
		this.gdpPerCapita = gdpPerCapita;
	}
	public String getGdpPerCapitaEmployed() {
		return gdpPerCapitaEmployed;
	}
	public void setGdpPerCapitaEmployed(String gdpPerCapitaEmployed) {
		this.gdpPerCapitaEmployed = gdpPerCapitaEmployed;
	}
	public String getUrbanR() {
		return urbanR;
	}
	public void setUrbanR(String urbanR) {
		this.urbanR = urbanR;
	}
	public String getWaterUseEffiAgri() {
		return waterUseEffiAgri;
	}
	public void setWaterUseEffiAgri(String waterUseEffiAgri) {
		this.waterUseEffiAgri = waterUseEffiAgri;
	}
	public String getWaterProductivityAgri() {
		return waterProductivityAgri;
	}
	public void setWaterProductivityAgri(String waterProductivityAgri) {
		this.waterProductivityAgri = waterProductivityAgri;
	}
	public String getAreaCrop() {
		return areaCrop;
	}
	public void setAreaCrop(String areaCrop) {
		this.areaCrop = areaCrop;
	}
	public String getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(String totalscore) {
		this.totalscore = totalscore;
	}
	public String getGoal1score() {
		return goal1score;
	}
	public void setGoal1score(String goal1score) {
		this.goal1score = goal1score;
	}
	public String getGoal2score() {
		return goal2score;
	}
	public void setGoal2score(String goal2score) {
		this.goal2score = goal2score;
	}
	public String getGoal3score() {
		return goal3score;
	}
	public void setGoal3score(String goal3score) {
		this.goal3score = goal3score;
	}
	
	
}
