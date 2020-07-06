package com.smates.dbc2.model;

/**
 * @class 
 * @brief 山地绿色覆盖指数 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.17
 * @note
 *  山地绿色覆盖指数 = 山地绿色覆盖面积/山区总面积
 */
public class ModelMountainGreenCoverageRate {

	public ModelMountainGreenCoverageRate(){
		
	}
	
	/**
	 * 
	 * @param areaGreen	double	山地绿色覆盖面积
	 * @param areaTotal	double	山区总面积
	 * @return gcr	double	 山地绿色覆盖指数
	 * @exception 
     * @note
     *     山地绿色覆盖指数 = 山地绿色覆盖面积/山区总面积
	 */
	public double calc( double areaGreen, double areaTotal ){

		double gcr = 0;
		if(areaTotal!=0)
			gcr = areaGreen/areaTotal;
		return gcr;
	}
	

	/** @brief brief description  */
	public void init(){
	}
//	
//	public static void main(String[] args){
//		
//		System.out.println(calc(4,2));
//	}
}
