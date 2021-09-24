package com.saxyrepairtracker.saxophone.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.Customer;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.service.CustomerService;

@RestController

public class DefaultCustomerController implements CustomerController {

//public class GigController {
    
    @Autowired
    private CustomerService customerService;

//@Override
//public List<Customer> fetchCustomers() {
//  // TODO Auto-generated method stub
//  return null;
//}

@Override
public List<Customer> fetchAllCustomers() {
  // TODO Auto-generated method stub
  return null;
}

@Override
public List<Customer> fetchACustomer() {
  // TODO Auto-generated method stub
  return null;
}

@Override
public List<Customer> fetchCustomerByFirstName() {
  // TODO Auto-generated method stub
  return null;
}
    
 
}
//
