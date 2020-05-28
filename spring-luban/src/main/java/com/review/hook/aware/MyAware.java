package com.review.hook.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class MyAware implements ApplicationContextAware, EnvironmentAware {
	private ApplicationContext applicationContext;
	private Environment environment;

	public void reloadApp(){
		if(applicationContext instanceof AbstractApplicationContext){
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationExtention.xml","classpath:application2.xml");
			applicationContext = context;
		}
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

}
