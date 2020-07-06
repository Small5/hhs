package com.smates.dbc2.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.lf5.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smates.dbc2.utils.ExcelUtils4;

/**
 * 下载模型运行中间输出结果
 * @author geek_hu
 *
 */
@Controller
public class ExcelControlle4 {

	@Autowired
	private ExcelUtils4 excelUtils4;

	@RequestMapping("downexcelmodel")
	public void downExcel(HttpServletResponse response) throws FileNotFoundException, IOException {
		excelUtils4.outputExcel();
		// File file = new File("/home/page/excel/modelOutput.xls");
		File file = new File("D:\\project\\modelOutput\\modelOutput.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}
	
}
