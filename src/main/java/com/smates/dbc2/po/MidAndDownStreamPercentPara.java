package com.smates.dbc2.po;

/**
 * 水资源管理，中下游水分配
 * @author baijw
 *
 */
public class MidAndDownStreamPercentPara {

	private String projectId;
	private String watershedId;
	private double serfaceWater;
	private double midstreamPercent;
	private double downstreamPercent;
	
	public MidAndDownStreamPercentPara() {
		super();
	}

	public MidAndDownStreamPercentPara(String projectId, String watershedId, double serfaceWater,
			double midstreamPercent, double downstreamPercent) {
		this.projectId = projectId;
		this.watershedId = watershedId;
		this.serfaceWater = serfaceWater;
		this.midstreamPercent = midstreamPercent;
		this.downstreamPercent = downstreamPercent;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getWatershedId() {
		return watershedId;
	}

	public void setWatershedId(String watershedId) {
		this.watershedId = watershedId;
	}

	public double getSerfaceWater() {
		return serfaceWater;
	}

	public void setSerfaceWater(double serfaceWater) {
		this.serfaceWater = serfaceWater;
	}

	public double getMidstreamPercent() {
		return midstreamPercent;
	}

	public void setMidstreamPercent(double midstreamPercent) {
		this.midstreamPercent = midstreamPercent;
	}

	public double getDownstreamPercent() {
		return downstreamPercent;
	}

	public void setDownstreamPercent(double downstreamPercent) {
		this.downstreamPercent = downstreamPercent;
	}

	@Override
	public String toString() {
		return "MidAndDownStreamPercentPara [projectId=" + projectId + ", watershedId=" + watershedId
				+ ", serfaceWater=" + serfaceWater + ", midstreamPercent=" + midstreamPercent + ", downstreamPercent="
				+ downstreamPercent + "]";
	}
	
	

}
