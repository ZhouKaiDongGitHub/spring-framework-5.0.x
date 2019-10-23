package com.luban.xml.test;

import com.luban.xml.service.IndexServiceImpl1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

		IndexServiceImpl1 indexServiceImpl1 = (IndexServiceImpl1) context.getBean("indexServiceImpl1");
		indexServiceImpl1.delete();
		indexServiceImpl1.query();
	}
}
