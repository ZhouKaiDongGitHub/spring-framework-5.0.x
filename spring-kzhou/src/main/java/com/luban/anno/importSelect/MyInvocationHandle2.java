package com.luban.anno.importSelect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandle2 implements InvocationHandler {
	private Object target;
	public MyInvocationHandle2(Object target){
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是代理方法");
		return method.invoke(target,args);
	}
}
