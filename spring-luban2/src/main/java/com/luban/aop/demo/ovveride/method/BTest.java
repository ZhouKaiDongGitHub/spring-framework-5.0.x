package com.luban.aop.demo.ovveride.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Component
@Scope(SCOPE_SINGLETON)
public abstract class BTest {

	//@Autowired
	//private ATest aTest;
	public ATest getA(){
		return getAObject();
	}

	@Lookup
	public abstract ATest getAObject();//只能每次都从工厂中获取一个A对象
}
