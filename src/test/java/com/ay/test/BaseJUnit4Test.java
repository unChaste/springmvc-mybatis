package com.ay.test;

import com.ay.apple.fruit.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class BaseJUnit4Test {

    @Autowired
    private Car car;

    @Test
    public void testCar() {
        // @Controller @Service @Repository @Configuration @Component
        // Bean 容器
        car.run(); // DI  dependency injection
    }
}
