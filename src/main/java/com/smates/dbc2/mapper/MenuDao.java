package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.Menu;

public interface MenuDao {
	
	/**
	 * 获取所有菜单,一级菜单和二级菜单
	 * @return
	 */
	public List<Menu> getMenuByRole(Integer role);
	
}
