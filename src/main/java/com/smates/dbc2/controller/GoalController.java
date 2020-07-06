package com.smates.dbc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Goal;
import com.smates.dbc2.po.UserProjectRelation;
import com.smates.dbc2.service.ChineseAndEnglishService;
import com.smates.dbc2.service.GoalService;
import com.smates.dbc2.service.ModelService;
import com.smates.dbc2.service.UserAndLanguageService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.Node;

/**
 * 
 * @author baijw
 *
 */
@Controller
public class GoalController {
	
	@Autowired
	private GoalService goalService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAndLanguageService userAndLanguageService;
	
	@Autowired
	private UserProjectRelationService userProjectRelationService;
	
	@Autowired
	private ChineseAndEnglishService chineseAndEnglishService;
	@Autowired
	private ModelService modelservice;
	
	/**
	 * 加载目标页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="goal",method=RequestMethod.GET)
	public String projectlist(ModelMap modelMap){
		String userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		//判断该用户是否设置了默认项目
//		System.out.println("项目ID"+userProjectRelation.getAutoProjectId());
		modelMap.addAttribute("projectId", userProjectRelation.getAutoProjectId());
		modelMap.addAttribute("system", chineseAndEnglishService.getPhraseByIndexAndLanguage(1, userLanguage));
		modelMap.addAttribute("goal", chineseAndEnglishService.getPhraseByIndexAndLanguage(89, userLanguage));
		modelMap.addAttribute("scene", chineseAndEnglishService.getPhraseByIndexAndLanguage(90, userLanguage));
		modelMap.addAttribute("scene1", chineseAndEnglishService.getPhraseByIndexAndLanguage(91, userLanguage));
		modelMap.addAttribute("goalset", chineseAndEnglishService.getPhraseByIndexAndLanguage(92, userLanguage));
		modelMap.addAttribute("arch", chineseAndEnglishService.getPhraseByIndexAndLanguage(93, userLanguage));
		modelMap.addAttribute("desc", chineseAndEnglishService.getPhraseByIndexAndLanguage(94, userLanguage));
		modelMap.addAttribute("goal1", chineseAndEnglishService.getPhraseByIndexAndLanguage(95, userLanguage));
		modelMap.addAttribute("weight", chineseAndEnglishService.getPhraseByIndexAndLanguage(96, userLanguage));
		modelMap.addAttribute("sub", chineseAndEnglishService.getPhraseByIndexAndLanguage(97, userLanguage));
		modelMap.addAttribute("index", chineseAndEnglishService.getPhraseByIndexAndLanguage(98, userLanguage));
		modelMap.addAttribute("i11", chineseAndEnglishService.getPhraseByIndexAndLanguage(99, userLanguage));
		modelMap.addAttribute("i111", chineseAndEnglishService.getPhraseByIndexAndLanguage(100, userLanguage));
		modelMap.addAttribute("d1", chineseAndEnglishService.getPhraseByIndexAndLanguage(101, userLanguage));
		modelMap.addAttribute("i112", chineseAndEnglishService.getPhraseByIndexAndLanguage(102, userLanguage));
		modelMap.addAttribute("i12", chineseAndEnglishService.getPhraseByIndexAndLanguage(103, userLanguage));
		modelMap.addAttribute("i121", chineseAndEnglishService.getPhraseByIndexAndLanguage(104, userLanguage));
		modelMap.addAttribute("i13", chineseAndEnglishService.getPhraseByIndexAndLanguage(105, userLanguage));
		modelMap.addAttribute("i131", chineseAndEnglishService.getPhraseByIndexAndLanguage(106, userLanguage));
		modelMap.addAttribute("i132", chineseAndEnglishService.getPhraseByIndexAndLanguage(107, userLanguage));
		modelMap.addAttribute("i14", chineseAndEnglishService.getPhraseByIndexAndLanguage(108, userLanguage));
		modelMap.addAttribute("i141", chineseAndEnglishService.getPhraseByIndexAndLanguage(109, userLanguage));
		modelMap.addAttribute("i142", chineseAndEnglishService.getPhraseByIndexAndLanguage(110, userLanguage));
		modelMap.addAttribute("i143", chineseAndEnglishService.getPhraseByIndexAndLanguage(111, userLanguage));
		modelMap.addAttribute("i144", chineseAndEnglishService.getPhraseByIndexAndLanguage(112, userLanguage));
		modelMap.addAttribute("goal2", chineseAndEnglishService.getPhraseByIndexAndLanguage(113, userLanguage));
		modelMap.addAttribute("i21", chineseAndEnglishService.getPhraseByIndexAndLanguage(114, userLanguage));
		modelMap.addAttribute("i211", chineseAndEnglishService.getPhraseByIndexAndLanguage(115, userLanguage));
		modelMap.addAttribute("i22", chineseAndEnglishService.getPhraseByIndexAndLanguage(116, userLanguage));
		modelMap.addAttribute("i221", chineseAndEnglishService.getPhraseByIndexAndLanguage(117, userLanguage));
		modelMap.addAttribute("i23", chineseAndEnglishService.getPhraseByIndexAndLanguage(118, userLanguage));
		modelMap.addAttribute("i231", chineseAndEnglishService.getPhraseByIndexAndLanguage(119, userLanguage));
		modelMap.addAttribute("goal3", chineseAndEnglishService.getPhraseByIndexAndLanguage(120, userLanguage));
		modelMap.addAttribute("i31", chineseAndEnglishService.getPhraseByIndexAndLanguage(121, userLanguage));
		modelMap.addAttribute("i311", chineseAndEnglishService.getPhraseByIndexAndLanguage(122, userLanguage));
		modelMap.addAttribute("WanYuan", chineseAndEnglishService.getPhraseByIndexAndLanguage(123, userLanguage));
		modelMap.addAttribute("i32", chineseAndEnglishService.getPhraseByIndexAndLanguage(124, userLanguage));
		modelMap.addAttribute("i321", chineseAndEnglishService.getPhraseByIndexAndLanguage(125, userLanguage));
		modelMap.addAttribute("i33", chineseAndEnglishService.getPhraseByIndexAndLanguage(126, userLanguage));
		modelMap.addAttribute("i331", chineseAndEnglishService.getPhraseByIndexAndLanguage(127, userLanguage));
		modelMap.addAttribute("i34", chineseAndEnglishService.getPhraseByIndexAndLanguage(128, userLanguage));
		modelMap.addAttribute("i341", chineseAndEnglishService.getPhraseByIndexAndLanguage(129, userLanguage));
		modelMap.addAttribute("i35", chineseAndEnglishService.getPhraseByIndexAndLanguage(130, userLanguage));
		modelMap.addAttribute("i351", chineseAndEnglishService.getPhraseByIndexAndLanguage(131, userLanguage));
		modelMap.addAttribute("i352", chineseAndEnglishService.getPhraseByIndexAndLanguage(132, userLanguage));
		modelMap.addAttribute("i36", chineseAndEnglishService.getPhraseByIndexAndLanguage(133, userLanguage));
		modelMap.addAttribute("i361", chineseAndEnglishService.getPhraseByIndexAndLanguage(134, userLanguage));
		modelMap.addAttribute("i37", chineseAndEnglishService.getPhraseByIndexAndLanguage(135, userLanguage));
		modelMap.addAttribute("i371", chineseAndEnglishService.getPhraseByIndexAndLanguage(135, userLanguage));
		modelMap.addAttribute("kg", chineseAndEnglishService.getPhraseByIndexAndLanguage(136, userLanguage));
		modelMap.addAttribute("i372", chineseAndEnglishService.getPhraseByIndexAndLanguage(137, userLanguage));
		modelMap.addAttribute("i373", chineseAndEnglishService.getPhraseByIndexAndLanguage(138, userLanguage));
		modelMap.addAttribute("i38", chineseAndEnglishService.getPhraseByIndexAndLanguage(139, userLanguage));
		modelMap.addAttribute("i381", chineseAndEnglishService.getPhraseByIndexAndLanguage(140, userLanguage));
		modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(24, userLanguage));
		modelMap.addAttribute("reset", chineseAndEnglishService.getPhraseByIndexAndLanguage(25, userLanguage));
		modelMap.addAttribute("next", chineseAndEnglishService.getPhraseByIndexAndLanguage(141, userLanguage));
		modelMap.addAttribute("WanMu", chineseAndEnglishService.getPhraseByIndexAndLanguage(313, userLanguage));
		modelMap.addAttribute("ELiFang", chineseAndEnglishService.getPhraseByIndexAndLanguage(170, userLanguage));
		modelMap.addAttribute("Yuan", chineseAndEnglishService.getPhraseByIndexAndLanguage(314, userLanguage));
		return "goal.ftl";
	}

	/**
	 * 保存目标体系接口（参数和界面标号对应）
	 * 
	 * @param goal_1
	 * @param goal_2
	 * @param goal_3
	 * @param index_111
	 * @param index_112
	 * @param index_121
	 * @param index_131
	 * @param index_132
	 * @param index_141
	 * @param index_142
	 * @param index_143
	 * @param index_144
	 * @param index_211
	 * @param index_221
	 * @param index_231
	 * @param index_311
	 * @param index_321
	 * @param index_331
	 * @param index_341
	 * @param index_351
	 * @param index_352
	 * @param index_361
	 * @param index_371
	 * @param index_372
	 * @param index_373
	 * @param index_381
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="addGoal",method=RequestMethod.GET)
	public BaseMsg addGoal(String goal_1, String goal_2, String goal_3, String index_111, String index_112, String index_121,
			String index_131, String index_132, String index_141, String index_142, String index_143, String index_144,
			String index_211, String index_221, String index_231, String index_311, String index_321, String index_331,
			String index_341, String index_351, String index_352, String index_361,
			String index_371, String index_372, String index_373, String index_381,
			String goal_1_status,String goal_2_status,String goal_3_status,String index_111_status,
			String index_112_status,String index_121_status,String index_131_status,String index_132_status,
			String index_141_status,String index_142_status,String index_143_status,String index_144_status,
			String index_211_status,String index_221_status,String index_231_status,
			String index_311_status,String index_321_status,String index_331_status,
			String index_341_status,String index_351_status,String index_352_status,
			String index_361_status,String index_371_status,String index_372_status,
			String index_373_status,String index_381_status){
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		String projectId = userProjectRelation.getAutoProjectId();
		goalService.deleteGoalById(projectId);
		goalService.addGoal(projectId, goal_1, goal_2, goal_3, index_111, index_112, index_121, index_131, index_132, index_141, index_142, index_143, index_144, index_211, index_221, index_231, index_311, index_321, index_331, index_341, index_351, index_352, index_361, index_371, index_372, index_373, index_381,
				goal_1_status,goal_2_status,goal_3_status,index_111_status,
				index_112_status,index_121_status,index_131_status,index_132_status,
				index_141_status,index_142_status,index_143_status,index_144_status,
				index_211_status,index_221_status,index_231_status,
				index_311_status,index_321_status,index_331_status,
				index_341_status,index_351_status,index_352_status,
				index_361_status,index_371_status,index_372_status,
				index_373_status,index_381_status);
		return new BaseMsg(true, "Success");
	}
	
	@ResponseBody
	@RequestMapping(value="getGoalTree.do",method=RequestMethod.GET)
	public Node getGoalTree(){
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		String projectid = userProjectRelation.getAutoProjectId();
		return goalService.getGoalTreeById(projectid);
	}
	
	@ResponseBody
	@RequestMapping(value="getGoal.do",method=RequestMethod.GET)
	public Goal getGoal(){
		/*System.out.println(id);*/
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		String projectid = userProjectRelation.getAutoProjectId();
		System.out.println(goalService.getGoalById(projectid));

