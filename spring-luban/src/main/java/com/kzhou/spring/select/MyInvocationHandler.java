package com.kzhou.spring.select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private PowerDao powerDao;

    public MyInvocationHandler(PowerDao powerDao){
        this.powerDao = powerDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强方法逻辑");
        method.invoke(powerDao,args);
        return null;
    }
}
