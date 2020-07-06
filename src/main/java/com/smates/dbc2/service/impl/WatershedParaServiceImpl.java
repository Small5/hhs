package com.smates.dbc2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.WatershedParaDao;
import com.smates.dbc2.po.LandUsePara;
import com.smates.dbc2.po.MidAndDownStreamPercentPara;
import com.smates.dbc2.po.SaveWater;
import com.smates.dbc2.po.SocEcoPara;
import com.smates.dbc2.po.TbLanduseScePara;
import com.smates.dbc2.po.TbSocioEconomyScePara;
import com.smates.dbc2.po.TbWaterManSceCWPara;
import com.smates.dbc2.po.TbWaterManSceMDPara;
import com.smates.dbc2.po.TbWaterManSceWRPara;
import com.smates.dbc2.po.TblClimateScePara;
import com.smates.dbc2.po.TblIndUrbanScePara;
import com.smates.dbc2.po.WaterPara;
import com.smates.dbc2.service.WatershedParaService;
import com.smates.dbc2.vo.ProjectIdAndCountyId;
import com.smates.dbc2.vo.ProjectIdAndCountyId2;

/**
 * @author machao march.machao@gmail.com
 * @version 创建时间：2016年9月29日 下午2:22:29
 */

@Service
public class WatershedParaServiceImpl implements WatershedParaService {
	@Autowired
	private WatershedParaDao watershedParaDao;
	
	
	@Override
	public List<TblClimateScePara> getTblClimateSceParaByProjectId(String projectId) {
		return watershedParaDao.getTblClimateSceParaByProjectId(projectId);
				
	}

	@Override
	public void addTblClimateScePara(String projectId, String countyId, String rainInc, String tempInc) {
		watershedParaDao
				.addTblClimateScePara(new TblClimateScePara(projectId, countyId, rainInc, tempInc));
	}

	

	@Override
	public void addTblIndUrbanScePara(String projectId, String countryId, String nonFarmPercent, String fldIndOutput,
			String fldIndOutputPercent, String fldAgrOutput, String fldAgrOutputPercent, String fldSerOutput,
			String fldSerOutputPercent, String industryProgressRate, String changeRateOfTourismIndustry,String year, 
			String fldFarmPop, String fldNonFarmPop) {
		watershedParaDao.addTblIndUrbanScePara(new TblIndUrbanScePara(projectId, countryId, nonFarmPercent,
				fldIndOutput, fldIndOutputPercent, fldAgrOutput, fldAgrOutputPercent, fldSerOutput, fldSerOutputPercent,
				industryProgressRate, changeRateOfTourismIndustry, year, fldFarmPop, fldNonFarmPop));
	}

	@Override
	public void deleteTblIndUrbanScePara(String projectId, String countryId, String year) {
		watershedParaDao.deleteTblIndUrbanScePara(new ProjectIdAndCountyId2(projectId, countryId,year));
	}

	@Override
	public void addTbLanduseScePara(String projectId, String countryId, String fldFarmArea,String fldFarmAreaChgR, String wheatChgR,
			String cornChgR, String oilPlantsChgR, String vegetablesChgR, String orchardChgR, String cottonChgR,
			String wheatArea, String cornArea, String oilPlantsArea, String vegetablesArea, String orchardArea,
			String cottonArea, String wetlandArea, String forestArea, String grassArea, String waterArea, String year) {
		watershedParaDao.addTbLanduseScePara(new TbLanduseScePara(projectId, countryId, fldFarmArea,fldFarmAreaChgR, wheatChgR,
				cornChgR, oilPlantsChgR, vegetablesChgR, orchardChgR, cottonChgR, wheatArea, cornArea, oilPlantsArea,
				vegetablesArea, orchardArea, cottonArea, wetlandArea, forestArea, grassArea, waterArea,year));
	}

	@Override
	public void deleteTbLanduseScePara(String projectId, String countryId, String year) {
		watershedParaDao.deleteTbLanduseScePara(new ProjectIdAndCountyId2(projectId, countryId, year));
	}

	@Override
	public void addTbSocioEconomyScePara(String projectId, String countryId, String perCapGDPR,String perCapGDP,
			String fldMainCannelLeng, String fldMainCanWUE, String fldBranCannelLeng, String fldBranCanWUE,
			String fldDouLeng, String fldDouWUE, String fldNongLeng, String fldNongWUE, String fldMaoLeng,
			String fldMaoWUE, String fldSprinkingArea, String fldDropIrrArea, String fldIndustryAllowance,
			String fldFarmAllowance, String fldServiceAllowance,String year) {
		watershedParaDao.addTbSocioEconomyScePara(new TbSocioEconomyScePara(projectId, countryId, perCapGDPR,perCapGDP,
				fldMainCannelLeng, fldMainCanWUE, fldBranCannelLeng, fldBranCanWUE, fldDouLeng, fldDouWUE, fldNongLeng,
				fldNongWUE, fldMaoLeng, fldMaoWUE, fldSprinkingArea, fldDropIrrArea, fldIndustryAllowance,
				fldFarmAllowance, fldServiceAllowance,year));
	}

	@Override
	public void deleteTbSocioEconomyScePara(String projectId, String countryId,String year) {
		watershedParaDao.deleteTbSocioEconomyScePara(new ProjectIdAndCountyId2(projectId, countryId,year));
	}

	

	@Override
	public TblIndUrbanScePara getTblIndUrbanSceParaByProjectIdAndCountryId(String projectId, String countryId,String year) {

				return watershedParaDao
				.getTblIndUrbanSceParaByProjectIdAndCountryId(new ProjectIdAndCountyId2(projectId, countryId,year));
	}

