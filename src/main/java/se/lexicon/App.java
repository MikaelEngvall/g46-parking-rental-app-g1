package se.lexicon;

import se.lexicon.data.CustomerDao;
import se.lexicon.data.impl.CustomerDaoImpl;
import se.lexicon.model.Customer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        CustomerDao customerDao = CustomerDaoImpl.getInstance();

        Customer customer = new Customer("Test Testson", "123456");
        customerDao.create(customer);
        customerDao.create(new Customer("Mehrdad", "123456"));
        System.out.println(customerDao.findAll().size()); // 2

        customerDao = CustomerDaoImpl.getInstance();
        System.out.println(customerDao.findAll().size()); // 2
//        ParkingSpot parkingSpot = new ParkingSpot(12, false);
//        System.out.println(parkingSpot.getSpotNumber());
//        System.out.println(parkingSpot.isOccupied());

    }
}
