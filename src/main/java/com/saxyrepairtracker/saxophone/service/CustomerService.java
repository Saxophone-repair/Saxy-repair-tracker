package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Customer;

public interface CustomerService {

  List<Customer> fetchCustomer(String firstName, String lastName);

  List<Customer> getCustomers();

  Customer createCustomer(Customer customer);
}
