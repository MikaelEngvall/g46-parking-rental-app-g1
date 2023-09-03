package se.lexicon.data;

import se.lexicon.model.Vehicle;

import java.util.Collection;
import java.util.Optional;

public interface VehicleDao {

    Vehicle create(Vehicle data);

    Optional<Vehicle> find(String licensePlate);

    boolean remove(String licensePlate);

    Collection<Vehicle> findAll();

    void update(Vehicle data);


}
