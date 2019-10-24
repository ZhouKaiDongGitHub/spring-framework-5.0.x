package com.luban.anno.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * Spring提供的扩展点之一：可以对beanFactory中生成的beanDefinitionMap进行操作
 * 例如：ConfigurationClassPostProcessor，就是对所有的beanFactory中的beanDifinition是annotedBeanDifinition并且
 * 		 加上@Configuration的类进行操作，解析上面的注解等等
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("调用了自定义的BeanFactoryPostProcessor " + beanFactory);
		Iterator it = beanFactory.getBeanNamesIterator();

		String[] names = beanFactory.getBeanDefinitionNames();
		// 获取了所有的bean名称列表
		for(int i=0; i<names.length; i++){
			String name = names[i];
			BeanDefinition bd = beanFactory.getBeanDefinition(name);
			System.out.println(name + " bean properties: " + bd.getPropertyValues().toString());
			// 本内容只是个demo，打印持有的bean的属性情况
		}
	}
}
