package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Country;

/**
 * 对Country操作
 * @author baijw
 *
 */
public interface CountryDao {

	/**
	 * 查找所有县区信息
	 * @return 县区list
	 */
	public List<Country> getAllCountry();
	
}
