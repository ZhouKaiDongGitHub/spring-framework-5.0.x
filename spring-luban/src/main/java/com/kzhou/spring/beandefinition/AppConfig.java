package com.kzhou.spring.beandefinition;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyImportBeanDefination.class})
public class AppConfig {

}
