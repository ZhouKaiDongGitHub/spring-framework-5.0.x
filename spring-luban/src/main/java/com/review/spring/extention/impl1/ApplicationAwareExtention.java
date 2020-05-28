package com.review.spring.extention.impl1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationAwareExtention implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	public void handleApplicationContext(){
		System.out.println(applicationContext.getClassLoader());
		System.out.println(applicationContext.getBean("applicationAwareExtention").getClass().getName());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
