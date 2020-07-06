package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.AssessResult;
import com.smates.dbc2.po.Evallevel;
import com.smates.dbc2.po.GetScore;
import com.smates.dbc2.po.Gisecharts;
import com.smates.dbc2.vo.CountryIdAndFarmAreaVo;
import com.smates.dbc2.vo.ProjectIdAndCountyId;

/**
 * gis相关Dao
 * 
 * @author machao
 *
 */
public interface GisDao {
	public void updateFlowdown(String projectId,String countyId,String flowdown);
	
	public List<String> getyears(String projectId);
	
	public List<AssessResult> getScore(String projectId,String year);
	/**
	 * 查找所有评价结果信息
	 * 
	 * @return
	 */
	public List<AssessResult> getAllGisecharts(String projectId);

	/**
	 * 添加评价结果信息
	 * 
	 * @param Gisecharts
	 */
	public void addGisecharts(Gisecharts gisecharts);

	/**
	 * 删除评价结果信息
	 * 
	 * @param year
	 */
	public void deleteGisecharts(String year);
	
	/**
	 * 更新上游耕地面积
	 */
	public void updateLandUseArea(CountryIdAndFarmAreaVo ountryIdAndFarmAreaVo);
	
	/**
	 * 更新滴灌面积
	 * @param ountryIdAndFarmAreaVo
	 */
	public void updateSprinkArea(CountryIdAndFarmAreaVo ountryIdAndFarmAreaVo);
	
	
}
