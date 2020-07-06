package com.smates.dbc2.po;

import java.util.Date;
import java.util.UUID;

/**
 * 项目po
 * 
 * @author baijw
 *
 */
public class Project2 {
	
	private String username;
	private String id;
	private String name;
	private String watershedId;
	private String createTime;
	private String describe;
	private String baseYear;
	private String goalYear;
	private String step;

	public Project2() {
	}

	public Project2(String username,String id,String name, String watershedId, Date createTime, String describe, String baseYear,
			String goalYear, String step) {
		this.username = username;
		this.id = id;
		this.name = name;
		this.watershedId = watershedId;
		this.createTime = createTime.toString();
		this.describe = describe;
		this.baseYear = baseYear;
		this.goalYear = goalYear;
		this.step = step;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWatershedId() {
		return watershedId;
	}

	public void setWatershedId(String watershedId) {
		this.watershedId = watershedId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getBaseYear() {
		return baseYear;
	}

	public void setBaseYear(String baseYear) {
		this.baseYear = baseYear;
	}

	public String getGoalYear() {
		return goalYear;
	}

	public void setGoalYear(String goalYear) {
		this.goalYear = goalYear;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "Project [username=" + username + ", id=" + id + ", name=" + name + ", watershedId=" + watershedId
				+ ", createtime=" + createTime + ", describe=" + describe + ", baseYear=" + baseYear + ", goalYear="
				+ goalYear + ", step=" + step + "]";
	}
	
}
