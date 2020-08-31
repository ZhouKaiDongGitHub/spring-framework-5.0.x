package com.luban.aop.demo.ovveride.method;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class ATest {

}
