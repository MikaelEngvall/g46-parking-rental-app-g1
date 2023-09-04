package se.lexicon;

import se.lexicon.data.CustomerDao;
import se.lexicon.data.impl.CustomerDaoImpl;
import se.lexicon.data.impl.ReservationDaoImpl;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;
import se.lexicon.model.Vehicle;

import java.time.LocalTime;

import static se.lexicon.model.VehicleType.CAR;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        CustomerDao customerDao = CustomerDaoImpl.getInstance();
//        ParkingSpotDaoImpl parkingSpotDao = ParkingSpotDaoImpl.getInstance();
//        ParkingLotDaoImpl parkingLotDao = ParkingLotDaoImpl.getInstance();
//        VehicleDaoImpl vehicleDao = VehicleDaoImpl.getInstance();
        ReservationDaoImpl reservationDao = ReservationDaoImpl.getInstance();

        Customer customer = new Customer("Test Testson", "123456");
        customerDao.create(customer);
        ParkingSpot parkingSpot = new ParkingSpot(12, false);
        System.out.println("Parking spot " + parkingSpot.getSpotNumber() + " is now" + (parkingSpot.isOccupied() ? " occupied" : " free"));
        Vehicle vehicle = new Vehicle("ABC123", CAR);
        Reservation reservation = new Reservation(LocalTime.of(0,1), LocalTime.of(23,59), customer, parkingSpot, vehicle);
        reservationDao.create(reservation); // Here we reserve the spot and state it occupied
        System.out.println("Reserving parking spot : " + reservation.getParkingSpot().getSpotNumber());
        System.out.println("Parking spot " + parkingSpot.getSpotNumber() + " is now" + (parkingSpot.isOccupied() ? " occupied" : " free"));
        reservationDao.remove(reservation); // Here we vacate the spot and state it free
        System.out.println("Leaving parking spot : " + reservation.getParkingSpot().getSpotNumber());
        System.out.println("Parking spot " + parkingSpot.getSpotNumber() + " is now" + (parkingSpot.isOccupied() ? " occupied" : " free"));


    }
}
