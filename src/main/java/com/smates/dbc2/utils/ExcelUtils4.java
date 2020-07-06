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
import com.smates.dbc2.po.ModelOutput;
import com.smates.dbc2.service.GisService;
import com.smates.dbc2.service.ModelService;
import com.smates.dbc2.service.UserProjectRelationService;
import com.smates.dbc2.service.UserService;

@Service
public class ExcelUtils4 {

	@Autowired
	private ModelService modelService;
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
		cell.setCellValue("年份");
		// cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("县区编码");
		// cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("莺落峡流量输出 单位：亿立方米");
		// cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("其他河流流量输出");
		cell = row.createCell(5);
		cell.setCellValue("地表水引用量(亿立方米/年)");
		cell = row.createCell(6);
		cell.setCellValue("地下水抽取量(亿立方米/年)");
		cell = row.createCell(7);
		cell.setCellValue("耕地面积ET量(亿立方米/年)");
		cell = row.createCell(8);
		cell.setCellValue("湿地面积");
		cell = row.createCell(9);
		cell.setCellValue("农业产值变化率");
		cell = row.createCell(10);
		cell.setCellValue("工业产值变化率");
		cell = row.createCell(11);
		cell.setCellValue("服务业产值变化率");
		cell = row.createCell(12);
		cell.setCellValue("耕地变化率");
		cell = row.createCell(13);
		cell.setCellValue("城镇工业用地变化率");
		cell = row.createCell(14);
		cell.setCellValue("服务业用地变化率");
		cell = row.createCell(15);
		cell.setCellValue("水价变化率");
		cell = row.createCell(16);
		cell.setCellValue("就业变化率");
		cell = row.createCell(17);
		cell.setCellValue("地表需水量变化率");
		cell = row.createCell(18);
		cell.setCellValue("地下需水量变化率");
		cell = row.createCell(19);
		cell.setCellValue("农业产值(亿元)");
		cell = row.createCell(20);
		cell.setCellValue("工业产值（亿元）");
		cell = row.createCell(21);
		cell.setCellValue("服务业产值（亿元）");
		cell = row.createCell(22);
		cell.setCellValue("耕地面积");
		cell = row.createCell(23);
		cell.setCellValue("城镇工业用地面积");
		cell = row.createCell(24);
		cell.setCellValue("服务业用地面积");
		cell = row.createCell(25);
		cell.setCellValue("水价");
		cell = row.createCell(26);
		cell.setCellValue("就业");
		cell = row.createCell(27);
		cell.setCellValue("地表需水量");
		cell = row.createCell(28);
		cell.setCellValue("地下需水量");
		// // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		String projectId = userProjectRelationService.getUserProjectRelationByUserName(userService.getCurrentUserId()).getAutoProjectId();
		List<ModelOutput> modeloutput = modelService.getAllmodeloutput(projectId);

		for (int i = 0; i < modeloutput.size(); i++) {
			row = sheet.createRow((int) i + 1);
			ModelOutput modeloutputs = modeloutput.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell(0).setCellValue(modeloutputs.getProjectId());
			row.createCell(1).setCellValue(modeloutputs.getYear());
			row.createCell(2).setCellValue(modeloutputs.getCountyId());
			row.createCell(3).setCellValue(modeloutputs.getFlowYLX());
			row.createCell(4).setCellValue(modeloutputs.getFlowOther());
			row.createCell(5).setCellValue(modeloutputs.getSurSup());
			row.createCell(6).setCellValue(modeloutputs.getGWSup());
			row.createCell(7).setCellValue(modeloutputs.getCropET());
			row.createCell(8).setCellValue(modeloutputs.getWetlandArea());
			row.createCell(9).setCellValue(modeloutputs.getArgValueR());
			row.createCell(10).setCellValue(modeloutputs.getIndValueR());
			row.createCell(11).setCellValue(modeloutputs.getSerValueR());
			row.createCell(12).setCellValue(modeloutputs.getLandFarmR());
			row.createCell(13).setCellValue(modeloutputs.getLandCIR());
			row.createCell(14).setCellValue(modeloutputs.getLandSerR());
			row.createCell(15).setCellValue(modeloutputs.getWaterPR());
			row.createCell(16).setCellValue(modeloutputs.getEmpR());
			row.createCell(17).setCellValue(modeloutputs.getSurWDR());
			row.createCell(18).setCellValue(modeloutputs.getGWWDR());
			row.createCell(19).setCellValue(modeloutputs.getArgValue());
			row.createCell(20).setCellValue(modeloutputs.getIndValue());
			row.createCell(21).setCellValue(modeloutputs.getSerValue());
			row.createCell(22).setCellValue(modeloutputs.getLandFarm());
			row.createCell(23).setCellValue(modeloutputs.getLandCI());
			row.createCell(24).setCellValue(modeloutputs.getLandSer());
			row.createCell(25).setCellValue(modeloutputs.getWaterP());
			row.createCell(26).setCellValue(modeloutputs.getEmp());
			row.createCell(27).setCellValue(modeloutputs.getSurWD());
			row.createCell(28).setCellValue(modeloutputs.getGWWD());
			// row.createCell((short) 2).setCellValue((double) stu.getAge());
			// cell = row.createCell((short) 3);
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
		}
		// // 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("D:\\project\\modelOutput\\modelOutput.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
