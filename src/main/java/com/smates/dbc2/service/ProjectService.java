package com.smates.dbc2.service;

import java.util.List;

import com.smates.dbc2.po.Project;

/**
 * 项目管理业务层
 * 
 * @author baijw
 *
 */
public interface ProjectService {

	/**
	 * 新增一个项目
	 * 
	 * @param project
	 *            项目内容
	 */
	public void addProject(String username,String name, String describe, String watershedId, String baseYear, String goalYear,
			String step);
	/**
	 * 修改项目
	 * @param username
	 * @param name
	 * @param describe
	 * @param watershedId
	 * @param baseYear
	 * @param goalYear
	 * @param step
	 */
	public void updateProject(String username,String projrctid,String name, String describe, String watershedId, String baseYear, String goalYear,
			String step);
	
	/**
	 * 统计符合条件的项目总数
	 * @param name 项目名称
	 * @return
	 */
	public int getProjectSumByName(String username,String name);
	
	/**
	 * 根据项目名称查找项目
	 * @param name 项目名称
	 * @param rows 每页显示的个数
	 * @param page 当前页数
	 * @return
	 */
	public List<Project> getProjectByName(String username,String name,int rows,int page);

	/**
	 * 根据用户名返回项目名*/
	public List<Project> getProjectByUser(String username);

	/**
	 * 根据项目id删除一个项目
	 * @param id 项目id
	 */
	public void deleteProject(String username,String id);
	
	/**
	 * 根据项目id查询项目
	 * 
	 * @param id项目id
	 * @return 项目所有信息
	 */
	public Project getProjectByUsernameAndId(String username,String id);

}
