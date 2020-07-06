package com.smates.dbc2.service;

/**
 * 中英对照业务接口
 * 
 * @author baijw
 * 
 * @date 2017年3月7日 上午10:07:06
 */
public interface ChineseAndEnglishService {

	/**
	 * 根据序号和语言获取对应的词条
	 * @param index 序号
	 * @param lanuage 语言
	 * @return
	 */
	public String getPhraseByIndexAndLanguage(int index,String lanuage);
	
}
