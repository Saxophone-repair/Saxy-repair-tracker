package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saxyrepairtracker.saxophone.dao.CustomerDao;
import com.saxyrepairtracker.saxophone.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultCustomerService implements CustomerService{
  
  @Autowired
  private CustomerDao customerDao;
  
  
  @Override
  public List<Customer> fetchCustomer(String firstName, String lastName) {
    log.info("Fetch Customer in service layer");
    return null;
  }

  @Override
  public List<Customer> getCustomers() {
     log.info("get Customers in service layer");
    return customerDao.getCustomers();
  }

  @Override
  public Customer createCustomer(Customer customer) {
    log.info("create Customers in service layer");
    return customer;
  }

  @Override
  public Customer updateCustomer(Customer customer) {
    log.info("create Customers in service layer");
    return customer;
  }

  @Override
  public Customer getCustomerFirstName(String firstName) {
    // TODO Auto-generated method stub
    return null;
  }

//  @Override
//  public Customer getCustomerFirstName(String firstName) {
//    log.info("pulls Customers in the service layer with a requested first name");
//    return Customer;
//  }

}
