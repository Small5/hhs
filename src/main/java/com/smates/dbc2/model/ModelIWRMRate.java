package com.smates.dbc2.model;

/**
 * @class 
 * @brief 集成水资源管理效率 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  集成水资源管理效率=集成水资源管理影响的面积/流域面积
 */
public class ModelIWRMRate {

	public ModelIWRMRate(){
		
	}
	
	/**
	 * 
	 * @param areaIWRM	double	集成水资源管理影响的面积
	 * @param areaWatershed	double	流域面积
	 * @return rate	double	 集成水资源管理效率
	 * @exception 
     * @note
     *     集成水资源管理效率=集成水资源管理影响的面积/流域面积
	 */
	public double calc( double areaIWRM, double areaWatershed ){

		double rate = 0;
		if(areaWatershed!=0)
			rate = areaIWRM/areaWatershed;
		return rate;
	}
	

	/** @brief brief description  */
	public void init(){
	}

//	public static void main(String[] args){
//	
//		System.out.println(calc(4, 2));
//	}
}
