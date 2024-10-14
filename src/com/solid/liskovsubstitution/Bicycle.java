package com.solid.liskovsubstitution;

public class Bicycle implements Bike {
    int speed;

    @Override
    public void startEngine() {
        throw new RuntimeException("Engine not found");
    }

    @Override
    public void accelerate() {
        speed += 2;
    }

    public Bicycle(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
