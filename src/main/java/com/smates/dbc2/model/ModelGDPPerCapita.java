package com.smates.dbc2.model;

/**
 * @class 
 * @brief 人均GDP 
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  人均GDP=GDP/人口
 */
public class ModelGDPPerCapita {

	public ModelGDPPerCapita(){
		
	}
	
	/**
	 * 
	 * @param gdp	double	GDP
	 * @param population	double	人口
	 * @return gdppc	double	 人均GDP
	 * @exception 
     * @note
     *     人均GDP=GDP/人口
	 */
	public double calc( double gdp, double population ){

		double gdppc = 0;
		if(population!=0)
			gdppc = gdp/population;
		return gdppc;
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
