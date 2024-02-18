package org.rdouda.VehiculeManager;

import org.rdouda.VehiculeManager.Exceptions.GarageException;

import java.util.ArrayList;

public class Garage {
    private String name;
    private String address;
    private final ArrayList<Vehicle> vehicles;
    public Garage(String name, String address){
        this.name = name;
        this.address = address;
        this.vehicles = new ArrayList<>();
    }

    public void add(Vehicle vehicle){
        if (vehicle != null) {
            if (!this.vehicles.contains(vehicle)) {
                vehicles.add(vehicle);
                System.out.println("Vehicle added successfully");
            } else {
                System.out.println("Error: Vehicle with same ID already exists in the Garage.");
            }
        } else {
            System.out.println("Error: Cannot add a null vehicle.");
        }
    }

    public void remove(Vehicle vehicle) throws GarageException {
        if (vehicle != null) {
            if (vehicles.contains(vehicle)) {
                vehicles.remove(vehicle);
                System.out.println("Vehicle removed successfully.");
            } else {
                throw new GarageException("Error: Vehicle not found in the garage.");
            }
        } else {
            throw new GarageException("Error: Cannot remove a null vehicle.");
        }
    }
    public void display() {
        System.out.println("List of Vehicles in the Garage:");
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
        }
    }

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
