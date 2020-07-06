package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.IndicatorsDao;
import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.service.IndicatorsService;

@Service
public class IndicatorsServiceImpl implements IndicatorsService{

	@Autowired
	private IndicatorsDao indicatorsDao;
	
	@Override
	public List<Indicators> getAllIndicators(String projectId) {
		
		return  indicatorsDao.getAllIndicators(projectId);
	}
}
