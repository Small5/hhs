package com.smates.dbc2.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.po.AssessResult;
import com.smates.dbc2.po.Gisecharts;
import com.smates.dbc2.service.GisService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;

@Service
public class ExcelUtils {

	@Autowired
	private GisService gisService;
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
		// cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("流域ID");
		// cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("年份");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("流域可持续发展指数");
		// cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("水资源管理可持续发展指数");
		cell = row.createCell(5);
		cell.setCellValue("生态系统可持续发展指数");
		cell = row.createCell(6);
		cell.setCellValue("社会经济可持续发展指数");
		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		List<AssessResult> gisdata = gisService.getAllGisecharts(projectId);

		for (int i = 0; i < gisdata.size(); i++) {
			row = sheet.createRow((int) i + 1);
			AssessResult gisecharts = gisdata.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(gisecharts.getProjectId());
			row.createCell(1).setCellValue(gisecharts.getCountyId());
			row.createCell(2).setCellValue(gisecharts.getYear());
			row.createCell(3).setCellValue(gisecharts.getTotalindex());
			row.createCell(4).setCellValue(gisecharts.getGoal1index());
			row.createCell(5).setCellValue(gisecharts.getGoal2index());
			row.createCell(6).setCellValue(gisecharts.getGoal3index());
			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// // 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("/home/page/excel/result.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
