package com.smates.dbc2.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.UserAndLanguageDao;
import com.smates.dbc2.po.UserAndLanuage;
import com.smates.dbc2.service.UserAndLanguageService;

@Service
public class UserAndLanguageServiceImpl implements UserAndLanguageService{
	
	@Autowired
	private UserAndLanguageDao userAndLanguageDao;

	@Override
	public String getUserAndLanuage(String accountNumber) {
		return userAndLanguageDao.getUserAndLanuageByAccountNumber(accountNumber).getLanguage();
	}

	@Override
	public void updateUserAndLanguage(String accountNumber, String language) {
		Map<String, String> paraMap = new HashMap<String,String>();
		paraMap.put("accountNumber", accountNumber);
		paraMap.put("language", language);
		userAndLanguageDao.updateUserAndLanguage(paraMap);
	}

	@Override
	public void updateUserLanguageAndGuide(String accountNumber, String language, String guide) {
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("accountNumber", accountNumber);
		paraMap.put("language", language);
		paraMap.put("guide", guide);
		userAndLanguageDao.updateUserLanguageAndGuide(paraMap);
	}

	@Override
	public UserAndLanuage getUserLanguageAndGuide(String accountNumber) {
		return userAndLanguageDao.getUserLanguageAndGuide(accountNumber);
	}

	@Override
	public void deleteUserLanguageAndGuide(String accountNumber) {
		userAndLanguageDao.deleteUserLanguageAndGuide(accountNumber);

	}

	@Override
	public void addUserLanguageAndGuide(String accountNumber, String language, String guide) {
		userAndLanguageDao.addUserLanguageAndGuide(new UserAndLanuage(accountNumber, language, guide));
	}

}
