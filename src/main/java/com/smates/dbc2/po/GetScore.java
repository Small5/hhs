package com.smates.dbc2.po;

public class GetScore {

	private String countyId;
	private String year;
	private String totalscore;
	
	public GetScore() {
		
	}
	public GetScore(String countyId,String year,String totalscore) {
		this.countyId = countyId;
		this.year = year;
		this.totalscore = totalscore;
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
	
}
