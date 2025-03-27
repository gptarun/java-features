package common.designpatterns.factorydp.client;

import common.designpatterns.factorydp.factoryinterface.IVehicle;
import common.designpatterns.factorydp.libraryclass.Vehicle;

public class VehicleClient {
    private Vehicle vehicle;

    public VehicleClient(IVehicle vehicle) {
        this.vehicle = vehicle.createVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
