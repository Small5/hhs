package com.smates.dbc2.po;

public class EcoPara {
	String IARArg;
	String IARInd;
	String IARSer;
	String countyId;
	String popolicy;
	String negak;
	public EcoPara(String iARArg, String iARInd, String iARSer, String countyId, String popolicy, String negak) {
		super();
		IARArg = iARArg;
		IARInd = iARInd;
		IARSer = iARSer;
		this.countyId = countyId;
		this.popolicy = popolicy;
		this.negak = negak;
	}

	public String getPopolicy() {
		return popolicy;
	}

	public void setPopolicy(String popolicy) {
		this.popolicy = popolicy;
	}

	public String getNegak() {
		return negak;
	}

	public void setNegak(String negak) {
		this.negak = negak;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	
	public EcoPara() {}
	
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
	public String getCountyId() {
		return countyId;
	}
	
	

}
