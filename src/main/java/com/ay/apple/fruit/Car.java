package com.ay.apple.fruit;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// 单例
//@Controller
@Configuration
public class Car implements Vehicle {
    @Override
    public void run() {
        System.out.println("car run...");
        // 字段 属性 状态
    }
}
