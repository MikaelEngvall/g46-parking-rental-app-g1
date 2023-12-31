package se.lexicon.data.impl;

import se.lexicon.data.ReservationDao;
import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationDaoImpl implements ReservationDao {

    // Implementing the Singleton design pattern
    private static ReservationDaoImpl instance;
    private List<Reservation> reservations;

    private ReservationDaoImpl() {
        reservations = new ArrayList<>();
    }

    public static ReservationDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReservationDaoImpl();
        }
        return instance;
    }

    @Override
    public Reservation create(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Reservation is null.");
        // Implementing the create method
        reservations.add(reservation);
        reservation.getParkingSpot().occupy(); // This states the spot occupied
        return reservation;
    }
    @Override
    public Reservation remove(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Reservation is null.");
        // Implementing the create method
        reservations.remove(reservation);
        reservation.getParkingSpot().vacate(); // This states the spot free
        return reservation;
    }
    @Override
    public Optional<Reservation> find(String reservationId) {
        if (reservationId == null) throw new IllegalArgumentException("Reservation Id is null.");
        // Implementing the find method
        for (Reservation reservation : reservations) {
            if (reservation.getId().equals(reservationId)) {
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }
}
