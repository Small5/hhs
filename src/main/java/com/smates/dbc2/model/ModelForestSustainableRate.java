package com.smates.dbc2.model;

/**
 * @class 
 * @brief 可持续森林管理覆盖 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  Rsf = Asf/Af  
 *  其中，Asf为执行森林管理规划的森林总面积，
 *    Af为森林总面积
 *    Rsf可持续森林管理覆盖
 */
public class ModelForestSustainableRate {

	public ModelForestSustainableRate(){
		
	}
	
	/**
	 * 
	 * @param areaSustainableForest	double	执行森林管理规划的森林总面积，m3
	 * @param areaForest	double	森林总面积，m3
	 * @return rateSustainableForest	double	 可持续森林管理覆盖
	 * @exception 
     * @note
     *     可持续森林管理覆盖 = 执行森林管理规划的森林总面积/森林总面积
	 */
	public double calc( double areaSustainableForest, double areaForest ){

		double rsf = 0;
		if(areaForest!=0)
			rsf = areaSustainableForest/areaForest;
		return rsf;
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
