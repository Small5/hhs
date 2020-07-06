package com.smates.dbc2.controller;

import java.util.List;

import com.smates.dbc2.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.smates.dbc2.mapper.GisDao;
import com.smates.dbc2.service.GisService;
import com.smates.dbc2.service.LeafletService;
import com.smates.dbc2.service.ProjectService;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.CountryIdAndFarmAreaVo;
import com.smates.dbc2.vo.StreamLanUseSceVo;

@Controller
public class GisController extends BaseController {
	
	@Autowired
	private GisService gisService; 

	@Autowired
	private GisDao gisDao;
	
	@Autowired
	private LeafletService leafletService;
	
	@ResponseBody
	@RequestMapping(value = "setFlowdown", method = RequestMethod.POST)
	public BaseMsg setFlowdown(String flowdown) {
		String countyId = "2";
		String projectId = userProjectRelationService
				.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		gisService.setflowdown(projectId, countyId, flowdown);
		return new BaseMsg(true, "修改成功");
	}

/*====================================leaflet部分=============================================*/
	//获取中文指标类型
	@ResponseBody
	@RequestMapping(value = "indexTypeCH",method = RequestMethod.GET)
	public List<String> getIndexTypeCH(){
//		List<String>  arr = new ArrayList<String>();
//		arr.add("GDP");
//		arr.add("a1");
//		arr.add("a2");
//		arr.add("a3");
		return leafletService.getIndexTypeCH();
	}
	//获取英文指标类型
	@ResponseBody
	@RequestMapping(value = "indexTypeEN",method = RequestMethod.GET)
	public List<String> getIndexTypeEN(){

		return leafletService.getIndexTypeEN();
	}
	
	@ResponseBody
	@RequestMapping(value = "leafletA",method = RequestMethod.GET)
	public List<String> getAllYear(){
		return leafletService.getAllYear();
	}
	
	@ResponseBody
	@RequestMapping(value = "getEvallevel",method = RequestMethod.GET)
	public List<Evallevel> getEvaluateResult(String year){
		return leafletService.getEvallevel(year);
	}
	
//	@ResponseBody
//	@RequestMapping(value = "leafletC",method = RequestMethod.GET)
//	public List<GisIndex> getLeftDataByType(String name,String type){
//		return leafletService.getLeftDataByType(name, type);
//	}
	
	@ResponseBody
	@RequestMapping(value = "getleftdata",method = RequestMethod.GET)
	public List<Indicators> getLeftDataByType(String projectId,String countyId){
		return leafletService.getLeftDataByCountyId(projectId, countyId);
	}
	
	@ResponseBody
	@RequestMapping(value = "leafletD",method = RequestMethod.GET)
	public List<Developindex> getRightDataByYear(String name,int year){
		return leafletService.getRightDataByYear(name, year);
	}
	
