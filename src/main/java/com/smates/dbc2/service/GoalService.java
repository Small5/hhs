package com.smates.dbc2.service;

import com.smates.dbc2.po.Goal;
import com.smates.dbc2.vo.Node;

/**
 * 
 * @author baijw
 *
 */
public interface GoalService {

	/**
	 * 新增一个目标体系
	 * @param goal
	 */
	public void addGoal(String projectId, String goal_1, String goal_2, String goal_3, String index_111, String index_112, String index_121,
			String index_131, String index_132, String index_141, String index_142, String index_143, String index_144,
			String index_211, String index_221, String index_231, String index_311, String index_321, String index_331,
			String index_341, String index_351, String index_352, String index_361,
			String index_371, String index_372, String index_373, String index_381,
			String goal_1_status,String goal_2_status,String goal_3_status,String index_111_status,
			String index_112_status,String index_121_status,String index_131_status,String index_132_status,
			String index_141_status,String index_142_status,String index_143_status,String index_144_status,
			String index_211_status,String index_221_status,String index_231_status,
			String index_311_status,String index_321_status,String index_331_status,
			String index_341_status,String index_351_status,String index_352_status,
			String index_361_status,String index_371_status,String index_372_status,
			String index_373_status,String index_381_status);
	
	public Node getGoalTreeById(String id);
	
	public Goal getGoalById(String id);
	
	/**
	 * 删除一个项目的目标体系
	 * @param id
	 */
	public void deleteGoalById(String id);
	
	
	
}
