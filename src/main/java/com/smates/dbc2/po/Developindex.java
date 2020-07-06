package com.smates.dbc2.po;

import java.text.DecimalFormat;

/**
 * 发展指标po
 * 
 * @author baijw
 *
 */
public class Developindex {

	private int oid;
	private String countyname;
	private double AQ;
	private double EQ;
	private double MGWD;
	private double GDP;
	private double IAGDP;
	private double MIA;
	private double Pop;
	private double DFA;
	private double DLA;
	private int year;
	DecimalFormat df = new DecimalFormat("0.0");
	public Developindex() {
		super();
	}

	public Developindex(int oid, String countyname, double aQ, double eQ, double mGWD, double gDP, double iAGDP, double mIA,
			double pop, double dFA, double dLA, int year) {
		super();
		
		this.oid = oid;
		this.countyname = countyname;
		AQ = Double.parseDouble(df.format(aQ));
		EQ = Double.parseDouble(df.format(eQ));
		MGWD = Double.parseDouble(df.format(mGWD));
		GDP = Double.parseDouble(df.format(gDP));
		IAGDP = Double.parseDouble(df.format(iAGDP));
		MIA = Double.parseDouble(df.format(mIA));
		Pop = Double.parseDouble(df.format(pop));
		DFA = Double.parseDouble(df.format(dFA));
		DLA = Double.parseDouble(df.format(dLA));
		this.year = year;
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

	public double getAQ() {
		return AQ;
	}

	public void setAQ(double aQ) {
		AQ = Double.parseDouble(df.format(aQ));
	}

	public double getEQ() {
		return EQ;
	}

	public void setEQ(double eQ) {
		EQ = Double.parseDouble(df.format(eQ));
	}

	public double getMGWD() {
		return MGWD;
	}

	public void setMGWD(double mGWD) {
		MGWD = Double.parseDouble(df.format(mGWD));
	}

	public double getGDP() {
		return GDP;
	}

	public void setGDP(double gDP) {
		GDP = Double.parseDouble(df.format(gDP));
	}

	public double getIAGDP() {
		return IAGDP;
	}

	public void setIAGDP(double iAGDP) {
		IAGDP = Double.parseDouble(df.format(iAGDP));
	}

	public double getMIA() {
		return MIA;
	}

	public void setMIA(double mIA) {
		MIA = Double.parseDouble(df.format(mIA));
	}

	public double getPop() {
		return Pop;
	}

	public void setPop(double pop) {
		Pop = Double.parseDouble(df.format(pop));
	}

	public double getDFA() {
		return DFA;
	}

	public void setDFA(double dFA) {
		DFA = Double.parseDouble(df.format(dFA));
	}

	public double getDLA() {
		return DLA;
	}

	public void setDLA(double dLA) {
		DLA = Double.parseDouble(df.format(dLA));
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
