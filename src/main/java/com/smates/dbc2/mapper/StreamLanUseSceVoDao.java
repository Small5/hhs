package com.smates.dbc2.mapper;

import java.util.List;

import com.smates.dbc2.vo.StreamLanUseSceVo;

/**
 * GIS全局变量【耕地面积、湿地面积】
 * @author baijw
 *
 */
public interface StreamLanUseSceVoDao {
	
	/**
	 * 按流域获取土地利用情景
	 * @return
	 */
	public List<StreamLanUseSceVo> getStreamLanUseSceVo(String stream);
	
}
