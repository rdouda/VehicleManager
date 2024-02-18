package org.rdouda.VehiculeManager;

import java.util.Scanner;

/**
 * A factory class for creating Car and Truck objects based on user input.
 */
public class VehicleFactory {

    // Scanner for reading user input
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Creates a Car object by prompting the user for its information.
     *
     * @return The created Car object.
     */
    public static Car createCar() {
        System.out.println("Enter information for the Car: ");

        // Get car details from user
        int carId = getIntInput("ID: ");
        String carBrand = getStringInput("Brand: ");
        String carColor = getStringInput("Color: ");

        // Create and return the Car object
        return new Car(carId, carBrand, carColor);
    }

    /**
     * Creates a Truck object by prompting the user for its information.
     *
     * @return The created Truck object.
     */
    public static Truck createTruck() {
        System.out.println("Enter information for the Truck: ");

        // Get truck details from user
        int truckId = getIntInput("ID: ");
        String truckBrand = getStringInput("Brand: ");
        String truckColor = getStringInput("Color: ");

        // Create and return the Truck object
        return new Truck(truckId, truckBrand, truckColor);
    }

    /**
     * Closes the Scanner to release resources.
     */
    public static void closeScanner() {
        scanner.close();
    }

    // Helper methods for reading user input

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        int inputValue = scanner.nextInt();
        scanner.nextLine();
        /*
            Scanner does not consume the newline character (\n) after reading the integer.
            scanner.nextLine(); Discard the remaining newline before reading the brand and color.
         */
        return inputValue;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
