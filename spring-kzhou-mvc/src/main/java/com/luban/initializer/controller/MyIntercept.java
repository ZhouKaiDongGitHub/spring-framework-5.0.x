package com.luban.initializer.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyIntercept implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(("进入 preHandle 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI()));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("进入 postHandle 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("进入 afterCompletion 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());
	}

}
