package org.rdouda.VehiculeManager;

import org.rdouda.VehiculeManager.Exceptions.GarageException;
import java.util.ArrayList;

/**
 * Represents a garage for storing vehicles. It supports adding, removing, and displaying vehicles.
 */
public class Garage {

    // Garage properties
    private String name;
    private String address;
    private final ArrayList<Vehicle> vehicles;

    /**
     * Constructs a new Garage with the specified name and address.
     *
     * @param name Name of the garage.
     * @param address Address of the garage.
     */
    public Garage(String name, String address) {
        this.name = name;
        this.address = address;
        this.vehicles = new ArrayList<>(); // Initialize vehicle list
    }

    /**
     * Adds a vehicle to the garage.
     *
     * @param vehicle The vehicle to be added.
     * @throws GarageException if the vehicle is null or already exists in the garage with the same ID.
     */
    public void add(Vehicle vehicle) throws GarageException {
        if (vehicle != null) {
            if (!this.vehicles.contains(vehicle)) {
                vehicles.add(vehicle);
                System.out.println("Vehicle added successfully");
            } else {
                System.out.println("Error: Vehicle with same ID already exists in the Garage.");
                throw new GarageException("Duplicate vehicle ID found.");
            }
        } else {
            System.out.println("Error: Cannot add a null vehicle.");
            throw new GarageException("Null vehicle cannot be added.");
        }
    }

    /**
     * Removes a vehicle from the garage.
     *
     * @param vehicle The vehicle to be removed.
     * @throws GarageException if the vehicle is not found in the garage or is null.
     */
    public void remove(Vehicle vehicle) throws GarageException {
        if (vehicle != null) {
            if (vehicles.contains(vehicle)) {
                vehicles.remove(vehicle);
                System.out.println("Vehicle removed successfully.");
            } else {
                throw new GarageException("Vehicle not found in the garage.");
            }
        } else {
            throw new GarageException("Cannot remove a null vehicle.");
        }
    }

    /**
     * Displays information about all vehicles in the garage.
     */
    public void display() {
        System.out.println("List of Vehicles in the Garage:");
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
        }
    }

    // Getters and setters for garage properties

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
