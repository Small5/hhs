package com.smates.dbc2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.AssessResult;
import com.smates.dbc2.po.UserProjectRelation;

@Controller
public class MapGISController extends BaseController{

	@RequestMapping(value = "mapgis", method = RequestMethod.GET)
	public String jumptomapgis(ModelMap modelMap) {
		String userName = userService.getCurrentUserId();//鑾峰彇褰撳墠鐧诲綍鐨勭敤鎴疯处鍙�
		UserProjectRelation userProjectRelation = userProjectRelationService.getUserProjectRelationByUserName(userName);
		userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		modelMap.addAttribute("projectId", userProjectRelation.getAutoProjectId());
		modelMap.addAttribute("colormap", chineseAndEnglishService.getPhraseByIndexAndLanguage(216, userLanguage));
		modelMap.addAttribute("graymap", chineseAndEnglishService.getPhraseByIndexAndLanguage(217, userLanguage));
		modelMap.addAttribute("imgmap", chineseAndEnglishService.getPhraseByIndexAndLanguage(218, userLanguage));
		modelMap.addAttribute("boundary", chineseAndEnglishService.getPhraseByIndexAndLanguage(219, userLanguage));
		modelMap.addAttribute("county", chineseAndEnglishService.getPhraseByIndexAndLanguage(220, userLanguage));
		modelMap.addAttribute("town", chineseAndEnglishService.getPhraseByIndexAndLanguage(221, userLanguage));
		modelMap.addAttribute("river", chineseAndEnglishService.getPhraseByIndexAndLanguage(222, userLanguage));
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
		modelMap.addAttribute("findex", chineseAndEnglishService.getPhraseByIndexAndLanguage(223, userLanguage));
		modelMap.addAttribute("level", chineseAndEnglishService.getPhraseByIndexAndLanguage(224, userLanguage));
		modelMap.addAttribute("index1", chineseAndEnglishService.getPhraseByIndexAndLanguage(192, userLanguage));
		modelMap.addAttribute("index2", chineseAndEnglishService.getPhraseByIndexAndLanguage(193, userLanguage));
		modelMap.addAttribute("index3", chineseAndEnglishService.getPhraseByIndexAndLanguage(194, userLanguage));
		modelMap.addAttribute("index4", chineseAndEnglishService.getPhraseByIndexAndLanguage(195, userLanguage));
		modelMap.addAttribute("evaindex", chineseAndEnglishService.getPhraseByIndexAndLanguage(225, userLanguage));
		modelMap.addAttribute("year", chineseAndEnglishService.getPhraseByIndexAndLanguage(226, userLanguage));
		modelMap.addAttribute("Language",userLanguage);
		modelMap.addAttribute("indexnum",chineseAndEnglishService.getPhraseByIndexAndLanguage(318, userLanguage));
		
		modelMap.addAttribute("right1",chineseAndEnglishService.getPhraseByIndexAndLanguage(319, userLanguage));
		modelMap.addAttribute("right2",chineseAndEnglishService.getPhraseByIndexAndLanguage(320, userLanguage));
		modelMap.addAttribute("right3",chineseAndEnglishService.getPhraseByIndexAndLanguage(321, userLanguage));
		modelMap.addAttribute("right4",chineseAndEnglishService.getPhraseByIndexAndLanguage(322, userLanguage));
		modelMap.addAttribute("right5",chineseAndEnglishService.getPhraseByIndexAndLanguage(323, userLanguage));
		modelMap.addAttribute("right6",chineseAndEnglishService.getPhraseByIndexAndLanguage(324, userLanguage));
		modelMap.addAttribute("right7",chineseAndEnglishService.getPhraseByIndexAndLanguage(325, userLanguage));
		modelMap.addAttribute("right8",chineseAndEnglishService.getPhraseByIndexAndLanguage(326, userLanguage));
		modelMap.addAttribute("right9",chineseAndEnglishService.getPhraseByIndexAndLanguage(327, userLanguage));
		
		return "mapGIS.ftl";
	}
}
