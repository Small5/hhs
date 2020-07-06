package com.smates.dbc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.UserProjectRelationDao;
import com.smates.dbc2.po.UserProjectRelation;
import com.smates.dbc2.service.UserProjectRelationService;

@Service
public class UserProjectRelationServiceImpl implements UserProjectRelationService{

	@Autowired
	private UserProjectRelationDao userProjectRelationDao;
	
	@Override
	public void addUserProjectRelation(String userName, String autoProjectId) {
		userProjectRelationDao.deleteUserProjectRelation(userName);
		userProjectRelationDao.addUserProjectRelation(new UserProjectRelation(userName, autoProjectId));
	}

	@Override
	public UserProjectRelation getUserProjectRelationByUserName(String userName) {
		return userProjectRelationDao.getUserProjectRelationByUserName(userName);
	}

}
