package org.rdouda.VehiculeManager;

public abstract class Vehicle implements IVehicle {
    protected int id;
    protected String brand;
    protected String colour;
    public Vehicle(int id, String brand, String colour){
        this.id = id;
        this.brand = brand;
        this.colour = colour;
    }
    @Override
    public void display() {
        System.out.printf("Vehicle: %d, %s, %s%n", this.id, this.brand, this.colour);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (!(obj instanceof Vehicle))
            return false;
        Vehicle vehicle = (Vehicle) obj;
        return id == vehicle.id;
    }
}