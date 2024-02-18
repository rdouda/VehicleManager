package org.rdouda;

import org.rdouda.VehiculeManager.*;
import org.rdouda.VehiculeManager.Exceptions.GarageException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class for the Garage Management System, providing a professional and user-friendly
 * interface for managing vehicles in a garage.
 */
public class Main {

    private static final Garage garage = new Garage("City Garage", "238 State St");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    displayVehicles();
                    break;
                case 4:
                    garage.setName(getNewName());
                    System.out.println("Garage name updated successfully!");
                    break;
                case 5:
                    garage.setAddress(getNewAddress());
                    System.out.println("Garage address updated successfully!");
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    VehicleFactory.closeScanner();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nGarage Management System");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle");
        System.out.println("3. Display Vehicles");
        System.out.println("4. Update Garage Name");
        System.out.println("5. Update Garage Address");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Prompts the user for input.
     * the input to ensure it is an integer within the valid range.
     * @return The user's choice as an integer.
     */
    private static int getChoice() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    /**
     * Guides the user through adding a new vehicle to the garage, providing clear instructions
     * and handling potential exceptions.
     */
    private static void addVehicle() {
        System.out.println("\nAdd Vehicle:");
        System.out.print("1. Add Car\n2. Add Truck: ");
        int choice = getChoice();

        try {
            if (choice == 1) {
                garage.add(VehicleFactory.createCar());
            } else if (choice == 2) {
                garage.add(VehicleFactory.createTruck());
            } else {
                System.out.println("Invalid choice. Vehicle not added.");
            }
        } catch (GarageException e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
        }
    }

    // Allows the user to remove a vehicle from the garage by its ID.
    private static void removeVehicle() {
        System.out.println("\nRemove Vehicle:");
        int id = getVehicleId();

        try {
            // Retrieve the vehicle to be removed and remove it from the garage
            garage.remove(getVehicleById(id));
            System.out.println("Vehicle removed successfully.");
        } catch (GarageException e) {
            System.out.println("Error removing vehicle: " + e.getMessage());
        }
    }

    // Displays a list of all vehicles currently stored in the garage.
    private static void displayVehicles() {
        System.out.println("\nList of Vehicles:");
        garage.display(); // Calls the display method of the Garage class
    }

    // Prompts the user to enter a vehicle ID for removal or other operations.
    private static int getVehicleId() {
        System.out.print("Enter vehicle ID: ");
        return getChoice(); // Uses the getChoice method for input validation
    }

    // Retrieves a vehicle from the garage based on its ID.
    // Throws a GarageException if the vehicle is not found.
    private static Vehicle getVehicleById(int id) throws GarageException {
        for (Vehicle vehicle : garage.getVehicles()) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        throw new GarageException("Vehicle with ID " + id + " not found.");
    }

    // Prompts the user to enter a new name for the garage.
    private static String getNewName() {
        System.out.print("Enter new name for the garage: ");
        return scanner.nextLine();
    }

    // Prompts the user to enter a new address for the garage.
    private static String getNewAddress() {
        System.out.print("Enter new address for the garage: ");
        return scanner.nextLine();
    }
}
