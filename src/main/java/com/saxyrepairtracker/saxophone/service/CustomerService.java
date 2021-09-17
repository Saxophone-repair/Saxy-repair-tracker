package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import org.springframework.util.MultiValueMap;
import com.saxyrepairtracker.saxophone.entity.Customer;

public interface CustomerService {

  List<Customer> fetchCustomer(String firstName, String lastName);

  List<Customer> getCustomers();

  Customer createCustomer(Customer customer);

  Customer updateCustomer(Customer customer);

  Customer getCustomerFirstName(String firstName);
}
