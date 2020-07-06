package com.smates.dbc2.model;

/**
 * @class 
 * @brief 社会安全饮用水比例 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  Rsd = POPs/POP  
 *  其中，Rsd 社会安全饮用水比例，
 *        POPs：饮用卫生达标水的人口数量
 *        Pop：区域总人口数量
 */
public class ModelSafeDrinkingWaterRate {

	public ModelSafeDrinkingWaterRate(){
		
	}
	
	/**
	 * 
	 * @param pops	long	饮用卫生达标水的人口数量
	 * @param pop	long	区域总人口数量
	 * @return rsd	double	 社会安全饮用水比例，
	 * @exception 
     * @note
     *     社会安全饮用水比例 = 饮用卫生达标水的人口数量/区域总人口数量
	 */
	public double calc( long pops, long pop){

		double rsd = 0;
		if(pop!=0)
			rsd = pops/pop;
		return rsd;
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
