package com.smates.dbc2.model;

/**
 * @class 
 * @brief 计算水生产力 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  Wpa = Ya / Qtot
 *  其中，Ya为流域总产值，元；Qtot为流域总用水量，m3.
 *    Ya=工业产值+农业产值+服务业产值
 *    Qtot=工业需水量+农业需水量+服务业需水量
 *
 */
public class ModelWaterProductivity {

	public ModelWaterProductivity(){
		
	}
	
	/**
	 * 
	 * @param outputInd	double	工业产值
	 * @param outputAgr	double	农业产值
	 * @param outputSer	double	服务业产值
	 * @param waterUseInd	double	工业需水量 
	 * @param waterUseAgr	double	农业需水量
	 * @param waterUseSer	double	服务业需水量
	 * @return waterProductivity	double	 水生产力
	 * @exception 
     * @note
     *     水生产力 = (工业产值+农业产值+服务业产值)/(工业需水量+农业需水量+服务业需水量)
	 */
	public double calc(double outputInd, double outputAgr, double outputSer, 
			           double waterUseInd, double waterUseAgr, double waterUseSer){

		double wpa = 0;
		double qtot = waterUseAgr + waterUseInd + waterUseSer;
		if(qtot!=0)
			wpa = (outputInd + outputAgr + outputSer)/qtot;
		return wpa;
	}
	

	/** @brief brief description  */
	public void init(){
	}
//	
//	public static void main(String[] args){
//		
//		System.out.println(calc(2,2,2,1,1,1));
//	}
}
