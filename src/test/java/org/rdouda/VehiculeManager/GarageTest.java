package org.rdouda.VehiculeManager;

import org.rdouda.VehiculeManager.Exceptions.GarageException;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.garage = new Garage("GarageTest", "adr 2311");
    }

    @org.junit.jupiter.api.Test
    void testAddVehicle() {
        Car car = new Car(23, "Volkswagen", "Gray");
        Truck truck = new Truck(1, "Toyota Tundra", "Red");
        garage.add(car);
        garage.add(truck);
        assertTrue(garage.getVehicles().contains(car));
        assertTrue(garage.getVehicles().contains(truck));
    }
    @org.junit.jupiter.api.Test
    public void testAddNullVehicle() {
        garage.add(null);
        assertEquals(0, garage.getVehicles().size());
    }
    @org.junit.jupiter.api.Test
    public void testAddDuplicateVehicle() {
        Car car = new Car(1, "Toyota", "Blue");
        garage.add(car);
        garage.add(car);
        assertEquals(1, garage.getVehicles().size());
    }
    @org.junit.jupiter.api.Test
    public void testAddDuplicateVehicleIDs() {
        Car car = new Car(1, "Toyota", "Blue");
        Truck truck = new Truck(1, "Volkswagen", "Gray");
        garage.add(car);
        garage.add(truck);
        assertEquals(1, garage.getVehicles().size());
    }
    @org.junit.jupiter.api.Test
    public void testRemoveVehicle() {
        Car car = new Car(1, "Toyota", "Blue");
        garage.add(car);
        try {
            garage.remove(car);
        } catch (GarageException garageException){
            System.out.println(garageException.getMessage());
        }
        assertFalse(garage.getVehicles().contains(car));
    }
    @org.junit.jupiter.api.Test
    public void testRemoveNullVehicle() {
        try {
            garage.remove(null);
        } catch (GarageException garageException){
            System.out.println(garageException.getMessage());
        }
        assertFalse(garage.getVehicles().contains(null));
    }
}