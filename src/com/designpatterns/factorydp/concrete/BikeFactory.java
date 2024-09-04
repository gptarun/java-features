package com.designpatterns.factorydp.concrete;

import com.designpatterns.factorydp.factoryinterface.IVehicle;
import com.designpatterns.factorydp.libraryclass.Bike;
import com.designpatterns.factorydp.libraryclass.Vehicle;

public class BikeFactory implements IVehicle {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}
