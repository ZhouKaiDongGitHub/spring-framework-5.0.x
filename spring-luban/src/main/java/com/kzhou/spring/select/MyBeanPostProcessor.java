package com.kzhou.spring.select;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("powerDaoImpl".equals(beanName)){
            java.lang.reflect.Proxy proxy = (Proxy) java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{PowerDao.class} ,new MyInvocationHandler((PowerDao) bean));
            return proxy;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
