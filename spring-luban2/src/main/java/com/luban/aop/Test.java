package com.luban.aop;

import com.luban.aop.config.AppConfig;

import com.luban.aop.demo.autowired.XMLAutowiredB;
import com.luban.aop.demo.ovveride.method.BTest;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		//AopService aopService = (AopService) context.getBean("targetPrograme");
		//aopService.testAop();

		//FactoryBean在工厂中也是只有一个对象的，在工厂初始化的时候，存储的是myFactoryBean，MyFactoryBean
		//1.当获取的时候，如果是获取&myFactoryBean，内部会解析发现有&那么直接返回原来对象MyFactoryBean
		//2.当获取的时候，如果是获取myFactoryBean，内部会从一个FactoryBeanCache中去获取对应的getObjects方法的返回对象，
		//     	如果获取不到，就先调用getObject方法生成一个对象给下次调用
		Object object = context.getBean("myFactoryBean");
		Object objects = context.getBean("&myFactoryBean");

		System.out.println(context.getBean("userService"));

		//lookup-method和 replace-method
		System.out.println(context.getBean(BTest.class).getA().hashCode());
		System.out.println(context.getBean(BTest.class).getA().hashCode());

		//
		context.getBean(XMLAutowiredB.class).getA();
	}
}
