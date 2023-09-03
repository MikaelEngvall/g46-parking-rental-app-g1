package se.lexicon.data.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import java.util.Optional;

public class CustomerDaoImplTest {

    private CustomerDaoImpl testObject;

    @BeforeEach
    public void setup(){
        //testObject = new CustomerDaoImpl();
        testObject = CustomerDaoImpl.getInstance();
    }

    @Test
    public void testCreateCustomer(){
        Customer customer = new Customer("Test Testson", "123456");
        Customer createdCustomer = testObject.create(customer);
        Assertions.assertNotNull(createdCustomer);
    }

    @Test
    public void testFindById(){
        Customer customer = new Customer("Test Testson", "123456");
        Customer createdCustomer = testObject.create(customer);
        Assertions.assertNotNull(createdCustomer);
        Optional<Customer> customerOptional = testObject.find(createdCustomer.getId());
        Assertions.assertTrue(customerOptional.isPresent());
    }


}
