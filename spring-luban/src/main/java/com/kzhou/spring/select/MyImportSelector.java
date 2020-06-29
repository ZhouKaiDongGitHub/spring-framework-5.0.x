package com.kzhou.spring.select;

import org.springframework.context.annotation.ImportSelector;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(org.springframework.core.type.AnnotationMetadata annotationMetadata) {
        String[] addBean = new String[]{UserServiceImpl.class.getName(), MyBeanPostProcessor.class.getName()};
        return addBean;
    }
}
