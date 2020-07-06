//package com.smates.dbc2.service.impl;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.smates.dbc2.model.ModelAgriOutputPerHectare;
//import com.smates.dbc2.model.ModelForestCoverageRate;
//import com.smates.dbc2.model.ModelForestSustainableRate;
//import com.smates.dbc2.model.ModelGDPPerCapita;
//import com.smates.dbc2.model.ModelGDPPerPersonEmployed;
//import com.smates.dbc2.model.ModelGDPTourismRate;
//import com.smates.dbc2.model.ModelIWRMRate;
//import com.smates.dbc2.model.ModelLandPopuRate;
//import com.smates.dbc2.model.ModelMountainGreenCoverageRate;
//import com.smates.dbc2.model.ModelSafeDrinkingWaterRate;
//import com.smates.dbc2.model.ModelTourConsRate;
//import com.smates.dbc2.model.ModelTransboundaryAvailability;
//import com.smates.dbc2.model.ModelUrbanizationRate;
//import com.smates.dbc2.model.ModelWaterPressure;
//import com.smates.dbc2.model.ModelWaterProductivity;
//import com.smates.dbc2.model.ModelWaterProductivityAgri;
//import com.smates.dbc2.model.ModelWaterUseEfficiencyAgri;
//import com.smates.dbc2.model.ModelYouthEmpRate;
//import com.smates.dbc2.model.ModelYouthUnempRate;
//import com.smates.dbc2.service.IndexCalculateService;
//import com.smates.dbc2.ws.DoubleArray;
//
///**
// * 指标计算
// * 
// * @author baijw
// *
// */
//@Service
//public class IndexCalculateServiceImpl implements IndexCalculateService {
//
//	@Override
//	public double WaterProductivity(List<DoubleArray> modleOutput) {
//		ModelWaterProductivity modelWaterProductivity = new ModelWaterProductivity();
//		return modelWaterProductivity.calc(modleOutput.get(7).getItem().get(0), modleOutput.get(8).getItem().get(0),
//				modleOutput.get(9).getItem().get(0), modleOutput.get(30).getItem().get(0),
//				modleOutput.get(31).getItem().get(0), modleOutput.get(32).getItem().get(0));
//	}
//
//	@Override
//	public double reduceWaterUseP(List<DoubleArray> modleOutput) {
//		ModelWaterPressure modelWaterPressure = new ModelWaterPressure();
//		return modelWaterPressure.calc(modleOutput.get(30).getItem().get(0), modleOutput.get(31).getItem().get(0),
//				modleOutput.get(32).getItem().get(0), modleOutput.get(25).getItem().get(0));
//	}
//
//	@Override
//	public double SafeDrinkingWaterRate(List<DoubleArray> modleOutput) {
//		ModelSafeDrinkingWaterRate modelSafeDrinkingWaterRate = new ModelSafeDrinkingWaterRate();
//		return modelSafeDrinkingWaterRate.calc(modleOutput.get(44).getItem().get(0).intValue(), modleOutput.get(4).getItem().get(0).intValue());
//	}
//
//	/****************************************************************/
//	@Override
//	public double IWRMRate(List<DoubleArray> modleOutput) {
//		ModelIWRMRate modelIWRMRate = new ModelIWRMRate();
//		return modelIWRMRate.calc(modleOutput.get(52).getItem().get(0), modleOutput.get(52).getItem().get(0));
//	}
//
//	@Override
//	public double TransboundaryAvailability(List<DoubleArray> modleOutput) {
//		ModelTransboundaryAvailability modelTransboundaryAvailability = new ModelTransboundaryAvailability();
//		return modelTransboundaryAvailability.calc(modleOutput.get(51).getItem().get(0),modleOutput.get(50).getItem().get(0));
//	}
//
//	/****************************************************************/
//
//	@Override
//	public double OutputWetlandArea(List<DoubleArray> modleOutput) {
//		return modleOutput.get(21).getItem().get(0);
//	}
//
//	@Override
//	public double OutputMinWater(List<DoubleArray> modleOutput) {
//		return modleOutput.get(33).getItem().get(0);
//	}
//
//	@Override
//	public double OutputWaterExtraction(List<DoubleArray> modleOutput) {
//		return modleOutput.get(27).getItem().get(0);
//	}
//
//	@Override
//	public double OutputMidWaterUse(List<DoubleArray> modleOutput) {
//		return modleOutput.get(41).getItem().get(0);
//	}
//
//	/********************************************************/
//	@Override
//	public double ForestCoverageRate(List<DoubleArray> modleOutput) {
//		ModelForestCoverageRate modelForestCoverageRate = new ModelForestCoverageRate();
//		return modelForestCoverageRate.calc(modleOutput.get(8).getItem().get(0), modleOutput.get(45).getItem().get(0));
//	}
//
//	/*********************************************************/
//
//	/********************************************************/
//	@Override
//	public double ForestSustainableRate(List<DoubleArray> modleOutput) {
//		ModelForestSustainableRate modelForestSustainableRate = new ModelForestSustainableRate();
//		return modelForestSustainableRate.calc(modleOutput.get(41).getItem().get(0), modleOutput.get(8).getItem().get(0));
//	}
//
//	/********************************************************/
//
//	@Override
//	public double MountainGreenCoverageRate(List<DoubleArray> modleOutput) {
//		ModelMountainGreenCoverageRate modelMountainGreenCoverageRate = new ModelMountainGreenCoverageRate();
//		return modelMountainGreenCoverageRate.calc(modleOutput.get(37).getItem().get(0), modleOutput.get(35).getItem().get(0));
//	}
//
//	@Override
//	public double GDPPerCapita(List<DoubleArray> modleOutput) {
//		ModelGDPPerCapita modelGDPPerCapita = new ModelGDPPerCapita();
//		return modelGDPPerCapita.calc(modleOutput.get(23).getItem().get(0), modleOutput.get(4).getItem().get(0));
//	}
//
//	@Override
//	public double GDPPerPersonEmployed(List<DoubleArray> modleOutput) {
//		ModelGDPPerPersonEmployed modelGDPPerPersonEmployed = new ModelGDPPerPersonEmployed();
//		return modelGDPPerPersonEmployed.calc(modleOutput.get(23).getItem().get(0), modleOutput.get(8).getItem().get(0), modleOutput.get(45).getItem().get(0));
//	}
//
//	@Override
//	public double YouthEmpRate(List<DoubleArray> modleOutput) {
//		ModelYouthEmpRate modelYouthEmpRate = new ModelYouthEmpRate();
//		return modelYouthEmpRate.calc(modleOutput.get(47).getItem().get(0),modleOutput.get(46).getItem().get(0));
//	}
//
//	@Override
//	public double YouthUnempRate(List<DoubleArray> modleOutput) {
//		ModelYouthUnempRate modelYouthUnempRate = new ModelYouthUnempRate();
//		return modelYouthUnempRate.calc(modleOutput.get(48).getItem().get(0), modleOutput.get(46).getItem().get(0));
//	}
//
//	@Override
//	public double GDPTourismRate(List<DoubleArray> modleOutput) {
//		ModelGDPTourismRate modelGDPTourismRate = new ModelGDPTourismRate();
//		return modelGDPTourismRate.calc(modleOutput.get(10).getItem().get(0), modleOutput.get(23).getItem().get(0));
//	}
//
//	@Override
//	public double TourConsRate(List<DoubleArray> modleOutput) {
//		ModelTourConsRate modelTourConsRate = new ModelTourConsRate();
//		return modelTourConsRate.calc(modleOutput.get(53).getItem().get(0), modleOutput.get(54).getItem().get(0));
//	}
//
//	@Override
//	public double LandPopuRate(List<DoubleArray> modleOutput) {
//		ModelLandPopuRate modelLandPopuRate = new ModelLandPopuRate();
//		return modelLandPopuRate.calc(modleOutput.get(55).getItem().get(0), modleOutput.get(56).getItem().get(0));
//	}
//
//	/*******************************************************/
//	@Override
//	public double UrbanizationRate(List<DoubleArray> modleOutput) {
//		ModelUrbanizationRate modelUrbanizationRate = new ModelUrbanizationRate();
//		return modelUrbanizationRate.calc(modleOutput.get(8).getItem().get(0), modleOutput.get(9).getItem().get(0));
//	}
//
//	/********************************************************/
//
//	@Override
//	public double WaterProductivityAgri(List<DoubleArray> modleOutput) {
//		ModelWaterProductivityAgri modelWaterProductivityAgri = new ModelWaterProductivityAgri();
//		return modelWaterProductivityAgri.calc(modleOutput.get(8).getItem().get(0), modleOutput.get(31).getItem().get(0));
//	}
//
//	@Override
//	public double WaterUseEfficiencyAgri(List<DoubleArray> modleOutput) {
//		ModelWaterUseEfficiencyAgri modelWaterUseEfficiencyAgri = new ModelWaterUseEfficiencyAgri();
//		return modelWaterUseEfficiencyAgri.calc(modleOutput.get(28).getItem().get(0), modleOutput.get(40).getItem().get(0));
//	}
//
//	/**************************************************************/
//	@Override
//	public double AgriOutputPerHectare(List<DoubleArray> modleOutput) {
//		ModelAgriOutputPerHectare modelAgriOutputPerHectare = new ModelAgriOutputPerHectare();
//		return modelAgriOutputPerHectare.calc(modleOutput.get(8).getItem().get(0), modleOutput.get(7).getItem().get(0));
//	}
//
//	/****************************************************************/
//
//	@Override
//	public double OutputAgriArea(List<DoubleArray> modleOutput) {
//		return modleOutput.get(50).getItem().get(0);
//	}
//
//	@Override
//	public double OutputSocialWelWare(List<DoubleArray> modleOutput) {
//		return modleOutput.get(49).getItem().get(0);
//	}
//
//}
