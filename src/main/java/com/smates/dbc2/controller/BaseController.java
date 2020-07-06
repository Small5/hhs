package com.smates.dbc2.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.smates.dbc2.mapper.StreamLanUseSceVoDao;
import com.smates.dbc2.mapper.WatershedDao;
import com.smates.dbc2.mapper.WatershedParaDao;
import com.smates.dbc2.po.TblClimateScenarioMonth;
import com.smates.dbc2.po.TblClimateScenarioYear;
import com.smates.dbc2.po.TblCropPattern;
import com.smates.dbc2.po.TblHydrEngineering;
import com.smates.dbc2.po.TblIndustyUrbanSce;
import com.smates.dbc2.po.TblLandUseSce;
import com.smates.dbc2.po.TbLanduseScePara;
import com.smates.dbc2.po.TblMidDownWaterAllo;
import com.smates.dbc2.po.TblPrefPolicy;
import com.smates.dbc2.po.TblSocioEconSce;
import com.smates.dbc2.po.TblWaterAlloCounty;
import com.smates.dbc2.po.TblWaterResManSce;
import com.smates.dbc2.po.TblWaterRightCounty;
import com.smates.dbc2.po.TblWaterUseCounty;
import com.smates.dbc2.po.UserWatershedRelation;
import com.smates.dbc2.service.ChineseAndEnglishService;
import com.smates.dbc2.service.JxlService;
import com.smates.dbc2.service.MenuService;
import com.smates.dbc2.service.RoleService;
import com.smates.dbc2.service.UserAndLanguageService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.service.UserWatershedRelationService;
import com.smates.dbc2.service.WatershedService;
import com.smates.dbc2.utils.StringUtils;

public class BaseController {
	
	@Autowired
	public ChineseAndEnglishService chineseAndEnglishService;
	
	@Autowired
	public UserAndLanguageService userAndLanguageService;
	
	@Autowired
	public StreamLanUseSceVoDao streamLanUseSceVoDao;
	
	@Autowired
	public WatershedParaDao watershedParaDao;

	@Autowired
	public UserService userService;

	@Autowired
	public MenuService menuService;

	@Autowired
	public RoleService roleService;
	
	@Autowired
	public JxlService jxlService;
	
	@Autowired
	public WatershedDao watershedDao;

	@Autowired
	public WatershedService watershedService;
	
	@Autowired
	public UserProjectRelationService userProjectRelationService;
	
	@Autowired
	public UserWatershedRelationService userWatershedRelationService;
	
	
	
	public String userLanguage;

	public Logger logger = Logger.getLogger(BaseController.class);

