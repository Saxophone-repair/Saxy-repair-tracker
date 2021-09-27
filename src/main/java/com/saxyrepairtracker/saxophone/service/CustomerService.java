package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Customer;

public interface CustomerService {

  List<Customer> fetchAllCustomers();                                                          //!!!
  
  List<Customer> fetchACustomer(String firstName, String lastName);                            //!!!

  List<Customer> fetchCustomerByFirstName(String firstName);                                   //!!!

  Customer createCustomer(String firstName, String lastName, String phone);                    //!!!
  
  Customer updateCustomer(Customer updatedCustomer);




}

