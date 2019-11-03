package com.luban.anno.test;

import com.luban.anno.aop.TargetProgrome;
import com.luban.anno.config.AppConfig;
import com.luban.anno.dao.PowerDao;
import com.luban.anno.factoryBean.DataSourceFactoryBean;
import com.luban.anno.importSelect.Dao;
import com.luban.anno.importSelect.DaoImpl;
import com.luban.anno.importSelect.ImportSelectIndexDao;
import com.luban.anno.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMainClass {

	public static void main(String[] args) {
		//FactoryBean
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

		//BeanFactoryPostProcessor
		//context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());

		//ImportBeanDefinitionRegistrar
		/*PowerDao powerDao = (PowerDao) context.getBean("myFactoryBean");
		System.out.println(powerDao.queryPower());*/

		//ImportSelector
		/*Dao dao = (Dao)context.getBean("daoImpl");
		dao.query();*/

		//ProxyAppconfig
		//AppConfig appConfig = (AppConfig) context.getBean("appConfig");
		TargetProgrome targetProgrome = (TargetProgrome) context.getBean("targetProgrome");
		targetProgrome.query();

	}
}
