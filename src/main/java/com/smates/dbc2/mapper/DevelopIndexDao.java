package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Developindex;

public interface DevelopIndexDao {
	
	/**
	 * 保存发展指标
	 * @param developindex
	 */
	public void addDevelopIndex(Developindex developindex);
	
	/**
	 * 删除发展指标
	 */
	public void deleteDevelopIndex();
	
	/**
	 * 获取所有的指标
	 * @return
	 */
	public List<Developindex> getAllDevelopIndex();
}
