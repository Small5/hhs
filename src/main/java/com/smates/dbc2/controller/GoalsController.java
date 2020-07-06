//package com.smates.dbc2.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.smates.dbc2.po.Goals;
//import com.smates.dbc2.po.GoalsIDAndProjectID;
//import com.smates.dbc2.po.UserProjectRelation;
//import com.smates.dbc2.service.GoalsService;
//import com.smates.dbc2.service.UserProjectRelationService;
//import com.smates.dbc2.service.UserService;
//import com.smates.dbc2.vo.BaseMsg;
//import com.smates.dbc2.vo.DataGrideRow;
//
///**
// * 动态加载评价目标的controller
// * 
// * @author March
// *
// */
//@Controller
//public class GoalsController {
//
//	@Autowired
//	private GoalsService goalsService;
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private UserProjectRelationService userProjectRelationService;
//
//	/**
//	 * 动态加载评价目标
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("getGoalsByProjectid")
//	public String getGoalsByProjectid(Model model) {
//		// model.addAttribute("goalslist",
//		// goalsService.getGoalsByProjectid("default"));
//		UserProjectRelation userProjectRelation = userProjectRelationService
//				.getUserProjectRelationByUserName(userService.getCurrentUserId());
//		if (userProjectRelation == null) {
//			return "none.ftl";
//		}
//		String projectId = userProjectRelation.getAutoProjectId();
//		List<Goals> goalslist = new ArrayList<Goals>(goalsService.getGoalsByProjectidTree(projectId));// 查询项目下的目标树形结构
//		if (goalslist.isEmpty()) {// 判断该项目下是否有已定制的目标，若为空
//			goalslist = goalsService.getDefaultGoals();// 查询默认目标的表结构
//			for (int i = 0; i < goalslist.size(); i++) {
//				goalslist.get(i).setProjectID(projectId);
//			}
//			goalsService.addGoals(goalslist);// 将默认目标置为当前项目的目标
//			goalslist = goalsService.getGoalsByProjectidTree(projectId);// 查询项目下的目标树形结构
//		}
//		model.addAttribute("goalslist", goalslist);
//		model.addAttribute("projectId", projectId);
//		return "goals.ftl";
//	}
//
//	/**
//	 * 增加一个目标
//	 * 
//	 * @param goalId
//	 * @param goalName
//	 * @param parentId
//	 * @param order
//	 * @param value
//	 * @param englishName
//	 * @param projectId
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("addGoal")
//	public BaseMsg addGoal(String goalId, String goalName, String parentId, Integer order, Integer value,
//			String englishName) {
//		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
//		goalsService.addOneGoal(new Goals(goalId, goalName, parentId, order, value, englishName, projectId));
//		return new BaseMsg(true, "目标添加成功！");
//	}
//
//	/**
//	 * 获取某项目下所有目标List结构
//	 * 
//	 * @param page
//	 * @param rows
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("getGolasbyProjectIdList")
//	public DataGrideRow<Goals> getGolasbyProjectIdList(@RequestParam(defaultValue = "1") int page, int rows) {
//		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
//		List<Goals> goals = goalsService.getGoalsByProjectIDList(projectId);
//		return new DataGrideRow<Goals>(goalsService.countSum(projectId), goals);
//	}
//
//	/**
//	 * 删除一个目标
//	 * 
//	 * @param goalId
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("deleteGoal")
//	public BaseMsg deleteGoal(String goalId) {
//		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
//		goalsService.deleteGoal(new GoalsIDAndProjectID(goalId, projectId));
//		return new BaseMsg(true, "目标删除成功！");
//	}
//}
