package com.kzhou.spring.beandefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserMapper userMapper = (UserMapper) context.getBean("myFactoryBean");
        String sql  = userMapper.qureyUserList();
        System.out.println(sql);
    }
}
