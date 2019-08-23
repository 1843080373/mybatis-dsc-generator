package com.ftl.utils;

/**
 * 模板解析实体类
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import com.ftl.pdf.PDFUtil;
import com.github.mybatis.fl.util.FreemarkerUtil;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TemplateParseUtil {
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
		cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/freemarker/templates");
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

	/**
	 * 解析模板返回字节数组
	 * 
	 * @param templateDir  模板目录
	 * @param templateName 模板名称
	 * @param data         数据参数
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static byte[] parse(String templateName, Map<String, Object> data) throws TemplateException, IOException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setNumberFormat("0.00");
		cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/freemarker/templates");
		Template template = cfg.getTemplate(templateName, "utf-8");
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(outStream, "UTF-8");
		template.process(data, out);
		return outStream.toByteArray();
	}

	/**
	 * 自定义模板字符串解析
	 * 
	 * @param templateStr 模板字符串
	 * @param data        数据
	 * @return 解析后的字符串
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String parseStr(String templateName, Map<String, Object> data) throws IOException, TemplateException {
		// 初始化工作
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		// 设置默认编码格式为UTF-8
		cfg.setDefaultEncoding("UTF-8");
		// 全局数字格式
		cfg.setNumberFormat("0.00");
		// 设置模板文件位置
		cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/freemarker/templates");
		// 设置默认字体
		cfg.setDefaultEncoding("utf-8");
		// 获取模板
		Template template = cfg.getTemplate(templateName);
		Writer out = new StringWriter();
		template.process(data, out);
		return out.toString();
	}

	public static void parse2PDF(String templateName, String filePath, Map<String, Object> data) throws Exception {
		String context = parseStr(templateName, data);
		FileOutputStream outFile = new FileOutputStream(filePath);
		new PDFUtil().createPDFFile(context, outFile);
	}
}