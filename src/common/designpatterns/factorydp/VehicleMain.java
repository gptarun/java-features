package common.designpatterns.factorydp;

import common.designpatterns.factorydp.client.VehicleClient;
import common.designpatterns.factorydp.concrete.BikeFactory;
import common.designpatterns.factorydp.concrete.CarFactory;
import common.designpatterns.factorydp.factoryinterface.IVehicle;

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
