package com.review.spring.extention.impl1;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnviromentAwareExtention implements EnvironmentAware {
	private Environment environment;

	public void handleEnviroment(){
		System.out.println("qurey enviroment properties:");
		environment.containsProperty("");

	}
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
