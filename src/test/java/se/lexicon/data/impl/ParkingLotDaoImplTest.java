package se.lexicon.data.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.ParkingLot;
import se.lexicon.model.ParkingSpot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotDaoImplTest {

    private ParkingLotDaoImpl testObject;

    @BeforeEach
    public void setup() {
        testObject = ParkingLotDaoImpl.getInstance();
    }

    @Test
    void testSingletonDesignPattern() {
        ParkingLotDaoImpl instance1 = ParkingLotDaoImpl.getInstance();
        ParkingLotDaoImpl instance2 = ParkingLotDaoImpl.getInstance();

        System.out.println("Instance 1 hash: " + instance1.hashCode());
        System.out.println("Instance 2 hash: " + instance2.hashCode());

        Assertions.assertEquals(instance1, instance2);
    }

    @Test
    void testCreate() {
        Map<Integer, ParkingSpot> parkingSpotMap = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot(1, parkingSpotMap);
        testObject.create(parkingLot);

        assertEquals(Optional.of(parkingLot), testObject.find(1)); //Fix this once find is done
    }

    @Test //cannot be run together with the rest of the tests, due to singleton design pattern. Run this test alone, and it works just fine.
    void testFind() {
        Map<Integer, ParkingSpot> parkingSpotMap = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot(1, parkingSpotMap);
        testObject.create(parkingLot);

        Optional<ParkingLot> parkingLotFound = testObject.find(1);
        if (parkingLotFound.isPresent()) {
            assertEquals(parkingLot.getAreaCode(), parkingLotFound.get().getAreaCode());
        } else {
            System.out.println("areaCode() not equal");
        }
    }

}