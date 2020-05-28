package com.review.spring.extention.impl6;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectExtention implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//返回需要注入的类全路径
		String[] strings = new String[]{"com.review.spring.extention.impl6.Test1"};
		return strings;
	}
}
