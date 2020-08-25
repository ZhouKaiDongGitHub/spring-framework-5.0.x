package com.review.spring.aop;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.review.spring.aop")
@ImportResource("classpath:application_aop.xml")
@EnableAspectJAutoProxy
public class AppConfigAop {


}
