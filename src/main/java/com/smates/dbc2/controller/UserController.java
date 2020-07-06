package com.smates.dbc2.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.smates.dbc2.po.*;
import com.smates.dbc2.vo.StreamLanUseSceVo;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.smates.dbc2.service.ModelService;
import com.smates.dbc2.service.ProjectService;
import com.smates.dbc2.utils.ShiroUtils;
import com.smates.dbc2.utils.ValidaterUtil;
import com.smates.dbc2.vo.BaseMsg;

@Controller
public class UserController extends BaseController {
	private static Logger logger = Logger.getLogger(UserController.class);
	//定义用户语言初始变量
	private String Language = "";
	@Autowired
	private ModelService modelservice;
	@Autowired
	private ProjectService projectService;
	//定义全局项目id
	public String projectid;
	/**
	 * 用户登录系统首页
	 * @param modelMap
	 * @param language
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(ModelMap modelMap, String language) {
		if(language==null) {
			language="chinese";
		}
		Language = language;
		return "index.ftl";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.addAttribute("login", chineseAndEnglishService.getPhraseByIndexAndLanguage(186, Language));
		modelMap.addAttribute("tourist", chineseAndEnglishService.getPhraseByIndexAndLanguage(187, Language));
		modelMap.addAttribute("hhs", chineseAndEnglishService.getPhraseByIndexAndLanguage(188, Language));
		return "Login.ftl";
	}
	/**
	 * 处理登录请求
	 * @param accountNumber 用户登录的accountNumber
	 * @param userpwd 用户登录的明文密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String submit(ModelMap modelMap, String accountNumber, String userpwd) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(accountNumber, userpwd);
		try {
			subject.login(token);
		} catch (AuthenticationException ae) {
			logger.info("账号或密码错误");
			modelMap.addAttribute("callback", "账号或密码错误");
			return "0";
		}
		//记录登录时间
		logger.info("----------登录时间："+new Date()+"----------");
		//记录登录状态
		logger.info("登录成功");
		//记录当前登录用户名
		logger.info("登录用户："+userService.getCurrentUserId()+"，语言："+Language);
		//更改当前用户语言
		userAndLanguageService.updateUserAndLanguage(accountNumber, Language);
		return "1";
	}
	
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String regist(String username, String userpwd,String nickname,String email) {
		//System.out.println(username+"-"+userpwd+"-"+nickname+"-"+email);
		Boolean flag = false;
		try {
			User user=userService.getUserByAccountNumber(username);
			System.out.println(user.getAccountNumber());
		}catch(Exception e){
			System.out.println("无数据");
			flag = true;
		}
		System.out.println(flag);
		if(flag) {
			userService.addUser(new User(UUID.randomUUID().toString(),username,nickname,ShiroUtils.passwdMD5(userpwd),1,new java.sql.Date(new Date().getTime()),email));
			userService.addUserLanuage(new UserAndLanuage(username,null,null));
			return "1";
		}else{
			return "0";
		}
		//System.out.println(user.getAccountNumber().isEmpty());
		
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		logger.info("!退出时间："+new Date());
		return "redirect:index.do";
	}

	/**
	 * 系统主界面，用户登录后可根据权限显示不同菜单
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("home")
	public String home(ModelMap modelMap) {
		//从数据库中读取当前用户选择语言
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		//获取当前登录用户
		User user = userService.getUserByAccountNumber(userService.getCurrentUserId());
		String username = userService.getCurrentUserId();
		projectid = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
//		System.err.println(projectid);
//		projectid = "6057a402-4e27-409f-a9ae-ac24e0347f05";
//		System.err.println(projectid);
		String goalyear = modelservice.getgoalyear(projectid);
		//System.err.println(username);
		///String watershedId = userWatershedRelationService.getUserWatershedRelationByUserName(username).getAutowatershedid();
		//System.err.println(watershedId);
		//Watershed watershed = watershedService.watershed(username, watershedId);
		//获取用户权限
		logger.info("当前用户权限是："+user.getRole());
		modelMap.addAttribute("role", user.getRole());
		//System.out.println(user.getImage());
		//头像相关
		//user.setImage(SysConst.QNIUYUNURL + user.getImage());
		//用户
		modelMap.addAttribute("user", user);
		//用户语言
		modelMap.addAttribute("userLanguage", userLanguage);
		//流域可持续发展决策支持系统
		modelMap.addAttribute("title", chineseAndEnglishService.getPhraseByIndexAndLanguage(1, userLanguage));
		//欢迎您！
		modelMap.addAttribute("nickname", chineseAndEnglishService.getPhraseByIndexAndLanguage(2, userLanguage));
		//流域管理
		modelMap.addAttribute("rbm", chineseAndEnglishService.getPhraseByIndexAndLanguage(3, userLanguage));
		//用户设置的流域
		///modelMap.addAttribute("YHDYLY", watershed.getName());
		//黑河流域
		modelMap.addAttribute("hrb", chineseAndEnglishService.getPhraseByIndexAndLanguage(4, userLanguage));
		//决策支持
		modelMap.addAttribute("dms", chineseAndEnglishService.getPhraseByIndexAndLanguage(5, userLanguage));
		//用户管理
		modelMap.addAttribute("um", chineseAndEnglishService.getPhraseByIndexAndLanguage(6, userLanguage));
		//关于本系统
		modelMap.addAttribute("about", chineseAndEnglishService.getPhraseByIndexAndLanguage(7, userLanguage));
		//黑河集成建模
		modelMap.addAttribute("him", chineseAndEnglishService.getPhraseByIndexAndLanguage(8, userLanguage));
		//联系我们
		modelMap.addAttribute("contact", chineseAndEnglishService.getPhraseByIndexAndLanguage(9, userLanguage));
		//退出
		modelMap.addAttribute("exit", chineseAndEnglishService.getPhraseByIndexAndLanguage(10, userLanguage));
		//寒旱所
		modelMap.addAttribute("hhs", chineseAndEnglishService.getPhraseByIndexAndLanguage(188, userLanguage));
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
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
		modelMap.addAttribute("project", projectService.getProjectByUsernameAndId(userService.getCurrentUserId(),projectid));
		//userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("modify", chineseAndEnglishService.getPhraseByIndexAndLanguage(67, userLanguage));
		modelMap.addAttribute("base", chineseAndEnglishService.getPhraseByIndexAndLanguage(68, userLanguage));
		modelMap.addAttribute("pname", chineseAndEnglishService.getPhraseByIndexAndLanguage(57, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(59, userLanguage));
		modelMap.addAttribute("cwid", chineseAndEnglishService.getPhraseByIndexAndLanguage(69, userLanguage));
		modelMap.addAttribute("bps", chineseAndEnglishService.getPhraseByIndexAndLanguage(70, userLanguage));
		modelMap.addAttribute("baseyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(61, userLanguage));
		modelMap.addAttribute("targetyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(62, userLanguage));
		modelMap.addAttribute("step", chineseAndEnglishService.getPhraseByIndexAndLanguage(63, userLanguage));
		modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(24, userLanguage));
		modelMap.addAttribute("reset", chineseAndEnglishService.getPhraseByIndexAndLanguage(25, userLanguage));
        modelMap.addAttribute("savesuccess", chineseAndEnglishService.getPhraseByIndexAndLanguage(242, userLanguage));
        modelMap.addAttribute("sdb", chineseAndEnglishService.getPhraseByIndexAndLanguage(35, userLanguage));
        modelMap.addAttribute("open", chineseAndEnglishService.getPhraseByIndexAndLanguage(64, userLanguage));
        modelMap.addAttribute("delete", chineseAndEnglishService.getPhraseByIndexAndLanguage(33, userLanguage));
        modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
        modelMap.addAttribute("sdp", chineseAndEnglishService.getPhraseByIndexAndLanguage(65, userLanguage));
		modelMap.addAttribute("scecon", chineseAndEnglishService.getPhraseByIndexAndLanguage(189, userLanguage));
		//评价结果
		modelMap.addAttribute("result", chineseAndEnglishService.getPhraseByIndexAndLanguage(190, userLanguage));
		modelMap.addAttribute("downresult", chineseAndEnglishService.getPhraseByIndexAndLanguage(191, userLanguage));
		modelMap.addAttribute("EA", chineseAndEnglishService.getPhraseByIndexAndLanguage(204, userLanguage));
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
		}
		return "home.ftl";
	}

	/**
	 * 普通权限下用户可修改信息
	 * @param id
	 * @param accountNumber
	 * @param nickName
	 * @param password
	 * @param repwd
	 * @param eMail
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public BaseMsg updateUser(String id, String accountNumber, String nickName, String password, String repwd,
			String eMail) {
		if (!password.equals(repwd)) {
			return new BaseMsg(false, "两次密码不一致");
		}
		if (eMail != null) {
			if (!ValidaterUtil.checkEMail(eMail)) {
				return new BaseMsg(false, "邮箱格式不正确");
			}
		}
		// 用户权限下只允许修改,密码,邮箱,昵称
		User user = new User(id, null, nickName, ShiroUtils.passwdMD5(password), null, null, eMail);

		User userpo = userService.getUserByAccountNumber(userService.getCurrentUserId());
		// 密码没有修改
		if (password.equals("")) {
			user.setPassword(null);
		}
		if (password.equals(userpo.getPassword())) {
			user.setPassword(null);
		}
		userService.updateUser(user);
		logger.info("用户信息修改:"+new Date());
		return new BaseMsg(true, "信息修改成功");
	}

	/**
	 * 获取当前登录的用户信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getCurrentUser", method = RequestMethod.GET)
	public User getCurrentUser() {
		return userService.getUserByAccountNumber(userService.getCurrentUserId());
	}

	@ResponseBody
	@RequestMapping(value = "autoproject",method=RequestMethod.GET)
	public BaseMsg autoproject(String id){
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		userProjectRelationService.addUserProjectRelation(userName, id);
		//设置为默认项目
		projectid = id;
		return new BaseMsg(true, "您要打开ID为："+id+"的项目吗？");
	}

	/**
	 * 加载用户信息页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "userinformation", method = RequestMethod.GET)
	public String watershedlist(ModelMap modelMap) {
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("pim", chineseAndEnglishService.getPhraseByIndexAndLanguage(11, userLanguage));
		modelMap.addAttribute("username", chineseAndEnglishService.getPhraseByIndexAndLanguage(12, userLanguage));
		modelMap.addAttribute("nickname", chineseAndEnglishService.getPhraseByIndexAndLanguage(13, userLanguage));
		modelMap.addAttribute("nickname1", chineseAndEnglishService.getPhraseByIndexAndLanguage(14, userLanguage));
		modelMap.addAttribute("pwd1", chineseAndEnglishService.getPhraseByIndexAndLanguage(15, userLanguage));
		modelMap.addAttribute("pwd01", chineseAndEnglishService.getPhraseByIndexAndLanguage(16, userLanguage));
		modelMap.addAttribute("pwd2", chineseAndEnglishService.getPhraseByIndexAndLanguage(17, userLanguage));
		modelMap.addAttribute("pwd02", chineseAndEnglishService.getPhraseByIndexAndLanguage(18, userLanguage));
		modelMap.addAttribute("lage", chineseAndEnglishService.getPhraseByIndexAndLanguage(19, userLanguage));
		modelMap.addAttribute("chinese", chineseAndEnglishService.getPhraseByIndexAndLanguage(20, userLanguage));
		modelMap.addAttribute("ngo", chineseAndEnglishService.getPhraseByIndexAndLanguage(21, userLanguage));
		modelMap.addAttribute("need", chineseAndEnglishService.getPhraseByIndexAndLanguage(22, userLanguage));
		modelMap.addAttribute("notneed", chineseAndEnglishService.getPhraseByIndexAndLanguage(23, userLanguage));
		modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(24, userLanguage));
		modelMap.addAttribute("reset", chineseAndEnglishService.getPhraseByIndexAndLanguage(25, userLanguage));
		//return "UserInformation.ftl";
		return "home.ftl";
	}

}