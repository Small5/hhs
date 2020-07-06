package com.smates.dbc2.mapper;

import com.smates.dbc2.po.UserProjectRelation;

public interface UserProjectRelationDao {

	/**
	 * 添加一个用户的默认项目
	 * @param userProjectRelation
	 */
	public void addUserProjectRelation(UserProjectRelation userProjectRelation);
	
	/**
	 * 删除一个用户的默认项目
	 * @param userName 用户账号
	 */
	public void deleteUserProjectRelation(String userName);
	
	/**
	 * 查询用户的默认项目
	 * @param userName 用户账号
	 * @return UserProjectRelation 用户默认项目和账号的对应关系类
	 */
	public UserProjectRelation getUserProjectRelationByUserName(String userName);
	
}
