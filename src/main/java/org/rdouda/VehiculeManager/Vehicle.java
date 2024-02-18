package org.rdouda.VehiculeManager;

public abstract class Vehicle implements IVehicle {

    // Vehicle properties
    protected int id;
    protected String brand;
    protected String colour;

    /**
     * Constructor to create a new Vehicle with an ID, brand, and color.
     *
     * @param id Unique identifier for the vehicle.
     * @param brand Brand of the vehicle.
     * @param colour Color of the vehicle.
     */
    public Vehicle(int id, String brand, String colour) {
        this.id = id;
        this.brand = brand;
        this.colour = colour;
    }

    /**
     * Displays information about the vehicle.
     */
    @Override
    public void display() {
        System.out.printf("Vehicle: %d, %s, %s%n", this.id, this.brand, this.colour);
    }

    /**
     * Compares two Vehicle objects for equality.
     *
     * @param obj The object to compare with.
     * @return True if the objects have the same ID, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vehicle otherVehicle = (Vehicle) obj;
        return id == otherVehicle.id;
    }
}
