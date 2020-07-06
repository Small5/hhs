package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.TblClimateScenarioMonth;
import com.smates.dbc2.po.TblClimateScenarioYear;
import com.smates.dbc2.po.TblCropPattern;
import com.smates.dbc2.po.TblHydrEngineering;
import com.smates.dbc2.po.TblIndustyUrbanSce;
import com.smates.dbc2.po.TblLandUseSce;
import com.smates.dbc2.po.ClimateScenario;
import com.smates.dbc2.po.TbLanduseScePara;
import com.smates.dbc2.po.TblMidDownWaterAllo;
import com.smates.dbc2.po.TblPrefPolicy;
import com.smates.dbc2.po.TblSocioEconSce;
import com.smates.dbc2.po.TblWaterAlloCounty;
import com.smates.dbc2.po.TblWaterResManSce;
import com.smates.dbc2.po.TblWaterRightCounty;
import com.smates.dbc2.po.TblWaterUseCounty;
import com.smates.dbc2.po.Watershed;
import com.smates.dbc2.vo.CRPTypeAndCountryId;
import com.smates.dbc2.vo.ProjectIdAndCountyId;
import com.smates.dbc2.vo.UserAndLandUse;
import com.smates.dbc2.vo.UsernameAndName;
import com.smates.dbc2.vo.UsernameAndWatershedId;
import com.smates.dbc2.vo.WatershedParaVo;

public interface WatershedDao {
	/**
	 * 根据用户名和ID查询流域信息
	 * @param userid
	 * @return
	 */
	public Watershed getwatershedbyUserAndId(UsernameAndWatershedId userid);
	/**
	 * 根据用户名查询名下的流域
	 * @param user
	 * @return
	 */
	public List<Watershed> getwatershedbyUser(String username);
	/**
	 * 添加流域信息
	 * 
	 * @param name
	 *            流域名称
	 * @param describe
	 *            流域描述
	 */
	public void addWatershed(Watershed watershed);
	/**
	 * 更新流域基本信息
	 * @param watershed
	 */
	public void updateWatershed(Watershed watershed);
	
	/**
	 * 添加气候情景数据表(年)数据
	 * 
	 * @param tblClimateScenarioYear
	 */
	public void addTblClimateScenarioYear(TblClimateScenarioYear tblClimateScenarioYear);
	
	/**
	 * 删除气候情景数据表(年)数据
	 * @param watershedCode
	 */
	public void deleteTblClimateScenarioYear(String watershedCode);
	
	/**
	 * 查找所有气候数据（逐年各县）
	 * @return
	 */
	public List<TblClimateScenarioYear> getTblClimateScenarioYear();
	
	/**
	 * 添加气候情景数据表(月)数据
	 * 
	 * @param tblClimateScenarioMonth
	 */
	public void addTblClimateScenarioMonth(TblClimateScenarioMonth tblClimateScenarioMonth);
	
	/**
	 * 删除气候情景数据表(月)数据
	 * @param watershedCode
	 */
	public void deleteTblClimateScenarioMonth(String watershedCode);
	
	/**
	 * 添加产业与城市发展情景
	 * 
	 * @param tblClimateScenarioMonth
	 */
	public void addTblIndustyUrbanSce(TblIndustyUrbanSce tblInodustyUrbanSce);
	
	/**
	 * 删除产业与城市发展情景
	 * @param watershedCode
	 */
	public void deleteTblIndustyUrbanSce(String watershedCode);
	
	/**
	 * 查找所有城市发展情景
	 * 
	 * @return
	 */
	public List<TblIndustyUrbanSce> getTblIndustyUrbanSce();
	/**
	 * 添加土地类型
	 * 
	 * @param tblLandUseSce
	 */
	public void addtblLandUseSce(TblLandUseSce tblLandUseSce);
	
	/**
	 * 删除土地类型
	 * @param watershedCode
	 */
	public void deletetblLandUseSce(String watershedCode);

