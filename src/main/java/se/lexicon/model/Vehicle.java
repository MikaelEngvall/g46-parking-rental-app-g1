package se.lexicon.model;

public class Vehicle {

    // Fields
    private final String licensePlate;
    private final VehicleType type;

    // Constructor
    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    // Getters
    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    // ToString
    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                '}';
    }
}
