package com.smates.dbc2.model;

/**
 * @class 
 * @brief 旅游消费  
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  旅游消费 = 旅游部门中工作职位数量 / 区域绿色和体面的工作职位数量
 */
public class ModelTourConsRate {

	public ModelTourConsRate(){
		
	}
	
	/**
	 * 
	 * @param amountJobTour	double	旅游部门中工作职位数量
	 * @param amountJob	double	区域绿色和体面的工作职位数量
	 * @return tcr	double	 旅游消费
	 * @exception 
     * @note
     *     旅游消费 = 旅游部门中工作职位数量 / 区域绿色和体面的工作职位数量
	 */
	public double calc( double amountJobTour, double amountJob ){

		double tcr = 0;
		if(amountJob!=0)
			tcr = amountJobTour/amountJob;
		return tcr;
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
