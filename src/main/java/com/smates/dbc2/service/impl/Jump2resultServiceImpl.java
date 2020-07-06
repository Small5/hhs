package com.smates.dbc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.Jump2resultDao;
import com.smates.dbc2.po.UpStream;
import com.smates.dbc2.service.Jump2resultService;

@Service("jump2resultService")
public class Jump2resultServiceImpl implements Jump2resultService{

	@Autowired
	private Jump2resultDao jump2resultdao;
	@Override
	public void addUpStream(UpStream upstream) {
		jump2resultdao.addUpStream(upstream);
	}

}
