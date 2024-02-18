package org.rdouda;

import org.rdouda.VehiculeManager.Car;
import org.rdouda.VehiculeManager.Exceptions.GarageException;
import org.rdouda.VehiculeManager.Garage;
import org.rdouda.VehiculeManager.Truck;
import org.rdouda.VehiculeManager.VehicleFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage("Garage", "238 State St");

        Car car = VehicleFactory.createCar();
        Truck truck = VehicleFactory.createTruck();

        garage.add(car);
        garage.add(truck);

        garage.display();

        try{
            garage.remove(car);
        }catch (GarageException garageException){
            System.out.println("Error: Error unknown error.");
        }
    }
}