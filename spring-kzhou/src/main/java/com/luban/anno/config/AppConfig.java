package com.luban.anno.config;

import com.luban.anno.importBeanDifinitionRegiste.MyImportBeanFactoryRegiste;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.luban")
@Import(MyImportBeanFactoryRegiste.class)
public class AppConfig {
}
