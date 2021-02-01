package com.ay.apple.proxy;

public class ProxyPattern {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = new Proxy(subject);
        proxy.operation();
    }

}

interface Subject {
    void operation();
}

class RealSubject implements Subject {
    @Override
    public void operation() {
        System.out.println("operation...");
    }
}

class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void operation() {
        preOperation();

        subject.operation();

        postOperation();
    }

    void preOperation() {
        System.out.println("pre operation...");
    }

    void postOperation() {
        System.out.println("post operation...");
    }
}
