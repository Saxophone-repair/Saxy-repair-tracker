package com.saxyrepairtracker.saxophone.controller;



import java.util.List;
import javax.validation.Valid;
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
  return customerService.fetchACustomer(firstName, lastName);
}

@Override
public List<Customer> fetchCustomerByFirstName(String firstName) {                             //!!!
  return customerService.fetchCustomerByFirstName(firstName);}

@Override
public Customer createCustomer(String firstName, String lastName, String phone) {              //!!!
  return customerService.createCustomer(firstName, lastName, phone);
}

@Override
public Customer updateCustomer(int customerPK, @Valid Customer updatedCustomer) {              //!!!
  return customerService.updateCustomer(customerPK, updatedCustomer);
}
    
 
}

