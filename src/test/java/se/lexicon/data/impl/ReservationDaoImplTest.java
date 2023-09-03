package se.lexicon.data.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.data.impl.ReservationDaoImpl;
import se.lexicon.data.sequencer.CustomerIdSequencer;
import se.lexicon.model.*;

import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationDaoImplTest {


    private ReservationDaoImpl testObject;
    private Customer customer;
    private Reservation reservation;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;

    @BeforeEach
    public void setup() {
        testObject = ReservationDaoImpl.getInstance();
        customer = new Customer(CustomerIdSequencer.nextId(), "Mikael Engvall", "123456");
        parkingSpot = new ParkingSpot(1, false);
        vehicle = new Vehicle("ABC-123", VehicleType.CAR);
        reservation = new Reservation("Reservation Id", LocalTime.now(), LocalTime.now().plusHours(1), customer, parkingSpot, vehicle);
    }

    @Test
    void testSingletonDesignPattern() {
        ReservationDaoImpl instance1 = ReservationDaoImpl.getInstance();
        ReservationDaoImpl instance2 = ReservationDaoImpl.getInstance();

        System.out.println("Instance 1 hash: " + instance1.hashCode());
        System.out.println("Instance 2 hash: " + instance2.hashCode());

        Assertions.assertEquals(instance1, instance2);
    }

    @Test
    void testCreate() {
        testObject.create(reservation);
        Optional<Reservation> reservationFound = testObject.find("Reservation Id");
        assertEquals(reservation.getId(), reservationFound.get().getId());
    }

    @Test
    void testFind() {
        testObject.create(reservation);
        Optional<Reservation> reservationFound = testObject.find("Reservation Id");
        assertEquals(reservationFound.get().getId(), reservation.getId());
    }
}