		return goalService.getGoalById(projectid);
	}
	
	@RequestMapping(value="toStuation.do",method=RequestMethod.GET)
	public String toStuation(ModelMap modelMap){
		String userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		String goalyear = modelservice.getgoalyear(projectId);
		//判断该用户是否设置了默认项目
//		System.out.println("项目ID"+userProjectRelation.getAutoProjectId());
		if(userProjectRelation.getAutoProjectId()==null){
			return "none.ftl";
		}else{
			modelMap.addAttribute("projectId", userProjectRelation.getAutoProjectId());
			modelMap.addAttribute("tab1", chineseAndEnglishService.getPhraseByIndexAndLanguage(40, userLanguage));
			modelMap.addAttribute("tab2", chineseAndEnglishService.getPhraseByIndexAndLanguage(43, userLanguage));
			modelMap.addAttribute("tab3", chineseAndEnglishService.getPhraseByIndexAndLanguage(46, userLanguage));
			modelMap.addAttribute("tab4", chineseAndEnglishService.getPhraseByIndexAndLanguage(78, userLanguage));
			modelMap.addAttribute("tab5", chineseAndEnglishService.getPhraseByIndexAndLanguage(50, userLanguage));
			modelMap.addAttribute("selectCountry", chineseAndEnglishService.getPhraseByIndexAndLanguage(79, userLanguage));
//			modelMap.addAttribute("selectYear", chineseAndEnglishService.getPhraseByIndexAndLanguage(80, userLanguage));
//			modelMap.addAttribute("ClimateScenarios", chineseAndEnglishService.getPhraseByIndexAndLanguage(19, userLanguage));
//			modelMap.addAttribute("climatmyself", chineseAndEnglishService.getPhraseByIndexAndLanguage(28, userLanguage));
//			modelMap.addAttribute("rainup", chineseAndEnglishService.getPhraseByIndexAndLanguage(29, userLanguage));
//			modelMap.addAttribute("temup", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
			modelMap.addAttribute("avgtem", chineseAndEnglishService.getPhraseByIndexAndLanguage(81, userLanguage));
			modelMap.addAttribute("toptem", chineseAndEnglishService.getPhraseByIndexAndLanguage(82, userLanguage));
			modelMap.addAttribute("bottomtem", chineseAndEnglishService.getPhraseByIndexAndLanguage(83, userLanguage));
			modelMap.addAttribute("temcurve", chineseAndEnglishService.getPhraseByIndexAndLanguage(80, userLanguage));
			modelMap.addAttribute("tem", chineseAndEnglishService.getPhraseByIndexAndLanguage(85, userLanguage));
			modelMap.addAttribute("year", chineseAndEnglishService.getPhraseByIndexAndLanguage(84, userLanguage));
			modelMap.addAttribute("Precipitation", chineseAndEnglishService.getPhraseByIndexAndLanguage(88, userLanguage));
//			modelMap.addAttribute("AveragePrecipitation", chineseAndEnglishService.getPhraseByIndexAndLanguage(26, userLanguage));
//			modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(10, userLanguage));
//			modelMap.addAttribute("reset", chineseAndEnglishService.getPhraseByIndexAndLanguage(11, userLanguage));
			modelMap.addAttribute("Curveofprecipitation", chineseAndEnglishService.getPhraseByIndexAndLanguage(86, userLanguage));
			modelMap.addAttribute("AveragePrecipitation", chineseAndEnglishService.getPhraseByIndexAndLanguage(87, userLanguage));
			modelMap.addAttribute("system", chineseAndEnglishService.getPhraseByIndexAndLanguage(1, userLanguage));
			modelMap.addAttribute("goal", chineseAndEnglishService.getPhraseByIndexAndLanguage(89, userLanguage));
			modelMap.addAttribute("scene", chineseAndEnglishService.getPhraseByIndexAndLanguage(90, userLanguage));
			modelMap.addAttribute("scene1", chineseAndEnglishService.getPhraseByIndexAndLanguage(91, userLanguage));
			modelMap.addAttribute("climate", chineseAndEnglishService.getPhraseByIndexAndLanguage(40, userLanguage));
			modelMap.addAttribute("land", chineseAndEnglishService.getPhraseByIndexAndLanguage(43, userLanguage));
			modelMap.addAttribute("soc", chineseAndEnglishService.getPhraseByIndexAndLanguage(142, userLanguage));
			modelMap.addAttribute("water", chineseAndEnglishService.getPhraseByIndexAndLanguage(50, userLanguage));
			modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(143, userLanguage));
			modelMap.addAttribute("county", chineseAndEnglishService.getPhraseByIndexAndLanguage(144, userLanguage));
			modelMap.addAttribute("rain", chineseAndEnglishService.getPhraseByIndexAndLanguage(145, userLanguage));
			modelMap.addAttribute("temp", chineseAndEnglishService.getPhraseByIndexAndLanguage(146, userLanguage));
			modelMap.addAttribute("sc", chineseAndEnglishService.getPhraseByIndexAndLanguage(147, userLanguage));
			modelMap.addAttribute("tempbiao", chineseAndEnglishService.getPhraseByIndexAndLanguage(148, userLanguage));
			modelMap.addAttribute("rainbiao", chineseAndEnglishService.getPhraseByIndexAndLanguage(149, userLanguage));
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
			modelMap.addAttribute("gengbian", chineseAndEnglishService.getPhraseByIndexAndLanguage(162, userLanguage));
			modelMap.addAttribute("landbian", chineseAndEnglishService.getPhraseByIndexAndLanguage(163, userLanguage));
			modelMap.addAttribute("popo", chineseAndEnglishService.getPhraseByIndexAndLanguage(164, userLanguage));
			modelMap.addAttribute("aptr", chineseAndEnglishService.getPhraseByIndexAndLanguage(165, userLanguage));
			modelMap.addAttribute("itpr", chineseAndEnglishService.getPhraseByIndexAndLanguage(166, userLanguage));
			modelMap.addAttribute("sitpr", chineseAndEnglishService.getPhraseByIndexAndLanguage(167, userLanguage));
			modelMap.addAttribute("urpar", chineseAndEnglishService.getPhraseByIndexAndLanguage(332, userLanguage));
			modelMap.addAttribute("qcbiao", chineseAndEnglishService.getPhraseByIndexAndLanguage(168, userLanguage));
			modelMap.addAttribute("shang", chineseAndEnglishService.getPhraseByIndexAndLanguage(169, userLanguage));
			modelMap.addAttribute("e", chineseAndEnglishService.getPhraseByIndexAndLanguage(170, userLanguage));
			modelMap.addAttribute("xia", chineseAndEnglishService.getPhraseByIndexAndLanguage(171, userLanguage));
			modelMap.addAttribute("drink", chineseAndEnglishService.getPhraseByIndexAndLanguage(172, userLanguage));
			modelMap.addAttribute("dbw", chineseAndEnglishService.getPhraseByIndexAndLanguage(173, userLanguage));
			modelMap.addAttribute("dxw", chineseAndEnglishService.getPhraseByIndexAndLanguage(174, userLanguage));
			modelMap.addAttribute("fn", chineseAndEnglishService.getPhraseByIndexAndLanguage(175, userLanguage));
			modelMap.addAttribute("waterbian", chineseAndEnglishService.getPhraseByIndexAndLanguage(176, userLanguage));
			modelMap.addAttribute("next", chineseAndEnglishService.getPhraseByIndexAndLanguage(177, userLanguage));
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
			modelMap.addAttribute("rate1", chineseAndEnglishService.getPhraseByIndexAndLanguage(239, userLanguage));
			modelMap.addAttribute("rate2", chineseAndEnglishService.getPhraseByIndexAndLanguage(240, userLanguage));
			modelMap.addAttribute("clicksave", chineseAndEnglishService.getPhraseByIndexAndLanguage(241, userLanguage));
			modelMap.addAttribute("savesuccess", chineseAndEnglishService.getPhraseByIndexAndLanguage(242, userLanguage));
			modelMap.addAttribute("landchange", chineseAndEnglishService.getPhraseByIndexAndLanguage(243, userLanguage));
			modelMap.addAttribute("landarea", chineseAndEnglishService.getPhraseByIndexAndLanguage(244, userLanguage));
			modelMap.addAttribute("mu", chineseAndEnglishService.getPhraseByIndexAndLanguage(245, userLanguage));
			modelMap.addAttribute("areachange", chineseAndEnglishService.getPhraseByIndexAndLanguage(246, userLanguage));
			modelMap.addAttribute("Wetland", chineseAndEnglishService.getPhraseByIndexAndLanguage(247, userLanguage));
			modelMap.addAttribute("Forest", chineseAndEnglishService.getPhraseByIndexAndLanguage(248, userLanguage));
			modelMap.addAttribute("Grass", chineseAndEnglishService.getPhraseByIndexAndLanguage(249, userLanguage));
			modelMap.addAttribute("Populus", chineseAndEnglishService.getPhraseByIndexAndLanguage(250, userLanguage));
			modelMap.addAttribute("Waterarea", chineseAndEnglishService.getPhraseByIndexAndLanguage(251, userLanguage));
			modelMap.addAttribute("usingwater", chineseAndEnglishService.getPhraseByIndexAndLanguage(252, userLanguage));
			modelMap.addAttribute("MWV", chineseAndEnglishService.getPhraseByIndexAndLanguage(253, userLanguage));
			modelMap.addAttribute("DWV", chineseAndEnglishService.getPhraseByIndexAndLanguage(254, userLanguage));
			modelMap.addAttribute("WC", chineseAndEnglishService.getPhraseByIndexAndLanguage(255, userLanguage));
			modelMap.addAttribute("showArea5", chineseAndEnglishService.getPhraseByIndexAndLanguage(256, userLanguage));
			modelMap.addAttribute("Main", chineseAndEnglishService.getPhraseByIndexAndLanguage(257, userLanguage));
			modelMap.addAttribute("Branch", chineseAndEnglishService.getPhraseByIndexAndLanguage(258, userLanguage));
			modelMap.addAttribute("Ditch", chineseAndEnglishService.getPhraseByIndexAndLanguage(259, userLanguage));
			modelMap.addAttribute("Agricultural", chineseAndEnglishService.getPhraseByIndexAndLanguage(260, userLanguage));
			modelMap.addAttribute("Gross", chineseAndEnglishService.getPhraseByIndexAndLanguage(261, userLanguage));
			modelMap.addAttribute("Sprinkler", chineseAndEnglishService.getPhraseByIndexAndLanguage(262, userLanguage));
			modelMap.addAttribute("Drip", chineseAndEnglishService.getPhraseByIndexAndLanguage(263, userLanguage));
			modelMap.addAttribute("userate", chineseAndEnglishService.getPhraseByIndexAndLanguage(264, userLanguage));
			modelMap.addAttribute("toalyear",(Integer.valueOf(goalyear).intValue()-2012+1));
			modelMap.addAttribute("nian", chineseAndEnglishService.getPhraseByIndexAndLanguage(335, userLanguage));
			
			modelMap.addAttribute("UpRainUpper", chineseAndEnglishService.getPhraseByIndexAndLanguage(336, userLanguage));
			modelMap.addAttribute("UpRainULower", chineseAndEnglishService.getPhraseByIndexAndLanguage(337, userLanguage));
			modelMap.addAttribute("MidRainUpper", chineseAndEnglishService.getPhraseByIndexAndLanguage(338, userLanguage));
			modelMap.addAttribute("MidRainLower", chineseAndEnglishService.getPhraseByIndexAndLanguage(339, userLanguage));
			modelMap.addAttribute("DownRainUpper", chineseAndEnglishService.getPhraseByIndexAndLanguage(340, userLanguage));
			modelMap.addAttribute("DownRainLower", chineseAndEnglishService.getPhraseByIndexAndLanguage(341, userLanguage));
			
			modelMap.addAttribute("UpTempUpper", chineseAndEnglishService.getPhraseByIndexAndLanguage(342, userLanguage));
			modelMap.addAttribute("UpTempULower", chineseAndEnglishService.getPhraseByIndexAndLanguage(343, userLanguage));
			modelMap.addAttribute("MidTempUpper", chineseAndEnglishService.getPhraseByIndexAndLanguage(344, userLanguage));
			modelMap.addAttribute("MidTempLower", chineseAndEnglishService.getPhraseByIndexAndLanguage(345, userLanguage));
			modelMap.addAttribute("DownTempUpper", chineseAndEnglishService.getPhraseByIndexAndLanguage(346, userLanguage));
			modelMap.addAttribute("DownTempLower", chineseAndEnglishService.getPhraseByIndexAndLanguage(347, userLanguage));
			
			return "toStuation.ftl";
		}
	}
	
}
