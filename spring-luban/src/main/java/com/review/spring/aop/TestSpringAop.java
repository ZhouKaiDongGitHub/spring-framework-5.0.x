package com.review.spring.aop;

import com.review.spring.aop.annotation.TargetObeject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringAop {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfigAop.class);
		context.refresh();

		TargetObeject targetObeject = (TargetObeject) context.getBean("targetObject");
		targetObeject.queryUserName("1");
	}
}
