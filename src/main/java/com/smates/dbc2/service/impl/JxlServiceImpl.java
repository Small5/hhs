package com.smates.dbc2.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.smates.dbc2.service.JxlService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
public class JxlServiceImpl implements JxlService {
	
	@Autowired
	public UserService userService;
	@Autowired
	public UserProjectRelationService userProjectRelationService;
	
	@Override
	public String getContent(int row, int col, InputStream fis) {
		jxl.Workbook rwb = null;
		String result = "";
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet sheet = rwb.getSheet(0);
			Cell[] cells = sheet.getRow(row);
			result = cells[col].getContents();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (fis != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return result;
	}
	
	//气候情景数据表(年
	@Override
	public List<TblClimateScenarioYear> getAllContenttblClimateScenarioYear(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldCRPType;
		String fldDate;
		double fldPrecipitation;
		double fldAvgTemperature;
		double fldMaxTemp;
		double fldMinTemp;
		List<TblClimateScenarioYear> datas = new ArrayList<TblClimateScenarioYear>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldCRPType = cells[2].getContents();
					fldDate = cells[3].getContents();
					fldPrecipitation = Double.parseDouble(cells[4].getContents());
					fldAvgTemperature = Double.parseDouble(cells[5].getContents());
					fldMaxTemp = Double.parseDouble(cells[6].getContents());
					fldMinTemp = Double.parseDouble(cells[7].getContents());
					datas.add(new TblClimateScenarioYear(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldCRPType, fldDate,
							fldPrecipitation, fldAvgTemperature, fldMaxTemp, fldMinTemp));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//气候情景数据表(月)
	@Override
	public List<TblClimateScenarioMonth> getAllContenttblClimateScenarioMonth(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldCRPType;
		String fldDate;
		double fldPrecipitation;
		double fldAvgTemperature;
		double fldMaxTemp;
		double fldMinTemp;
		List<TblClimateScenarioMonth> datas = new ArrayList<TblClimateScenarioMonth>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldCRPType = cells[2].getContents();
					fldDate = cells[3].getContents();
					fldPrecipitation = Double.parseDouble(cells[4].getContents());
					fldAvgTemperature = Double.parseDouble(cells[5].getContents());
					fldMaxTemp = Double.parseDouble(cells[6].getContents());
					fldMinTemp = Double.parseDouble(cells[7].getContents());
					datas.add(new TblClimateScenarioMonth(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldCRPType, fldDate,
							fldPrecipitation, fldAvgTemperature, fldMaxTemp, fldMinTemp));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	@Override
	public List<TblIndustyUrbanSce> getAllContenttTblIndustyUrbanSces(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		double fldFarmPop;
		double fldNonFarmPop;
		double fldIndOutput;
		double fldAgrOutput;
		double fldSerOutput;
		double fldTourOutput;
		double fldTechProgRatio;
		List<TblIndustyUrbanSce> datas = new ArrayList<TblIndustyUrbanSce>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldFarmPop = Double.parseDouble(cells[3].getContents());
					fldNonFarmPop = Double.parseDouble(cells[4].getContents());
					fldIndOutput = Double.parseDouble(cells[5].getContents());
					fldAgrOutput = Double.parseDouble(cells[6].getContents());
					fldSerOutput = Double.parseDouble(cells[7].getContents());
					fldTourOutput = Double.parseDouble(cells[8].getContents());
					fldTechProgRatio = Double.parseDouble(cells[9].getContents());
					datas.add(new TblIndustyUrbanSce(fldWatershedCode, fldCountyCode, fldDate, fldFarmPop,
							fldNonFarmPop, fldIndOutput, fldAgrOutput, fldSerOutput, fldTourOutput, fldTechProgRatio));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}
	
	//土地种类
	@Override
	public List<TblLandUseSce> getAllContentTblLandUseSce(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		double fldFarmArea;
		double fldWetlandArea;
		double fldForestArea;
		double fldGrassArea;
		double fldHuYangArea;
		double idfldWaterArea;
		List<TblLandUseSce> datas = new ArrayList<TblLandUseSce>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldFarmArea = Double.parseDouble(cells[3].getContents());
					fldWetlandArea = Double.parseDouble(cells[4].getContents());
					fldForestArea = Double.parseDouble(cells[5].getContents());
					fldGrassArea = Double.parseDouble(cells[6].getContents());
					fldHuYangArea = Double.parseDouble(cells[7].getContents());
					idfldWaterArea = Double.parseDouble(cells[8].getContents());
					datas.add(new TblLandUseSce(userService.getCurrentUserId(), fldWatershedCode, fldCountyCode, fldDate, fldFarmArea, fldWetlandArea,
							fldForestArea, fldGrassArea, fldHuYangArea, idfldWaterArea));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//种植结构
	@Override
	public List<TblCropPattern> getAllContentTblCropPattern(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		String fldCropType;
		double fldCropArea;
		double fldIrrQuota;
		double fldFertilizer;
		double fldYieldPer;
		double fldCropPrice;
		List<TblCropPattern> datas = new ArrayList<TblCropPattern>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldCropType = cells[3].getContents();
					fldCropArea = Double.parseDouble(cells[4].getContents());
					fldIrrQuota = Double.parseDouble(cells[5].getContents());
					fldFertilizer = Double.parseDouble(cells[6].getContents());
					fldYieldPer = Double.parseDouble(cells[7].getContents());
					fldCropPrice = Double.parseDouble(cells[8].getContents());
					datas.add(new TblCropPattern(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldDate, fldCropType, fldCropArea,
							fldIrrQuota, fldFertilizer, fldYieldPer, fldCropPrice));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//GDP数据
	@Override
	public List<TblSocioEconSce> getAllContentTblSocioEconSce(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		double fldPerCapGDP;
		double fldGDP;
		double fldPop;
		List<TblSocioEconSce> datas = new ArrayList<TblSocioEconSce>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			Cell[] cells = null;
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					try {
						fldPerCapGDP = Double.parseDouble(cells[3].getContents());
					} catch (Exception e) {
						fldPerCapGDP = 0;
					}
					try {
						fldGDP = Double.parseDouble(cells[4].getContents());
					} catch (Exception e) {
						fldGDP = 0;
					}
					try {
						fldPop = Double.parseDouble(cells[5].getContents());
					} catch (Exception e) {
						fldPop = 0;
					}
					datas.add(new TblSocioEconSce(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldDate, fldPerCapGDP, fldGDP,
							fldPop));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//优惠政策
	@Override
	public List<TblPrefPolicy> getAllContentTblPrefPolicy(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		String fldPrefPolicyType;
		double fldAllowance;
		List<TblPrefPolicy> datas = new ArrayList<TblPrefPolicy>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldPrefPolicyType = cells[3].getContents();
					fldAllowance = Double.parseDouble(cells[4].getContents());
					datas.add(new TblPrefPolicy(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldDate, fldPrefPolicyType,
							fldAllowance));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//水利工程
	@Override
	public List<TblHydrEngineering> getAllContentTblHydrEngineering(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		double fldMainCannelLeng;
		double fldMainCanWUE;
		double fldBranCannelLeng;
		double fldBranCanWUE;
		double fldDouLeng;
		double fldDouWUE;
		double fldNongLeng;
		double fldNongWUE;
		double fldMaoLeng;
		double fldMaoWUE;
		double fldSprinkingArea;
		double fldSprWUE;
		double fldDropIrrArea;
		double fldDropWUE;
		List<TblHydrEngineering> datas = new ArrayList<TblHydrEngineering>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldMainCannelLeng = Double.parseDouble(cells[3].getContents());
					fldMainCanWUE = Double.parseDouble(cells[4].getContents());
					fldBranCannelLeng = Double.parseDouble(cells[5].getContents());
					fldBranCanWUE = Double.parseDouble(cells[6].getContents());
					fldDouLeng = Double.parseDouble(cells[7].getContents());
					fldDouWUE = Double.parseDouble(cells[8].getContents());
					fldNongLeng = Double.parseDouble(cells[9].getContents());
					fldNongWUE = Double.parseDouble(cells[10].getContents());
					fldMaoLeng = Double.parseDouble(cells[11].getContents());
					fldMaoWUE = Double.parseDouble(cells[12].getContents());
					fldSprinkingArea = Double.parseDouble(cells[13].getContents());
					fldSprWUE = Double.parseDouble(cells[14].getContents());
					fldDropIrrArea = Double.parseDouble(cells[15].getContents());
					fldDropWUE = Double.parseDouble(cells[16].getContents());
					datas.add(new TblHydrEngineering(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldDate, fldMainCannelLeng,
							fldMainCanWUE, fldBranCannelLeng, fldBranCanWUE, fldDouLeng, fldDouWUE, fldNongLeng,
							fldNongWUE, fldMaoLeng, fldMaoWUE, fldSprinkingArea, fldSprWUE, fldDropIrrArea,
							fldDropWUE));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//水资源面积
	@Override
	public List<TblWaterResManSce> getAllContentTblWaterResManSce(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		double fldWaterManArea;
		double fldTransCoopArea;
		List<TblWaterResManSce> datas = new ArrayList<TblWaterResManSce>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldWaterManArea = Double.parseDouble(cells[3].getContents());
					fldTransCoopArea = Double.parseDouble(cells[4].getContents());
					datas.add(new TblWaterResManSce(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldDate, fldWaterManArea,
							fldTransCoopArea));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//县区三产用水量
	@Override
	public List<TblWaterUseCounty> getAllContentTblWaterUseCounty(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		double fldWaterUseAgr;
		double fldWaterUseInd;
		double fldWaterUseSer;
		List<TblWaterUseCounty> datas = new ArrayList<TblWaterUseCounty>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldWaterUseAgr = Double.parseDouble(cells[3].getContents());
					fldWaterUseInd = Double.parseDouble(cells[4].getContents());
					fldWaterUseSer = Double.parseDouble(cells[5].getContents());
					datas.add(new TblWaterUseCounty(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldDate, fldWaterUseAgr,
							fldWaterUseInd, fldWaterUseSer));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//县区水权分配
	@Override
	public List<TblWaterRightCounty> getAllContentTblWaterRightCounty(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCityCode;
		String fldCountyCode;
		String fldDate;
		double fldWaterRightRatio;
		List<TblWaterRightCounty> datas = new ArrayList<TblWaterRightCounty>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCityCode = cells[1].getContents();
					fldCountyCode = cells[2].getContents();
					fldDate = cells[3].getContents();
					fldWaterRightRatio = Double.parseDouble(cells[4].getContents());
					datas.add(new TblWaterRightCounty(userService.getCurrentUserId(),fldWatershedCode, fldCityCode, fldCountyCode, fldDate,
							fldWaterRightRatio));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//流域中下游水分配
	@Override
	public List<TblMidDownWaterAllo> getAllContentTblMidDownWaterAllo(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldDate;
		double fldWaterUseMid;
		double fldWaterUseDown;
		List<TblMidDownWaterAllo> datas = new ArrayList<TblMidDownWaterAllo>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldDate = cells[1].getContents();
					fldWaterUseMid = Double.parseDouble(cells[2].getContents());
					fldWaterUseDown = Double.parseDouble(cells[3].getContents());
					datas.add(new TblMidDownWaterAllo(userService.getCurrentUserId(),fldWatershedCode, fldDate, fldWaterUseMid, fldWaterUseDown));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//县区用水量
	@Override
	public List<TblWaterAlloCounty> getAllContentTblWaterAlloCounty(InputStream fis) {
		jxl.Workbook rwb = null;
		String fldWatershedCode;
		String fldCountyCode;
		String fldDate;
		double fldSurfaceWater;
		double fldGroundWater;
		List<TblWaterAlloCounty> datas = new ArrayList<TblWaterAlloCounty>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					fldWatershedCode = cells[0].getContents();
					fldCountyCode = cells[1].getContents();
					fldDate = cells[2].getContents();
					fldSurfaceWater = Double.parseDouble(cells[3].getContents());
					fldGroundWater = Double.parseDouble(cells[4].getContents());
					datas.add(new TblWaterAlloCounty(userService.getCurrentUserId(),fldWatershedCode, fldCountyCode, fldDate, fldSurfaceWater,
							fldGroundWater));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

	//上游代理模型
	@Override
	public List<UpStream> getUpStreams(InputStream fis) {
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		jxl.Workbook rwb = null;
		String functionTxt;
		List<UpStream> datas = new ArrayList<UpStream>();
		try {
			rwb = Workbook.getWorkbook(fis);
			Sheet[] sheets = rwb.getSheets();
//			System.out.println(sheets.length);
			
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = rwb.getSheet(i);
				for (int row = 1; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					functionTxt = cells[0].getContents();
					datas.add(new UpStream(projectId,"upStreamProxy", functionTxt));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}

			try {
				if (rwb != null) {
					rwb.close();
				}
			} catch (Exception e) {
			}
		}
		return datas;
	}

}
