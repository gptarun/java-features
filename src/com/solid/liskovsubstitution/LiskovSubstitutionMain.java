package com.solid.liskovsubstitution;

/**
 * L — Liskov’s Substitution Principle
 * Parent classes should be easily substituted with their child classes without blowing up the application
 */
public class LiskovSubstitutionMain {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        vehicle.start();
        car.start();
        bike.start(); // here it is failing this principle, as it is throwing an exception i.e. breaking the flow
    }
}
 