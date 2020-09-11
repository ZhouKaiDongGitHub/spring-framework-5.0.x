package com.luban.initializer.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


	/*public void addInterceptors(InterceptorRegistry registry) {
		//创建自定义的拦截器
		Interceptor interceptor = new Interceptor();
		//添加拦截器
		registry.addInterceptor(interceptor)
				//添加需要拦截的路径
				.addPathPatterns("");
	}*/
}