	@ResponseBody
	@RequestMapping(value = "leafletE",method = RequestMethod.GET)
	public List<GisIndex> getTypeValueByYearAndIndexype(String type,int year){
		return leafletService.getTypeValueByYearAndIndexype(type, year);
	}
/*============================================================================================*/
	@RequestMapping("gis")
	public String Gis(ModelMap modelMap) {
		
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		//情景控制
		modelMap.addAttribute("projectId", userProjectRelationService
				.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId());
		modelMap.addAttribute("scecon", chineseAndEnglishService.getPhraseByIndexAndLanguage(189, userLanguage));
		//评价结果
		modelMap.addAttribute("result", chineseAndEnglishService.getPhraseByIndexAndLanguage(190, userLanguage));
		modelMap.addAttribute("downresult", chineseAndEnglishService.getPhraseByIndexAndLanguage(191, userLanguage));
		modelMap.addAttribute("index1", chineseAndEnglishService.getPhraseByIndexAndLanguage(192, userLanguage));
		modelMap.addAttribute("index2", chineseAndEnglishService.getPhraseByIndexAndLanguage(193, userLanguage));
		modelMap.addAttribute("index3", chineseAndEnglishService.getPhraseByIndexAndLanguage(194, userLanguage));
		modelMap.addAttribute("index4", chineseAndEnglishService.getPhraseByIndexAndLanguage(195, userLanguage));
		modelMap.addAttribute("up", chineseAndEnglishService.getPhraseByIndexAndLanguage(196, userLanguage));
		modelMap.addAttribute("zxwater", chineseAndEnglishService.getPhraseByIndexAndLanguage(197, userLanguage));
		modelMap.addAttribute("zhong", chineseAndEnglishService.getPhraseByIndexAndLanguage(198, userLanguage));
		modelMap.addAttribute("xia", chineseAndEnglishService.getPhraseByIndexAndLanguage(199, userLanguage));
		modelMap.addAttribute("mid", chineseAndEnglishService.getPhraseByIndexAndLanguage(200, userLanguage));
		modelMap.addAttribute("mids", chineseAndEnglishService.getPhraseByIndexAndLanguage(201, userLanguage));
		modelMap.addAttribute("midd", chineseAndEnglishService.getPhraseByIndexAndLanguage(202, userLanguage));
		modelMap.addAttribute("down", chineseAndEnglishService.getPhraseByIndexAndLanguage(203, userLanguage));
		modelMap.addAttribute("EA", chineseAndEnglishService.getPhraseByIndexAndLanguage(204, userLanguage));
		modelMap.addAttribute("etitle", chineseAndEnglishService.getPhraseByIndexAndLanguage(205, userLanguage));
		modelMap.addAttribute("ganzhou", chineseAndEnglishService.getPhraseByIndexAndLanguage(206, userLanguage));
		modelMap.addAttribute("linze", chineseAndEnglishService.getPhraseByIndexAndLanguage(207, userLanguage));
		modelMap.addAttribute("gaotai", chineseAndEnglishService.getPhraseByIndexAndLanguage(208, userLanguage));
		modelMap.addAttribute("shandan", chineseAndEnglishService.getPhraseByIndexAndLanguage(209, userLanguage));
		modelMap.addAttribute("minle", chineseAndEnglishService.getPhraseByIndexAndLanguage(210, userLanguage));
		modelMap.addAttribute("sunan", chineseAndEnglishService.getPhraseByIndexAndLanguage(211, userLanguage));
		modelMap.addAttribute("jiayuguan", chineseAndEnglishService.getPhraseByIndexAndLanguage(212, userLanguage));
		modelMap.addAttribute("suzhou", chineseAndEnglishService.getPhraseByIndexAndLanguage(213, userLanguage));
		modelMap.addAttribute("jinta", chineseAndEnglishService.getPhraseByIndexAndLanguage(214, userLanguage));
		modelMap.addAttribute("ejinaqi", chineseAndEnglishService.getPhraseByIndexAndLanguage(215, userLanguage));
		modelMap.addAttribute("wanmu", chineseAndEnglishService.getPhraseByIndexAndLanguage(313, userLanguage));
		modelMap.addAttribute("yilifang", chineseAndEnglishService.getPhraseByIndexAndLanguage(170, userLanguage));
		try {
			String projectId = userProjectRelationService
					.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
			// 上游【耕地面积、湿地面积】
			List<StreamLanUseSceVo> upstreamLanUseSceVos = streamLanUseSceVoDao.getStreamLanUseSceVo("upstream");
			// 中游【耕地面积、湿地面积】
			List<StreamLanUseSceVo> midstreamLanUseSceVos = streamLanUseSceVoDao.getStreamLanUseSceVo("midstream");
			// 下游【耕地面积、湿地面积】
			List<StreamLanUseSceVo> downstreamLanUseSceVos = streamLanUseSceVoDao.getStreamLanUseSceVo("downstream");
			// 中下游分水量
			MidAndDownStreamPercentPara midAndDownStreamPercentPara = watershedParaDao
					.getMidAndDownStreamPercentPara(projectId);
			// 中游滴灌面积
			List<TbSocioEconomyScePara> midStreamTbSocioEconomyScePara = watershedParaDao
					.getmidStreamSocioEconomyScePara(projectId);

			// 上游耕地面积和
			double upStramFarmArea = 0;
			if (upstreamLanUseSceVos != null) {
				for (int i = 0; i < upstreamLanUseSceVos.size(); i++) {
					upStramFarmArea = upStramFarmArea
							+ Double.parseDouble(upstreamLanUseSceVos.get(i).getFldFarmArea());
				}
			}

			// 中游耕地耕地面积和，中游湿地面积和
			double midStreamFarmArea = 0, midStreamWetLand = 0;
			if (midstreamLanUseSceVos != null) {
				for (int i = 0; i < midstreamLanUseSceVos.size(); i++) {
					midStreamFarmArea = midStreamFarmArea
							+ Double.parseDouble(midstreamLanUseSceVos.get(i).getFldFarmArea());
					midStreamWetLand = midStreamWetLand
							+ Double.parseDouble(midstreamLanUseSceVos.get(i).getWetlandArea());
				}
			}

			// 中游滴灌面积和
			double midStreamsprink = 0;
			if (midStreamTbSocioEconomyScePara != null) {
				for (int i = 0; i < midStreamTbSocioEconomyScePara.size(); i++) {
					midStreamsprink = midStreamsprink
							+ Double.parseDouble(midStreamTbSocioEconomyScePara.get(i).getFldSprinkingArea());
				}
			}

			// 下游耕地面积和
			double downStreamFarmArea = 0;
			if (downstreamLanUseSceVos != null) {
				for (int i = 0; i < downstreamLanUseSceVos.size(); i++) {
					downStreamFarmArea = downStreamFarmArea
							+ Double.parseDouble(downstreamLanUseSceVos.get(i).getFldFarmArea());
				}
			}
			modelMap.addAttribute("projectId", projectId);
			modelMap.addAttribute("value1", upStramFarmArea);// 上游耕地面积
			modelMap.addAttribute("value2", midStreamFarmArea);// 中游耕地面积
			modelMap.addAttribute("value3", midStreamWetLand);// 中游湿地面积
			modelMap.addAttribute("value4", midStreamsprink);// 中游滴灌面积
			modelMap.addAttribute("value5", downStreamFarmArea);// 下游耕地面积
			modelMap.addAttribute("value6", midAndDownStreamPercentPara.getMidstreamPercent());// 中游分水量
			modelMap.addAttribute("value7", midAndDownStreamPercentPara.getDownstreamPercent());// 下游分水量
			return "GIS.ftl";
		} catch (NullPointerException e) {
			String projectId = userProjectRelationService
					.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
			modelMap.addAttribute("projectId", projectId);
			modelMap.addAttribute("value1", 252);// 上游耕地面积
			modelMap.addAttribute("value2", 306);// 中游耕地面积
			modelMap.addAttribute("value3", 198);// 中游湿地面积
			modelMap.addAttribute("value4", 165);// 中游滴灌面积
			modelMap.addAttribute("value5", 305);// 下游耕地面积
			modelMap.addAttribute("value6", 188);// 中游分水量
			modelMap.addAttribute("value7", 188);// 下游分水量
			return "GIS.ftl";
		}

	}

//	@ResponseBody
//	@RequestMapping(value = "saveGisEcharts", method = RequestMethod.POST)
//	public BaseMsg saveGisEcharts(String years, String results) {
//		List<String> years2 = JSON.parseArray(years, String.class);
//		List<Gisecharts> result = JSON.parseArray(results, Gisecharts.class);
//		for (int i = 0; i < years2.size(); i++) {
//			gisService.deleteGisecharts(years2.get(i));
//			gisService.addGisecharts(years2.get(i), result.get(i).getResultOverall(), result.get(i).getResultP1(),
//					result.get(i).getResultP2(), result.get(i).getResultP3());
//		}
//		gisService.updateDevelop();
//		gisService.updateGisIndex();
//		gisService.updateThreeindex();
//		return new BaseMsg(true, "指标计算成功！");
//	}

