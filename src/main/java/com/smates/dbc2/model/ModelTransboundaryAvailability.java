package com.smates.dbc2.model;

/**
 * @class 
 * @brief 跨边界流域可操作合约有效性
 * @author Bob, Ge Yingchun
 * @version 
 * @date 
 * @note
 *  跨边界流域可操作合约有效性=合约影响到的流域地表与地下水面积/流域总面积
 */
public class ModelTransboundaryAvailability {

	public ModelTransboundaryAvailability(){
		
	}
	
	/**
	 * 
	 * @param areaTransboundary	double	合约影响到的流域地表与地下水面积
	 * @param areaWatershed	double	流域总面积
	 * @return ta	double	 跨边界流域可操作合约有效性
	 * @exception 
     * @note
     *     跨边界流域可操作合约有效性=合约影响到的流域地表与地下水面积/流域总面积
	 */
	public double calc( double areaTransboundary, double areaWatershed ){

		double ta = 0;
		if(areaWatershed!=0)
			ta = areaTransboundary/areaWatershed;
		return ta;
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
