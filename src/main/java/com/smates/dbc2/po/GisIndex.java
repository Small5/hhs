package com.smates.dbc2.po;

/**
 * Gis中左下角的图数据
 * 
 * @author baijw
 *
 */
public class GisIndex {

	private int oid;
	private String countyname;
	private String indextype;
	private int year;
	private int value;

	public GisIndex() {
		super();
	}

	public GisIndex(int oid, String countyname, String indextype, int year, int value) {
		super();
		this.oid = oid;
		this.countyname = countyname;
		this.indextype = indextype;
		this.year = year;
		this.value = value;
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

	public String getIndextype() {
		return indextype;
	}

	public void setIndextype(String indextype) {
		this.indextype = indextype;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
