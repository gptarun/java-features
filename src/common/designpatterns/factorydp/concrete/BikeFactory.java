package common.designpatterns.factorydp.concrete;

import common.designpatterns.factorydp.factoryinterface.IVehicle;
import common.designpatterns.factorydp.libraryclass.Bike;
import common.designpatterns.factorydp.libraryclass.Vehicle;

public class BikeFactory implements IVehicle {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}
