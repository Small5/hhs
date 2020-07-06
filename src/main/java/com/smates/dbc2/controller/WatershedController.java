package com.smates.dbc2.controller;

import java.io.IOException;
import java.util.List;

import com.smates.dbc2.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.smates.dbc2.service.ModelService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.service.ProjectService;
import com.smates.dbc2.service.UserWatershedRelationService;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.DataGrideRow;

/**
 * 流域相关controller
 *
 * @author baijw and March
 *
 */
@Controller
public class WatershedController extends BaseController {
	@Autowired
	public UserService userService;
	@Autowired
	private ModelService modelservice;
	@Autowired
	private ProjectService projectService;
	//定义全局流域ID
	public String watershedid;

	/**
	 * 添加流域信息
	 *
	 * @param name
	 *            流域名称
	 * @param describe
	 *            流域描述
	 * @param tblClimateScenarioYear
	 *            气候情景数据表(年)
	 * @param tblClimateScenarioMonth
	 *            气候情景数据表(月)
	 * @param tblLandUseSce
	 *            土地种类
	 * @param tblCropPattern
	 *            种植结构数据表
	 * @param tblSocioEconSce
	 *            GDP数据
	 * @param tblPrefPolicy
	 *            优惠政策表
	 * @param tblHydrEngineering
	 *            水利工程数据
	 * @param tblWaterResManSce
	 *            水资源面积
	 * @param tblWaterUseCounty
	 *            县区三产用水量
	 * @param tblWaterRightCounty
	 *            县区水权分配
	 * @param tblMidDownWaterAllo
	 *            流域中下游水分配
	 * @param tblWaterAlloCounty
	 *            县区用水量
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "addWatershed", method = RequestMethod.POST)
	public String addWatershed(ModelMap modelMap,String id, String name, String describe, MultipartFile tblClimateScenarioYear,
							   MultipartFile tblClimateScenarioMonth, MultipartFile tblLandUseSce,
							   MultipartFile tblCropPattern, MultipartFile tblSocioEconSce, MultipartFile tblPrefPolicy,
							   MultipartFile tblHydrEngineering, MultipartFile tblWaterResManSce, MultipartFile tblWaterUseCounty,
							   MultipartFile tblWaterRightCounty, MultipartFile tblMidDownWaterAllo, MultipartFile tblWaterAlloCounty)
			throws IOException {
		System.out.println(id+"  "+name+"  "+describe);


		// 保存流域基本信息(流域名,流域描述)
		String username = userService.getCurrentUserId();
		watershedService.addWatershedInfo(username,id, name, describe);
		// 解析excel表格并存储
		StoreExcelData(id, tblClimateScenarioYear, tblClimateScenarioMonth, tblLandUseSce,
				tblCropPattern, tblSocioEconSce, tblPrefPolicy, tblHydrEngineering, tblWaterResManSce,
				tblWaterUseCounty, tblWaterRightCounty, tblMidDownWaterAllo, tblWaterAlloCounty);

		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("title", chineseAndEnglishService.getPhraseByIndexAndLanguage(3, userLanguage));
		modelMap.addAttribute("basin", chineseAndEnglishService.getPhraseByIndexAndLanguage(26, userLanguage));
		modelMap.addAttribute("keyword", chineseAndEnglishService.getPhraseByIndexAndLanguage(27, userLanguage));
		modelMap.addAttribute("find", chineseAndEnglishService.getPhraseByIndexAndLanguage(28, userLanguage));
		modelMap.addAttribute("new", chineseAndEnglishService.getPhraseByIndexAndLanguage(29, userLanguage));
		modelMap.addAttribute("basinid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(31, userLanguage));
		modelMap.addAttribute("operation", chineseAndEnglishService.getPhraseByIndexAndLanguage(32, userLanguage));
		modelMap.addAttribute("delete", chineseAndEnglishService.getPhraseByIndexAndLanguage(33, userLanguage));
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
		modelMap.addAttribute("sdb", chineseAndEnglishService.getPhraseByIndexAndLanguage(35, userLanguage));

		return "watershedList.ftl";
	}

	/**
	 * 更改流域信息
	 *
	 * @return
	 */

