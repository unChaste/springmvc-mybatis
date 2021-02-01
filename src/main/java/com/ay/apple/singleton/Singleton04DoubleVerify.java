package com.ay.apple.singleton;

public class Singleton04DoubleVerify {
    private static Singleton04DoubleVerify singleton04DoubleVerify = null;

    private Singleton04DoubleVerify() {

    }

    public static Singleton04DoubleVerify getSingleton04DoubleVerify() {
        if (singleton04DoubleVerify == null) {
            synchronized(Singleton04DoubleVerify.class) {
                if (singleton04DoubleVerify == null) {
                    // 但是这种双重校验方法会出现指令重排的问题
                    // 所谓指令重排是指JVM为了提高程序运行效率，在不影响单线程程序执行结果的前提下，会对指令进行优化、重排，尽可能地提高并行度。
                    // 实例创建底层会有三个步骤
                    // memory = allocate()  # 1分配对象的内存空间
                    // ctorInstance(memery) # 2初始化对象
                    // singleton = memery;  # 3指向刚分配的内存地址
                    // 指令重排后执行步骤会变成1、3、2，当线程A执行到3的时候，恰好线程B进入方法，判断singleton不为null，然后返回，导致程序出错
                    singleton04DoubleVerify = new Singleton04DoubleVerify();
                }
            }
        }
        return singleton04DoubleVerify;
    }

    public void sayHello() {
        System.out.println("Hello, Singleton05DoubleVerify");
    }
}
