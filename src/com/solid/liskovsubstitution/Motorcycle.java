package com.solid.liskovsubstitution;

public class Motorcycle implements Bike {
    boolean isEngineStarted;
    int speed;

    @Override
    public void startEngine() {
        isEngineStarted = true;
        System.out.println("Motorcycle engine started");
    }

    @Override
    public void accelerate() {
        speed += 10;
    }

    public Motorcycle(boolean isEngineStarted, int speed) {
        this.isEngineStarted = isEngineStarted;
        this.speed = speed;
    }

    public boolean isEngineStarted() {
        return isEngineStarted;
    }

    public void setEngineStarted(boolean engineStarted) {
        isEngineStarted = engineStarted;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
