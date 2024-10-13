package com.solid.liskovsubstitution;

public class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car started");
    }
}
