package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Customer;

public interface CustomerDao {
  List<Customer> fetchCustomer(String firstName, String lastName);

  List<Customer> getCustomers();

  List<Customer> fetchCustomers(String firstName, String lastName);

  Customer createCustomer(Customer customer);

  Customer updateCustomer(Customer customer);

  Customer getCustomerFirstName(String firstName);

 
}
