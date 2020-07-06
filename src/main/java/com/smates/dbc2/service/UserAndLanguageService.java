package com.smates.dbc2.service;

import com.smates.dbc2.po.UserAndLanuage;

/**
 * 获取用户语言业务接口
 * 
 * @author baijw
 * 
 * @date 2017年3月7日 上午10:48:17
 */
public interface UserAndLanguageService {

	/**
	 * 获取用户使用的语言
	 * 
	 * @param accountNumber
	 * 
	 * @return
	 */
	public String getUserAndLanuage(String accountNumber);
	
	/**
	 * 更改用户默认的语言
	 * @param accountNumber 用户账号
	 * @param language 用户默认语言
	 */
	public void updateUserAndLanguage(String accountNumber,String language);

	/**
	 * 修改用户默认语言和新手引导
	 * 
	 * @param
	 */
	public void updateUserLanguageAndGuide(String accountNumber, String language, String guide);

	/**
	 * 增加用户默认语言和新手引导
	 * 
	 * @param accountNumber
	 */
	public void addUserLanguageAndGuide(String accountNumber, String language, String guide);

	/**
	 * 删除用户语言和新手引导
	 * 
	 * @param accountNumber
	 */
	public void deleteUserLanguageAndGuide(String accountNumber);

	/**
	 * 获取用户的语言和指引设置
	 * 
	 * @param accountNumber
	 * @return
	 */
	public UserAndLanuage getUserLanguageAndGuide(String accountNumber);

}
