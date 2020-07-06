package com.smates.dbc2.po;

public class AssessResult {
	String projectId;
	String countyId;
	String year;
	String totalscore;
	String goal1score;
	String goal2score;
	String goal3score;
	String totalindex;
	String goal1index;
	String goal2index;
	String goal3index;
	public String getTotalindex() {
		return totalindex;
	}
	public void setTotalindex(String totalindex) {
		this.totalindex = totalindex;
	}
	public String getGoal1index() {
		return goal1index;
	}
	public void setGoal1index(String goal1index) {
		this.goal1index = goal1index;
	}
	public String getGoal2index() {
		return goal2index;
	}
	public void setGoal2index(String goal2index) {
		this.goal2index = goal2index;
	}
	public String getGoal3index() {
		return goal3index;
	}
	public void setGoal3index(String goal3index) {
		this.goal3index = goal3index;
	}
	
	public AssessResult() {}
	public AssessResult(String projectId, String countyId, String year, String totalscore, String goal1score,
			String goal2score, String goal3score,String totalindex,String goal1index,String goal2index,String goal3index) {
		super();
		this.projectId = projectId;
		this.countyId = countyId;
		this.year = year;
		this.totalscore = totalscore;
		this.goal1score = goal1score;
		this.goal2score = goal2score;
		this.goal3score = goal3score;
		this.totalindex=totalindex;
		this.goal1index=goal1index;
		this.goal2index=goal2index;
		this.goal3index=goal3index;
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
