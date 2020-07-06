package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Developindex;
import com.smates.dbc2.po.Evallevel;
import com.smates.dbc2.po.GisIndex;
import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.ThreeIndex;
import com.smates.dbc2.vo.ProjectIdAndCountyId;

public interface LeafletDao {
	public List<Evallevel> getEvellevel(String year);
	public List<String> getIndexTypeCH();//获取指标类型中文
	public List<String> getIndexTypeEN();//获取指标类型英文
	public List<String> getAllYear();//获取所有年份
	public List<ThreeIndex> getEvaluateResult(int year);//获取评价结果指标数据
	//根据县区ID,获取左边图表数据
	public List<Indicators> getLeftDataByCountyId(ProjectIdAndCountyId projectIdAndCountyId);
//	public List<GisIndex> getLeftDataByType(String name,String type);//根据指标类型,县名获取左边图表数据
	public List<Developindex> getRightDataByYear(String name,int year);//根据年份获取右边图表数据
	public List<GisIndex> getTypeValueByYearAndIndexype(String type,int year);//根据年份和指标类型获取每个区域的指标数据
}
