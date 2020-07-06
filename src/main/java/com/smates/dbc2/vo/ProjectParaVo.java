package com.smates.dbc2.vo;

/**
 * 项目查找条件vo
 * 
 * @author baijw
 *
 */
public class ProjectParaVo {

	private String username;
	private String name;
	private int rows;
	private int startNum;

	public ProjectParaVo() {
	}

	public ProjectParaVo(String username,String name, int rows, int startNum) {
		this.username = username;
		this.name = name;
		this.rows = rows;
		this.startNum = startNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	@Override
	public String toString() {
		return "ProjectParaVo [username=" + username + ", name=" + name + ", rows=" + rows + ", startNum=" + startNum
				+ "]";
	}

}
