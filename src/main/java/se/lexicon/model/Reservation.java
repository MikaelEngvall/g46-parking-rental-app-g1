package se.lexicon.model;

import java.time.LocalTime;
import java.util.UUID;

public class Reservation {

    // Fields
    private String id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Customer customer;
    private ParkingSpot parkingSpot;
    private Vehicle associatedVehicle;

    // Constructors

    public Reservation() {
        this.id = UUID.randomUUID().toString();
    }

    public Reservation(LocalTime startTime, LocalTime endTime, ParkingSpot parkingSpot) {
        this();
        this.startTime = startTime;
        this.endTime = endTime;
        this.parkingSpot = parkingSpot;
    }

    public Reservation(String id, LocalTime startTime, LocalTime endTime, Customer customer, ParkingSpot parkingSpot, Vehicle associatedVehicle) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
        this.parkingSpot = parkingSpot;
        this.associatedVehicle = associatedVehicle;
    }

    public Reservation(LocalTime startTime, LocalTime endTime, Customer customer, ParkingSpot parkingSpot, Vehicle associatedVehicle) {
        this();
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
        this.parkingSpot = parkingSpot;
        this.associatedVehicle = associatedVehicle;
    }

    // Setters & Getters
    public String getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getAssociatedVehicle() {
        return associatedVehicle;
    }

    // ToString


    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", customer=" + customer +
                ", parkingSpot=" + parkingSpot +
                ", associatedVehicle=" + associatedVehicle +
                '}';
    }
}
