package com.smates.dbc2.service;

import com.smates.dbc2.po.UserWatershedRelation;

public interface UserWatershedRelationService {

	/**
	 * 添加用户默认流域
	 * @param userName 用户账号
	 * @param autoProjectId 用户的默认流域
	 */
	public void addUserWatershedRelation(String username, String autowatershedid);
	
	/**
	 * 查找用户的默认流域
	 * @param userName 用户账号
	 * @return 用户和默认流域的对应关系类
	 */
	public UserWatershedRelation getUserWatershedRelationByUserName(String username);
}
