package com.luban.anno.importBeanDifinitionRegiste;

import com.luban.anno.annotation.SQLAnnotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("这边不需要增强原方法，也不需要委托原方法的实现方法，只需要接口上面的sql");
		SQLAnnotation annotation = method.getAnnotation(SQLAnnotation.class);
		String sql = annotation.value()[0];
		return sql;
	}
}
