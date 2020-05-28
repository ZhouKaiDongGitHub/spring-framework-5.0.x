package com.review.hook;

import com.review.hook.aware.MyAware;
import com.review.hook.aware.TestClassOne;
import com.review.hook.aware.TestClassTwo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Spring提供了很多的扩展点
 * 1，Aware ApplicationAware EnviromentAware
 * 2, InitialzingBean DisposableBean
 * 3, ImportBeanDifinitionRegistar ImportSelector
 * 4, BeanPostProcessor BeanFactoryPostProcessor
 * 5，BeanDifinitionRegistarPostProcessor
 * 6, FactoryBean
 * 7, ApplicationListener
 */
public class MainClass {
	public static void main(String[] args) throws InterruptedException {

		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application2.xml");
		TestClassOne testClassOne = (TestClassOne)context.getBean("testOne");
		testClassOne.print();
		MyAware myAware = (MyAware) context.getBean("myAware");
		myAware.reloadApp();
		TestClassTwo testClassTwo = (TestClassTwo) context.getBean("testTwo");
		testClassTwo.print();*/

		//MyApplicationEvent applicationEvent = (MyApplicationEvent)context.getBean("myApplicationEvent");
		//Thread.sleep(10000);
		//context.publishEvent(applicationEvent);
		Date date = new Date();
		System.out.println(date);
		Timestamp timestamp = new Timestamp(date.getTime());
		System.out.println(timestamp);
	}
}
