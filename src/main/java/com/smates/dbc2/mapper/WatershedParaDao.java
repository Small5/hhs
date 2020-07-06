package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.po.LandUsePara;
import com.smates.dbc2.po.MidAndDownStreamPercentPara;
import com.smates.dbc2.po.SaveWater;
import com.smates.dbc2.po.SocEcoPara;
import com.smates.dbc2.po.TbLanduseSceCropPara;
import com.smates.dbc2.po.TbLanduseScePara;
import com.smates.dbc2.po.TbSocioEconomySceHydEngPara;
import com.smates.dbc2.po.TbSocioEconomyScePara;
import com.smates.dbc2.po.TbSocioEconomyScePoyPara;
import com.smates.dbc2.po.TbWaterManSceCWPara;
import com.smates.dbc2.po.TbWaterManSceMDPara;
import com.smates.dbc2.po.TbWaterManScePara;
import com.smates.dbc2.po.TbWaterManSceTWPara;
import com.smates.dbc2.po.TbWaterManSceWRPara;
import com.smates.dbc2.po.TblClimateScePara;
import com.smates.dbc2.po.TblIndUrbanScePara;
import com.smates.dbc2.po.WaterPara;
import com.smates.dbc2.vo.ProjectIdAndCountyId;
import com.smates.dbc2.vo.ProjectIdAndCountyId2;

/**
 * 
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 下午2:00:53
 */
public interface WatershedParaDao {
	/**
	 * 删除水资源管理参数
	 * @param projectIdAndCountyId
	 */
	public void deleteWaterParaById(ProjectIdAndCountyId projectIdAndCountyId);
	/**
	 * 删除土地利用情景参数
	 * @param projectIdAndCountyId
	 */
	public void deleteLandUseParaById(ProjectIdAndCountyId projectIdAndCountyId);
	/**
	 * 删除社会经济情景参数
	 * @param projectIdAndCountyId
	 */
	public void deleteSocEcoParaById(ProjectIdAndCountyId projectIdAndCountyId);
	/**
	 * 添加水资源管理参数
	 * @param waterPara
	 */
	public void addWaterPara(WaterPara waterPara);
	/**
	 * 查找水资源管理参数
	 * @param projectId
	 * @return
	 */
	public List<WaterPara> getWaterParaByProjectId(String projectId);
	/**
	 * 添加社会经济情景参数
	 * @param socEcoPara
	 */
	public void addSocEcoPara(SocEcoPara socEcoPara);
	/**
	 * 查找社会经济情景参数
	 * @param projectId
	 * @return
	 */
	public List<SocEcoPara> getSocEcoParaByProjectId(String projectId);
	/**
	 * 查找气候情景参数
	 * @param projectId
	 */
	public List<TblClimateScePara> getTblClimateSceParaByProjectId(String projectId);
    
	/**
	 * 添加气候情景参数
	 * 
	 * @param tblClimateScePara
	 */
	public void addTblClimateScePara(TblClimateScePara tblClimateScePara);
	
	/**
	 * 删除某个项目的气候情景参数
	 * 
	 * @param id
	 */
	public void deleteTblclimateSceParaById(ProjectIdAndCountyId projectIdAndCountyId);
	
	
	
	/**
	 * 查找气候情景参数
	 * @param projectIdAndCountyId
	 * @return
	 */
	public TblClimateScePara getTblClimateSceParaByProjectIdAndCountryId(ProjectIdAndCountyId projectIdAndCountyId);
	
	/**
	 * 添加产业与城市发展情景参数
	 */
	public void addTblIndUrbanScePara(TblIndUrbanScePara tblIndUrbanScePara);
	
	/**
	 * 删除产业与城市发展情景参数
	 * 
	 * @param projectIdAndCountyId
	 */
	public void deleteTblIndUrbanScePara(ProjectIdAndCountyId2 projectIdAndCountyId);
	
	/**
	 * 查找产业与城市发展情景参数
	 * @param projectIdAndCountyId
	 * @return
	 */
	public TblIndUrbanScePara getTblIndUrbanSceParaByProjectIdAndCountryId(ProjectIdAndCountyId2 projectIdAndCountyId);
	
	/**
	 * 获取城市与产业发展参数
	 * 
	 * @param projectId
	 * @return
	 */
	public List<TblIndUrbanScePara> getTblIndUrbanScePara(String projectId);
	/**
	 * 根据id查找土地利用情景参数1
	 * @param projectId
	 * @return
	 */
	public List<LandUsePara> getLandUseParaByProjectId(String projectId);
	/**
	 * 添加土地利用情景参数1
	 * @param landUsePara
	 */
	public void addLandUsePara(LandUsePara landUsePara);
	/**
	 * 添加土地资源利用情景参数
	 * 
	 * @param tbLanduseScePara
	 */
	public void addTbLanduseScePara(TbLanduseScePara tbLanduseScePara);
	
	/**
	 * 删除土地资源利用情景参数
	 * 
	 * @param projectIdAndCountyId
	 */
	public void deleteTbLanduseScePara(ProjectIdAndCountyId2 projectIdAndCountyId);
	
