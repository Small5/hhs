package com.smates.dbc2.model;

/**
 * @class 
 * @brief  森林覆盖率
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  Rfc = Af/Aw  
 *  其中，Rfc为森林覆盖率，
 *    Af为森林覆盖面积
 *    Aw为流域面积
 */
public class ModelForestCoverageRate {

	public ModelForestCoverageRate(){
		
	}
	
	/**
	 * 
	 * @param areaForest	double	森林覆盖面积，m3
	 * @param areaWatershed	double	流域面积，m3
	 * @return rateForestCoverage	double	 森林覆盖率
	 * @exception 
     * @note
     *     森林覆盖率 = 森林覆盖面积/流域面积
	 */
	public double calc( double areaForest, double areaWatershed ){

		double rfc = 0;
		if(areaWatershed!=0)
			rfc = areaForest/areaWatershed;
		return rfc;
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
