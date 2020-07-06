package com.smates.dbc2.po;

public class SocEcoPara {
	private String projectId;
	private String countyId;
	private String popolicy;
	private String IARArg;
	private String IARInd;
	private String IARSer;
	private String negak;
	
	public SocEcoPara() {
		
	}
	
	public SocEcoPara(String projectId,String countyId, String popolicy,String IARArg,String IARInd,String IARSer,String negak) {
		this.projectId = projectId;
		this.countyId = countyId;
		this.popolicy = popolicy;
		this.IARArg = IARArg;
		this.IARInd = IARInd;
		this.IARSer = IARSer;
		this.negak = negak;
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

	public String getPopolicy() {
		return popolicy;
	}

	public void setPopolicy(String popolicy) {
		this.popolicy = popolicy;
	}

	public String getIARArg() {
		return IARArg;
	}

	public void setIARArg(String iARArg) {
		IARArg = iARArg;
	}

	public String getIARInd() {
		return IARInd;
	}

	public void setIARInd(String iARInd) {
		IARInd = iARInd;
	}

	public String getIARSer() {
		return IARSer;
	}

	public void setIARSer(String iARSer) {
		IARSer = iARSer;
	}

	public String getNegak() {
		return negak;
	}

	public void setNegak(String negak) {
		this.negak = negak;
	}

	@Override
	public String toString() {
		return "SocEcoPara [projectId=" + projectId + ", countyId=" + countyId + ", popolicy=" + popolicy + ", IARArg="
				+ IARArg + ", IARInd=" + IARInd + ", IARSer=" + IARSer + "]";
	}

}
