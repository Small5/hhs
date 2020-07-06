package com.smates.dbc2.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.po.Indicators;
import com.smates.dbc2.po.TestManyOutput;
import com.smates.dbc2.service.IndicatorsService;
import com.smates.dbc2.service.TestManyOutPutService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;



@Service
public class ExcelUtils3 {

	@Autowired
	private TestManyOutPutService testManyOutPutService;
	@Autowired
	public UserProjectRelationService userProjectRelationService;
	@Autowired
	public UserService userService;

	public void outputExcel() {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		// HSSFCellStyle style = wb.createCellStyle();
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("项目ID");
		cell = row.createCell(1);
		cell.setCellValue("县区ID");
		cell = row.createCell(2);
		cell.setCellValue("年份");
		cell = row.createCell(3);
		cell.setCellValue("温度变化℃");
		// cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("降水变化率%");
		// cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("耕地面积变化率%");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("农业技术进步率%");
		cell = row.createCell(7);
		cell.setCellValue("正义峡下泄量 亿立方米");
		cell = row.createCell(8);
		cell.setCellValue("莺落峡流量输出 单位：亿立方米");
		cell = row.createCell(9);
		cell.setCellValue("其他河流流量输出 单位：亿立方米");
		cell = row.createCell(10);
		cell.setCellValue("地表供水量 单位：亿立方米");
		cell = row.createCell(11);
		cell.setCellValue("地下供水量 单位：亿立方米");
		cell = row.createCell(12);
		cell.setCellValue("作物蒸散发 单位：亿立方米");
		cell = row.createCell(13);
		cell.setCellValue("农业产值 单位：变化率 %");
		cell = row.createCell(14);
		cell.setCellValue("工业产值 单位：变化率 %");
		cell = row.createCell(15);
		cell.setCellValue("服务业产值 单位：变化率 %");
		cell = row.createCell(16);
		cell.setCellValue("耕地变化率 %");
		cell = row.createCell(17);
		cell.setCellValue("城镇工业用地变化率 单位：%");
		cell = row.createCell(18);
		cell.setCellValue("服务业用地变化率 单位：%");
		cell = row.createCell(19);
		cell.setCellValue("水价变化率 单位：%");
		cell = row.createCell(20);
		cell.setCellValue("就业率 单位：%");
		cell = row.createCell(21);
		cell.setCellValue("地表需水量变化率 单位：%");
		cell = row.createCell(22);
		cell.setCellValue("地下需水量变化率 单位：%");
		cell = row.createCell(23);
		cell.setCellValue("提高水生产力到b%");
		cell = row.createCell(24);
		cell.setCellValue("在各个层次上减小用水压力到m%");
		cell = row.createCell(25);
		cell.setCellValue("提高流域社会安全饮用水人口比例到d%");
		cell = row.createCell(26);
		cell.setCellValue("中游地下水开采量i 亿m3");
		cell = row.createCell(27);
		cell.setCellValue("山地绿色覆盖指数b%");
		cell = row.createCell(28);
		cell.setCellValue("人均GDP");
		cell = row.createCell(29);
		cell.setCellValue("就业人口人均 GDP 增长率");
		cell = row.createCell(30);
		cell.setCellValue("城镇化率");
		cell = row.createCell(31);
		cell.setCellValue("农业水利用效率");
		cell = row.createCell(32);
		cell.setCellValue("农业水生产力");
		cell = row.createCell(33);
		cell.setCellValue("维持可持续农业种植面积");
		cell = row.createCell(34);
		cell.setCellValue("流域可持续发展指数");
		cell = row.createCell(35);
		cell.setCellValue("水资源管理可持续发展指数");
		cell = row.createCell(36);
		cell.setCellValue("生态系统可持续发展指数");
		cell = row.createCell(37);
		cell.setCellValue("社会经济可持续发展指数");
		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		List<TestManyOutput> getresults = testManyOutPutService.getalldatas(projectId);

		for (int i = 0; i < getresults.size(); i++) {
			row = sheet.createRow((int) i + 1);
			TestManyOutput mayoutput = getresults.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(mayoutput.getProjectId());
			row.createCell(1).setCellValue(mayoutput.getCountyId());
			row.createCell(2).setCellValue(mayoutput.getYear());
			row.createCell(3).setCellValue(mayoutput.getTempset());
			row.createCell(4).setCellValue(mayoutput.getPreset());
			row.createCell(5).setCellValue(mayoutput.getCultiarearset());
			row.createCell(6).setCellValue(mayoutput.getCultitechrset());
			row.createCell(7).setCellValue(mayoutput.getDownstreamset());
			row.createCell(8).setCellValue(mayoutput.getFlowYLX());
			row.createCell(9).setCellValue(mayoutput.getFlowOther());
			row.createCell(10).setCellValue(mayoutput.getSurSup());
			row.createCell(11).setCellValue(mayoutput.getGWSup());
			row.createCell(12).setCellValue(mayoutput.getCropET());
			row.createCell(13).setCellValue(mayoutput.getArgValue());
			row.createCell(14).setCellValue(mayoutput.getIndValue());
			row.createCell(15).setCellValue(mayoutput.getSerValue());
			row.createCell(16).setCellValue(mayoutput.getLandFarmR());
			row.createCell(17).setCellValue(mayoutput.getLandCIR());
			row.createCell(18).setCellValue(mayoutput.getLandSerR());
			row.createCell(19).setCellValue(mayoutput.getWaterPR());
			row.createCell(20).setCellValue(mayoutput.getEmpR());
			row.createCell(21).setCellValue(mayoutput.getSurWDR());
			row.createCell(22).setCellValue(mayoutput.getGWWDR());
			row.createCell(23).setCellValue(mayoutput.getWaterProductivity());
			row.createCell(24).setCellValue(mayoutput.getWaterPressure());
			row.createCell(25).setCellValue(mayoutput.getSafeDrinkingWaterR());
			row.createCell(26).setCellValue(mayoutput.getGroundwaterMining());
			row.createCell(27).setCellValue(mayoutput.getMountainGreenCoverR());
			row.createCell(28).setCellValue(mayoutput.getGdpPerCapita());
			row.createCell(29).setCellValue(mayoutput.getGdpPerCapitaEmployed());
			row.createCell(30).setCellValue(mayoutput.getUrbanR());
			row.createCell(31).setCellValue(mayoutput.getWaterUseEffiAgri());
			row.createCell(32).setCellValue(mayoutput.getWaterProductivityAgri());
			row.createCell(33).setCellValue(mayoutput.getAreaCrop());
			row.createCell(34).setCellValue(mayoutput.getTotalindex());
			row.createCell(35).setCellValue(mayoutput.getGoal1index());
			row.createCell(36).setCellValue(mayoutput.getGoal2index());
			row.createCell(37).setCellValue(mayoutput.getGoal3index());
			
			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// // 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/alldatas.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
