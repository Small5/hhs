package com.smates.dbc2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.ChineseAndEnglishDao;
import com.smates.dbc2.po.ChineseAndEnglish;
import com.smates.dbc2.service.ChineseAndEnglishService;

/**
 * 中英对照业务实现
 * @author baijw
 * 
 * @date 2017年3月7日 上午10:12:13
 */
@Service
public class ChineseAndEnglishServiceImpl implements ChineseAndEnglishService{

	@Autowired
	private ChineseAndEnglishDao chineseAndEnglishDao;
	
	@Override
	public String getPhraseByIndexAndLanguage(int index, String lanuage) {
		ChineseAndEnglish ce = chineseAndEnglishDao.getChineseAndEnglishByIndex(index);
		if (lanuage==null) {//默认语言为空时,显示汉语界面
			return ce.getChinese();
		}
		if(lanuage.equals("chinese")){
			return ce.getChinese();
		}
		return ce.getEnglish();
	}

}
