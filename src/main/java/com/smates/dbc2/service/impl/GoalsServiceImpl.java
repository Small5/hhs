package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.GoalsDao;
import com.smates.dbc2.po.Goals;
import com.smates.dbc2.po.GoalsIDAndProjectID;
import com.smates.dbc2.service.GoalsService;

@Service
public class GoalsServiceImpl implements GoalsService {

	@Autowired
	private GoalsDao goalsDao;

	@Override
	public List<Goals> getGoalsByProjectidTree(String projectId) {
		return goalsDao.getGoalsByProjectidTree(projectId);
	}

	@Override
	public List<Goals> getDefaultGoals() {
		return goalsDao.getDefaultGoals();
	}

	@Override
	public void addOneGoal(Goals goals) {
		goalsDao.addOneGoal(goals);
	}

	@Override
	public void addGoals(List<Goals> goals) {
		goalsDao.addGoals(goals);
	}

	@Override
	public List<Goals> getGoalsByProjectIDList(String projectId) {
		return goalsDao.getGoalsByProjectIDList(projectId);
	}

	@Override
	public void deleteGoal(GoalsIDAndProjectID goalsIDAndProjectID) {
		goalsDao.deleteGoal(goalsIDAndProjectID);
	}

	@Override
	public int countSum(String projectId) {
		return goalsDao.countSum(projectId);
	}

}
