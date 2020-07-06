package com.smates.dbc2.service;

import com.smates.dbc2.po.UserProjectRelation;

public interface UserProjectRelationService {

	/**
	 * 添加用户默认项目
	 * @param userName 用户账号
	 * @param autoProjectId 用户的默认项目
	 */
	public void addUserProjectRelation(String userName, String autoProjectId);
	
	/**
	 * 查找用户的默认项目
	 * @param userName 用户账号
	 * @return 用户和默认账号的对应关系类
	 */
	public UserProjectRelation getUserProjectRelationByUserName(String userName);
}
