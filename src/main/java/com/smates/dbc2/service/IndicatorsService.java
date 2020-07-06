package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Indicators;

public interface IndicatorsService {

	/**
	 * 查询所有模拟结果
	 * @return
	 */
	public List<Indicators> getAllIndicators(String projectId);
}