	@Override
	public TbLanduseScePara getTbLanduseSceParaByProjectIdAndCountryId(String projectId, String countryId,String year) {

				return watershedParaDao
				.getTbLanduseSceParaByProjectIdAndCountryId(new ProjectIdAndCountyId2(projectId, countryId,year));
	}

	@Override
	public TbSocioEconomyScePara getTbSocioEconomySceParaByProjectIdAndCountryId(String projectId, String countryId,String year) {

				return watershedParaDao
				.getTbSocioEconomySceParaByProjectIdAndCountryId(new ProjectIdAndCountyId2(projectId, countryId,year));
	}

	@Override
	public void addTbWaterManSceCWPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode,
			String fldDate, double fldSurfaceWater, double fldGroundWater) {
		watershedParaDao.addTbWaterManSceCWPara(new TbWaterManSceCWPara(fldWatershedCode, fldProjectCode, fldCountyCode,
				fldDate, fldSurfaceWater, fldGroundWater));
	}

	@Override
	public void addTbWaterManSceMDPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode,
			String fldDate, double fldWaterUseMid, double fldWaterUseDown) {
		watershedParaDao.addTbWaterManSceMDPara(new TbWaterManSceMDPara(fldWatershedCode, fldProjectCode, fldCountyCode,
				fldDate, fldWaterUseMid, fldWaterUseDown));
	}

	@Override
	public void addTbWaterManSceWRPara(String fldWatershedCode, String fldProjectCode, String fldCountyCode,
			String fldDate, double fldWaterRightRatio) {
		watershedParaDao.deleteTbWaterManSceWRPara(new ProjectIdAndCountyId2(fldProjectCode, fldCountyCode,null));
		watershedParaDao.addTbWaterManSceWRPara(
				new TbWaterManSceWRPara(fldWatershedCode, fldProjectCode, fldCountyCode, fldDate, fldWaterRightRatio));
	}

	@Override
	public void addMidAndDownStreamPercentPara(String projectId, String watershedId, double serfaceWater,
			double midstreamPercent, double downstreamPercent) {
		watershedParaDao.deleteMidAndDownStreamPercentPara(projectId);
		watershedParaDao.addMidAndDownStreamPercentPara(new MidAndDownStreamPercentPara(projectId, watershedId,
				serfaceWater, midstreamPercent, downstreamPercent));
	}

	@Override
	public void addSaveWater(String projectId, String countryId, double savewater) {
		watershedParaDao.deleteSaveWater(new ProjectIdAndCountyId2(projectId, countryId,"2014"));
		watershedParaDao.addSaveWater(new SaveWater(projectId, countryId, savewater,"2014"));
	}

	/**
	 * 根据id查找土地利用情景参数1
	 */
	@Override
	public List<LandUsePara> getLandUseParaByProjectId(String projectId) {
		return watershedParaDao.getLandUseParaByProjectId(projectId);	
	}

	/**
	 * 添加土地利用情景参数1
	 */
	@Override
	public void addLandUsePara(String projectId, String countyId, String LandFarmR, String LandForestR,
			String LandGrassR, String WaterArea, String LandBareR, String LandCityR,
			String CPWhR, String CPCornR,
			String CPOilR, String CPVegR, String CPFTR, String CPCotR
			) {
		watershedParaDao.addLandUsePara(new LandUsePara(projectId, countyId,
				LandFarmR, LandForestR, LandGrassR, WaterArea, LandBareR, 
				LandCityR,CPWhR, CPCornR, CPOilR, CPVegR, CPFTR, CPCotR));	
	}

	/**
	 * 查询社会经济情景参数
	 */
	@Override
	public List<SocEcoPara> getSocEcoParaByProjectId(String projectId) {
		return watershedParaDao.getSocEcoParaByProjectId(projectId);
	}

	/**
	 * 添加社会经济情景参数
	 */
	@Override
	public void addSocEcoPara(String projectId, String countyId, String popolicy, String IARArg, String IARInd,
			String IARSer,String negak) {
		watershedParaDao.addSocEcoPara(new SocEcoPara(projectId,countyId,popolicy,IARArg,IARInd,IARSer,negak));
		
	}
	/**
	 * 查询水资源管理参数
	 */
	@Override
	public List<WaterPara> getWaterParaByProjectId(String projectId) {
		return watershedParaDao.getWaterParaByProjectId(projectId);
	}

	/**
	 * 添加水资源管理参数
	 */
	@Override
	public void addWaterPara(String projectId, String countyId, String Upstreamwater, String FlowDown,
			String Waterdistribution, String SurSup, String GWSup, String SupWater) {
		watershedParaDao.addWaterPara(new WaterPara(projectId, countyId, Upstreamwater, 
				FlowDown, Waterdistribution, SurSup, GWSup, SupWater));
	}
	/**
	 * 删除气候情景参数
	 */
	@Override
	public void deleteTblclimateSceParaById(String projectId, String countryId) {
		watershedParaDao.deleteTblclimateSceParaById(new ProjectIdAndCountyId(projectId, countryId));
	}
	/**
	 * 删除水资源管理参数
	 */
	@Override
	public void deleteWaterParaById(String projectId, String countyId) {
		watershedParaDao.deleteWaterParaById(new ProjectIdAndCountyId(projectId, countyId));
		
	}

	/**
	 * 删除社会经济情景参数
	 */
	@Override
	public void deleteSocEcoParaById(String projectId, String countyId) {
		watershedParaDao.deleteSocEcoParaById(new ProjectIdAndCountyId(projectId, countyId));
		
	}
	/**
	 * 删除土地利用情景参数
	 */
	@Override
	public void deleteLandUseParaById(String projectId, String countyId) {
		watershedParaDao.deleteLandUseParaById(new ProjectIdAndCountyId(projectId, countyId));
		
	}

}
