package com.luban.anno.config;

import com.luban.anno.importBeanDifinitionRegiste.MyImportBeanFactoryRegiste;
import com.luban.anno.importSelect.EnableEureka;
import com.luban.anno.importSelect.MyImportSelect;
import com.luban.anno.proxyConfiguration.CostDaoImpl;
import com.luban.anno.proxyConfiguration.OrderDaoImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.luban")
@EnableAspectJAutoProxy
@Import({MyImportBeanFactoryRegiste.class})
@EnableEureka
public class AppConfig {

	@Bean
	public OrderDaoImpl orderDaoImpl1(){
		return new OrderDaoImpl();
	}
	@Bean
	public CostDaoImpl costDaoImpl(){
		orderDaoImpl1();
		return new CostDaoImpl();
	}
}
