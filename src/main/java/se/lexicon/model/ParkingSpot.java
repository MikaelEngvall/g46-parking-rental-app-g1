package se.lexicon.model;

public class ParkingSpot {

    // Fields
    private int spotNumber;
    private boolean isOccupied;

    // Constructors
    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public ParkingSpot(int spotNumber, boolean isOccupied) {
        this.spotNumber = spotNumber;
        this.isOccupied = isOccupied;
    }

    // Getters
    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // Methods
    public void occupy(){
        isOccupied = true;
    }

    public void vacate(){
        isOccupied = false;
    }


    //ToString
    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
