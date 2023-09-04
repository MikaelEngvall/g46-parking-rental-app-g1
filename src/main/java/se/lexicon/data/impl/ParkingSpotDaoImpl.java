package se.lexicon.data.impl;

import se.lexicon.data.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {

    // Implementing the Singleton design pattern
    private static ParkingSpotDaoImpl instance;
    private List<ParkingSpot> parkingSpots;

    private ParkingSpotDaoImpl() {
        parkingSpots = new ArrayList<>();
    }

    public static ParkingSpotDaoImpl getInstance() {
        if (instance == null) {
            instance = new ParkingSpotDaoImpl();
        }
        return instance;
    }

    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        if (parkingSpot == null) throw new IllegalArgumentException("Parking spot is null.");
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> find(Integer spotNumber) {
        if (spotNumber == null) throw new IllegalArgumentException("Spot is null.");
        // Implementing the find method

        for (ParkingSpot parkingSpot : parkingSpots) {
            // This loop iterates through all the parking spots stored in the parkingSpots list.

            if (parkingSpot.getSpotNumber() == spotNumber) {
                // For each parking spot, it checks if the spot number matches the provided spotNumber.

                return Optional.of(parkingSpot);
                // If a match is found, it wraps the matching ParkingSpot object in an Optional and returns it.
            }
        }

        // If no matching parking spot is found in the loop, it means the spotNumber doesn't exist.
        // In this case, it returns an empty Optional to indicate that no result was found.
        return Optional.empty();
    }


    @Override
    public void occupyParkingSpot(int spotNumber) {
        // Implementing the occupyParkingSpot method
        parkingSpots.forEach(parkingSpot -> {
            if (parkingSpot.getSpotNumber() == spotNumber){
                parkingSpot.occupy();
            }
        });
    }

    @Override
    public void vacateParkingSpot(int spotNumber) {
        parkingSpots.forEach(parkingSpot -> {
            if (parkingSpot.getSpotNumber() == spotNumber){
                parkingSpot.vacate();
            }
        });
    }
}
