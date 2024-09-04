package com.designpatterns.factorydp.concrete;

import com.designpatterns.factorydp.factoryinterface.IVehicle;
import com.designpatterns.factorydp.libraryclass.Car;
import com.designpatterns.factorydp.libraryclass.Vehicle;

public class CarFactory implements IVehicle {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
