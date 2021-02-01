package com.ay.apple.singleton;

public class Singleton02Lazy {
    private static Singleton02Lazy singleton02Lazy;

    private Singleton02Lazy() {

    }

    public static Singleton02Lazy getSingleton02Lazy() {
        if (singleton02Lazy == null) {
            singleton02Lazy = new Singleton02Lazy();
        }
        return singleton02Lazy;
    }

    public void sayHello() {
        System.out.println("Hello, Singleton02Lazy!");
    }
}
