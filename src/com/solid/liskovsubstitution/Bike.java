package com.solid.liskovsubstitution;

public class Bike extends Vehicle {
    @Override
    void start() {
        throw new RuntimeException("Error occurred");
    }
}
