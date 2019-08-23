package com.ftl.pdf;

import java.util.Map;

import org.junit.Test;

public class PDFtest {
	@Test
	public void createPDF() {
		String path = "D:/test";
		String name = "test.html";
		//String content = "'\r\n<html>\r\n\r\n<head>\r\n<meta http-equiv=Content-Type content=\"text/html; charset=UTF-8\"></meta>\r\n<meta name=Generator content=\"Microsoft Word 15 (filtered)\"></meta>\r\n\r\n\r\n</head>\r\n\r\n<body style=\'text-justify-trim:punctuation\'>\r\n\r\n${bankName}年利率是:${interest}%\r\n\r\n</body>\r\n\r\n</html>\r\n'";
		PDFUtil pdfUtil = new PDFUtil(path, name);
		//pdfUtil.createdHtmlTemplate(content);
		try {
			Map<String, Object> paraMap=pdfUtil.data();
			String uploadfile = pdfUtil.fillTemplate(paraMap);
			System.out.println(uploadfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}