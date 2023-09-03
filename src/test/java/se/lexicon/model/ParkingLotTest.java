package se.lexicon.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotTest {

    private ParkingLot testObject;

    @BeforeEach
    public void setup() {

        Map<Integer, ParkingSpot> parkingSpotMap = new HashMap<>();
        parkingSpotMap.put(1, new ParkingSpot(1, true));
        parkingSpotMap.put(2, new ParkingSpot(2, false));
        parkingSpotMap.put(3, new ParkingSpot(3, true));

        testObject = new ParkingLot(123, parkingSpotMap);
    }

    @Test
    public void testGetAreaCode() {
        int expectedAreCode = 123;
        assertEquals(expectedAreCode, testObject.getAreaCode());
    }

    @Test
    public void testGetParkingSpotsSize3() {
        int expected = 3;
        int actual = testObject.getParkingSpots().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAvailableParkingSpotsSize1() {
        int expected = 1;
        int actual = testObject.getAvailableParkingSpots().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetParkingSpotBySpotId2(){
        ParkingSpot parkingSpot = testObject.getParkingSpotBySpotNumber(2);
        assertNotNull(parkingSpot);
    }


    @Test
    public void testGetParkingSpotBySpotInvalidId(){
        ParkingSpot parkingSpot = testObject.getParkingSpotBySpotNumber(5);
        assertNull(parkingSpot);
    }


}
