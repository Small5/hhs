package com.smates.dbc2.model;

/**
 * @class 
 * @brief 地下水开采量 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.17
 * @note
 *  地下水开采量 = 总需水量-地表水用水量
 */
public class ModelGroundwaterMiningAmount {

	public ModelGroundwaterMiningAmount(){
		
	}
	
	/**
	 * 
	 * @param waterUse	double	总需水量， m3
	 * @param waterSurface	double	地表水用水量， m3
	 * @return waterGround	double	 地下水开采量， m3
	 * @exception 
     * @note
     *     地下水开采量 = 总需水量-地表水用水量
	 */
	public double calc( double waterUse, double waterSurface ){

		double waterGround = 0;
		if(waterSurface!=0)
			waterGround = waterUse/waterSurface;
		return waterGround;
	}
	

	/** @brief brief description  */
	public void init(){
	}
	
//	public static void main(String[] args){
//		
//		System.out.println(calc(4,2));
//	}
}
