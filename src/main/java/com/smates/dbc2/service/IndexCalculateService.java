//package com.smates.dbc2.service;
//
//import java.util.List;
//
//import com.smates.dbc2.ws.DoubleArray;
//
///**
// * 指标计算
// * 
// * @author baijw
// *
// */
//public interface IndexCalculateService {
//
//	/**
//	 * 提高水生产力到b%
//	 * @return
//	 */
//	public double WaterProductivity(List<DoubleArray> modleOutput);
//
//	/**
//	 * 在各个层次上减小用水压力到m%
//	 * @return
//	 */
//	public double reduceWaterUseP(List<DoubleArray> modleOutput);
//
//	/**
//	 * 提高流域社会安全饮用水人口比例到d%
//	 */
//	public double SafeDrinkingWaterRate(List<DoubleArray> modleOutput);
//
//	/**
//	 * 集成水资源管理效率
//	 */
//	public double IWRMRate(List<DoubleArray> modleOutput);
//
//	/**
//	 * 跨边界流域可操作合约有效性e%
//	 */
//	public double TransboundaryAvailability(List<DoubleArray> modleOutput);
//
//	/**
//	 * 维持流域可持续湿地面积d万亩
//	 */
//	public double OutputWetlandArea(List<DoubleArray> modleOutput);
//
//	/**
//	 * 保证下游可持续生态系统发展所需最小水量f 亿m3
//	 */
//	public double OutputMinWater(List<DoubleArray> modleOutput);
//
//	/**
//	 * 中游地下水开采量i 亿m3
//	 * 
//	 */
//	public double OutputWaterExtraction(List<DoubleArray> modleOutput);
//
//	/**
//	 * 中游生态系统用水量j 亿m3
//	 */
//	public double OutputMidWaterUse(List<DoubleArray> modleOutput);
//
//	/**
//	 * 森林覆盖率
//	 */
//	public double ForestCoverageRate(List<DoubleArray> modleOutput);
//
//	/**
//	 * 可持续森林管理覆盖b%
//	 */
//	public double ForestSustainableRate(List<DoubleArray> modleOutput);
//
//	/**
//	 * 山地绿色覆盖指数b%
//	 */
//	public double MountainGreenCoverageRate(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 人均GDP
//	 */
//	public double GDPPerCapita(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 就业人口人均 GDP 增长率 
//	 */
//	public double GDPPerPersonEmployed(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 年轻人（15-24）在教育，就业和培训中的比例 
//	 */
//	public double YouthEmpRate(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 年轻人（15-24）失业率 
//	 */
//	public double YouthUnempRate(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 旅游业产值在 GDP 中的比例
//	 */
//	public double GDPTourismRate(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 旅游消费 
//	 */
//	public double TourConsRate(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 土地消耗率与人口增长率的比率
//	 */
//	public double LandPopuRate(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 城镇化率 
//	 */
//	public double UrbanizationRate(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 农业水生产力 
//	 */
//	public double WaterProductivityAgri(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 农业水利用效率 
//	 */
//	public double WaterUseEfficiencyAgri(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 每公顷农产品产值 
//	 */
//	public double AgriOutputPerHectare(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 维持可持续的农业种植面积 
//	 */
//	public double OutputAgriArea(List<DoubleArray> modleOutput);
//	
//	/**
//	 * 可持续社会福利指数 
//	 */
//	public double OutputSocialWelWare(List<DoubleArray> modleOutput);
//
//}
