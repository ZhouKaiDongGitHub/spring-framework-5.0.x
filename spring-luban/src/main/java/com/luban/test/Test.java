package com.luban.test;

import com.luban.config.AppConfig;
import com.luban.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		IndexService indexService = (IndexService) context.getBean("indexServiceImpl1");
		indexService.query();*/
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IndexService indexService = (IndexService) context.getBean("indexServiceImpl1");
		indexService.query();
	}
}
