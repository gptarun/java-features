package com.designpatterns.factorydp;

import com.designpatterns.factorydp.client.VehicleClient;
import com.designpatterns.factorydp.concrete.BikeFactory;
import com.designpatterns.factorydp.concrete.CarFactory;
import com.designpatterns.factorydp.factoryinterface.IVehicle;

public class VehicleMain {
    public static void main(String[] args) {
        IVehicle bikeFactory = new BikeFactory();
        VehicleClient vehicleClient = new VehicleClient(bikeFactory);
        vehicleClient.getVehicle().printVehicle();

        IVehicle carFactory = new CarFactory();
        VehicleClient vehicleClient1 = new VehicleClient(carFactory);
        vehicleClient1.getVehicle().printVehicle();
    }
}
