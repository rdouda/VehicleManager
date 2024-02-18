package org.rdouda.VehiculeManager;

import java.util.Scanner;

public class VehicleFactory {
    private static final Scanner scanner = new Scanner(System.in);
    public static Car createCar(){
        System.out.println("Enter information for the Car: ");
        System.out.print("ID:    ");
        int carId = scanner.nextInt();
        scanner.nextLine();
        /*
            Scanner does not consume the newline character (\n) after reading the integer.
            scanner.nextLine(); Discard the remaining newline before reading the brand and color.
         */
        System.out.print("Brand: ");
        String carBrand = scanner.nextLine();
        System.out.print("Color: ");
        String carColor = scanner.nextLine();
        Car car = new Car(carId, carBrand, carColor);
        return car;
    }

    public static Truck createTruck(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter information for the Truck: ");
        System.out.print("ID:    ");
        int carId = scanner.nextInt();
        scanner.nextLine();
        /*
            Scanner does not consume the newline character (\n) after reading the integer.
            scanner.nextLine(); Discard the remaining newline before reading the brand and color.
         */
        System.out.print("Brand: ");
        String carBrand = scanner.next();
        System.out.print("Color: ");
        String carColor = scanner.next();
        Truck truck = new Truck(carId, carBrand, carColor);
        return truck;
    }

    public static void closeScanner(){
        scanner.close();
    }
}
