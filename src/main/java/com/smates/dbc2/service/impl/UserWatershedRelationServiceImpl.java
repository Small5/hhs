package com.smates.dbc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.UserWatershedRelationDao;
import com.smates.dbc2.po.UserWatershedRelation;

import com.smates.dbc2.service.UserWatershedRelationService;

@Service
public class UserWatershedRelationServiceImpl implements UserWatershedRelationService{

	@Autowired
	private UserWatershedRelationDao userWatershedRelationDao;
	
	@Override
	public void addUserWatershedRelation(String username, String autowatershedid) {
		userWatershedRelationDao.deleteUserWatershedRelation(username);
		userWatershedRelationDao.addUserWatershedRelation(new UserWatershedRelation(username,autowatershedid));
	}

	@Override
	public UserWatershedRelation getUserWatershedRelationByUserName(String username) {
		return userWatershedRelationDao.getUserWatershedRelationByUserName(username);
	}

}
