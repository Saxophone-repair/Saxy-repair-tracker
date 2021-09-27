package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Customer;

public interface CustomerDao {
  List<Customer> fetchAllCustomers();                                                          //!!!
  
  List<Customer> fetchACustomer(String firstName, String lastName);                            //!!!
  
  List<Customer> fetchCustomerByFirstName(String firstName);                                   //!!!

//  List<Customer> fetchMultipleCustomers(String firstName, String lastName);

  Customer createCustomer(String firstName, String lastName, String phone);                    //!!!

  Customer updateCustomer(Customer customer);



 
}
