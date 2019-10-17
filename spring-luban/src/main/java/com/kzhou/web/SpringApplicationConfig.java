package com.kzhou.web;

import com.kzhou.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SpringApplicationConfig {

	public static void run() throws LifecycleException{
		//获取Tomcat的临时目录
		File base = new File(System.getProperty("java.io.tmpdir"));
		//实例化Tomcat
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9080);
		Context rootctx = tomcat.addContext("/",base.getAbsolutePath());

		//初始化ApplicationContext
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		//实例化DispatcherServlet,一种方法是需要通过WebApplicationInitializer的servletContext,另一种方法直接加到
		//tomcat之中
		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

		Tomcat.addServlet(rootctx,"Servlet",dispatcherServlet).setLoadOnStartup(0);
		rootctx.addServletMapping("/","Servlet");
		tomcat.start();
		tomcat.getServer().await();
	}
}
