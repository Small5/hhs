package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.ModelOutput;

public interface ModelService {

	public List<String> queryAvailable(String projectId,String countyId);
	
	public List<Indicators> getDataYearlyws(String projectId,String countyId,String year);
	
	public String getgoalyear(String projectId);
	
	//查询模型输出中间结果
	public List<ModelOutput> getAllmodeloutput(String projectId);
	
	public void inputStartTime(String projectid);
	
	public void deleteStartTime(String projectid);
	
	public void inputEndTime(String projectid);
	
	public void deleteEndTime(String projectid);
	
	public String getStartTime(String projectId);
	
	public String getEndTime(String projectId);
}
