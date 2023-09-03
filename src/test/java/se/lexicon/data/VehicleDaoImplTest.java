package se.lexicon.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import se.lexicon.data.impl.VehicleDaoImpl;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import java.util.Optional;

public class VehicleDaoImplTest {

    private VehicleDaoImpl testObject;
    private Vehicle vehicle;

    @BeforeEach
    public void setup() {
        testObject = new VehicleDaoImpl();
        vehicle = new Vehicle("ABC123", VehicleType.CAR);

    }

    // testCreate
    @Test
    public void testCreate() {
        Vehicle createdVehicle = testObject.create(vehicle);
        assertEquals(vehicle, createdVehicle);
    }

    // testCreateExistingVehicle
    @Test
    public void testCreateExistingVehicle() {
        testObject.create(vehicle); // "ABC123", VehicleType.CAR
        /*assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testObject.create(vehicle); // this line should throw a logical exception(IllegalArgumentException)
            }
        });*/

        // use lambda
        assertThrows(IllegalArgumentException.class, () -> testObject.create(vehicle));
    }


    // testFindExistingVehicle
    @Test
    public void testFindExistingVehicle() {
        testObject.create(vehicle); // "ABC123", VehicleType.CAR
        Optional<Vehicle> vehicleOptional = testObject.find("ABC123");
        assertTrue(vehicleOptional.isPresent());
    }


    // testFindNonExistingVehicle
    @Test
    public void testFindNonExistingVehicle() {
        testObject.create(vehicle); // "ABC123", VehicleType.CAR
        Optional<Vehicle> vehicleOptional = testObject.find("DAB222");
        assertFalse(vehicleOptional.isPresent());
    }

    // testRemoveExistingVehicle
    // testRemoveNonExistingVehicle

    // testUpdate
    @Test
    public void testUpdate() {
        testObject.create(vehicle); // "ABC123", VehicleType.CAR

        Vehicle toUpdate = new Vehicle("ABC123", VehicleType.TRUCK);
        testObject.update(toUpdate);

        Optional<Vehicle> vehicleOptional = testObject.find("ABC123");
        assertTrue(vehicleOptional.isPresent());

        Vehicle vehicle = vehicleOptional.get();
        assertEquals(VehicleType.TRUCK, vehicle.getType());

    }

}
