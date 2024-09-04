package com.designpatterns.factorydp.client;

import com.designpatterns.factorydp.factoryinterface.IVehicle;
import com.designpatterns.factorydp.libraryclass.Vehicle;

public class VehicleClient {
    private Vehicle vehicle;

    public VehicleClient(IVehicle vehicle) {
        this.vehicle = vehicle.createVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
