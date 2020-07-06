package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.LeafletDao;
import com.smates.dbc2.po.Developindex;
import com.smates.dbc2.po.Evallevel;
import com.smates.dbc2.po.GisIndex;
import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.ThreeIndex;
import com.smates.dbc2.service.LeafletService;
import com.smates.dbc2.vo.ProjectIdAndCountyId;

@Service
public class LeafletServiceImpl implements LeafletService {

	@Autowired
	private LeafletDao leafletDao;
	//获取中文指标类型
	@Override
	public List<String> getIndexTypeCH() {	
		return leafletDao.getIndexTypeCH();
	}
	//获取英文指标类型
	@Override
	public List<String> getIndexTypeEN() {	
		return leafletDao.getIndexTypeEN();
	}
	@Override
	public List<String> getAllYear() {
		return leafletDao.getAllYear();
	}
	@Override
	public List<ThreeIndex> getEvaluateResult(int year) {
		return leafletDao.getEvaluateResult(year);
	}
//	@Override
//	public List<GisIndex> getLeftDataByType(String name, String type) {
//		return leafletDao.getLeftDataByType(name, type);
//	}
	@Override
	public List<Developindex> getRightDataByYear(String name, int year) {
		return leafletDao.getRightDataByYear(name, year);
	}
	@Override
	public List<GisIndex> getTypeValueByYearAndIndexype(String type, int year) {
		return leafletDao.getTypeValueByYearAndIndexype(type, year);
	}
	@Override
	public List<Evallevel> getEvallevel(String year) {
		return leafletDao.getEvellevel(year);
	}
	@Override
	public List<Indicators> getLeftDataByCountyId(String projectId, String countyId) {
		return leafletDao.getLeftDataByCountyId(new ProjectIdAndCountyId(projectId,countyId));
	}

}
