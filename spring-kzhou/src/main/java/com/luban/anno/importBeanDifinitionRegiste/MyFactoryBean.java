package com.luban.anno.importBeanDifinitionRegiste;

import com.luban.anno.dao.UserDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;


public class MyFactoryBean implements FactoryBean {

	private Class[] classes;
	public MyFactoryBean(Class[] classes){
		this.classes = classes;
	}
	@Override
	public Object getObject() throws Exception {
		Proxy proxy =(Proxy) Proxy.newProxyInstance(this.getClass().getClassLoader(),classes,new MyInvocationHandler());
		return proxy;
	}

	@Override
	public Class<?> getObjectType() {
		return classes[0];
	}
}
