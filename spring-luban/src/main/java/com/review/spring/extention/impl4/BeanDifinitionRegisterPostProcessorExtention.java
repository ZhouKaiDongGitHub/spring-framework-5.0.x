package com.review.spring.extention.impl4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class BeanDifinitionRegisterPostProcessorExtention implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		BeanDefinition beanDefinition = new RootBeanDefinition(MyBeanDefination.class);
		registry.registerBeanDefinition("myBeanDefination",beanDefinition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}

	public class MyBeanDefination{
		private String attribute1l;

		public String getAttribute1l() {
			return attribute1l;
		}

		public void setAttribute1l(String attribute1l) {
			this.attribute1l = attribute1l;
		}

		public void test(){
			System.out.println("MyBeanDefinition");
		}
	}
}
