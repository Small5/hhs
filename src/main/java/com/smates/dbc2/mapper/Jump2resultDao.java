package com.smates.dbc2.mapper;

import com.smates.dbc2.po.UpStream;

public interface Jump2resultDao {

	//根据项目ID删除相关代理模型
	public void deletecustomizedModelFunction(String projectId);
	//添加上游代理模型
	public void addUpStream(UpStream upstream);
}
