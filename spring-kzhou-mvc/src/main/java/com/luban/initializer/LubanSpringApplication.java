package com.luban.initializer;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.File;

public class LubanSpringApplication {

	public static void run() throws LifecycleException, ServletException {

		Tomcat tomcat  = new Tomcat();
		tomcat.setPort(9090);

		/**
		 * 这是传统的添加webapp的方式，这种方式表明是一个web项目
		 * contextPath表示访问这个web的路径
		 * path表示WEB-INF目录，也就是webapp的目录
		 *
		 * SprintBoot没有了webapp，也没有这样做了
		 */
		File base = new File(System.getProperty("java.io.tmpdir"));
		//tomcat.addWebapp("/",base.getAbsolutePath());

		/**
		 * 我们采用这种方式来添加一个Context应用
		 * 这样就无需web.xml和jsp相关处理
		 * 但是有个问题是，tomcat怎么得到servlet的引用呢？
		 * 			在正常的web启动方式下，ServletContainerInitialzer会将servletContext传入并且将dispatchServlet传入其中
		 * 		但是我们自己new出来的tomcat怎么办呢？直接在run方法中将dispatchServlet给tomcat的Context。
		 */
		Context context = tomcat.addContext("/",base.getAbsolutePath());
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();

		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
		Tomcat.addServlet(context,"Servlet",dispatcherServlet).setLoadOnStartup(0);

		context.addServletMapping("/","Servlet");

		tomcat.start();
		tomcat.getServer().await();
	}
}
