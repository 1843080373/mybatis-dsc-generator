package com.ftl.basic.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ftl.basic.ib.MySortMethod;
import com.ftl.basic.ib.MyValidationDirective;
import com.ftl.basic.module.Record;
import com.ftl.basic.module.User;
import com.ftl.basic.tools.FreemarkerUtils;

import freemarker.template.TemplateException;

public class TestCaseMain {

	public static void main(String[] args) {
		// 准备数据
		Map<String, Object> data = new HashMap<>();

		Record record = new Record();
		record.setId(1L);
		record.setName("记录一");

		User user = new User();
		user.setUsername("小明");
		user.setAge(18);
		user.setRecord(record);

		data.put("user", user);
		data.put("isOk", Boolean.TRUE);
		data.put("utildate", new Date());
		data.put("nullVar", null);
		data.put("missingVar", null);
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
		    list.add(i+1);
		}
		data.put("numList", list);
		data.put("my_sort", new MySortMethod());
		data.put("role", new MyValidationDirective());
		try {
			FreemarkerUtils.parse("hello.ftl", "basic/hello.html", data);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}
}
