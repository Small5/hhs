package com.smates.dbc2.po;

public class GoalsIDAndProjectID {

	private String goalsId;
	private String projectId;

	public GoalsIDAndProjectID() {
	}

	public GoalsIDAndProjectID(String goalsId, String projectId) {
		this.goalsId = goalsId;
		this.projectId = projectId;
	}

	public String getGoalsId() {
		return goalsId;
	}

	public void setGoalsId(String goalsId) {
		this.goalsId = goalsId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