	/**
	 * 获取土地利用参数
	 * @param projectId
	 * @return
	 */
	public List<TbLanduseScePara> geTbLanduseScePara (String projectId);
	
	/**
	 * 查找土地资源利用情景参数
	 * @param projectIdAndCountyId
	 * @return
	 */
	public TbLanduseScePara getTbLanduseSceParaByProjectIdAndCountryId(ProjectIdAndCountyId2 projectIdAndCountyId);
	
	/**
	 * 添加社会经济发展情景参数
	 * 
	 * @param tbSocioEconomyScePara
	 */
	public void addTbSocioEconomyScePara(TbSocioEconomyScePara tbSocioEconomyScePara);
	
	/**
	 * 获取社会经济参数
	 * @return
	 */
	public List<TbSocioEconomyScePara> getTbSocioEconomyScePara(String projectId);
	
	/**
	 * 删除社会经济发展情景参数
	 * 
	 * @param projectIdAndCountyId
	 */
	public void deleteTbSocioEconomyScePara(ProjectIdAndCountyId2 projectIdAndCountyId);
	
	/**
	 * 查找社会经济发展情景参数
	 * @param projectIdAndCountyId
	 * @return
	 */
	public TbSocioEconomyScePara getTbSocioEconomySceParaByProjectIdAndCountryId(ProjectIdAndCountyId2 projectIdAndCountyId);

	/**
	 * 添加土地利用情景种植结构参数
	 * 
	 * @param tbLanduseSceCropPara
	 */
	public void addTbLanduseSceCropPara(TbLanduseSceCropPara tbLanduseSceCropPara);


	/**
	 * 添加社会经济发展情景优惠政策参数
	 * 
	 * @param tbSocioEconomyScePoyPara
	 */
	public void addTbSocioEconomyScePoyPara(TbSocioEconomyScePoyPara tbSocioEconomyScePoyPara);

	/**
	 * 添加社会经济发展情景水利工程参数
	 * 
	 * @param tbSocioEconomySceHydEngPara
	 */
	public void addTbSocioEconomySceHydEngPara(TbSocioEconomySceHydEngPara tbSocioEconomySceHydEngPara);

	/**
	 * 添加水资源管理情景参数
	 * 
	 * @param tbWaterManScePara
	 */
	public void addTbWaterManScePara(TbWaterManScePara tbWaterManScePara);

	/**
	 * 添加水资源管理情景县区三产用水量参数
	 * 
	 * @param tbWaterManSceTWPara
	 */
	public void addTbWaterManSceTWPara(TbWaterManSceTWPara tbWaterManSceTWPara);

	/**
	 * 添加水资源管理情景县区水权分配参数
	 * 
	 * @param tbWaterManSceTWPara
	 */
	public void addTbWaterManSceWRPara(TbWaterManSceWRPara tbWaterManSceWRPara);
	
	/**
	 * 删除水资源管理情景县区水权分配参数
	 * @param projectId
	 */
	public void deleteTbWaterManSceWRPara(ProjectIdAndCountyId2 projectIdAndCountyId);

	/**
	 * 添加水资源管理情景流域中下游用水量参数
	 * 
	 * @param tbWaterManSceMDPara
	 */
	public void addTbWaterManSceMDPara(TbWaterManSceMDPara tbWaterManSceMDPara);
	
	/**
	 * 获取中下游分水量
	 * @param projectId
	 */
	public TbWaterManSceMDPara getTbWaterManSceMDPara(String projectId);

	/**
	 * 添加水资源管理情景县区用水量参数
	 * 
	 * @param tbWaterManSceCWPara
	 */
	public void addTbWaterManSceCWPara(TbWaterManSceCWPara tbWaterManSceCWPara);
	
	/**
	 * 获取中游滴灌面积
	 * @param projectId
	 * @return
	 */
	public List<TbSocioEconomyScePara> getmidStreamSocioEconomyScePara(String projectId);
	
	/**
	 * 获取水权分配比例
	 * @param projectId 项目id
	 * @return
	 */
	public List<TbWaterManSceWRPara> getTbWaterManSceWRParaByProjectId(String projectId);
	
	/**
	 * 添加水资源管理，中下游水分配
	 */
	public void addMidAndDownStreamPercentPara(MidAndDownStreamPercentPara midAndDownStreamPercentPara);
	
	/**
	 * 获取中下游分水量
	 * @param projectId
	 * @return
	 */
	public MidAndDownStreamPercentPara getMidAndDownStreamPercentPara(String projectId);
	
	/**
	 * 删除对应项目ID中下游水分配数据
	 * @param projectId
	 */
	public void deleteMidAndDownStreamPercentPara(String projectId);
	
	/**
	 * 保存节水技术情景
	 */
	public void addSaveWater(SaveWater saveWater);
	
	/**
	 * 获取节水技术参数
	 * @param projectId 项目id
	 */
	public List<SaveWater> getSaveWaterByProjectId(String projectId);
	
	/**
	 * 删除节水技术情景
	 * @param projectIdAndCountyId
	 */
	public void deleteSaveWater(ProjectIdAndCountyId2 projectIdAndCountyId);
}
