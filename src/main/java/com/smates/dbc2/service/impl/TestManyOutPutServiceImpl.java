package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.TestManyOutputDao;
import com.smates.dbc2.po.TestManyOutput;
import com.smates.dbc2.service.TestManyOutPutService;

@Service
public class TestManyOutPutServiceImpl implements TestManyOutPutService{

	@Autowired
	TestManyOutputDao testManyOutputDao;
	@Override
	public List<TestManyOutput> getalldatas(String projectId) {
		return testManyOutputDao.getalldatas(projectId);
	}

}
