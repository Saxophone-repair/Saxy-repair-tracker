package com.saxyrepairtracker.saxophone.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.Customer;
import com.saxyrepairtracker.saxophone.service.CustomerService;

@RestController

public class DefaultCustomerController implements CustomerController {

//public class GigController {
    
    @Autowired
    private CustomerService customerService;



@Override
public List<Customer> fetchAllCustomers() {                                                    //!!!
  return customerService.fetchAllCustomers();
}

@Override
public List<Customer> fetchACustomer(String firstName, String lastName) {                      //!!!
  // TODO Auto-generated method stub
  return customerService.fetchACustomer(firstName, lastName);
}

@Override
public List<Customer> fetchCustomerByFirstName(String firstName) {                             //!!!
  // TODO Auto-generated method stub
  return customerService.fetchCustomerByFirstName(firstName);}

@Override
public Customer createCustomer(String firstName, String lastName, String phone) {              //!!!
  // TODO Auto-generated method stub
  return customerService.createCustomer(firstName, lastName, phone);
}
    
 
}
//
