package com.smates.dbc2.model;

/**
 * @class 
 * @brief 年轻人就业率  
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  年轻人就业率 = 年轻人在教育、就业和培训中的人口数/年轻人总数量
 */
public class ModelYouthEmpRate {

	public ModelYouthEmpRate(){
		
	}
	
	/**
	 * 
	 * @param popEmployment	double	年轻人在教育、就业和培训中的人口数
	 * @param popYoung	double	年轻人总数量
	 * @return rate	double	 年轻人就业率
	 * @exception 
     * @note
     *     年轻人就业率 = 年轻人在教育、就业和培训中的人口数 / 年轻人总数量
	 */
	public double calc( double popEmployment, double popYoung ){

		double rate = 0;
		if(popYoung!=0)
			rate = popEmployment/popYoung;
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