	@RequestMapping(value = "updateWatershed", method = RequestMethod.POST)
	public String updateWatershed(ModelMap modelMap,String id, String name, String describe, MultipartFile tblClimateScenarioYear,
								  MultipartFile tblClimateScenarioMonth, MultipartFile tblLandUseSce,
								  MultipartFile tblCropPattern, MultipartFile tblSocioEconSce, MultipartFile tblPrefPolicy,
								  MultipartFile tblHydrEngineering, MultipartFile tblWaterResManSce, MultipartFile tblWaterUseCounty,
								  MultipartFile tblWaterRightCounty, MultipartFile tblMidDownWaterAllo, MultipartFile tblWaterAlloCounty)
			throws IOException {

		String username = userService.getCurrentUserId();
		//删除现有流域
		watershedService.deleteWatershed(username,id);
		//添加新流域
		watershedService.addWatershedInfo(username,id, name, describe);

		// 解析excel表格并存储
		StoreExcelData(id, tblClimateScenarioYear, tblClimateScenarioMonth, tblLandUseSce,
				tblCropPattern, tblSocioEconSce, tblPrefPolicy, tblHydrEngineering, tblWaterResManSce,
				tblWaterUseCounty, tblWaterRightCounty, tblMidDownWaterAllo, tblWaterAlloCounty);

		/*userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("title", chineseAndEnglishService.getPhraseByIndexAndLanguage(3, userLanguage));
		modelMap.addAttribute("basin", chineseAndEnglishService.getPhraseByIndexAndLanguage(26, userLanguage));
		modelMap.addAttribute("keyword", chineseAndEnglishService.getPhraseByIndexAndLanguage(27, userLanguage));
		modelMap.addAttribute("find", chineseAndEnglishService.getPhraseByIndexAndLanguage(28, userLanguage));
		modelMap.addAttribute("new", chineseAndEnglishService.getPhraseByIndexAndLanguage(29, userLanguage));
		modelMap.addAttribute("basinid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(31, userLanguage));
		modelMap.addAttribute("operation", chineseAndEnglishService.getPhraseByIndexAndLanguage(32, userLanguage));
		modelMap.addAttribute("delete", chineseAndEnglishService.getPhraseByIndexAndLanguage(33, userLanguage));
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
		modelMap.addAttribute("sdb", chineseAndEnglishService.getPhraseByIndexAndLanguage(35, userLanguage));*/

		return "watershedList.ftl";
	}

