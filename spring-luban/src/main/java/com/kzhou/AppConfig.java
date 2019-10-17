package com.kzhou;


import com.kzhou.web.SpringApplicationConfig;
import org.apache.catalina.LifecycleException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kzhou")
public class AppConfig {

		public static void main(String[] args) {
			try {
				SpringApplicationConfig.run();
			} catch (LifecycleException e) {
				e.printStackTrace();
			}
		}

}
