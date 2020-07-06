package com.smates.dbc2.mapper;

import java.util.Date;
import java.util.List;

import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.ModelOutput;
import com.smates.dbc2.vo.ProjectIdAndCountyId;
import com.smates.dbc2.vo.ProjectIdAndCountyId2;

public interface ModelDao {
	
	public List<String> queryAvailable(ProjectIdAndCountyId proacou);
	
	public List<Indicators> getDataYearlyws(ProjectIdAndCountyId2 proacou2);
	
	public String getgoalyear(String projectId);
	
	public List<ModelOutput> getAllmodeloutput(String projectId);
	
	public void inputStartTime(String projectId,String time);
	
	public void deleteStartTime(String projectId);
	
	public void inputEndTime(String projectId,String time);
	
	public void deleteEndTime(String projectId);
	
	public String getStartTime(String projectId);
	
	public String getEndTime(String projectId);
}
 