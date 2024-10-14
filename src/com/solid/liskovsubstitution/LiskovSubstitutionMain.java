package com.solid.liskovsubstitution;

/**
 * L — Liskov’s Substitution Principle
 * Parent classes should be easily substituted with their child classes without blowing up the application
 */
public class LiskovSubstitutionMain {
    public static void main(String[] args) {
        Motorcycle motorcycle = new Motorcycle(false, 15);
        VehicleCreation vehicleCreation = new VehicleCreation();
        vehicleCreation.setBike(motorcycle);
        vehicleCreation.getBike().startEngine();
        vehicleCreation.getBike().accelerate();
        System.out.println(motorcycle.getSpeed());

        Bicycle bicycle = new Bicycle(1);
        vehicleCreation.setBike(bicycle);
//        vehicleCreation.getBike().startEngine();
    }
}
