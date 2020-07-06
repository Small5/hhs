package com.smates.dbc2.po;

/**
 * 气候情景参数
 * 
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 上午10:31:13
 */
public class TblClimateScePara extends BaseClass{

	private String projectId;
	private String countyId;
	private String PreChangeR;
	private String TempChange;

	public TblClimateScePara() {
	}

	public TblClimateScePara(String projectId, String countyId, String PreChangeR, String TempChange) {
		this.projectId = projectId;
		this.countyId = countyId;
		this.PreChangeR = PreChangeR;
		this.TempChange = TempChange;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getPreChangeR() {
		return PreChangeR;
	}

	public void setPreChangeR(String preChangeR) {
		PreChangeR = preChangeR;
	}

	public String getTempChange() {
		return TempChange;
	}

	public void setTempChange(String tempChange) {
		TempChange = tempChange;
	}

	@Override
	public String toString() {
		return "TblClimateScePara [projectId=" + projectId + ", countyId=" + countyId + ", PreChangeR=" + PreChangeR
				+ ", TempChange=" + TempChange + "]";
	}
}
