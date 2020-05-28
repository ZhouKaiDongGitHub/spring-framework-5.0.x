package com.review.spring.extention.impl2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DisposableAndInitialBeanExtention implements InitializingBean, DisposableBean {

	private String attribute1;
	private String attribute2;
	@Override
	public void destroy() throws Exception {
		System.out.println("ApplicationContext destory: DisposableAndInitialBeanExtention destory.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("DisposableAndInitialBeanExtention bean attribute set,call afterPropertiesSet Method");
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
}
