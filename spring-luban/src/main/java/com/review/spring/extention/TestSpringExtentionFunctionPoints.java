package com.review.spring.extention;

import com.review.spring.extention.impl1.ApplicationAwareExtention;
import com.review.spring.extention.impl1.EnviromentAwareExtention;
import com.review.spring.extention.impl2.DisposableAndInitialBeanExtention;
import com.review.spring.extention.impl3.FactoryBeanExtention;
import com.review.spring.extention.impl4.BeanDifinitionRegisterPostProcessorExtention;
import com.review.spring.extention.impl5.BeanPostProcessorExtention;
import com.review.spring.extention.impl6.ImportBeanDefinitionRegisterExtention;
import com.review.spring.extention.impl6.Test1;
import com.review.spring.extention.impl6.Test2;
import com.review.spring.extention.impl7.ApplicationEventExtention;
import com.review.spring.extention.impl7.ApplicationSourceExtention;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

/**
 * spring提供了许多的扩展点，大体分为七类：
 * 1.Aware  EnvironmentAware(注入环境)  ApplicationAware(注入工厂)
 * 2.DisposableBean和InitializeBean 这两个接口用于对象实例化出来后和对象构造方法之前
 * 3.FactoryBean 用于特殊的bean生成，在复杂的bean生成和结合代理有特殊的功能
 * 4.beanFactoryPostProcessor和beanPostProcessor 后置处理器，用于处理BeanDifinitionMaps和SingtonObjects
 * 5.beanDifinitionRegisterPostProcessor 此类postProcess Spring默认有几个用来处理bean的注入，也可以自定义一些
 * 6. @ImportSelectos @ImportBenaDifinitionRegister
 * 7.applicationPublish 用于事件发布
 */
public class TestSpringExtentionFunctionPoints {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//test extention1
		ApplicationAwareExtention applicationAwareExtention = (ApplicationAwareExtention)context.getBean("applicationAwareExtention");
		applicationAwareExtention.handleApplicationContext();
		EnviromentAwareExtention enviromentAwareExtention = (EnviromentAwareExtention)context.getBean("enviromentAwareExtention");
		enviromentAwareExtention.handleEnviroment();

		//test extention2
		DisposableAndInitialBeanExtention disposableAndInitialBeanExtention = (DisposableAndInitialBeanExtention)context.getBean("disposableAndInitialBeanExtention");
//		context.destroy();
////		try {
////			Thread.sleep(10000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}

		//test extention3
		FactoryBeanExtention factoryBeanExtention = (FactoryBeanExtention)context.getBean("&factoryBeanExtention");
		System.out.println(factoryBeanExtention.getClass().getName());
		Proxy proxy = (Proxy) context.getBean("factoryBeanExtention");
		System.out.println(proxy.getClass().getName());

		// test extention4
		BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination myBeanDefination = (BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination)context.getBean("myBeanDefination");
		myBeanDefination.test();

		// test extention5

		// test extention6
		Test1 test1 = context.getBean(Test1.class);
		test1.printAttribute1();
		Test2 test2 = context.getBean(Test2.class);
		test2.printAttribute1();

		// test extention7
		ApplicationEventExtention applicationEventExtention = new ApplicationEventExtention(new ApplicationSourceExtention("30度","50湿度","气压80"));
		context.publishEvent(applicationEventExtention);

		applicationEventExtention = new ApplicationEventExtention(new ApplicationSourceExtention("50度","1000湿度","气压180"));
		context.publishEvent(applicationEventExtention);

	}
}
