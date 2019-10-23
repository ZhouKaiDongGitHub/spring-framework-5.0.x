package com.luban.test;

import com.luban.config.AppConfig;
import com.luban.factoryBean.DataSourceFactoryBean;
import com.luban.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMainClass {

	public static void main(String[] args) {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		DataSourceFactoryBean dataSourceFactoryBean = (DataSourceFactoryBean) context.getBean("&dataSourceFactoryBean");
		try {
			dataSourceFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSourceFactoryBean.print();*/
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		IndexService indexService = (IndexService) context.getBean("indexServiceImpl1");
		System.out.println(indexService.getNameById("kzhou"));
	}
}
