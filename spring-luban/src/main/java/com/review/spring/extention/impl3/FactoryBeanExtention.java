package com.review.spring.extention.impl3;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class FactoryBeanExtention implements FactoryBean {

	private Object object;

	@Override
	public Object getObject() throws Exception {
		Proxy proxy = (Proxy) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{FactoryBeanExtentionInterface.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//暂时先不处理
				return null;
			}
		});
		return proxy;
	}

	@Override
	public Class<?> getObjectType() {
		return object.getClass();
	}

	public interface FactoryBeanExtentionInterface{
		public String getNameById();
	}
}
