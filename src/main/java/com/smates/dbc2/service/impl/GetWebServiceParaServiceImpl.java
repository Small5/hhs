package com.smates.dbc2.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.CountryDao;
import com.smates.dbc2.mapper.ProjectDao;
import com.smates.dbc2.mapper.WatershedDao;
import com.smates.dbc2.mapper.WatershedParaDao;
import com.smates.dbc2.po.Country;
import com.smates.dbc2.po.Project;
import com.smates.dbc2.service.GetWebServiceParaService;
import com.smates.dbc2.vo.DoubleArray;
import com.smates.dbc2.vo.UsernameAndProjectId;
import com.smates.dbc2.vo.UsernameAndWatershedId;
//import com.smates.dbc2.ws.DoubleArray;

@Service
public class GetWebServiceParaServiceImpl implements GetWebServiceParaService {

	@Autowired
	private CountryDao countrydao;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private WatershedDao watershedDao;

	@Autowired
	private WatershedParaDao watershedParaDao;

	@Override
	public List<String> getCountryCodes() {
		List<String> CountryCodes = new ArrayList<String>();
		List<Country> countries = countrydao.getAllCountry();
		for (int i = 0; i < countries.size(); i++) {
			CountryCodes.add(countries.get(i).getCountryId());
		}
		return CountryCodes;
	}

	@Override
	public List<String> getCountryNames() {
		List<String> CountryNames = new ArrayList<String>();
		List<Country> countries = countrydao.getAllCountry();
		for (int i = 0; i < countries.size(); i++) {
			CountryNames.add(countries.get(i).getCountryName());
		}
		return CountryNames;
	}

	/**
	 * 查询项目信息
	 */
	@Override
	public Project getProjectById(String username,String projectId) {
		return projectDao.getProjectByUsernameAndId(new UsernameAndProjectId(username,projectId));
	}

	@Override
	public List<DoubleArray> getTblClimateScenarioYear() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblClimateScenarioYear(),"getFldDate","getFldPrecipitation");
	}

	private List<DoubleArray> ToDoubleArray(List<?> tblClimateScenarioYears, String DateMethod, String dataMethod)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz;
		Method dateMethodName = null;
		Method dataMethodName = null;
		List<DoubleArray> para = new ArrayList<DoubleArray>();
		List<Double> items = new ArrayList<Double>();
		String date = null;
		for (int i = 0; i < tblClimateScenarioYears.size(); i++) {

			clazz = tblClimateScenarioYears.get(i).getClass();
			try {
				dateMethodName = clazz.getDeclaredMethod(DateMethod);
				dataMethodName = clazz.getDeclaredMethod(dataMethod);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}

			if (date == null) {
				date = (String) dateMethodName.invoke(tblClimateScenarioYears.get(i), null);
			}
			if (date.equals((String) dateMethodName.invoke(tblClimateScenarioYears.get(i), null))) {
				try{
					items.add(Double.parseDouble((String)dataMethodName.invoke(tblClimateScenarioYears.get(i), null)));
				}catch (Exception e) {
					items.add((Double)dataMethodName.invoke(tblClimateScenarioYears.get(i), null));
				}
				
				
			} else {
				para.add(new DoubleArray(items));
				items = new ArrayList<Double>();
				date = (String) dateMethodName.invoke(tblClimateScenarioYears.get(i), null);
				try{
					items.add(Double.parseDouble((String)dataMethodName.invoke(tblClimateScenarioYears.get(i), null)));
				}catch (Exception e) {
					items.add((Double)dataMethodName.invoke(tblClimateScenarioYears.get(i), null));
				}
			}
		}
		para.add(new DoubleArray(items));
		return para;
	}

