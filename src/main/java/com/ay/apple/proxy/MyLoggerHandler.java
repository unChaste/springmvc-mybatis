package com.ay.apple.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyLoggerHandler implements InvocationHandler {
    private Object objOriginal;

    private MyLogger myLogger = new MyLoggerImpl();

    public MyLoggerHandler(Object obj) {
        this.objOriginal = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        myLogger.saveIntoMethodTime(method);

        result = method.invoke(this.objOriginal, args);

        myLogger.saveOutMethodTime(method);

        return result;
    }

    public static void main(String[] args) {
        BusinessService businessService = new BusinessServiceImpl();

        MyLoggerHandler myLoggerHandler = new MyLoggerHandler(businessService);

        BusinessService proxy = (BusinessService) Proxy.newProxyInstance(businessService.getClass().getClassLoader(), businessService.getClass().getInterfaces(), myLoggerHandler);

        proxy.doSomething();
    }
}
