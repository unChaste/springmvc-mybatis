package com.ay.apple.singleton;

public class Apple {
    public static void main(String[] args) {
        Singleton01Eager singleton = Singleton01Eager.getSingleton01Eager();
        singleton.sayHello();

        Singleton02Lazy singleton02Lazy = Singleton02Lazy.getSingleton02Lazy();
        singleton02Lazy.sayHello();

        Singleton03Synchronized singleton03Synchronized = Singleton03Synchronized.getSingleton03Synchronized();
        singleton03Synchronized.sayHello();

        Singleton04DoubleVerify singleton04DoubleVerify = Singleton04DoubleVerify.getSingleton04DoubleVerify();
        singleton04DoubleVerify.sayHello();


        Singleton05DoubleVerify2 singleton05DoubleVerify2 = Singleton05DoubleVerify2.getSingleton05DoubleVerify2();
        singleton05DoubleVerify2.sayHello();
    }
}
