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
import com.smates.dbc2.service.IndicatorsService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;



@Service
public class ExcelUtils2 {

	@Autowired
	private IndicatorsService indicatorsService;
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
		cell.setCellValue("提高水生产力到b%");
		// cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("在各个层次上减小用水压力到m%");
		// cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("提高流域社会安全饮用水人口比例到d%");
		// cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("集成水资源管理执行度d%");
		cell = row.createCell(7);
		cell.setCellValue("跨边界流域可操作合约有效性e%");
		cell = row.createCell(8);
		cell.setCellValue("维持流域可持续湿地面积d万亩");
		cell = row.createCell(9);
		cell.setCellValue("维持下游可持续生态系统发展所需最小分水量f亿m³");
		cell = row.createCell(10);
		cell.setCellValue("中游地下水开采量i亿m³");
		cell = row.createCell(11);
		cell.setCellValue("中游生态系统用水量j亿m³");
		cell = row.createCell(12);
		cell.setCellValue("森林覆盖率b%");
		cell = row.createCell(13);
		cell.setCellValue("可持续森林管理覆盖b%");
		cell = row.createCell(14);
		cell.setCellValue("山地绿色覆盖指数b%");
		cell = row.createCell(15);
		cell.setCellValue("人均GDP");
		cell = row.createCell(16);
		cell.setCellValue("就业人口人均 GDP");
		cell = row.createCell(17);
		cell.setCellValue("年轻人（15-24）在教育，就业和培训中的比例");
		cell = row.createCell(18);
		cell.setCellValue("旅游业产值在 GDP 中的比例");
		cell = row.createCell(19);
		cell.setCellValue("土地利用率(土地消耗率与人口增长率的比率)");
		cell = row.createCell(20);
		cell.setCellValue("城镇化率(%)");
		cell = row.createCell(21);
		cell.setCellValue("人均社会福利");
		cell = row.createCell(22);
		cell.setCellValue("提高农业水生产力到b");
		cell = row.createCell(23);
		cell.setCellValue("提高农业水利用效率到c%");
		cell = row.createCell(24);
		cell.setCellValue("提高每公顷农产品产值d元");
		cell = row.createCell(25);
		cell.setCellValue("维持可持续发展的中游耕地面积在e万亩");
		cell = row.createCell(26);
		cell.setCellValue("人口（万人）");
		//cell = row.createCell(23);
		//cell.setCellValue("维持可持续的农业种植面积");
		//cell = row.createCell(24);
		//cell.setCellValue("可持续社会福利指数");
		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		List<Indicators> getresults = indicatorsService.getAllIndicators(projectId);

		for (int i = 0; i < getresults.size(); i++) {
			row = sheet.createRow((int) i + 1);
			Indicators indicators = getresults.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(indicators.getProjectId());
			row.createCell(1).setCellValue(indicators.getCountyId());
			row.createCell(2).setCellValue(indicators.getYear());
			row.createCell(3).setCellValue(indicators.getWaterProductivity());
			row.createCell(4).setCellValue(indicators.getWaterPressure());
			row.createCell(5).setCellValue(indicators.getSafeDrinkingWaterR());
			row.createCell(6).setCellValue(indicators.getIwrmR());
			row.createCell(7).setCellValue(indicators.getTransboundaryAvailability());
			row.createCell(8).setCellValue(indicators.getAreaWetland());
			row.createCell(9).setCellValue(indicators.getWaterDemandEco());
			row.createCell(10).setCellValue(indicators.getGroundwaterMining());
			row.createCell(11).setCellValue(indicators.getWaterUseEco());
			row.createCell(12).setCellValue(indicators.getForestCoverR());
			row.createCell(13).setCellValue(indicators.getForestSustainableR());
			row.createCell(14).setCellValue(indicators.getMountainGreenCoverR());
			row.createCell(15).setCellValue(indicators.getGdpPerCapita());
			row.createCell(16).setCellValue(indicators.getGdpPerCapitaEmployed());
			row.createCell(17).setCellValue(indicators.getYouthEmpR());
			row.createCell(18).setCellValue(indicators.getGdpTourismR());
			row.createCell(19).setCellValue(indicators.getLandPopuR());
			row.createCell(20).setCellValue(indicators.getUrbanR());
			row.createCell(21).setCellValue(indicators.getAvgWelfare());
			row.createCell(22).setCellValue(indicators.getWaterProductivityAgri());
			row.createCell(23).setCellValue(indicators.getWaterUseEffiAgri());
			row.createCell(24).setCellValue(indicators.getAgriOutputPerHectare());
			row.createCell(25).setCellValue(indicators.getAreaCrop());
			row.createCell(26).setCellValue(indicators.getPop());
			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// // 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/indicators.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
