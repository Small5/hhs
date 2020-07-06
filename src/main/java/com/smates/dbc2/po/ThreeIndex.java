package com.smates.dbc2.po;

import java.text.DecimalFormat;

/**
 * GIS上的三个指标
 * @author baijw
 *
 */
public class ThreeIndex {

	private int oid;
	private String countyname;
	private int time;
	private double socialeconomy;
	private double ecology;
	private double water;
	DecimalFormat df = new DecimalFormat("0.0");
	public ThreeIndex() {
		super();
	}
	public ThreeIndex(int oid, String countyname, int time, double socialeconomy, double ecology, double water) {
		super();
		this.oid = oid;
		this.countyname = countyname;
		this.time = time;
		this.socialeconomy = Double.parseDouble(df.format(socialeconomy));
		this.ecology = Double.parseDouble(df.format(ecology));
		this.water = Double.parseDouble(df.format(water));
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getCountyname() {
		return countyname;
	}
	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public double getSocialeconomy() {
		return socialeconomy;
	}
	public void setSocialeconomy(double socialeconomy) {
		this.socialeconomy = Double.parseDouble(df.format(socialeconomy));
	}
	public double getEcology() {
		return ecology;
	}
	public void setEcology(double ecology) {
		this.ecology = Double.parseDouble(df.format(ecology));
	}
	public double getWater() {
		return water;
	}
	public void setWater(double water) {
		this.water = Double.parseDouble(df.format(water));
	}
	
}