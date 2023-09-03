package se.lexicon.data.impl;

import se.lexicon.data.ParkingLotDao;
import se.lexicon.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotDaoImpl implements ParkingLotDao {

    // Implementing a Singleton design pattern
    private static ParkingLotDaoImpl instance;
    private List<ParkingLot> parkingLots;

    private ParkingLotDaoImpl() {
        parkingLots = new ArrayList<>();
    }

    public static ParkingLotDaoImpl getInstance() {
        if (instance == null) {
            instance = new ParkingLotDaoImpl();
        }
        return instance;
    }

    @Override
    public ParkingLot create(ParkingLot parkingLot) {
        if (parkingLot == null) throw new IllegalArgumentException("Parking lot data is null.");
        parkingLots.add(parkingLot);
        return parkingLot;
    }

    @Override
    public Optional<ParkingLot> find(Integer lot) {
        if (lot == null) throw new IllegalArgumentException("Lot is null.");
        Optional<ParkingLot> foundParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getParkingSpots().equals(lot))
                .findFirst();
        return foundParkingLot;
    }
}
