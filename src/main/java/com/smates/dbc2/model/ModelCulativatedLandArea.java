package com.smates.dbc2.model;

/**
 * @class 
 * @brief 耕地面积 
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  耕地面积=产量/亩产
 */
public class ModelCulativatedLandArea {

	public ModelCulativatedLandArea(){
		
	}
	
	/**
	 * 
	 * @param output	double	产量
	 * @param outputPerMu	double	亩产
	 * @return acl	double	 耕地面积
	 * @exception 
     * @note
     *     耕地面积=产量/亩产
	 */
	public double calc( double output, double outputPerMu ){

		double acl = 0;
		if(outputPerMu!=0)
			acl = output/outputPerMu;
		return acl;
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