	@ResponseBody
	@RequestMapping(value = "getyears", method = RequestMethod.GET)
	public List<String> getyears(){
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		String projectId = userProjectRelation.getAutoProjectId();
		System.out.println(projectId);
		return gisService.getyears(projectId);
	}
	@ResponseBody
	@RequestMapping(value = "getGisEcharts", method = RequestMethod.GET)
	public List<AssessResult> getGisEcharts(String year) {
//		return gisService.getAllGisecharts();
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		String projectId = userProjectRelation.getAutoProjectId();
		return gisService.getScore(projectId,year);
	}

	/**
	 * 接收从GIS情景控制传来的全局变量
	 * 
	 * @param projectId
	 *            项目代码【为null时值为默认项目id】
	 * @param upstreamCultivatedArea
	 *            上游耕地面积
	 * @param midstreamWater
	 *            中游分水量
	 * @param downstreamWater
	 *            下游分水量
	 * @param midStreamCultivatedArea
	 *            中游耕地面积
	 * @param midStreamWetLandArea
	 *            中游湿地面积
	 * @param midStreamDripIrrigation
	 *            中游滴灌面积
	 * @param downStreamCultivatedArea
	 *            下游耕地面积
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "stuationControl", method = RequestMethod.GET)
	public BaseMsg stuationControl(String projectId, String upstreamCultivatedArea, String midstreamWater,
			String downstreamWater, String midStreamCultivatedArea, String midStreamWetLandArea,
			String midStreamDripIrrigation, String downStreamCultivatedArea) {
		try {

			if (projectId == null) {
				projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId())
						.getAutoProjectId();
			}
			System.out.println(projectId + "," + upstreamCultivatedArea + "," + midstreamWater + "," + downstreamWater
					+ "," + midStreamCultivatedArea + "," + midStreamWetLandArea + "," + midStreamDripIrrigation + ","
					+ downStreamCultivatedArea);
			// 上游【耕地面积、湿地面积】
			List<StreamLanUseSceVo> upstreamLanUseSceVos = streamLanUseSceVoDao.getStreamLanUseSceVo("upstream");
			// 中游【耕地面积、湿地面积】
			List<StreamLanUseSceVo> midstreamLanUseSceVos = streamLanUseSceVoDao.getStreamLanUseSceVo("midstream");
			// 下游【耕地面积、湿地面积】
			List<StreamLanUseSceVo> downstreamLanUseSceVos = streamLanUseSceVoDao.getStreamLanUseSceVo("downstream");
			// 中下游分水量
			MidAndDownStreamPercentPara midAndDownStreamPercentPara = watershedParaDao
					.getMidAndDownStreamPercentPara(projectId);
			// 中游滴灌面积
			List<TbSocioEconomyScePara> midStreamTbSocioEconomyScePara = watershedParaDao
					.getmidStreamSocioEconomyScePara(projectId);

			// 上游耕地面积和

			if (upstreamLanUseSceVos != null) {
				double upStramFarmArea = 0;
				for (int i = 0; i < upstreamLanUseSceVos.size(); i++) {
					upStramFarmArea = upStramFarmArea
							+ Double.parseDouble(upstreamLanUseSceVos.get(i).getFldFarmArea());
				}
				for (int i = 0; i < upstreamLanUseSceVos.size(); i++) {
					double percentArea = (Double.parseDouble(upstreamLanUseSceVos.get(i).getFldFarmArea())
							/ upStramFarmArea) * Double.parseDouble(upstreamCultivatedArea);
					CountryIdAndFarmAreaVo countryIdAndFarmAreaVo = new CountryIdAndFarmAreaVo();
					countryIdAndFarmAreaVo.setCountryId(upstreamLanUseSceVos.get(i).getCountryId());
					countryIdAndFarmAreaVo.setProjectId(projectId);
					countryIdAndFarmAreaVo.setFarmArea(String.valueOf(percentArea));
					gisDao.updateLandUseArea(countryIdAndFarmAreaVo);
				}
			}

			// 中游耕地耕地面积和，中游湿地面积和
			if (midstreamLanUseSceVos != null) {
				double midStreamFarmArea = 0, midStreamWetLand = 0;
				for (int i = 0; i < midstreamLanUseSceVos.size(); i++) {
					midStreamFarmArea = midStreamFarmArea
							+ Double.parseDouble(midstreamLanUseSceVos.get(i).getFldFarmArea());
					midStreamWetLand = midStreamWetLand
							+ Double.parseDouble(midstreamLanUseSceVos.get(i).getWetlandArea());
				}
				System.out.println("baijw midStreamFarmArea:" + midStreamFarmArea + "," + midStreamWetLand);
				// List<CountryIdAndFarmAreaVo> CountryIdAndFarmAreaVos1 = new
				// ArrayList<CountryIdAndFarmAreaVo>();
				for (int i = 0; i < midstreamLanUseSceVos.size(); i++) {
					double percentArea = (Double.parseDouble(midstreamLanUseSceVos.get(i).getFldFarmArea())
							/ midStreamFarmArea) * Double.parseDouble(midStreamCultivatedArea);
					double percentwet = (Double.parseDouble(midstreamLanUseSceVos.get(i).getWetlandArea())
							/ midStreamWetLand) * Double.parseDouble(midStreamWetLandArea);
					CountryIdAndFarmAreaVo countryIdAndFarmAreaVo = new CountryIdAndFarmAreaVo();
					countryIdAndFarmAreaVo.setProjectId(projectId);
					countryIdAndFarmAreaVo.setCountryId(midstreamLanUseSceVos.get(i).getCountryId());
					countryIdAndFarmAreaVo.setFarmArea(percentArea + "");
					countryIdAndFarmAreaVo.setWetLand(percentwet + "");
					// CountryIdAndFarmAreaVos1.add(countryIdAndFarmAreaVo);
					System.out.println(percentArea + "," + percentwet);
					gisDao.updateLandUseArea(countryIdAndFarmAreaVo);
				}
			}

			// 中游滴灌面积和
			if (midStreamTbSocioEconomyScePara != null) {
				double midStreamsprink = 0;
				for (int i = 0; i < midStreamTbSocioEconomyScePara.size(); i++) {
					midStreamsprink = midStreamsprink
							+ Double.parseDouble(midStreamTbSocioEconomyScePara.get(i).getFldSprinkingArea());
				}
				// List<CountryIdAndFarmAreaVo> CountryIdAndFarmAreaVos2 = new
				// ArrayList<CountryIdAndFarmAreaVo>();
				for (int i = 0; i < midStreamTbSocioEconomyScePara.size(); i++) {
					double percentArea = (Double
							.parseDouble(midStreamTbSocioEconomyScePara.get(i).getFldSprinkingArea()) / midStreamsprink)
							* Double.parseDouble(midStreamDripIrrigation);
					CountryIdAndFarmAreaVo countryIdAndFarmAreaVo = new CountryIdAndFarmAreaVo();
					countryIdAndFarmAreaVo.setProjectId(projectId);
					countryIdAndFarmAreaVo.setCountryId(midStreamTbSocioEconomyScePara.get(i).getCountryId());
					countryIdAndFarmAreaVo.setSprinkArea(percentArea + "");
					// CountryIdAndFarmAreaVos2.add(countryIdAndFarmAreaVo);
					gisDao.updateSprinkArea(countryIdAndFarmAreaVo);
				}
			}

			// 下游耕地面积和
			if (downstreamLanUseSceVos != null) {
				double downStreamFarmArea = 0;
				for (int i = 0; i < downstreamLanUseSceVos.size(); i++) {
					downStreamFarmArea = downStreamFarmArea
							+ Double.parseDouble(downstreamLanUseSceVos.get(i).getFldFarmArea());
				}
				// List<CountryIdAndFarmAreaVo> CountryIdAndFarmAreaVos3 = new
				// ArrayList<CountryIdAndFarmAreaVo>();
				for (int i = 0; i < downstreamLanUseSceVos.size(); i++) {
					double percentArea = (Double.parseDouble(downstreamLanUseSceVos.get(i).getFldFarmArea())
							/ downStreamFarmArea) * Double.parseDouble(downStreamCultivatedArea);
					CountryIdAndFarmAreaVo countryIdAndFarmAreaVo = new CountryIdAndFarmAreaVo();
					countryIdAndFarmAreaVo.setCountryId(downstreamLanUseSceVos.get(i).getCountryId());
					countryIdAndFarmAreaVo.setProjectId(projectId);
					countryIdAndFarmAreaVo.setFarmArea(String.valueOf(percentArea));
					// CountryIdAndFarmAreaVos3.add(countryIdAndFarmAreaVo);
					gisDao.updateLandUseArea(countryIdAndFarmAreaVo);
				}
			}

			/**
			 * 更新中下游分水量
			 */
			watershedParaDao.deleteMidAndDownStreamPercentPara(projectId);
			midAndDownStreamPercentPara.setMidstreamPercent(Double.parseDouble(midstreamWater));
			midAndDownStreamPercentPara.setDownstreamPercent(Double.parseDouble(downstreamWater));
			watershedParaDao.addMidAndDownStreamPercentPara(midAndDownStreamPercentPara);
			return new BaseMsg(true, "情景控制保存成功");
		} catch (NullPointerException e) {
			return new BaseMsg(false, "您没有权限！");
		}

	}

}
