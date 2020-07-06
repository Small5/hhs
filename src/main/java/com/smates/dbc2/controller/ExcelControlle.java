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

import com.smates.dbc2.utils.ExcelUtils;
import com.smates.dbc2.utils.ExcelUtils2;

/**
 * 下载Excel的类
 * @author March march.machao@gmail.com
 *
 */
@Controller
public class ExcelControlle {

	@Autowired
	private ExcelUtils excelUtils;

	@RequestMapping("downexcel1")
	public void downExcel(HttpServletResponse response) throws FileNotFoundException, IOException {
		excelUtils.outputExcel();
		File file = new File("/home/page/excel/result.xls");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
	}
	
}
