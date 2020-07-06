package com.smates.dbc2.mapper;

import com.smates.dbc2.po.UserWatershedRelation;

public interface UserWatershedRelationDao {

	/**
	 * 添加一个用户的默认流域
	 * @param userProjectRelation
	 */
	public void addUserWatershedRelation(UserWatershedRelation userWatershedRelation);
	
	/**
	 * 删除一个用户的默认流域
	 * @param userName 用户账号
	 */
	public void deleteUserWatershedRelation(String username);
	
	/**
	 * 查询用户的默认项目
	 * @param userName 用户账号
	 * @return UserProjectRelation 用户默认项目和账号的对应关系类
	 */
	public UserWatershedRelation getUserWatershedRelationByUserName(String username);
	
}
