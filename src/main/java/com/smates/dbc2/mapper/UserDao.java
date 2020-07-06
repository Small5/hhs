package com.smates.dbc2.mapper;

import com.smates.dbc2.po.User;
import com.smates.dbc2.po.UserAndLanuage;

public interface UserDao {
	/**
	 * 添加用户语言
	 * @param userAndLanuage
	 */
	public void addUserLanuage(UserAndLanuage userAndLanuage);
	/**
	 * 注册用户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 根据 accountNumber查找user
	 * @param accountNumber
	 * @return user
	 */
	public User selectByAccountNumber(String accountNumber);

	/**
	 * 根据用户id更新用户信息
	 * 
	 * @param user2
	 */
	public void updateUser(User user2);
}