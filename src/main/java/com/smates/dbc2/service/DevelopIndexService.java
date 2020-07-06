package com.smates.dbc2.service;

public interface DevelopIndexService {
		
	/**
	 * 保存发展指标
	 * @param aQ 
	 * @param eQ
	 * @param mGWD
	 * @param gDP
	 * @param iAGDP
	 * @param mIA
	 * @param pop
	 * @param dFA
	 * @param dLA
	 * @param year
	 */
	public void addDevelopIndex(int oid, String countyname, float aQ, float eQ, float mGWD, float gDP, float iAGDP, float mIA,
			float pop, float dFA, float dLA, int year);
	
	/**
	 * 删除发展指标
	 */
	public void updateDevelopIndex();
	
	
}
