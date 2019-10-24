package com.luban.anno.importSelect;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class ImportSelectIndexDao implements  BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("daoImpl")){
			bean= Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{Dao.class},
					new MyInvocationHandle2(new DaoImpl()));
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
