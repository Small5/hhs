package com.smates.dbc2.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.ProjectDao;
import com.smates.dbc2.po.Project;
import com.smates.dbc2.po.Project2;
import com.smates.dbc2.service.ProjectService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.vo.ProjectParaVo;
import com.smates.dbc2.vo.UsernameAndName;
import com.smates.dbc2.vo.UsernameAndProjectId;
import com.smates.dbc2.vo.UsernameAndWatershedId;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDao projectDao;

	@Override
	public void addProject(String username,String name, String describe, String watershedId, String baseYear, String goalYear,
			String step) {
		projectDao.addProject(new Project(username, name, watershedId, new Date(), describe, baseYear, goalYear, step));
	}

	@Override
	public int getProjectSumByName(String username,String name) {
		return projectDao.getProjectSumByName(new UsernameAndName(username,name));
	}

	@Override
	public List<Project> getProjectByName(String username,String name, int rows, int page) {
		return projectDao.getProjectByName(new ProjectParaVo(username,name, rows, (page-1)*rows));
	}
	@Override
	public List<Project> getProjectByUser(String username){
		return projectDao.getProjectByUser(username);
	}

	@Override
	public void deleteProject(String username,String id) {
		projectDao.deleteProject(new UsernameAndProjectId(username,id));
	}

	@Override
	public Project getProjectByUsernameAndId(String username,String id) {
		return projectDao.getProjectByUsernameAndId(new UsernameAndProjectId(username,id));
	}

	@Override
	public void updateProject(String username,String projectid,String name, String describe, String watershedId, String baseYear,
			String goalYear, String step) {
			projectDao.updateProject(new Project2(username,projectid,name, watershedId, new Date(), describe, baseYear, goalYear, step));
		
	}

}
