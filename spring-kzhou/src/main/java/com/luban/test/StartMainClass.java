package com.luban.test;

import com.luban.factoryBean.DataSourceFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		DataSourceFactoryBean dataSourceFactoryBean = (DataSourceFactoryBean) context.getBean("&dataSourceFactoryBean");
		try {
			dataSourceFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSourceFactoryBean.print();
	}
}
