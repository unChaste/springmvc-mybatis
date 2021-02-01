package com.ay.apple.singleton;

public class Singleton03Synchronized {
    private static Singleton03Synchronized singleton03Synchronized;

    private Singleton03Synchronized() {

    }

    // 同步方法出现性能问题，当实例被创建后，每次获取实例依然需要进行同步
    public static synchronized Singleton03Synchronized getSingleton03Synchronized() {
        if (singleton03Synchronized == null) {
            singleton03Synchronized = new Singleton03Synchronized();
        }
        return singleton03Synchronized;
    }

    public void sayHello() {
        System.out.println("Hello, Singleton03Synchronized");
    }
}
