package com.ftl.pdf;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class PDFUtil {
	private String tempFilePath;
	private String tempFileName;

	public PDFUtil() {
	}

	public PDFUtil(String tempFilePath, String tempFileName) {
		this.tempFilePath = tempFilePath;
		this.tempFileName = tempFileName;
	}

	public String getTempFilePath() {
		return tempFilePath;
	}

	public void setTempFilePath(String tempFilePath) {
		this.tempFilePath = tempFilePath;
	}

	public String getTempFileName() {
		return tempFileName;
	}

	public void setTempFileName(String tempFileName) {
		this.tempFileName = tempFileName;
	}

	public  Map<String, Object> data() throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loanId", "LO123456"); // 订单ID
		paramMap.put("realName", "张三"); // 订单ID
		paramMap.put("cardNo", "110001451121111"); // 订单ID
		paramMap.put("name", "张三"); // 订单ID
		paramMap.put("loanAmount", "56.00"); // 订单ID
		paramMap.put("loanAmountCharacter", "五十六元整"); // 订单ID
		paramMap.put("timeLimit", "3"); // 订单ID
		paramMap.put("interest", "0.88"); // 订单ID
		paramMap.put("bankName", "建设银行"); // 订单ID
		paramMap.put("bankNo", "622655555555"); // 订单ID
		paramMap.put("order_id", "1"); // 订单ID
		return paramMap;
	}

	/**
	 * 填充模板
	 * 
	 * @param paramMap
	 * @throws Exception
	 */
	public String fillTemplate(Map<String, Object> paramMap) throws Exception {
		File modelFile = new File(tempFilePath);
		if (!modelFile.exists()) {
			modelFile.mkdirs();
		}
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDirectoryForTemplateLoading(modelFile);
		configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
		configuration.setDefaultEncoding("UTF-8"); // 这个一定要设置，不然在生成的页面中 会乱码
		// 获取或创建一个模版。
		Template template = configuration.getTemplate(tempFileName);

		StringWriter stringWriter = new StringWriter();
		BufferedWriter writer = new BufferedWriter(stringWriter);
		template.process(paramMap, writer);

		String htmlStr = stringWriter.toString();
		writer.flush();
		writer.close();

		String tmpPath = tempFilePath + "/temp";
		File tmepFilePath = new File(tmpPath);
		if (!tmepFilePath.exists()) {
			tmepFilePath.mkdirs();
		}
		String tmpFileName = System.currentTimeMillis() + ".pdf";
		String outputFile = tmpPath + File.separatorChar + tmpFileName;
		FileOutputStream outFile = new FileOutputStream(outputFile);
		createPDFFile(htmlStr, outFile);

		return outputFile;
	}

	/**
	 * 根据HTML字符串创建PDF文件
	 * 
	 * @param htmlStr
	 * @param outputFile
	 * @throws Exception
	 */
	public void createPDFFile(String htmlStr, OutputStream os) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(htmlStr.getBytes("UTF-8"));
		// step 1
		Document document = new Document();
		try {
			// step 2
			PdfWriter writer = PdfWriter.getInstance(document, os);
			// step 3
			document.open();
			FontProvider provider = new FontProvider();
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, bais, Charset.forName("UTF-8"), provider);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				document.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				bais.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 字体
	 *
	 */
	private class FontProvider extends XMLWorkerFontProvider {

		public Font getFont(final String fontname, final String encoding, final boolean embedded, final float size,
				final int style, final BaseColor color) {
			BaseFont bf = null;
			try {
				bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Font font = new Font(bf, size, style, color);
			font.setColor(color);
			return font;
		}
	}

	/**
	 * 生成html模板
	 * 
	 * @param content
	 * @return
	 */
	public String createdHtmlTemplate(String content) {
		String fileName = tempFilePath + "/" + tempFileName;
		try {
			File file = new File(tempFilePath);
			if (!file.isDirectory()) {
				file.mkdir();
			}
			file = new File(fileName);
			if (!file.isFile()) {
				file.createNewFile();
			}
			// 打开文件
			PrintStream printStream = new PrintStream(new FileOutputStream(fileName));

			// 将HTML文件内容写入文件中
			printStream.println(content);
			printStream.flush();
			printStream.close();
			System.out.println("生成html模板成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

}