package com.smates.dbc2.mapper;

import com.smates.dbc2.po.Goal;

/**
 * 目标体系dao
 * @author baijw
 *
 */
public interface GoalDao {

	/**
	 * 添加一个目标体系
	 * @param goal
	 */
	public void addGoal(Goal goal);

	/**
	 * 根据id查找goal
	 * @param id 
	 */
	public Goal getGoalById(String id);
	
	/**
	 * 删除一个项目的目标体系
	 * @param id
	 */
	public void deleteGoalById(String id);
	
}
