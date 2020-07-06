package com.smates.dbc2.model;

/**
 * @class 
 * @brief 计算水压力 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  WPr = Qtot/Qsr  
 *  其中，WPr水压力，
 *    Qtot为用水量=工业需水量+农业需水量+服务业需水量
 *    Qsr淡水总量=地表径流量
 */
public class ModelWaterPressure {

	public ModelWaterPressure(){
		
	}
	
	/**
	 * 
	 * @param waterUseAgr	double	工业需水量
	 * @param waterUseInd	double	农业需水量
	 * @param waterUseSer	double	服务业需水量
     # @param surfaceRunoff double  地表径流量
	 * @return waterPressure	double	 水压力
	 * @exception 
     * @note
     *     水压力 = (工业需水量+农业需水量+服务业需水量)/地表径流量
	 */
	public double calc( double waterUseAgr, double waterUseInd, double waterUseSer,
                        double surfaceRunoff ){

		double wpr = 0;
		if(surfaceRunoff!=0)
			wpr = (waterUseAgr + waterUseInd + waterUseSer)/surfaceRunoff;
		return wpr;
	}
	

	/** @brief brief description  */
	public void init(){
	}
//	
//	public static void main(String[] args){
//		
//		System.out.println(calc(1,1,1, 2));
//	}
}
