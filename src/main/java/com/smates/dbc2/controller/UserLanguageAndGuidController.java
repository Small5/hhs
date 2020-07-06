package com.smates.dbc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smates.dbc2.po.UserAndLanuage;
import com.smates.dbc2.service.UserAndLanguageService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.vo.BaseMsg;

/**
 * 用户设置页面的controller
 * 
 * @author March
 *
 */
@Controller
public class UserLanguageAndGuidController {

	@Autowired
	private UserAndLanguageService userAndLanguageService;

	@Autowired
	private UserService userService;

	/**
	 * 获取用户的语言和新手指引选项
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserLanguageAndGuid")
	public UserAndLanuage getUserLanguageAndGuid() {
		UserAndLanuage userAndLanuage = userAndLanguageService.getUserLanguageAndGuide(userService.getCurrentUserId());
		return userAndLanuage;
	}

	/**
	 * 修改用户的语言和新手指引选项
	 * 
	 * @param language
	 * @param guide
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateUserLanguageAndGuide")
	public BaseMsg updateUserLanguageAndGuide(String language, String guide) {
		userAndLanguageService.updateUserLanguageAndGuide(userService.getCurrentUserId(), language, guide);
		// userAndLanguageService.deleteUserLanguageAndGuide(userService.getCurrentUserId());
		// userAndLanguageService.addUserLanguageAndGuide(userService.getCurrentUserId(),
		// language, guide);
		return new BaseMsg(true, "修改成功");
	}
}
