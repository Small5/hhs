package com.smates.dbc2.model;

/**
 * @class 
 * @brief 就业人口人均GDP 
 * @author Bob, Ge Yingchun
 * @version 1.0
 * @date 2016.10.8
 * @note
 *  就业人口人均GDP=（GDP-农业产值）/就业人口数量
 */
public class ModelGDPPerPersonEmployed {

	public ModelGDPPerPersonEmployed(){
		
	}
	
	/**
	 * 
	 * @param gdp	double	GDP，元
	 * @param outputAgr	double	农业产值，元
	 * @param populationEmployed	double	就业人口数量
	 * @return gdpppe	double	 就业人口人均GDP，元
	 * @exception 
     * @note
     *     就业人口人均GDP=（GDP-农业产值）/就业人口数量
	 */
	public double calc( double gdp, double outputAgr, double populationEmployed ){

		double gdpppe = 0;
		if(populationEmployed!=0)
			gdpppe = (gdp - outputAgr)/populationEmployed;
		return gdpppe;
	}
	

	/** @brief brief description  */
	public void init(){
	}
//	
//	public static void main(String[] args){
//		
//		System.out.println(calc(8, 4, 2));
//	}
}
