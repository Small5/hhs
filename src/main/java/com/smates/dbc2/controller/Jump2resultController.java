package com.smates.dbc2.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.smates.dbc2.mapper.Jump2resultDao;
import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.TblClimateScenarioYear;
import com.smates.dbc2.po.UpStream;
import com.smates.dbc2.service.Jump2resultService;
import com.smates.dbc2.service.JxlService;
import com.smates.dbc2.service.ModelFunctionService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.utils.StringUtils;
import com.smates.dbc2.vo.BaseMsg;

@Controller
public class Jump2resultController {

	@Autowired
	public Jump2resultDao jump2resultDao;
	@Autowired
	public UserProjectRelationService userProjectRelationService;
	@Autowired
	public UserService userService;
	@Autowired
	public JxlService jxlService;
	@Autowired
	public Jump2resultService resultService;
	@Autowired
	private ModelFunctionService modelFunctionService;
	
	public Logger logger = Logger.getLogger(Jump2resultController.class);
	
	@RequestMapping(value = "addAgentModel", method = RequestMethod.POST)
	public BaseMsg addAgentModel(MultipartFile upstream,MultipartFile hydrology,MultipartFile economic) throws IOException {
		//上游代理模型
		//if (!StringUtils.isEmpty(upstream.getOriginalFilename())) {
			String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
			jump2resultDao.deletecustomizedModelFunction(projectId);
			List<UpStream> upstreams = jxlService.getUpStreams(upstream.getInputStream());
//			System.out.println(upstreams);
			logger.info(upstreams.size());
			for (int i = 0; i < upstreams.size(); i++) {
				resultService.addUpStream(upstreams.get(i));
			}
		//}
//		//生态水文模型
//		if (!StringUtils.isEmpty(hydrology.getOriginalFilename())) {
//			watershedDao.deleteTblClimateScenarioYear(userService.getCurrentUserId());
//			List<TblClimateScenarioYear> tblClimateScenarioYears = jxlService
//					.getAllContenttblClimateScenarioYear(tblClimateScenarioYear.getInputStream());
//			logger.info(tblClimateScenarioYears.size() + "year");
//			for (int i = 0; i < tblClimateScenarioYears.size(); i++) {
//				watershedService.addTblClimateScenarioYear(tblClimateScenarioYears.get(i));
//			}
//		}
//		//社会经济模型
//		if (!StringUtils.isEmpty(economic.getOriginalFilename())) {
//			watershedDao.deleteTblClimateScenarioYear(userService.getCurrentUserId());
//			List<TblClimateScenarioYear> tblClimateScenarioYears = jxlService
//					.getAllContenttblClimateScenarioYear(tblClimateScenarioYear.getInputStream());
//			logger.info(tblClimateScenarioYears.size() + "year");
//			for (int i = 0; i < tblClimateScenarioYears.size(); i++) {
//				watershedService.addTblClimateScenarioYear(tblClimateScenarioYears.get(i));
//			}
//		}
		return new BaseMsg(true, "代理模型上传成功！");
	}
	
	@ResponseBody
	@RequestMapping(value = ("getTestFlag"), method = RequestMethod.GET)
	public String getTestFlag(){
		return modelFunctionService.getTestFlag();
	}
}
