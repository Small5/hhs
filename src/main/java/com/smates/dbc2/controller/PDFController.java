package com.smates.dbc2.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.lf5.util.StreamUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.smates.dbc2.utils.PDFUtils;

import freemarker.template.TemplateException;

/**
 * PDF文件下载
 * @author baijw
 *
 */
@Controller
public class PDFController {
	
	@RequestMapping(value="downPDF",method=RequestMethod.GET)
	public void downPDF(HttpServletResponse response) throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException{
		
		PDFUtils.toPdfWithMap();
		File file = new File("/home/page/pdf/Test.pdf");
		if (file.exists()) {
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			StreamUtils.copyThenClose(new FileInputStream(file), response.getOutputStream());
		} else {
			response.setStatus(404);
		}
	}

}
