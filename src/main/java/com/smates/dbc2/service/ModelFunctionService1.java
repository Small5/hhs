//package com.smates.dbc2.service;
//
//import java.util.List;
//import java.util.Map;
//
//import com.smates.dbc2.po.AssessResult;
//import com.smates.dbc2.po.ClimatePara;
//import com.smates.dbc2.po.EcoPara;
//import com.smates.dbc2.po.IndicatorInfo;
//import com.smates.dbc2.po.Indicators;
//import com.smates.dbc2.po.LandPara;
//import com.smates.dbc2.po.ModelOutput;
//import com.smates.dbc2.po.TestManyOutput;
//import com.smates.dbc2.po.WaterPara;
//
//public interface ModelFunctionService1 {
//	public List<String> getFunctions(String projectId,String modelName);
//	public List<String> getDefaultFunctions(String watershedID,String modelName);
//	public ClimatePara getClimateParaByCounty(String projectId,String countyId);
//	public List<ClimatePara> getAllClimatePara(String projectId);
//	public LandPara getLandParaByCounty(String projectId,String countyId);
//	public EcoPara getEcoParaByCounty(String projectId,String countyId);
//	public WaterPara getWaterParaByCounty(String projectId,String countyId);
//	
//	public void insertModelOutput(ModelOutput modeloutput);
//	public void deleteModelOutput(String projectId);
//	
//	public Object calculate(String jexlExp,Map<String,Object> map);
//	
//	public Map<String,Object> getIndiParabyWatershedId(String watershedId);
//	public List<IndicatorInfo> getIndicatorInfo(String watershedId);
//	public void insertIndicatorOutput(Indicators indicator);
//	public List<Indicators> getIndicatorsbyProjectId(String projectId);
//	public void deletIndicatorOutputbyProjectId(String projectId);
//	public String getareaCrop(String projectId);
//	public void insertScores(AssessResult score);
//	public void deleteAssessResultbyProjectId(String projectId);
//	
//	public Map<String,Object> getClimateParaMap(String projectId);
//	public Map<String,Object> getLandParaMap(String projectId);
//	public Map<String,Object> getEcoParaMap(String projectId);
//	public Map<String,Object> getWaterParaMap(String projectId);
//	
//	public void insertTestManyOutput(TestManyOutput many);
//	public void deleteTestManyOutput(String projectId);
//	public String getTestFlag();
//	public void setTestFlag(String flag,String messege);
//	public String getNum(String projectId);
//}
