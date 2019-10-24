package com.luban.anno.importBeanDifinitionRegiste;

import com.luban.anno.dao.PowerDao;
import com.luban.anno.dao.UserDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

/**
 * Spring提供的扩展点之一：可以对beanFactory中生成的beanDefinitionMap进行操作
 * 例如：Mybatis中的MapperScan就是结合FactoryBean利用代理生成接口的实现代理类，然后将代理类交给Spring管理的
 *
 */
public class MyImportBeanFactoryRegiste implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(PowerDao.class);
		registry.registerBeanDefinition("myFactoryBean",beanDefinition);
	}
}
