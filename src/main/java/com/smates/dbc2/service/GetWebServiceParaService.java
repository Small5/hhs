package com.smates.dbc2.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.smates.dbc2.po.Project;
import com.smates.dbc2.vo.DoubleArray;
//import com.smates.dbc2.ws.DoubleArray;

/**
 * 获取webService模型需要的参数
 * 
 * @author baijw
 *
 */
public interface GetWebServiceParaService {

	/**
	 * 获取所有县区代码
	 * 
	 * @return
	 */
	public List<String> getCountryCodes();

	/**
	 * 获取所有县区名称
	 * 
	 * @return
	 */
	public List<String> getCountryNames();

	/**
	 * 查找项目信息
	 * 
	 * @param projectId
	 * @return
	 */
	public Project getProjectById(String username,String projectId);

	/**
	 * 获取降水数据（逐年各县）
	 * 
	 * @return
	 */
	public List<DoubleArray> getTblClimateScenarioYear()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
//	public List<DoubleArray> getprecR(String projectId)
//			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取平均温度
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> gettempAvg()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取最高温度
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> gettempMax()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取最低温度
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> gettempMin()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取中下游分水量
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getTblMidDownWaterAllo()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取下游分水量
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getTblDownDownWaterAllo()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取水权分配比例
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getfldWaterRightRatio(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取节水技术提高比例
	 * 
	 * @param projectId
	 *            项目id
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getSaveWater(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取非农业人口比例变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getpopNonAgriRR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取工业产值
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getoutputInd()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取农业产值
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getoutputAgr()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取服务业产值
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getoutputSer()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取旅游业产值
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getoutputTour()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取旅游业产值变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getoutputTourR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取产业进步率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> gettechProgRR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取耕地面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaAgri(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	
	/**
	 * 获取耕地面积增长率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaAgriR(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取小麦种植面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropWheat(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取玉米种植面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropCorn(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取油料种植面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropOilseed(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取果园种植面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropOrchard(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取棉花种植面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropCotton(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取蔬菜种植面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropGreenstuff(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取小麦种植面积变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropWheatR(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取玉米种植面积变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropCornR(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取油料作物面积变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropOilseedR(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取果园种植面积变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropOrchardR(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取棉花种植面积变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropCottonR(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取湿地面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaWetland(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取林地面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaForest(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取草地面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaGrass(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取水域面积
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaWater(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	/**
	 * 获取蔬菜种植面积变化率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getareaCropGreenstuffR(String projectId) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取GDP参数
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getGDP()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取人均GDP
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getgdpPer()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取GDP增长率
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getGDPInc(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取人均GDP增长率
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getGDPperInc(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取干渠长度
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getchannelMain(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取支渠长度
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getchannelBran(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取斗渠长度
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getchannelDou(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取支渠长度
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getchannelNong(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * 获取支渠长度
	 * 
	 * @param projectId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<DoubleArray> getchannelMao(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	   
	   /**
		 * 获取干渠水利用率
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getchannelMainWUE(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		
		/**
		 * 获取支渠水利用率
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getchannelBranWUE(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		
		/**
		 * 获取斗渠水利用率
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getchannelDouWUE(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		
		/**
		 * 获取农渠水利用率
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getchannelNongWUE(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		
		/**
		 * 获取毛渠水利用率
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getchannelMaoWUE(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		
		/**
		 * 获取滴灌面积
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getareaDripIrri(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

		/**
		 * 获取工业政策补贴
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getallowanceInd(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		/**
		 * 获取农业政策补贴
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getallowanceAgr(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		/**
		 * 获取服务业政策补贴
		 * 
		 * @param projectId
		 * @return
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 */
		public List<DoubleArray> getallowanceSer(String projectId)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

}
