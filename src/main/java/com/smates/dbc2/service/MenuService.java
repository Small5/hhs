package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Menu;

/**
 * menu相关service
 * @author baijw12
 *
 */
public interface MenuService {
	
	/**
	 * 根据用户权限获取获取菜单,二级菜单在一级菜单下
	 * @return
	 */
	public List<Menu> getMenuByRoles(Integer role);

}
