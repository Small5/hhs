package com.smates.dbc2.model;

/**
 * @class 
 * @brief 年轻人失业率  
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  年轻人失业率 = 年轻人失业人口数/年轻人总数量
 */
public class ModelYouthUnempRate {

	public ModelYouthUnempRate(){
		
	}
	
	/**
	 * 
	 * @param popYoungUnemp	double	年轻人失业人口数
	 * @param popYoung	double	年轻人总数量
	 * @return rate	double	 年轻人失业率
	 * @exception 
     * @note
     *     年轻人失业率 = 年轻人失业人口数 / 年轻人总数量
	 */
	public double calc( double popYoungUnemp, double popYoung ){

		double rate = 0;
		if(popYoung!=0)
			rate = popYoungUnemp/popYoung;
		return rate;
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