	/**
	 * 添加种植结构数据
	 * 
	 * @param tblCropPattern
	 */
	public void addtblCropPattern(TblCropPattern tblCropPattern);
	
	/**
	 * 删除种植结构数据
	 * @param watershedCode
	 */
	public void deletetblCropPattern(String watershedCode);
	
	/**
	 * 添加GDP发展数据
	 * 
	 * @param tblSocioEconSce
	 */
	public void addtblSocioEconSce(TblSocioEconSce tblSocioEconSce);
	
	/**
	 * 删除GDP发展数据
	 * @param watershedCode
	 */
	public void deletetblSocioEconSce(String watershedCode);
	
	

	/**
	 * 添加优惠政策
	 * 
	 * @param tblPrefPolicy
	 */
	public void addtblPrefPolicy(TblPrefPolicy tblPrefPolicy);
	
	/**
	 * 删除优惠政策
	 * @param watershedCode
	 */
	public void deletetblPrefPolicy(String watershedCode);
	
	/**
	 * 添加水利工程数据
	 * 
	 * @param tblHydrEngineering
	 */
	public void addtblHydrEngineering(TblHydrEngineering tblHydrEngineering);
	
	/**
	 * 删除水利工程数据
	 * @param watershedCode
	 */
	public void deletetblHydrEngineering(String watershedCode);

	/**
	 * 添加水资源面积数据
	 * 
	 * @param tblWaterResManSce
	 */
	public void addtblWaterResManSce(TblWaterResManSce tblWaterResManSce);
	
	/**
	 * 删除水资源面积数据
	 * @param watershedCode
	 */
	public void deletetblWaterResManSce(String watershedCode);

	/**
	 * 添加县区三产用水量数据
	 * 
	 * @param tblWaterUseCounty
	 */
	public void addtblWaterUseCounty(TblWaterUseCounty tblWaterUseCounty);
	
	/**
	 * 删除县区三产用水量数据
	 * @param watershedCode
	 */
	public void deletetblWaterUseCounty(String watershedCode);
	
	/**
	 * 获取三产用水量
	 * @return
	 */
	public TblWaterUseCounty gettblWaterUseCountyByYearAndCountryId(ProjectIdAndCountyId projectIdAndCountyId);

	/**
	 * 添加县区水权分配数据
	 * 
	 * @param tblWaterRightCounty
	 */
	public void addtblWaterRightCounty(TblWaterRightCounty tblWaterRightCounty);
	
	/**
	 * 删除县区水权分配数据
	 * @param watershedCode
	 */
	public void deletetblWaterRightCounty(String watershedCode);

	/**
	 * 添加流域中下游分配数据
	 * 
	 * @param tblMidDownWaterAllo
	 */
	public void addtblMidDownWaterAllo(TblMidDownWaterAllo tblMidDownWaterAllo);
	
	/**
	 * 删除流域中下游分配数据
	 * @param watershedCode
	 */
	public void deletetblMidDownWaterAllo(String watershedCode);

	/**
	 * 添加县区用水量数据
	 * 
	 * @param tblWaterAlloCounty
	 */
	public void addtblWaterAlloCounty(TblWaterAlloCounty tblWaterAlloCounty);
	
	/**
	 * 删除县区用水量数据
	 * @param watershedCode
	 */
	public void deletetblWaterAlloCounty(String watershedCode);


	/**
	 * 根据气候情景排放类型查找气候情景数据表
	 * 
	 * @param CRPTypeAndCountryId
	 *            IPCC和县区代码
	 * @return 气候情景数据表(年)lsit
	 */
	public List<TblClimateScenarioYear> geTblClimateScenarioYearsByfldCRPType(CRPTypeAndCountryId cRPTypeAndCountryId);

	/*新：获取气候情景图标数据*/
	public List<ClimateScenario> getClimateScenarioByUsername(String username,String countyId);
	/**
	 * 查找流域信息
	 * @param watershed 
	 * @return
	 */
	public List<Watershed> getWatershedByName(WatershedParaVo watershedParaVo);
	
