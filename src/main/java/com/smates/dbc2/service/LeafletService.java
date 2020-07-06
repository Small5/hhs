package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Developindex;
import com.smates.dbc2.po.Evallevel;
import com.smates.dbc2.po.GisIndex;
import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.ThreeIndex;

public interface LeafletService {
	public List<Evallevel> getEvallevel(String year); 
	//获取中文指标类型
	public List<String> getIndexTypeCH();
	//获取英文指标类型
	public List<String> getIndexTypeEN();
	public List<String> getAllYear();
	public List<ThreeIndex> getEvaluateResult(int year);
//	public List<GisIndex> getLeftDataByType(String name,String type);
	public List<Developindex> getRightDataByYear(String name,int year);
	public List<GisIndex> getTypeValueByYearAndIndexype(String type,int year);
	//根据县区ID获取左侧列表数据
	public List<Indicators> getLeftDataByCountyId(String projectId,String countyId);
}
