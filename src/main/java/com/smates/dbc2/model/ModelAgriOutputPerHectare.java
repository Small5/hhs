package com.smates.dbc2.model;

/**
 * @class 
 * @brief 每公顷农产品产值   
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  每公顷农产品产值  = 农产品总值/农产品总种植面积
 */

/*test*/

public class ModelAgriOutputPerHectare {

	public ModelAgriOutputPerHectare(){
		
	}
	
	/**
	 * 
	 * @param outputAgr	double	农产品总值 元
	 * @param areaAgr	double	农产品总种植面积 平方千米
	 * @return op	double	 每公顷农产品产值 
	 * @exception 
     * @note
     *     每公顷农产品产值 = 农产品总值/农产品总种植面积
	 */
	public double calc( double outputAgr, double areaAgr ){
        ////1平方千米＝100公顷;   1公顷＝0.01平方千米
		double op = 0;
		if(areaAgr!=0)
			op = outputAgr/areaAgr*0.01;
		return op;
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
