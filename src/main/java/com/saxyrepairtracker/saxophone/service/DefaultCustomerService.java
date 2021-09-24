package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.saxyrepairtracker.saxophone.dao.CustomerDao;
import com.saxyrepairtracker.saxophone.entity.Customer;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultCustomerService implements CustomerService{
  
  @Autowired
  private CustomerDao customerDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchACustomer(String firstName, String lastName) {
    log.info("Fetch Customer in service layer");
    return customerDao.fetchACustomer(firstName, lastName);
  }

//  @Transactional(readOnly = true)
//  @Override
//  public List<Saxophones> fetchAllSaxophones() {                                            //!!!
//        List<Saxophones> saxophones = saxophonesDao.fetchAllSaxophones();
//        if(saxophones.isEmpty()) {
//          String msg = String.format("We have no saxophones");
//              throw new NoSuchElementException(msg);
//        }
//       // Collections.sort((List<Employee>) employees);
//        return saxophones;
//      }
  
  @Override
  public List<Customer> fetchAllCustomers() {
     log.info("get Customers in service layer");
    return customerDao.fetchAllCustomers();
  }

  @Override
  public Customer createCustomer(Customer customer) {
    log.info("create Customers in service layer");
    return customerDao.createCustomer(customer);
  }

  @Override
  public Customer updateCustomer(Customer customer) {
    log.info("create Customers in service layer");
    return customerDao.updateCustomer(customer);
  }

  @Override
  public List<Customer> fetchCustomerByFirstName(String firstName) {
    // TODO Auto-generated method stub
    return customerDao.fetchCustomerByFirstName(firstName);
  }

//  @Override
//  public Customer getCustomerFirstName(String firstName) {
//    // TODO Auto-generated method stub
//    return null;
//  }

//  @Override
//  public Customer getCustomerFirstName(String firstName) {
//    log.info("pulls Customers in the service layer with a requested first name");
//    return Customer;
//  }

}
