package com.smates.dbc2.mapper;

import java.util.List;
import java.util.Map;

import com.smates.dbc2.po.AssessResult;
import com.smates.dbc2.po.ClimatePara;
import com.smates.dbc2.po.EcoPara;
import com.smates.dbc2.po.IndicatorInfo;
import com.smates.dbc2.po.IndicatorPara;
import com.smates.dbc2.po.IndicatorWeight;
import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.LandPara;
import com.smates.dbc2.po.ModelOutput;
import com.smates.dbc2.po.TestManyOutput;
import com.smates.dbc2.po.WaterPara;

public interface ModelFunctionDao {
	public List<String> getFunctions(String projectId,String modelName);
	public List<String> getDefaultFunctions(String watershedID,String modelName);
	public ClimatePara getClimateParaByCounty(String projectId,String countyId);
	public List<ClimatePara> getAllClimatePara(String projectId);
	public List<LandPara> getAllLandPara(String projectId);
	public List<EcoPara> getAllEcoPara(String projectId);
	public List<WaterPara> getAllWaterPara(String projectId);
	
	public LandPara getLandParaByCounty(String projectId,String countyId);
	public EcoPara getEcoParaByCounty(String projectId,String countyId);
	public WaterPara getWaterParaByCounty(String projectId,String countyId);
	
	public void insertModelOutput(ModelOutput modeloutput);
	public void deleteModelOutput(String projectId);
	
	
	public List<IndicatorInfo> getIndicatorInfo(String watershedId);
	public Object convertToCode(String jexlExp,Map<String,Object> map);
	public List<IndicatorPara> getIndicatorPara(String watershedId);
	public void insertIndicatorOutput(Indicators indicator);
	public List<Indicators> getIndicatorsbyProjectId(String projectId);
	public void deleteIndicatorOutputbyProjectId(String projectId);
	public String getareaCrop(String projectId);
	public void insertScores(AssessResult score);
	public void deleteAssessResultbyProjectId(String projectId);
	public void insertTestManyOutput(TestManyOutput many);
	public void deleteTestManyOutput(String projectId);
	public String getTestFlag();
	public void setTestFlag(String flag,String messege);
	public String getNum(String projectId);
	public void deleteIndicatorWeithtbyProjectId(String projectId);
	public void insertIndicatorWeight(IndicatorWeight iw);
}
