package com.ay.apple.factory;

public class SimpleFactoryPattern {

    public static void main(String[] args) {
        Vehicle vehicle = SimpleFactoryPattern.produce("car");
        vehicle.run();
    }

    public static Vehicle produce(String type) {
        Vehicle vehicle = null;
        if ("car".equals(type)) {
            vehicle = new Car();
        }
        if ("bus".equals(type)) {
            vehicle = new Bus();
        }
        if ("bicycle".equals(type)) {
            vehicle = new Bicycle();
        }
        return vehicle;
    }
}

interface Vehicle {
    void run();
}

class Car implements Vehicle {
    @Override
    public void run() {
        System.out.println("car run...");
    }
}

class Bus implements Vehicle {
    @Override
    public void run() {
        System.out.println("bus run...");
    }
}

class Bicycle implements Vehicle {
    @Override
    public void run() {
        System.out.println("bicycle run...");
    }
}
