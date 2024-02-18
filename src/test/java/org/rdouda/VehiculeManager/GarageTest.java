package org.rdouda.VehiculeManager;

import org.rdouda.VehiculeManager.Exceptions.GarageException;
import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage; // Garage instance for testing

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Create new Garage for each test
        this.garage = new Garage("GarageTest", "adr 2311");
    }

    @org.junit.jupiter.api.Test
    void testAddVehicle() throws GarageException{
        // Add a car and truck to the garage
        // Check if both car and truck are present in the garage's vehicle list
        Car car = new Car(23, "Volkswagen", "Gray");
        Truck truck = new Truck(1, "Toyota Tundra", "Red");
        garage.add(car);
        garage.add(truck);
        assertTrue(garage.getVehicles().contains(car));
        assertTrue(garage.getVehicles().contains(truck));
    }

    @org.junit.jupiter.api.Test
    void testAddNullVehicle() throws GarageException {
        // Try adding null to the garage
        // Verify that the garage's vehicle list size remains zero
        garage.add(null);
        assertEquals(0, garage.getVehicles().size());
    }

    @org.junit.jupiter.api.Test
    void testAddDuplicateVehicle() throws GarageException{
        // Add the same car to the garage twice
        // Verify that the garage's vehicle list size is still one
        Car car = new Car(1, "Toyota", "Blue");
        garage.add(car);
        garage.add(car);
        assertEquals(1, garage.getVehicles().size());
    }

    @org.junit.jupiter.api.Test
    void testAddDuplicateVehicleIDs() throws GarageException {
        // Add a car and truck with the same ID but different types
        // Verify that the garage's vehicle list size is still one
        Car car = new Car(1, "Toyota", "Blue");
        Truck truck = new Truck(1, "Volkswagen", "Gray");
        garage.add(car);
        garage.add(truck);
        assertEquals(1, garage.getVehicles().size());
    }

    @org.junit.jupiter.api.Test
    void testRemoveVehicle() throws GarageException {
        // Add a car to the garage
        // Remove the car and handle potential exceptions
        // Verify that the car is no longer in the garage's vehicle list
        Car car = new Car(1, "Toyota", "Blue");
        garage.add(car);
        try {
            garage.remove(car);
        } catch (GarageException e) {
            // Handle exception (not shown here)
        }
        assertFalse(garage.getVehicles().contains(car));
    }

    @org.junit.jupiter.api.Test
    void testRemoveVehicleDoesNotExist() throws GarageException {
        // Add a car to the garage
        // Remove the car, then try removing it again (should throw exception)
        // Verify that the expected exception is thrown with the correct message
        Car car = new Car(1, "Toyota", "Blue");
        garage.add(car);

        try {
            garage.remove(car);
            garage.remove(car);
            fail("Expected GarageException was not thrown");
        } catch (GarageException e) {
            assertEquals("Vehicle not found in the garage.", e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void testRemoveNullVehicle() {
        // Try removing null from the garage
        // Handle potential exceptions
        // Verify that no null vehicle is added to the garage's vehicle list
        try {
            garage.remove(null);
        } catch (GarageException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(garage.getVehicles().contains(null));
    }
}
