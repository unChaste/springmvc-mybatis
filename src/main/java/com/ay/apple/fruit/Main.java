package com.ay.apple.fruit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mvc.xml");
        Car car = applicationContext.getBean(Car.class);
        car.run();
    }

}
