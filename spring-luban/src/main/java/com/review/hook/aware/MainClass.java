package com.review.hook.aware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application2.xml");

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				MyAware myAware = (MyAware) context.getBean("myAware");
				myAware.reloadApp();
			}
		});
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					try {
						TestClassOne testClassOne = (TestClassOne)context.getBean("testOne");
						testClassOne.print();
						TestClassTwo testClassTwo = (TestClassTwo) context.getBean("testTwo");
						testClassTwo.print();
						thread2.join();
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
		thread2.start();

	}
}
