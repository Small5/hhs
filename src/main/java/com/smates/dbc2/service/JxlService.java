package com.smates.dbc2.service;

import java.io.InputStream;
import java.util.List;

import com.smates.dbc2.po.TblClimateScenarioMonth;
import com.smates.dbc2.po.TblClimateScenarioYear;
import com.smates.dbc2.po.TblCropPattern;
import com.smates.dbc2.po.TblHydrEngineering;
import com.smates.dbc2.po.TblIndustyUrbanSce;
import com.smates.dbc2.po.TblLandUseSce;
import com.smates.dbc2.po.TbLanduseScePara;
import com.smates.dbc2.po.TblMidDownWaterAllo;
import com.smates.dbc2.po.TblPrefPolicy;
import com.smates.dbc2.po.TblSocioEconSce;
import com.smates.dbc2.po.TblWaterAlloCounty;
import com.smates.dbc2.po.TblWaterResManSce;
import com.smates.dbc2.po.TblWaterRightCounty;
import com.smates.dbc2.po.TblWaterUseCounty;
import com.smates.dbc2.po.UpStream;


public interface JxlService {

	/**
	 * 获取excel的指定位置的内容
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public String getContent(int row, int col, InputStream fis);
	
	/**
	 * 一次得到文件所有内容(气候情景数据表(年))
	 * @param fis 文件输入流
	 * @return
	 */
	public List<TblClimateScenarioYear> getAllContenttblClimateScenarioYear(InputStream fis);
	
	/**
	 * 一次得到文件所有内容(气候情景数据表(月))
	 * @param fis 文件输入流
	 * @return
	 */
	public List<TblClimateScenarioMonth> getAllContenttblClimateScenarioMonth(InputStream fis);
	
	/**
	 * 一次得到文件所有内容(产业与城市发展情景)
	 * @param fis
	 * @return
	 */
	public List<TblIndustyUrbanSce> getAllContenttTblIndustyUrbanSces(InputStream fis);
	
	/**
	 * 一次得到文件所有内容(土地种类)
	 * @param fis
	 * @return
	 */
	public List<TblLandUseSce> getAllContentTblLandUseSce(InputStream fis);
	
	/**
	 * 一次得到文件所有内容(种植结构)
	 * @param fis
	 * @return
	 */
	public List<TblCropPattern> getAllContentTblCropPattern(InputStream fis);

	/**
	 * 一次得到文件所有内容(GDP数据)
	 * @param fis
	 * @return
	 */
	public List<TblSocioEconSce> getAllContentTblSocioEconSce(InputStream fis);

	/**
	 * 一次得到文件所有内容(优惠政策表)
	 * @param fis
	 * @return
	 */
	public List<TblPrefPolicy> getAllContentTblPrefPolicy(InputStream fis);

	/**
	 * 一次得到文件所有内容(水利工程数据)
	 * @param fis
	 * @return
	 */
	public List<TblHydrEngineering> getAllContentTblHydrEngineering(InputStream fis);

	/**
	 * 一次得到文件所有内容(水资源面积)
	 * @param fis
	 * @return
	 */
	public List<TblWaterResManSce> getAllContentTblWaterResManSce(InputStream fis);

	/**
	 * 一次得到文件所有内容(县区三产用水量)
	 * @param fis
	 * @return
	 */
	public List<TblWaterUseCounty> getAllContentTblWaterUseCounty(InputStream fis);

	/**
	 * 一次得到文件所有内容(县区水权分配)
	 * @param fis
	 * @return
	 */
	public List<TblWaterRightCounty> getAllContentTblWaterRightCounty(InputStream fis);

	/**
	 * 一次得到文件所有内容(流域中下游水分配)
	 * @param fis
	 * @return
	 */
	public List<TblMidDownWaterAllo> getAllContentTblMidDownWaterAllo(InputStream fis);

	/**
	 * 一次得到文件所有内容(县区用水量)
	 * @param fis
	 * @return
	 */
	public List<TblWaterAlloCounty> getAllContentTblWaterAlloCounty(InputStream fis);
	
	/**
	 * 一次性得到上游代理模型
	 * @param fis
	 * @return
	 */
	public List<UpStream> getUpStreams(InputStream fis);

}
