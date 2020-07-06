package com.smates.dbc2.po;

public class IndicatorInfo {
	String index;
	String indiVariable;
	String indiName;
	String direction;
	String functionTxt;
	String goal;
	Boolean need;
	public IndicatorInfo() {}
	public Boolean getNeed() {
		return need;
	}
	public void setNeed(Boolean need) {
		this.need = need;
	}
	public IndicatorInfo(String index, String indiVariable, String indiName, String direction, String functionTxt,
			String goal) {
		super();
		this.index = index;
		this.indiVariable = indiVariable;
		this.indiName = indiName;
		this.direction = direction;
		this.functionTxt = functionTxt;
		this.goal = goal;
		this.need=false;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getIndiVariable() {
		return indiVariable;
	}
	public void setIndiVariable(String indiVariable) {
		this.indiVariable = indiVariable;
	}
	public String getIndiName() {
		return indiName;
	}
	public void setIndiName(String indiName) {
		this.indiName = indiName;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getFunctionTxt() {
		return functionTxt;
	}
	public void setFunctionTxt(String functionTxt) {
		this.functionTxt = functionTxt;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	
}
