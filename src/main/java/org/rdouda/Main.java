package org.rdouda;

import org.rdouda.VehiculeManager.Car;
import org.rdouda.VehiculeManager.Exceptions.GarageException;
import org.rdouda.VehiculeManager.Garage;
import org.rdouda.VehiculeManager.Truck;
import org.rdouda.VehiculeManager.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage("Garage", "238 State St");

        Car car1 = VehicleFactory.createCar();
        Car car2 = VehicleFactory.createCar();
        Truck truck1 = VehicleFactory.createTruck();
        Truck truck2 = VehicleFactory.createTruck();

        try {
            garage.add(car1);
            garage.add(car2);
            garage.add(truck1);
            garage.add(truck2);
        }catch (GarageException garageException){
            System.out.println(garageException.getMessage());
        }
        try {
            garage.remove(car1);
            garage.remove(car1);
        }catch (GarageException garageException){
            System.out.println(garageException.getMessage());
        }

        garage.display();

        VehicleFactory.closeScanner();
    }
}