	/**
	 * 查找所有流域信息（主要提取流域名）
	 * @param username
	 * @return
	 */

	public List<String> getwatershednamebyUser(String username);
	/**
	 * 查询符合条件的流域总数
	 * @return 流域总个数
	 */
	public Integer getWatershedSum(UsernameAndName usernameandname);
	
	/**
	 * 删除一个流域信息
	 * @param id 流域id
	 */
	public void deleteWatershed(UsernameAndWatershedId usernameandwatershedId);
	
	/**
	 * 根据气候情景排放类型查找气候情景数据表（年）
	 * 
	 * @param fldCRPType
	 *            气候情景排放类型
	 * @return 气候情景数据表(年)list
	 */
	public List<TblClimateScenarioYear> getTblClimateScenarioYearsByfldCRPType(String fldCRPType);

	/**
	 * 根据气候情景排放类型查找气候情景数据表（月）
	 * 
	 * @param fldCRPType
	 *            气候情景排放类型
	 * @return 气候情景数据表(月)list
	 */
	public List<TblClimateScenarioMonth> getTblClimateScenarioMonthByfldCRPType(String fldCRPType);

	/**
	 * 根据县区代码查找产业与城市发展情景数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 产业与城市发展情景数据表list
	 */
	public List<TblIndustyUrbanSce> getTblIndustyUrbanSceByfldCountyCode(UserAndLandUse userAndLandUse);

	/**
	 * 根据县区代码查找GDP发展数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return GDP发展数据表list
	 */
	public List<TblSocioEconSce> getTblSocioEconSceByfldCountyCode(String fldCountyCode);

	/**
	 * 根据县区代码查找优惠政策表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 优惠政策表list
	 */
	public List<TblPrefPolicy> getTblPrefPolicyByfldCountyCode(String fldCountyCode);

	/**
	 * 根据县区代码查找水利工程数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 水利工程数据表list
	 */
	public List<TblHydrEngineering> getTblHydrEngineeringByfldCountyCode(UserAndLandUse userAndLandUse);

	/**
	 * 根据县区代码查找土地类型数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 土地类型数据表list
	 */
	public List<TbLanduseScePara> getTblLandUseSceByfldCountyCode(UserAndLandUse userAndLandUse);

	/**
	 * 根据县区代码查找种植结构数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 种植结构数据表list
	 */
	public List<TblCropPattern> getTblCropPatternByfldCountyCode(String fldCountyCode);

	/**
	 * 根据县区代码查找水资源面积数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 水资源面积数据表list
	 */
	public List<TblWaterResManSce> getTblWaterResManSceByfldCountyCode(String fldCountyCode);

	/**
	 * 根据县区代码查找三产用水量数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 三产用水量数据表list
	 */
	public List<TblWaterUseCounty> getTblWaterUseCountyByfldCountyCode(String fldCountyCode);

	/**
	 * 根据县区代码查找水权分配数据表 ！！！！！！！！！！！后期需要增加市级代码！！！！！！！！！！
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 水权分配数据表list
	 */
	public List<TblWaterRightCounty> getTblWaterRightCountyByfldCountyCode(String fldCountyCode);

	/**
	 * 查找流域中下游水分配表
	 * 
	 * @param
	 * 
	 * @return 中下游水分配表list
	 */
	public List<TblMidDownWaterAllo> getTblMidDownWaterAllo();

	/**
	 * 根据县区代码查找县区用水量数据表
	 * 
	 * @param fldCountyCode
	 *            县区代码
	 * @return 县区用水量数据表list
	 */
	public List<TblWaterAlloCounty> getTblWaterAlloCountyByfldCountyCode(String fldCountyCode);
	
	/**
	 * 获取社会经济参数
	 * @return
	 */
	public List<TblSocioEconSce> getTblSocioEconSce();
	
	

}
