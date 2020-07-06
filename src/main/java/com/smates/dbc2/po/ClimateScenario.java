package com.smates.dbc2.po;

public class ClimateScenario {
	String username;//用户名
	String fldYear;//年份
	String WaterShedCode;//流域ID
	String fldCountyCode;//县区
	
	String UpRainUpper;//上游降水变化率上限，%/10年
	String UpRainULower;//上游降水变化率下限，%/10年
	String MidRainUpper;//中游降水变化率上限，%/10年
	String MidRainLower;//中游降水变化率下限，%/10年
	String DownRainUpper;//下游降水变化率上限，%/10年
	String DownRainLower;//下游降水变化率下限，%/10年
	
	String UpTempUpper;//上游升温变化率上限，%/10年
	String UpTempULower;//上游升温变化率下限，%/10年
	String MidTempUpper;//中游升温变化率上限，%/10年
	String MidTempLower;//中游升温变化率下限，%/10年
	String DownTempUpper;//下游升温变化率上限，%/10年
	String DownTempLower;//下游升温变化率下限，%/10年
	
	public ClimateScenario() {
		
	}
	
	public ClimateScenario(String username,String fldYear,String WaterShedCode,String fldCountyCode,
			String UpRainUpper,String UpRainULower,String MidRainUpper,
			String MidRainLower,String DownRainUpper,String DownRainLower,
	
			String UpTempUpper,String UpTempULower,String MidTempUpper,
			String MidTempLower,String DownTempUpper,String DownTempLower) {
		this.username = username;
		this.fldYear = fldYear;
		this.WaterShedCode = WaterShedCode;
		this.fldCountyCode = fldCountyCode;
		this.UpRainUpper = UpRainUpper;
		this.UpRainULower = UpRainULower;
		this.MidRainUpper = MidRainUpper;
		this.MidRainLower = MidRainLower;
		this.DownRainUpper =DownRainUpper;
		this.DownRainLower = DownRainLower;
		this.UpTempUpper = UpTempUpper;
		this.UpTempULower = UpTempULower;
		this.MidTempUpper = MidTempUpper;
		this.MidTempLower = MidTempLower;
		this.DownTempUpper =DownTempUpper;
		this.DownTempLower = DownTempLower;	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFldYear() {
		return fldYear;
	}

	public void setFldYear(String fldYear) {
		this.fldYear = fldYear;
	}

	public String getWaterShedCode() {
		return WaterShedCode;
	}

	public void setWaterShedCode(String waterShedCode) {
		WaterShedCode = waterShedCode;
	}

	public String getFldCountyCode() {
		return fldCountyCode;
	}

	public void setFldCountyCode(String fldCountyCode) {
		this.fldCountyCode = fldCountyCode;
	}

	public String getUpRainUpper() {
		return UpRainUpper;
	}

	public void setUpRainUpper(String upRainUpper) {
		UpRainUpper = upRainUpper;
	}

	public String getUpRainULower() {
		return UpRainULower;
	}

	public void setUpRainULower(String upRainULower) {
		UpRainULower = upRainULower;
	}

	public String getMidRainUpper() {
		return MidRainUpper;
	}

	public void setMidRainUpper(String midRainUpper) {
		MidRainUpper = midRainUpper;
	}

	public String getMidRainLower() {
		return MidRainLower;
	}

	public void setMidRainLower(String midRainLower) {
		MidRainLower = midRainLower;
	}

	public String getDownRainUpper() {
		return DownRainUpper;
	}

	public void setDownRainUpper(String downRainUpper) {
		DownRainUpper = downRainUpper;
	}

	public String getDownRainLower() {
		return DownRainLower;
	}

	public void setDownRainLower(String downRainLower) {
		DownRainLower = downRainLower;
	}

	public String getUpTempUpper() {
		return UpTempUpper;
	}

	public void setUpTempUpper(String upTempUpper) {
		UpTempUpper = upTempUpper;
	}

	public String getUpTempULower() {
		return UpTempULower;
	}

	public void setUpTempULower(String upTempULower) {
		UpTempULower = upTempULower;
	}

	public String getMidTempUpper() {
		return MidTempUpper;
	}

	public void setMidTempUpper(String midTempUpper) {
		MidTempUpper = midTempUpper;
	}

	public String getMidTempLower() {
		return MidTempLower;
	}

	public void setMidTempLower(String midTempLower) {
		MidTempLower = midTempLower;
	}

	public String getDownTempUpper() {
		return DownTempUpper;
	}

	public void setDownTempUpper(String downTempUpper) {
		DownTempUpper = downTempUpper;
	}

	public String getDownTempLower() {
		return DownTempLower;
	}

	public void setDownTempLower(String downTempLower) {
		DownTempLower = downTempLower;
	}
	
}
