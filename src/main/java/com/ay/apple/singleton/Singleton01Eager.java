package com.ay.apple.singleton;

public class Singleton01Eager {
    private static Singleton01Eager singleton01Eager = new Singleton01Eager();

    private Singleton01Eager() {

    }

    public static Singleton01Eager getSingleton01Eager() {
        return singleton01Eager;
    }

    public void sayHello() {
        System.out.println("Hello, Singleton01Eager!");
    }
}
