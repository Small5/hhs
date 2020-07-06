package com.smates.dbc2.po;

/**
 * gis评价结果的图表
 * 
 * @author machao
 *
 */
public class Gisecharts {
	private String projectId;
	private String countyId;
	private String year;
	private String totalscore;
	private String goal1score;
	private String goal2score;
	private String goal3score;

	public Gisecharts() {
	}

	public Gisecharts(String projectId,String countyId,String year,String totalscore,String goal1score,String goal2score,String goal3score) {
		super();
		this.projectId = projectId;
		this.countyId = countyId;
		this.year = year;
		this.totalscore = totalscore;
		this.goal1score =goal1score;
		this.goal2score = goal2score;
		this.goal3score = goal3score;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTotalscore() {
		return totalscore;
	}

	public void setTotalscore(String totalscore) {
		this.totalscore = totalscore;
	}

	public String getGoal1score() {
		return goal1score;
	}

	public void setGoal1score(String goal1score) {
		this.goal1score = goal1score;
	}

	public String getGoal2score() {
		return goal2score;
	}

	public void setGoal2score(String goal2score) {
		this.goal2score = goal2score;
	}

	public String getGoal3score() {
		return goal3score;
	}

	public void setGoal3score(String goal3score) {
		this.goal3score = goal3score;
	}

	
}
