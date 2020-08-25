package com.review.spring.extention;

import com.review.spring.extention.impl2.DisposableAndInitialBeanExtention;
import com.review.spring.extention.impl6.ImportBeanDefinitionRegisterExtention;
import com.review.spring.extention.impl6.ImportSelectExtention;
import com.review.spring.extention.impl6.ImportSelectExtention2;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.review.spring.extention")
@Import({ImportSelectExtention.class,ImportSelectExtention2.class, ImportBeanDefinitionRegisterExtention.class})
//@EnableAspectJAutoProxy
public class AppConfig {

	@Bean("disposableAndInitialBeanExtention")
	public DisposableAndInitialBeanExtention testExtention2Bean(){
		DisposableAndInitialBeanExtention testExtention2Bean = new DisposableAndInitialBeanExtention();
		testExtention2Bean.setAttribute1("attribute1");
		testExtention2Bean.setAttribute2("attribute2");
		return testExtention2Bean;
	}
}
