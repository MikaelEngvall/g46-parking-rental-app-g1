package se.lexicon.data.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.ParkingSpot;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingSpotDaoImplTest {

    private ParkingSpotDaoImpl testObject;
    private ParkingSpot parkingSpot;

    @BeforeEach
    public void setup() {
        testObject = ParkingSpotDaoImpl.getInstance();
        parkingSpot = new ParkingSpot(1, false);
    }

    @Test
    void testSingletonDesignPattern() {
        ParkingSpotDaoImpl instance1 = ParkingSpotDaoImpl.getInstance();
        ParkingSpotDaoImpl instance2 = ParkingSpotDaoImpl.getInstance();

        System.out.println("Instance 1 hash: " + instance1.hashCode());
        System.out.println("Instance 2 hash: " + instance2.hashCode());

        Assertions.assertEquals(instance1, instance2);
    }

    @Test
    void testCreate() {
        assertEquals(parkingSpot.getSpotNumber(), testObject.create(parkingSpot).getSpotNumber());
    }

    @Test
    void testFind() {
        testObject.create(parkingSpot);

        Optional<ParkingSpot> parkingSpotFound = testObject.find(1);
        assertEquals(1, parkingSpotFound.get().getSpotNumber());
    }

    @Test
    void testOccupyParkingSpot() {
        testObject.create(parkingSpot);
        parkingSpot.occupy();

        Optional<ParkingSpot> parkingSpot = testObject.find(1);
        assertTrue(parkingSpot.get().isOccupied());
    }

    @Test
    void testVacateParkingSpot() {
        testObject.create(parkingSpot);
        parkingSpot.occupy();
        parkingSpot.vacate();

        Optional<ParkingSpot> parkingSpot = testObject.find(1);
        assertFalse(parkingSpot.get().isOccupied());
    }
}
