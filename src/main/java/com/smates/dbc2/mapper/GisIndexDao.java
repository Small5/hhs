package com.smates.dbc2.mapper;

import com.smates.dbc2.po.GisIndex;

/**
 * Gis左下角图数据
 * @author baijw
 *
 */
public interface GisIndexDao {

	/**
	 * 插入新的指标数据
	 * @param gisIndex
	 */
	public void InsertIndex(GisIndex gisIndex);
	
	/**
	 * 删除所有的指标数据
	 */
	public void deleteAllIndex();
	
}