//	@Override
//	public List<DoubleArray> getprecR(String projectId) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
////		return ToDoubleArray(watershedParaDao.getTblClimateSceParaByProjectId(projectId),"getYear","getRainInc");
//	}

	@Override
	public List<DoubleArray> gettempAvg()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblClimateScenarioYear(),"getFldDate","getFldAvgTemperature");
	}

	@Override
	public List<DoubleArray> gettempMax()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblClimateScenarioYear(),"getFldDate","getFldMaxTemp");
	}

	@Override
	public List<DoubleArray> gettempMin()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblClimateScenarioYear(),"getFldDate","getFldMinTemp");

	}

	@Override
	public List<DoubleArray> getTblMidDownWaterAllo()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblMidDownWaterAllo(),"getFldDate","getFldWaterUseMid");
	}

	@Override
	public List<DoubleArray> getTblDownDownWaterAllo()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblMidDownWaterAllo(),"getFldDate","getFldWaterUseDown");
	}

	@Override
	public List<DoubleArray> getfldWaterRightRatio(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbWaterManSceWRParaByProjectId(projectId),"getFldDate","getFldWaterRightRatio");
	}

	@Override
	public List<DoubleArray> getSaveWater(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getSaveWaterByProjectId(projectId),"getYear","getSavewater");
	}

	@Override
	public List<DoubleArray> getGDP()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblSocioEconSce(),"getFldDate","getFldGDP");
	}

	@Override
	public List<DoubleArray> getgdpPer()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblSocioEconSce(),"getFldDate","getFldPerCapGDP");
	}

	@Override
	public List<DoubleArray> getGDPInc(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getPerCapGDP");
	}

	@Override
	public List<DoubleArray> getGDPperInc(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getPerCapGDPR");
	}

	@Override
	public List<DoubleArray> getchannelMain(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldMainCannelLeng");
	}

	@Override
	public List<DoubleArray> getchannelBran(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldBranCannelLeng");
	}

	@Override
	public List<DoubleArray> getchannelDou(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldDouLeng");
	}

	@Override
	public List<DoubleArray> getchannelNong(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldNongLeng");
	}

	@Override
	public List<DoubleArray> getchannelMao(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldMaoLeng");
	}

	
	
	
	@Override
	public List<DoubleArray> getchannelMainWUE(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldMainCanWUE");
	}

	@Override
	public List<DoubleArray> getchannelBranWUE(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldBranCanWUE");
	}

	@Override
	public List<DoubleArray> getchannelDouWUE(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldDouWUE");
	}

	@Override
	public List<DoubleArray> getchannelNongWUE(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldNongWUE");
	}

	@Override
	public List<DoubleArray> getchannelMaoWUE(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldMaoWUE");
	}

	@Override
	public List<DoubleArray> getareaDripIrri(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldDropIrrArea");
	}

	@Override
	public List<DoubleArray> getallowanceInd(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldIndustryAllowance");
	}

	@Override
	public List<DoubleArray> getallowanceAgr(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldFarmAllowance");
	}

	@Override
	public List<DoubleArray> getallowanceSer(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTbSocioEconomyScePara(projectId),"getYear","getFldServiceAllowance");
	}

	@Override
	public List<DoubleArray> getareaAgri(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getFldFarmArea");
	}

	@Override
	public List<DoubleArray> getareaAgriR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getFldFarmAreaChgR");
	}

	@Override
	public List<DoubleArray> getareaCropWheat(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getWheatArea");
	}

	@Override
	public List<DoubleArray> getareaCropCorn(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getCornArea");
	}

	@Override
	public List<DoubleArray> getareaCropOilseed(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getOilPlantsArea");
	}

	@Override
	public List<DoubleArray> getareaCropOrchard(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getOrchardArea");
	}

	@Override
	public List<DoubleArray> getareaCropCotton(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getCottonArea");
	}

	@Override
	public List<DoubleArray> getareaCropGreenstuff(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getVegetablesArea");
	}

	@Override
	public List<DoubleArray> getareaCropWheatR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getWheatChgR");
	}

	@Override
	public List<DoubleArray> getareaCropCornR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getCornChgR");
	}

	@Override
	public List<DoubleArray> getareaCropOilseedR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getOilPlantsChgR");
	}

	@Override
	public List<DoubleArray> getareaCropOrchardR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getOrchardChgR");
	}

	@Override
	public List<DoubleArray> getareaCropCottonR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getCottonChgR");
	}

	@Override
	public List<DoubleArray> getareaCropGreenstuffR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getVegetablesChgR");
	}

	@Override
	public List<DoubleArray> getareaWetland(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getWetlandArea");
	}

	@Override
	public List<DoubleArray> getareaForest(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getForestArea");
	}

	@Override
	public List<DoubleArray> getareaGrass(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getGrassArea");
	}

	@Override
	public List<DoubleArray> getareaWater(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.geTbLanduseScePara(projectId),"getYear","getWaterArea");
	}

	@Override
	public List<DoubleArray> getpopNonAgriRR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTblIndUrbanScePara(projectId),"getYear","getNonFarmPercent");
	}

	@Override
	public List<DoubleArray> getoutputInd()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblIndustyUrbanSce(), "getFldDate", "getFldIndOutput");
	}

	@Override
	public List<DoubleArray> getoutputAgr()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblIndustyUrbanSce(), "getFldDate", "getFldAgrOutput");
	}

	@Override
	public List<DoubleArray> getoutputSer()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblIndustyUrbanSce(), "getFldDate", "getFldSerOutput");
	}

	@Override
	public List<DoubleArray> getoutputTour()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedDao.getTblIndustyUrbanSce(), "getFldDate", "getFldTourOutput");
	}

	@Override
	public List<DoubleArray> getoutputTourR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTblIndUrbanScePara(projectId),"getYear","getChangeRateOfTourismIndustry");
	}

	@Override
	public List<DoubleArray> gettechProgRR(String projectId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ToDoubleArray(watershedParaDao.getTblIndUrbanScePara(projectId),"getYear","getIndustryProgressRate");
	}

}
