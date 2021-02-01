package com.ay.apple.singleton;

public class Singleton06InnerClass {
    // 第一次访问之前不会产生内部类的加载
    private static class SingletonHolder {
        private static Singleton06InnerClass singleton06InnerClass = new Singleton06InnerClass();
    }

    private Singleton06InnerClass() {

    }

    // 第一次访问会触发内部类的加载，类只会被加载一次
    public static Singleton06InnerClass getSingleton06InnerClass() {
        return SingletonHolder.singleton06InnerClass;
    }
}
