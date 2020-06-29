package com.luban.xml.lookup;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SingltonClass implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	private PrototypeClass prototypeClass;

	public void printProtoTypeHashCode(){
		PrototypeClass prototypeClass = applicationContext.getBean(PrototypeClass.class);
		System.out.println(prototypeClass.hashCode());
	}

	public void setPrototypeClass(PrototypeClass prototypeClass) {
		this.prototypeClass = prototypeClass;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
