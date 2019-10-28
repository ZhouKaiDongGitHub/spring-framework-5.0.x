package com.luban.anno.proxyConfiguration;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CostDaoImplCglib implements MethodInterceptor {

	public Object getInstance(Class clazz)throws Exception{
		Enhancer enhancer = new Enhancer();
		//告诉cglib，生成的子类需要继承哪个类
		enhancer.setSuperclass(clazz);
		//设置回调
		enhancer.setCallback(this);
		//生成源代码
		//编译成class文件
		//加载到JVM中，并返回被代理对象
		return enhancer.create();
	}


	/**
	 * Object obj：表示要进行增强的对象
	 * Method method：表示拦截的方法
	 * Object[] args：基本数据类型需要传入其包装类型
	 * MethodProxy proxy：表示对方法的代理
	 * 注意：我们设置了目标类作为代理类的父类（setSuperclass），在cglib中目标类的创建不是我们自己手工去创建，而是cglib通过反射动态去创建的。
	 *
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("增强逻辑");
		return methodProxy.invokeSuper(o,objects);
	}
}
