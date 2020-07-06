package com.smates.dbc2.service.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.ModelDao;
import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.ModelOutput;
import com.smates.dbc2.service.ModelService;
import com.smates.dbc2.vo.ProjectIdAndCountyId;
import com.smates.dbc2.vo.ProjectIdAndCountyId2;

@Service
public class ModelServiceImpl implements ModelService{

	@Autowired
	private ModelDao modeldao;
	
	@Override
	public List<String> queryAvailable(String projectId,String countyId) {
		return modeldao.queryAvailable(new ProjectIdAndCountyId(projectId,countyId));
	}

	@Override
	public List<Indicators> getDataYearlyws(String projectId, String countyId, String year) {
		return modeldao.getDataYearlyws(new ProjectIdAndCountyId2(projectId, countyId, year));
	}

	@Override
	public String getgoalyear(String projectId) {
		
		return modeldao.getgoalyear(projectId);
	}

	@Override
	public List<ModelOutput> getAllmodeloutput(String projectId) {
		
		return modeldao.getAllmodeloutput(projectId);
	}

	@Override
	public void inputStartTime(String projectId) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		modeldao.inputStartTime(projectId,dateString);
	}
	
	@Override
	public void deleteStartTime(String projectId) {
		modeldao.deleteStartTime(projectId);
	}

	@Override
	public void inputEndTime(String projectId) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		modeldao.inputEndTime(projectId,dateString);	
	}
	
	@Override
	public void deleteEndTime(String projectId) {
		modeldao.deleteEndTime(projectId);	
	}

	@Override
	public String getStartTime(String projectId) {
		
		return modeldao.getStartTime(projectId);
	}

	@Override
	public String getEndTime(String projectId) {
		
		return modeldao.getEndTime(projectId);
	}
	
}
