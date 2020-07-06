package com.smates.dbc2.po;

public class UpStream {

	private String projectID;
	private String modelName;
	private String functionTxt;
	
	public UpStream() {
		
	}
	
	public UpStream(String projectID,String modelName,String functionTxt) {
		this.projectID = projectID;
		this.modelName = modelName;
		this.functionTxt = functionTxt;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getFunctionTxt() {
		return functionTxt;
	}

	public void setFunctionTxt(String functionTxt) {
		this.functionTxt = functionTxt;
	}
}
