package com.ay.apple.singleton;

public class Singleton05DoubleVerify2 {
    private static volatile Singleton05DoubleVerify2 singleton05DoubleVerify2 = null;

    private Singleton05DoubleVerify2() {

    }

    public static Singleton05DoubleVerify2 getSingleton05DoubleVerify2() {
        if (singleton05DoubleVerify2 == null) {
            synchronized (Singleton05DoubleVerify2.class) {
                singleton05DoubleVerify2 = new Singleton05DoubleVerify2();
            }
        }
        return singleton05DoubleVerify2;
    }

    public void sayHello() {
        System.out.println("Hello, Singleton05DoubleVerify2");
    }
}
