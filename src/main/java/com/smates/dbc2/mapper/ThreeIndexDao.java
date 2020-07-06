package com.smates.dbc2.mapper;

import com.smates.dbc2.po.ThreeIndex;

/**
 * GIS地图上的三个指标树状图
 * @author baijw
 *
 */
public interface ThreeIndexDao {

	/**
	 * 删除所有
	 */
	public void deleteAll();
	
	/**
	 * 添加新的指标
	 */
	public void insertIndex(ThreeIndex threeIndex);
	
}
