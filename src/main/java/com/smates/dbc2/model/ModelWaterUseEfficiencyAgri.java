package com.smates.dbc2.model;

/**
 * @class 
 * @brief 农业水利用效率 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  WuE = Ea/Qa  
 *  其中，WuE 为农业水利用效率，
 *    Ea为作物总蒸腾量，m3
 *    Qa为农业总用水量，m3
 */
public class ModelWaterUseEfficiencyAgri {

	public ModelWaterUseEfficiencyAgri(){
		
	}
	
	/**
	 * 
	 * @param et	double	作物总蒸腾量，m3
	 * @param qa	double	农业总用水量，m3
	 * @return wue	double	 农业水利用效率
	 * @exception 
     * @note
     *     农业水利用效率 = 作物总蒸腾量/农业总用水量
	 */
	public double calc( double et, double qt){

		double wue = 0;
		if(qt!=0)
			wue = et/qt;
		return wue;
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
