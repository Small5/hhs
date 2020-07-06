package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.DevelopIndexDao;
import com.smates.dbc2.po.Developindex;
import com.smates.dbc2.service.DevelopIndexService;

@Service
public class DevelopIndexServiceImpl implements DevelopIndexService{

	@Autowired
	private DevelopIndexDao developIndexDao;
	
	@Override
	public void addDevelopIndex(int oid, String countyname, float aQ, float eQ, float mGWD, float gDP, float iAGDP, float mIA,
			float pop, float dFA, float dLA, int year) {
		developIndexDao.addDevelopIndex(new Developindex(oid, countyname, aQ, eQ, mGWD, gDP, iAGDP, mIA, pop, dFA, dLA, year));
	}

	@Override
	public void updateDevelopIndex() {
		List<Developindex> developindexs= developIndexDao.getAllDevelopIndex();
		developIndexDao.deleteDevelopIndex();
		System.out.println(developindexs.size());
		for(int i=0;i<developindexs.size();i++){
			developindexs.get(i).setAQ((Math.random()+0.7)*(developindexs.get(i).getAQ()));
			developindexs.get(i).setDFA((Math.random()+0.7)*(developindexs.get(i).getDFA()));
			developindexs.get(i).setDLA((Math.random()+0.7)*(developindexs.get(i).getDLA()));
			developindexs.get(i).setEQ((Math.random()+0.7)*(developindexs.get(i).getEQ()));
			developindexs.get(i).setGDP((Math.random()+0.7)*(developindexs.get(i).getGDP()));
			developindexs.get(i).setIAGDP((Math.random()+0.7)*(developindexs.get(i).getIAGDP()));
			developindexs.get(i).setMGWD((Math.random()+0.7)*(developindexs.get(i).getMGWD()));
			developindexs.get(i).setMIA((Math.random()+0.7)*(developindexs.get(i).getMIA()));
			developindexs.get(i).setPop((Math.random()+0.7)*(developindexs.get(i).getPop()));
			developIndexDao.addDevelopIndex(developindexs.get(i));
		}
	}

}
