package com.smates.dbc2.model;

/**
 * @class 
 * @brief 农业水生产力 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  WPa = Ya/Qa  
 *  其中，WPa 农业水生产力，
 *    Ya为农业总产值
 *    Qa为农业总用水量
 */
public class ModelWaterProductivityAgri {

	public ModelWaterProductivityAgri(){
		
	}
	
	/**
	 * 
	 * @param outputAgr	double	农业总产值， 元
	 * @param waterUseAgr	double	农业总用水量，m3
	 * @return waterProductivityAgri	double	 农业水生产力
	 * @exception 
     * @note
     *     农业水生产力 = 农业总产值/农业总用水量
	 */
	public double calc( double outputAgr, double waterUseAgr){

		double wpa = 0;
		if(waterUseAgr!=0)
			wpa = outputAgr/waterUseAgr;
		return wpa;
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
