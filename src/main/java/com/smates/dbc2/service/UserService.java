package com.smates.dbc2.service;

import com.smates.dbc2.po.User;
import com.smates.dbc2.po.UserAndLanuage;

/**
 * 用户相关service
 * 
 * @author baijw12
 *
 */
public interface UserService {

	/**
	 * 添加用户语言
	 * @param userAndLanuage
	 */
	public void addUserLanuage(UserAndLanuage userAndLanuage);
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public void addUser(User user);
	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	public String getCurrentUserId();

	/**
	 * 根据accountNumber查找user
	 * 
	 * @param accountNumber
	 * @return
	 */
	public User getUserByAccountNumber(String accountNumber);

	/**
	 * 根据用户id更新用户信息
	 * 
	 * @param user2
	 *            用户信息
	 */
	public void updateUser(User user2);
}
