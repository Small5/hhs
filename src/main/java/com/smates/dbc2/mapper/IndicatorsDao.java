package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Indicators;

public interface IndicatorsDao {

	/**
	 * 查询模拟结果
	 * 
	 * @author geek_hu
	 */
	public List<Indicators> getAllIndicators(String projectId);
}
