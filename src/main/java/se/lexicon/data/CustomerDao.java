package se.lexicon.data;

import se.lexicon.model.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer, Integer> {

    List<Customer> findAll();

}
