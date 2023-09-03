package se.lexicon.model;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReservationTest {

    private Reservation testObject;

    @Test
    public void testConstructorWithoutId() {
        Customer customer = new Customer("Test Testson", "123456789");
        ParkingSpot parkingSpot = new ParkingSpot(1);
        Vehicle vehicle = new Vehicle("abc 123", VehicleType.CAR);
        testObject = new Reservation(LocalTime.parse("10:00"), LocalTime.parse("12:00"), customer, parkingSpot, vehicle);

        assertNull(testObject.getId());
        assertEquals("Test Testson", customer.getName());
        //...
    }


}
