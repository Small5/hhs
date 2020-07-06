package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Goals;
import com.smates.dbc2.po.GoalsIDAndProjectID;

public interface GoalsService {

	/**
	 * 获取某项目下的目标
	 * 
	 * @param projectId
	 * @return
	 */
	public List<Goals> getGoalsByProjectidTree(String projectId);

	/**
	 * 获取默认目标
	 * 
	 * @return
	 */
	public List<Goals> getDefaultGoals();

	/**
	 * 添加目标
	 * 
	 * @param goals
	 */
	public void addOneGoal(Goals goals);

	/**
	 * 批量插入目标
	 * 
	 * @param goals
	 */
	public void addGoals(List<Goals> goals);

	/**
	 * 获取某项目下所有目标
	 * 
	 * @param projectId
	 * @return
	 */
	public List<Goals> getGoalsByProjectIDList(String projectId);

	/**
	 * 删除目标
	 * 
	 * @param goalsIDAndProjectID
	 *            目标id和项目id
	 */
	public void deleteGoal(GoalsIDAndProjectID goalsIDAndProjectID);

	/**
	 * 获取数据数量（用于分页）
	 * 
	 * @param projectId
	 * @return
	 */
	public int countSum(String projectId);
}
