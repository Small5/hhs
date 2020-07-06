package com.smates.dbc2.model;

/**
 * @class 
 * @brief 土地消耗率与人口增长率的比率  
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  土地消耗率与人口增长率的比率 = 土地消耗率/人口增长率
 */
public class ModelLandPopuRate {

	public ModelLandPopuRate(){
		
	}
	
	/**
	 * 
	 * @param landConsumptionRate	double	土地消耗率
	 * @param popuGrowthRate	double	人口增长率
	 * @return rate	double	 土地消耗率与人口增长率的比率
	 * @exception 
     * @note
     *     土地消耗率与人口增长率的比率 = 土地消耗率/人口增长率
	 */
	public double calc( double landConsumptionRate, double popuGrowthRate ){

		double rate = 0;
		if(popuGrowthRate!=0)
			rate = landConsumptionRate/popuGrowthRate;
		return rate;
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
