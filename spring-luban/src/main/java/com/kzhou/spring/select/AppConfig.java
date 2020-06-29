package com.kzhou.spring.select;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyImportSelector.class})
public class AppConfig {

}
