package com.kzhou.spring.beandefinition;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;


public class MyFactoryBean implements FactoryBean {
    private Class[] classes;

    public MyFactoryBean(Class[] classes){
        this.classes = classes;
    }

    @Override
    public Object getObject() throws Exception {
        Proxy proxy = (Proxy) Proxy.newProxyInstance(this.getClass().getClassLoader(), classes, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                String sql = "";
                if(method.isAnnotationPresent(Select.class)){
                    sql = method.getAnnotation(Select.class).value();
                }
                return sql;
            }
        });
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        try {
            return getObject().getClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
