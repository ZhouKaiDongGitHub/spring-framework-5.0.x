package com.luban.initializer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class LubanWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		applicationContext.refresh();

		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet.setApplicationContext(applicationContext);


		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcherServlet",dispatcherServlet);
		servletRegistration.addMapping("/luban");
		servletRegistration.setLoadOnStartup(1);
	}
}