	/**
	 * 加载流域信息页面
	 *
	 * @return
	 */
    /**
     * 这里返回的只是页面的一些标识值
     * */
	@RequestMapping(value = "watershedlist", method = RequestMethod.GET)
	public String watershedlist(ModelMap modelMap) {
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("title", chineseAndEnglishService.getPhraseByIndexAndLanguage(3, userLanguage));
		modelMap.addAttribute("basin", chineseAndEnglishService.getPhraseByIndexAndLanguage(26, userLanguage));
		modelMap.addAttribute("keyword", chineseAndEnglishService.getPhraseByIndexAndLanguage(27, userLanguage));
		modelMap.addAttribute("find", chineseAndEnglishService.getPhraseByIndexAndLanguage(28, userLanguage));
		modelMap.addAttribute("new", chineseAndEnglishService.getPhraseByIndexAndLanguage(29, userLanguage));
		modelMap.addAttribute("basinid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(31, userLanguage));
		modelMap.addAttribute("operation", chineseAndEnglishService.getPhraseByIndexAndLanguage(32, userLanguage));
		modelMap.addAttribute("delete", chineseAndEnglishService.getPhraseByIndexAndLanguage(33, userLanguage));
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
		modelMap.addAttribute("sdb", chineseAndEnglishService.getPhraseByIndexAndLanguage(35, userLanguage));
		return "watershedList.ftl";
        //return "home.ftl";
	}
	/**
	 * 加载添加流域信息页面
	 *
	 * @return
	 */

	@RequestMapping(value = "addwatershedpage", method = RequestMethod.GET)
	public String addwatershed(ModelMap modelMap) {
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("add", chineseAndEnglishService.getPhraseByIndexAndLanguage(36, userLanguage));
		modelMap.addAttribute("basinid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("watershedid", chineseAndEnglishService.getPhraseByIndexAndLanguage(37, userLanguage));
		modelMap.addAttribute("basin", chineseAndEnglishService.getPhraseByIndexAndLanguage(26, userLanguage));
		modelMap.addAttribute("basiname", chineseAndEnglishService.getPhraseByIndexAndLanguage(38, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(31, userLanguage));
		modelMap.addAttribute("inputdes", chineseAndEnglishService.getPhraseByIndexAndLanguage(39, userLanguage));
		modelMap.addAttribute("climate", chineseAndEnglishService.getPhraseByIndexAndLanguage(40, userLanguage));
		modelMap.addAttribute("climatey", chineseAndEnglishService.getPhraseByIndexAndLanguage(41, userLanguage));
		modelMap.addAttribute("climatem", chineseAndEnglishService.getPhraseByIndexAndLanguage(42, userLanguage));
		modelMap.addAttribute("land", chineseAndEnglishService.getPhraseByIndexAndLanguage(43, userLanguage));
		modelMap.addAttribute("landtype", chineseAndEnglishService.getPhraseByIndexAndLanguage(44, userLanguage));
		modelMap.addAttribute("planting", chineseAndEnglishService.getPhraseByIndexAndLanguage(45, userLanguage));
		modelMap.addAttribute("economic", chineseAndEnglishService.getPhraseByIndexAndLanguage(46, userLanguage));
		modelMap.addAttribute("gdp", chineseAndEnglishService.getPhraseByIndexAndLanguage(47, userLanguage));
		modelMap.addAttribute("policy", chineseAndEnglishService.getPhraseByIndexAndLanguage(48, userLanguage));
		modelMap.addAttribute("water", chineseAndEnglishService.getPhraseByIndexAndLanguage(49, userLanguage));
		modelMap.addAttribute("resources", chineseAndEnglishService.getPhraseByIndexAndLanguage(50, userLanguage));
		modelMap.addAttribute("areawater", chineseAndEnglishService.getPhraseByIndexAndLanguage(51, userLanguage));
		modelMap.addAttribute("three", chineseAndEnglishService.getPhraseByIndexAndLanguage(52, userLanguage));
		modelMap.addAttribute("right", chineseAndEnglishService.getPhraseByIndexAndLanguage(53, userLanguage));
		modelMap.addAttribute("middle", chineseAndEnglishService.getPhraseByIndexAndLanguage(54, userLanguage));
		modelMap.addAttribute("consumption", chineseAndEnglishService.getPhraseByIndexAndLanguage(55, userLanguage));
		modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(24, userLanguage));
		modelMap.addAttribute("reset", chineseAndEnglishService.getPhraseByIndexAndLanguage(25, userLanguage));

		return "AddWatershed.ftl";
        //return "home.ftl";
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 根据用户输入的流域名称返回查找的结果
	 *
	 * @param page
	 *            显示的页码
	 * @param name
	 *            流域名称
	 * @param rows
	 *            每页显示的个数
	 * @return 格式化后的流域信息
	 */
    /** 这里才是返回的所有流域的信息，放在格式化的表格里*/
	@ResponseBody
	@RequestMapping(value = "getWatershedByName", method = RequestMethod.GET)
	public DataGrideRow<Watershed> getWatershedByName(@RequestParam(defaultValue = "1") int page, String name,
													  int rows) {
		return watershedService.getWatershedFormateDataGride(userService.getCurrentUserId(), name, page, rows);
	}
	/**
	 * 返回用户的所有流域信息，
	 * @param username
	 * @return */
	@ResponseBody
	@RequestMapping(value = "getwatershedbyUser", method = RequestMethod.GET)
	public List<Watershed> watershedList(String username){
		System.err.println(watershedService.watershedlist(userService.getCurrentUserId()).toString());
		//System.err.println(userService.getCurrentUserId());
		//List<Project> projectlist = projectService.getProjectByUser(userService.getCurrentUserId());
		List<Watershed> watershedlist =  watershedService.watershedlist(userService.getCurrentUserId());
		return watershedlist;
	}

	/**
	 * 返回用户的所有流域名称，
	 * @param username
	 * @return */
	@ResponseBody
	@RequestMapping(value = "getwatershednamebyUser", method = RequestMethod.GET)
	public List<String> watershednameList(String username){
		System.err.println("jieguo:" + watershedService.watershednamelist(userService.getCurrentUserId()).toString());
		System.err.println(userService.getCurrentUserId());

		List<String> watershedlist =  watershedService.watershednamelist(userService.getCurrentUserId());
		return watershedlist;
	}
	/**
	 * 编辑流域
	 * @param modelMap
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "watershededit", method = RequestMethod.GET)
	public BaseMsg Watershededit(ModelMap modelMap,String id) {
		watershedid = id;
//		System.err.println(watershedid);
//		modelMap.addAttribute("watershed", watershedService.watershed(userService.getCurrentUserId(), id));
		return new BaseMsg(true, "确定要编辑该流域吗？");
	}
	@ResponseBody
	@RequestMapping(value = "watershedMsg", method = RequestMethod.GET)
	public Watershed Watershededit() {
		Watershed watershed = watershedService.watershed(userService.getCurrentUserId(), watershedid);
		System.err.println(watershed.toString());
//		System.err.println(watershedid);
//		modelMap.addAttribute("watershed", watershedService.watershed(userService.getCurrentUserId(), id));
		return watershed;
	}

	/**
	 * 跳转到编辑流域界面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "jumpToWatershededit", method = RequestMethod.GET)
	public String ToWatershededit(ModelMap modelMap) {
		modelMap.addAttribute("watershed", watershedService.watershed(userService.getCurrentUserId(), watershedid));
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(66, userLanguage));
		modelMap.addAttribute("basinid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("watershedid", chineseAndEnglishService.getPhraseByIndexAndLanguage(37, userLanguage));
		modelMap.addAttribute("basin", chineseAndEnglishService.getPhraseByIndexAndLanguage(26, userLanguage));
		modelMap.addAttribute("basiname", chineseAndEnglishService.getPhraseByIndexAndLanguage(38, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(31, userLanguage));
		modelMap.addAttribute("inputdes", chineseAndEnglishService.getPhraseByIndexAndLanguage(39, userLanguage));
		modelMap.addAttribute("climate", chineseAndEnglishService.getPhraseByIndexAndLanguage(40, userLanguage));
		modelMap.addAttribute("climatey", chineseAndEnglishService.getPhraseByIndexAndLanguage(41, userLanguage));
		modelMap.addAttribute("climatem", chineseAndEnglishService.getPhraseByIndexAndLanguage(42, userLanguage));
		modelMap.addAttribute("land", chineseAndEnglishService.getPhraseByIndexAndLanguage(43, userLanguage));
		modelMap.addAttribute("landtype", chineseAndEnglishService.getPhraseByIndexAndLanguage(44, userLanguage));
		modelMap.addAttribute("planting", chineseAndEnglishService.getPhraseByIndexAndLanguage(45, userLanguage));
		modelMap.addAttribute("economic", chineseAndEnglishService.getPhraseByIndexAndLanguage(46, userLanguage));
		modelMap.addAttribute("gdp", chineseAndEnglishService.getPhraseByIndexAndLanguage(47, userLanguage));
		modelMap.addAttribute("policy", chineseAndEnglishService.getPhraseByIndexAndLanguage(48, userLanguage));
		modelMap.addAttribute("water", chineseAndEnglishService.getPhraseByIndexAndLanguage(49, userLanguage));
		modelMap.addAttribute("resources", chineseAndEnglishService.getPhraseByIndexAndLanguage(50, userLanguage));
		modelMap.addAttribute("areawater", chineseAndEnglishService.getPhraseByIndexAndLanguage(51, userLanguage));
		modelMap.addAttribute("three", chineseAndEnglishService.getPhraseByIndexAndLanguage(52, userLanguage));
		modelMap.addAttribute("right", chineseAndEnglishService.getPhraseByIndexAndLanguage(53, userLanguage));
		modelMap.addAttribute("middle", chineseAndEnglishService.getPhraseByIndexAndLanguage(54, userLanguage));
		modelMap.addAttribute("consumption", chineseAndEnglishService.getPhraseByIndexAndLanguage(55, userLanguage));
		modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(24, userLanguage));
		modelMap.addAttribute("reset", chineseAndEnglishService.getPhraseByIndexAndLanguage(25, userLanguage));
		return "watershededit.ftl";
	}

	/**
	 * 删除一条流域信息
	 *
	 * @param id
	 *            流域id
	 */
	@ResponseBody
	@RequestMapping(value = "deleteWatershed", method = RequestMethod.GET)
	public BaseMsg deleteWatershed(String id) {
		String username = userService.getCurrentUserId();
		watershedService.deleteWatershed(username,id);
		return new BaseMsg(true, "删除成功");
	}

	/**
	 * 将某个流域设置为默认流域
	 * @param id 流域id
	 * @return 是否设置成功
	 */
	@ResponseBody
	@RequestMapping(value = "autowatershed",method=RequestMethod.GET)
	public BaseMsg autoproject(String id){
		String username = userService.getCurrentUserId();//获取当前登录的用户账号

		userWatershedRelationService.addUserWatershedRelation(username, id);
		return new BaseMsg(true, "设置默认流域成功");
	}

	/**
	 * 根据用户输入的气候情景排放类型返回List<TblClimateScenarioYear>
	 *
	 * @param fldCRPType
	 *            气候情景排放类型
	 * @return List<TblClimateScenarioYear>的json格式数据
	 */
	@ResponseBody
	@RequestMapping(value = "geTblClimateScenarioYearsByfldCRPType", method = RequestMethod.GET)
	public List<TblClimateScenarioYear> geTblClimateScenarioYearsByfldCRPType(String fldCRPType, String countryId) {
		String username = userService.getCurrentUserId();
		return watershedService.getTblClimateScenarioYearsByfldCRPType(username,fldCRPType, countryId);
	}

	/*新：获取气候情景图标数据*/
	@ResponseBody
	@RequestMapping(value = "getClimateScenarioByUsername", method = RequestMethod.GET)
	public List<ClimateScenario> getClimateScenarioByUsername(String countyId){
		String username = userService.getCurrentUserId();
		return watershedService.getClimateScenarioByUsername(username,countyId);
	}

	/**
	 * 根据县区代码查找产业与城市发展情景 返回List<TblIndustyUrbanSce>
	 *
	 * @param fldCountyCode
	 *            县区代码
	 * @return List<TblIndustyUrbanSce>的json格式数据
	 */
	@ResponseBody
	@RequestMapping(value = "getTblIndustyUrbanSceByfldCountyCode", method = RequestMethod.GET)
	public List<TblIndustyUrbanSce> getTblIndustyUrbanSceByfldCountyCode(String fldCountyCode) {
		String username = userService.getCurrentUserId();
		return watershedService.getTblIndustyUrbanSceByfldCountyCode(username,fldCountyCode);
	}

//	@ResponseBody
//	@RequestMapping(value = "getTblIndustyUrbanSceByfldCountyCode", method = RequestMethod.GET)
//	public List<Watershed> watershedlist(){
//		String username = userService.getCurrentUserId();
////		System.out.println(watershedService.watershedlist(username));
//		return watershedService.watershedlist(username);
//	}

	/**
	 * 根据县区代码查找GDP发展数据表
	 *
	 * @param fldCountyCode
	 *            县区代码
	 * @return List<TblSocioEconSce>的json格式数据
	 */
	@ResponseBody
	@RequestMapping(value = "getTblSocioEconSceByfldCountyCode", method = RequestMethod.GET)
	public List<TblSocioEconSce> getTblSocioEconSceByfldCountyCode(String fldCountyCode) {
		return watershedService.getTblSocioEconSceByfldCountyCode(fldCountyCode);
	}

	/**
	 * 根据县区代码查找水利工程数据表
	 *
	 * @param fldCountyCode
	 *            县区代码
	 * @return List<TblHydrEngineering>的json格式数据
	 */
	@ResponseBody
	@RequestMapping(value = "getTblHydrEngineeringByfldCountyCode", method = RequestMethod.GET)
	public List<TblHydrEngineering> getTblHydrEngineeringByfldCountyCode(String fldCountyCode) {
		String username = userService.getCurrentUserId();
		return watershedService.getTblHydrEngineeringByfldCountyCode(username,fldCountyCode);
	}

	/**
	 * 根据县区代码查找土地类型数据表
	 *
	 * @param fldCountyCode
	 *            县区代码
	 * @return List<TblLandUseSce>的json格式数据
	 */
	@ResponseBody
	@RequestMapping(value = "getTblLandUseSceByfldCountyCode", method = RequestMethod.GET)
	public List<TbLanduseScePara> getTblLandUseSceByfldCountyCode(String fldCountyCode) {
		String username = userService.getCurrentUserId();
		return watershedService.getTblLandUseSceByfldCountyCode(username,fldCountyCode);
	}

	/**
	 * 根据县区代码查找种植结构数据表
	 *
	 * @param fldCountyCode
	 *            县区代码
	 * @return List<TblCropPattern>的json格式数据
	 */
	@ResponseBody
	@RequestMapping(value = "getTblCropPatternByfldCountyCode", method = RequestMethod.GET)
	public List<TblCropPattern> getTblCropPatternByfldCountyCode(String fldCountyCode) {
		return watershedService.getTblCropPatternByfldCountyCode(fldCountyCode);
	}
	/**
	 * 查找流域中下游水分配表
	 *
	 * @param
	 *
	 * @return List<TblMidDownWaterAllo>的json格式数据
	 */
	@ResponseBody
	@RequestMapping(value = "getTblMidDownWaterAllo", method = RequestMethod.GET)
	public List<TblMidDownWaterAllo> getTblMidDownWaterAllo() {

		return watershedService.getTblMidDownWaterAllo();
	}

	@RequestMapping(value = "jumpToAbstract", method = RequestMethod.GET)
	public String jumpToAbstract(ModelMap modelMap, String projectId) {
		if(projectId == null){
			projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		}
		modelMap.addAttribute("projectId", projectId);
		return "abstract.ftl";
	}

	@RequestMapping(value = "jumpToResult", method = RequestMethod.GET)
	public String jumpToResult(ModelMap modelMap) {

		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();

		String goalyear = modelservice.getgoalyear(projectId);
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("projectId", projectId);
		modelMap.addAttribute("system", chineseAndEnglishService.getPhraseByIndexAndLanguage(1, userLanguage));
		modelMap.addAttribute("goal", chineseAndEnglishService.getPhraseByIndexAndLanguage(89, userLanguage));
		modelMap.addAttribute("scene", chineseAndEnglishService.getPhraseByIndexAndLanguage(90, userLanguage));
		modelMap.addAttribute("scene1", chineseAndEnglishService.getPhraseByIndexAndLanguage(91, userLanguage));
		modelMap.addAttribute("abstract", chineseAndEnglishService.getPhraseByIndexAndLanguage(178, userLanguage));
		modelMap.addAttribute("monidata", chineseAndEnglishService.getPhraseByIndexAndLanguage(179, userLanguage));
		modelMap.addAttribute("pinggu", chineseAndEnglishService.getPhraseByIndexAndLanguage(180, userLanguage));
		modelMap.addAttribute("juece", chineseAndEnglishService.getPhraseByIndexAndLanguage(181, userLanguage));
		modelMap.addAttribute("yanjiu", chineseAndEnglishService.getPhraseByIndexAndLanguage(182, userLanguage));
		modelMap.addAttribute("heihe", chineseAndEnglishService.getPhraseByIndexAndLanguage(4, userLanguage));
		modelMap.addAttribute("project", chineseAndEnglishService.getPhraseByIndexAndLanguage(183, userLanguage));
		modelMap.addAttribute("county", chineseAndEnglishService.getPhraseByIndexAndLanguage(144, userLanguage));
		modelMap.addAttribute("climate", chineseAndEnglishService.getPhraseByIndexAndLanguage(40, userLanguage));
		modelMap.addAttribute("land", chineseAndEnglishService.getPhraseByIndexAndLanguage(43, userLanguage));
		modelMap.addAttribute("soc", chineseAndEnglishService.getPhraseByIndexAndLanguage(142, userLanguage));
		modelMap.addAttribute("water", chineseAndEnglishService.getPhraseByIndexAndLanguage(50, userLanguage));
		modelMap.addAttribute("rain", chineseAndEnglishService.getPhraseByIndexAndLanguage(145, userLanguage));
		modelMap.addAttribute("temp", chineseAndEnglishService.getPhraseByIndexAndLanguage(146, userLanguage));
		modelMap.addAttribute("gengdi", chineseAndEnglishService.getPhraseByIndexAndLanguage(184, userLanguage));
		modelMap.addAttribute("jiegou", chineseAndEnglishService.getPhraseByIndexAndLanguage(185, userLanguage));
		modelMap.addAttribute("popo", chineseAndEnglishService.getPhraseByIndexAndLanguage(164, userLanguage));
		modelMap.addAttribute("aptr", chineseAndEnglishService.getPhraseByIndexAndLanguage(165, userLanguage));
		modelMap.addAttribute("itpr", chineseAndEnglishService.getPhraseByIndexAndLanguage(166, userLanguage));
		modelMap.addAttribute("sitpr", chineseAndEnglishService.getPhraseByIndexAndLanguage(167, userLanguage));
		modelMap.addAttribute("urpar", chineseAndEnglishService.getPhraseByIndexAndLanguage(332, userLanguage));
		modelMap.addAttribute("shang", chineseAndEnglishService.getPhraseByIndexAndLanguage(169, userLanguage));
		modelMap.addAttribute("e", chineseAndEnglishService.getPhraseByIndexAndLanguage(170, userLanguage));
		modelMap.addAttribute("xia", chineseAndEnglishService.getPhraseByIndexAndLanguage(171, userLanguage));
		modelMap.addAttribute("drink", chineseAndEnglishService.getPhraseByIndexAndLanguage(172, userLanguage));
		modelMap.addAttribute("dbw", chineseAndEnglishService.getPhraseByIndexAndLanguage(173, userLanguage));
		modelMap.addAttribute("dxw", chineseAndEnglishService.getPhraseByIndexAndLanguage(174, userLanguage));
		modelMap.addAttribute("fn", chineseAndEnglishService.getPhraseByIndexAndLanguage(175, userLanguage));
		modelMap.addAttribute("geng", chineseAndEnglishService.getPhraseByIndexAndLanguage(150, userLanguage));
		modelMap.addAttribute("lin", chineseAndEnglishService.getPhraseByIndexAndLanguage(151, userLanguage));
		modelMap.addAttribute("cao", chineseAndEnglishService.getPhraseByIndexAndLanguage(152, userLanguage));
		modelMap.addAttribute("shui", chineseAndEnglishService.getPhraseByIndexAndLanguage(153, userLanguage));
		modelMap.addAttribute("luo", chineseAndEnglishService.getPhraseByIndexAndLanguage(154, userLanguage));
		modelMap.addAttribute("cheng", chineseAndEnglishService.getPhraseByIndexAndLanguage(155, userLanguage));
		modelMap.addAttribute("mai", chineseAndEnglishService.getPhraseByIndexAndLanguage(156, userLanguage));
		modelMap.addAttribute("yu", chineseAndEnglishService.getPhraseByIndexAndLanguage(157, userLanguage));
		modelMap.addAttribute("you", chineseAndEnglishService.getPhraseByIndexAndLanguage(158, userLanguage));
		modelMap.addAttribute("shu", chineseAndEnglishService.getPhraseByIndexAndLanguage(159, userLanguage));
		modelMap.addAttribute("guo", chineseAndEnglishService.getPhraseByIndexAndLanguage(160, userLanguage));
		modelMap.addAttribute("mian", chineseAndEnglishService.getPhraseByIndexAndLanguage(161, userLanguage));
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
		modelMap.addAttribute("quanliuyu", chineseAndEnglishService.getPhraseByIndexAndLanguage(227, userLanguage));
		modelMap.addAttribute("upstream", chineseAndEnglishService.getPhraseByIndexAndLanguage(228, userLanguage));
		modelMap.addAttribute("mal", chineseAndEnglishService.getPhraseByIndexAndLanguage(229, userLanguage));
		modelMap.addAttribute("qilian", chineseAndEnglishService.getPhraseByIndexAndLanguage(230, userLanguage));
		modelMap.addAttribute("startmodel", chineseAndEnglishService.getPhraseByIndexAndLanguage(231, userLanguage));
		modelMap.addAttribute("selpar", chineseAndEnglishService.getPhraseByIndexAndLanguage(232, userLanguage));
		modelMap.addAttribute("model1", chineseAndEnglishService.getPhraseByIndexAndLanguage(233, userLanguage));
		modelMap.addAttribute("model2", chineseAndEnglishService.getPhraseByIndexAndLanguage(234, userLanguage));
		modelMap.addAttribute("model3", chineseAndEnglishService.getPhraseByIndexAndLanguage(235, userLanguage));
		modelMap.addAttribute("model4", chineseAndEnglishService.getPhraseByIndexAndLanguage(236, userLanguage));
		modelMap.addAttribute("model5", chineseAndEnglishService.getPhraseByIndexAndLanguage(237, userLanguage));
		modelMap.addAttribute("model6", chineseAndEnglishService.getPhraseByIndexAndLanguage(238, userLanguage));
		modelMap.addAttribute("Status", chineseAndEnglishService.getPhraseByIndexAndLanguage(265, userLanguage));
		modelMap.addAttribute("Used", chineseAndEnglishService.getPhraseByIndexAndLanguage(266, userLanguage));
		modelMap.addAttribute("second", chineseAndEnglishService.getPhraseByIndexAndLanguage(267, userLanguage));
		modelMap.addAttribute("SSR", chineseAndEnglishService.getPhraseByIndexAndLanguage(268, userLanguage));
		modelMap.addAttribute("SR", chineseAndEnglishService.getPhraseByIndexAndLanguage(179, userLanguage));
		modelMap.addAttribute("download", chineseAndEnglishService.getPhraseByIndexAndLanguage(269, userLanguage));
		modelMap.addAttribute("index", chineseAndEnglishService.getPhraseByIndexAndLanguage(270, userLanguage));
		modelMap.addAttribute("index1", chineseAndEnglishService.getPhraseByIndexAndLanguage(271, userLanguage));
		modelMap.addAttribute("index2", chineseAndEnglishService.getPhraseByIndexAndLanguage(272, userLanguage));
		modelMap.addAttribute("index3", chineseAndEnglishService.getPhraseByIndexAndLanguage(273, userLanguage));
		modelMap.addAttribute("index4", chineseAndEnglishService.getPhraseByIndexAndLanguage(274, userLanguage));
		modelMap.addAttribute("index5", chineseAndEnglishService.getPhraseByIndexAndLanguage(275, userLanguage));
		modelMap.addAttribute("index6", chineseAndEnglishService.getPhraseByIndexAndLanguage(276, userLanguage));
		modelMap.addAttribute("index7", chineseAndEnglishService.getPhraseByIndexAndLanguage(277, userLanguage));
		modelMap.addAttribute("index8", chineseAndEnglishService.getPhraseByIndexAndLanguage(278, userLanguage));
		modelMap.addAttribute("index9", chineseAndEnglishService.getPhraseByIndexAndLanguage(279, userLanguage));
		modelMap.addAttribute("index10", chineseAndEnglishService.getPhraseByIndexAndLanguage(280, userLanguage));
		modelMap.addAttribute("index11", chineseAndEnglishService.getPhraseByIndexAndLanguage(281, userLanguage));
		modelMap.addAttribute("index12", chineseAndEnglishService.getPhraseByIndexAndLanguage(282, userLanguage));
		modelMap.addAttribute("index13", chineseAndEnglishService.getPhraseByIndexAndLanguage(283, userLanguage));
		modelMap.addAttribute("index14", chineseAndEnglishService.getPhraseByIndexAndLanguage(284, userLanguage));
		modelMap.addAttribute("index15", chineseAndEnglishService.getPhraseByIndexAndLanguage(285, userLanguage));
		modelMap.addAttribute("index16", chineseAndEnglishService.getPhraseByIndexAndLanguage(286, userLanguage));
		modelMap.addAttribute("index17", chineseAndEnglishService.getPhraseByIndexAndLanguage(287, userLanguage));
		modelMap.addAttribute("index18", chineseAndEnglishService.getPhraseByIndexAndLanguage(288, userLanguage));
		modelMap.addAttribute("index19", chineseAndEnglishService.getPhraseByIndexAndLanguage(289, userLanguage));
		modelMap.addAttribute("index20", chineseAndEnglishService.getPhraseByIndexAndLanguage(290, userLanguage));
		modelMap.addAttribute("index21", chineseAndEnglishService.getPhraseByIndexAndLanguage(291, userLanguage));
		modelMap.addAttribute("index22", chineseAndEnglishService.getPhraseByIndexAndLanguage(292, userLanguage));
		modelMap.addAttribute("duo", chineseAndEnglishService.getPhraseByIndexAndLanguage(293, userLanguage));
		modelMap.addAttribute("selecta", chineseAndEnglishService.getPhraseByIndexAndLanguage(294, userLanguage));
		modelMap.addAttribute("pen", chineseAndEnglishService.getPhraseByIndexAndLanguage(295, userLanguage));
		modelMap.addAttribute("ctst", chineseAndEnglishService.getPhraseByIndexAndLanguage(296, userLanguage));
		modelMap.addAttribute("testcontinue", chineseAndEnglishService.getPhraseByIndexAndLanguage(328, userLanguage));
		modelMap.addAttribute("StartCalculation", chineseAndEnglishService.getPhraseByIndexAndLanguage(329, userLanguage));
		modelMap.addAttribute("CalculationContinue", chineseAndEnglishService.getPhraseByIndexAndLanguage(330, userLanguage));
		modelMap.addAttribute("downloadtest", chineseAndEnglishService.getPhraseByIndexAndLanguage(297, userLanguage));
		modelMap.addAttribute("Assessment", chineseAndEnglishService.getPhraseByIndexAndLanguage(298, userLanguage));
		modelMap.addAttribute("ver", chineseAndEnglishService.getPhraseByIndexAndLanguage(299, userLanguage));
		modelMap.addAttribute("vere", chineseAndEnglishService.getPhraseByIndexAndLanguage(300, userLanguage));
		modelMap.addAttribute("toes", chineseAndEnglishService.getPhraseByIndexAndLanguage(301, userLanguage));
		modelMap.addAttribute("toeuse", chineseAndEnglishService.getPhraseByIndexAndLanguage(302, userLanguage));
		modelMap.addAttribute("yearindex", chineseAndEnglishService.getPhraseByIndexAndLanguage(303, userLanguage));
		modelMap.addAttribute("Clicktorunmodel", chineseAndEnglishService.getPhraseByIndexAndLanguage(304, userLanguage));
		modelMap.addAttribute("ModelEND", chineseAndEnglishService.getPhraseByIndexAndLanguage(305, userLanguage));
		modelMap.addAttribute("Modelcalculation", chineseAndEnglishService.getPhraseByIndexAndLanguage(306, userLanguage));
		modelMap.addAttribute("Calculatetimeout", chineseAndEnglishService.getPhraseByIndexAndLanguage(307, userLanguage));
		modelMap.addAttribute("starttest", chineseAndEnglishService.getPhraseByIndexAndLanguage(308, userLanguage));
		modelMap.addAttribute("testend", chineseAndEnglishService.getPhraseByIndexAndLanguage(309, userLanguage));
		modelMap.addAttribute("Startevaluation", chineseAndEnglishService.getPhraseByIndexAndLanguage(310, userLanguage));
		modelMap.addAttribute("Intheevaluation", chineseAndEnglishService.getPhraseByIndexAndLanguage(311, userLanguage));
		modelMap.addAttribute("Evaluationend", chineseAndEnglishService.getPhraseByIndexAndLanguage(312, userLanguage));
		modelMap.addAttribute("model7", chineseAndEnglishService.getPhraseByIndexAndLanguage(315, userLanguage));
		modelMap.addAttribute("model8", chineseAndEnglishService.getPhraseByIndexAndLanguage(316, userLanguage));
		modelMap.addAttribute("moderuning", chineseAndEnglishService.getPhraseByIndexAndLanguage(317, userLanguage));
		modelMap.addAttribute("wait", chineseAndEnglishService.getPhraseByIndexAndLanguage(331, userLanguage));
		modelMap.addAttribute("time1", chineseAndEnglishService.getPhraseByIndexAndLanguage(333, userLanguage));
		modelMap.addAttribute("time2", chineseAndEnglishService.getPhraseByIndexAndLanguage(334, userLanguage));
		modelMap.addAttribute("toalyear",(Integer.valueOf(goalyear).intValue()-2012+1));
		modelMap.addAttribute("nian", chineseAndEnglishService.getPhraseByIndexAndLanguage(335, userLanguage));
		return "jumpToResult.ftl";
	}
}