	public void StoreExcelData(String watershedCode, MultipartFile tblClimateScenarioYear, MultipartFile tblClimateScenarioMonth,
			MultipartFile tblLandUseSce, MultipartFile tblCropPattern,
			MultipartFile tblSocioEconSce, MultipartFile tblPrefPolicy, MultipartFile tblHydrEngineering,
			MultipartFile tblWaterResManSce, MultipartFile tblWaterUseCounty, MultipartFile tblWaterRightCounty,
			MultipartFile tblMidDownWaterAllo, MultipartFile tblWaterAlloCounty) throws IOException {
		//1.气候情景数据表(年)
				if (!StringUtils.isEmpty(tblClimateScenarioYear.getOriginalFilename())) {
					watershedDao.deleteTblClimateScenarioYear(userService.getCurrentUserId());
					List<TblClimateScenarioYear> tblClimateScenarioYears = jxlService
							.getAllContenttblClimateScenarioYear(tblClimateScenarioYear.getInputStream());
					logger.info(tblClimateScenarioYears.size() + "year");
					for (int i = 0; i < tblClimateScenarioYears.size(); i++) {
						watershedService.addTblClimateScenarioYear(tblClimateScenarioYears.get(i));
					}
				}
		//2.气候情景数据表(月)
		if (!StringUtils.isEmpty(tblClimateScenarioMonth.getOriginalFilename())) {
			watershedDao.deleteTblClimateScenarioMonth(userService.getCurrentUserId());//根据用户名删除原有数据
			List<TblClimateScenarioMonth> tblClimateScenarioMonths = jxlService
					.getAllContenttblClimateScenarioMonth(tblClimateScenarioMonth.getInputStream());
			logger.info(tblClimateScenarioMonths.size() + "month");
			for (int i = 0; i < tblClimateScenarioMonths.size(); i++) {
				watershedService.addTblClimateScenarioMonth(tblClimateScenarioMonths.get(i));
			}
		}
		
		//3.土地种类
		if (!StringUtils.isEmpty(tblLandUseSce.getOriginalFilename())) {
			watershedDao.deletetblLandUseSce(watershedCode);
			List<TblLandUseSce> TblLandUseSces = jxlService.getAllContentTblLandUseSce(tblLandUseSce.getInputStream());
			logger.info(TblLandUseSces.size() + "土地种类");
			for (int i = 0; i < TblLandUseSces.size(); i++) {
				watershedService.addTblLandUseSce(TblLandUseSces.get(i));
			}
		}
		//4.种植结构
		if (!StringUtils.isEmpty(tblCropPattern.getOriginalFilename())) {
			watershedDao.deletetblCropPattern(userService.getCurrentUserId());
			List<TblCropPattern> TblCropPatterns = jxlService
					.getAllContentTblCropPattern(tblCropPattern.getInputStream());
			logger.info(TblCropPatterns.size() + "种植结构");
			for (int i = 0; i < TblCropPatterns.size(); i++) {
				watershedService.addtblCropPattern(TblCropPatterns.get(i));
			}
		}
		//5.GDP数据
		if (!StringUtils.isEmpty(tblSocioEconSce.getOriginalFilename())) {
			watershedDao.deletetblSocioEconSce(userService.getCurrentUserId());
			List<TblSocioEconSce> TblSocioEconSces = jxlService
					.getAllContentTblSocioEconSce(tblSocioEconSce.getInputStream());
			logger.info(TblSocioEconSces.size() + "GDP数据");
			for (int i = 0; i < TblSocioEconSces.size(); i++) {
				watershedService.addtblSocioEconSce(TblSocioEconSces.get(i));
			}
		}
		//6.优惠政策
		if (!StringUtils.isEmpty(tblPrefPolicy.getOriginalFilename())) {
			watershedDao.deletetblPrefPolicy(userService.getCurrentUserId());
			List<TblPrefPolicy> TblPrefPolicys = jxlService.getAllContentTblPrefPolicy(tblPrefPolicy.getInputStream());
			logger.info(TblPrefPolicys.size() + "优惠政策");
			for (int i = 0; i < TblPrefPolicys.size(); i++) {
				watershedService.addtblPrefPolicy(TblPrefPolicys.get(i));
			}
		}
		
		//7.水利工程
		if (!StringUtils.isEmpty(tblHydrEngineering.getOriginalFilename())) {
			watershedDao.deletetblHydrEngineering(userService.getCurrentUserId());
			List<TblHydrEngineering> TblHydrEngineerings = jxlService
					.getAllContentTblHydrEngineering(tblHydrEngineering.getInputStream());
			logger.info(TblHydrEngineerings.size() + "水利工程");
			for (int i = 0; i < TblHydrEngineerings.size(); i++) {
				watershedService.addtblHydrEngineering(TblHydrEngineerings.get(i));
			}
		}

		//8.水资源面积
		if (!StringUtils.isEmpty(tblWaterResManSce.getOriginalFilename())) {
			watershedDao.deletetblWaterResManSce(userService.getCurrentUserId());
			List<TblWaterResManSce> TblWaterResManSces = jxlService
					.getAllContentTblWaterResManSce(tblWaterResManSce.getInputStream());
			logger.info(TblWaterResManSces.size() + "水资源面积");
			for (int i = 0; i < TblWaterResManSces.size(); i++) {
				watershedService.addtblWaterResManSce(TblWaterResManSces.get(i));
			}
		}

		//9.县区三产用水量
		if (!StringUtils.isEmpty(tblWaterUseCounty.getOriginalFilename())) {
			watershedDao.deletetblWaterUseCounty(userService.getCurrentUserId());
			List<TblWaterUseCounty> TblWaterUseCountys = jxlService
					.getAllContentTblWaterUseCounty(tblWaterUseCounty.getInputStream());
			logger.info(TblWaterUseCountys.size() + "县区三产用水量");
			for (int i = 0; i < TblWaterUseCountys.size(); i++) {
				watershedService.addtblWaterUseCounty(TblWaterUseCountys.get(i));
			}
		}

		//10.县区水权分配
		if (!StringUtils.isEmpty(tblWaterRightCounty.getOriginalFilename())) {
			watershedDao.deletetblWaterRightCounty(userService.getCurrentUserId());
			List<TblWaterRightCounty> TblWaterRightCountys = jxlService
					.getAllContentTblWaterRightCounty(tblWaterRightCounty.getInputStream());
			logger.info(TblWaterRightCountys.size() + "县区水权分配");
			for (int i = 0; i < TblWaterRightCountys.size(); i++) {
				watershedService.addtblWaterRightCounty(TblWaterRightCountys.get(i));
			}
		}

		//11.流域中下游水分配
		if (!StringUtils.isEmpty(tblMidDownWaterAllo.getOriginalFilename())) {
			watershedDao.deletetblMidDownWaterAllo(userService.getCurrentUserId());
			List<TblMidDownWaterAllo> TblMidDownWaterAllos = jxlService
					.getAllContentTblMidDownWaterAllo(tblMidDownWaterAllo.getInputStream());
			logger.info(TblMidDownWaterAllos.size() + "流域中下游水分配");
			for (int i = 0; i < TblMidDownWaterAllos.size(); i++) {
				watershedService.addtblMidDownWaterAllo(TblMidDownWaterAllos.get(i));
			}
		}

		//12.县区用水量
		if (!StringUtils.isEmpty(tblWaterAlloCounty.getOriginalFilename())) {
			watershedDao.deletetblWaterAlloCounty(userService.getCurrentUserId());
			List<TblWaterAlloCounty> TblWaterAlloCountys = jxlService
					.getAllContentTblWaterAlloCounty(tblWaterAlloCounty.getInputStream());
			logger.info(TblWaterAlloCountys.size() + "县区用水量");
			for (int i = 0; i < TblWaterAlloCountys.size(); i++) {
				watershedService.addtblWaterAlloCounty(TblWaterAlloCountys.get(i));
			}
		}
	}

}
