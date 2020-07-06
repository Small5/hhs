package com.smates.dbc2.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Math;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.ModelFunctionDao;
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
import com.smates.dbc2.service.ModelFunctionService;
@Service("modelFunctionService")
public class ModelFunctionServiceImpl implements ModelFunctionService {
	@Autowired
	private ModelFunctionDao modelFunctionMapper;
	@Override
	public List<String> getFunctions(String projectId, String modelName) {
		return modelFunctionMapper.getFunctions(projectId, modelName);
	}
	@Override
	public Object calculate(String expression,Map<String,Object> variableMap){    
        JexlEngine jexlEngine=new JexlEngine();    
        Expression jexlExpression = jexlEngine.createExpression(expression);    
        JexlContext jexlContext = new MapContext();    
        for(String key:variableMap.keySet()){    
            jexlContext.set(key, variableMap.get(key));    
        }    
        if(null==jexlExpression.evaluate(jexlContext)){    
            return "";    
        }    
        return jexlExpression.evaluate(jexlContext);    
    }
	@Override
	public List<String> getDefaultFunctions(String watershedID, String modelName) {
		return modelFunctionMapper.getDefaultFunctions(watershedID, modelName);
	}
	@Override
	public ClimatePara getClimateParaByCounty(String projectId, String countyId) {
		// TODO Auto-generated method stub
		return modelFunctionMapper.getClimateParaByCounty(projectId, countyId);
	}
	
	@Override
	public List<ClimatePara> getAllClimatePara(String projectId) {
		// TODO Auto-generated method stub
		return modelFunctionMapper.getAllClimatePara(projectId);
	}
	@Override
	public LandPara getLandParaByCounty(String projectId, String countyId) {
		// TODO Auto-generated method stub
		return modelFunctionMapper.getLandParaByCounty(projectId, countyId);
	}
	@Override
	public EcoPara getEcoParaByCounty(String projectId, String countyId) {
		// TODO Auto-generated method stub
		return modelFunctionMapper.getEcoParaByCounty(projectId, countyId);
	}
	@Override
	public WaterPara getWaterParaByCounty(String projectId, String countyId) {
		// TODO Auto-generated method stub
		return modelFunctionMapper.getWaterParaByCounty(projectId, countyId);
	}    
	@Override
	public void insertModelOutput(ModelOutput modeloutput)
	{
		// TODO Auto-generated method stub
		modelFunctionMapper.insertModelOutput(modeloutput);
	} 
	public void deleteModelOutput(String projectId)
	{
		modelFunctionMapper.deleteModelOutput(projectId);
	}
	
	@Override
	public List<IndicatorInfo> getIndicatorInfo(String watershedId) {
		/*Map<String,Object> indimap = new HashMap<String,Object>();
		List<IndicatorInfo> indiinfo=modelFunctionMapper.getIndicatorInfo(watershedId);
		for(int i=0;i<indiinfo.size();i++)
		{
			indimap.put(indiinfo.get(i).getIndiVariable(), indiinfo.get(i));
		}
		return indimap;*/
		return modelFunctionMapper.getIndicatorInfo(watershedId);
	}
	@Override
	public Map<String, Object> getIndiParabyWatershedId(String watershedId) {
		Map<String,Object> indiParaMap=new HashMap<String,Object>();
		List<IndicatorPara> indiPara=modelFunctionMapper.getIndicatorPara(watershedId);
		for(int i=0;i<indiPara.size();i++)
		{
			indiParaMap.put(indiPara.get(i).getCountyId(), indiPara.get(i));
		}
		return indiParaMap;
	}
	@Override
	public void insertIndicatorOutput(Indicators indicator) {
		modelFunctionMapper.insertIndicatorOutput(indicator);
	}
	@Override
	public List<Indicators> getIndicatorsbyProjectId(String projectId) {
		
		return modelFunctionMapper.getIndicatorsbyProjectId(projectId);
	}
	@Override
	public void deletIndicatorOutputbyProjectId(String projectId) {
		// TODO Auto-generated method stub
		modelFunctionMapper.deleteIndicatorOutputbyProjectId(projectId);
	}
	@Override
	public String getareaCrop(String projectId) {
		return modelFunctionMapper.getareaCrop(projectId);
		
	}
	@Override
	public void insertScores(AssessResult score) {

		modelFunctionMapper.insertScores(score);
		
	}
	@Override
	public void deleteAssessResultbyProjectId(String projectId) {
		modelFunctionMapper.deleteAssessResultbyProjectId(projectId);
	}
	@Override
	public Map<String, Object> getClimateParaMap(String projectId) {
		Map<String,Object> climatemap=new HashMap<String,Object>();
		List<ClimatePara> climateList=modelFunctionMapper.getAllClimatePara(projectId);
		for(int i=0;i<climateList.size();i++)
		{
			climatemap.put(climateList.get(i).getCountyId(), climateList.get(i));
		}
		return climatemap;
	}
	@Override
	public Map<String, Object> getLandParaMap(String projectId) {
		Map<String,Object> landmap=new HashMap<String,Object>();
		List<LandPara> landList=modelFunctionMapper.getAllLandPara(projectId);
		for(int i=0;i<landList.size();i++)
		{
			landmap.put(landList.get(i).getCountyId(), landList.get(i));
		}
		return landmap;
	}
	@Override
	public Map<String, Object> getEcoParaMap(String projectId) {
		Map<String,Object> ecomap=new HashMap<String,Object>();
		List<EcoPara> ecoList=modelFunctionMapper.getAllEcoPara(projectId);
		for(int i=0;i<ecoList.size();i++)
		{
			ecomap.put(ecoList.get(i).getCountyId(), ecoList.get(i));
		}
		return ecomap;
	}
	@Override
	public Map<String, Object> getWaterParaMap(String projectId) {
		Map<String,Object> watermap=new HashMap<String,Object>();
		List<WaterPara> waterList=modelFunctionMapper.getAllWaterPara(projectId);
		for(int i=0;i<waterList.size();i++)
		{
			watermap.put(waterList.get(i).getCountyId(), waterList.get(i));
		}
		return watermap;
	}
	@Override
	public void insertTestManyOutput(TestManyOutput many) {
		modelFunctionMapper.insertTestManyOutput(many);
	}
	@Override
	public void deleteTestManyOutput(String projectId) {
		modelFunctionMapper.deleteTestManyOutput(projectId);		
	}
	@Override
	public String getTestFlag() {
		// TODO Auto-generated method stub
		return modelFunctionMapper.getTestFlag();
	}
	@Override
	public void setTestFlag(String flag,String messege) {
		modelFunctionMapper.setTestFlag(flag,messege);
	}
	@Override
	public String getNum(String projectId) {
		// TODO Auto-generated method stub
		return modelFunctionMapper.getNum(projectId);
	}
	@Override
	public void deleteIndicatorWeithtbyProjectId(String projectId) {
		modelFunctionMapper.deleteIndicatorWeithtbyProjectId(projectId);
	}
	@Override
	public void insertIndicatorWeight(IndicatorWeight iw) {
		modelFunctionMapper.insertIndicatorWeight(iw);
	}
}
