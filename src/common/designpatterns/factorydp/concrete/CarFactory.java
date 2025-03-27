package common.designpatterns.factorydp.concrete;

import common.designpatterns.factorydp.factoryinterface.IVehicle;
import common.designpatterns.factorydp.libraryclass.Car;
import common.designpatterns.factorydp.libraryclass.Vehicle;

public class CarFactory implements IVehicle {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
