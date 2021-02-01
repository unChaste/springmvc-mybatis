package com.ay.apple.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Before("execution(* com.ay.controller.*.*(..))")
    public void before() {
        System.out.println("进入方法的时间为：" + new Date());
    }

    @After("execution(* com.ay.controller.*.*(..))")
    public void after() {
        System.out.println("退出方法的时间为：" + new Date());
    }
}
