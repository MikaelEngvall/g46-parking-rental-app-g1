package se.lexicon;

import se.lexicon.data.CustomerDao;
import se.lexicon.data.impl.*;
import se.lexicon.model.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ParkingLotDaoImpl parkingLotDao = ParkingLotDaoImpl.getInstance();

        CustomerDao customerDao = CustomerDaoImpl.getInstance();
        ParkingSpotDaoImpl parkingSpotDao = ParkingSpotDaoImpl.getInstance();
        VehicleDaoImpl vehicleDao = VehicleDaoImpl.getInstance();
        ReservationDaoImpl reservationDao = ReservationDaoImpl.getInstance();

        HashMap<Integer, ParkingSpot> spotHashMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            ParkingSpot createdParkingSpot = parkingSpotDao.create(new ParkingSpot(i));
            spotHashMap.put(i, createdParkingSpot);
        }
        ParkingLot parkingLot = new ParkingLot(100, spotHashMap);

        ParkingLot createdParkingLot = parkingLotDao.create(parkingLot);

        createdParkingLot.displayParkingSpots();




        Customer createdCustomer = customerDao.create(new Customer("Test Testson", "123456"));
        Vehicle createdVehicle = vehicleDao.create( new Vehicle("ABC123", VehicleType.CAR));
        Optional<ParkingSpot> optionalParkingSpot = parkingSpotDao.find(5);
        if (optionalParkingSpot.isEmpty()) throw new IllegalArgumentException("Spot Number is not Valid!");
        ParkingSpot foundParkingSpot = optionalParkingSpot.get();
        if (foundParkingSpot.isOccupied()) throw new IllegalArgumentException("Parking Spot Number is already occupied!");
        parkingSpotDao.occupyParkingSpot(foundParkingSpot.getSpotNumber());

        Reservation createdReservation =  reservationDao.create(new Reservation(LocalTime.parse("09:00"), LocalTime.parse("11:00"), createdCustomer, foundParkingSpot, createdVehicle)); // Here we reserve the spot and state it occupied


        System.out.println();
        System.out.println("-------------------------------");

        System.out.println(createdReservation.toString());

        System.out.println("-------------------------------");
        createdParkingLot.displayParkingSpots();
        System.out.println();
        System.out.println("-------------------------------");
        parkingSpotDao.vacateParkingSpot(5);

        createdParkingLot.displayParkingSpots();



    }
}
