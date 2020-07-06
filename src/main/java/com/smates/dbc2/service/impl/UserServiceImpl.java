package com.smates.dbc2.service.impl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.UserDao;
import com.smates.dbc2.po.User;
import com.smates.dbc2.po.UserAndLanuage;
import com.smates.dbc2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userMapper;

	@Override
	public String getCurrentUserId() {
		return SecurityUtils.getSubject().getPrincipal().toString();
	}

	@Override
	public User getUserByAccountNumber(String accountNumber) {
		return userMapper.selectByAccountNumber(accountNumber);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	/**
	 * 注册用户
	 */
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}
	/**
	 * 添加用户语言
	 */
	@Override
	public void addUserLanuage(UserAndLanuage userAndLanuage) {
		userMapper.addUserLanuage(userAndLanuage);
		
	}
}
