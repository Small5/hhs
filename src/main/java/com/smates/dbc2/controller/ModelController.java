package com.smates.dbc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.service.ModelService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;

@Controller
public class ModelController {

	@Autowired
	private ModelService modelservice;
	@Autowired
	private UserService userService;
	@Autowired
	public UserProjectRelationService userProjectRelationService;

	/**
	 * 查询模型算出结果年份列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = ("queryAvailablews"), method = RequestMethod.GET)
	public List<String> queryAvailablews(String countyId) {
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		//System.out.println(projectId+"/"+countyId);	
		return modelservice.queryAvailable(projectId,countyId);
	}
	
	@ResponseBody
	@RequestMapping(value = ("getDataYearlyws"), method = RequestMethod.GET)
	public List<Indicators> getDataYearlyws(String countyId,String year){
		//System.err.println("传过来的年份是："+year);
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		return modelservice.getDataYearlyws(projectId,countyId,year);
	}
	
	@ResponseBody
	@RequestMapping(value = ("getgoalyear"), method = RequestMethod.GET)
	public String getgoalyear() {
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		return modelservice.getgoalyear(projectId);
	}
	
	@ResponseBody
	@RequestMapping(value = "inputStartTime", method = RequestMethod.POST)
	public void inputStartTime() {
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		modelservice.deleteStartTime(projectId);
		modelservice.inputStartTime(projectId);
	}
	
	@ResponseBody
	@RequestMapping(value = "inputEndTime", method = RequestMethod.POST)
	public void inputEndTime() {
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		modelservice.deleteEndTime(projectId);
		modelservice.inputEndTime(projectId);
	}
	
	@ResponseBody
	@RequestMapping(value = ("getStartTime"), method = RequestMethod.GET)
	public String getStartTime() {
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		return modelservice.getStartTime(projectId);
	}
	
	@ResponseBody
	@RequestMapping(value = ("getEndTime"), method = RequestMethod.GET)
	public String getEndTime() {
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		return modelservice.getEndTime(projectId);
	}
}
