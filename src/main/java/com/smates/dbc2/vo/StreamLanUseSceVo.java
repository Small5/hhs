package com.smates.dbc2.vo;

/**
 * 分流域的土地利用参数
 * 
 * @author baijw
 *
 */
public class StreamLanUseSceVo {

	private String countryId;
	private String countryName;
	private String stream;
	private String fldFarmArea;
	private String WetlandArea;

	public StreamLanUseSceVo() {
		super();
	}

	public StreamLanUseSceVo(String countryId, String countryName, String stream, String fldFarmArea,
			String wetlandArea) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.stream = stream;
		this.fldFarmArea = fldFarmArea;
		WetlandArea = wetlandArea;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getFldFarmArea() {
		return fldFarmArea;
	}

	public void setFldFarmArea(String fldFarmArea) {
		this.fldFarmArea = fldFarmArea;
	}

	public String getWetlandArea() {
		return WetlandArea;
	}

	public void setWetlandArea(String wetlandArea) {
		WetlandArea = wetlandArea;
	}

}
