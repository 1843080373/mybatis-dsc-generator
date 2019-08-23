package com.ftl.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ftl.entity.OptionQuestions;
import com.ftl.entity.User;
import com.ftl.utils.TemplateParseUtil;

public class TestCase {

	public static void main(String[] args) {
		// xmlTest();
		// htmlTest();
		// excelTest();
		// wordTest();
		pdfTest2();
	}


	/**
	 * 测试PDF文件的生成
	 */
	public static void pdfTest2() {
		List<User> userList = new ArrayList<User>();
		for (int i = 1; i < 10; i++) {
			User user = new User();
			user.setUserName("狗娃" + i);
			user.setRealName("许文强");
			user.setPassWord("123456");
			user.setAddr("上海虎头帮总舵");
			user.setAge("28");
			userList.add(user);
		}
		// 测试Excel文件生成
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userList", userList);
		data.put("title", "演员列表");
		String imgPath = TestCase.class.getClassLoader().getResource("freemarker/templates/imsges/f.jpg").getPath();
		data.put("imgPath", imgPath);
		try {
			TemplateParseUtil.parse2PDF("pdf02.ftl", "tempFile/pdfTest02.pdf", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试PDF文件的生成
	 */
	public static void pdfTest() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("loanId", "LO123456"); // 订单ID
		data.put("realName", "张三"); // 订单ID
		data.put("cardNo", "110001451121111"); // 订单ID
		data.put("name", "张三"); // 订单ID
		data.put("loanAmount", "56.00"); // 订单ID
		data.put("loanAmountCharacter", "五十六元整"); // 订单ID
		data.put("timeLimit", "3"); // 订单ID
		data.put("interest", "0.88"); // 订单ID
		data.put("bankName", "建设银行"); // 订单ID
		data.put("bankNo", "622655555555"); // 订单ID
		data.put("order_id", "1"); // 订单ID
		try {
			TemplateParseUtil.parse2PDF("pdf.ftl", "tempFile/pdfTest.pdf", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试Word文件的生成
	 */
	public static void wordTest() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<OptionQuestions> options = new ArrayList<OptionQuestions>();
		for (int i = 1; i <= 10; i++) {
			OptionQuestions option = new OptionQuestions();
			option.setContent(i + "." + "“给力”这个词出自以下哪本名著？");
			option.setOption1("A." + "《不给力啊，老湿》");
			option.setOption2("B." + "《这货不是宿敌》");
			option.setOption3("C." + "《西游记：旅程的终点》");
			option.setOption4("D." + "《屌丝也有春天》");
			options.add(option);
		}
		List<String> judges = new ArrayList<String>();
		for (int i = 1; i <= 5; i++) {
			judges.add(i + "." + "正方形、长方形、平行四边形和梯形都是特殊四边形");
		}
		data.put("title", "全国人大代表考试题");
		data.put("options", options);
		data.put("judges", judges);
		try {
			TemplateParseUtil.parse("word.ftl", "tempFile/wordTest.doc", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试Excel文件的生成
	 */
	public static void excelTest() {
		List<User> userList = new ArrayList<User>();
		for (int i = 1; i < 10; i++) {
			User user = new User();
			user.setUserName("狗娃" + i);
			user.setRealName("许文强");
			user.setPassWord("123456");
			user.setAddr("上海虎头帮总舵");
			user.setAge("28");
			userList.add(user);
		}
		// 测试Excel文件生成
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userList", userList);
		data.put("title", "演员列表");
		try {
			TemplateParseUtil.parse("excel.ftl", "tempFile/excelTest.xls", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试HTML文件的生成
	 */
	public static void htmlTest() {
		List<User> userList = new ArrayList<User>();
		for (int i = 1; i <= 3; i++) {
			User user = new User();
			user.setUserName("狗娃" + i);
			user.setRealName("许文强");
			user.setPassWord("123456");
			user.setAddr("上海虎头帮总舵");
			user.setAge("28");
			userList.add(user);
		}
		// 测试Excel文件生成
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userList", userList);
		data.put("title", "演员列表");
		try {
			TemplateParseUtil.parse("html.ftl", "tempFile/htmlTest.html", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试XML文件的生成
	 */
	public static void xmlTest() {
		List<User> userList = new ArrayList<User>();
		for (int i = 1; i <= 3; i++) {
			User user = new User();
			user.setUserName("狗娃" + i);
			user.setRealName("许文强");
			user.setPassWord("123456");
			user.setAddr("上海虎头帮总舵");
			user.setAge("28");
			userList.add(user);
		}
		// 测试Excel文件生成
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("userList", userList);
		try {
			TemplateParseUtil.parse("xml.ftl", "templateFiles/xmlTest.xml", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
