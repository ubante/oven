package com.ubante.oven.carswapping;

/**
 * Created by J on 5/21/2014.
 */
public class Person {
    String name;
    Car car;
    double initialValue = 0;

    Person(String name) { this.name = name; }

    public void setCar(Car car) {
        this.car = car;
        if ( initialValue == 0) { initialValue = car.value; }
    }

    public void loseCar() { car = new Car(0,"none"); }

    public double getBalance() {
        return car.value - initialValue;
    }

    @Override
    public String toString() {
        return name+"-"+car.name;
    }
}
