package org.rdouda.VehiculeManager;

public class Truck extends Vehicle {

    // Additional property specific to trucks
    private String driver;

    /**
     * Constructor to create a new Truck object inheriting properties from Vehicle.
     *
     * @param id Unique identifier for the truck.
     * @param brand Brand of the truck.
     * @param colour Color of the truck.
     */
    public Truck(int id, String brand, String colour) {
        super(id, brand, colour); // Call Vehicle's constructor to initialize common properties
    }

    /**
     * Gets the driver assigned to the truck.
     *
     * @return The driver's name.
     */
    public String getDriver() {
        return driver;
    }

    /**
     * Sets the driver assigned to the truck.
     *
     * @param driver The driver's name.
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }
}
