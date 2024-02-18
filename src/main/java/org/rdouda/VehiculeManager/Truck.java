package org.rdouda.VehiculeManager;

public class Truck extends Vehicle {
    private String driver;
    public Truck(int id, String brand, String colour) {
        super(id, brand, colour);
    }
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
