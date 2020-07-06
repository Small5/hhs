package com.smates.dbc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Project;
import com.smates.dbc2.po.UserProjectRelation;
import com.smates.dbc2.service.ProjectService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.vo.BaseMsg;
import com.smates.dbc2.vo.DataGrideRow;

import java.util.List;

@Controller
public class ProjectController extends BaseController{
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserProjectRelationService userProjectRelationService;
	
	public String userLanguage;
	//定义全局项目id
	public String projectid;
	/**
	 * 加载添加项目信息页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "addProjectpage", method = RequestMethod.GET)
	public String addproject(ModelMap modelMap) {
		modelMap.addAttribute("addp", chineseAndEnglishService.getPhraseByIndexAndLanguage(71, userLanguage));
		modelMap.addAttribute("base", chineseAndEnglishService.getPhraseByIndexAndLanguage(68, userLanguage));
		modelMap.addAttribute("pname", chineseAndEnglishService.getPhraseByIndexAndLanguage(57, userLanguage));
		modelMap.addAttribute("pnamein", chineseAndEnglishService.getPhraseByIndexAndLanguage(72, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(59, userLanguage));
		modelMap.addAttribute("descriptionin", chineseAndEnglishService.getPhraseByIndexAndLanguage(73, userLanguage));
		modelMap.addAttribute("cwid", chineseAndEnglishService.getPhraseByIndexAndLanguage(69, userLanguage));
		modelMap.addAttribute("cwidin", chineseAndEnglishService.getPhraseByIndexAndLanguage(74, userLanguage));
		modelMap.addAttribute("bps", chineseAndEnglishService.getPhraseByIndexAndLanguage(70, userLanguage));
		modelMap.addAttribute("baseyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(61, userLanguage));
		modelMap.addAttribute("baseyearin", chineseAndEnglishService.getPhraseByIndexAndLanguage(75, userLanguage));
		modelMap.addAttribute("targetyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(62, userLanguage));
		modelMap.addAttribute("targetyearin", chineseAndEnglishService.getPhraseByIndexAndLanguage(76, userLanguage));
		modelMap.addAttribute("step", chineseAndEnglishService.getPhraseByIndexAndLanguage(63, userLanguage));
		modelMap.addAttribute("stepin", chineseAndEnglishService.getPhraseByIndexAndLanguage(77, userLanguage));
		modelMap.addAttribute("save", chineseAndEnglishService.getPhraseByIndexAndLanguage(24, userLanguage));
		modelMap.addAttribute("reset", chineseAndEnglishService.getPhraseByIndexAndLanguage(25, userLanguage));
		return "AddProject.ftl";
	}
	/**
	 * 加载项目页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="projectlist",method=RequestMethod.GET)
	public String projectlist(ModelMap modelMap){
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("title", chineseAndEnglishService.getPhraseByIndexAndLanguage(56, userLanguage));
		modelMap.addAttribute("pname", chineseAndEnglishService.getPhraseByIndexAndLanguage(57, userLanguage));
		modelMap.addAttribute("keyword", chineseAndEnglishService.getPhraseByIndexAndLanguage(27, userLanguage));
		modelMap.addAttribute("find", chineseAndEnglishService.getPhraseByIndexAndLanguage(28, userLanguage));
		modelMap.addAttribute("new", chineseAndEnglishService.getPhraseByIndexAndLanguage(29, userLanguage));
		modelMap.addAttribute("pid", chineseAndEnglishService.getPhraseByIndexAndLanguage(58, userLanguage));
		modelMap.addAttribute("wid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(59, userLanguage));
		modelMap.addAttribute("time", chineseAndEnglishService.getPhraseByIndexAndLanguage(60, userLanguage));
		modelMap.addAttribute("baseyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(61, userLanguage));
		modelMap.addAttribute("targetyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(62, userLanguage));
		modelMap.addAttribute("step", chineseAndEnglishService.getPhraseByIndexAndLanguage(63, userLanguage));
		modelMap.addAttribute("open", chineseAndEnglishService.getPhraseByIndexAndLanguage(64, userLanguage));
		modelMap.addAttribute("delete", chineseAndEnglishService.getPhraseByIndexAndLanguage(33, userLanguage));
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
		modelMap.addAttribute("sdp", chineseAndEnglishService.getPhraseByIndexAndLanguage(65, userLanguage));
		return "projectList.ftl";
	}
	
	@ResponseBody
	@RequestMapping(value = "projectedit", method = RequestMethod.GET)
	public BaseMsg Projectedit(ModelMap modelMap,String id) {
		projectid = id;
		System.out.println("目前所选项目id:"+id);
//		modelMap.addAttribute("watershed", watershedService.watershed(userService.getCurrentUserId(), id));
		return new BaseMsg(true, "确定要编辑该项目吗？");
	}

	@ResponseBody
	@RequestMapping(value = "projectMsg", method = RequestMethod.GET)
	public Project Projectedit() {
		//projectid = id;
		System.out.println("目前编辑的项目id_1:"+projectid);
		Project project = projectService.getProjectByUsernameAndId(userService.getCurrentUserId(),projectid);

//		modelMap.addAttribute("watershed", watershedService.watershed(userService.getCurrentUserId(), id));
		return project;
	}

	@RequestMapping(value = "jumpToProjectdedit", method = RequestMethod.GET)
	public String ToProjectedit(ModelMap modelMap) {
//		System.out.println(projectService.getProjectByUsernameAndId(userService.getCurrentUserId(),projectid));
		modelMap.addAttribute("project", projectService.getProjectByUsernameAndId(userService.getCurrentUserId(),projectid));
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
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
		return "projectedit.ftl";
	}

	/**
	 * 
	 * @param name
	 * @param describe
	 * @param watershedId
	 * @param baseYear
	 * @param goalYear
	 * @param step
	 * @return
	 */
	@RequestMapping(value = "addProject", method = RequestMethod.POST)
	public String addProject(ModelMap modelMap,String name, String describe, String watershedId, String baseYear, String goalYear,
			String step) {
		System.out.println(name+"/"+describe+"/"+watershedId+"/"+baseYear+"/"+goalYear+"/"+step);
		projectService.addProject(userService.getCurrentUserId(), name, describe, watershedId, baseYear, goalYear, step);
		
		modelMap.addAttribute("title", chineseAndEnglishService.getPhraseByIndexAndLanguage(56, userLanguage));
		modelMap.addAttribute("pname", chineseAndEnglishService.getPhraseByIndexAndLanguage(57, userLanguage));
		modelMap.addAttribute("keyword", chineseAndEnglishService.getPhraseByIndexAndLanguage(27, userLanguage));
		modelMap.addAttribute("find", chineseAndEnglishService.getPhraseByIndexAndLanguage(28, userLanguage));
		modelMap.addAttribute("new", chineseAndEnglishService.getPhraseByIndexAndLanguage(29, userLanguage));
		modelMap.addAttribute("pid", chineseAndEnglishService.getPhraseByIndexAndLanguage(58, userLanguage));
		modelMap.addAttribute("wid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(59, userLanguage));
		modelMap.addAttribute("time", chineseAndEnglishService.getPhraseByIndexAndLanguage(60, userLanguage));
		modelMap.addAttribute("baseyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(61, userLanguage));
		modelMap.addAttribute("targetyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(62, userLanguage));
		modelMap.addAttribute("step", chineseAndEnglishService.getPhraseByIndexAndLanguage(63, userLanguage));
		modelMap.addAttribute("open", chineseAndEnglishService.getPhraseByIndexAndLanguage(64, userLanguage));
		modelMap.addAttribute("delete", chineseAndEnglishService.getPhraseByIndexAndLanguage(33, userLanguage));
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
		modelMap.addAttribute("sdp", chineseAndEnglishService.getPhraseByIndexAndLanguage(65, userLanguage));
		//return "projectList.ftl";
		return "home.ftl";
	}
	
	@RequestMapping(value = "updateProject", method = RequestMethod.POST)
	public String updateProject(ModelMap modelMap,String name, String describe, String watershedId, String baseYear, String goalYear,
			String step) {
//		System.out.println(name+"/"+describe+"/"+watershedId+"/"+baseYear+"/"+goalYear+"/"+step);
		String username = userService.getCurrentUserId();
		projectService.updateProject(username,projectid, name, describe, watershedId, baseYear, goalYear, step);
//		projectService.deleteProject(username, projectid);
		
		modelMap.addAttribute("title", chineseAndEnglishService.getPhraseByIndexAndLanguage(56, userLanguage));
		modelMap.addAttribute("pname", chineseAndEnglishService.getPhraseByIndexAndLanguage(57, userLanguage));
		modelMap.addAttribute("keyword", chineseAndEnglishService.getPhraseByIndexAndLanguage(27, userLanguage));
		modelMap.addAttribute("find", chineseAndEnglishService.getPhraseByIndexAndLanguage(28, userLanguage));
		modelMap.addAttribute("new", chineseAndEnglishService.getPhraseByIndexAndLanguage(29, userLanguage));
		modelMap.addAttribute("pid", chineseAndEnglishService.getPhraseByIndexAndLanguage(58, userLanguage));
		modelMap.addAttribute("wid", chineseAndEnglishService.getPhraseByIndexAndLanguage(30, userLanguage));
		modelMap.addAttribute("description", chineseAndEnglishService.getPhraseByIndexAndLanguage(59, userLanguage));
		modelMap.addAttribute("time", chineseAndEnglishService.getPhraseByIndexAndLanguage(60, userLanguage));
		modelMap.addAttribute("baseyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(61, userLanguage));
		modelMap.addAttribute("targetyear", chineseAndEnglishService.getPhraseByIndexAndLanguage(62, userLanguage));
		modelMap.addAttribute("step", chineseAndEnglishService.getPhraseByIndexAndLanguage(63, userLanguage));
		modelMap.addAttribute("open", chineseAndEnglishService.getPhraseByIndexAndLanguage(64, userLanguage));
		modelMap.addAttribute("delete", chineseAndEnglishService.getPhraseByIndexAndLanguage(33, userLanguage));
		modelMap.addAttribute("edit", chineseAndEnglishService.getPhraseByIndexAndLanguage(34, userLanguage));
		modelMap.addAttribute("sdp", chineseAndEnglishService.getPhraseByIndexAndLanguage(65, userLanguage));
		//return "projectList.ftl";
		return "home.ftl";
	}

	/**
	 * 根据项目名称模糊查找项目信息
	 * @param name 项目名称
	 * @param rows 每页显示的个数
	 * @param page 当前显示的页数
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getProjectByName", method = RequestMethod.GET)
	public DataGrideRow<Project> getProjectByName(String name, int rows, @RequestParam(defaultValue = "1") int page) {
		return new DataGrideRow<>(projectService.getProjectSumByName(userService.getCurrentUserId(),name),
				projectService.getProjectByName(userService.getCurrentUserId(),name, rows, page));
	}

	/**
	 * 根据项目名称模糊查找项目信息
	 * @param username
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getProjectByUser", method = RequestMethod.GET)
	public List<Project> getProjectByUser(String username) {
		List<Project> projectList = projectService.getProjectByUser(userService.getCurrentUserId());
		return projectList;
	}
	
	/**
	 * 删除一个项目记录 
	 * @param id 项目id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deleteProject",method=RequestMethod.POST)
	public BaseMsg deleteProjectById(String id){
		String username = userService.getCurrentUserId();
		projectService.deleteProject(username,id);
		return new BaseMsg(true, "删除成功");
	}
	
	/**
	 * 跳转到评价界面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="assess.do",method=RequestMethod.GET)
	public String assess(String projectId,ModelMap modelMap){
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		//判断该用户是否设置了默认项目
		if(userProjectRelation==null){
			return "none.ftl";
		}else{
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
			//return "goal.ftl";
			return "home.ftl";
		}
	}

	/**
	 * 根据项目id查询项目信息（abstract.ftl用到）
	 * 
	 * @param projectId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getProjectById", method = RequestMethod.GET)
	public Project getProjectById(String username,String projectId) {
		return projectService.getProjectByUsernameAndId(username,projectId);
	}
	
	/**
	 * 将某个项目设置为默认项目
	 * @param id 项目id
	 * @return 是否设置成功
	 */
	/*@ResponseBody
	@RequestMapping(value = "autoproject",method=RequestMethod.GET)
	public BaseMsg autoproject(String id){
		String userName = userService.getCurrentUserId();//获取当前登录的用户账号
		userProjectRelationService.addUserProjectRelation(userName, id);
		//设置为默认项目
		projectid = id;
		return new BaseMsg(true, "您要打开ID为："+id+"的项目吗？");
	}*/


}
