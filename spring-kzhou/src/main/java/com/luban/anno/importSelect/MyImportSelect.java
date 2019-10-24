package com.luban.anno.importSelect;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Spring提供的扩展点之一：功能稍弱ImportBeanDefinitionRegistrar，动态
 */
public class MyImportSelect implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{ImportSelectIndexDao.class.getName()};
	}
}
