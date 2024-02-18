package org.rdouda.VehiculeManager;

public class Car extends Vehicle {

    /**
     * Constructor to create a new Car object inheriting properties from Vehicle.
     *
     * @param id Unique identifier for the car.
     * @param brand Brand of the car.
     * @param colour Color of the car.
     */
    public Car(int id, String brand, String colour) {
        super(id, brand, colour); // Call Vehicle's constructor to initialize common properties
    }
}
