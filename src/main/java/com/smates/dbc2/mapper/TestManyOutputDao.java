package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.TestManyOutput;

public interface TestManyOutputDao {

	public List<TestManyOutput> getalldatas(String projectId);
}
