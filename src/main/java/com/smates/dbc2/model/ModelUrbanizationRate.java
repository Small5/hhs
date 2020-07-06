package com.smates.dbc2.model;

/**
 * @class 
 * @brief 城镇化率 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  城镇化率=城镇化人口/人口总数
 */
public class ModelUrbanizationRate {

	public ModelUrbanizationRate(){
		
	}
	
	/**
	 * 
	 * @param pu	double	城镇化人口
	 * @param pt	double	人口总数
	 * @return ur	double	 城镇化率
	 * @exception 
     * @note
     *     城镇化率=城镇化人口/人口总数
	 */
	public double calc( double pu, double pt ){

		double ur = 0;
		if(pt!=0)
			ur = pu/pt;
		return ur;
	}
	

	/** @brief brief description  */
	public void init(){
	}
//	
//	public static void main(String[] args){
//		
//		System.out.println(calc(4, 2));
//	}
}
