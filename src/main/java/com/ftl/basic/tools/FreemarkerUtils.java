package com.ftl.basic.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import com.github.mybatis.fl.util.FreemarkerUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtils {
	/**
	 * 解析模板生成Excel，Doc，html
	 * 
	 * @param templateName 模板名称
	 * @param excelPath    生成的Excel文件路径
	 * @param data         数据参数
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void parse(String templateName, String filePath, Map<String, Object> data)
			throws IOException, TemplateException {
		// 初始化工作
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		// 设置默认编码格式为UTF-8
		cfg.setDefaultEncoding("UTF-8");
		// 全局数字格式
		cfg.setNumberFormat("0.00");
		// 设置模板文件位置
		cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/freemarker/basic");
		// 设置默认字体
		cfg.setDefaultEncoding("utf-8");
		// 获取模板
		Template template = cfg.getTemplate(templateName);
		OutputStreamWriter writer = null;
		try {
			File file = new File(filePath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			// 填充数据至Excel
			writer = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
			template.process(data, writer);
			writer.flush();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
