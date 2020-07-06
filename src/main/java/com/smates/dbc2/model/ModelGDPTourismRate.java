package com.smates.dbc2.model;

/**
 * @class 
 * @brief 旅游业在GDP中的比例 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  旅游业GDP比例=旅游业产值/GDP
 */
public class ModelGDPTourismRate {

	public ModelGDPTourismRate(){
		
	}
	
	/**
	 * 
	 * @param outputTourism	double	旅游业产值
	 * @param gdp	double	GDP
	 * @return rt	double	 旅游业GDP比例
	 * @exception 
     * @note
     *     旅游业GDP比例 = 旅游业产值/GDP
	 */
	public double calc( double outputTourism, double gdp ){

		double rt = 0;
		if(gdp!=0)
			rt = outputTourism/gdp;
		return rt;
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
