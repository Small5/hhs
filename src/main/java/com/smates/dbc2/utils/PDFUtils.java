package com.smates.dbc2.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class PDFUtils {

	public static void toPdfWithMap()
			throws IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		Template temp = cfg.getTemplate("/home/page/report.ftl");
		Map<String, String> root = new HashMap<String, String>();
//		root.put("第一章  黑河流域","");
//		root.put("1.1  概况","");
//		root.put("    ","黑河流域是我国西北地区第二大内陆流域，位于河西走廊中部，为甘蒙西部最大的内陆河流域。");
//		root.put("    ","黑河发源于南部祁连山区，分东西两支：东支为干流，上游分东西两岔，东岔俄博河又称八宝河，源于俄博滩东的锦阳岭，"
//				+ "自东向西流长80余公里，西岔野牛沟，源于铁里干山，由西向东流长190余公里，东西两岔汇于黄藏寺折向北流称为甘州河，"
//				+ "流程90km至莺落峡进入走廊平原，始称黑河，上述流域为黑河(干流)的上游。西支源于陶勒寺，上游称讨赖河，也有东西两岔，"
//				+ "于朱龙庙附近汇合，称北大河（或临水河）。黑河从莺落峡进入河西走廊,于张掖市城西北10km附近，纳山丹河、洪水河，"
//				+ "流向西北，经临泽、高台汇梨园河、摆浪河穿越正义峡（北山），进入阿拉善平原。莺落峡至正义峡流程185km，"
//				+ "为黑河（干流）的中游。黑河流经正义峡谷后，在甘肃金塔县境内的鼎新与北大河汇合，"
//				+ "北流150km至内蒙古自治区额济纳旗境内的狼心山西麓，又分为东西两河，"
//				+ "东河（达西敖包河）向北分八个支流（纳林河、保都格河、昂茨河等）呈扇形注入东居延海（索果淖尔）；"
//				+ "西河（穆林河）向北分五条支流（龚子河、科立杜河、马蹄格格河等）注入西居延海（嘎顺淖尔）。");
//		root.put("    ","黑河从发源地到居延海全长 821km，横跨三种不同的自然环境单元，流域面积约14.29万km2 ，"
//				+ "北部与蒙古接壤，东以大黄山与武威盆地相连，西部以黑山与疏勒河流域毗邻。分属三省（区），上游属青海省祁连县，"
//				+ "中游属甘肃山丹、民乐、张掖、临泽、高台、肃南、酒泉等市县，下游属甘肃金塔和内蒙古自治区额济纳旗。");

		// 合并模板和数据模型
		
		String file1 = "/home/page/pdf/contractTemplate.html";  
        File file = new File(file1);  
        if (!file.exists())  
            file.createNewFile();  
        // Writer out = new FileWriter(file);  
        Writer out = new BufferedWriter(new OutputStreamWriter(  
                new FileOutputStream(file), "utf-8")); 
		temp.process(root, out);
		out.flush();
		
		
		String url = new File(file1).toURI().toURL().toString();  
        String outputFile = "/home/page/pdf/Test.pdf";  
		OutputStream os = new FileOutputStream(outputFile);
		
//		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//		Document doc = builder.parse(new ByteArrayInputStream(out.toString().getBytes()));
//
//		renderer.setDocument(doc, null);
		
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocument(url);
		

		// 解决中文支持问题
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("/home/page/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		// 解决图片的相对路径问题
		renderer.getSharedContext().setBaseURL("file:/home/page/");

		renderer.layout();
		renderer.createPDF(os);

		os.close();

	}

}
