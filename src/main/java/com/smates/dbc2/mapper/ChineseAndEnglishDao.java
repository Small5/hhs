package com.smates.dbc2.mapper;

import com.smates.dbc2.po.ChineseAndEnglish;

/**
 * 中英对照查询
 * @author baijw
 * 
 * @date 2017年3月7日 上午9:57:03
 */
public interface ChineseAndEnglishDao {
	
	/**
	 * 根据序号(主键)获取中英对照词表
	 * @param index 序号
	 * @return
	 */
	public ChineseAndEnglish getChineseAndEnglishByIndex(int index);

}
