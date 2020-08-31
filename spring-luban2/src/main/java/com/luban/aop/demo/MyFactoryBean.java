package com.luban.aop.demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class MyFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		return  Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{UserDao.class},new MyInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		try {
			return getObject().getClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
