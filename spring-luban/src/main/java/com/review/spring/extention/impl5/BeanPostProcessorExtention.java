package com.review.spring.extention.impl5;

import com.review.spring.extention.impl4.BeanDifinitionRegisterPostProcessorExtention;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorExtention implements BeanPostProcessor {

	@Value("attribute1")
	private String attribute1;
	@Value("attribute2")
	private String attribute2;
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if("myBeanDefination".equals(beanName)|| bean instanceof BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination){
			BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination myBeanDefination = (BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination)bean;
			myBeanDefination.setAttribute1l("attribute111111111111111111111111111");
			System.out.println("postProcessBeforeInitialization");
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if("myBeanDefination".equals(beanName)|| bean instanceof BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination){
			BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination myBeanDefination = (BeanDifinitionRegisterPostProcessorExtention.MyBeanDefination)bean;
			System.out.println(myBeanDefination.getAttribute1l());
			System.out.println("postProcessAfterInitialization");
		}
		return null;
	}
}
