package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.MenuDao;
import com.smates.dbc2.po.Menu;
import com.smates.dbc2.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<Menu> getMenuByRoles(Integer role) {
		return menuDao.getMenuByRole(role);
	}

}
