package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Customer;

public interface CustomerService {

  List<Customer> fetchACustomer(String firstName, String lastName);

  List<Customer> fetchAllCustomers();

  Customer createCustomer(Customer customer);

  Customer updateCustomer(Customer customer);

  List<Customer> fetchCustomerByFirstName(String firstName);
}
