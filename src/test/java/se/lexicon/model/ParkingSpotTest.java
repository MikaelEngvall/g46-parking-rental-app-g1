package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingSpotTest {

    private ParkingSpot testObject;

    @BeforeEach
    public void setup() {
        testObject = new ParkingSpot(1);
    }

    @Test
    public void testGetSpotNumber() {
        int expectedNumber = 1;
        int actualNumber = testObject.getSpotNumber();
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testIsOccupyInitiallyFalse() {
        assertFalse(testObject.isOccupied());
    }

    @Test
    public void testOccupy() {
        testObject.occupy(); // isOccupied = true
        assertTrue(testObject.isOccupied());
    }

    @Test
    public void testVacate() {
        testObject.occupy(); // isOccupied = true
        testObject.vacate(); // isOccupied = false
        assertFalse(testObject.isOccupied());
    }


}
