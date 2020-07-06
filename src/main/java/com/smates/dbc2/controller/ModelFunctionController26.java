//package com.smates.dbc2.controller;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.smates.dbc2.po.AssessResult;
//import com.smates.dbc2.po.ClimatePara;
//import com.smates.dbc2.po.EcoPara;
//import com.smates.dbc2.po.Goal;
//import com.smates.dbc2.po.IndicatorInfo;
//import com.smates.dbc2.po.IndicatorPara;
//import com.smates.dbc2.po.IndicatorWeight;
//import com.smates.dbc2.po.Indicators;
//import com.smates.dbc2.po.JxelUseMath;
//import com.smates.dbc2.po.LandPara;
//import com.smates.dbc2.po.ModelOutput;
//import com.smates.dbc2.po.Project;
//import com.smates.dbc2.po.TestManyOutput;
//import com.smates.dbc2.po.WaterPara;
//import com.smates.dbc2.service.GetWebServiceParaService;
//import com.smates.dbc2.service.GoalService;
//import com.smates.dbc2.service.IndicatorsService;
//import com.smates.dbc2.service.ModelFunctionService;
//import com.smates.dbc2.service.UserAndLanguageService;
//import com.smates.dbc2.service.UserService;
//import com.smates.dbc2.vo.BaseMsg;
//import com.smates.dbc2.ws.IModelEconomic;
//import com.smates.dbc2.ws.IModelEconomicImpl;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import libsvm.svm;
//import libsvm.svm_model;
//import libsvm.svm_node;
//import net.sf.json.JSONObject;
//@Controller
//public class ModelFunctionController26 {
//
//	@Autowired
//	private GetWebServiceParaService getWebServiceParaService;  
//	@Autowired
//	private IndicatorsService indicatorsService;
//	@Autowired
//	private ModelFunctionService modelFunctionService;
//	@Autowired
//	private GoalService goalService;
//	@Autowired
//	private UserService userservice;
//	@Autowired
//	public UserAndLanguageService userAndLanguageService;
//	
//	
//	static boolean flag1 = true;
//	static boolean flag2 = true;
//	static boolean flag3 = true;
//	static boolean flag4 = true;
//	static boolean flag5 = true;
//	
//	
//	@ResponseBody
//    @RequestMapping(value = "startAssessTest", method = RequestMethod.POST)
//    public String startAssessTest(String projectId)
//    {
//		List<Indicators> indiList=modelFunctionService.getIndicatorsbyProjectId(projectId);
//	    if(indiList.size()==0)
//	    {
//	    	return "本项目的指标输出结果不存在";
//	    }
//	    int num=indiList.size();
//	    String lineArr[]=new String[num];
//	    AssessResult scoreArr[]=new AssessResult[num];
//	    Indicators indicator;
//	    int i;
//	    for(i=0;i<num;i++)
//	    {
//	    	indicator=indiList.get(i);
//	    	scoreArr[i]=new AssessResult();
//	    	scoreArr[i].setProjectId(projectId);
//	    	scoreArr[i].setCountyId(indicator.getCountyId());
//	    	scoreArr[i].setYear(indicator.getYear());
//	    	scoreArr[i].setTotalscore("2");
//	    	scoreArr[i].setGoal1score("1");
//	    	scoreArr[i].setGoal2score("2");
//	    	scoreArr[i].setGoal3score("3");
//	    	scoreArr[i].setTotalindex("4.4");
//	    	scoreArr[i].setGoal1index("1.1");
//	    	scoreArr[i].setGoal2index("2.2");
//	    	scoreArr[i].setGoal3index("3.3");
//	    }
//	    modelFunctionService.deleteAssessResultbyProjectId(projectId);
//		for(i=0;i<num;i++)
//		{
//			modelFunctionService.insertScores(scoreArr[i]);
//		}
//		return "指标已评价完成并存入数据库";
//    }
//	@ResponseBody
//    @RequestMapping(value = "startAssess", method = RequestMethod.POST)
//     public BaseMsg startAssess(String projectId,Boolean sub)//主观sub=true;客观 sub=false
//    {	
//		String userLanguage = userAndLanguageService.getUserAndLanuage(userservice.getCurrentUserId());
//		if(sub==true)//每个指标主观赋权
//		{
//			String path="";
//			String flagstr=""; 
//			if(flag1==true)
//			{
//				flag1=false;
//				path="/opt/submodel/eval1/";
//				flagstr="flag1";
//				
//			}
//			else if(flag2==true)
//			{
//				flag2=false;
//				path="/opt/submodel/eval2/";
//				flagstr="flag2";
//				
//			}
//			else if(flag3==true)
//			{
//				flag3=false;
//				path="/opt/submodel/eval3/";
//				flagstr="flag3";
//				
//			}
//			else if(flag4==true)
//			{
//				flag4=false;
//				path="/opt/submodel/eval4/";
//				flagstr="flag4";
//				
//			}
//			else if(flag5==true)
//			{
//				flag5=false;
//				path="/opt/submodel/eval5/";
//				flagstr="flag5";
//				
//			}
//			else
//			{
//				if(userLanguage.equals("chinese")) {
//					return new BaseMsg(true,"评价程序都被占用，请稍后再试！");
//				}else {
//					return new BaseMsg(true,"Evaluation procedures are occupied, please try again later！");
//				}
//			}
//			
//			String username = userservice.getCurrentUserId();
//			//查询数据库，组合评价python程序需要的字符串，修改两个文件，运行程序，得到输出字符串，解析输出字符串，存到评分数据库表
//			Project myPro=getWebServiceParaService.getProjectById(username,projectId);
//			if(myPro==null)
//			{
//				setFlag(flagstr);
//				if(userLanguage.equals("chinese")) {
//					return new BaseMsg(true,"项目信息不存在");
//				}else {
//					return new BaseMsg(true,"Project information does not exist");
//				}
//			}
//					List<IndicatorInfo> indiInfoList=modelFunctionService.getIndicatorInfo(myPro.getWatershedId());
//					if(indiInfoList.size()==0)
//					{
//						setFlag(flagstr);
//						if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标基本信息不存在");
//						}else {
//							return new BaseMsg(true,"The basic information of the indicator does not exist.");
//						}
//					}
//					Goal goal=goalService.getGoalById(projectId);
//			     	if(goal==null)
//			     	{
//			     		setFlag(flagstr);
//			     		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"项目目标信息不存在");
//						}else {
//							return new BaseMsg(true,"Project information does not exist");
//						}
//			     	}
//			     	
//			     	int gw1,gw2,gw3;
//			     	String gwstr1=goal.getGoal_1();
//			     	String gwstr2=goal.getGoal_2();
//			     	String gwstr3=goal.getGoal_3();
//			     	
//			     	String indiweight[]=new String[13];
//			     	if(gwstr1.equals("undefined") || gwstr1.equals("undefined") || gwstr1.equals("undefined"))
//			     	{
//			     		setFlag(flagstr);
//			     		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"项目目标权重未指定");
//						}else {
//							return new BaseMsg(true,"Project weight not specified");
//						}
//			     	}
//			     	gw1=Integer.parseInt(gwstr1);
//			     	gw2=Integer.parseInt(gwstr2);
//			     	gw3=Integer.parseInt(gwstr3);
//			     	int temp=gw1+gw2+gw3;
//			     	if(temp!=100)
//			     	{
//			     		setFlag(flagstr);
//			     		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"目标权重之和应等于100");
//						}else {
//							return new BaseMsg(true,"The sum of the target weights should equal 100");
//						}
//			     	}
//			     	float fgw1=(float) (gw1*0.01);
//			     	float fgw2=(float) (gw2*0.01);
//			     	float fgw3=(float) (gw3*0.01);
//			     	
//			     	String wstr=""+fgw1+" "+fgw2+" "+fgw3;
//			     	
//			     	//把权重表先删了
//			     	modelFunctionService.deleteIndicatorWeithtbyProjectId(projectId);
//			     	
//			    	//很关键的一步来了~  看哪些指标是需要计算的   1.用户指定的与目前能算的交集~~
//			    	int i,j;
//			    	for(i=0;i<indiInfoList.size();i++)
//			    	{
//			    		indiInfoList.get(i).setNeed(false);
//			    	}
//			    	indiInfoList.get(0).setNeed(true);//1.1.1
//			     	indiInfoList.get(1).setNeed(true);//1.1.2
//			     	indiInfoList.get(2).setNeed(true);//1.2.1  安全水
//			     	indiInfoList.get(7).setNeed(true);//1.4.3
//			     	indiInfoList.get(9).setNeed(true);//2.1.1  9森林覆盖率
//			     	indiInfoList.get(10).setNeed(true);//2.2.1 10 退化土地占总土地面积比例
//			     	indiInfoList.get(11).setNeed(true);//2.3.1
//			     	indiInfoList.get(12).setNeed(true);//3.1.1
//			     	indiInfoList.get(13).setNeed(true);//3.2.1
//			     	indiInfoList.get(17).setNeed(true);//3.5.2
//			     	indiInfoList.get(19).setNeed(true);//3.7.1
//			     	indiInfoList.get(20).setNeed(true);//3.7.2
//			     	indiInfoList.get(22).setNeed(true);//3.8.1
//			     	
//			     	
//			     	int n=0;
//			    	float  total=0;
//			    	float  tempweight;
//			    	indiweight[n]=goal.getIndex_111();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标1.1.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 1.1.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_112();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标1.1.2权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 1.1.2 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			     	
//			    	indiweight[n]=goal.getIndex_121();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标1.2.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 1.2.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_143();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标1.4.3权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 1.4.3 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_211();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标2.1.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 2.1.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_221();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标2.2.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 2.2.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_231();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标2.3.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 2.3.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_311();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标3.1.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 3.1.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_321();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标3.2.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 3.2.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_352();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标3.5.2权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 3.5.2 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_371();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标3.7.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 3.7.1 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_372();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标3.7.2权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 3.7.2 weight is not specified");
//						}
//			    	}
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	n++;
//			    	
//			    	indiweight[n]=goal.getIndex_381();
//			    	if(indiweight[n].equals("undefined") ||indiweight[n].equals(""))
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"指标3.8.1权重未指定");
//						}else {
//							return new BaseMsg(true,"Indicator 3.8.1 weight is not specified");
//						}
//			    	}			    	
//			    	tempweight=Float.parseFloat(indiweight[n])/100;
//			    	indiweight[n]=""+tempweight;
//			    	total+=tempweight;
//			    	if(total!=1)
//			    	{
//			    		setFlag(flagstr);
//			    		if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true,"13个可算指标权重之和必须等于100");
//						}else {
//							return new BaseMsg(true,"The sum of the 13 calculated index weights must equal 100.");
//						}
//			    	}
//			    	
//			    	
//			     	String indiindex[]=new String[] {"1.1.1","1.1.2","1.2.1","1.4.3","2.1.1","2.2.1","2.3.1","3.1.1","3.2.1","3.5.2","3.7.1","3.7.2","3.8.1"};
//			     	
//			     	int goal1num=4,goal2num=3,goal3num=6;
//			    	String numStr=goal1num+" "+goal2num+" "+goal3num;
//			    	String firstline="5";
//			    	i=0;
//
//				    for(;i<indiInfoList.size();i++)
//				    {
//				    	if(indiInfoList.get(i).getNeed()!=null && indiInfoList.get(i).getNeed()==true)
//				    	{
//				    		firstline=firstline+"\t"+indiInfoList.get(i).getDirection();
//				    	}
//				    }
//					
//				    List<Indicators> indiList=modelFunctionService.getIndicatorsbyProjectId(projectId);//全部指标
//				    if(indiList.size()==0)
//				    {
//				    	setFlag(flagstr);
//				    	if(userLanguage.equals("chinese")) {
//				    		return new BaseMsg(true,"本项目的指标输出结果不存在");
//				    	}else {
//				    		return new BaseMsg(true,"The indicator output of this project does not exist.");
//				    	}
//				    }
//				    
//				     //int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//			        // int timeEnd = Integer.parseInt(myPro.getGoalYear());
//			        // int yearNum= timeEnd-timeStart+1;
//				    
//				    int num=indiList.size();  
//				    //int yearNum=num/11;	
//			         int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//			         int timeEnd = Integer.parseInt(myPro.getGoalYear());
//			        
//			         int yearNum= timeEnd-timeStart+1;
//			         int cNum=num/yearNum;
//				    String lineArr[]=new String[yearNum];//计算一个县的
//				    AssessResult scoreArr[]=new AssessResult[num];//完整的结果
//				    Indicators indicator;
//				    
//				    for(i=0;i<num;i++)
//				    {
//				    	scoreArr[i]=new AssessResult();
//				    }
//				    int index=0;
//				    IndicatorWeight iw=new IndicatorWeight();
//				    
//				    for(int cIndex=0;cIndex<cNum;cIndex++)
//				    {
//				    	
//					    for(i=0;i<yearNum;i++) //i 是行号   index是结果数组序号
//					    {
//					    	index=cIndex*yearNum+i;
//					    	indicator=indiList.get(index);
//					    	scoreArr[index].setProjectId(projectId);
//					    	scoreArr[index].setCountyId(indicator.getCountyId());
//					    	scoreArr[index].setYear(indicator.getYear());
//					    	
//					    	lineArr[i]=indicator.getYear()+"\t";
//					    	
//					    	if(indiInfoList.get(0).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getWaterProductivity()+"\t";
//					    		
//					    	}
//					    	if(indiInfoList.get(1).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getWaterPressure()+"\t";
//					    	}
//					    	if(indiInfoList.get(2).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getSafeDrinkingWaterR()+"\t";
//					    	}
//					    	if(indiInfoList.get(7).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getGroundwaterMining()+"\t";
//					    	}
//					    	if(indiInfoList.get(9).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getForestCoverR()+"\t";
//					    	}
//					    	if(indiInfoList.get(10).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getForestSustainableR()+"\t";
//					    	}
//					    	if(indiInfoList.get(11).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getMountainGreenCoverR()+"\t";
//					    	}
//					    	if(indiInfoList.get(12).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getGdpPerCapita()+"\t";
//					    	}
//					    	if(indiInfoList.get(13).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getGdpPerCapitaEmployed()+"\t";
//					    	}
//					    	if(indiInfoList.get(17).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getUrbanR()+"\t";
//					    	}
//					    	if(indiInfoList.get(19).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getWaterProductivityAgri()+"\t";
//					    	}
//					    	if(indiInfoList.get(20).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getWaterUseEffiAgri()+"\t";
//					    	}
//					    	if(indiInfoList.get(22).getNeed())
//					    	{
//					    		lineArr[i]=lineArr[i]+indicator.getAreaCrop()+"\t";
//					    	}
//					    	lineArr[i]=lineArr[i].substring(0,lineArr[i].length()-1);//去掉最后一个 \t符号
//					    }
//					    //测试写文件
//					    String outArr[]=null;
//					    String score[]=null;
//					    ///////////////////////运行 评价模型  python的代码   只能在服务器上测试！！！/////////////////////////////
//					    String msg = new String();
//						String fileName = new String();
//						String fileNameGN = new String();
//						String filePy = new String();
//						String exePy = new String();
//						
//						String inw=path+"Subjective_weight.txt";
//						BufferedWriter inwwriter=null;
//						File inwfile=new File(inw);
//						
//						fileName = path+"datacal.txt";
//			    		fileNameGN = path+"goals_number.txt";
//			    		filePy = path+"subjective.py";
//			    		exePy = "/usr/bin/python";
//			    		
//						//解析传入参数, 写入参数文件
//					    BufferedWriter bufferedWriter = null;
//					    BufferedWriter bufferedWriterGN = null;
//					    File f = new File(fileName);
//						File fGN = new File(fileNameGN);
//						
//						String wfile=path+"goalweight.txt";
//			    		BufferedWriter wWriter = null;
//			    		File wf=new File(wfile);
//			    		
//						try{
//							if(!f.exists()){
//								f.createNewFile();
//							}
//							if(!fGN.exists()){
//								fGN.createNewFile();
//							}
//							if(!wf.exists()){
//								wf.createNewFile();
//							}
//							if(!inwfile.exists()){
//								inwfile.createNewFile();
//							}
//							
//							//目标权重文件
//							wWriter=new BufferedWriter(new FileWriter(wf, false));
//							wWriter.write(wstr);
//							//指标权重文件
//							inwwriter=new BufferedWriter(new FileWriter(inwfile, false));
//							for(i=0;i<12;i++)
//							{
//								inwwriter.write(indiweight[i]);
//								inwwriter.newLine(); 
//							}
//							inwwriter.write(indiweight[i]);
//							
//							//goal_number文件
//							bufferedWriterGN = new BufferedWriter(new FileWriter(fGN, false));
//							bufferedWriterGN.write(numStr);
//							//datacal文件
//						    bufferedWriter = new BufferedWriter(new FileWriter(f,false));
//						    bufferedWriter.write(firstline);
//					    	bufferedWriter.newLine(); 
//					    	for(i=0;i<yearNum-1;i++)
//					    	{
//					    		bufferedWriter.write(lineArr[i]);
//						    	bufferedWriter.newLine(); 
//					    	}
//					    	bufferedWriter.write(lineArr[i]);
//				        }
//						catch (FileNotFoundException ex) {
//						    ex.printStackTrace();
//						    setFlag(flagstr);
//						    if(userLanguage.equals("chinese")) {
//					    		return new BaseMsg(true,"写输入文件出错-文件不存在");
//						    }else {
//						    	return new BaseMsg(true,"Error writing input file - file does not exist");
//						    }
//						} 
//						catch (IOException ex) {
//							ex.printStackTrace();
//							setFlag(flagstr);
//							if(userLanguage.equals("chinese")) {
//					    		return new BaseMsg(true,"写输入文件出错");
//							}else {
//								return new BaseMsg(true,"Error writing input file.");
//							}
//						} 
//						finally {
//						    //Close the bufferWritter
//						    try {
//						        if (bufferedWriter != null) {
//						        	bufferedWriter.flush();
//						        	bufferedWriter.close();
//						        }
//						        if (bufferedWriterGN != null) {
//						        	bufferedWriterGN.flush();
//						        	bufferedWriterGN.close();
//						        }
//						        if (wWriter != null) {
//						        	wWriter.flush();
//						        	wWriter.close();
//						        }
//						        if (inwwriter != null) {
//						        	inwwriter.flush();
//						        	inwwriter.close();
//						        }
//						    } 
//						    catch (IOException ex) {
//						        ex.printStackTrace();
//						        setFlag(flagstr);
//						        if(userLanguage.equals("chinese")) {
//						    		return new BaseMsg(true,"关闭文件出错");
//						        }else {
//						        	return new BaseMsg(true,"Error closing file.");
//						        }
//						    }
//		
//					    }
//						
//						msg += "write input data successfully!";
//		
//						//运行py模型
//						Runtime rt = Runtime.getRuntime();
//						String[] cmds = new String[]{exePy, filePy, fileName};
//				        Process p;  
//				        StringBuilder sb = new StringBuilder();    
//				        try    
//				        {    
//				        	//执行py
//				        	p = rt.exec(cmds);
//				        	try {
//				        		p.waitFor();
//				        	} catch (InterruptedException intexc) {
//				        		msg += "Interrupted Exception on waitFor: " + intexc.getMessage();
//				        		System.out.println("Interrupted Exception on waitFor: " + intexc.getMessage());
//				        		setFlag(flagstr);
//				        		if(userLanguage.equals("chinese")) {
//							    	 return new BaseMsg(true,"1执行python程序出错"+msg);
//				        		}else {
//				        			 return new BaseMsg(true,"1Error executing python program."+msg);
//				        		}
//				        	}
//				            //取得命令结果的输出流    
//				             InputStream fis=p.getInputStream();    
//				            //用一个读输出流类去读    
//				             InputStreamReader isr=new InputStreamReader(fis);    
//				            //用缓冲器读行    
//				             BufferedReader br=new BufferedReader(isr);    
//				             String line=null;    
//				            //直到读完为止    
//				    		
//				                while((line=br.readLine())!=null)    
//				                {    
//				                	sb.append(line);
//				                }
//				        }
//				        catch (IOException e)    
//				        {    
//				        	msg  += e.getMessage();
//				            e.printStackTrace();    
//				            setFlag(flagstr);
//				            if(userLanguage.equals("chinese")) {
//						    	 return new BaseMsg(true,"2执行python程序出错"+msg);
//			        		}else {
//			        			 return new BaseMsg(true,"2Error executing python program."+msg);
//			        		}
//				        }
//				        msg += "  run py done!";
//				        System.out.println(msg);    
//		
//				       if(!(sb.toString().contains("[") && sb.toString().contains("]")))
//				        {
//				        	setFlag(flagstr);
//				        	if(userLanguage.equals("chinese")) {
//						    	 return new BaseMsg(true,path+":输出命令窗口并未包含[]"+sb.toString());
//			        		}else {
//			        			 return new BaseMsg(true,path+":Output command window does not contain []"+sb.toString());
//			        		}
//				        }
//				        try {
//					    outArr=sb.toString().split("]");
//					    
//						for(i=0;i<4;i++)//前四个是index
//						{
//							outArr[i]=outArr[i].replaceAll(" +"," ");
//							outArr[i]=outArr[i].substring(outArr[i].indexOf("[")+1, outArr[i].length());
//							if(outArr[i].substring(0, 1).equals(" "))
//							{
//								outArr[i]=outArr[i].substring(1, outArr[i].length());
//							}
//					    	score=outArr[i].split(" ");
//					    	for(j=0;j<yearNum;j++) //现在结果只有 yearNum列
//					    	{
//					    		index=cIndex*yearNum+j;
//					    		if(i==0)
//					    		{
//					    			scoreArr[index].setGoal1index(score[j]);
//					    		}
//					    		else if(i==1)
//					    		{
//					    			scoreArr[index].setGoal2index(score[j]);
//					    		}
//					    		else if(i==2)
//					    		{
//					    			scoreArr[index].setGoal3index(score[j]);
//					    		}
//					    		else if(i==3)
//					    		{
//					    			scoreArr[index].setTotalindex(score[j]);
//					    		}
//					    	}
//						}
//					    
//						    for(i=4;i<8;i++)//后四个是grade
//						    {
//						    	outArr[i] = outArr[i].replace(" ", "");
//						    	score=outArr[i].split("\\.");// 取得 .号分开的多个子字符串
//						    	score[0]=score[0].substring(score[0].length()-1);//第一个字串 形如Flagtotalclass=[2 取最后一个字符即可
//						    	for(j=0;j<yearNum;j++)
//						    	{
//						    		index=cIndex*yearNum+j;
//						    		if(i==4)
//						    		{
//						    			scoreArr[index].setTotalscore(score[j]);
//						    		}
//						    		else if(i==5)
//						    		{
//						    			scoreArr[index].setGoal1score(score[j]);
//						    		}
//						    		else if(i==6)
//						    		{
//						    			scoreArr[index].setGoal2score(score[j]);
//						    		}
//						    		else if(i==7)
//						    		{
//						    			scoreArr[index].setGoal3score(score[j]);
//						    		}
//						    	}
//						    }
//				        }
//				        catch(Exception e)
//				        {
//				        	setFlag(flagstr);
//				        	if(userLanguage.equals("chinese")) {
//				        		return new BaseMsg(true,e.getMessage()+"长度"+outArr.length+path+"输出"+sb.toString());
//				        	}else {
//				        		return new BaseMsg(true,e.getMessage()+"Length"+outArr.length+path+"Output"+sb.toString());
//				        	}
//				        }	
//				        //把读取权重的加到这里
//				        for(i=0;i<13;i++)
//			 			{
//			 				iw.setProjectId(projectId);
//			 				iw.setCountyId(scoreArr[index].getCountyId());
//			 				iw.setIndicatorindex(indiindex[i]);
//			 				iw.setWeight(indiweight[i]);
//			 				modelFunctionService.insertIndicatorWeight(iw);//数据库插入 项目，县对应的权重
//			 			}
//				    }//end of for
//				    //计算完了再操作数据库
//						modelFunctionService.deleteAssessResultbyProjectId(projectId);
//						for(i=0;i<num;i++)
//						{
//							modelFunctionService.insertScores(scoreArr[i]);
//						}
//				    
//					setFlag(flagstr);
//					if(userLanguage.equals("chinese")) {
//						return new BaseMsg(true, "指标已评价完成并存入数据库");
//					}else {
//						return new BaseMsg(true,"The indicator has been evaluated and stored in the database");
//					}
//		}
//		else{
//		String path="";
//		String flagstr=""; 
//		if(flag1==true)
//		{
//			flag1=false;
//			path="/opt/oldmodel/eval1/";
//			flagstr="flag1";
//			
//		}
//		else if(flag2==true)
//		{
//			flag2=false;
//			path="/opt/oldmodel/eval2/";
//			flagstr="flag2";
//			
//		}
//		else if(flag3==true)
//		{
//			flag3=false;
//			path="/opt/oldmodel/eval3/";
//			flagstr="flag3";
//			
//		}
//		else if(flag4==true)
//		{
//			flag4=false;
//			path="/opt/oldmodel/eval4/";
//			flagstr="flag4";
//			
//		}
//		else if(flag5==true)
//		{
//			flag5=false;
//			path="/opt/oldmodel/eval5/";
//			flagstr="flag5";
//			
//		}
//		else
//		{
//			if(userLanguage.equals("chinese")) {
//				return new BaseMsg(true, "评价程序都被占用，请稍后再试！");
//			}else {
//				return new BaseMsg(true,"The evaluation program is occupied, please try again later!");
//			}
//		}
//		
//		String username = userservice.getCurrentUserId();
//		//查询数据库，组合评价python程序需要的字符串，修改两个文件，运行程序，得到输出字符串，解析输出字符串，存到评分数据库表
//		Project myPro=getWebServiceParaService.getProjectById(username,projectId);
//		if(myPro==null)
//		{
//			setFlag(flagstr);
//			if(userLanguage.equals("chinese")) {
//				return new BaseMsg(true, "项目信息不存在");
//			}else {
//				return new BaseMsg(true,"Project information does not exist");
//			}
//		}
//				List<IndicatorInfo> indiInfoList=modelFunctionService.getIndicatorInfo(myPro.getWatershedId());
//				if(indiInfoList.size()==0)
//				{
//					setFlag(flagstr);
//					if(userLanguage.equals("chinese")) {
//						return new BaseMsg(true, "指标基本信息不存在");
//					}else {
//						return new BaseMsg(true,"The basic information of the indicator does not exist.");
//					}
//				}
//				Goal goal=goalService.getGoalById(projectId);
//		     	if(goal==null)
//		     	{
//		     		setFlag(flagstr);
//		     		if(userLanguage.equals("chinese")) {
//						return new BaseMsg(true, "项目目标信息不存在");
//					}else {
//						return new BaseMsg(true,"The basic information of the indicator does not exist.");
//					}
//		     	}
//		     	
//		     	int gw1,gw2,gw3;
//		     	String gwstr1=goal.getGoal_1();
//		     	String gwstr2=goal.getGoal_2();
//		     	String gwstr3=goal.getGoal_3();
//		     	if(gwstr1.equals("undefined") || gwstr1.equals("undefined") || gwstr1.equals("undefined"))
//		     	{
//		     		setFlag(flagstr);
//		     		if(userLanguage.equals("chinese")) {
//						return new BaseMsg(true,"项目目标权重未指定");
//					}else {
//						return new BaseMsg(true,"Project weight not specified");
//					}
//		     	}
//		     	gw1=Integer.parseInt(gwstr1);
//		     	gw2=Integer.parseInt(gwstr2);
//		     	gw3=Integer.parseInt(gwstr3);
//		     	int temp=gw1+gw2+gw3;
//		     	if(temp!=100)
//		     	{
//		     		setFlag(flagstr);
//		     		if(userLanguage.equals("chinese")) {
//						return new BaseMsg(true,"目标权重之和应等于100");
//					}else {
//						return new BaseMsg(true,"The sum of the target weights should equal 100");
//					}
//		     	}
//		     	float fgw1=(float) (gw1*0.01);
//		     	float fgw2=(float) (gw2*0.01);
//		     	float fgw3=(float) (gw3*0.01);
//		     	
//		     	String wstr=""+fgw1+" "+fgw2+" "+fgw3;
//		     	
//		     	//把权重表先删了
//		     	modelFunctionService.deleteIndicatorWeithtbyProjectId(projectId);
//		     	
//		    	//很关键的一步来了~  看哪些指标是需要计算的   1.用户指定的与目前能算的交集~~
//		    	int i,j;
//		    	for(i=0;i<indiInfoList.size();i++)
//		    	{
//		    		indiInfoList.get(i).setNeed(false);
//		    	}
//		    	indiInfoList.get(0).setNeed(true);//1.1.1
//		     	indiInfoList.get(1).setNeed(true);//1.1.2
//		     	indiInfoList.get(2).setNeed(true);//1.2.1  安全水
//		     	indiInfoList.get(7).setNeed(true);//1.4.3
//		     	indiInfoList.get(9).setNeed(true);//2.1.1  9森林覆盖率
//		     	indiInfoList.get(10).setNeed(true);//2.2.1 10 退化土地占总土地面积比例
//		     	indiInfoList.get(11).setNeed(true);//2.3.1
//		     	indiInfoList.get(12).setNeed(true);//3.1.1
//		     	indiInfoList.get(13).setNeed(true);//3.2.1
//		     	indiInfoList.get(17).setNeed(true);//3.5.2
//		     	indiInfoList.get(19).setNeed(true);//3.7.1
//		     	indiInfoList.get(20).setNeed(true);//3.7.2
//		     	indiInfoList.get(22).setNeed(true);//3.8.1
//		     	
//		     	String indiindex[]=new String[] {"1.1.1","1.1.2","1.2.1","1.4.3","2.1.1","2.2.1","2.3.1","3.1.1","3.2.1","3.5.2","3.7.1","3.7.2","3.8.1"};
//		     	
//		     	int goal1num=4,goal2num=3,goal3num=6;
//		    	String numStr=goal1num+" "+goal2num+" "+goal3num;
//		    	String firstline="5";
//		    	i=0;
//
//			    for(;i<indiInfoList.size();i++)
//			    {
//			    	if(indiInfoList.get(i).getNeed()!=null && indiInfoList.get(i).getNeed()==true)
//			    	{
//			    		firstline=firstline+"\t"+indiInfoList.get(i).getDirection();
//			    	}
//			    }
//				
//			    List<Indicators> indiList=modelFunctionService.getIndicatorsbyProjectId(projectId);//全部指标
//			    if(indiList.size()==0)
//			    {
//			    	setFlag(flagstr);
//			    	if(userLanguage.equals("chinese")) {
//			    		return new BaseMsg(true,"本项目的指标输出结果不存在");
//			    	}else {
//			    		return new BaseMsg(true,"The indicator output of this project does not exist.");
//			    	}
//			    }
//			    
//			     //int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//		        // int timeEnd = Integer.parseInt(myPro.getGoalYear());
//		        // int yearNum= timeEnd-timeStart+1;
//			    
//			    int num=indiList.size();  
//			    //int yearNum=num/11;	
//		         int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//		         int timeEnd = Integer.parseInt(myPro.getGoalYear());
//		        
//		         int yearNum= timeEnd-timeStart+1;
//		         int cNum=num/yearNum;
//			    String lineArr[]=new String[yearNum];//计算一个县的
//			    AssessResult scoreArr[]=new AssessResult[num];//完整的结果
//			    Indicators indicator;
//			    
//			    for(i=0;i<num;i++)
//			    {
//			    	scoreArr[i]=new AssessResult();
//			    }
//			    int index=0;
//			    IndicatorWeight iw=new IndicatorWeight();
//			    
//			    for(int cIndex=0;cIndex<cNum;cIndex++)
//			    {
//			    	
//				    for(i=0;i<yearNum;i++) //i 是行号   index是结果数组序号
//				    {
//				    	index=cIndex*yearNum+i;
//				    	indicator=indiList.get(index);
//				    	scoreArr[index].setProjectId(projectId);
//				    	scoreArr[index].setCountyId(indicator.getCountyId());
//				    	scoreArr[index].setYear(indicator.getYear());
//				    	
//				    	lineArr[i]=indicator.getYear()+"\t";
//				    	if(indiInfoList.get(0).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getWaterProductivity()+"\t";
//				    	}
//				    	if(indiInfoList.get(1).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getWaterPressure()+"\t";
//				    	}
//				    	if(indiInfoList.get(2).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getSafeDrinkingWaterR()+"\t";
//				    	}
//				    	if(indiInfoList.get(7).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getGroundwaterMining()+"\t";
//				    	}
//				    	if(indiInfoList.get(9).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getForestCoverR()+"\t";
//				    	}
//				    	if(indiInfoList.get(10).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getForestSustainableR()+"\t";
//				    	}
//				    	if(indiInfoList.get(11).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getMountainGreenCoverR()+"\t";
//				    	}
//				    	if(indiInfoList.get(12).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getGdpPerCapita()+"\t";
//				    	}
//				    	if(indiInfoList.get(13).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getGdpPerCapitaEmployed()+"\t";
//				    	}
//				    	if(indiInfoList.get(17).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getUrbanR()+"\t";
//				    	}
//				    	if(indiInfoList.get(19).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getWaterProductivityAgri()+"\t";
//				    	}
//				    	if(indiInfoList.get(20).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getWaterUseEffiAgri()+"\t";
//				    	}
//				    	if(indiInfoList.get(22).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indicator.getAreaCrop()+"\t";
//				    	}
//				    	lineArr[i]=lineArr[i].substring(0,lineArr[i].length()-1);//去掉最后一个 \t符号
//				    }
//				    //测试写文件
//				    String outArr[]=null;
//				    String score[]=null;
//				    ///////////////////////运行 评价模型  python的代码   只能在服务器上测试！！！/////////////////////////////
//				    String msg = new String();
//					String fileName = new String();
//					String fileNameGN = new String();
//					String filePy = new String();
//					String exePy = new String();
//															
//					fileName = path+"datacal.txt";
//		    		fileNameGN = path+"goals_number.txt";
//		    		filePy = path+"evalmodel_objective.py";
//		    		exePy = "/usr/bin/python";
//		    		
//					//解析传入参数, 写入参数文件
//				    BufferedWriter bufferedWriter = null;
//				    BufferedWriter bufferedWriterGN = null;
//				    File f = new File(fileName);
//					File fGN = new File(fileNameGN);
//					
//					String wfile=path+"goalweight.txt";
//		    		BufferedWriter wWriter = null;
//		    		File wf=new File(wfile);
//		    		
//					try{
//						if(!f.exists()){
//							f.createNewFile();
//						}
//						if(!fGN.exists()){
//							fGN.createNewFile();
//						}
//						if(!wf.exists()){
//							wf.createNewFile();
//						}
//						wWriter=new BufferedWriter(new FileWriter(wf, false));
//						wWriter.write(wstr);
//						
//						bufferedWriterGN = new BufferedWriter(new FileWriter(fGN, false));
//						bufferedWriterGN.write(numStr);
//						bufferedWriterGN.newLine();
//					    bufferedWriter = new BufferedWriter(new FileWriter(f,false));
//					    bufferedWriter.write(firstline);
//				    	bufferedWriter.newLine(); 
//				    	for(i=0;i<yearNum-1;i++)
//				    	{
//				    		bufferedWriter.write(lineArr[i]);
//					    	bufferedWriter.newLine(); 
//				    	}
//				    	bufferedWriter.write(lineArr[i]);
//			        }
//					catch (FileNotFoundException ex) {
//					    ex.printStackTrace();
//					    setFlag(flagstr);
//					    if(userLanguage.equals("chinese")) {
//				    		return new BaseMsg(true,"写输入文件出错-文件不存在");
//					    }else {
//					    	return new BaseMsg(true,"Error writing input file - file does not exist");
//					    }
//					} 
//					catch (IOException ex) {
//						ex.printStackTrace();
//						setFlag(flagstr);
//						if(userLanguage.equals("chinese")) {
//				    		return new BaseMsg(true,"写输入文件出错");
//						}else {
//							return new BaseMsg(true,"Error writing input file.");
//						}
//					} 
//					finally {
//					    //Close the bufferWritter
//					    try {
//					        if (bufferedWriter != null) {
//					        	bufferedWriter.flush();
//					        	bufferedWriter.close();
//					        }
//					        if (bufferedWriterGN != null) {
//					        	bufferedWriterGN.flush();
//					        	bufferedWriterGN.close();
//					        }
//					        if (wWriter != null) {
//					        	wWriter.flush();
//					        	wWriter.close();
//					        }
//					    } 
//					    catch (IOException ex) {
//					        ex.printStackTrace();
//					        setFlag(flagstr);
//					        if(userLanguage.equals("chinese")) {
//					    		return new BaseMsg(true,"关闭文件出错");
//					        }else {
//					        	return new BaseMsg(true,"Error closing file.");
//					        }
//					    }
//	
//				    }
//					
//					msg += "write input data successfully!";
//	
//					//运行py模型
//					Runtime rt = Runtime.getRuntime();
//					String[] cmds = new String[]{exePy, filePy, fileName};
//			        Process p;  
//			        StringBuilder sb = new StringBuilder();    
//			        try    
//			        {    
//			        	//执行py
//			        	p = rt.exec(cmds);
//			        	try {
//			        		p.waitFor();
//			        	} catch (InterruptedException intexc) {
//			        		msg += "Interrupted Exception on waitFor: " + intexc.getMessage();
//			        		System.out.println("Interrupted Exception on waitFor: " + intexc.getMessage());
//			        		setFlag(flagstr);
//			        		if(userLanguage.equals("chinese")) {
//						    	 return new BaseMsg(true,"1执行python程序出错"+msg);
//			        		}else {
//			        			 return new BaseMsg(true,"1Error executing python program."+msg);
//			        		}
//			        	}
//			            //取得命令结果的输出流    
//			             InputStream fis=p.getInputStream();    
//			            //用一个读输出流类去读    
//			             InputStreamReader isr=new InputStreamReader(fis);    
//			            //用缓冲器读行    
//			             BufferedReader br=new BufferedReader(isr);    
//			             String line=null;    
//			            //直到读完为止    
//			    		
//			                while((line=br.readLine())!=null)    
//			                {    
//			                	sb.append(line);
//			                }
//			        }
//			        catch (IOException e)    
//			        {    
//			        	msg  += e.getMessage();
//			            e.printStackTrace();    
//			            setFlag(flagstr);
//			            if(userLanguage.equals("chinese")) {
//					    	 return new BaseMsg(true,"2执行python程序出错"+msg);
//		        		}else {
//		        			 return new BaseMsg(true,"2Error executing python program."+msg);
//		        		}
//			        }
//			        msg += "  run py done!";
//			        System.out.println(msg);    
//	
//			       if(!(sb.toString().contains("[") && sb.toString().contains("]")))
//			        {
//			        	setFlag(flagstr);
//			        	if(userLanguage.equals("chinese")) {
//					    	 return new BaseMsg(true,path+":输出命令窗口并未包含[]"+sb.toString());
//		        		}else {
//		        			 return new BaseMsg(true,path+":Output command window does not contain []"+sb.toString());
//		        		}
//			        }
//			        try {
//				    outArr=sb.toString().split("]");
//				    
//					for(i=0;i<4;i++)//前四个是index
//					{
//						outArr[i]=outArr[i].replaceAll(" +"," ");
//						outArr[i]=outArr[i].substring(outArr[i].indexOf("[")+1, outArr[i].length());
//						if(outArr[i].substring(0, 1).equals(" "))
//						{
//							outArr[i]=outArr[i].substring(1, outArr[i].length());
//						}
//				    	score=outArr[i].split(" ");
//				    	for(j=0;j<yearNum;j++) //现在结果只有 yearNum列
//				    	{
//				    		index=cIndex*yearNum+j;
//				    		if(i==0)
//				    		{
//				    			scoreArr[index].setGoal1index(score[j]);
//				    		}
//				    		else if(i==1)
//				    		{
//				    			scoreArr[index].setGoal2index(score[j]);
//				    		}
//				    		else if(i==2)
//				    		{
//				    			scoreArr[index].setGoal3index(score[j]);
//				    		}
//				    		else if(i==3)
//				    		{
//				    			scoreArr[index].setTotalindex(score[j]);
//				    		}
//				    	}
//					}
//				    
//					    for(i=4;i<8;i++)//后四个是grade
//					    {
//					    	outArr[i] = outArr[i].replace(" ", "");
//					    	score=outArr[i].split("\\.");// 取得 .号分开的多个子字符串
//					    	score[0]=score[0].substring(score[0].length()-1);//第一个字串 形如Flagtotalclass=[2 取最后一个字符即可
//					    	for(j=0;j<yearNum;j++)
//					    	{
//					    		index=cIndex*yearNum+j;
//					    		if(i==4)
//					    		{
//					    			scoreArr[index].setTotalscore(score[j]);
//					    		}
//					    		else if(i==5)
//					    		{
//					    			scoreArr[index].setGoal1score(score[j]);
//					    		}
//					    		else if(i==6)
//					    		{
//					    			scoreArr[index].setGoal2score(score[j]);
//					    		}
//					    		else if(i==7)
//					    		{
//					    			scoreArr[index].setGoal3score(score[j]);
//					    		}
//					    	}
//					    }
//			        }
//			        catch(Exception e)
//			        {
//			        	setFlag(flagstr);
//			        	return new BaseMsg(true,e.getMessage()+"长度"+outArr.length+path+"输出"+sb.toString());
//			        }	
//			        //把读取权重的加到这里
//			     	try
//			 		{
//			 			BufferedReader ecobr=new BufferedReader(new FileReader(path+"index_weight.txt"));
//			 			for(i=0;i<13;i++)
//			 			{
//			 				iw.setProjectId(projectId);
//			 				iw.setCountyId(scoreArr[index].getCountyId());
//			 				iw.setIndicatorindex(indiindex[i]);
//			 				iw.setWeight(ecobr.readLine());
//			 				modelFunctionService.insertIndicatorWeight(iw);//数据库插入 项目，县对应的权重
//			 			}
//			 			ecobr.close();
//			 		}
//			 		catch(Exception e)
//			 		{
//			 			System.out.println(e.toString());
//			 			setFlag(flagstr);
//			 			if(userLanguage.equals("chinese")) {
//							return new BaseMsg(true, "提取指标权重 index_weight.txt 出错");
//						}else {
//							return new BaseMsg(true,"Extract indicator weight index_weight.txt error");
//						}
//			 		}
//			    }//end of for
//			    //计算完了再操作数据库
//					modelFunctionService.deleteAssessResultbyProjectId(projectId);
//					for(i=0;i<num;i++)
//					{
//						modelFunctionService.insertScores(scoreArr[i]);
//					}
//			    
//				setFlag(flagstr);
//				if(userLanguage.equals("chinese")) {
//					return new BaseMsg(true, "指标已评价完成并存入数据库");
//				}else {
//					return new BaseMsg(true,"The indicator has been evaluated and stored in the database");
//				}
//    		}
/////////////////////////运行 评价模型  python的代码   只能在服务器上测试！！！   done/////////////////////////////		       	    	
//    }
//	public void setFlag(String flagstr)
//	{
//		if(flagstr.equals("flag1"))
//		{
//			flag1=true;
//		}
//		else if(flagstr.equals("flag2"))
//		{
//			flag2=true;
//		}
//		else if(flagstr.equals("flag3"))
//		{
//			flag3=true;
//		}
//		else if(flagstr.equals("flag4"))
//		{
//			flag4=true;
//		}
//		else if(flagstr.equals("flag5"))
//		{
//			flag5=true;
//		}
//	}
//	 //测试解析函数
//    @ResponseBody
//    @RequestMapping(value = "testFunc", method = RequestMethod.POST)
//    public String testFunction(String projectId)
//    {
//    	/*String str;
//    	try
//    	{
//    	InputStream stream = new FileInputStream(new File("E://SVM//term//percent.xls"));
//		//获取Excel文件对象
//		Workbook rwb = Workbook.getWorkbook(stream);
//		Sheet sheet=rwb.getSheet(0); 
//		str=sheet.getCell(1,1).getContents();
//		stream.close();
//    	}
//    	catch(Exception e)
//    	{return e.getMessage();}
//    	return str;*/
//    	//modelFunctionService.setTestFlag("0","测试");
//    	
//    	//return modelFunctionService.getNum(projectId);
//    	/*Project myPro=getWebServiceParaService.getProjectById(projectId);
//     	if(myPro==null)
// 		{
// 			return "项目信息不存在";
// 		}
//     	String str=projectId+"~~"+myPro.getBaseYear()+"~~"+myPro.getGoalYear();*/
//     	
//     	//return str;
//         //int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//         //int timeEnd = Integer.parseInt(myPro.getGoalYear());
//		///return projectId;
//    	/*Project myPro=getWebServiceParaService.getProjectById(projectId);
//     	if(myPro==null)
//     	{
//     		return "没有项目信息";
//     	}
//     	String watershedId=myPro.getWatershedId();
//     	Map<String,Object> indiparaMap=modelFunctionService.getIndiParabyWatershedId(watershedId);
//     	if(indiparaMap.size()<10)
//     	{
//     		return "基础年参数不全";
//     	}
//
//     	IndicatorPara indiPara=(IndicatorPara)(indiparaMap.get("620902"));
//     	String str=indiPara.getWaterPrice();
//     	return str;*/
//    	//String ecooutput;
//    	/*地表供水量变化率SurSupR
// 		地下供水量变化率GWSupR
// 		农业产业技术进步率
// 		工业产业技术进步率
// 		服务业产业技术进步率*/
//    	//IModelEconomic IModelEconomicService= new IModelEconomicImpl().getIModelEconomicImplPort();
//    	//ecooutput=IModelEconomicService.start(projectId,"哈哈哈哈哈哈");
//     	//return "";	
//    	/*String str="I,am,a,girl,";
//    	String []score=str.split(",");// 取得 .号分开的多个子字符串
//    	return score[0]+"   len:"+score.length;*/
//    	/*String paraString="1.475152435227083,1.2842490625297984,2.0674567683063234,1.8193305515118774,2.17557685178547,2.1802229730143896,2.167557124492071,0.9296059460067961,1.2491859736666973,1.3130706727138883,1.9751028071944388,1.5666878615880189,1.1963999383685235,1.6725707386700996,0.8884726189660747,1.4401949840121977,2.137588648849322,1.6112218849991464,1.4933778664218658,1.682793352032562,2.1123664098722013,1.8612563351834452,-2.228942731055219,-2.1665505923511907,-1.1731521046562847,-0.7649638868252144,-1.4670652613177582,-0.898647376842105,-1.683388989284078,-1.5319112691988772,-1.7009814064612803,-2.0036093075709367,-0.8965343218067695,-1.582055557555397,-1.9379079816420124,-2.5521928087321615,-1.3975493566739645,-2.468850066068922,-1.4300509985667609,-2.0464712325806804,-2.9614383859248443,-1.5671880406193515,-1.5299833926160633,-1.649912121907755,-3.346492902745872,-1.865530165487323,-3.4749572697422857,-2.1165854654853535,-2.395083037089423,-1.526226971288896,-1.7113290543016701,-3.3201889719507154,-2.8003292280349736,-2.0933063314786815,-1.4017673176338765,";
//    	File dir = new File("E:\\term1");
//    	String []para=null;
//    	try {
//            System.err.println("==========设置参数==========");
//            File inFile = new File(dir.toString()+"//termheader.cmf");
//            int lineno=130;
//            //InputPar.insertStringInFile(dir1, 113, parameter);
//         // 临时文件
//    		File outFile = new File(dir.toString()+"//term.cmf");
//    		// 输入
//    		FileInputStream fis = new FileInputStream(inFile);
//    		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//    		// 输出
//    		FileOutputStream fos = new FileOutputStream(outFile);
//    		PrintWriter out = new PrintWriter(fos);
//    		// 保存一行数据
//    		String thisLine;
//    		// 行号从1开始
//    		para=paraString.split(",");
//    		String countyName[]=new String[] {"GanZhou","LinZe","GaoTai","ShanDan","MinLe","SuNan","JiaYuGuan","SuZhou","JinTai","EJNAQ","QiLian"};
//    		int i = 1;
//    		int j,k;
//    		String line;
//    		while ((thisLine = in.readLine()) != null) {
//    			// 如果行号等于目标行，则输出要插入的数据  55个参数
//    			if (i == lineno) {
//    				for(j=0,k=0;j<11;j++,k++)
//    				{
//    					line="shock xswt(IND,\""+countyName[k]+"\") = uniform "+para[j]+";";
//    					out.println(line);
//    				}
//    				for(j=11,k=0;j<22;j++,k++)
//    				{
//    					line="shock xuwt(IND,\""+countyName[k]+"\") = uniform "+para[j]+";";
//    					out.println(line);
//    				}
//    				for(j=22,k=0;j<33;j++,k++)
//    				{
//    					line="shock aprim(AGR,\""+countyName[k]+"\") = uniform "+para[j]+";";
//    					out.println(line);
//    				}
//    				for(j=33,k=0;j<44;j++,k++)
//    				{
//    					line="shock aprim(INDTR,\""+countyName[k]+"\") = uniform "+para[j]+";";
//    					out.println(line);
//    				}
//    				for(j=44,k=0;j<55;j++,k++)
//    				{
//    					line="shock aprim(SER,\""+countyName[k]+"\") = uniform "+para[j]+";";
//    					out.println(line);
//    				}
//    			}
//    			// 输出读取到的数据
//    			out.println(thisLine);
//    			// 行号增加
//    			i++;
//    		}
//    		out.flush();
//    		out.close();
//    		in.close();
//
//    		// 把临时文件改名为原文件名
//    		System.out.println("参数传入成功！");
//    		return "参数传入成功！";
//        } catch (IOException e) { 
//            e.printStackTrace();
//            return "参数个数"+para.length;
//        }
//    	Goal goal=goalService.getGoalById(projectId);
//     	if(goal==null)
//     	{
//     		return "项目目标信息不存在";
//     	}
//     	
//     	int gw1,gw2,gw3;
//     	String gwstr1=goal.getGoal_1();
//     	String gwstr2=goal.getGoal_2();
//     	String gwstr3=goal.getGoal_3();
//     	if(gwstr1.equals("undefined") || gwstr1.equals("undefined") || gwstr1.equals("undefined"))
//     	{
//     		return "项目目标权重未指定";
//     	}
//     	gw1=Integer.parseInt(gwstr1);
//     	gw2=Integer.parseInt(gwstr2);
//     	gw3=Integer.parseInt(gwstr3);
//     	int temp=gw1+gw2+gw3;
//     	if(temp!=100)
//     	{
//     		return "目标权重之和应等于100";
//     	}
//     	float fgw1=(float) (gw1*0.01);
//     	float fgw2=(float) (gw2*0.01);
//     	float fgw3=(float) (gw3*0.01);
//     	
//     	String wstr=""+fgw1+" "+fgw2+" "+fgw3;
//     	return wstr;
//    	IndicatorWeight iw=new IndicatorWeight();
//    	iw.setProjectId(projectId);
//    	iw.setCountyId("县");
//    	iw.setIndicatorindex("x.x.x");
//    	iw.setWeight("0.001");
//    	modelFunctionService.insertIndicatorWeight(iw);
//    	return "插入iw";
//    	IndicatorWeight iw=new IndicatorWeight();
//    	String path="E:\\";
//    	int i;
//    	try
// 		{
// 			BufferedReader ecobr=new BufferedReader(new FileReader(path+"index_weight.txt"));
// 			for(i=0;i<13;i++)
// 			{
// 				iw.setProjectId(projectId);
// 				iw.setCountyId("测试");
// 				iw.setIndicatorindex("1.2.2");
// 				iw.setWeight(ecobr.readLine());
// 				modelFunctionService.insertIndicatorWeight(iw);//数据库插入 项目，县对应的权重
// 			}
// 			ecobr.close();
// 		}
// 		catch(Exception e)
// 		{
// 			System.out.println(e.toString());
// 			return "提取指标权重 index_weight.txt 出错";
// 		}
//    	AssessResult resu=new AssessResult();
//    	String temp;
//    	String []score=null;
//    	int j;
//    	try
// 		{
// 			BufferedReader ecobr=new BufferedReader(new FileReader(path+"out.txt"));
// 			for(i=0;i<8;i++)
// 			{	
// 				temp=ecobr.readLine();
// 				score=temp.split(",");
// 				for(j=0;j<score.length;j++)
// 					System.out.println(score[j]);
// 			}
// 			ecobr.close();
// 		}
// 		catch(Exception e)
// 		{
// 			System.out.println(e.toString());
// 			return "提取指标权重 index_weight.txt 出错";
// 		}
//    	return ""+score.length;*/
//    	String username = userservice.getCurrentUserId();
//    	Project myPro=getWebServiceParaService.getProjectById(username,projectId);
//     	if(myPro==null)
// 		{
// 			return "项目信息不存在";
// 		}
//     	String watershedId=myPro.getWatershedId();
//    	List<IndicatorInfo> indiInfoList=modelFunctionService.getIndicatorInfo(watershedId);
//     	if(indiInfoList.size()==0)
//     	{
//     		return "指标信息不存在";
//     	}
//     	return ""+indiInfoList.size()+"hhhh-"+watershedId+"---hhh";
//    }
//    @ResponseBody
//    @RequestMapping(value = "testReadFunc", method = RequestMethod.POST)
//    public String testReadFunction(String projectId)
//    {
//    	String countyName="GanZhou";
//    	String filedir="E://SVM//term";
//    	String returnstr="";
//    	String coeffdir=filedir+"//percent.xls";
//    	int coefflineindex=0;
//    	String resultdir=filedir+"//results.xls";
//    	int resultslineindex=0;
//    //	1 GanZhou	2 SuNan	3 MinLe	4 LinZe	5 GaoTai	6 ShanDan	7 SuZhou	8 JinTai	9 JiaYuGuan	10 EJNAQ	11 QiLian
//    //GanZhou	SuNan	MinLe	LinZe	GaoTai	ShanDan	SuZhou	JinTai	JiaYuGuan	EJNAQ	QiLian
//
//    	if(countyName.equals("GanZhou"))
//    	{
//    		coefflineindex=1;
//    		resultslineindex=2;
//    	}
//    	else if(countyName.equals("SuNan"))
//    	{
//    		coefflineindex=2;
//    		resultslineindex=3;
//    	}
//    	else if(countyName.equals("MinLe"))
//    	{
//    		coefflineindex=3;
//    		resultslineindex=4;
//    	}
//    	else if(countyName.equals("LinZe"))
//    	{
//    		coefflineindex=4;
//    		resultslineindex=5;
//    	}
//    	else if(countyName.equals("GaoTai"))
//    	{
//    		coefflineindex=5;
//    		resultslineindex=6;
//    	}
//    	else if(countyName.equals("ShanDan"))
//    	{
//    		coefflineindex=6;
//    		resultslineindex=7;
//    	}
//    	else if(countyName.equals("SuZhou"))
//    	{
//    		coefflineindex=7;
//    		resultslineindex=8;
//    	}
//    	else if(countyName.equals("JinTai"))
//    	{
//    		coefflineindex=8;
//    		resultslineindex=9;
//    	}
//    	else if(countyName.equals("JiaYuGuan"))
//    	{
//    		coefflineindex=9;
//    		resultslineindex=10;
//    	}
//    	else if(countyName.equals("EJNAQ"))
//    	{
//    		coefflineindex=10;
//    		resultslineindex=11;
//    	}
//    	int resultrowstart=8;
//    	int coeffrowstart=1;
//    	int resultsheet[]=new int[]{3,4,8,7,5,6}; //在输出文件对应sheet，产值3，土地4，水价8，就业7，地表水5，地下水6
//    	double coeff[][]=new double[6][48];
//    	double result[][]=new double[6][48];
//    	
//    	double returnvalue[]=new double[] {0,0,0,0,0,0,0,0,0,0};//10个输出： 农业，工业，服务业产值，农业，工业，服务业土地，水价，就业，地表水，地下水 
//    	
//    	int i,j,sheetindex;
//    	for(i=0;i<6;i++)  //0~5  产值，土地，水价，就业，地表水，地下水 
//    	{
//    		coeff[i]=new double[48];
//    		result[i]=new double[48];
//    	}
//    	//读取系数
//    	Workbook rwb = null;
//		Cell cell = null;
//		//创建输入流
//		InputStream stream,stream1;
//		Sheet sheet;
//		String str="";
//		try
//		{
//			//读取系数
//			stream = new FileInputStream(new File(coeffdir));
//			str="1";
//			//获取Excel文件对象
//			rwb = Workbook.getWorkbook(stream);
//			str="2";
//			for(sheetindex=0;sheetindex<6;sheetindex++)
//			{
//				sheet = rwb.getSheet(sheetindex); 
//				str="3 " + sheetindex;
//				for(i=coeffrowstart,j=0;j<48;i++,j++)  //i是行号，j是数组下标
//				{
//					coeff[sheetindex][j]=Double.parseDouble(sheet.getCell(coefflineindex,i).getContents());
//					str="4 " + i;
//				}
//			}
//			stream.close();
//			
//			//读取result值
//			stream1 = new FileInputStream(new File(resultdir));
//			str="5";
//			//获取Excel文件对象
//			rwb = Workbook.getWorkbook(stream1);
//			str="6";
//			for(sheetindex=0;sheetindex<6;sheetindex++)
//			{
//				sheet = rwb.getSheet(resultsheet[sheetindex]); 
//				str="7 " + sheetindex;
//				for(i=resultrowstart,j=0;j<48;i++,j++)  //i是行号，j是数组下标
//				{
//					result[sheetindex][j]=Double.parseDouble(sheet.getCell(resultslineindex,i).getContents());
//					str="8 " + i;
//				}
//			}
//			stream1.close();
//			//结果都读出来了，现在开始计算
//			//农（1-7），工（8-32），服（33-48）   前两个数组分三段 变成6个输出
//			for(i=0;i<7;i++)
//			{
//				returnvalue[0]=returnvalue[0]+result[0][i]*coeff[0][i];
//				returnvalue[3]=returnvalue[3]+result[1][i]*coeff[1][i];
//			}
//			for(i=7;i<32;i++)
//			{
//				returnvalue[1]=returnvalue[0]+result[0][i]*coeff[0][i];
//				returnvalue[4]=returnvalue[3]+result[1][i]*coeff[1][i];
//			}
//			for(i=32;i<48;i++)
//			{
//				returnvalue[2]=returnvalue[0]+result[0][i]*coeff[0][i];
//				returnvalue[5]=returnvalue[3]+result[1][i]*coeff[1][i];
//			}
//			str="9";
//			for(j=6;j<10;j++) //第6到9个输出   计算对应 2-5数组
//			{
//				for(i=0;i<48;i++)
//				{
//					returnvalue[j]=returnvalue[j]+result[j-4][i]*coeff[j-4][i];
//				}
//			}
//			//组合输出了
//			str="10";
//			for(i=0;i<9;i++)
//			{
//				returnstr=returnstr+returnvalue[i]+",";
//			}
//			returnstr=returnstr+returnvalue[9];
//		}
//		catch(Exception e)
//		{
//			return coeffdir+","+resultdir+" 处理经济模型结果发生错误  "+str+" 错误信息"+e.getMessage();
//		}
//    	return returnstr;
//    }
//    @ResponseBody
//    @RequestMapping(value = "test1", method = RequestMethod.POST)
//    public String testws(String projectId)
//    {
//    	//modelFunctionService.setTestFlag("0");
//    	//return "OK";
//    	/*IModelEconomic wsservice= new IModelEconomicImpl().getIModelEconomicImplPort();
//    	List l1=wsservice.getData("admin");
//    	return l1.get(0).toString();*/
//    	//return "新改的";
//    	String countyName="GanZhou";
//    	String filedir="E://SVM//term";
//    	String returnstr="";
//    	String coeffdir=filedir+"//percent.xls";
//    	int coefflineindex=0;
//    	String resultdir=filedir+"//results.xls";
//    	int resultslineindex=0;
//    //	1 GanZhou	2 SuNan	3 MinLe	4 LinZe	5 GaoTai	6 ShanDan	7 SuZhou	8 JinTai	9 JiaYuGuan	10 EJNAQ	11 QiLian
//    //GanZhou	SuNan	MinLe	LinZe	GaoTai	ShanDan	SuZhou	JinTai	JiaYuGuan	EJNAQ	QiLian
//
//    	if(countyName.equals("Ganzhou"))
//    	{
//    		coefflineindex=1;
//    		resultslineindex=2;
//    	}
//    	else if(countyName.equals("SuNan"))
//    	{
//    		coefflineindex=2;
//    		resultslineindex=3;
//    	}
//    	else if(countyName.equals("MinLe"))
//    	{
//    		coefflineindex=3;
//    		resultslineindex=4;
//    	}
//    	else if(countyName.equals("LinZe"))
//    	{
//    		coefflineindex=4;
//    		resultslineindex=5;
//    	}
//    	else if(countyName.equals("GaoTai"))
//    	{
//    		coefflineindex=5;
//    		resultslineindex=6;
//    	}
//    	else if(countyName.equals("ShanDan"))
//    	{
//    		coefflineindex=6;
//    		resultslineindex=7;
//    	}
//    	else if(countyName.equals("SuZhou"))
//    	{
//    		coefflineindex=7;
//    		resultslineindex=8;
//    	}
//    	else if(countyName.equals("JinTai"))
//    	{
//    		coefflineindex=8;
//    		resultslineindex=9;
//    	}
//    	else if(countyName.equals("JiaYuGuan"))
//    	{
//    		coefflineindex=9;
//    		resultslineindex=10;
//    	}
//    	else if(countyName.equals("EJNAQ"))
//    	{
//    		coefflineindex=10;
//    		resultslineindex=11;
//    	}
//    	int resultrowstart=8;
//    	int coeffrowstart=1;
//    	int resultsheet[]=new int[]{3,4,8,7,5,6}; //在输出文件对应sheet，产值3，土地4，水价8，就业7，地表水5，地下水6
//    	double coeff[][]=new double[6][48];
//    	double result[][]=new double[6][48];
//    	
//    	double returnvalue[]=new double[] {0,0,0,0,0,0,0,0,0,0};//10个输出： 农业，工业，服务业产值，农业，工业，服务业土地，水价，就业，地表水，地下水 
//    	
//    	int i,j,sheetindex;
//    	for(i=0;i<6;i++)  //0~5  产值，土地，水价，就业，地表水，地下水 
//    	{
//    		coeff[i]=new double[48];
//    		result[i]=new double[48];
//    	}
//    	//读取系数
//    	Workbook rwb = null;
//		Cell cell = null;
//		//创建输入流
//		InputStream stream;
//		Sheet sheet;
//		try
//		{
//			//读取系数
//			stream = new FileInputStream(new File(coeffdir));
//			//获取Excel文件对象
//			rwb = Workbook.getWorkbook(stream);
//			for(sheetindex=0;sheetindex<6;sheetindex++)
//			{
//				sheet = rwb.getSheet(sheetindex); 
//				for(i=coeffrowstart,j=0;j<48;i++,j++)  //i是行号，j是数组下标
//				{
//					coeff[sheetindex][j]=Double.parseDouble(sheet.getCell(i,coefflineindex).getContents());
//				}
//			}
//			stream.close();
//			
//			//读取result值
//			stream = new FileInputStream(new File(resultdir));
//			//获取Excel文件对象
//			rwb = Workbook.getWorkbook(stream);
//			for(sheetindex=0;sheetindex<6;sheetindex++)
//			{
//				sheet = rwb.getSheet(resultsheet[sheetindex]); 
//				for(i=resultrowstart,j=0;j<48;i++,j++)  //i是行号，j是数组下标
//				{
//					result[sheetindex][j]=Double.parseDouble(sheet.getCell(i,resultslineindex).getContents());
//				}
//			}
//			stream.close();
//			//结果都读出来了，现在开始计算
//			//农（1-7），工（8-32），服（33-48）   前两个数组分三段 变成6个输出
//			for(i=0;i<7;i++)
//			{
//				returnvalue[0]=returnvalue[0]+result[0][i]*coeff[0][i];
//				returnvalue[3]=returnvalue[3]+result[1][i]*coeff[1][i];
//			}
//			for(i=7;i<32;i++)
//			{
//				returnvalue[1]=returnvalue[0]+result[0][i]*coeff[0][i];
//				returnvalue[4]=returnvalue[3]+result[1][i]*coeff[1][i];
//			}
//			for(i=32;i<48;i++)
//			{
//				returnvalue[2]=returnvalue[0]+result[0][i]*coeff[0][i];
//				returnvalue[5]=returnvalue[3]+result[1][i]*coeff[1][i];
//			}
//			for(j=6;j<10;j++) //第6到9个输出   计算对应 2-5数组
//			{
//				for(i=0;i<48;i++)
//				{
//					returnvalue[j]=returnvalue[j]+result[j-4][i]*coeff[j-4][i];
//				}
//			}
//			//组合输出了
//			
//			for(i=0;i<9;i++)
//			{
//				returnstr=returnstr+returnvalue[i]+",";
//			}
//			returnstr=returnstr+returnvalue[9];
//		}
//		catch(Exception e)
//		{
//			return coeffdir+","+resultdir+" 处理经济模型结果发生错误";
//		}
//    	return returnstr;
//    }
//  //响应用户按钮    开始计算不同参数变化组合
//    @ResponseBody
//    @RequestMapping(value = "startTestMany", method = RequestMethod.POST)
//    public String startTestMany(String projectId,Boolean economicFrist,String step,Boolean newStart)
//     {
//    	try
//    	{
//    	//DecimalFormat df = new DecimalFormat("#.00");
//    	String flag=modelFunctionService.getTestFlag();
//    	if(flag.equals("1"))
//    	{
//    		return "上个测试还没有完成，请稍后再试";
//    	}
//    	 modelFunctionService.setTestFlag("1",projectId);
//    	//String modelPath="E:\\SVM\\modelfile\\";
//    	String modelPath="/home/software/modelfile/";
//    	//经济模型的输入限制
//    	double jinbumin=0.000001;
//    	double jinbumax=10;//进步率限值
//    	//double []dibiaomin= new double[]{-15,-10,-9,-25,-25,-30,-10,-10,-10,-10}; //地表供水变化率%
//    	//double []dibiaomax= new double[]{20,13,10,25,25,30,10,10,10,20};
//    	
//    	//double []dixiamin= new double[] {-20,-20,-30,-10,-10,-2,-10,-10,-10,-20};//地下供水变化率%
//    	//double []dixiamax= new double[] {20,20,50,10,10,2,10,10,10,20};
//    	double []dibiaomin= new double[]{-20,-20,-20,-20,-20,-20,-20,-20,-20,-20,-20}; //地表供水变化率%
//    	double []dibiaomax= new double[]{20,20,20,20,20,20,20,20,20,20,20};
//    	
//    	double []dixiamin= new double[] {-20,-20,-20,-20,-20,-20,-20,-20,-20,-20,-20};//地下供水变化率%
//    	double []dixiamax= new double[] {20,20,20,20,20,20,20,20,20,20,20};//20181121根据刘天龙重新取值范围
//    	int i;
//     	//获取所有的网页情景    
//    	if(newStart)//如果是重新开始
//    	{
//    		modelFunctionService.deleteTestManyOutput(projectId); //先把测试对应的数据库删干净
//    	}
//    	
//    	int stepnum=Integer.parseInt(step);	
// 		//温度（℃）	[0,2]
//		 //降水（%）	[-15,15]
//		 //耕地面积变化率（%）	[-5,5]
// 		//农业技术进步率（%）	[0,10]
//        //下游下泄量（亿立方米）	[6.5,21]
//		 double wendu_low=0,wendu_high=2;
//		 double jiangyu_low=-15,jiangyu_high=15;
//    	double gendi_low=-5,gendi_high=5;
//    	double nongjinbu_low=0,nongjinbu_high=10;
//    	double xiayou_low=6.5,xiayou_high=21;
//    	
//    	int wendu_index,jiangyu_index,gendi_index,nongjinbu_index,xiayou_index;
//    	
//    	
//     	//声明所有输入输出变量
//     	double PreChangeR; //降雨增加比例 单位：%                1-x1
//     	double TempChange; //温度变化 单位：℃                                                   1-x2
//
//     	double IARArg; //产业技术进步率-农业 单位：%
//    	double IARInd; //产业技术进步率-工业 单位：%
//    	double IARSer; //产业技术进步率-服务业 单位：%
//    	double LandFarmR; //耕地变化率 单位：%
//     	double IARArg_year;
//     	double IARInd_year;
//     	double IARSer_year;
//     	double LandFarmR_year;
//     	double dibiao_year;
//     	double dixia_year;
//    	double zhengyixia;//正义峡下泄量 亿立方米 
//     	//获取所有的网页情景    
//     	//网页情景返回应该是按区县排序 
//     	//查找
//     	//ClimatePara climate;
//     	LandPara land;
//     	WaterPara water;
//     	EcoPara eco; 	
//     	TestManyOutput[] testResult;	
//     	String username = userservice.getCurrentUserId();
//     	Project myPro=getWebServiceParaService.getProjectById(username,projectId);
//     	if(myPro==null)
// 		{
// 			return "项目信息不存在";
// 		}
//     	
//         int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//         int timeEnd = Integer.parseInt(myPro.getGoalYear());
//         int yearNum= timeEnd-timeStart+1;
//         int yearIndex;//年份循环变量
//         String watershedId=myPro.getWatershedId();
//
//         double PreChangeR_year;//年降雨变化 %
//         double TempChange_year;//年温度变化 ℃
//         //上游变量
//        double precylx,precother,airtylx,airtother;
//         double arr_FlowYLX[]=new double[yearNum];//莺落峡所有年份流量输出
//         double arr_FlowOther[]=new double[yearNum];//其他河流流量输出
//         //要用到的变量
//         int j=0,k;
//	     	int countyIndex;
//	     	
//	     	//模型输出数组
//	     	int outIndex=yearNum*10;
//	     	testResult=new TestManyOutput[outIndex];//只计算10个区县
//	     	for(i=0;i<outIndex;i++)
//	     	{
//	     		testResult[i]=new TestManyOutput();
//	     	}
//	     	int yearInt;   
//	     	//读文件，获取中下游模型的a和b
//	     	//读文件，获取X的max和min
//	     	double a[]=new double[30];
//	 		double b[]=new double[30];
//	 		try
//	 		{
//	 			BufferedReader abr=new BufferedReader(new FileReader(modelPath+"a.txt"));
//	 			BufferedReader bbr=new BufferedReader(new FileReader(modelPath+"b.txt"));
//	 			for(i=0;i<30;i++)
//	 			{
//	 				a[i]=Double.valueOf(abr.readLine()).doubleValue();
//	 				b[i]=Double.valueOf(bbr.readLine()).doubleValue();
//	 			}
//	 			abr.close();
//	 			bbr.close();
//	 		}
//	 		catch(Exception e)
//	 		{
//	 			System.out.println(e.toString());
//	 			return "打开中下游生态水文模型系数a,b文件错误";
//	 		}
//	 		double max[]=new double[25];
//	 		double min[]=new double[25];
//	 		try
//	 		{
//	 			BufferedReader abr=new BufferedReader(new FileReader(modelPath+"minmax.txt"));
//	 			for(i=0;i<25;i++)
//	 			{
//	 				min[i]=Double.valueOf(abr.readLine()).doubleValue();
//	 				max[i]=Double.valueOf(abr.readLine()).doubleValue();
//	 			}
//	 			abr.close();
//	 		}
//	 		catch(Exception e)
//	 		{
//	 			System.out.println(e.toString());
//	 			return "打开中下游生态水文模型系数输入限值文件错误";
//	 		}
//	 		
//	 		svm_model svmmodel[]=new svm_model[30];
//	 		String fileName;
//	     	String line;
//	 		int modelindex;
//	 		j=0;
//	 		for(i=1;i<=10;i++) //读取30个模型
//	 		{
//	 			for(k=1;k<=3;k++)
//	 			{
//	 				modelindex=i*10+k;
//	 				fileName=modelPath+"model"+modelindex+".txt";
//	 				try
//	 				{
//	 					svmmodel[j] = svm.svm_load_model(fileName);
//	 					if (svmmodel[j]== null)
//	 					{
//	 						System.err.print("can't open model file "+fileName);
//	 						return "打开SVM模型文件错误 "+fileName;
//	 					}
//	 					j++;
//	 				}
//	 				catch(Exception e)
//	 				{
//	 					System.out.println(e.toString());
//	 					return "打开SVM模型文件错误  "+fileName;
//	 				}
//	 			}
//	 		}
//	 		svm_node[]x=new svm_node[25];
//	 		double input[]=new double[25];
//	 		//定制SVM的输入X
//	 		for(i=0;i<25;i++)
//	 		{
//	 			x[i] = new svm_node();
//	 			x[i].index=i+1;
//	 		}
//	 		Map<String,Object> allClimate=modelFunctionService.getClimateParaMap(projectId);
//	     	if(allClimate.size()<14)
//	     	{
//	     		return "气候情景参数不全";
//	     	}
//	     	Map<String,Object> allLand=modelFunctionService.getLandParaMap(projectId);
//	     	if(allLand.size()<14)
//	     	{
//	     		return "土地利用情景参数不全";
//	     	}
//	     	Map<String,Object> allEco=modelFunctionService.getEcoParaMap(projectId);
//	     	if(allEco.size()<14)
//	     	{
//	     		return "社会经济情景参数不全";
//	     	}
//	     	Map<String,Object> allWater=modelFunctionService.getWaterParaMap(projectId);
//	     	if(allWater.size()<14)
//	     	{
//	     		return "水资源情景参数不全";
//	     	}
//	     	Map<String,Object> indiparaMap=modelFunctionService.getIndiParabyWatershedId(watershedId);
//	     	if(indiparaMap.size()<10)
//	     	{
//	     		return "基础年参数不全";
//	     	}
//	     	j=0;
//	     	ClimatePara climateArr[]=new ClimatePara[11];
//	     	climateArr[0]=(ClimatePara)(allClimate.get("620702"));
//	     	climateArr[1]=(ClimatePara)(allClimate.get("620723"));
//	     	climateArr[2]=(ClimatePara)(allClimate.get("620724"));
//	     	climateArr[3]=(ClimatePara)(allClimate.get("620725"));
//	     	climateArr[4]=(ClimatePara)(allClimate.get("620722"));
//	     	climateArr[5]=(ClimatePara)(allClimate.get("620721"));
//	     	climateArr[6]=(ClimatePara)(allClimate.get("620200"));
//	     	climateArr[7]=(ClimatePara)(allClimate.get("620902"));
//	     	climateArr[8]=(ClimatePara)(allClimate.get("620921"));
//	     	climateArr[9]=(ClimatePara)(allClimate.get("152923"));
//	     	climateArr[10]=(ClimatePara)(allClimate.get("632222")); //祁连县
//	     	/*中下游模型按下列区县顺序
//	     	620702	甘州区      
//	     	620723	临泽县
//	     	620724	高台县
//	     	620725	山丹县
//	     	620722	民乐县
//	     	620721	肃南县
//	     	620200	嘉峪关市
//	     	620902	肃州区
//	     	620921	金塔县
//	     	152923	额济纳旗*/
//	     	for(i=0;i<10;i++)//非农业用水  一直不变，从网页情景得来
//	 		{
//	 			water=(WaterPara)(allWater.get(climateArr[i].getCountyId()));	
//	 			input[5+i]=Double.parseDouble(water.getSupWater());
//	 			if(input[5+i]>=min[5+i] && input[5+i]<=max[5+i])
//	 			{
//	 				x[5+i].value=(input[5+i]-min[5+i])/(max[5+i]-min[5+i]);
//	 			}
//	 			else
//	 			{
//	 				if(input[5+i]<min[5+i])
//	 				{
//	 					x[5+i].value=0;
//	 				}
//	 				else if(input[5+i]>max[5+i])
//	 				{
//	 					x[5+i].value=1;
//	 				}
//	 			}
//	 		}
//	 		
//	 		String countyId;	
//	 		double v;
//	 		double A[]=new double[6];
//	 		double AA[][]=new double[11][6];//用来组合经济模型输入变量的
//	        for(i=0;i<11;i++)
//	        {
//	        	AA[i]=new double[6];
//	        }
//
//	 		double ht[]=new double[22];
//	 		IndicatorPara indiPara;
//	 		double SurSup1,SurSup2;//第一年数据，第二年数据
//	 		double GWSup1,GWSup2;
//	 		double value[]=new double[10];
//	 	  //指标计算相关
//	 		List<IndicatorInfo> indiInfoList=modelFunctionService.getIndicatorInfo(watershedId);
//	     	if(indiInfoList.size()==0)
//	     	{
//	     		return "指标信息不存在";
//	     	}
//	     	Goal goal=goalService.getGoalById(projectId);
//	     	if(goal==null)
//	     	{
//	     		return "项目目标信息不存在";
//	     	}
//	     	//很关键的一步来了~  看哪些指标是需要计算的   1.用户指定的与目前能算的交集~~
//	     	for(i=0;i<indiInfoList.size();i++)
//	     	{
//	     		indiInfoList.get(i).setNeed(false);
//	     	}
//	     	indiInfoList.get(0).setNeed(true);//1.1.1
//	     	indiInfoList.get(1).setNeed(true);//1.1.2
//	     	indiInfoList.get(2).setNeed(true);//1.2.1  安全水
//	     	indiInfoList.get(7).setNeed(true);//1.4.3
//	     	indiInfoList.get(9).setNeed(true);//2.1.1  9森林覆盖率
//	     	indiInfoList.get(10).setNeed(true);//2.2.1 10 退化土地占总土地面积比例
//	     	indiInfoList.get(11).setNeed(true);//2.3.1
//	     	indiInfoList.get(12).setNeed(true);//3.1.1
//	     	indiInfoList.get(13).setNeed(true);//3.2.1
//	     	indiInfoList.get(17).setNeed(true);//3.5.2
//	     	indiInfoList.get(19).setNeed(true);//3.7.1
//	     	indiInfoList.get(20).setNeed(true);//3.7.2
//	     	indiInfoList.get(22).setNeed(true);//3.8.1 	
//
//	     	int indiIndex=0;
//	     	int modeloutindex;
//	     	double GDP;//总产值(元)
//	     	double waterDemand;//总需水量(m3)
//	     	double POP=0;// 区域总人口数量(万人)
//	     	double Area;// 山地所在区域总面积(km2)   	
//	     	double baseNeedSurWater[]=new double[10];
//	     	double baseNeedGWater[]=new double[10];
//	     	double baseForestArea;
//	     	double baseGrassArea;
//	     	double agrivalue[]=new double[10];
//	     	double indivalue[]=new double[10];
//	     	double servalue[]=new double[10];
//	     	double empr[]=new double[10];
//	     	double agriarea[]=new double[10];
//	     	double safewaterpop;
//	     	double agrivaluer;
//	     	double indivaluer;
//	     	double servaluer;
//	     	double surwaterr;
//	     	double gwaterr;
//	     	double surwaterOffer;
//	     	double gwaterOffer;
//	     	double safewaterr;
//	     	double safewaterr_year;
//	     	double safepop;
//	     	double x0,xm,r;
//	     	double forestr,forestr_year,grassr,grassr_year,greenarea;
//	     	double emppopr;//当年的就业率
//	     	double lameda,nagek,urbanr;
//	     	double agriwater,agriwaterb;
//	     	double agriareareult,agriarear,emprr;
//         	double indiarea[]=new double[10];
//         	double serarea[]=new double[10];
//         	double waterP[]=new double[10];
//         	double indiarear,serarear,waterpr;
//         	
//         	double agrarear;
//         	double baseSurWater,baseUGWater,agrivalueyy,indivalueyy,servalueyy,waterpricey;
//            double agrareagq,indiareagq,serareagq;
//	     	
//            //跟指标评价有关的    	
//	     	int gw1,gw2,gw3;
//	     	String gwstr1=goal.getGoal_1();
//	     	String gwstr2=goal.getGoal_2();
//	     	String gwstr3=goal.getGoal_3();
//	     	if(gwstr1.equals("undefined") || gwstr1.equals("undefined") || gwstr1.equals("undefined"))
//	     	{
//	     		return "项目目标权重未指定";
//	     	}
//	     	gw1=Integer.parseInt(gwstr1);
//	     	gw2=Integer.parseInt(gwstr2);
//	     	gw3=Integer.parseInt(gwstr3);
//	     	int temp=gw1+gw2+gw3;
//	     	if(temp!=100)
//	     	{
//	     		return "目标权重之和应等于100";
//	     	}
//	     	float fgw1=(float) (gw1*0.01);
//	     	float fgw2=(float) (gw2*0.01);
//	     	float fgw3=(float) (gw3*0.01);
//	     	
//	     	String wstr=""+fgw1+" "+fgw2+" "+fgw3;
//	     	
//	     	int goal1num=4,goal2num=3,goal3num=6;
//	    	String numStr=goal1num+" "+goal2num+" "+goal3num;
//	    	String firstline="5";
//	    	i=0;
//
//		    for(;i<indiInfoList.size();i++)
//		    {
//		    	if(indiInfoList.get(i).getNeed()!=null && indiInfoList.get(i).getNeed()==true)
//		    	{
//		    		firstline=firstline+"\t"+indiInfoList.get(i).getDirection();
//		    	}
//		    }
//		    String wfile="/opt/evalmodeltest/evalmodel20180622/goalweight.txt";
//    		BufferedWriter wWriter = null;
//    		File wf=new File(wfile);
//    		
//			try{
//				if(!wf.exists()){
//					wf.createNewFile();
//				}
//				wWriter=new BufferedWriter(new FileWriter(wf, false));
//				wWriter.write(wstr);
//	        }
//			catch (FileNotFoundException ex) {
//			    ex.printStackTrace();
//			    return "写评价文件权重出错-文件不存在";
//			} 
//			catch (IOException ex) {
//				ex.printStackTrace();
//				return "写评价文件权重出错";
//			} 
//			finally {
//			    //Close the bufferWritter
//			    try {			      
//			        if (wWriter != null) {
//			        	wWriter.flush();
//			        	wWriter.close();
//			        }
//			    } 
//			    catch (IOException ex) {
//			        ex.printStackTrace();
//			        return "关闭文件出错";
//			    }
//
//		    }
//		 int alreadynum=0;
//		 
//		 if(!newStart)
//		 {
//			 alreadynum=Integer.valueOf(modelFunctionService.getNum(projectId)).intValue();
//			 alreadynum=alreadynum/(100*yearNum);
//		 }
//         //组合变量计算
//		 int num=0;
//         for(wendu_index=0;wendu_index<=stepnum;wendu_index++)
//         {
//        	 TempChange=wendu_low+(wendu_high-wendu_low)/stepnum*wendu_index; //温度变化 单位：℃ 
//        	 if(TempChange<0.000001)
//             {
//            	 TempChange=0;
//             }
//             else if(TempChange>2)
//             {
//            	 TempChange=2;
//             }
//        	 double pre,temper;
//        	 for(jiangyu_index=0;jiangyu_index<=stepnum;jiangyu_index++)
//        	 {
//        		 PreChangeR=jiangyu_low+(jiangyu_high-jiangyu_low)/stepnum*jiangyu_index;//降雨增加比例 单位：%
//                //上游模型只和温度与降水有关系 所以
//        		 if(PreChangeR<-15)
//                 {
//                	 PreChangeR=-15;
//                 }
//                 else if(PreChangeR>15)
//                 {
//                	 PreChangeR=15;
//                 }
//                 
//        		 PreChangeR_year=PreChangeR/yearNum/100;
//			    	TempChange_year=TempChange/yearNum;
//
//    	     	for(yearIndex=1;yearIndex<yearNum;yearIndex++)//按年份开始计算上游模型了
//    	     	{
//    	     		//黑河上游2001至2012年年平均气温（K）在干流区和非干流区分别为：270.24，271.60，拟合公式适用范围为【269K, 275K】
//    	     		//年平均降水（mm）在干流区和非干流区分别为669.15，814.35，拟合公式适用范围为 [407,1000]
//    	     		//上游模型：
//    	     		pre=1+PreChangeR_year*(Math.random()+0.5)*yearIndex;
//    	     		     		precylx=669.15*pre;//鹰落峡降水mm
//    	     		     		if(precylx<407)
//    	     		     		{
//    	     		     			precylx=407;
//    	     		     		}  
//    	     		     		else if(precylx>1000)
//    	     		     		{
//    	     		     			precylx=1000;
//    	     		     		}
//    	     		     		//precother=814.35*Math.pow(1+pre,1+yearIndex);//鹰落峡降水mm 
//    	     		     		precother=814.35*pre;//鹰落峡降水mm 
//    	     		     		if(precother<407)
//    	     		     		{
//    	     		     			precother=407;
//    	     		     		}  
//    	     		     		else if(precother>1000)
//    	     		     		{
//    	     		     			precother=1000;
//    	     		     		}
//    	     		     		//1摄氏度(℃)=274.15开尔文(K) 不对，应该摄氏度和开尔文温度的差值是一样的
//    	     		     		//temper=TempChange_year*(1+yearIndex);
//    	     		     		temper=TempChange*yearIndex;
//    	     		     		airtylx=270.24+temper;
//    	     		     		if(airtylx<269)
//    	     		     		{
//    	     		     			airtylx=269;
//    	     		     		}
//    	     		     		else if(airtylx>275)
//    	     		     		{
//    	     		     			airtylx=275;
//    	     		     		}
//    	     		     		airtother=271.60+temper;
//    	     		     		if(airtother<269)
//    	     		     		{
//    	     		     			airtother=269;
//    	     		     		}
//    	     		     		else if(airtother>275)
//    	     		     		{
//    	     		     			airtother=275;
//    	     		     		}
//
//    	     		//立方米-》亿立方米
//    	     		arr_FlowYLX[yearIndex]=(177.825085*precylx*precylx
//    	     		       + 6988908.56*airtylx*airtylx
//    	     		       -77217.5416*precylx*airtylx
//    	     		       +26500711*precylx-3.84373553e9*airtylx + 5.26858754e11)/1e8;
//    	     		arr_FlowOther[yearIndex]=(-3.94249672e2 *precother*precother
//    	     		       -1.62845167e7*airtother*airtother
//    	     		       +1.27406840e6*precother*airtother
//    	     		       -3.41549958e8*precother
//    	     		       +7.82500648e9*airtother -9.25319379e+11)/1e8;
//    	     	}//此时已经计算完上游模型，结果存在arr_Out_FlowYLX arr_Out_FlowOther 
//        		 for(gendi_index=0;gendi_index<=stepnum;gendi_index++)
//        		 {	 
//        			 LandFarmR=gendi_low+(gendi_high-gendi_low)/stepnum*gendi_index; //耕地变化率 单位：%
//        			 //LandFarmR_year=LandFarmR/yearNum/100;
//        			 for(nongjinbu_index=0;nongjinbu_index<=stepnum;nongjinbu_index++)
//        			 {
//        				 IARArg=nongjinbu_low+(nongjinbu_high-nongjinbu_low)/stepnum*nongjinbu_index; //产业技术进步率-农业 单位：%
//        				// IARArg_year=IARArg/yearNum/100;
//        				 for(xiayou_index=0;xiayou_index<=stepnum;xiayou_index++)
//         {
//        	num++;
//        	if(!newStart)
//        	{
//	        	if(num<=alreadynum)
//	        	{
//	        		continue;//略过本次循环，不计算
//	        	}
//        	}
//        	zhengyixia=xiayou_low+(xiayou_high-xiayou_low)/stepnum*xiayou_index;
//        	
//        	for(countyIndex=0;countyIndex<10;countyIndex++)// 2012年的
//    		{
//        		countyId=climateArr[countyIndex].getCountyId();
//				testResult[countyIndex]=new TestManyOutput();
//				indiPara=(IndicatorPara)(indiparaMap.get(countyId));
//				testResult[countyIndex].setArgValue(indiPara.getAgrivalue());
//				testResult[countyIndex].setArgValueR("0");
//				testResult[countyIndex].setCountyId(countyId);
//				testResult[countyIndex].setCropET(indiPara.getCropET());
//				testResult[countyIndex].setEmp(indiPara.getEmpr());
//				testResult[countyIndex].setEmpR("0");
//				testResult[countyIndex].setFlowOther(indiPara.getFlowOther());
//				testResult[countyIndex].setFlowYLX(indiPara.getFlowYLX());
//				testResult[countyIndex].setGWSup(indiPara.getGWSup());
//				testResult[countyIndex].setGWWD(""+Float.parseFloat(indiPara.getBaseNeedGWater())/Float.parseFloat(indiPara.getEcopro()));
//				testResult[countyIndex].setGWWDR("0");
//				testResult[countyIndex].setIndValue(indiPara.getIndivalue());
//				testResult[countyIndex].setIndValueR("0");
//				testResult[countyIndex].setLandCI(indiPara.getIndiArea());
//				testResult[countyIndex].setLandCIR("0");
//				testResult[countyIndex].setLandSer(indiPara.getSerArea());
//				testResult[countyIndex].setLandSerR("0");
//				testResult[countyIndex].setLandFarm(indiPara.getFarmArea());
//				testResult[countyIndex].setLandFarmR("0");
//				testResult[countyIndex].setProjectId(projectId);
//				testResult[countyIndex].setSerValue(indiPara.getServalue());
//				testResult[countyIndex].setSerValueR("0");
//				testResult[countyIndex].setSurSup(indiPara.getSurSup());
//				testResult[countyIndex].setSurWD(""+Float.parseFloat(indiPara.getBaseNeedSurWater())/Float.parseFloat(indiPara.getEcopro()));
//				testResult[countyIndex].setSurWDR("0");
//				testResult[countyIndex].setWaterP(indiPara.getWaterPrice());
//				testResult[countyIndex].setWaterPR("0");
//				//modelOutputArr[countyIndex].setWetlandArea("");
//				testResult[countyIndex].setYear(myPro.getBaseYear());
//    		}
//
//        	String paraString="";
//        	
//        		IModelEconomic IModelEconomicService= new IModelEconomicImpl().getIModelEconomicImplPort();
//        		String countyName[]=new String[] {"GanZhou","LinZe","GaoTai","ShanDan","MinLe","SuNan","JiaYuGuan","SuZhou","JinTai","EJNAQ"};
//        		String ecooutput;
//        		String ecooutputArr[];
//        		for(yearIndex=1;yearIndex<yearNum;yearIndex++)//按年份开始计算中下游模型和经济模型了
//    	 		{
//    	 			yearInt=timeStart+yearIndex;
//    	 			if(economicFrist)
//    	 			{
//    	 				for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    先算经济模型
//    	 				{
//    	 					countyId=climateArr[countyIndex].getCountyId();
//    	 					water=(WaterPara)allWater.get(countyId);
//    	 					indiPara=(IndicatorPara)indiparaMap.get(countyId);
//    	 					eco=(EcoPara)allEco.get(countyId);
//    			     		//IARArg=Float.parseFloat(eco.getIARArg());  //农业技术进步率不从网上取
//    			     		IARInd=Float.parseFloat(eco.getIARInd()); 
//    			     		IARSer=Float.parseFloat(eco.getIARSer());
//    			     		
//    	 					IARArg_year=IARArg/yearNum/100;
//        		     		IARInd_year=IARInd/yearNum/100;
//        		     		IARSer_year=IARSer/yearNum/100;
//        		     		dibiao_year=Float.parseFloat(water.getSurSup())/yearNum/100;
//        		     		dixia_year=Float.parseFloat(water.getGWSup())/yearNum/100;
//
//        		     		if(countyIndex!=10)//不是祁连县
//        		     		{
//        		     			if(yearIndex==1)
//            		     		{
//            		     			AA[countyIndex][1]=dibiao_year*yearIndex*100;
//            		     			AA[countyIndex][2]=dixia_year*yearIndex*100;
//            		     			
//            		     		}
//            		     		else if(yearIndex==2)//第一年减基础年     					
//            		     		{
//            		     			SurSup2=Double.parseDouble(testResult[(yearIndex-1)*10+countyIndex].getSurSup())*Float.parseFloat(indiPara.getEcopro());
//            		     			SurSup1=Double.parseDouble(indiPara.getBaseNeedSurWater());    		     			
//            		     			GWSup2=Double.parseDouble(testResult[(yearIndex-1)*10+countyIndex].getGWSup())*Float.parseFloat(indiPara.getEcopro());
//            		     			GWSup1=Double.parseDouble(indiPara.getBaseNeedGWater());
//            		     			AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;
//            		     			AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;	
//            		     		}
//            		     		else
//            		     		{
//            		     			SurSup2=Double.parseDouble(testResult[(yearIndex-1)*10+countyIndex].getSurSup());
//            		     			GWSup2=Double.parseDouble(testResult[(yearIndex-1)*10+countyIndex].getGWSup());
//            		     			SurSup1=Double.parseDouble(testResult[(yearIndex-2)*10+countyIndex].getSurSup());
//            		     			GWSup1=Double.parseDouble(testResult[(yearIndex-2)*10+countyIndex].getGWSup());	
//            		     			AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;
//            		     			AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;
//            		     		}
//        		     		}
//        		     		else//是祁连县
//        		     		{
//        		     			AA[countyIndex][1]=dibiao_year*yearIndex*100;
//        		     			AA[countyIndex][2]=dixia_year*yearIndex*100;
//        		     		}
//        		     		AA[countyIndex][3]=IARArg_year*yearIndex*100;
//        		     		AA[countyIndex][4]=IARInd_year*yearIndex*100;
//        		     		AA[countyIndex][5]=IARSer_year*yearIndex*100;
//        		     		
//        		     		if(AA[countyIndex][1]<dibiaomin[countyIndex])
//        		     		{
//        		     			AA[countyIndex][1]=dibiaomin[countyIndex];
//        		     		}
//        		     		else if(AA[countyIndex][1]>dibiaomax[countyIndex])
//        		     		{
//        		     			AA[countyIndex][1]=dibiaomax[countyIndex];
//        		     		}
//        		     		if(AA[countyIndex][2]<dixiamin[countyIndex])
//        		     		{
//        		     			AA[countyIndex][2]=dixiamin[countyIndex];
//        		     		}
//        		     		else if(AA[countyIndex][2]>dixiamax[countyIndex])
//        		     		{
//        		     			AA[countyIndex][2]=dixiamax[countyIndex];
//        		     		}
//        		     		if(AA[countyIndex][3]<jinbumin)
//        		     		{
//        		     			AA[countyIndex][3]=0;
//        		     		}
//        		     		else if(AA[countyIndex][3]>jinbumax)
//        		     		{
//        		     			AA[countyIndex][3]=jinbumax;
//        		     		}
//        		     		if(AA[countyIndex][4]<jinbumin)
//        		     		{
//        		     			AA[countyIndex][4]=0;
//        		     		}
//        		     		else if(AA[countyIndex][4]>jinbumax)
//        		     		{
//        		     			AA[countyIndex][4]=jinbumax;
//        		     		}
//        		     		if(AA[countyIndex][5]<jinbumin)
//        		     		{
//        		     			AA[countyIndex][5]=0;
//        		     		}
//        		     		else if(AA[countyIndex][5]>jinbumax)
//        		     		{
//        		     			AA[countyIndex][5]=jinbumax;
//        		     		}    
//        		     		AA[countyIndex][3]=-1*AA[countyIndex][3];
//        		     		AA[countyIndex][4]=-1*AA[countyIndex][4];
//        		     		AA[countyIndex][5]=-1*AA[countyIndex][5];
//    	 				}//end of for
//    	 				paraString="";
//         				for(j=1;j<6;j++)
//         				{
//         					for(i=0;i<11;i++)
//         					{
//         						paraString=paraString+AA[i][j]+",";
//         					}
//         				}
//         				//组合完了，现在才开始调用经济模型
//         				System.out.println("参数是我："+paraString);
//         				ecooutput=IModelEconomicService.start(projectId,paraString,"","","","","");
//    		     		//IModelEconomicService.start("112233","GanZhou","20","10","10","5","8");
//    		     		ecooutputArr=ecooutput.split(",");
//    		     		if(ecooutputArr.length!=100)
//    		     		{
//    		     			return ecooutput+"  len:"+ecooutputArr.length;
//    		     		}
//    		     		System.out.println(ecooutput);
//    		     		//提取结果
//    		     		for(countyIndex=0;countyIndex<10;countyIndex++)
//    		     		{
//    		     			countyId=climateArr[countyIndex].getCountyId();
//    		     			testResult[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setProjectId(projectId);//~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setArgValueR(ecooutputArr[countyIndex*10]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setIndValueR(ecooutputArr[countyIndex*10+1]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setSerValueR(ecooutputArr[countyIndex*10+2]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setLandFarmR(ecooutputArr[countyIndex*10+3]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setLandCIR(ecooutputArr[countyIndex*10+4]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setLandSerR(ecooutputArr[countyIndex*10+5]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setWaterPR(ecooutputArr[countyIndex*10+6]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setEmpR(ecooutputArr[countyIndex*10+7]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setSurWDR(ecooutputArr[countyIndex*10+8]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setGWWDR(ecooutputArr[countyIndex*10+9]);//~~~~~~  
//    		     		}
//    	 				
//    	 				PreChangeR_year=PreChangeR/yearNum/100;
//     			    	TempChange_year=TempChange/yearNum;
//     			    	
//     			    	input[0]=PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     			    	input[1]=TempChange*yearIndex;
//     			    	
//     	        		input[2]=arr_FlowYLX[yearIndex];// 莺落峡来流(亿m3/y)
//     	        		input[3]=arr_FlowOther[yearIndex];//其他上游来流(亿m3/y)
//     	        		input[4]=zhengyixia;
//     	        		for(i=0;i<5;i++)//前五个输入
//     	        		{
//     	        			if(input[i]>=min[i] && input[i]<=max[i])
//     	        			{
//     	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//     	        			}
//     	        			else
//     	        			{
//     	        				if(input[i]<min[i])
//    	        				{
//    	        					x[i].value=0;
//    	        				}
//    	        				else if(input[i]>max[i])
//    	        				{
//    	        					x[i].value=1;
//    	        				}
//     	        			}
//     	        		}  
//     	        		for(i=0;i<10;i++)//因为先算的  经济模型，所以直接取今年的
//     	        		{
//     	        			input[15+i]=Double.parseDouble(testResult[yearIndex*10+i].getLandFarmR())/100;
//     	        			if(input[15+i]>=min[15+i] && input[15+i]<=max[15+i])
//     	        			{
//     	        				x[15+i].value=(input[15+i]-min[15+i])/(max[15+i]-min[15+i]);
//     	        			}
//     	        			else
//     	        			{
//     	        				if(input[15+i]<min[15+i])
//    	        				{
//    	        					x[15+i].value=0;
//    	        				}
//    	        				else if(input[15+i]>max[15+i])
//    	        				{
//    	        					x[15+i].value=1;
//    	        				}
//     	        			}
//     	        		}
//    	 				for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    再算中下游水文模型  
//    	 				{
//    	 					countyId=climateArr[countyIndex].getCountyId();
//    	 					//再算中下游水文模型
//    	 	        		//组合模型输出
//    	 	        		testResult[yearIndex*10+countyIndex].setFlowYLX(""+arr_FlowYLX[yearIndex]);//~~~~~~
//    	 	        		testResult[yearIndex*10+countyIndex].setFlowOther(""+arr_FlowOther[yearIndex]);//~~~~~~
//    	 	        		
//    	 	        		
//    	 	        		//至此为止，SVM的输入X已经组合好了！！！
//    	 	        		//开始计算SVM模型
//    	 	        		v = svm.svm_predict(svmmodel[countyIndex*3],x);
//    	 	        		v=v*a[countyIndex*3]+b[countyIndex*3];
//    	 	        		v=v/10000;
//    	 	        		testResult[yearIndex*10+countyIndex].setSurSup(""+v);//地表水引用量(万吨/年)//~~~~~~
//    	 	        		
//    	 	        		v = svm.svm_predict(svmmodel[countyIndex*3+1],x);
//    	 	        		v=v*a[countyIndex*3+1]+b[countyIndex*3+1];
//    	 	        		v=v/10000;
//    	 	        		testResult[yearIndex*10+countyIndex].setGWSup(""+v);//地下水抽取量(万吨/年)//~~~~~~
//    	 	        		
//    	 	        		v = svm.svm_predict(svmmodel[countyIndex*3+2],x);
//    	 	        		v=v*a[countyIndex*3+2]+b[countyIndex*3+2];
//    	 	        		v=v/10000;
//    	 	        		testResult[yearIndex*10+countyIndex].setCropET(""+v);//耕地面积ET量(万吨/年)//~~~~~~ 
//    		 			}
//    	 			}
//    	 			else//生态水文先算
//    	 			{
//    	 				PreChangeR_year=PreChangeR/yearNum/100;
//     			    	TempChange_year=TempChange/yearNum;
//     			    	
//     			    	input[0]=PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     			    	input[1]=TempChange*yearIndex;
//     			    	
//     	        		input[2]=arr_FlowYLX[yearIndex];// 莺落峡来流(亿m3/y)
//     	        		input[3]=arr_FlowOther[yearIndex];//其他上游来流(亿m3/y)
//     	        		input[4]=zhengyixia;
//     	        		for(i=0;i<5;i++)//前五个输入
//     	        		{
//     	        			if(input[i]>=min[i] && input[i]<=max[i])
//     	        			{
//     	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//     	        			}
//     	        			else
//     	        			{
//     	        				if(input[i]<min[i])
//    	        				{
//    	        					x[i].value=0;
//    	        				}
//    	        				else if(input[i]>max[i])
//    	        				{
//    	        					x[i].value=1;
//    	        				}
//     	        			}
//     	        		}
//    	 				for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    先算生态水文模型
//    	 				{
//    	 					countyId=climateArr[countyIndex].getCountyId();
//    	 					testResult[yearIndex*10+countyIndex]=new TestManyOutput();
//    	 					testResult[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//    	 					testResult[yearIndex*10+countyIndex].setProjectId(projectId);//~~~~~
//    	 			        
//    	 	        		
//    	 	        		//组合模型输出
//    	 	        		testResult[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~~
//    	 	        		testResult[yearIndex*10+countyIndex].setFlowYLX(""+arr_FlowYLX[yearIndex]);//~~~~~~
//    	 	        		testResult[yearIndex*10+countyIndex].setFlowOther(""+arr_FlowOther[yearIndex]);//~~~~~~
//    	 	        		
//    	 	        		if(yearIndex==1) //第一年的耕地变化率，从网页得来  从设置来
//    	 	        		{
//    	 	        			//landFarmR_year=Math.pow(1+LandFarmR/100, 1/yearNum)-1; 
//    	 	        			LandFarmR_year=LandFarmR/yearNum/100; 
//    	 	        			for(i=0;i<10;i++)
//    	 	        			{ 	        	
//    	 	        				input[15+i]=LandFarmR_year*yearIndex;
//    	 	        			}
//    	 	        		}
//    	 	        		else//从第二年起，就从上一年的经济模型的输出里面取得
//    	 	        		{
//    	 	        			for(i=0;i<10;i++)
//    	 	        			{
//    	 	        				input[15+i]=Double.parseDouble(testResult[(yearIndex-1)*10+i].getLandFarmR())/100;
//    	 	        			}
//    	 	        		}
//    	 	        		for(i=15;i<25;i++)//后10个输入
//    	 	        		{
//    	 	        			if(input[i]>=min[i] && input[i]<=max[i])
//    	 	        			{
//    	 	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//    	 	        			}
//    	 	        			else
//    	 	        			{
//    	 	        				if(input[i]<min[i])
//    		        				{
//    		        					x[i].value=0;
//    		        				}
//    		        				else if(input[i]>max[i])
//    		        				{
//    		        					x[i].value=1;
//    		        				}
//    	 	        			}
//    	 	        		}//至此为止，SVM的输入X已经组合好了！！！
//    	 	        		//开始计算SVM模型	
//    	 	        		v = svm.svm_predict(svmmodel[countyIndex*3],x);
//    	 	        		v=v*a[countyIndex*3]+b[countyIndex*3];
//    	 	        		v=v/10000;
//    	 	        		SurSup2=v;  //计算pcm要用
//    	 	        		testResult[yearIndex*10+countyIndex].setSurSup(""+v);//地表水引用量(亿立方米/年)//~~~~~~
//    	 	        		
//    	 	        		v = svm.svm_predict(svmmodel[countyIndex*3+1],x);
//    	 	        		v=v*a[countyIndex*3+1]+b[countyIndex*3+1];
//    	 	        		v=v/10000;
//    	 	        		GWSup2=v;//计算pcm要用
//    	 	        		testResult[yearIndex*10+countyIndex].setGWSup(""+v);//地下水抽取量(亿立方米/年)//~~~~~~
//    	 	        		
//    	 	        		v = svm.svm_predict(svmmodel[countyIndex*3+2],x);
//    	 	        		v=v*a[countyIndex*3+2]+b[countyIndex*3+2];
//    	 	        		v=v/10000;
//    	 	        		testResult[yearIndex*10+countyIndex].setCropET(""+v);//耕地面积ET量(亿立方米/年)//~~~~~~ 
//    	 	        		//再算经济模型
//    	 	        		if(yearIndex==1)//基础年
//         	        		{
//         	        			indiPara=(IndicatorPara)(indiparaMap.get(countyId));
//         	        			SurSup1=Double.parseDouble(indiPara.getBaseNeedSurWater());
//         	        			GWSup1=Double.parseDouble(indiPara.getBaseNeedGWater());
//         	        			SurSup2=SurSup2*Float.parseFloat(indiPara.getEcopro());
//         	        			GWSup2=GWSup2*Float.parseFloat(indiPara.getEcopro());
//         	        		}
//         	        		else
//         	        		{
//         	        			SurSup1=Double.parseDouble(testResult[(yearIndex-1)*10+countyIndex].getSurSup());
//         	        			GWSup1=Double.parseDouble(testResult[(yearIndex-1)*10+countyIndex].getGWSup());
//         	        		}
//    	 	        		eco=(EcoPara)allEco.get(countyId);
//    	 	        		//IARArg=Float.parseFloat(eco.getIARArg());
//    	 	        		IARInd=Float.parseFloat(eco.getIARInd());
//    	 	        		IARSer=Float.parseFloat(eco.getIARSer());
//    	 	        		IARArg_year=IARArg/yearNum/100;
//    	 	        		IARInd_year=IARInd/yearNum/100;
//    	 	        		IARSer_year=IARSer/yearNum/100;
//    	 	        		AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;//地表供水量变化率
//         	        		AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;//地下供水量变化率
//         	        		AA[countyIndex][3]=IARArg_year*yearIndex*100;
//         	        		AA[countyIndex][4]=IARInd_year*yearIndex*100;
//         	        		AA[countyIndex][5]=IARSer_year*yearIndex*100;
//         	        		if(AA[countyIndex][1]<dibiaomin[countyIndex])
//        		     		{
//         	        			AA[countyIndex][1]=dibiaomin[countyIndex];
//        		     		}
//        		     		else if(AA[countyIndex][1]>dibiaomax[countyIndex])
//        		     		{
//        		     			AA[countyIndex][1]=dibiaomax[countyIndex];
//        		     		}
//        		     		if(AA[countyIndex][2]<dixiamin[countyIndex])
//        		     		{
//        		     			AA[countyIndex][2]=dixiamin[countyIndex];
//        		     		}
//        		     		else if(AA[countyIndex][2]>dixiamax[countyIndex])
//        		     		{
//        		     			AA[countyIndex][2]=dixiamax[countyIndex];
//        		     		}
//        		     		if(AA[countyIndex][3]<jinbumin)
//        		     		{
//        		     			AA[countyIndex][3]=0;
//        		     		}
//        		     		else if(AA[countyIndex][3]>jinbumax)
//        		     		{
//        		     			AA[countyIndex][3]=jinbumax;
//        		     		}
//        		     		if(AA[countyIndex][4]<jinbumin)
//        		     		{
//        		     			AA[countyIndex][4]=0;
//        		     		}
//        		     		else if(AA[countyIndex][4]>jinbumax)
//        		     		{
//        		     			AA[countyIndex][4]=jinbumax;
//        		     		}
//        		     		if(AA[countyIndex][5]<jinbumin)
//        		     		{
//        		     			AA[countyIndex][5]=0;
//        		     		}
//        		     		else if(AA[countyIndex][5]>jinbumax)
//        		     		{
//        		     			AA[countyIndex][5]=jinbumax;
//        		     		}
//        		     		AA[countyIndex][3]=-1*AA[countyIndex][3];
//        		     		AA[countyIndex][4]=-1*AA[countyIndex][4];
//        		     		AA[countyIndex][5]=-1*AA[countyIndex][5];
//    	 				}//end of 10个区县   生态水文	
//    	 				//再算经济模型
//    	 				//组合祁连县的量
//     					water=(WaterPara)allWater.get("632222");
//     					indiPara=(IndicatorPara)indiparaMap.get("632222");
//    		     		eco=(EcoPara)allEco.get("632222");
//    		     		//IARArg=Float.parseFloat(eco.getIARArg());
//    		     		IARInd=Float.parseFloat(eco.getIARInd());
//    		     		IARSer=Float.parseFloat(eco.getIARSer());
//    		     		IARArg_year=IARArg/yearNum/100;
//    		     		IARInd_year=IARInd/yearNum/100;
//    		     		IARSer_year=IARSer/yearNum/100;
//    		     		dibiao_year=Float.parseFloat(water.getSurSup())/yearNum/100;
//    		     		dixia_year=Float.parseFloat(water.getGWSup())/yearNum/100;
//
//    		     		AA[10][1]=dibiao_year*yearIndex*100;
//    		     		AA[10][2]=dixia_year*yearIndex*100;
//    		     		AA[10][3]=IARArg_year*yearIndex*100;
//    		     		AA[10][4]=IARInd_year*yearIndex*100;
//    		     		AA[10][5]=IARSer_year*yearIndex*100;
//    		     		
//    		     		if(AA[10][1]<dibiaomin[10])
//    		     		{
//    		     			AA[10][1]=dibiaomin[10];
//    		     		}
//    		     		else if(AA[10][1]>dibiaomax[10])
//    		     		{
//    		     			AA[10][1]=dibiaomax[10];
//    		     		}
//    		     		if(AA[10][2]<dixiamin[10])
//    		     		{
//    		     			AA[10][2]=dixiamin[10];
//    		     		}
//    		     		else if(AA[10][2]>dixiamax[10])
//    		     		{
//    		     			AA[10][2]=dixiamax[10];
//    		     		}
//    		     		if(AA[10][3]<jinbumin)
//    		     		{
//    		     			AA[10][3]=0;
//    		     		}
//    		     		else if(AA[10][3]>jinbumax)
//    		     		{
//    		     			AA[10][3]=jinbumax;
//    		     		}
//    		     		if(AA[10][4]<jinbumin)
//    		     		{
//    		     			AA[10][4]=0;
//    		     		}
//    		     		else if(AA[10][4]>jinbumax)
//    		     		{
//    		     			AA[10][4]=jinbumax;
//    		     		}
//    		     		if(AA[10][5]<jinbumin)
//    		     		{
//    		     			AA[10][5]=0;
//    		     		}
//    		     		else if(AA[10][5]>jinbumax)
//    		     		{
//    		     			AA[10][5]=jinbumax;
//    		     		}    
//    		     		AA[10][3]=-1*AA[10][3];
//    		     		AA[10][4]=-1*AA[10][4];
//    		     		AA[10][5]=-1*AA[10][5];
//         				
//    		     		paraString="";
//    		     		for(j=1;j<6;j++)
//         				{
//         					for(i=0;i<11;i++)
//         					{
//         						paraString=paraString+AA[i][j]+",";
//         					}
//         				}
//         				//组合完了，现在才开始调用经济模型
//    		     		System.out.println(paraString);
//         				ecooutput=IModelEconomicService.start(projectId,paraString,"","","","","");
//    		     		//IModelEconomicService.start("112233","GanZhou","20","10","10","5","8");
//    		     		ecooutputArr=ecooutput.split(",");
//    		     		if(ecooutputArr.length!=100)
//    		     		{
//    		     		
//    			     			return ecooutput+"  len:"+ecooutputArr.length;
//    			     		
//    		     		}
//    		     		System.out.println(ecooutput);
//    		     		//提取结果
//    		     		for(countyIndex=0;countyIndex<10;countyIndex++)
//    		     		{
//    		     			countyId=climateArr[countyIndex].getCountyId();
//    		     			testResult[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setProjectId(projectId);//~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setArgValueR(ecooutputArr[countyIndex*10]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setIndValueR(ecooutputArr[countyIndex*10+1]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setSerValueR(ecooutputArr[countyIndex*10+2]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setLandFarmR(ecooutputArr[countyIndex*10+3]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setLandCIR(ecooutputArr[countyIndex*10+4]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setLandSerR(ecooutputArr[countyIndex*10+5]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setWaterPR(ecooutputArr[countyIndex*10+6]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setEmpR(ecooutputArr[countyIndex*10+7]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setSurWDR(ecooutputArr[countyIndex*10+8]);//~~~~~~
//    		     			testResult[yearIndex*10+countyIndex].setGWWDR(ecooutputArr[countyIndex*10+9]);//~~~~~~  
//    		     		}
//    	 			}//end of else//生态水文先算
//    	 		}
//        	
//	 		
//	     	//计算完成，就要存数据库啦！
//	     	//先把项目对应输出删干净
//	     	/*modelFunctionService.deleteModelOutput(projectId);
//	     	outIndex=yearNum*10;
//	     	for(i=0;i<outIndex;i++)
//	     	{
//	     		modelFunctionService.insertModelOutput(modelOutputArr[i]);
//	     	}*/
//	     	
//	         //存完数据库，就要计算指标啦！
//	     	/*计算指标思路，1.读a_goal，看本项目需要算哪些指标；
//	     	2.根据要算的指标index,从defaultIndicator表读取计算公式，用commons-jexl方法解析计算  
//	     	 这一步最大的问题在于：计算进行不下去！！！！！指标计算所需要的很多输入变量没有！！！
//	     	 3.按年份按区县存储指标计算结果到 indicatorOutput表 
//	     	 点指标评价的时候，需要做的事情就是  从defaultIndicator、a_goal、indicatorOutput中组合指标运算web service需要的格式。
//	     	*/
//            double forestbase,forestmax,forestk,grassbase,grassmax,grassk,barebase,baremax,barek,inditemp;
//
//         	for(countyIndex=0;countyIndex<10;countyIndex++)//每个区县
//         	{
//         		countyId=climateArr[countyIndex].getCountyId();
//         		indiPara=(IndicatorPara)indiparaMap.get(countyId);
//         		land=(LandPara)allLand.get(countyId);
//         		water=(WaterPara)allWater.get(countyId);
//         		eco=(EcoPara)allEco.get(countyId);
//         		agrivalue[countyIndex]=Double.parseDouble(indiPara.getAgrivalue());
//         		indivalue[countyIndex]=Double.parseDouble(indiPara.getIndivalue());
//         		servalue[countyIndex]=Double.parseDouble(indiPara.getServalue());
//         		baseNeedSurWater[countyIndex]=Double.parseDouble(indiPara.getBaseNeedSurWater());
//         		baseNeedGWater[countyIndex]=Double.parseDouble(indiPara.getBaseNeedGWater());
//         		
//         		forestbase=Double.parseDouble(indiPara.getForestArea());
//         		forestmax=Double.parseDouble(indiPara.getForestmax());
//         		forestk=Double.parseDouble(land.getLandForestR());
//         		
//         		grassbase=Double.parseDouble(indiPara.getGrassArea());
//         		grassmax=Double.parseDouble(indiPara.getGrassmax());
//         		grassk=Double.parseDouble(land.getLandGrassR());
//         		
//         		barebase=Double.parseDouble(indiPara.getBarebase());
//         		baremax=Double.parseDouble(indiPara.getBaremax());
//         		barek=Double.parseDouble(land.getWaterArea());
//         		
//         		safewaterr=Double.parseDouble(water.getWaterdistribution());//安全饮用水人口年增长率
//         		safewaterr_year=safewaterr/100;
//         		safewaterpop=Double.parseDouble(indiPara.getSafewaterPop());
//         		
//         		x0=Double.parseDouble(indiPara.getPopx0());
//         		xm=Double.parseDouble(indiPara.getPopxm());
//         		r=Double.parseDouble(eco.getPopolicy());
//         		
//         		baseForestArea=Double.parseDouble(indiPara.getForestArea());
//         		baseGrassArea=Double.parseDouble(indiPara.getGrassArea());
//         		forestr=Double.parseDouble(land.getLandForestR());
//         		forestr_year=forestr/yearNum/100;
//         		grassr=Double.parseDouble(land.getLandGrassR());
//         		grassr_year=grassr/yearNum/100;
//         		Area=Double.parseDouble(indiPara.getArea());
//         		lameda=Double.parseDouble(indiPara.getUrbanla());
//         		nagek=Double.parseDouble(eco.getNegak());
//         		agriwater=Double.parseDouble(indiPara.getAgriwater());//农业用水比例
//         		empr[countyIndex]=Double.parseDouble(indiPara.getEmpr());//就业率
//             	agriarea[countyIndex]=Double.parseDouble(indiPara.getFarmArea());//公顷
//             	indiarea[countyIndex]=Double.parseDouble(indiPara.getIndiArea());
//             	serarea[countyIndex]=Double.parseDouble(indiPara.getSerArea());
//             	waterP[countyIndex]=Double.parseDouble(indiPara.getWaterPrice());
//         		for(yearIndex=1;yearIndex<yearNum;yearIndex++)
//         		{
//         			yearInt=timeStart+yearIndex;
//         			indiIndex=countyIndex*yearNum+yearIndex;
//         			modeloutindex=yearIndex*10+countyIndex;
//         
//         			testResult[indiIndex].setCountyId(countyId);//~~~~~~~~~~~~~~~~~~~~~
//         			testResult[indiIndex].setYear(""+yearInt);//~~~~~~~~~~~~~~~~~~~~~
//         			testResult[indiIndex].setProjectId(projectId);//~~~~~~~~~~~~~~~~~~~~~
//         			surwaterr=Double.parseDouble(testResult[modeloutindex].getSurWDR())/100;//地表需水变化率
//     				gwaterr=Double.parseDouble(testResult[modeloutindex].getGWWDR())/100;//地下需水变化率
//     				agrivaluer=Double.parseDouble(testResult[modeloutindex].getArgValueR())/100;
//     				indivaluer=Double.parseDouble(testResult[modeloutindex].getIndValueR())/100;
//     				servaluer=Double.parseDouble(testResult[modeloutindex].getSerValueR())/100;
//     				indiarear=Double.parseDouble(testResult[modeloutindex].getLandCIR())/100;
//     				serarear=Double.parseDouble(testResult[modeloutindex].getLandSerR())/100;
//     				waterpr=Double.parseDouble(testResult[modeloutindex].getWaterPR())/100;
//     				agrarear=Double.parseDouble(testResult[modeloutindex].getLandFarmR())/100;
//     				emprr=Double.parseDouble(testResult[modeloutindex].getEmpR())/100;//就业率变化率
//     						
//     				emppopr=empr[countyIndex]*(1+emprr);//当年的就业率
//     				waterpricey=waterP[countyIndex]*(1+waterpr);
//     				agrareagq=agriarea[countyIndex]*(1+agrarear);
//     				indiareagq=agriarea[countyIndex]*(1+indiarear);
//     				serareagq=agriarea[countyIndex]*(1+serarear);
//     				baseSurWater=baseNeedSurWater[countyIndex]*(1+surwaterr);
//     				baseUGWater=baseNeedGWater[countyIndex]*(1+gwaterr);
//     				waterDemand=baseSurWater+baseUGWater;
//     				//GDP数据库里面是亿元为单位
//     				agrivalueyy=agrivalue[countyIndex]*(1+agrivaluer); 				
//     				indivalueyy=indivalue[countyIndex]*(1+indivaluer);
//     				servalueyy=servalue[countyIndex]*(1+servaluer);
//     				GDP=agrivalueyy+indivalueyy+servalueyy;
//     				surwaterOffer=Double.parseDouble(testResult[modeloutindex].getSurSup());//地表供水
//     				gwaterOffer=Double.parseDouble(testResult[modeloutindex].getGWSup());//地下供水
//     				
//     				POP=xm/(1+(xm/x0-1)*Math.pow(Math.E, -1*r*yearIndex));//万人
//     				if(countyIndex==9)//额济纳旗  用的是阿拉善的数据，要做一下处理   下辖地区阿拉善左旗、阿拉善右旗、额济纳旗 
//     				{
//     					POP=POP/3;
//     				}
//     				
//     				//经济用水
//     				agriwaterb=Float.parseFloat(indiPara.getEcopro())*(surwaterOffer+gwaterOffer);
//     				if(indiInfoList.get(0).getNeed())//提高水生产力到b%//GDP/waterDemand
//         			{
//     					testResult[indiIndex].setWaterProductivity(""+(GDP/agriwaterb));//~~~~~~~~~~~~~~~~~~~~~
//         			}
//         			if(indiInfoList.get(1).getNeed())//在各个层次上减小用水压力到m%    waterConsumption/freshWater
//         			{
//         				testResult[indiIndex].setWaterPressure(""+(waterDemand/(surwaterOffer+gwaterOffer)*100));
//         			}
//         			if(indiInfoList.get(2).getNeed())//提高流域社会安全饮用水人口比例到d%  POPws/POP
//         			{
//         				safepop=safewaterpop*(1+safewaterr_year*yearIndex);
//         				testResult[indiIndex].setSafeDrinkingWaterR(""+(safepop/POP*100));
//         			}
//         			if(indiInfoList.get(7).getNeed())//中游地下水开采量i 亿m3
//         			{
//         				testResult[indiIndex].setGroundwaterMining(""+gwaterOffer);
//         			}
//         			//森林面积
//     				inditemp=forestmax/(1+((forestmax/forestbase-1)*Math.pow(Math.E, -1*forestk*yearIndex)));	
//         			if(indiInfoList.get(9).getNeed())//森林覆盖指数b%
//         			{
//         				testResult[indiIndex].setForestcoverR(""+(inditemp/Area*100));
//         			}
//         			//森林面积+草地面积
//         			inditemp=inditemp+grassmax/(1+((grassmax/grassbase-1)*Math.pow(Math.E, -1*grassk*yearIndex)));
//         			if(indiInfoList.get(11).getNeed())//山地绿色覆盖指数b%
//         			{
//         				testResult[indiIndex].setMountainGreenCoverR(""+(inditemp/Area*100));
//         			}
//         			//土地退化面积
//     				inditemp=baremax/(1+((baremax/barebase-1)*Math.pow(Math.E, -1*barek*yearIndex)));	
//         			if(indiInfoList.get(10).getNeed())//土地退化
//         			{
//         				testResult[indiIndex].setBarecoverR(""+(inditemp/Area*100));
//         			}
//
//         			if(indiInfoList.get(12).getNeed())//人均GDP   万元/万人
//         			{
//         				testResult[indiIndex].setGdpPerCapita(""+((10000*GDP)/POP));
//         			}
//         			if(indiInfoList.get(13).getNeed())//就业人口人均 GDP
//         			{
//         				testResult[indiIndex].setGdpPerCapitaEmployed(""+((10000*GDP)/(POP*emppopr)));
//         			}
//         			if(indiInfoList.get(17).getNeed())//urbanR 
//         			{
//         				urbanr=1/(1+lameda*Math.pow(Math.E, nagek*(1+yearIndex)))*100;
//         				testResult[indiIndex].setUrbanR(""+urbanr);
//         			}
//         			
//         			if(indiInfoList.get(22).getNeed())//维持可持续发展的中游耕地面积在e万亩
//         			{
//         				agriareareult=agrareagq/666.667;  //公顷转化为万亩
//         				testResult[indiIndex].setAreaCrop(""+agriareareult);
//         			}
//         			//农业用水
//         			agriwaterb=agriwater*(surwaterOffer+gwaterOffer);
//         			if(indiInfoList.get(19).getNeed())//提高农业水生产力到b  Ya 农业总产值 (元)/Qtot 农业总用水量(m3)
//         			{
//         				testResult[indiIndex].setWaterProductivityAgri(""+agrivalueyy/agriwaterb);
//         			}
//         			if(indiInfoList.get(20).getNeed())//提高农业水利用效率到c% Ea 作物总蒸腾量(m3)/Qtot 农业总用水量(m3)
//         			{
//         				double temp1=Double.parseDouble(testResult[modeloutindex].getCropET())*0.75/agriwaterb;
//         				testResult[indiIndex].setWaterUseEffiAgri(""+temp1);
//         			}
//         			
//         			//模型新加的几个变量放进去！！！！
//         			if(yearIndex>0)
//         			{
//         			testResult[modeloutindex].setArgValue(""+agrivalueyy);
//     				testResult[modeloutindex].setIndValue(""+indivalueyy);
//     				testResult[modeloutindex].setSerValue(""+servalueyy);
//     				testResult[modeloutindex].setLandFarm(""+agrareagq);
//     				testResult[modeloutindex].setLandCI(""+indiareagq);
//     				testResult[modeloutindex].setLandSer(""+serareagq);
//     				testResult[modeloutindex].setEmp(""+emppopr);
//     				testResult[modeloutindex].setWaterP(""+waterpricey);
//     				testResult[modeloutindex].setSurWD(""+baseSurWater);
//     				testResult[modeloutindex].setGWWD(""+baseUGWater);
//         			}
//         	     //处理循环变量
//     			/*	agrivalue[countyIndex]=agrivalueyy;
//     				indivalue[countyIndex]=indivalueyy;
//     				servalue[countyIndex]=servalueyy;
//     				baseNeedSurWater[countyIndex]=baseSurWater;
//     				baseNeedGWater[countyIndex]=baseUGWater;
//     				empr[countyIndex]=emppopr;
//     				agriarea[countyIndex]=agrareagq;
//     				indiarea[countyIndex]=indiareagq;
//     				serarea[countyIndex]=serareagq;
//     				waterP[countyIndex]=waterpricey;*/
//         		}
//         	}
//         	
//	    	String lineArr[]=new String[yearNum];
//
//	     	//开始算评分  //假设的测试
//		    for(i=0;i<outIndex;i++)
//		    {
//		    	/*testResult[i].setTotalscore("2");
//		    	testResult[i].setGoal1score("1");
//		    	testResult[i].setGoal2score("2");
//		    	testResult[i].setGoal3score("3");
//		    	testResult[i].setTotalindex("4.4");
//		    	testResult[i].setGoal1index("1.1");;
//		    	testResult[i].setGoal2index("2.2");
//		    	testResult[i].setGoal3index("3.3");*/
//		    	testResult[i].setTempset(""+TempChange);
//		    	testResult[i].setPreset(""+PreChangeR);
//		    	testResult[i].setCultiarearset(""+LandFarmR);
//		    	testResult[i].setCultitechrset(""+IARArg);
//		    	testResult[i].setDownstreamset(""+zhengyixia);
//		    }
//	     	//在服务器上运行的评分
//		    int index=0;
//		    for(int cIndex=0;cIndex<10;cIndex++)
//		    {
//			    for(i=0;i<yearNum;i++) //i 是行号   index是结果数组序号
//			    {
//			    	//index=cIndex*yearNum+i;	
//			    	index=i*10+cIndex;   //在总变量中的位置
//			    	lineArr[i]=testResult[index].getYear()+"\t";
//			    	if(indiInfoList.get(0).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getWaterProductivity()+"\t";
//			    	}
//			    	if(indiInfoList.get(1).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getWaterPressure()+"\t";
//			    	}
//			    	if(indiInfoList.get(2).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getSafeDrinkingWaterR()+"\t";
//			    	}
//			    	if(indiInfoList.get(7).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getGroundwaterMining()+"\t";
//			    	}
//			    	if(indiInfoList.get(9).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getForestcoverR()+"\t";
//			    	}
//			    	if(indiInfoList.get(10).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getBarecoverR()+"\t";
//			    	}
//			    	if(indiInfoList.get(11).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getMountainGreenCoverR()+"\t";
//			    	}
//			    	
//			    	if(indiInfoList.get(12).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getGdpPerCapita()+"\t";
//			    	}
//			    	if(indiInfoList.get(13).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getGdpPerCapitaEmployed()+"\t";
//			    	}
//			    	if(indiInfoList.get(17).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getUrbanR()+"\t";
//			    	}
//			    	if(indiInfoList.get(19).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getWaterProductivityAgri()+"\t";
//			    	}
//			    	if(indiInfoList.get(20).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getWaterUseEffiAgri()+"\t";
//			    	}
//			    	if(indiInfoList.get(22).getNeed())
//			    	{
//			    		lineArr[i]=lineArr[i]+testResult[index].getAreaCrop()+"\t";
//			    	}
//			    	lineArr[i]=lineArr[i].substring(0,lineArr[i].length()-1);//去掉最后一个 \t符号
//			    }//提取完了一个县的
//			    //测试写文件
//			    String outArr[]=null;
//			    String score[]=null;
//			    ///////////////////////运行 评价模型  python的代码   只能在服务器上测试！！！/////////////////////////////
//			    String msg = new String();
//				String fileName1 = new String();
//				String fileNameGN = new String();
//				String filePy = new String();
//				String exePy = new String();
//														
//				fileName1 = "/opt/evalmodeltest/evalmodel20180622/datacal.txt";
//	    		fileNameGN = "/opt/evalmodeltest/evalmodel20180622/goals_number.txt";
//	    		filePy = "/opt/evalmodeltest/evalmodel20180622/evalmodel_objective.py";
//	    		exePy = "/usr/bin/python";
//	    		
//				//解析传入参数, 写入参数文件
//			    BufferedWriter bufferedWriter = null;
//			    BufferedWriter bufferedWriterGN = null;
//			    File f = new File(fileName1);
//				File fGN = new File(fileNameGN);
//				try{
//					if(!f.exists()){
//						f.createNewFile();
//					}
//					if(!fGN.exists()){
//						fGN.createNewFile();
//					}
//					if(!wf.exists()){
//						wf.createNewFile();
//					}
//					bufferedWriterGN = new BufferedWriter(new FileWriter(fGN, false));
//					bufferedWriterGN.write(numStr);
//					bufferedWriterGN.newLine();
//				    bufferedWriter = new BufferedWriter(new FileWriter(f,false));
//				    bufferedWriter.write(firstline);
//			    	bufferedWriter.newLine(); 
//			    	for(i=0;i<yearNum-1;i++)
//			    	{
//			    		bufferedWriter.write(lineArr[i]);
//				    	bufferedWriter.newLine(); 
//			    	}
//			    	bufferedWriter.write(lineArr[i]);
//		        }
//				catch (FileNotFoundException ex) {
//				    ex.printStackTrace();
//				    return "写评价输入文件出错-文件不存在";
//				} 
//				catch (IOException ex) {
//					ex.printStackTrace();
//					return "写评价输入文件出错";
//				} 
//				finally {
//				    //Close the bufferWritter
//				    try {
//				        if (bufferedWriter != null) {
//				        	bufferedWriter.flush();
//				        	bufferedWriter.close();
//				        }
//				        if (bufferedWriterGN != null) {
//				        	bufferedWriterGN.flush();
//				        	bufferedWriterGN.close();
//				        }
//				    } 
//				    catch (IOException ex) {
//				        ex.printStackTrace();
//				        return "关闭文件出错";
//				    }
//			    }
//				msg += "write input data successfully!";
//				//运行py模型
//				Runtime rt = Runtime.getRuntime();
//				String[] cmds = new String[]{exePy, filePy, fileName1};
//		        Process p;  
//		        StringBuilder sb = new StringBuilder();    
//		        try    
//		        {    
//		        	//执行py
//		        	p = rt.exec(cmds);
//		        	try {
//		        		p.waitFor();
//		        	} catch (InterruptedException intexc) {
//		        		msg += "Interrupted Exception on waitFor: " + intexc.getMessage();
//		        		System.out.println("Interrupted Exception on waitFor: " + intexc.getMessage());
//		        		return "1执行python程序出错"+msg;
//		        	}
//		            //取得命令结果的输出流    
//		             InputStream fis=p.getInputStream();    
//		            //用一个读输出流类去读    
//		             InputStreamReader isr=new InputStreamReader(fis);    
//		            //用缓冲器读行    
//		             BufferedReader br=new BufferedReader(isr);    
//		             String line1=null;    
//		            //直到读完为止    
//		    		if( System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1 ) {
//		                sb.append("Flagtotalclass= [ 2.  2.  3.  3.  3.  3.  2.  3.  3.  2.]");
//		                sb.append("Flaggoal1class= [ 2.  2.  3.  3.  3.  3.  2.  3.  3.  2.]");
//		                sb.append("Flaggoal2class= [ 3.  2.  3.  2.  2.  2.  3.  2.  3.  3.]");
//		                sb.append("Flaggoal3class= [ 2.  2.  3.  2.  2.  2.  2.  2.  3.  3.]");
//		            }else{
//		                while((line1=br.readLine())!=null)    
//		                {    
//		                	sb.append(line1);
//		                }
//		            } 
//		        }
//		        catch (IOException e)    
//		        {    
//		        	msg  += e.getMessage();
//		            e.printStackTrace();    
//		            return "2执行python程序出错"+msg;
//		        }
//		        msg += "  run py done!";
//		        System.out.println(msg);    
//
//		    
//			        if(!(sb.toString().contains("[") && sb.toString().contains("]")))
//			        {
//			        	return ":输出命令窗口并未包含[]"+sb.toString();
//			        }
//			        try {
//				    outArr=sb.toString().split("]");
//				    
//					for(i=0;i<4;i++)//前四个是index
//					{
//						outArr[i]=outArr[i].replaceAll(" +"," ");
//						outArr[i]=outArr[i].substring(outArr[i].indexOf("[")+1, outArr[i].length());
//						if(outArr[i].substring(0, 1).equals(" "))
//						{
//							outArr[i]=outArr[i].substring(1, outArr[i].length());
//						}
//				    	score=outArr[i].split(" ");
//				    	for(j=0;j<yearNum;j++) //现在结果只有 yearNum列
//				    	{
//				    		index=j*10+cIndex;
//				    		if(i==0)
//				    		{
//				    			testResult[index].setGoal1index(score[j]);
//				    		}
//				    		else if(i==1)
//				    		{
//				    			testResult[index].setGoal2index(score[j]);
//				    		}
//				    		else if(i==2)
//				    		{
//				    			testResult[index].setGoal3index(score[j]);
//				    		}
//				    		else if(i==3)
//				    		{
//				    			testResult[index].setTotalindex(score[j]);
//				    		}
//				    	}
//					}
//				    
//					    for(i=4;i<8;i++)//后四个是grade
//					    {
//					    	outArr[i] = outArr[i].replace(" ", "");
//					    	score=outArr[i].split("\\.");// 取得 .号分开的多个子字符串
//					    	score[0]=score[0].substring(score[0].length()-1);//第一个字串 形如Flagtotalclass=[2 取最后一个字符即可
//					    	for(j=0;j<yearNum;j++)
//					    	{
//					    		index=j*10+cIndex;
//					    		if(i==4)
//					    		{
//					    			testResult[index].setTotalscore(score[j]);
//					    		}
//					    		else if(i==5)
//					    		{
//					    			testResult[index].setGoal1score(score[j]);
//					    		}
//					    		else if(i==6)
//					    		{
//					    			testResult[index].setGoal2score(score[j]);
//					    		}
//					    		else if(i==7)
//					    		{
//					    			testResult[index].setGoal3score(score[j]);
//					    		}
//					    	}
//					    }
//			        }
//			        catch(Exception e)
//			        {
//			 			return e.getMessage()+"长度"+outArr.length+"输出"+sb.toString();
//			        }	
//		    }//end of for 
//		    //模型，指标，评分都已经计算完成
//		    for(i=0;i<outIndex;i++) //存数据库啦
//		    {
//		    	modelFunctionService.insertTestManyOutput(testResult[i]);
//		    }
//         }}}}}
//        //终于计算完啦，有没有很激动，现在要把flag置0
//         modelFunctionService.setTestFlag("0","success:"+projectId);
//    	return "success";
//    	}
//    	catch(Exception e)
//    	{
//    		 modelFunctionService.setTestFlag("0","发生异常:"+e.getMessage());
//    		 return "error";
//    	}
//     }
//    
//    //响应用户按钮    开始计算模型
//    @ResponseBody
//    @RequestMapping(value = "startProxyModel", method = RequestMethod.POST)
//    public String startModel(String projectId,Boolean economicFrist)
//     {
//    	//System.out.println("进入函数");
//    	//projectId="98f16387-02b8-4aa5-b57d-481108a1e660";
//    	//projectId="98f16387-02b8-4aa5-b57d-481108a1e660";
//    	//Boolean term=false;
//        String modelPath="/home/software/modelfile/";
//    	//String modelPath="E:\\SVM\\modelfile\\";
//    	//DecimalFormat df = new DecimalFormat("#.00");  
//     	//声明所有输入输出变量
//    	//projectId="e776191c-8634-42c9-8824-19531b7474a5";
//     	double PreChangeR; //降雨增加比例 单位：%                1-x1
//     	double TempChange; //温度变化 单位：℃                                                   1-x2
//     	double LandForestR; //土地利用变化-林地 单位：%
//     	double LandGrassR; //土地利用变化-草地 单位：%
//     	double LandBareR; //土地利用变化-裸地 单位：%
//     	double LandCityR; //土地利用变化-城镇 单位：%
//     	double IARArg; //产业技术进步率-农业 单位：%
//    	double IARInd; //产业技术进步率-工业 单位：%
//    	double IARSer; //产业技术进步率-服务业 单位：%
//    	double LandFarmR; //耕地变化率 单位：%
//     	double dibiaoR_year;
//     	double dixiaR_year;
//     	double LandFarmR_year;
//    	//经济模型的输入限制
//    	double jinbumin=0.000001;
//    	double jinbumax=10;//进步率限值
//    	//double []dibiaomin= new double[]{-15,-10,-9,-25,-25,-30,-10,-10,-10,-10}; //地表供水变化率%
//    	//double []dibiaomax= new double[]{20,13,10,25,25,30,10,10,10,20};
//    	
//    	//double []dixiamin= new double[] {-20,-20,-30,-10,-10,-2,-10,-10,-10,-20};//地下供水变化率%
//    	//double []dixiamax= new double[] {20,20,50,10,10,2,10,10,10,20};
//    	double []dibiaomin= new double[]{-20,-20,-20,-20,-20,-20,-20,-20,-20,-20,-20}; //地表供水变化率%
//    	double []dibiaomax= new double[]{20,20,20,20,20,20,20,20,20,20,20};
//    	
//    	double []dixiamin= new double[] {-20,-20,-20,-20,-20,-20,-20,-20,-20,-20,-20};//地下供水变化率%
//    	double []dixiamax= new double[] {20,20,20,20,20,20,20,20,20,20,20};//20181121根据刘天龙重新取值范围
//     	int i;
//    	/*
//    	620702	甘州区       1
//    	620723	临泽县  2
//    	620724	高台县3
//    	620725	山丹县4
//    	620722	民乐县5
//    	620721	肃南县6
//    	620200	嘉峪关市7
//    	620902	肃州区8
//    	620921	金塔县9
//    	152923	额济纳旗10
//    	 * 
//    	 */
//     	
//     	//获取所有的网页情景    
//     	//网页情景返回应该是按区县排序 
//     	//查找
//     	ClimatePara climate;
//     	LandPara land;
//     	WaterPara water;
//     	EcoPara eco; 	
//     	IndicatorPara indiPara;
//     	ModelOutput[] modelOutputArr;	
//     	String username = userservice.getCurrentUserId();
//     	Project myPro=getWebServiceParaService.getProjectById(username,projectId);
//     	if(myPro==null)
// 		{
// 			return "项目信息不存在";
// 		}
//     	
//         int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//         int timeEnd = Integer.parseInt(myPro.getGoalYear());
//        
//         int yearNum= timeEnd-timeStart+1;
//         int yearIndex;//年份循环变量
//         
//         //System.out.println(myPro.getBaseYear()+","+myPro.getGoalYear());
//         
//         String watershedId=myPro.getWatershedId();
//         Map<String,Object> map=new HashMap<String,Object>(); 
//         
//         climate=modelFunctionService.getClimateParaByCounty(projectId, "1");//上游的区县ID是1
//         if(climate==null)
//         {
//         	return "上游地区的气候情景不存在";
//         }
//         
//       
//         
//          
//         PreChangeR=Float.parseFloat(climate.getPreChangeR()); //降雨增加比例 单位：%
//     	TempChange=Float.parseFloat(climate.getTempChange()); //温度变化 单位：℃
//     	
//         
//         double arr_FlowYLX[]=new double[yearNum];//莺落峡所有年份流量输出
//         double arr_FlowOther[]=new double[yearNum];//其他河流流量输出
//         //方程样式FlowYLX(Preratio_up,Temratio_up);5*Preratio_up*Temratio_up*500000
//         double PreChangeR_year;//%
//         double TempChange_year;//摄氏度
//         double LandForestR_year;
//         double LandGrassR_year;
//         double LandBareR_year;
//         double LandCityR_year; 
//         double precylx,precother,airtylx,airtother; 
//         
//         //限定温度（摄氏度）和降水（%）范围
//         //降雨(%), [-0.15, 0.15]
//         //温度(C), [0, 2]
//         if(PreChangeR<-15)
//         {
//        	 PreChangeR=-15;
//         }
//         else if(PreChangeR>15)
//         {
//        	 PreChangeR=15;
//         }
//         if(TempChange<0.000001)
//         {
//        	 TempChange=0;
//         }
//         else if(TempChange>2)
//         {
//        	 TempChange=2;
//         }
//         PreChangeR_year=PreChangeR/(yearNum)/100;
//         TempChange_year=TempChange/yearNum;
//         double pre,temper;
//     	for(yearIndex=1;yearIndex<yearNum;yearIndex++)//按年份开始计算上游模型了
//     	{
//     		//黑河上游2001至2012年年平均气温（K）在干流区和非干流区分别为：270.24，271.60，拟合公式适用范围为【269K, 275K】
//     		//年平均降水（mm）在干流区和非干流区分别为669.15，814.35，拟合公式适用范围为 [407,1000]
//     		//pre=Math.pow(1+PreChangeR_year,1+yearIndex);
//     		//pre=PreChangeR/100;
//     		//precylx=669.15*Math.pow(1+pre,1+yearIndex);//鹰落峡降水mm 
//     		pre=1+PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     		precylx=669.15*pre;//鹰落峡降水mm
//     		if(precylx<407)
//     		{
//     			precylx=407;
//     		}  
//     		else if(precylx>1000)
//     		{
//     			precylx=1000;
//     		}
//     		//precother=814.35*Math.pow(1+pre,1+yearIndex);//鹰落峡降水mm 
//     		precother=814.35*pre;//鹰落峡降水mm 
//     		if(precother<407)
//     		{
//     			precother=407;
//     		}  
//     		else if(precother>1000)
//     		{
//     			precother=1000;
//     		}
//     		//1摄氏度(℃)=274.15开尔文(K) 不对，应该摄氏度和开尔文温度的差值是一样的
//     		//temper=TempChange_year*(1+yearIndex);
//     		temper=TempChange*yearIndex;
//     		airtylx=270.24+temper;
//     		if(airtylx<269)
//     		{
//     			airtylx=269;
//     		}
//     		else if(airtylx>275)
//     		{
//     			airtylx=275;
//     		}
//     		airtother=271.60+temper;
//     		if(airtother<269)
//     		{
//     			airtother=269;
//     		}
//     		else if(airtother>275)
//     		{
//     			airtother=275;
//     		}
//     		
//     		//立方米-》亿立方米
//     		arr_FlowYLX[yearIndex]=(177.825085*precylx*precylx
//     		       + 6988908.56*airtylx*airtylx
//     		       -77217.5416*precylx*airtylx
//     		       +26500711*precylx-3.84373553e9*airtylx + 5.26858754e11)/1e8;
//     		arr_FlowOther[yearIndex]=(-3.94249672e2 *precother*precother
//     		       -1.62845167e7*airtother*airtother
//     		       +1.27406840e6*precother*airtother
//     		       -3.41549958e8*precother
//     		       +7.82500648e9*airtother -9.25319379e+11)/1e8;
//     	}//此时已经计算完上游模型，结果存在arr_Out_FlowYLX arr_Out_FlowOther 
//     	Map<String,Object> allClimate=modelFunctionService.getClimateParaMap(projectId);
//     	if(allClimate.size()<14)
//     	{
//     		return "气候情景参数不全";
//     	}
//     	Map<String,Object> allLand=modelFunctionService.getLandParaMap(projectId);
//     	if(allLand.size()<14)
//     	{
//     		return "土地利用情景参数不全";
//     	}
//     	Map<String,Object> allEco=modelFunctionService.getEcoParaMap(projectId);
//     	if(allEco.size()<14)
//     	{
//     		return "社会经济情景参数不全";
//     	}
//     	Map<String,Object> allWater=modelFunctionService.getWaterParaMap(projectId);
//     	if(allWater.size()<14)
//     	{
//     		return "水资源情景参数不全";
//     	}
//     	Map<String,Object> indiparaMap=modelFunctionService.getIndiParabyWatershedId(watershedId);
//     	if(indiparaMap.size()<10)
//     	{
//     		return "基础年参数不全";
//     	}
//     	int j=0,k;
//     	int countyIndex;
//     	ClimatePara climateArr[]=new ClimatePara[11];
//     	climateArr[0]=(ClimatePara)(allClimate.get("620702"));
//     	climateArr[1]=(ClimatePara)(allClimate.get("620723"));
//     	climateArr[2]=(ClimatePara)(allClimate.get("620724"));
//     	climateArr[3]=(ClimatePara)(allClimate.get("620725"));
//     	climateArr[4]=(ClimatePara)(allClimate.get("620722"));
//     	climateArr[5]=(ClimatePara)(allClimate.get("620721"));
//     	climateArr[6]=(ClimatePara)(allClimate.get("620200"));
//     	climateArr[7]=(ClimatePara)(allClimate.get("620902"));
//     	climateArr[8]=(ClimatePara)(allClimate.get("620921"));
//     	climateArr[9]=(ClimatePara)(allClimate.get("152923"));
//     	climateArr[10]=(ClimatePara)(allClimate.get("632222")); //祁连县
//     	/*中下游模型按下列区县顺序
//     	620702	甘州区      
//     	620723	临泽县
//     	620724	高台县
//     	620725	山丹县
//     	620722	民乐县
//     	620721	肃南县
//     	620200	嘉峪关市
//     	620902	肃州区
//     	620921	金塔县
//     	152923	额济纳旗*/
//     	//模型输出数组
//     	modelOutputArr=new ModelOutput[yearNum*10];//只计算10个区县
//     	for(i=0;i<yearNum*10;i++)
//     	{
//     		modelOutputArr[i]=new ModelOutput();
//     	}
//     	int outIndex=0;
//     	int yearInt; 
//     	String countyId;	
// 		double v;
// 		double A[]=new double[6];
// 		double ht[]=new double[22];
// 		
// 		double AA[][]=new double[11][6];//用来组合经济模型输入变量的
//        for(i=0;i<11;i++)
//        {
//        	AA[i]=new double[6];
//        }
// 		double SurSup1,SurSup2;//第一年数据，第二年数据
// 		double GWSup1,GWSup2;
// 		double IARArg_year,IARInd_year,IARSer_year,landFarmR_year;
// 		double value[]=new double[10];
// 		
// 		//基础年的数据赋值
// 		for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    先算经济模型
//		{
//				countyId=climateArr[countyIndex].getCountyId();
//				//modelOutputArr[countyIndex]=new ModelOutput();
//				indiPara=(IndicatorPara)(indiparaMap.get(countyId));
//				modelOutputArr[countyIndex].setArgValue(indiPara.getAgrivalue());
//				modelOutputArr[countyIndex].setArgValueR("0");
//				modelOutputArr[countyIndex].setCountyId(countyId);
//				modelOutputArr[countyIndex].setCropET(indiPara.getCropET());
//				modelOutputArr[countyIndex].setEmp(indiPara.getEmpr());
//				modelOutputArr[countyIndex].setEmpR("0");
//				modelOutputArr[countyIndex].setFlowOther(indiPara.getFlowOther());
//				modelOutputArr[countyIndex].setFlowYLX(indiPara.getFlowYLX());
//				modelOutputArr[countyIndex].setGWSup(indiPara.getGWSup());
//				modelOutputArr[countyIndex].setGWWD(""+Float.parseFloat(indiPara.getBaseNeedGWater())/Float.parseFloat(indiPara.getEcopro()));
//				modelOutputArr[countyIndex].setGWWDR("0");
//				modelOutputArr[countyIndex].setIndValue(indiPara.getIndivalue());
//				modelOutputArr[countyIndex].setIndValueR("0");
//				modelOutputArr[countyIndex].setLandCI(indiPara.getIndiArea());
//				modelOutputArr[countyIndex].setLandCIR("0");
//				modelOutputArr[countyIndex].setLandSer(indiPara.getSerArea());
//				modelOutputArr[countyIndex].setLandSerR("0");
//				modelOutputArr[countyIndex].setLandFarm(indiPara.getFarmArea());
//				modelOutputArr[countyIndex].setLandFarmR("0");
//				modelOutputArr[countyIndex].setProjectID(projectId);
//				modelOutputArr[countyIndex].setSerValue(indiPara.getServalue());
//				modelOutputArr[countyIndex].setSerValueR("0");
//				modelOutputArr[countyIndex].setSurSup(indiPara.getSurSup());
//				modelOutputArr[countyIndex].setSurWD(""+Float.parseFloat(indiPara.getBaseNeedSurWater())/Float.parseFloat(indiPara.getEcopro()));
//				modelOutputArr[countyIndex].setSurWDR("0");
//				modelOutputArr[countyIndex].setWaterP(indiPara.getWaterPrice());
//				modelOutputArr[countyIndex].setWaterPR("0");
//				//modelOutputArr[countyIndex].setWetlandArea("");
//				modelOutputArr[countyIndex].setYear(myPro.getBaseYear());
//		}
//     
//     		IModelEconomic IModelEconomicService= new IModelEconomicImpl().getIModelEconomicImplPort();
//     		String ecooutput;
//     		String ecooutputArr[];
//     		String countyName[]=new String[] {"GanZhou","LinZe","GaoTai","ShanDan","MinLe","SuNan","JiaYuGuan","SuZhou","JinTai","EJNAQ"};
//         	String fileName;
//         	//读文件，获取中下游模型的a和b
//         	//读文件，获取X的max和min
//         	double a[]=new double[30];
//     		double b[]=new double[30];
//     		try
//     		{
//     			BufferedReader abr=new BufferedReader(new FileReader(modelPath+"a.txt"));
//     			BufferedReader bbr=new BufferedReader(new FileReader(modelPath+"b.txt"));
//     			for(i=0;i<30;i++)
//     			{
//     				a[i]=Double.valueOf(abr.readLine()).doubleValue();
//     				b[i]=Double.valueOf(bbr.readLine()).doubleValue();
//     			}
//     			abr.close();
//     			bbr.close();
//     		}
//     		catch(Exception e)
//     		{
//     			System.out.println(e.toString());
//     			return "打开中下游生态水文模型系数a,b文件错误";
//     		}
//     		double max[]=new double[25];
//     		double min[]=new double[25];
//     		try
//     		{
//     			BufferedReader abr=new BufferedReader(new FileReader(modelPath+"minmax.txt"));
//     			for(i=0;i<25;i++)
//     			{
//     				min[i]=Double.valueOf(abr.readLine()).doubleValue();
//     				max[i]=Double.valueOf(abr.readLine()).doubleValue();
//     			}
//     			abr.close();
//     		}
//     		catch(Exception e)
//     		{
//     			System.out.println(e.toString());
//     			return "打开中下游生态水文模型系数输入限值文件错误";
//     		}
//     		
//     		svm_model svmmodel[]=new svm_model[30];
//     		
//     		int modelindex;
//     		j=0;
//     		for(i=1;i<=10;i++) //读取30个模型
//     		{
//     			for(k=1;k<=3;k++)
//     			{
//     				modelindex=i*10+k;
//     				fileName=modelPath+"model"+modelindex+".txt";
//     				try
//     				{
//     					svmmodel[j] = svm.svm_load_model(fileName);
//     					if (svmmodel[j]== null)
//     					{
//     						System.err.print("can't open model file "+fileName);
//     						return "打开SVM模型文件错误 "+fileName;
//     					}
//     					j++;
//     				}
//     				catch(Exception e)
//     				{
//     					System.out.println(e.toString());
//     					return "打开SVM模型文件错误  "+fileName;
//     				}
//     			}
//     		}
//     		svm_node[]x=new svm_node[25];
//     		double input[]=new double[25];
//     		//定制SVM的输入X
//     		for(i=0;i<25;i++)
//     		{
//     			x[i] = new svm_node();
//     			x[i].index=i+1;
//     		}
//     		for(i=0;i<10;i++)//非农业用水  一直不变，从网页情景得来
//     		{
//     			water=(WaterPara)(allWater.get(climateArr[i].getCountyId()));	
//     			input[5+i]=Double.parseDouble(water.getSupWater());
//     			if(input[5+i]>=min[5+i] && input[5+i]<=max[5+i])
//     			{
//     				x[5+i].value=(input[5+i]-min[5+i])/(max[5+i]-min[5+i]);
//     			}
//     			else
//     			{
//     				if(input[5+i]<min[5+i])
//     				{
//     					x[5+i].value=0;
//     				}
//     				else if(input[5+i]>max[5+i])
//     				{
//     					x[5+i].value=1;
//     				}
//     			}
//     		}
//     		//economicFrist=false;//先算生态水文
//     		String paraString;
//     		for(yearIndex=1;yearIndex<yearNum;yearIndex++)//按年份开始计算中下游模型和经济模型了
//     		{
//     			yearInt=timeStart+yearIndex;
//     			if(economicFrist)
//     			{
//     				
//     				for(countyIndex=0;countyIndex<11;countyIndex++)//10个区县    先算经济模型
//     				{
//     					countyId=climateArr[countyIndex].getCountyId();
//     					water=(WaterPara)allWater.get(countyId);
//     					indiPara=(IndicatorPara)indiparaMap.get(countyId);
//    		     		eco=(EcoPara)allEco.get(countyId);
//    		     		IARArg=Float.parseFloat(eco.getIARArg());
//    		     		IARInd=Float.parseFloat(eco.getIARInd());
//    		     		IARSer=Float.parseFloat(eco.getIARSer());
//    		     		IARArg_year=IARArg/yearNum/100;
//    		     		IARInd_year=IARInd/yearNum/100;
//    		     		IARSer_year=IARSer/yearNum/100;
//    		     		dibiaoR_year=Float.parseFloat(water.getSurSup())/yearNum/100;
//    		     		dixiaR_year=Float.parseFloat(water.getGWSup())/yearNum/100;
//    		     		/*
//    		     		地表供水量变化率SurSupR
//    		     		地下供水量变化率GWSupR
//    		     		农业产业技术进步率
//    		     		工业产业技术进步率
//    		     		服务业产业技术进步率*/
//    		     		if(countyIndex!=10)//不是祁连县
//    		     		{
//    		     			if(yearIndex==1)
//        		     		{
//        		     			AA[countyIndex][1]=dibiaoR_year*yearIndex*100;
//        		     			AA[countyIndex][2]=dixiaR_year*yearIndex*100;
//        		     			
//        		     		}
//        		     		else if(yearIndex==2)//第一年减基础年     					
//        		     		{
//        		     			SurSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getSurSup())*Float.parseFloat(indiPara.getEcopro());
//        		     			SurSup1=Double.parseDouble(indiPara.getBaseNeedSurWater());    		     			
//        		     			GWSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getGWSup())*Float.parseFloat(indiPara.getEcopro());
//        		     			GWSup1=Double.parseDouble(indiPara.getBaseNeedGWater());
//        		     			AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;
//        		     			AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;	
//        		     		}
//        		     		else
//        		     		{
//        		     			SurSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getSurSup());
//        		     			GWSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getGWSup());
//        		     			SurSup1=Double.parseDouble(modelOutputArr[(yearIndex-2)*10+countyIndex].getSurSup());
//        		     			GWSup1=Double.parseDouble(modelOutputArr[(yearIndex-2)*10+countyIndex].getGWSup());	
//        		     			AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;
//        		     			AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;
//        		     		}
//    		     		}
//    		     		else//是祁连县
//    		     		{
//    		     			AA[countyIndex][1]=dibiaoR_year*yearIndex*100;
//    		     			AA[countyIndex][2]=dixiaR_year*yearIndex*100;
//    		     		}
//    		     		AA[countyIndex][3]=IARArg_year*yearIndex*100;
//    		     		AA[countyIndex][4]=IARInd_year*yearIndex*100;
//    		     		AA[countyIndex][5]=IARSer_year*yearIndex*100;
//    		     		
//    		     		if(AA[countyIndex][1]<dibiaomin[countyIndex])
//    		     		{
//    		     			AA[countyIndex][1]=dibiaomin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][1]>dibiaomax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][1]=dibiaomax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][2]<dixiamin[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][2]>dixiamax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][3]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][3]=0;
//    		     		}
//    		     		else if(AA[countyIndex][3]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][3]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][4]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][4]=0;
//    		     		}
//    		     		else if(AA[countyIndex][4]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][4]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][5]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][5]=0;
//    		     		}
//    		     		else if(AA[countyIndex][5]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][5]=jinbumax;
//    		     		}    
//    		     		AA[countyIndex][3]=-1*AA[countyIndex][3];
//    		     		AA[countyIndex][4]=-1*AA[countyIndex][4];
//    		     		AA[countyIndex][5]=-1*AA[countyIndex][5];
//    		             /*
//    		             1.农业总产值变化率
//    		             2.工业总产值变化率
//    		             3.服务业总产值变化率
//    		             4.耕地变化率
//    		             5.工业用地变化率
//    		             6.服务业用地变化率
//    		             7.水价变化率
//    		             8.就业变化率
//    		             9.地表需水量变化率
//    		             10.地下需水量变化率*/
//     				}
//     				paraString="";		
//     				for(j=1;j<6;j++)
//     				{
//     					for(i=0;i<11;i++)
//     					{
//     						paraString=paraString+AA[i][j]+",";
//     					}
//     				}
//     				//组合完了，现在才开始调用经济模型
//     				//System.out.println("参数是我："+paraString);
//     				ecooutput=IModelEconomicService.start(projectId,paraString,"","","","","");
//		     		//IModelEconomicService.start("112233","GanZhou","20","10","10","5","8");
//		     		ecooutputArr=ecooutput.split(",");
//		     		if(ecooutputArr.length!=100)
//		     		{
//		     			return ecooutput+"  len:"+ecooutputArr.length;
//		     		}
//		     		//System.out.println(ecooutput);
//		     		//提取结果
//		     		for(countyIndex=0;countyIndex<10;countyIndex++)
//		     		{
//		     			countyId=climateArr[countyIndex].getCountyId();
//		     			modelOutputArr[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setProjectID(projectId);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setArgValueR(ecooutputArr[countyIndex*10]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setIndValueR(ecooutputArr[countyIndex*10+1]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSerValueR(ecooutputArr[countyIndex*10+2]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandFarmR(ecooutputArr[countyIndex*10+3]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandCIR(ecooutputArr[countyIndex*10+4]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandSerR(ecooutputArr[countyIndex*10+5]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setWaterPR(ecooutputArr[countyIndex*10+6]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setEmpR(ecooutputArr[countyIndex*10+7]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSurWDR(ecooutputArr[countyIndex*10+8]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setGWWDR(ecooutputArr[countyIndex*10+9]);//~~~~~~  
//		     		}
//		     		
//     				
//     				input[2]=arr_FlowYLX[yearIndex];// 莺落峡来流(亿m3/y)
//    	        	input[3]=arr_FlowOther[yearIndex];//其他上游来流(亿m3/y)
//    	        	water=(WaterPara)(allWater.get("2"));//全流域改为中下游
//    	        	input[4]=Double.parseDouble(water.getFlowDown());
//    	        	for(i=0;i<10;i++)//因为先算的  经济模型，所以直接取今年的
//    	        		{
//    	        			input[15+i]=Double.parseDouble(modelOutputArr[yearIndex*10+i].getLandFarmR())/100;
//    	        			if(input[15+i]>=min[15+i] && input[15+i]<=max[15+i])
//    	        			{
//    	        				x[15+i].value=(input[15+i]-min[15+i])/(max[15+i]-min[15+i]);
//    	        			}
//    	        			else
//    	        			{
//    	        				if(input[15+i]<min[15+i])
//    	        				{
//    	        					x[15+i].value=0;
//    	        				}
//    	        				else if(input[15+i]>max[15+i])
//    	        				{
//    	        					x[15+i].value=1;
//    	        				}
//    	        			}
//    	        		}
//     				for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    再算中下游水文模型  
//     				{
//     					countyId=climateArr[countyIndex].getCountyId();
//     					//再算中下游水文模型
//    		            PreChangeR=Float.parseFloat(climateArr[countyIndex].getPreChangeR()); //降雨增加比例 单位：%
//     			    	TempChange=Float.parseFloat(climateArr[countyIndex].getTempChange()); //温度变化 单位：℃
//     			    	
//     			    	PreChangeR_year=PreChangeR/yearNum/100;
//     			    	TempChange_year=TempChange/yearNum;
//     			    	
//     			    	input[0]=PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     			    	input[1]=TempChange*yearIndex;
//     	        		//组合模型输出
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowYLX(""+arr_FlowYLX[yearIndex]);//~~~~~~
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowOther(""+arr_FlowOther[yearIndex]);//~~~~~~
//     	        		for(i=0;i<5;i++)//前五个输入
//     	        		{
//     	        			if(input[i]>=min[i] && input[i]<=max[i])
//     	        			{
//     	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//     	        			}
//     	        			else
//     	        			{
//     	        				if(input[i]<min[i])
//     	        				{
//     	        					x[i].value=0;
//     	        				}
//     	        				else if(input[i]>max[i])
//     	        				{
//     	        					x[i].value=1;
//     	        				}
//     	        			}
//     	        		}  		        		
//     	        		
//     	        		//至此为止，SVM的输入X已经组合好了！！！
//     	        		//开始计算SVM模型
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3],x);
//     	        		v=v*a[countyIndex*3]+b[countyIndex*3];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setSurSup(""+v);//地表水引用量(万吨/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+1],x);
//     	        		v=v*a[countyIndex*3+1]+b[countyIndex*3+1];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setGWSup(""+v);//地下水抽取量(万吨/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+2],x);
//     	        		v=v*a[countyIndex*3+2]+b[countyIndex*3+2];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setCropET(""+v);//耕地面积ET量(万吨/年)//~~~~~~ 
//    	 			}
//     			}
//     			else//生态水文先算     默认！！
//     			{
//     				input[2]=arr_FlowYLX[yearIndex];// 莺落峡来流(亿m3/y)
//     				input[3]=arr_FlowOther[yearIndex];//其他上游来流(亿m3/y)
//     				water=(WaterPara)(allWater.get("2"));
//    	        	input[4]=Double.parseDouble(water.getFlowDown());
//    	        	
//    	        		if(yearIndex==1) //第一年的耕地变化率，从网页得来
//    	        		{
//    	        			for(i=0;i<10;i++)
//    	        			{ 
//    	        				land=(LandPara)(allLand.get(climateArr[i].getCountyId()));
//    	        				LandFarmR=Double.parseDouble(land.getLandFarmR());
//    	        				landFarmR_year=LandFarmR/yearNum/100;  	        	
//    	        				input[15+i]=landFarmR_year*yearIndex;
//    	        			}
//    	        		}
//    	        		else//从第二年起，就从上一年的经济模型的输出里面取得
//    	        		{
//    	        			for(i=0;i<10;i++)
//    	        			{
//    	        				input[15+i]=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+i].getLandFarmR())/100;
//    	        			}
//    	        		}
//    	        		for(i=15;i<25;i++)//后10个输入
//    	        		{
//    	        			if(input[i]>=min[i] && input[i]<=max[i])
//    	        			{
//    	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//    	        			}
//    	        			else
//    	        			{
//    	        				if(input[i]<min[i])
//    	        				{
//    	        					x[i].value=0;
//    	        				}
//    	        				else if(input[i]>max[i])
//    	        				{
//    	        					x[i].value=1;
//    	        				}
//    	        			}
//    	        		}
//     				for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    先算生态水文模型
//     				{
//     					countyId=climateArr[countyIndex].getCountyId();
//     					//modelOutputArr[yearIndex*10+countyIndex]=new ModelOutput();
//     					modelOutputArr[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//     					modelOutputArr[yearIndex*10+countyIndex].setProjectID(projectId);//~~~~~
//     					
//     					PreChangeR=Float.parseFloat(climateArr[countyIndex].getPreChangeR()); //降雨增加比例 单位：%
//     			    	TempChange=Float.parseFloat(climateArr[countyIndex].getTempChange()); //温度变化 单位：℃
//     			    	
//     			    	PreChangeR_year=PreChangeR/yearNum/100;
//     			    	TempChange_year=TempChange/yearNum;
//     			    	
//     			    	input[0]=PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     			    	input[1]=TempChange*yearIndex; 		
//     	        		//组合模型输出
//     	        		modelOutputArr[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~~
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowYLX(""+arr_FlowYLX[yearIndex]);//~~~~~~
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowOther(""+arr_FlowOther[yearIndex]);//~~~~~~
//     	        		for(i=0;i<5;i++)//前五个输入
//     	        		{
//     	        			if(input[i]>=min[i] && input[i]<=max[i])
//     	        			{
//     	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//     	        			}
//     	        			else
//     	        			{
//     	        				if(input[i]<min[i])
//     	        				{
//     	        					x[i].value=0;
//     	        				}
//     	        				else if(input[i]>max[i])
//     	        				{
//     	        					x[i].value=1;
//     	        				}
//     	        			}
//     	        		}
//     	        		//至此为止，SVM的输入X已经组合好了！！！
//     	        		//开始计算SVM模型	
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3],x);
//     	        		v=v*a[countyIndex*3]+b[countyIndex*3];
//     	        		v=v/10000;
//     	        		SurSup2=v;  //计算pcm要用
//     	        		modelOutputArr[yearIndex*10+countyIndex].setSurSup(""+v);//地表水引用量(亿立方米/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+1],x);
//     	        		v=v*a[countyIndex*3+1]+b[countyIndex*3+1];
//     	        		v=v/10000;
//     	        		GWSup2=v;//计算pcm要用
//     	        		modelOutputArr[yearIndex*10+countyIndex].setGWSup(""+v);//地下水抽取量(亿立方米/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+2],x);
//     	        		v=v*a[countyIndex*3+2]+b[countyIndex*3+2];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setCropET(""+v);//耕地面积ET量(亿立方米/年)//~~~~~~ 
//     	        		//再算经济模型
//     	        		if(yearIndex==1)//2013
//     	        		{
//     	        			indiPara=(IndicatorPara)(indiparaMap.get(countyId));
//     	        			SurSup1=Double.parseDouble(indiPara.getBaseNeedSurWater());
//     	        			GWSup1=Double.parseDouble(indiPara.getBaseNeedGWater());
//     	        			SurSup2=SurSup2*Float.parseFloat(indiPara.getEcopro());
//     	        			GWSup2=GWSup2*Float.parseFloat(indiPara.getEcopro());
//     	        		}
//     	        		else
//     	        		{
//     	        			SurSup1=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getSurSup());
//     	        			GWSup1=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getGWSup());
//     	        		}
//     	        		eco=(EcoPara)allEco.get(countyId);
//     	        		IARArg=Float.parseFloat(eco.getIARArg());
//     	        		IARInd=Float.parseFloat(eco.getIARInd());
//     	        		IARSer=Float.parseFloat(eco.getIARSer());
//     	        		IARArg_year=IARArg/yearNum/100;
//     	        		IARInd_year=IARInd/yearNum/100;
//     	        		IARSer_year=IARSer/yearNum/100;
//
//     	        		AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;//地表供水量变化率
//     	        		AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;//地下供水量变化率
//     	        		AA[countyIndex][3]=IARArg_year*yearIndex*100;
//     	        		AA[countyIndex][4]=IARInd_year*yearIndex*100;
//     	        		AA[countyIndex][5]=IARSer_year*yearIndex*100;
//     	        		if(AA[countyIndex][1]<dibiaomin[countyIndex])
//    		     		{
//     	        			AA[countyIndex][1]=dibiaomin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][1]>dibiaomax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][1]=dibiaomax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][2]<dixiamin[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][2]>dixiamax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][3]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][3]=0;
//    		     		}
//    		     		else if(AA[countyIndex][3]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][3]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][4]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][4]=0;
//    		     		}
//    		     		else if(AA[countyIndex][4]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][4]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][5]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][5]=0;
//    		     		}
//    		     		else if(AA[countyIndex][5]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][5]=jinbumax;
//    		     		}
//    		     		AA[countyIndex][3]=-1*AA[countyIndex][3];
//    		     		AA[countyIndex][4]=-1*AA[countyIndex][4];
//    		     		AA[countyIndex][5]=-1*AA[countyIndex][5];
//     				}//end of 10个区县   生态水文
//     				//再算经济模型
//     				//组合祁连县的量
// 					water=(WaterPara)allWater.get("632222");
// 					indiPara=(IndicatorPara)indiparaMap.get("632222");
//		     		eco=(EcoPara)allEco.get("632222");
//		     		IARArg=Float.parseFloat(eco.getIARArg());
//		     		IARInd=Float.parseFloat(eco.getIARInd());
//		     		IARSer=Float.parseFloat(eco.getIARSer());
//		     		IARArg_year=IARArg/yearNum/100;
//		     		IARInd_year=IARInd/yearNum/100;
//		     		IARSer_year=IARSer/yearNum/100;
//		     		dibiaoR_year=Float.parseFloat(water.getSurSup())/yearNum/100;
//		     		dixiaR_year=Float.parseFloat(water.getGWSup())/yearNum/100;
//
//		     		AA[10][1]=dibiaoR_year*yearIndex*100;
//		     		AA[10][2]=dixiaR_year*yearIndex*100;
//		     		AA[10][3]=IARArg_year*yearIndex*100;
//		     		AA[10][4]=IARInd_year*yearIndex*100;
//		     		AA[10][5]=IARSer_year*yearIndex*100;
//		     		
//		     		if(AA[10][1]<dibiaomin[10])
//		     		{
//		     			AA[10][1]=dibiaomin[10];
//		     		}
//		     		else if(AA[10][1]>dibiaomax[10])
//		     		{
//		     			AA[10][1]=dibiaomax[10];
//		     		}
//		     		if(AA[10][2]<dixiamin[10])
//		     		{
//		     			AA[10][2]=dixiamin[10];
//		     		}
//		     		else if(AA[10][2]>dixiamax[10])
//		     		{
//		     			AA[10][2]=dixiamax[10];
//		     		}
//		     		if(AA[10][3]<jinbumin)
//		     		{
//		     			AA[10][3]=0;
//		     		}
//		     		else if(AA[10][3]>jinbumax)
//		     		{
//		     			AA[10][3]=jinbumax;
//		     		}
//		     		if(AA[10][4]<jinbumin)
//		     		{
//		     			AA[10][4]=0;
//		     		}
//		     		else if(AA[10][4]>jinbumax)
//		     		{
//		     			AA[10][4]=jinbumax;
//		     		}
//		     		if(AA[10][5]<jinbumin)
//		     		{
//		     			AA[10][5]=0;
//		     		}
//		     		else if(AA[10][5]>jinbumax)
//		     		{
//		     			AA[10][5]=jinbumax;
//		     		}    
//		     		AA[10][3]=-1*AA[10][3];
//		     		AA[10][4]=-1*AA[10][4];
//		     		AA[10][5]=-1*AA[10][5];
//     				
//		     		paraString="";
//		     		for(j=1;j<6;j++)
//     				{
//     					for(i=0;i<11;i++)
//     					{
//     						paraString=paraString+AA[i][j]+",";
//     					}
//     				}
//     				//组合完了，现在才开始调用经济模型
//		     		//System.out.println(paraString);
//     				ecooutput=IModelEconomicService.start(projectId,paraString,"","","","","");
//		     		//IModelEconomicService.start("112233","GanZhou","20","10","10","5","8");
//		     		ecooutputArr=ecooutput.split(",");
//		     		if(ecooutputArr.length!=100)
//		     		{
//		     		
//			     			return ecooutput+"  len:"+ecooutputArr.length;
//			     		
//		     		}
//		     		System.out.println(ecooutput);
//		     		//提取结果
//		     		for(countyIndex=0;countyIndex<10;countyIndex++)
//		     		{
//		     			countyId=climateArr[countyIndex].getCountyId();
//		     			modelOutputArr[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setProjectID(projectId);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setArgValueR(ecooutputArr[countyIndex*10]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setIndValueR(ecooutputArr[countyIndex*10+1]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSerValueR(ecooutputArr[countyIndex*10+2]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandFarmR(ecooutputArr[countyIndex*10+3]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandCIR(ecooutputArr[countyIndex*10+4]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandSerR(ecooutputArr[countyIndex*10+5]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setWaterPR(ecooutputArr[countyIndex*10+6]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setEmpR(ecooutputArr[countyIndex*10+7]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSurWDR(ecooutputArr[countyIndex*10+8]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setGWWDR(ecooutputArr[countyIndex*10+9]);//~~~~~~  
//		     		}
//     				
//     			}//end of else//生态水文先算
//     		}
//     	
//     	
//     	
//         //计算指标啦！
//     	/*计算指标思路，1.读a_goal，看本项目需要算哪些指标；
//     	2.根据要算的指标index,从defaultIndicator表读取计算公式，用commons-jexl方法解析计算  
//     	 这一步最大的问题在于：计算进行不下去！！！！！指标计算所需要的很多输入变量没有！！！
//     	 3.按年份按区县存储指标计算结果到 indicatorOutput表 
//     	 点指标评价的时候，需要做的事情就是  从defaultIndicator、a_goal、indicatorOutput中组合指标运算web service需要的格式。
//     	*/
//     	List<IndicatorInfo> indiInfoList=modelFunctionService.getIndicatorInfo(watershedId);
//     	if(indiInfoList.size()==0)
//     	{
//     		return "指标信息不存在";
//     	}
//     	Goal goal=goalService.getGoalById(projectId);
//     	if(goal==null)
//     	{
//     		return "项目目标信息不存在";
//     	}
//     	//很关键的一步来了~  看哪些指标是需要计算的   1.用户指定的与目前能算的交集~~
//     	for(i=0;i<indiInfoList.size();i++)
//     	{
//     		indiInfoList.get(i).setNeed(false);
//     	}
//     	indiInfoList.get(0).setNeed(true);//1.1.1
//     	indiInfoList.get(1).setNeed(true);//1.1.2
//     	indiInfoList.get(2).setNeed(true);//1.2.1  安全水
//     	indiInfoList.get(7).setNeed(true);//1.4.3
//     	indiInfoList.get(9).setNeed(true);//2.1.1  9森林覆盖率
//     	indiInfoList.get(10).setNeed(true);//2.2.1 10 退化土地占总土地面积比例
//     	indiInfoList.get(11).setNeed(true);//2.3.1
//     	indiInfoList.get(12).setNeed(true);//3.1.1
//     	indiInfoList.get(13).setNeed(true);//3.2.1
//     	indiInfoList.get(17).setNeed(true);//3.5.2
//     	indiInfoList.get(19).setNeed(true);//3.7.1
//     	indiInfoList.get(20).setNeed(true);//3.7.2
//     	indiInfoList.get(22).setNeed(true);//3.8.1 	
//     	Indicators indiArr[]=new Indicators[yearNum*11];//把全流域加进去
//     	//System.out.println("outIndex="+outIndex);
//     	int indiIndex=0;
//     	int modeloutindex;
//     	double GDP;//总产值(元)
//     	double waterDemand;//总需水量(m3)
//     	double POP=0;// 区域总人口数量(万人)
//     	double Area;// 山地所在区域总面积(km2)   	
//     	double baseNeedSurWater[]=new double[10];
//     	double baseNeedGWater[]=new double[10];
//     	double baseForestArea;
//     	double baseGrassArea;
//     	double agrivalue[]=new double[10];
//     	double indivalue[]=new double[10];
//     	double servalue[]=new double[10];
//     	double empr[]=new double[10];
//     	double agriarea[]=new double[10];
//     	double indiarea[]=new double[10];
//     	double serarea[]=new double[10];
//     	double waterP[]=new double[10];
//     	double indiarear,serarear,waterpr;
//     	double safewaterpop;
//     	double agrivaluer;
//     	double indivaluer;
//     	double servaluer;
//     	double surwaterr;
//     	double emprr;
//     	double gwaterr;
//     	double surwaterOffer;
//     	double gwaterOffer;
//     	double safewaterr;
//     	double safewaterr_year;
//     	double safepop;
//     	double x0,xm,r;
//     	double forestr,forestr_year,grassr,grassr_year,greenarea;
//     	double emppopr;//当年的就业率
//     	double lameda,negak,urbanr;
//     	double agriwater,agriwaterb;
//     	double agriareareult,agrarear;
//     	double baseSurWater,baseUGWater,agrivalueyy,indivalueyy,servalueyy,waterpricey;
//        double agrareagq,indiareagq,serareagq;
//        double forestbase,forestmax,forestk,grassbase,grassmax,grassk,barebase,baremax,barek,inditemp;
//     	
//        //用于计算流域指标的变量
//        double allEcoWater[]=new double[10*yearNum];
//        double allWaterNeed[]=new double[10*yearNum];
//        double allSurWaterOffer[]=new double[10*yearNum];
//        double allGroundWaterOffer[]=new double[10*yearNum];
//        double allSafeWaterPop[]=new double[10*yearNum];
//        double allForestArea[]=new double[10*yearNum];
//        double allGrassArea[]=new double[10*yearNum];
//        double allArea[]=new double[10];
//        double allBareArea[]=new double[10*yearNum];
//        double allPop[]=new double[10*yearNum];
//        double allEmpPop[]=new double[10*yearNum];
//        double allUrbanPop[]=new double[10*yearNum];
//        double allAgriArea[]=new double[10*yearNum];
//        double allAgriValue[]=new double[10*yearNum];
//        double allAgriWater[]=new double[10*yearNum];
//        double allCropET[]=new double[10*yearNum];
//        double allGDP[]=new double[10*yearNum];
//     	for(countyIndex=0;countyIndex<10;countyIndex++)//每个区县
//     	{
//     		countyId=climateArr[countyIndex].getCountyId();
//     		indiPara=(IndicatorPara)indiparaMap.get(countyId);
//     		land=(LandPara)allLand.get(countyId);
//     		water=(WaterPara)allWater.get(countyId);
//     		eco=(EcoPara)allEco.get(countyId);
//     		agrivalue[countyIndex]=Double.parseDouble(indiPara.getAgrivalue());
//     		indivalue[countyIndex]=Double.parseDouble(indiPara.getIndivalue());
//     		servalue[countyIndex]=Double.parseDouble(indiPara.getServalue());
//     		baseNeedSurWater[countyIndex]=Double.parseDouble(indiPara.getBaseNeedSurWater());
//     		baseNeedGWater[countyIndex]=Double.parseDouble(indiPara.getBaseNeedGWater());
//     		
//
//     		forestbase=Double.parseDouble(indiPara.getForestArea());
//     		forestmax=Double.parseDouble(indiPara.getForestmax());
//     		forestk=Double.parseDouble(land.getLandForestR());
//     		
//     		grassbase=Double.parseDouble(indiPara.getGrassArea());
//     		grassmax=Double.parseDouble(indiPara.getGrassmax());
//     		grassk=Double.parseDouble(land.getLandGrassR());
//     		
//     		barebase=Double.parseDouble(indiPara.getBarebase());
//     		baremax=Double.parseDouble(indiPara.getBaremax());
//     		barek=Double.parseDouble(land.getWaterArea());
//     		
//     		safewaterr=Double.parseDouble(water.getWaterdistribution());//安全饮用水人口年增长率
//     		safewaterr_year=safewaterr/100;
//     		safewaterpop=Double.parseDouble(indiPara.getSafewaterPop());
//     		
//     		x0=Double.parseDouble(indiPara.getPopx0());
//     		xm=Double.parseDouble(indiPara.getPopxm());
//     		r=Double.parseDouble(eco.getPopolicy());//直接用
//     		baseForestArea=Double.parseDouble(indiPara.getForestArea());
//     		baseGrassArea=Double.parseDouble(indiPara.getGrassArea());
//     		forestr=Double.parseDouble(land.getLandForestR());
//     		forestr_year=forestr/yearNum/100;
//     		grassr=Double.parseDouble(land.getLandGrassR());
//     		grassr_year=grassr/yearNum/100;
//     		Area=Double.parseDouble(indiPara.getArea());
//     		lameda=Double.parseDouble(indiPara.getUrbanla());
//     		negak=Double.parseDouble(eco.getNegak());//直接用
//     		agriwater=Double.parseDouble(indiPara.getAgriwater());//农业用水比例
//     		empr[countyIndex]=Double.parseDouble(indiPara.getEmpr());//就业率
//         	agriarea[countyIndex]=Double.parseDouble(indiPara.getFarmArea());//公顷
//         	indiarea[countyIndex]=Double.parseDouble(indiPara.getIndiArea());
//         	serarea[countyIndex]=Double.parseDouble(indiPara.getSerArea());
//         	waterP[countyIndex]=Double.parseDouble(indiPara.getWaterPrice());
//         	allArea[countyIndex]=Area;//新加
//     		for(yearIndex=0;yearIndex<yearNum;yearIndex++)
//     		{
//     			yearInt=timeStart+yearIndex;
//     			indiIndex=countyIndex*yearNum+yearIndex;
//     			//System.out.println("indiIndex="+indiIndex);
//     			modeloutindex=yearIndex*10+countyIndex;
//     			indiArr[indiIndex]=new Indicators();
//     			indiArr[indiIndex].setCountyId(countyId);//~~~~~~~~~~~~~~~~~~~~~
//     			indiArr[indiIndex].setYear(""+yearInt);//~~~~~~~~~~~~~~~~~~~~~
//     			indiArr[indiIndex].setProjectId(projectId);//~~~~~~~~~~~~~~~~~~~~~
//     			surwaterr=Double.parseDouble(modelOutputArr[modeloutindex].getSurWDR())/100;//地表需水变化率
// 				gwaterr=Double.parseDouble(modelOutputArr[modeloutindex].getGWWDR())/100;//地下需水变化率
// 				agrivaluer=Double.parseDouble(modelOutputArr[modeloutindex].getArgValueR())/100;
// 				indivaluer=Double.parseDouble(modelOutputArr[modeloutindex].getIndValueR())/100;
// 				servaluer=Double.parseDouble(modelOutputArr[modeloutindex].getSerValueR())/100;
// 				indiarear=Double.parseDouble(modelOutputArr[modeloutindex].getLandCIR())/100;
// 				serarear=Double.parseDouble(modelOutputArr[modeloutindex].getLandSerR())/100;
// 				waterpr=Double.parseDouble(modelOutputArr[modeloutindex].getWaterPR())/100;
// 				agrarear=Double.parseDouble(modelOutputArr[modeloutindex].getLandFarmR())/100;
// 				emprr=Double.parseDouble(modelOutputArr[modeloutindex].getEmpR())/100;//就业率变化率
// 						
// 				emppopr=empr[countyIndex]*(1+emprr);//当年的就业率
// 				waterpricey=waterP[countyIndex]*(1+waterpr);
// 				agrareagq=agriarea[countyIndex]*(1+agrarear);
// 				indiareagq=agriarea[countyIndex]*(1+indiarear);
// 				serareagq=agriarea[countyIndex]*(1+serarear);
// 				baseSurWater=baseNeedSurWater[countyIndex]*(1+surwaterr);
// 				baseUGWater=baseNeedGWater[countyIndex]*(1+gwaterr);
// 				waterDemand=baseSurWater+baseUGWater;
// 				//GDP数据库里面是亿元为单位
// 				agrivalueyy=agrivalue[countyIndex]*(1+agrivaluer); 				
// 				indivalueyy=indivalue[countyIndex]*(1+indivaluer);
// 				servalueyy=servalue[countyIndex]*(1+servaluer);
// 				GDP=agrivalueyy+indivalueyy+servalueyy;
// 				surwaterOffer=Double.parseDouble(modelOutputArr[modeloutindex].getSurSup());//地表供水
// 				gwaterOffer=Double.parseDouble(modelOutputArr[modeloutindex].getGWSup());//地下供水
// 				
// 				POP=xm/(1+(xm/x0-1)*Math.pow(Math.E, -1*r*yearIndex));//万人
// 				if(countyIndex==9)//额济纳旗  用的是阿拉善的数据，要做一下处理   下辖地区阿拉善左旗、阿拉善右旗、额济纳旗 
// 				{
// 					POP=POP/3;
// 				}
// 				allPop[indiIndex]=POP;
// 				allGDP[indiIndex]=GDP;
// 				allWaterNeed[indiIndex]=waterDemand;
// 				allSurWaterOffer[indiIndex]=surwaterOffer;
// 				allGroundWaterOffer[indiIndex]=gwaterOffer;
// 				allEmpPop[indiIndex]=POP*emppopr;
// 				allAgriValue[indiIndex]=agrivalueyy;
// 				//经济用水
// 				agriwaterb=Float.parseFloat(indiPara.getEcopro())*(surwaterOffer+gwaterOffer);
// 				
// 				allEcoWater[indiIndex]=agriwaterb;
// 				if(indiInfoList.get(0).getNeed())//提高水生产力到b%
//     			{
//     				indiArr[indiIndex].setWaterProductivity(""+(GDP/agriwaterb));//~~~~~~~~~~~~~~~~~~~~~
//     			}
//     			if(indiInfoList.get(1).getNeed())//在各个层次上减小用水压力到m%    waterConsumption/freshWater
//     			{
//     				indiArr[indiIndex].setWaterPressure(""+(waterDemand/(surwaterOffer+gwaterOffer)*100));
//     			}
//     			safepop=safewaterpop*(1+safewaterr_year*yearIndex);
//     			allSafeWaterPop[indiIndex]=safepop;
//     			if(indiInfoList.get(2).getNeed())//提高流域社会安全饮用水人口比例到d%  POPws/POP
//     			{	
//     				indiArr[indiIndex].setSafeDrinkingWaterR(""+(safepop/POP*100));
//     			}
//     			if(indiInfoList.get(7).getNeed())//中游地下水开采量i 亿m3
//     			{
//     				indiArr[indiIndex].setGroundwaterMining(""+gwaterOffer);
//     			}
//     			//森林面积
// 				inditemp=forestmax/(1+((forestmax/forestbase-1)*Math.pow(Math.E, -1*forestk*yearIndex)));
// 				allForestArea[indiIndex]=inditemp;
// 				
//     			if(indiInfoList.get(9).getNeed())//森林覆盖指数b%
//     			{
//     				indiArr[indiIndex].setForestCoverR(""+(inditemp/Area*100));
//     			}
//     			//森林面积+草地面积
//     			inditemp=inditemp+grassmax/(1+((grassmax/grassbase-1)*Math.pow(Math.E, -1*grassk*yearIndex)));
//     			allGrassArea[indiIndex]=inditemp;
//     			if(indiInfoList.get(11).getNeed())//山地绿色覆盖指数b%
//     			{
//     				indiArr[indiIndex].setMountainGreenCoverR(""+(inditemp/Area*100));
//     			}
//     			//土地退化面积
// 				inditemp=baremax/(1+((baremax/barebase-1)*Math.pow(Math.E, -1*barek*yearIndex)));	
// 				allBareArea[indiIndex]=inditemp;
//     			if(indiInfoList.get(10).getNeed())//土地退化
//     			{
//     				indiArr[indiIndex].setForestSustainableR(""+(inditemp/Area*100));
//     			}
//
//     			if(indiInfoList.get(12).getNeed())//人均GDP   万元/万人
//     			{
//     				indiArr[indiIndex].setGdpPerCapita(""+((10000*GDP)/POP));
//     			}
//     			if(indiInfoList.get(13).getNeed())//就业人口人均 GDP
//     			{
//     				indiArr[indiIndex].setGdpPerCapitaEmployed(""+((10000*GDP)/(POP*emppopr)));
//     			}
//     			urbanr=1/(1+lameda*Math.pow(Math.E, negak*(1+yearIndex)))*100;
//     			allUrbanPop[indiIndex]=urbanr/100*POP;
//     			if(indiInfoList.get(17).getNeed())//urbanR 
//     			{
//     				
//     				indiArr[indiIndex].setUrbanR(""+urbanr);
//     			}
//     			agriareareult=agrareagq/666.667;  //公顷转化为万亩
//     			allAgriArea[indiIndex]=agriareareult;
//     			if(indiInfoList.get(22).getNeed())//维持可持续发展的中游耕地面积在e万亩
//     			{
//     				indiArr[indiIndex].setAreaCrop(""+agriareareult);
//     			}
//     			//农业用水
//     			agriwaterb=agriwater*(surwaterOffer+gwaterOffer);
//     			allAgriWater[indiIndex]=agriwaterb;
//     			
//     			if(indiInfoList.get(19).getNeed())//提高农业水生产力到b  Ya 农业总产值 (元)/Qtot 农业总用水量(m3)
//     			{
//     				indiArr[indiIndex].setWaterProductivityAgri(""+agrivalueyy/agriwaterb);
//     			}
//     			if(indiInfoList.get(20).getNeed())//提高农业水利用效率到c% Ea 作物总蒸腾量(m3)/Qtot 农业总用水量(m3)
//     			{
//     				double temp=Double.parseDouble(modelOutputArr[modeloutindex].getCropET())*0.75;
//     				allCropET[indiIndex]=temp;
//     				temp=temp/agriwaterb;
//     				indiArr[indiIndex].setWaterUseEffiAgri(""+temp);
//     			}
//     			indiArr[indiIndex].setPop(""+allPop[indiIndex]);
//
//     			//模型新加的几个变量放进去！！！！
//     			if(yearIndex>0)
//     			{
//	 				modelOutputArr[modeloutindex].setArgValue(""+agrivalueyy);
//	 				modelOutputArr[modeloutindex].setIndValue(""+indivalueyy);
//	 				modelOutputArr[modeloutindex].setSerValue(""+servalueyy);
//	 				modelOutputArr[modeloutindex].setLandFarm(""+agrareagq);
//	 				modelOutputArr[modeloutindex].setLandCI(""+indiareagq);
//	 				modelOutputArr[modeloutindex].setLandSer(""+serareagq);
//	 				modelOutputArr[modeloutindex].setEmp(""+emppopr);
//	 				modelOutputArr[modeloutindex].setWaterP(""+waterpricey);
//	 				modelOutputArr[modeloutindex].setSurWD(""+baseSurWater);
//	 				modelOutputArr[modeloutindex].setGWWD(""+baseUGWater);
//     			}
//     		}//end of year
//     	}//end of for county
//     	//现在算全流域的
//     	int varIndex;
//     	double varGDP=0,varEcoWater=0,varWaterNeed=0,varSurWaterOffer=0,varGroundWaterOffer=0,varSafeWaterPop=0,
//     	varForestArea=0,varGrassArea=0,varArea=0,varBareArea=0,varPop=0,varEmpPop=0,varUrbanPop=0,varAgriArea=0,varAgriValue=0,
//     	varAgriWater=0,varCropET=0;
//     	for(yearIndex=0;yearIndex<yearNum;yearIndex++)
// 		{
// 			yearInt=timeStart+yearIndex;
// 			indiIndex=10*yearNum+yearIndex;
// 			indiArr[indiIndex]=new Indicators();
// 			indiArr[indiIndex].setCountyId("0");//~~~~~~~~~~~~~~~~~~~~~
// 			indiArr[indiIndex].setYear(""+yearInt);//~~~~~~~~~~~~~~~~~~~~~
// 			indiArr[indiIndex].setProjectId(projectId);//~~~~~~~~~~~~~~~~~~~~~
// 			varGDP=0;
// 			varEcoWater=0;
// 			varWaterNeed=0;
// 			varSurWaterOffer=0;
// 			varGroundWaterOffer=0;
// 			varSafeWaterPop=0;
// 			varForestArea=0;
// 			varGrassArea=0;
// 			varArea=0;
// 			varBareArea=0;
// 			varPop=0;
// 			varEmpPop=0;
// 			varUrbanPop=0;
// 			varAgriArea=0;
// 			varAgriValue=0;
// 			varAgriWater=0;
// 			varCropET=0;
// 			for(countyIndex=0;countyIndex<10;countyIndex++)
// 			{
// 				varIndex=countyIndex*yearNum+yearIndex;//变量的索引
// 				varGDP+=allGDP[varIndex];
// 				varEcoWater+=allEcoWater[varIndex];
// 				varWaterNeed+=allWaterNeed[varIndex];
// 				varSurWaterOffer+=allSurWaterOffer[varIndex];
// 				varGroundWaterOffer+=allGroundWaterOffer[varIndex];
// 				varSafeWaterPop+=allSafeWaterPop[varIndex];
// 		     	varForestArea+=allForestArea[varIndex];
// 		     	varGrassArea+=allGrassArea[varIndex];
// 		     	varArea+=allArea[countyIndex];
// 		     	varBareArea+=allBareArea[varIndex];
// 		     	varPop+=allPop[varIndex];
// 		     	varEmpPop+=allEmpPop[varIndex];
// 		     	varUrbanPop+=allUrbanPop[varIndex];
// 		     	varAgriArea+=allAgriArea[varIndex];
// 		     	varAgriValue+=allAgriValue[varIndex];
// 		     	varAgriWater+=allAgriWater[varIndex];
// 		     	varCropET+=allCropET[varIndex];
// 			}
// 			
// 			
// 			
//				//经济用水
//				if(indiInfoList.get(0).getNeed())//提高水生产力到b%
// 			{
// 				indiArr[indiIndex].setWaterProductivity(""+(varGDP/varEcoWater));//~~~~~~~~~~~~~~~~~~~~~
// 			}
// 			if(indiInfoList.get(1).getNeed())//在各个层次上减小用水压力到m%    waterConsumption/freshWater
// 			{
// 				indiArr[indiIndex].setWaterPressure(""+(varWaterNeed/(varSurWaterOffer+varGroundWaterOffer)*100));
// 			}
// 			if(indiInfoList.get(2).getNeed())//提高流域社会安全饮用水人口比例到d%  POPws/POP
// 			{
// 				indiArr[indiIndex].setSafeDrinkingWaterR(""+(varSafeWaterPop/varPop*100));
// 			}
// 			if(indiInfoList.get(7).getNeed())//中游地下水开采量i 亿m3
// 			{
// 				indiArr[indiIndex].setGroundwaterMining(""+varGroundWaterOffer);
// 			}
// 			
// 			if(indiInfoList.get(9).getNeed())//森林覆盖指数b%
// 			{
// 				indiArr[indiIndex].setForestCoverR(""+(varForestArea/varArea*100));
// 			}
// 			if(indiInfoList.get(11).getNeed())//山地绿色覆盖指数b%
// 			{
// 				indiArr[indiIndex].setMountainGreenCoverR(""+((varForestArea+varGrassArea)/varArea*100));
// 			}	
// 			if(indiInfoList.get(10).getNeed())//土地退化
// 			{
// 				indiArr[indiIndex].setForestSustainableR(""+(varBareArea/varArea*100));
// 			}
//
// 			if(indiInfoList.get(12).getNeed())//人均GDP   万元/万人
// 			{
// 				indiArr[indiIndex].setGdpPerCapita(""+((10000*varGDP)/varPop));
// 			}
// 			if(indiInfoList.get(13).getNeed())//就业人口人均 GDP
// 			{
// 				indiArr[indiIndex].setGdpPerCapitaEmployed(""+((10000*varGDP)/varEmpPop));
// 			}
// 			if(indiInfoList.get(17).getNeed())//urbanR 
// 			{
// 				indiArr[indiIndex].setUrbanR(""+varUrbanPop/varPop*100);
// 			}
// 			
// 			if(indiInfoList.get(22).getNeed())//维持可持续发展的中游耕地面积在e万亩
// 			{
// 				indiArr[indiIndex].setAreaCrop(""+varAgriArea);
// 			}
// 			if(indiInfoList.get(19).getNeed())//提高农业水生产力到b  Ya 农业总产值 (元)/Qtot 农业总用水量(m3)
// 			{
// 				indiArr[indiIndex].setWaterProductivityAgri(""+varAgriValue/varAgriWater);
// 			}
// 			if(indiInfoList.get(20).getNeed())//提高农业水利用效率到c% Ea 作物总蒸腾量(m3)/Qtot 农业总用水量(m3)
// 			{
// 				indiArr[indiIndex].setWaterUseEffiAgri(""+varCropET/varAgriWater);
// 			}
// 			indiArr[indiIndex].setPop(""+varPop);
// 		}//end of year
//     	//计算完成，就要存数据库啦！
//     	//先把项目对应输出删干净
//     	modelFunctionService.deleteModelOutput(projectId);
//     	outIndex=yearNum*10;
//     	for(i=0;i<outIndex;i++)
//     	{
//     		modelFunctionService.insertModelOutput(modelOutputArr[i]);
//     	}
//     	//存指标
//     	outIndex=11*yearNum;
//     	modelFunctionService.deletIndicatorOutputbyProjectId(projectId);
//     	for(i=0;i<outIndex;i++)
//     	{
//     		modelFunctionService.insertIndicatorOutput(indiArr[i]);
//     	    System.out.println(indiArr[i].getPop());
//     	}
//     	
//     	return "模型计算完毕 模型计算结果和指标计算结果均存入了数据库";
//     }
//    
//    
//    //模型，指标，评价放到一个函数里的大函数！！！
//  //响应用户按钮    开始计算模型
//    @ResponseBody
//    @RequestMapping(value = "startAll", method = RequestMethod.POST)
//    public String startAll(String projectId,Boolean economicFrist)
//     {
//    	//Boolean term=false;
//    	String modelPath="/home/software/modelfile/";
//    	//String modelPath="E:\\SVM\\modelfile\\";
//    	//DecimalFormat df = new DecimalFormat("#.00");  
//     	//声明所有输入输出变量
//     	double PreChangeR; //降雨增加比例 单位：%                1-x1
//     	double TempChange; //温度变化 单位：℃                                                   1-x2
//     	double LandForestR; //土地利用变化-林地 单位：%
//     	double LandGrassR; //土地利用变化-草地 单位：%
//     	double LandBareR; //土地利用变化-裸地 单位：%
//     	double LandCityR; //土地利用变化-城镇 单位：%
//     	double IARArg; //产业技术进步率-农业 单位：%
//    	double IARInd; //产业技术进步率-工业 单位：%
//    	double IARSer; //产业技术进步率-服务业 单位：%
//    	double LandFarmR; //耕地变化率 单位：%
//     	double dibiaoR_year;
//     	double dixiaR_year;
//     	double LandFarmR_year;
//    	//经济模型的输入限制
//    	double jinbumin=0.000001;
//    	double jinbumax=10;//进步率限值
//    	//double []dibiaomin= new double[]{-15,-10,-9,-25,-25,-30,-10,-10,-10,-10}; //地表供水变化率%
//    	//double []dibiaomax= new double[]{20,13,10,25,25,30,10,10,10,20};
//    	
//    	//double []dixiamin= new double[] {-20,-20,-30,-10,-10,-2,-10,-10,-10,-20};//地下供水变化率%
//    	//double []dixiamax= new double[] {20,20,50,10,10,2,10,10,10,20};
//    	double []dibiaomin= new double[]{-20,-20,-20,-20,-20,-20,-20,-20,-20,-20,-20}; //地表供水变化率%
//    	double []dibiaomax= new double[]{20,20,20,20,20,20,20,20,20,20,20};
//    	
//    	double []dixiamin= new double[] {-20,-20,-20,-20,-20,-20,-20,-20,-20,-20,-20};//地下供水变化率%
//    	double []dixiamax= new double[] {20,20,20,20,20,20,20,20,20,20,20};//20181121根据刘天龙重新取值范围
//     	int i;
//    	/*
//    	620702	甘州区       1
//    	620723	临泽县  2
//    	620724	高台县3
//    	620725	山丹县4
//    	620722	民乐县5
//    	620721	肃南县6
//    	620200	嘉峪关市7
//    	620902	肃州区8
//    	620921	金塔县9
//    	152923	额济纳旗10
//    	 * 
//    	 */
//     	
//     	//获取所有的网页情景    
//     	//网页情景返回应该是按区县排序 
//     	//查找
//     	ClimatePara climate;
//     	LandPara land;
//     	WaterPara water;
//     	EcoPara eco; 	
//     	IndicatorPara indiPara;
//     	ModelOutput[] modelOutputArr;	
//     	String username = userservice.getCurrentUserId();
//     	Project myPro=getWebServiceParaService.getProjectById(username,projectId);
//     	if(myPro==null)
// 		{
// 			return "项目信息不存在";
// 		}
//     	
//         int timeStart = Integer.parseInt(myPro.getBaseYear());// 开始时间
//         int timeEnd = Integer.parseInt(myPro.getGoalYear());
//        
//         int yearNum= timeEnd-timeStart+1;
//         int yearIndex;//年份循环变量
//         
//         //System.out.println(myPro.getBaseYear()+","+myPro.getGoalYear());
//         
//         String watershedId=myPro.getWatershedId();
//         Map<String,Object> map=new HashMap<String,Object>(); 
//         
//         climate=modelFunctionService.getClimateParaByCounty(projectId, "1");//上游的区县ID是1
//         if(climate==null)
//         {
//         	return "上游地区的气候情景不存在";
//         }
//         
//       
//         
//          
//         PreChangeR=Float.parseFloat(climate.getPreChangeR()); //降雨增加比例 单位：%
//     	TempChange=Float.parseFloat(climate.getTempChange()); //温度变化 单位：℃
//     	
//         
//         double arr_FlowYLX[]=new double[yearNum];//莺落峡所有年份流量输出
//         double arr_FlowOther[]=new double[yearNum];//其他河流流量输出
//         //方程样式FlowYLX(Preratio_up,Temratio_up);5*Preratio_up*Temratio_up*500000
//         double PreChangeR_year;//%
//         double TempChange_year;//摄氏度
//         double LandForestR_year;
//         double LandGrassR_year;
//         double LandBareR_year;
//         double LandCityR_year; 
//         double precylx,precother,airtylx,airtother; 
//         
//         //限定温度（摄氏度）和降水（%）范围
//         //降雨(%), [-0.15, 0.15]
//         //温度(C), [0, 2]
//         if(PreChangeR<-15)
//         {
//        	 PreChangeR=-15;
//         }
//         else if(PreChangeR>15)
//         {
//        	 PreChangeR=15;
//         }
//         if(TempChange<0.000001)
//         {
//        	 TempChange=0;
//         }
//         else if(TempChange>2)
//         {
//        	 TempChange=2;
//         }
//         PreChangeR_year=PreChangeR/(yearNum)/100;
//         TempChange_year=TempChange/yearNum;
//         double pre,temper;
//     	for(yearIndex=1;yearIndex<yearNum;yearIndex++)//按年份开始计算上游模型了
//     	{
//     		//黑河上游2001至2012年年平均气温（K）在干流区和非干流区分别为：270.24，271.60，拟合公式适用范围为【269K, 275K】
//     		//年平均降水（mm）在干流区和非干流区分别为669.15，814.35，拟合公式适用范围为 [407,1000]
//     		//pre=Math.pow(1+PreChangeR_year,1+yearIndex);
//     		//pre=PreChangeR/100;
//     		//precylx=669.15*Math.pow(1+pre,1+yearIndex);//鹰落峡降水mm 
//     		pre=1+PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     		precylx=669.15*pre;//鹰落峡降水mm
//     		if(precylx<407)
//     		{
//     			precylx=407;
//     		}  
//     		else if(precylx>1000)
//     		{
//     			precylx=1000;
//     		}
//     		//precother=814.35*Math.pow(1+pre,1+yearIndex);//鹰落峡降水mm 
//     		precother=814.35*pre;//鹰落峡降水mm 
//     		if(precother<407)
//     		{
//     			precother=407;
//     		}  
//     		else if(precother>1000)
//     		{
//     			precother=1000;
//     		}
//     		//1摄氏度(℃)=274.15开尔文(K) 不对，应该摄氏度和开尔文温度的差值是一样的
//     		//temper=TempChange_year*(1+yearIndex);
//     		temper=TempChange*yearIndex;
//     		airtylx=270.24+temper;
//     		if(airtylx<269)
//     		{
//     			airtylx=269;
//     		}
//     		else if(airtylx>275)
//     		{
//     			airtylx=275;
//     		}
//     		airtother=271.60+temper;
//     		if(airtother<269)
//     		{
//     			airtother=269;
//     		}
//     		else if(airtother>275)
//     		{
//     			airtother=275;
//     		}
//     		
//     		//立方米-》亿立方米
//     		arr_FlowYLX[yearIndex]=(177.825085*precylx*precylx
//     		       + 6988908.56*airtylx*airtylx
//     		       -77217.5416*precylx*airtylx
//     		       +26500711*precylx-3.84373553e9*airtylx + 5.26858754e11)/1e8;
//     		arr_FlowOther[yearIndex]=(-3.94249672e2 *precother*precother
//     		       -1.62845167e7*airtother*airtother
//     		       +1.27406840e6*precother*airtother
//     		       -3.41549958e8*precother
//     		       +7.82500648e9*airtother -9.25319379e+11)/1e8;
//     	}//此时已经计算完上游模型，结果存在arr_Out_FlowYLX arr_Out_FlowOther 
//     	Map<String,Object> allClimate=modelFunctionService.getClimateParaMap(projectId);
//     	if(allClimate.size()<14)
//     	{
//     		return "气候情景参数不全";
//     	}
//     	Map<String,Object> allLand=modelFunctionService.getLandParaMap(projectId);
//     	if(allLand.size()<14)
//     	{
//     		return "土地利用情景参数不全";
//     	}
//     	Map<String,Object> allEco=modelFunctionService.getEcoParaMap(projectId);
//     	if(allEco.size()<14)
//     	{
//     		return "社会经济情景参数不全";
//     	}
//     	Map<String,Object> allWater=modelFunctionService.getWaterParaMap(projectId);
//     	if(allWater.size()<14)
//     	{
//     		return "水资源情景参数不全";
//     	}
//     	Map<String,Object> indiparaMap=modelFunctionService.getIndiParabyWatershedId(watershedId);
//     	if(indiparaMap.size()<10)
//     	{
//     		return "基础年参数不全";
//     	}
//     	int j=0,k;
//     	int countyIndex;
//     	ClimatePara climateArr[]=new ClimatePara[11];
//     	climateArr[0]=(ClimatePara)(allClimate.get("620702"));
//     	climateArr[1]=(ClimatePara)(allClimate.get("620723"));
//     	climateArr[2]=(ClimatePara)(allClimate.get("620724"));
//     	climateArr[3]=(ClimatePara)(allClimate.get("620725"));
//     	climateArr[4]=(ClimatePara)(allClimate.get("620722"));
//     	climateArr[5]=(ClimatePara)(allClimate.get("620721"));
//     	climateArr[6]=(ClimatePara)(allClimate.get("620200"));
//     	climateArr[7]=(ClimatePara)(allClimate.get("620902"));
//     	climateArr[8]=(ClimatePara)(allClimate.get("620921"));
//     	climateArr[9]=(ClimatePara)(allClimate.get("152923"));
//     	climateArr[10]=(ClimatePara)(allClimate.get("632222")); //祁连县
//     	/*中下游模型按下列区县顺序
//     	620702	甘州区      
//     	620723	临泽县
//     	620724	高台县
//     	620725	山丹县
//     	620722	民乐县
//     	620721	肃南县
//     	620200	嘉峪关市
//     	620902	肃州区
//     	620921	金塔县
//     	152923	额济纳旗*/
//     	//模型输出数组
//     	modelOutputArr=new ModelOutput[yearNum*10];//只计算10个区县
//     	for(i=0;i<yearNum*10;i++)
//     	{
//     		modelOutputArr[i]=new ModelOutput();
//     	}
//     	int outIndex=0;
//     	int yearInt; 
//     	String countyId;	
// 		double v;
// 		double A[]=new double[6];
// 		double ht[]=new double[22];
// 		
// 		double AA[][]=new double[11][6];//用来组合经济模型输入变量的
//        for(i=0;i<11;i++)
//        {
//        	AA[i]=new double[6];
//        }
// 		double SurSup1,SurSup2;//第一年数据，第二年数据
// 		double GWSup1,GWSup2;
// 		double IARArg_year,IARInd_year,IARSer_year,landFarmR_year;
// 		double value[]=new double[10];
// 		
// 		//基础年的数据赋值
// 		for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    先算经济模型
//		{
//				countyId=climateArr[countyIndex].getCountyId();
//				//modelOutputArr[countyIndex]=new ModelOutput();
//				indiPara=(IndicatorPara)(indiparaMap.get(countyId));
//				modelOutputArr[countyIndex].setArgValue(indiPara.getAgrivalue());
//				modelOutputArr[countyIndex].setArgValueR("0");
//				modelOutputArr[countyIndex].setCountyId(countyId);
//				modelOutputArr[countyIndex].setCropET(indiPara.getCropET());
//				modelOutputArr[countyIndex].setEmp(indiPara.getEmpr());
//				modelOutputArr[countyIndex].setEmpR("0");
//				modelOutputArr[countyIndex].setFlowOther(indiPara.getFlowOther());
//				modelOutputArr[countyIndex].setFlowYLX(indiPara.getFlowYLX());
//				modelOutputArr[countyIndex].setGWSup(indiPara.getGWSup());
//				modelOutputArr[countyIndex].setGWWD(""+Float.parseFloat(indiPara.getBaseNeedGWater())/Float.parseFloat(indiPara.getEcopro()));
//				modelOutputArr[countyIndex].setGWWDR("0");
//				modelOutputArr[countyIndex].setIndValue(indiPara.getIndivalue());
//				modelOutputArr[countyIndex].setIndValueR("0");
//				modelOutputArr[countyIndex].setLandCI(indiPara.getIndiArea());
//				modelOutputArr[countyIndex].setLandCIR("0");
//				modelOutputArr[countyIndex].setLandSer(indiPara.getSerArea());
//				modelOutputArr[countyIndex].setLandSerR("0");
//				modelOutputArr[countyIndex].setLandFarm(indiPara.getFarmArea());
//				modelOutputArr[countyIndex].setLandFarmR("0");
//				modelOutputArr[countyIndex].setProjectID(projectId);
//				modelOutputArr[countyIndex].setSerValue(indiPara.getServalue());
//				modelOutputArr[countyIndex].setSerValueR("0");
//				modelOutputArr[countyIndex].setSurSup(indiPara.getSurSup());
//				modelOutputArr[countyIndex].setSurWD(""+Float.parseFloat(indiPara.getBaseNeedSurWater())/Float.parseFloat(indiPara.getEcopro()));
//				modelOutputArr[countyIndex].setSurWDR("0");
//				modelOutputArr[countyIndex].setWaterP(indiPara.getWaterPrice());
//				modelOutputArr[countyIndex].setWaterPR("0");
//				//modelOutputArr[countyIndex].setWetlandArea("");
//				modelOutputArr[countyIndex].setYear(myPro.getBaseYear());
//		}
//
//     		IModelEconomic IModelEconomicService= new IModelEconomicImpl().getIModelEconomicImplPort();
//     		String ecooutput;
//     		String ecooutputArr[];
//     		String countyName[]=new String[] {"GanZhou","LinZe","GaoTai","ShanDan","MinLe","SuNan","JiaYuGuan","SuZhou","JinTai","EJNAQ"};
//         	String fileName;
//         	//读文件，获取中下游模型的a和b
//         	//读文件，获取X的max和min
//         	double a[]=new double[30];
//     		double b[]=new double[30];
//     		try
//     		{
//     			BufferedReader abr=new BufferedReader(new FileReader(modelPath+"a.txt"));
//     			BufferedReader bbr=new BufferedReader(new FileReader(modelPath+"b.txt"));
//     			for(i=0;i<30;i++)
//     			{
//     				a[i]=Double.valueOf(abr.readLine()).doubleValue();
//     				b[i]=Double.valueOf(bbr.readLine()).doubleValue();
//     			}
//     			abr.close();
//     			bbr.close();
//     		}
//     		catch(Exception e)
//     		{
//     			System.out.println(e.toString());
//     			return "打开中下游生态水文模型系数a,b文件错误";
//     		}
//     		double max[]=new double[25];
//     		double min[]=new double[25];
//     		try
//     		{
//     			BufferedReader abr=new BufferedReader(new FileReader(modelPath+"minmax.txt"));
//     			for(i=0;i<25;i++)
//     			{
//     				min[i]=Double.valueOf(abr.readLine()).doubleValue();
//     				max[i]=Double.valueOf(abr.readLine()).doubleValue();
//     			}
//     			abr.close();
//     		}
//     		catch(Exception e)
//     		{
//     			System.out.println(e.toString());
//     			return "打开中下游生态水文模型系数输入限值文件错误";
//     		}
//     		
//     		svm_model svmmodel[]=new svm_model[30];
//     		
//     		int modelindex;
//     		j=0;
//     		for(i=1;i<=10;i++) //读取30个模型
//     		{
//     			for(k=1;k<=3;k++)
//     			{
//     				modelindex=i*10+k;
//     				fileName=modelPath+"model"+modelindex+".txt";
//     				try
//     				{
//     					svmmodel[j] = svm.svm_load_model(fileName);
//     					if (svmmodel[j]== null)
//     					{
//     						System.err.print("can't open model file "+fileName);
//     						return "打开SVM模型文件错误 "+fileName;
//     					}
//     					j++;
//     				}
//     				catch(Exception e)
//     				{
//     					System.out.println(e.toString());
//     					return "打开SVM模型文件错误  "+fileName;
//     				}
//     			}
//     		}
//     		svm_node[]x=new svm_node[25];
//     		double input[]=new double[25];
//     		//定制SVM的输入X
//     		for(i=0;i<25;i++)
//     		{
//     			x[i] = new svm_node();
//     			x[i].index=i+1;
//     		}
//     		for(i=0;i<10;i++)//非农业用水  一直不变，从网页情景得来
//     		{
//     			water=(WaterPara)(allWater.get(climateArr[i].getCountyId()));	
//     			input[5+i]=Double.parseDouble(water.getSupWater());
//     			if(input[5+i]>=min[5+i] && input[5+i]<=max[5+i])
//     			{
//     				x[5+i].value=(input[5+i]-min[5+i])/(max[5+i]-min[5+i]);
//     			}
//     			else
//     			{
//     				if(input[5+i]<min[5+i])
//     				{
//     					x[5+i].value=0;
//     				}
//     				else if(input[5+i]>max[5+i])
//     				{
//     					x[5+i].value=1;
//     				}
//     			}
//     		}
//     		//economicFrist=false;//先算生态水文
//     		String paraString;
//     		for(yearIndex=1;yearIndex<yearNum;yearIndex++)//按年份开始计算中下游模型和经济模型了
//     		{
//     			yearInt=timeStart+yearIndex;
//     			if(economicFrist)
//     			{
//     				
//     				for(countyIndex=0;countyIndex<11;countyIndex++)//10个区县    先算经济模型
//     				{
//     					countyId=climateArr[countyIndex].getCountyId();
//     					water=(WaterPara)allWater.get(countyId);
//     					indiPara=(IndicatorPara)indiparaMap.get(countyId);
//    		     		eco=(EcoPara)allEco.get(countyId);
//    		     		IARArg=Float.parseFloat(eco.getIARArg());
//    		     		IARInd=Float.parseFloat(eco.getIARInd());
//    		     		IARSer=Float.parseFloat(eco.getIARSer());
//    		     		IARArg_year=IARArg/yearNum/100;
//    		     		IARInd_year=IARInd/yearNum/100;
//    		     		IARSer_year=IARSer/yearNum/100;
//    		     		dibiaoR_year=Float.parseFloat(water.getSurSup())/yearNum/100;
//    		     		dixiaR_year=Float.parseFloat(water.getGWSup())/yearNum/100;
//    		     		/*
//    		     		地表供水量变化率SurSupR
//    		     		地下供水量变化率GWSupR
//    		     		农业产业技术进步率
//    		     		工业产业技术进步率
//    		     		服务业产业技术进步率*/
//    		     		if(countyIndex!=10)//不是祁连县
//    		     		{
//    		     			if(yearIndex==1)
//        		     		{
//        		     			AA[countyIndex][1]=dibiaoR_year*yearIndex*100;
//        		     			AA[countyIndex][2]=dixiaR_year*yearIndex*100;
//        		     			
//        		     		}
//        		     		else if(yearIndex==2)//第一年减基础年     					
//        		     		{
//        		     			SurSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getSurSup())*Float.parseFloat(indiPara.getEcopro());
//        		     			SurSup1=Double.parseDouble(indiPara.getBaseNeedSurWater());    		     			
//        		     			GWSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getGWSup())*Float.parseFloat(indiPara.getEcopro());
//        		     			GWSup1=Double.parseDouble(indiPara.getBaseNeedGWater());
//        		     			AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;
//        		     			AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;	
//        		     		}
//        		     		else
//        		     		{
//        		     			SurSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getSurSup());
//        		     			GWSup2=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getGWSup());
//        		     			SurSup1=Double.parseDouble(modelOutputArr[(yearIndex-2)*10+countyIndex].getSurSup());
//        		     			GWSup1=Double.parseDouble(modelOutputArr[(yearIndex-2)*10+countyIndex].getGWSup());	
//        		     			AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;
//        		     			AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;
//        		     		}
//    		     		}
//    		     		else//是祁连县
//    		     		{
//    		     			AA[countyIndex][1]=dibiaoR_year*yearIndex*100;
//    		     			AA[countyIndex][2]=dixiaR_year*yearIndex*100;
//    		     		}
//    		     		AA[countyIndex][3]=IARArg_year*yearIndex*100;
//    		     		AA[countyIndex][4]=IARInd_year*yearIndex*100;
//    		     		AA[countyIndex][5]=IARSer_year*yearIndex*100;
//    		     		
//    		     		if(AA[countyIndex][1]<dibiaomin[countyIndex])
//    		     		{
//    		     			AA[countyIndex][1]=dibiaomin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][1]>dibiaomax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][1]=dibiaomax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][2]<dixiamin[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][2]>dixiamax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][3]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][3]=0;
//    		     		}
//    		     		else if(AA[countyIndex][3]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][3]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][4]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][4]=0;
//    		     		}
//    		     		else if(AA[countyIndex][4]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][4]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][5]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][5]=0;
//    		     		}
//    		     		else if(AA[countyIndex][5]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][5]=jinbumax;
//    		     		}    
//    		     		AA[countyIndex][3]=-1*AA[countyIndex][3];
//    		     		AA[countyIndex][4]=-1*AA[countyIndex][4];
//    		     		AA[countyIndex][5]=-1*AA[countyIndex][5];
//    		             /*
//    		             1.农业总产值变化率
//    		             2.工业总产值变化率
//    		             3.服务业总产值变化率
//    		             4.耕地变化率
//    		             5.工业用地变化率
//    		             6.服务业用地变化率
//    		             7.水价变化率
//    		             8.就业变化率
//    		             9.地表需水量变化率
//    		             10.地下需水量变化率*/
//     				}
//     				paraString="";		
//     				for(j=1;j<6;j++)
//     				{
//     					for(i=0;i<11;i++)
//     					{
//     						paraString=paraString+AA[i][j]+",";
//     					}
//     				}
//     				//组合完了，现在才开始调用经济模型
//     				//System.out.println("参数是我："+paraString);
//     				ecooutput=IModelEconomicService.start(projectId,paraString,"","","","","");
//		     		//IModelEconomicService.start("112233","GanZhou","20","10","10","5","8");
//		     		ecooutputArr=ecooutput.split(",");
//		     		if(ecooutputArr.length!=100)
//		     		{
//		     			return ecooutput+"  len:"+ecooutputArr.length;
//		     		}
//		     		//System.out.println(ecooutput);
//		     		//提取结果
//		     		for(countyIndex=0;countyIndex<10;countyIndex++)
//		     		{
//		     			countyId=climateArr[countyIndex].getCountyId();
//		     			modelOutputArr[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setProjectID(projectId);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setArgValueR(ecooutputArr[countyIndex*10]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setIndValueR(ecooutputArr[countyIndex*10+1]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSerValueR(ecooutputArr[countyIndex*10+2]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandFarmR(ecooutputArr[countyIndex*10+3]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandCIR(ecooutputArr[countyIndex*10+4]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandSerR(ecooutputArr[countyIndex*10+5]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setWaterPR(ecooutputArr[countyIndex*10+6]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setEmpR(ecooutputArr[countyIndex*10+7]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSurWDR(ecooutputArr[countyIndex*10+8]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setGWWDR(ecooutputArr[countyIndex*10+9]);//~~~~~~  
//		     		}
//		     		
//     				
//     				input[2]=arr_FlowYLX[yearIndex];// 莺落峡来流(亿m3/y)
//    	        	input[3]=arr_FlowOther[yearIndex];//其他上游来流(亿m3/y)
//    	        	water=(WaterPara)(allWater.get("2"));//全流域改为中下游
//    	        	input[4]=Double.parseDouble(water.getFlowDown());
//    	        	for(i=0;i<10;i++)//因为先算的  经济模型，所以直接取今年的
//    	        		{
//    	        			input[15+i]=Double.parseDouble(modelOutputArr[yearIndex*10+i].getLandFarmR())/100;
//    	        			if(input[15+i]>=min[15+i] && input[15+i]<=max[15+i])
//    	        			{
//    	        				x[15+i].value=(input[15+i]-min[15+i])/(max[15+i]-min[15+i]);
//    	        			}
//    	        			else
//    	        			{
//    	        				if(input[15+i]<min[15+i])
//    	        				{
//    	        					x[15+i].value=0;
//    	        				}
//    	        				else if(input[15+i]>max[15+i])
//    	        				{
//    	        					x[15+i].value=1;
//    	        				}
//    	        			}
//    	        		}
//     				for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    再算中下游水文模型  
//     				{
//     					countyId=climateArr[countyIndex].getCountyId();
//     					//再算中下游水文模型
//    		            PreChangeR=Float.parseFloat(climateArr[countyIndex].getPreChangeR()); //降雨增加比例 单位：%
//     			    	TempChange=Float.parseFloat(climateArr[countyIndex].getTempChange()); //温度变化 单位：℃
//     			    	
//     			    	PreChangeR_year=PreChangeR/yearNum/100;
//     			    	TempChange_year=TempChange/yearNum;
//     			    	
//     			    	input[0]=PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     			    	input[1]=TempChange*yearIndex;
//     	        		//组合模型输出
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowYLX(""+arr_FlowYLX[yearIndex]);//~~~~~~
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowOther(""+arr_FlowOther[yearIndex]);//~~~~~~
//     	        		for(i=0;i<5;i++)//前五个输入
//     	        		{
//     	        			if(input[i]>=min[i] && input[i]<=max[i])
//     	        			{
//     	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//     	        			}
//     	        			else
//     	        			{
//     	        				if(input[i]<min[i])
//     	        				{
//     	        					x[i].value=0;
//     	        				}
//     	        				else if(input[i]>max[i])
//     	        				{
//     	        					x[i].value=1;
//     	        				}
//     	        			}
//     	        		}  		        		
//     	        		
//     	        		//至此为止，SVM的输入X已经组合好了！！！
//     	        		//开始计算SVM模型
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3],x);
//     	        		v=v*a[countyIndex*3]+b[countyIndex*3];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setSurSup(""+v);//地表水引用量(万吨/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+1],x);
//     	        		v=v*a[countyIndex*3+1]+b[countyIndex*3+1];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setGWSup(""+v);//地下水抽取量(万吨/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+2],x);
//     	        		v=v*a[countyIndex*3+2]+b[countyIndex*3+2];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setCropET(""+v);//耕地面积ET量(万吨/年)//~~~~~~ 
//    	 			}
//     			}
//     			else//生态水文先算     默认！！
//     			{
//     				input[2]=arr_FlowYLX[yearIndex];// 莺落峡来流(亿m3/y)
//     				input[3]=arr_FlowOther[yearIndex];//其他上游来流(亿m3/y)
//     				water=(WaterPara)(allWater.get("2"));
//    	        	input[4]=Double.parseDouble(water.getFlowDown());
//    	        	
//    	        		if(yearIndex==1) //第一年的耕地变化率，从网页得来
//    	        		{
//    	        			for(i=0;i<10;i++)
//    	        			{ 
//    	        				land=(LandPara)(allLand.get(climateArr[i].getCountyId()));
//    	        				LandFarmR=Double.parseDouble(land.getLandFarmR());
//    	        				landFarmR_year=LandFarmR/yearNum/100;  	        	
//    	        				input[15+i]=landFarmR_year*yearIndex;
//    	        			}
//    	        		}
//    	        		else//从第二年起，就从上一年的经济模型的输出里面取得
//    	        		{
//    	        			for(i=0;i<10;i++)
//    	        			{
//    	        				input[15+i]=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+i].getLandFarmR())/100;
//    	        			}
//    	        		}
//    	        		for(i=15;i<25;i++)//后10个输入
//    	        		{
//    	        			if(input[i]>=min[i] && input[i]<=max[i])
//    	        			{
//    	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//    	        			}
//    	        			else
//    	        			{
//    	        				if(input[i]<min[i])
//    	        				{
//    	        					x[i].value=0;
//    	        				}
//    	        				else if(input[i]>max[i])
//    	        				{
//    	        					x[i].value=1;
//    	        				}
//    	        			}
//    	        		}
//     				for(countyIndex=0;countyIndex<10;countyIndex++)//10个区县    先算生态水文模型
//     				{
//     					countyId=climateArr[countyIndex].getCountyId();
//     					//modelOutputArr[yearIndex*10+countyIndex]=new ModelOutput();
//     					modelOutputArr[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//     					modelOutputArr[yearIndex*10+countyIndex].setProjectID(projectId);//~~~~~
//     					
//     					PreChangeR=Float.parseFloat(climateArr[countyIndex].getPreChangeR()); //降雨增加比例 单位：%
//     			    	TempChange=Float.parseFloat(climateArr[countyIndex].getTempChange()); //温度变化 单位：℃
//     			    	
//     			    	PreChangeR_year=PreChangeR/yearNum/100;
//     			    	TempChange_year=TempChange/yearNum;
//     			    	
//     			    	input[0]=PreChangeR_year*(Math.random()+0.5)*yearIndex;
//     			    	input[1]=TempChange*yearIndex; 		
//     	        		//组合模型输出
//     	        		modelOutputArr[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~~
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowYLX(""+arr_FlowYLX[yearIndex]);//~~~~~~
//     	        		modelOutputArr[yearIndex*10+countyIndex].setFlowOther(""+arr_FlowOther[yearIndex]);//~~~~~~
//     	        		for(i=0;i<5;i++)//前五个输入
//     	        		{
//     	        			if(input[i]>=min[i] && input[i]<=max[i])
//     	        			{
//     	        				x[i].value=(input[i]-min[i])/(max[i]-min[i]);
//     	        			}
//     	        			else
//     	        			{
//     	        				if(input[i]<min[i])
//     	        				{
//     	        					x[i].value=0;
//     	        				}
//     	        				else if(input[i]>max[i])
//     	        				{
//     	        					x[i].value=1;
//     	        				}
//     	        			}
//     	        		}
//     	        		//至此为止，SVM的输入X已经组合好了！！！
//     	        		//开始计算SVM模型	
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3],x);
//     	        		v=v*a[countyIndex*3]+b[countyIndex*3];
//     	        		v=v/10000;
//     	        		SurSup2=v;  //计算pcm要用
//     	        		modelOutputArr[yearIndex*10+countyIndex].setSurSup(""+v);//地表水引用量(亿立方米/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+1],x);
//     	        		v=v*a[countyIndex*3+1]+b[countyIndex*3+1];
//     	        		v=v/10000;
//     	        		GWSup2=v;//计算pcm要用
//     	        		modelOutputArr[yearIndex*10+countyIndex].setGWSup(""+v);//地下水抽取量(亿立方米/年)//~~~~~~
//     	        		
//     	        		v = svm.svm_predict(svmmodel[countyIndex*3+2],x);
//     	        		v=v*a[countyIndex*3+2]+b[countyIndex*3+2];
//     	        		v=v/10000;
//     	        		modelOutputArr[yearIndex*10+countyIndex].setCropET(""+v);//耕地面积ET量(亿立方米/年)//~~~~~~ 
//     	        		//再算经济模型
//     	        		if(yearIndex==1)//2013
//     	        		{
//     	        			indiPara=(IndicatorPara)(indiparaMap.get(countyId));
//     	        			SurSup1=Double.parseDouble(indiPara.getBaseNeedSurWater());
//     	        			GWSup1=Double.parseDouble(indiPara.getBaseNeedGWater());
//     	        			SurSup2=SurSup2*Float.parseFloat(indiPara.getEcopro());
//     	        			GWSup2=GWSup2*Float.parseFloat(indiPara.getEcopro());
//     	        		}
//     	        		else
//     	        		{
//     	        			SurSup1=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getSurSup());
//     	        			GWSup1=Double.parseDouble(modelOutputArr[(yearIndex-1)*10+countyIndex].getGWSup());
//     	        		}
//     	        		eco=(EcoPara)allEco.get(countyId);
//     	        		IARArg=Float.parseFloat(eco.getIARArg());
//     	        		IARInd=Float.parseFloat(eco.getIARInd());
//     	        		IARSer=Float.parseFloat(eco.getIARSer());
//     	        		IARArg_year=IARArg/yearNum/100;
//     	        		IARInd_year=IARInd/yearNum/100;
//     	        		IARSer_year=IARSer/yearNum/100;
//
//     	        		AA[countyIndex][1]=(SurSup2-SurSup1)/SurSup1*100;//地表供水量变化率
//     	        		AA[countyIndex][2]=(GWSup2-GWSup1)/GWSup1*100;//地下供水量变化率
//     	        		AA[countyIndex][3]=IARArg_year*yearIndex*100;
//     	        		AA[countyIndex][4]=IARInd_year*yearIndex*100;
//     	        		AA[countyIndex][5]=IARSer_year*yearIndex*100;
//     	        		if(AA[countyIndex][1]<dibiaomin[countyIndex])
//    		     		{
//     	        			AA[countyIndex][1]=dibiaomin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][1]>dibiaomax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][1]=dibiaomax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][2]<dixiamin[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamin[countyIndex];
//    		     		}
//    		     		else if(AA[countyIndex][2]>dixiamax[countyIndex])
//    		     		{
//    		     			AA[countyIndex][2]=dixiamax[countyIndex];
//    		     		}
//    		     		if(AA[countyIndex][3]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][3]=0;
//    		     		}
//    		     		else if(AA[countyIndex][3]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][3]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][4]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][4]=0;
//    		     		}
//    		     		else if(AA[countyIndex][4]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][4]=jinbumax;
//    		     		}
//    		     		if(AA[countyIndex][5]<jinbumin)
//    		     		{
//    		     			AA[countyIndex][5]=0;
//    		     		}
//    		     		else if(AA[countyIndex][5]>jinbumax)
//    		     		{
//    		     			AA[countyIndex][5]=jinbumax;
//    		     		}
//    		     		AA[countyIndex][3]=-1*AA[countyIndex][3];
//    		     		AA[countyIndex][4]=-1*AA[countyIndex][4];
//    		     		AA[countyIndex][5]=-1*AA[countyIndex][5];
//     				}//end of 10个区县   生态水文
//     				//再算经济模型
//     				//组合祁连县的量
// 					water=(WaterPara)allWater.get("632222");
// 					indiPara=(IndicatorPara)indiparaMap.get("632222");
//		     		eco=(EcoPara)allEco.get("632222");
//		     		IARArg=Float.parseFloat(eco.getIARArg());
//		     		IARInd=Float.parseFloat(eco.getIARInd());
//		     		IARSer=Float.parseFloat(eco.getIARSer());
//		     		IARArg_year=IARArg/yearNum/100;
//		     		IARInd_year=IARInd/yearNum/100;
//		     		IARSer_year=IARSer/yearNum/100;
//		     		dibiaoR_year=Float.parseFloat(water.getSurSup())/yearNum/100;
//		     		dixiaR_year=Float.parseFloat(water.getGWSup())/yearNum/100;
//
//		     		AA[10][1]=dibiaoR_year*yearIndex*100;
//		     		AA[10][2]=dixiaR_year*yearIndex*100;
//		     		AA[10][3]=IARArg_year*yearIndex*100;
//		     		AA[10][4]=IARInd_year*yearIndex*100;
//		     		AA[10][5]=IARSer_year*yearIndex*100;
//		     		
//		     		if(AA[10][1]<dibiaomin[10])
//		     		{
//		     			AA[10][1]=dibiaomin[10];
//		     		}
//		     		else if(AA[10][1]>dibiaomax[10])
//		     		{
//		     			AA[10][1]=dibiaomax[10];
//		     		}
//		     		if(AA[10][2]<dixiamin[10])
//		     		{
//		     			AA[10][2]=dixiamin[10];
//		     		}
//		     		else if(AA[10][2]>dixiamax[10])
//		     		{
//		     			AA[10][2]=dixiamax[10];
//		     		}
//		     		if(AA[10][3]<jinbumin)
//		     		{
//		     			AA[10][3]=0;
//		     		}
//		     		else if(AA[10][3]>jinbumax)
//		     		{
//		     			AA[10][3]=jinbumax;
//		     		}
//		     		if(AA[10][4]<jinbumin)
//		     		{
//		     			AA[10][4]=0;
//		     		}
//		     		else if(AA[10][4]>jinbumax)
//		     		{
//		     			AA[10][4]=jinbumax;
//		     		}
//		     		if(AA[10][5]<jinbumin)
//		     		{
//		     			AA[10][5]=0;
//		     		}
//		     		else if(AA[10][5]>jinbumax)
//		     		{
//		     			AA[10][5]=jinbumax;
//		     		}    
//		     		AA[10][3]=-1*AA[10][3];
//		     		AA[10][4]=-1*AA[10][4];
//		     		AA[10][5]=-1*AA[10][5];
//     				
//		     		paraString="";
//		     		for(j=1;j<6;j++)
//     				{
//     					for(i=0;i<11;i++)
//     					{
//     						paraString=paraString+AA[i][j]+",";
//     					}
//     				}
//     				//组合完了，现在才开始调用经济模型
//		     		//System.out.println(paraString);
//     				ecooutput=IModelEconomicService.start(projectId,paraString,"","","","","");
//		     		//IModelEconomicService.start("112233","GanZhou","20","10","10","5","8");
//		     		ecooutputArr=ecooutput.split(",");
//		     		if(ecooutputArr.length!=100)
//		     		{
//		     		
//			     			return ecooutput+"  len:"+ecooutputArr.length;
//			     		
//		     		}
//		     		System.out.println(ecooutput);
//		     		//提取结果
//		     		for(countyIndex=0;countyIndex<10;countyIndex++)
//		     		{
//		     			countyId=climateArr[countyIndex].getCountyId();
//		     			modelOutputArr[yearIndex*10+countyIndex].setYear(""+yearInt);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setProjectID(projectId);//~~~~~
//	 					modelOutputArr[yearIndex*10+countyIndex].setCountyId(countyId);//~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setArgValueR(ecooutputArr[countyIndex*10]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setIndValueR(ecooutputArr[countyIndex*10+1]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSerValueR(ecooutputArr[countyIndex*10+2]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandFarmR(ecooutputArr[countyIndex*10+3]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandCIR(ecooutputArr[countyIndex*10+4]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setLandSerR(ecooutputArr[countyIndex*10+5]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setWaterPR(ecooutputArr[countyIndex*10+6]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setEmpR(ecooutputArr[countyIndex*10+7]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setSurWDR(ecooutputArr[countyIndex*10+8]);//~~~~~~
//			            modelOutputArr[yearIndex*10+countyIndex].setGWWDR(ecooutputArr[countyIndex*10+9]);//~~~~~~  
//		     		}
//     				
//     			}//end of else//生态水文先算
//     		}//end of for year
//	
//         //计算指标啦！
//     	/*计算指标思路，1.读a_goal，看本项目需要算哪些指标；
//     	2.根据要算的指标index,从defaultIndicator表读取计算公式，用commons-jexl方法解析计算  
//     	 这一步最大的问题在于：计算进行不下去！！！！！指标计算所需要的很多输入变量没有！！！
//     	 3.按年份按区县存储指标计算结果到 indicatorOutput表 
//     	 点指标评价的时候，需要做的事情就是  从defaultIndicator、a_goal、indicatorOutput中组合指标运算web service需要的格式。
//     	*/
//     	List<IndicatorInfo> indiInfoList=modelFunctionService.getIndicatorInfo(watershedId);
//     	if(indiInfoList.size()==0)
//     	{
//     		return "指标信息不存在";
//     	}
//     	Goal goal=goalService.getGoalById(projectId);
//     	if(goal==null)
//     	{
//     		return "项目目标信息不存在";
//     	}
//     	//很关键的一步来了~  看哪些指标是需要计算的   1.用户指定的与目前能算的交集~~
//     	for(i=0;i<indiInfoList.size();i++)
//     	{
//     		indiInfoList.get(i).setNeed(false);
//     	}
//     	indiInfoList.get(0).setNeed(true);//1.1.1
//     	indiInfoList.get(1).setNeed(true);//1.1.2
//     	indiInfoList.get(2).setNeed(true);//1.2.1  安全水
//     	indiInfoList.get(7).setNeed(true);//1.4.3
//     	indiInfoList.get(9).setNeed(true);//2.1.1  9森林覆盖率
//     	indiInfoList.get(10).setNeed(true);//2.2.1 10 退化土地占总土地面积比例
//     	indiInfoList.get(11).setNeed(true);//2.3.1
//     	indiInfoList.get(12).setNeed(true);//3.1.1
//     	indiInfoList.get(13).setNeed(true);//3.2.1
//     	indiInfoList.get(17).setNeed(true);//3.5.2
//     	indiInfoList.get(19).setNeed(true);//3.7.1
//     	indiInfoList.get(20).setNeed(true);//3.7.2
//     	indiInfoList.get(22).setNeed(true);//3.8.1 	
//     	Indicators indiArr[]=new Indicators[yearNum*11];
//     	//System.out.println("outIndex="+outIndex);
//     	
//     	int indiIndex=0;
//     	int modeloutindex;
//     	double GDP;//总产值(元)
//     	double waterDemand;//总需水量(m3)
//     	double POP=0;// 区域总人口数量(万人)
//     	double Area;// 山地所在区域总面积(km2)   	
//     	double baseNeedSurWater[]=new double[10];
//     	double baseNeedGWater[]=new double[10];
//     	double baseForestArea;
//     	double baseGrassArea;
//     	double agrivalue[]=new double[10];
//     	double indivalue[]=new double[10];
//     	double servalue[]=new double[10];
//     	double empr[]=new double[10];
//     	double agriarea[]=new double[10];
//     	double indiarea[]=new double[10];
//     	double serarea[]=new double[10];
//     	double waterP[]=new double[10];
//     	double indiarear,serarear,waterpr;
//     	double safewaterpop;
//     	double agrivaluer;
//     	double indivaluer;
//     	double servaluer;
//     	double surwaterr;
//     	double emprr;
//     	double gwaterr;
//     	double surwaterOffer;
//     	double gwaterOffer;
//     	double safewaterr;
//     	double safewaterr_year;
//     	double safepop;
//     	double x0,xm,r;
//     	double forestr,forestr_year,grassr,grassr_year,greenarea;
//     	double emppopr;//当年的就业率
//     	double lameda,negak,urbanr;
//     	double agriwater,agriwaterb;
//     	double agriareareult,agrarear;
//     	double baseSurWater,baseUGWater,agrivalueyy,indivalueyy,servalueyy,waterpricey;
//        double agrareagq,indiareagq,serareagq;
//        double forestbase,forestmax,forestk,grassbase,grassmax,grassk,barebase,baremax,barek,inditemp;
//     	
//      //用于计算流域指标的变量
//        double allEcoWater[]=new double[10*yearNum];
//        double allWaterNeed[]=new double[10*yearNum];
//        double allSurWaterOffer[]=new double[10*yearNum];
//        double allGroundWaterOffer[]=new double[10*yearNum];
//        double allSafeWaterPop[]=new double[10*yearNum];
//        double allForestArea[]=new double[10*yearNum];
//        double allGrassArea[]=new double[10*yearNum];
//        double allArea[]=new double[10];
//        double allBareArea[]=new double[10*yearNum];
//        double allPop[]=new double[10*yearNum];
//        double allEmpPop[]=new double[10*yearNum];
//        double allUrbanPop[]=new double[10*yearNum];
//        double allAgriArea[]=new double[10*yearNum];
//        double allAgriValue[]=new double[10*yearNum];
//        double allAgriWater[]=new double[10*yearNum];
//        double allCropET[]=new double[10*yearNum];
//        double allGDP[]=new double[10*yearNum];
//     	for(countyIndex=0;countyIndex<10;countyIndex++)//每个区县
//     	{
//     		countyId=climateArr[countyIndex].getCountyId();
//     		indiPara=(IndicatorPara)indiparaMap.get(countyId);
//     		land=(LandPara)allLand.get(countyId);
//     		water=(WaterPara)allWater.get(countyId);
//     		eco=(EcoPara)allEco.get(countyId);
//     		agrivalue[countyIndex]=Double.parseDouble(indiPara.getAgrivalue());
//     		indivalue[countyIndex]=Double.parseDouble(indiPara.getIndivalue());
//     		servalue[countyIndex]=Double.parseDouble(indiPara.getServalue());
//     		baseNeedSurWater[countyIndex]=Double.parseDouble(indiPara.getBaseNeedSurWater());
//     		baseNeedGWater[countyIndex]=Double.parseDouble(indiPara.getBaseNeedGWater());
//     		
//
//     		forestbase=Double.parseDouble(indiPara.getForestArea());
//     		forestmax=Double.parseDouble(indiPara.getForestmax());
//     		forestk=Double.parseDouble(land.getLandForestR());
//     		
//     		grassbase=Double.parseDouble(indiPara.getGrassArea());
//     		grassmax=Double.parseDouble(indiPara.getGrassmax());
//     		grassk=Double.parseDouble(land.getLandGrassR());
//     		
//     		barebase=Double.parseDouble(indiPara.getBarebase());
//     		baremax=Double.parseDouble(indiPara.getBaremax());
//     		barek=Double.parseDouble(land.getWaterArea());
//     		
//     		safewaterr=Double.parseDouble(water.getWaterdistribution());//安全饮用水人口年增长率
//     		safewaterr_year=safewaterr/100;
//     		safewaterpop=Double.parseDouble(indiPara.getSafewaterPop());
//     		
//     		x0=Double.parseDouble(indiPara.getPopx0());
//     		xm=Double.parseDouble(indiPara.getPopxm());
//     		r=Double.parseDouble(eco.getPopolicy());//直接用
//     		baseForestArea=Double.parseDouble(indiPara.getForestArea());
//     		baseGrassArea=Double.parseDouble(indiPara.getGrassArea());
//     		forestr=Double.parseDouble(land.getLandForestR());
//     		forestr_year=forestr/yearNum/100;
//     		grassr=Double.parseDouble(land.getLandGrassR());
//     		grassr_year=grassr/yearNum/100;
//     		Area=Double.parseDouble(indiPara.getArea());
//     		lameda=Double.parseDouble(indiPara.getUrbanla());
//     		negak=Double.parseDouble(eco.getNegak());//直接用
//     		agriwater=Double.parseDouble(indiPara.getAgriwater());//农业用水比例
//     		empr[countyIndex]=Double.parseDouble(indiPara.getEmpr());//就业率
//         	agriarea[countyIndex]=Double.parseDouble(indiPara.getFarmArea());//公顷
//         	indiarea[countyIndex]=Double.parseDouble(indiPara.getIndiArea());
//         	serarea[countyIndex]=Double.parseDouble(indiPara.getSerArea());
//         	waterP[countyIndex]=Double.parseDouble(indiPara.getWaterPrice());
//         	allArea[countyIndex]=Area;//新加
//     		for(yearIndex=0;yearIndex<yearNum;yearIndex++)
//     		{
//     			yearInt=timeStart+yearIndex;
//     			indiIndex=countyIndex*yearNum+yearIndex;
//     			//System.out.println("indiIndex="+indiIndex);
//     			modeloutindex=yearIndex*10+countyIndex;
//     			indiArr[indiIndex]=new Indicators();
//     			indiArr[indiIndex].setCountyId(countyId);//~~~~~~~~~~~~~~~~~~~~~
//     			indiArr[indiIndex].setYear(""+yearInt);//~~~~~~~~~~~~~~~~~~~~~
//     			indiArr[indiIndex].setProjectId(projectId);//~~~~~~~~~~~~~~~~~~~~~
//     			surwaterr=Double.parseDouble(modelOutputArr[modeloutindex].getSurWDR())/100;//地表需水变化率
// 				gwaterr=Double.parseDouble(modelOutputArr[modeloutindex].getGWWDR())/100;//地下需水变化率
// 				agrivaluer=Double.parseDouble(modelOutputArr[modeloutindex].getArgValueR())/100;
// 				indivaluer=Double.parseDouble(modelOutputArr[modeloutindex].getIndValueR())/100;
// 				servaluer=Double.parseDouble(modelOutputArr[modeloutindex].getSerValueR())/100;
// 				indiarear=Double.parseDouble(modelOutputArr[modeloutindex].getLandCIR())/100;
// 				serarear=Double.parseDouble(modelOutputArr[modeloutindex].getLandSerR())/100;
// 				waterpr=Double.parseDouble(modelOutputArr[modeloutindex].getWaterPR())/100;
// 				agrarear=Double.parseDouble(modelOutputArr[modeloutindex].getLandFarmR())/100;
// 				emprr=Double.parseDouble(modelOutputArr[modeloutindex].getEmpR())/100;//就业率变化率
// 						
// 				emppopr=empr[countyIndex]*(1+emprr);//当年的就业率
// 				waterpricey=waterP[countyIndex]*(1+waterpr);
// 				agrareagq=agriarea[countyIndex]*(1+agrarear);
// 				indiareagq=agriarea[countyIndex]*(1+indiarear);
// 				serareagq=agriarea[countyIndex]*(1+serarear);
// 				baseSurWater=baseNeedSurWater[countyIndex]*(1+surwaterr);
// 				baseUGWater=baseNeedGWater[countyIndex]*(1+gwaterr);
// 				waterDemand=baseSurWater+baseUGWater;
// 				//GDP数据库里面是亿元为单位
// 				agrivalueyy=agrivalue[countyIndex]*(1+agrivaluer); 				
// 				indivalueyy=indivalue[countyIndex]*(1+indivaluer);
// 				servalueyy=servalue[countyIndex]*(1+servaluer);
// 				GDP=agrivalueyy+indivalueyy+servalueyy;
// 				surwaterOffer=Double.parseDouble(modelOutputArr[modeloutindex].getSurSup());//地表供水
// 				gwaterOffer=Double.parseDouble(modelOutputArr[modeloutindex].getGWSup());//地下供水
// 				
// 				POP=xm/(1+(xm/x0-1)*Math.pow(Math.E, -1*r*yearIndex));//万人
// 				if(countyIndex==9)//额济纳旗  用的是阿拉善的数据，要做一下处理   下辖地区阿拉善左旗、阿拉善右旗、额济纳旗 
// 				{
// 					POP=POP/3;
// 				}
// 				allPop[indiIndex]=POP;
// 				allGDP[indiIndex]=GDP;
// 				allWaterNeed[indiIndex]=waterDemand;
// 				allSurWaterOffer[indiIndex]=surwaterOffer;
// 				allGroundWaterOffer[indiIndex]=gwaterOffer;
// 				allEmpPop[indiIndex]=POP*emppopr;
// 				allAgriValue[indiIndex]=agrivalueyy;
// 				//经济用水
// 				agriwaterb=Float.parseFloat(indiPara.getEcopro())*(surwaterOffer+gwaterOffer);
// 				
// 				allEcoWater[indiIndex]=agriwaterb;
// 				if(indiInfoList.get(0).getNeed())//提高水生产力到b%
//     			{
//     				indiArr[indiIndex].setWaterProductivity(""+(GDP/agriwaterb));//~~~~~~~~~~~~~~~~~~~~~
//     			}
//     			if(indiInfoList.get(1).getNeed())//在各个层次上减小用水压力到m%    waterConsumption/freshWater
//     			{
//     				indiArr[indiIndex].setWaterPressure(""+(waterDemand/(surwaterOffer+gwaterOffer)*100));
//     			}
//     			safepop=safewaterpop*(1+safewaterr_year*yearIndex);
//     			allSafeWaterPop[indiIndex]=safepop;
//     			if(indiInfoList.get(2).getNeed())//提高流域社会安全饮用水人口比例到d%  POPws/POP
//     			{	
//     				indiArr[indiIndex].setSafeDrinkingWaterR(""+(safepop/POP*100));
//     			}
//     			if(indiInfoList.get(7).getNeed())//中游地下水开采量i 亿m3
//     			{
//     				indiArr[indiIndex].setGroundwaterMining(""+gwaterOffer);
//     			}
//     			//森林面积
// 				inditemp=forestmax/(1+((forestmax/forestbase-1)*Math.pow(Math.E, -1*forestk*yearIndex)));
// 				allForestArea[indiIndex]=inditemp;
// 				
//     			if(indiInfoList.get(9).getNeed())//森林覆盖指数b%
//     			{
//     				indiArr[indiIndex].setForestCoverR(""+(inditemp/Area*100));
//     			}
//     			//森林面积+草地面积
//     			inditemp=inditemp+grassmax/(1+((grassmax/grassbase-1)*Math.pow(Math.E, -1*grassk*yearIndex)));
//     			allGrassArea[indiIndex]=inditemp;
//     			if(indiInfoList.get(11).getNeed())//山地绿色覆盖指数b%
//     			{
//     				indiArr[indiIndex].setMountainGreenCoverR(""+(inditemp/Area*100));
//     			}
//     			//土地退化面积
// 				inditemp=baremax/(1+((baremax/barebase-1)*Math.pow(Math.E, -1*barek*yearIndex)));	
// 				allBareArea[indiIndex]=inditemp;
//     			if(indiInfoList.get(10).getNeed())//土地退化
//     			{
//     				indiArr[indiIndex].setForestSustainableR(""+(inditemp/Area*100));
//     			}
//
//     			if(indiInfoList.get(12).getNeed())//人均GDP   万元/万人
//     			{
//     				indiArr[indiIndex].setGdpPerCapita(""+((10000*GDP)/POP));
//     			}
//     			if(indiInfoList.get(13).getNeed())//就业人口人均 GDP
//     			{
//     				indiArr[indiIndex].setGdpPerCapitaEmployed(""+((10000*GDP)/(POP*emppopr)));
//     			}
//     			urbanr=1/(1+lameda*Math.pow(Math.E, negak*(1+yearIndex)))*100;
//     			allUrbanPop[indiIndex]=urbanr/100*POP;
//     			if(indiInfoList.get(17).getNeed())//urbanR 
//     			{
//     				
//     				indiArr[indiIndex].setUrbanR(""+urbanr);
//     			}
//     			agriareareult=agrareagq/666.667;  //公顷转化为万亩
//     			allAgriArea[indiIndex]=agriareareult;
//     			if(indiInfoList.get(22).getNeed())//维持可持续发展的中游耕地面积在e万亩
//     			{
//     				indiArr[indiIndex].setAreaCrop(""+agriareareult);
//     			}
//     			//农业用水
//     			agriwaterb=agriwater*(surwaterOffer+gwaterOffer);
//     			allAgriWater[indiIndex]=agriwaterb;
//     			
//     			if(indiInfoList.get(19).getNeed())//提高农业水生产力到b  Ya 农业总产值 (元)/Qtot 农业总用水量(m3)
//     			{
//     				indiArr[indiIndex].setWaterProductivityAgri(""+agrivalueyy/agriwaterb);
//     			}
//     			if(indiInfoList.get(20).getNeed())//提高农业水利用效率到c% Ea 作物总蒸腾量(m3)/Qtot 农业总用水量(m3)
//     			{
//     				double temp=Double.parseDouble(modelOutputArr[modeloutindex].getCropET())*0.75;
//     				allCropET[indiIndex]=temp;
//     				temp=temp/agriwaterb;
//     				indiArr[indiIndex].setWaterUseEffiAgri(""+temp);
//     			}
//     			indiArr[indiIndex].setPop(""+allPop[indiIndex]);
//     			//模型新加的几个变量放进去！！！！
//     			if(yearIndex>0)
//     			{
//	 				modelOutputArr[modeloutindex].setArgValue(""+agrivalueyy);
//	 				modelOutputArr[modeloutindex].setIndValue(""+indivalueyy);
//	 				modelOutputArr[modeloutindex].setSerValue(""+servalueyy);
//	 				modelOutputArr[modeloutindex].setLandFarm(""+agrareagq);
//	 				modelOutputArr[modeloutindex].setLandCI(""+indiareagq);
//	 				modelOutputArr[modeloutindex].setLandSer(""+serareagq);
//	 				modelOutputArr[modeloutindex].setEmp(""+emppopr);
//	 				modelOutputArr[modeloutindex].setWaterP(""+waterpricey);
//	 				modelOutputArr[modeloutindex].setSurWD(""+baseSurWater);
//	 				modelOutputArr[modeloutindex].setGWWD(""+baseUGWater);
//     			}
//     		}//end of year
//     	}//end of for county
//     	//现在算全流域的
//     	int varIndex;
//     	double varGDP=0,varEcoWater=0,varWaterNeed=0,varSurWaterOffer=0,varGroundWaterOffer=0,varSafeWaterPop=0,
//     	varForestArea=0,varGrassArea=0,varArea=0,varBareArea=0,varPop=0,varEmpPop=0,varUrbanPop=0,varAgriArea=0,varAgriValue=0,
//     	varAgriWater=0,varCropET=0;
//     	for(yearIndex=0;yearIndex<yearNum;yearIndex++)
// 		{
// 			yearInt=timeStart+yearIndex;
// 			indiIndex=10*yearNum+yearIndex;
// 			indiArr[indiIndex]=new Indicators();
// 			indiArr[indiIndex].setCountyId("0");//~~~~~~~~~~~~~~~~~~~~~
// 			indiArr[indiIndex].setYear(""+yearInt);//~~~~~~~~~~~~~~~~~~~~~
// 			indiArr[indiIndex].setProjectId(projectId);//~~~~~~~~~~~~~~~~~~~~~
// 			varGDP=0;
// 			varEcoWater=0;
// 			varWaterNeed=0;
// 			varSurWaterOffer=0;
// 			varGroundWaterOffer=0;
// 			varSafeWaterPop=0;
// 			varForestArea=0;
// 			varGrassArea=0;
// 			varArea=0;
// 			varBareArea=0;
// 			varPop=0;
// 			varEmpPop=0;
// 			varUrbanPop=0;
// 			varAgriArea=0;
// 			varAgriValue=0;
// 			varAgriWater=0;
// 			varCropET=0;
// 			for(countyIndex=0;countyIndex<10;countyIndex++)
// 			{
// 				varIndex=countyIndex*yearNum+yearIndex;//变量的索引
// 				varGDP+=allGDP[varIndex];
// 				varEcoWater+=allEcoWater[varIndex];
// 				varWaterNeed+=allWaterNeed[varIndex];
// 				varSurWaterOffer+=allSurWaterOffer[varIndex];
// 				varGroundWaterOffer+=allGroundWaterOffer[varIndex];
// 				varSafeWaterPop+=allSafeWaterPop[varIndex];
// 		     	varForestArea+=allForestArea[varIndex];
// 		     	varGrassArea+=allGrassArea[varIndex];
// 		     	varArea+=allArea[countyIndex];
// 		     	varBareArea+=allBareArea[varIndex];
// 		     	varPop+=allPop[varIndex];
// 		     	varEmpPop+=allEmpPop[varIndex];
// 		     	varUrbanPop+=allUrbanPop[varIndex];
// 		     	varAgriArea+=allAgriArea[varIndex];
// 		     	varAgriValue+=allAgriValue[varIndex];
// 		     	varAgriWater+=allAgriWater[varIndex];
// 		     	varCropET+=allCropET[varIndex];
// 			}
// 			
// 			
// 			
//				//经济用水
//				if(indiInfoList.get(0).getNeed())//提高水生产力到b%
// 			{
// 				indiArr[indiIndex].setWaterProductivity(""+(varGDP/varEcoWater));//~~~~~~~~~~~~~~~~~~~~~
// 			}
// 			if(indiInfoList.get(1).getNeed())//在各个层次上减小用水压力到m%    waterConsumption/freshWater
// 			{
// 				indiArr[indiIndex].setWaterPressure(""+(varWaterNeed/(varSurWaterOffer+varGroundWaterOffer)*100));
// 			}
// 			if(indiInfoList.get(2).getNeed())//提高流域社会安全饮用水人口比例到d%  POPws/POP
// 			{
// 				indiArr[indiIndex].setSafeDrinkingWaterR(""+(varSafeWaterPop/varPop*100));
// 			}
// 			if(indiInfoList.get(7).getNeed())//中游地下水开采量i 亿m3
// 			{
// 				indiArr[indiIndex].setGroundwaterMining(""+varGroundWaterOffer);
// 			}
// 			
// 			if(indiInfoList.get(9).getNeed())//森林覆盖指数b%
// 			{
// 				indiArr[indiIndex].setForestCoverR(""+(varForestArea/varArea*100));
// 			}
// 			if(indiInfoList.get(11).getNeed())//山地绿色覆盖指数b%
// 			{
// 				indiArr[indiIndex].setMountainGreenCoverR(""+((varForestArea+varGrassArea)/varArea*100));
// 			}	
// 			if(indiInfoList.get(10).getNeed())//土地退化
// 			{
// 				indiArr[indiIndex].setForestSustainableR(""+(varBareArea/varArea*100));
// 			}
//
// 			if(indiInfoList.get(12).getNeed())//人均GDP   万元/万人
// 			{
// 				indiArr[indiIndex].setGdpPerCapita(""+((10000*varGDP)/varPop));
// 			}
// 			if(indiInfoList.get(13).getNeed())//就业人口人均 GDP
// 			{
// 				indiArr[indiIndex].setGdpPerCapitaEmployed(""+((10000*varGDP)/varEmpPop));
// 			}
// 			if(indiInfoList.get(17).getNeed())//urbanR 
// 			{
// 				indiArr[indiIndex].setUrbanR(""+varUrbanPop/varPop*100);
// 			}
// 			
// 			if(indiInfoList.get(22).getNeed())//维持可持续发展的中游耕地面积在e万亩
// 			{
// 				indiArr[indiIndex].setAreaCrop(""+varAgriArea);
// 			}
// 			if(indiInfoList.get(19).getNeed())//提高农业水生产力到b  Ya 农业总产值 (元)/Qtot 农业总用水量(m3)
// 			{
// 				indiArr[indiIndex].setWaterProductivityAgri(""+varAgriValue/varAgriWater);
// 			}
// 			if(indiInfoList.get(20).getNeed())//提高农业水利用效率到c% Ea 作物总蒸腾量(m3)/Qtot 农业总用水量(m3)
// 			{
// 				indiArr[indiIndex].setWaterUseEffiAgri(""+varCropET/varAgriWater);
// 			}
// 			indiArr[indiIndex].setPop(""+varPop);
//
// 		}//end of year
//     	//计算完成，就要存数据库啦！
//     	//先把项目对应输出删干净
//     	modelFunctionService.deleteModelOutput(projectId);
//     	outIndex=yearNum*10;
//     	for(i=0;i<outIndex;i++)
//     	{
//     		modelFunctionService.insertModelOutput(modelOutputArr[i]);
//     	}
//     	//存指标
//     	outIndex=11*yearNum;
//     	modelFunctionService.deletIndicatorOutputbyProjectId(projectId);
//     	for(i=0;i<outIndex;i++)
//     	{
//     		modelFunctionService.insertIndicatorOutput(indiArr[i]);
//     	}	
//     	
//     	//开始评价了
//    	
//		String path="";
//		String flagstr=""; 
//		if(flag1==true)
//		{
//			flag1=false;
//			path="/opt/oldmodel/eval1/";
//			flagstr="flag1";
//			
//		}
//		else if(flag2==true)
//		{
//			flag2=false;
//			path="/opt/oldmodel/eval2/";
//			flagstr="flag2";
//			
//		}
//		else if(flag3==true)
//		{
//			flag3=false;
//			path="/opt/oldmodel/eval3/";
//			flagstr="flag3";
//			
//		}
//		else if(flag4==true)
//		{
//			flag4=false;
//			path="/opt/oldmodel/eval4/";
//			flagstr="flag4";
//			
//		}
//		else if(flag5==true)
//		{
//			flag5=false;
//			path="/opt/oldmodel/eval5/";
//			flagstr="flag5";
//			
//		}
//		else
//		{
//			return "评价程序都被占用，请稍后再试！";
//		}
//		
//		//查询数据库，组合评价python程序需要的字符串，修改两个文件，运行程序，得到输出字符串，解析输出字符串，存到评分数据库表
//		     	int gw1,gw2,gw3;
//		     	String gwstr1=goal.getGoal_1();
//		     	String gwstr2=goal.getGoal_2();
//		     	String gwstr3=goal.getGoal_3();
//		     	if(gwstr1.equals("undefined") || gwstr1.equals("undefined") || gwstr1.equals("undefined"))
//		     	{
//		     		setFlag(flagstr);
//		     		return "项目目标权重未指定";
//		     	}
//		     	gw1=Integer.parseInt(gwstr1);
//		     	gw2=Integer.parseInt(gwstr2);
//		     	gw3=Integer.parseInt(gwstr3);
//		     	int temp=gw1+gw2+gw3;
//		     	if(temp!=100)
//		     	{
//		     		setFlag(flagstr);
//		     		return "目标权重之和应等于100";
//		     	}
//		     	float fgw1=(float) (gw1*0.01);
//		     	float fgw2=(float) (gw2*0.01);
//		     	float fgw3=(float) (gw3*0.01);
//		     	
//		     	String wstr=""+fgw1+" "+fgw2+" "+fgw3;
//		     	
//		    	//很关键的一步来了~  看哪些指标是需要计算的   1.用户指定的与目前能算的交集~~
//		    	for(i=0;i<indiInfoList.size();i++)
//		    	{
//		    		indiInfoList.get(i).setNeed(false);
//		    	}
//		    	indiInfoList.get(0).setNeed(true);//1.1.1
//		     	indiInfoList.get(1).setNeed(true);//1.1.2
//		     	indiInfoList.get(2).setNeed(true);//1.2.1  安全水
//		     	indiInfoList.get(7).setNeed(true);//1.4.3
//		     	indiInfoList.get(9).setNeed(true);//2.1.1  9森林覆盖率
//		     	indiInfoList.get(10).setNeed(true);//2.2.1 10 退化土地占总土地面积比例
//		     	indiInfoList.get(11).setNeed(true);//2.3.1
//		     	indiInfoList.get(12).setNeed(true);//3.1.1
//		     	indiInfoList.get(13).setNeed(true);//3.2.1
//		     	indiInfoList.get(17).setNeed(true);//3.5.2
//		     	indiInfoList.get(19).setNeed(true);//3.7.1
//		     	indiInfoList.get(20).setNeed(true);//3.7.2
//		     	indiInfoList.get(22).setNeed(true);//3.8.1
//		     	String indiindex[]=new String[] {"1.1.1","1.1.2","1.2.1","1.4.3","2.1.1","2.2.1","2.3.1","3.1.1","3.2.1","3.5.2","3.7.1","3.7.2","3.8.1"};
//		     	int goal1num=4,goal2num=3,goal3num=6;
//		    	String numStr=goal1num+" "+goal2num+" "+goal3num;
//		    	String firstline="5";
//		    	i=0;
//		    	modelFunctionService.deleteIndicatorWeithtbyProjectId(projectId);
//		    	IndicatorWeight iw=new IndicatorWeight();
//
//			    for(;i<indiInfoList.size();i++)
//			    {
//			    	if(indiInfoList.get(i).getNeed()!=null && indiInfoList.get(i).getNeed()==true)
//			    	{
//			    		firstline=firstline+"\t"+indiInfoList.get(i).getDirection();
//			    	}
//			    }	   
//			    String lineArr[]=new String[yearNum];//计算一个县的
//			    AssessResult scoreArr[]=new AssessResult[outIndex];//完整的结果
//			    Indicators indicator;
//			    
//			    for(i=0;i<outIndex;i++)
//			    {
//			    	scoreArr[i]=new AssessResult();
//			    }
//			    int index=0;
//			    for(int cIndex=0;cIndex<11;cIndex++)
//			    {
//				    for(i=0;i<yearNum;i++) //i 是行号   index是结果数组序号
//				    {
//				    	index=cIndex*yearNum+i; //指标数组是 for县for年
//				    	scoreArr[index].setProjectId(projectId);
//				    	scoreArr[index].setCountyId(indiArr[index].getCountyId());
//				    	scoreArr[index].setYear(indiArr[index].getYear());
//				    	
//				    	lineArr[i]=indiArr[index].getYear()+"\t";
//				    	if(indiInfoList.get(0).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getWaterProductivity()+"\t";
//				    	}
//				    	if(indiInfoList.get(1).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getWaterPressure()+"\t";
//				    	}
//				    	if(indiInfoList.get(2).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getSafeDrinkingWaterR()+"\t";
//				    	}
//				    	if(indiInfoList.get(7).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getGroundwaterMining()+"\t";
//				    	}
//				    	if(indiInfoList.get(9).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getForestCoverR()+"\t";
//				    	}
//				    	if(indiInfoList.get(10).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getForestSustainableR()+"\t";
//				    	}
//				    	if(indiInfoList.get(11).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getMountainGreenCoverR()+"\t";
//				    	}
//				    	
//				    	if(indiInfoList.get(12).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getGdpPerCapita()+"\t";
//				    	}
//				    	if(indiInfoList.get(13).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getGdpPerCapitaEmployed()+"\t";
//				    	}
//				    	if(indiInfoList.get(17).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getUrbanR()+"\t";
//				    	}
//				    	if(indiInfoList.get(19).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getWaterProductivityAgri()+"\t";
//				    	}
//				    	if(indiInfoList.get(20).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getWaterUseEffiAgri()+"\t";
//				    	}
//				    	if(indiInfoList.get(22).getNeed())
//				    	{
//				    		lineArr[i]=lineArr[i]+indiArr[index].getAreaCrop()+"\t";
//				    	}
//				    	lineArr[i]=lineArr[i].substring(0,lineArr[i].length()-1);//去掉最后一个 \t符号
//				    }
//				    //测试写文件
//				    String outArr[]=null;
//				    String score[]=null;
//				    ///////////////////////运行 评价模型  python的代码   只能在服务器上测试！！！/////////////////////////////
//				    String msg = new String();
//					String fileName1 = new String();
//					String fileNameGN = new String();
//					String filePy = new String();
//					String exePy = new String();
//															
//					fileName1 = path+"datacal.txt";
//		    		fileNameGN = path+"goals_number.txt";
//		    		filePy = path+"evalmodel_objective.py";
//
//		    		exePy = "/usr/bin/python";
//		    		
//					//解析传入参数, 写入参数文件
//				    BufferedWriter bufferedWriter = null;
//				    BufferedWriter bufferedWriterGN = null;
//				    File f = new File(fileName1);
//					File fGN = new File(fileNameGN);
//					
//					String wfile=path+"goalweight.txt";
//		    		BufferedWriter wWriter = null;
//		    		File wf=new File(wfile);
//		    		
//					try{
//						if(!f.exists()){
//							f.createNewFile();
//						}
//						if(!fGN.exists()){
//							fGN.createNewFile();
//						}
//						if(!wf.exists()){
//							wf.createNewFile();
//						}
//						wWriter=new BufferedWriter(new FileWriter(wf, false));
//						wWriter.write(wstr);
//						
//						bufferedWriterGN = new BufferedWriter(new FileWriter(fGN, false));
//						bufferedWriterGN.write(numStr);
//						bufferedWriterGN.newLine();
//					    bufferedWriter = new BufferedWriter(new FileWriter(f,false));
//					    bufferedWriter.write(firstline);
//				    	bufferedWriter.newLine(); 
//				    	for(i=0;i<yearNum-1;i++)
//				    	{
//				    		bufferedWriter.write(lineArr[i]);
//					    	bufferedWriter.newLine(); 
//				    	}
//				    	bufferedWriter.write(lineArr[i]);
//			        }
//					catch (FileNotFoundException ex) {
//					    ex.printStackTrace();
//					    setFlag(flagstr);
//					    return "写输入文件出错-文件不存在";
//					} 
//					catch (IOException ex) {
//						ex.printStackTrace();
//						setFlag(flagstr);
//						return "写输入文件出错";
//					} 
//					finally {
//					    //Close the bufferWritter
//					    try {
//					        if (bufferedWriter != null) {
//					        	bufferedWriter.flush();
//					        	bufferedWriter.close();
//					        }
//					        if (bufferedWriterGN != null) {
//					        	bufferedWriterGN.flush();
//					        	bufferedWriterGN.close();
//					        }
//					        if (wWriter != null) {
//					        	wWriter.flush();
//					        	wWriter.close();
//					        }
//					    } 
//					    catch (IOException ex) {
//					        ex.printStackTrace();
//					        setFlag(flagstr);
//					        return "关闭文件出错";
//					    }
//	
//				    }
//					
//					msg += "write input data successfully!";
//	
//					//运行py模型
//					Runtime rt = Runtime.getRuntime();
//					String[] cmds = new String[]{exePy, filePy, fileName1};
//			        Process p;  
//			        StringBuilder sb = new StringBuilder();    
//			        try    
//			        {    
//			        	//执行py
//			        	p = rt.exec(cmds);
//			        	try {
//			        		p.waitFor();
//			        	} catch (InterruptedException intexc) {
//			        		msg += "Interrupted Exception on waitFor: " + intexc.getMessage();
//			        		System.out.println("Interrupted Exception on waitFor: " + intexc.getMessage());
//			        		setFlag(flagstr);
//			        		return "1执行python程序出错"+msg;
//			        	}
//			            //取得命令结果的输出流    
//			             InputStream fis=p.getInputStream();    
//			            //用一个读输出流类去读    
//			             InputStreamReader isr=new InputStreamReader(fis);    
//			            //用缓冲器读行    
//			             BufferedReader br=new BufferedReader(isr);    
//			             String line=null;    
//			            //直到读完为止    
//			    		if( System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1 ) {
//			                sb.append("Flagtotalclass= [ 2.  2.  3.  3.  3.  3.  2.  3.  3.  2.]");
//			                sb.append("Flaggoal1class= [ 2.  2.  3.  3.  3.  3.  2.  3.  3.  2.]");
//			                sb.append("Flaggoal2class= [ 3.  2.  3.  2.  2.  2.  3.  2.  3.  3.]");
//			                sb.append("Flaggoal3class= [ 2.  2.  3.  2.  2.  2.  2.  2.  3.  3.]");
//			            }else{
//			                while((line=br.readLine())!=null)    
//			                {    
//			                	sb.append(line);
//			                }
//			            } 
//			        }
//			        catch (IOException e)    
//			        {    
//			        	msg  += e.getMessage();
//			            e.printStackTrace();    
//			            setFlag(flagstr);
//			            return "2执行python程序出错"+msg;
//			        }
//			        msg += "  run py done!";
//			        System.out.println(msg);    
//	
//			        if(!(sb.toString().contains("[") && sb.toString().contains("]")))
//			        {
//			        	setFlag(flagstr);
//			        	return path+":输出命令窗口并未包含[]"+sb.toString();
//			        }
//			        try {
//				    outArr=sb.toString().split("]");
//				    
//					for(i=0;i<4;i++)//前四个是index
//					{
//						outArr[i]=outArr[i].replaceAll(" +"," ");
//						outArr[i]=outArr[i].substring(outArr[i].indexOf("[")+1, outArr[i].length());
//						if(outArr[i].substring(0, 1).equals(" "))
//						{
//							outArr[i]=outArr[i].substring(1, outArr[i].length());
//						}
//				    	score=outArr[i].split(" ");
//				    	for(j=0;j<yearNum;j++) //现在结果只有 yearNum列
//				    	{
//				    		index=cIndex*yearNum+j;
//				    		if(i==0)
//				    		{
//				    			scoreArr[index].setGoal1index(score[j]);
//				    		}
//				    		else if(i==1)
//				    		{
//				    			scoreArr[index].setGoal2index(score[j]);
//				    		}
//				    		else if(i==2)
//				    		{
//				    			scoreArr[index].setGoal3index(score[j]);
//				    		}
//				    		else if(i==3)
//				    		{
//				    			scoreArr[index].setTotalindex(score[j]);
//				    		}
//				    	}
//					}
//				    
//					    for(i=4;i<8;i++)//后四个是grade
//					    {
//					    	outArr[i] = outArr[i].replace(" ", "");
//					    	score=outArr[i].split("\\.");// 取得 .号分开的多个子字符串
//					    	score[0]=score[0].substring(score[0].length()-1);//第一个字串 形如Flagtotalclass=[2 取最后一个字符即可
//					    	for(j=0;j<yearNum;j++)
//					    	{
//					    		index=cIndex*yearNum+j;
//					    		if(i==4)
//					    		{
//					    			scoreArr[index].setTotalscore(score[j]);
//					    		}
//					    		else if(i==5)
//					    		{
//					    			scoreArr[index].setGoal1score(score[j]);
//					    		}
//					    		else if(i==6)
//					    		{
//					    			scoreArr[index].setGoal2score(score[j]);
//					    		}
//					    		else if(i==7)
//					    		{
//					    			scoreArr[index].setGoal3score(score[j]);
//					    		}
//					    	}
//					    }
//			        }
//			        catch(Exception e)
//			        {
//			        	setFlag(flagstr);
//			 			return e.getMessage()+"长度"+outArr.length+path+"输出"+sb.toString();
//			        }	
//			      //把读取权重的加到这里
//			     	try
//			 		{
//			 			BufferedReader ecobr=new BufferedReader(new FileReader(path+"index_weight.txt"));
//			 			for(i=0;i<13;i++)
//			 			{
//			 				iw.setProjectId(projectId);
//			 				iw.setCountyId(scoreArr[index].getCountyId());
//			 				iw.setIndicatorindex(indiindex[i]);
//			 				iw.setWeight(ecobr.readLine());
//			 				modelFunctionService.insertIndicatorWeight(iw);//数据库插入 项目，县对应的权重
//			 			}
//			 			ecobr.close();
//			 		}
//			 		catch(Exception e)
//			 		{
//			 			System.out.println(e.toString());
//			 			return "提取指标权重 index_weight.txt 出错";
//			 		}
//
//			    }//end of for
//			    //计算完了再操作数据库
//					modelFunctionService.deleteAssessResultbyProjectId(projectId);
//					for(i=0;i<outIndex;i++)
//					{
//						modelFunctionService.insertScores(scoreArr[i]);
//					}
//			    
//				setFlag(flagstr);
/////////////////////////运行 评价模型  python的代码   只能在服务器上测试！！！   done/////////////////////////////		       	    	
//     	return "计算完毕，模型输出、指标输出、评价输出均存入了数据库";
//     }
//}
