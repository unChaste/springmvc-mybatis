package com.ay.apple.factory;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Vehicle car = carFactory.produce();
        car.run();

        BusFactory busFactory = new BusFactory();
        Vehicle bus = busFactory.produce();
        bus.run();
    }
}

interface Factory {
    Vehicle produce();
}

class CarFactory  implements Factory{
    @Override
    public Vehicle produce() {
        return new Car();
    }
}

class BusFactory implements Factory {
    @Override
    public Vehicle produce() {
        return new Bus();
    }
}

class BicycleFactory implements Factory {
    @Override
    public Vehicle produce() {
        return new Bicycle();
    }
}