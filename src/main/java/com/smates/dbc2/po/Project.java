package com.smates.dbc2.po;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 项目po
 * 
 * @author baijw
 *
 */
public class Project {
	
	private String username;
	private String id;
	private String name;
	private String watershedId;
	private String createTime;
	private String describe;
	private String baseYear;
	private String goalYear;
	private String step;
//	Date currentTime = new Date();
//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	String dateString = formatter.format(currentTime);

	public Project() {
	}

	public Project(String username,String name, String watershedId, Date createTime, String describe, String baseYear,
			String goalYear, String step) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(createTime);
		this.username = username;
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.watershedId = watershedId;
		this.createTime = dateString;
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
