package com.ay.apple.proxy;

import java.lang.reflect.Method;
import java.util.Date;

public class MyLoggerImpl implements MyLogger{
    @Override
    public void saveIntoMethodTime(Method method) {
        System.out.println("进入" + method.getName() + "方法的时间为：" + new Date());
    }

    @Override
    public void saveOutMethodTime(Method method) {
        System.out.println("退出" + method.getName() + "方法的时间为：" + new Date());
    }
}
