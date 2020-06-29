package com.kzhou.spring.select;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.register(PowerDaoImpl.class);
		PowerDao proxy = (PowerDao)context.getBean("powerDaoImpl");
		proxy.getPower();
    }
}
