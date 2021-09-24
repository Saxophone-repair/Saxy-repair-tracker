package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import com.saxyrepairtracker.saxophone.controller.DefaultEmployeeController;
import com.saxyrepairtracker.saxophone.dao.SaxophonesDao;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
import lombok.extern.slf4j.Slf4j;

//@Component
@Service
@Slf4j
public class DefaultSaxophonesService implements SaxophonesService {

  @Autowired
  private SaxophonesDao saxophonesDao;
 
  @Transactional(readOnly = true)
  @Override
  public List<Saxophones> fetchAllSaxophones() {                                            //!!!
        List<Saxophones> saxophones = saxophonesDao.fetchAllSaxophones();
        if(saxophones.isEmpty()) {
          String msg = String.format("We have no saxophones");
              throw new NoSuchElementException(msg);
        }
       // Collections.sort((List<Employee>) employees);
        return saxophones;
      }

//  public List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type) {
//    // TODO Auto-generated method stub
//    return saxophonesDao.getSaxophonesBySaxophoneType(type);
//  }

  public Saxophones createSaxophones(int customerFK, int serialNumber,  String manufacturer, String series,
      SaxophonesType type) {
    
    return saxophonesDao.createSaxophones(customerFK, serialNumber, manufacturer, series, type);
  }

//  public List<Saxophones> getSaxophonesManufacturer(String manufacturer) {
//    // TODO Auto-generated method stub
//    return saxophonesDao.getSaxophonesManufacturer(manufacturer);
//  }

  public List<Saxophones> updateSaxophones(int saxophonesPK, Saxophones updatedSaxophones) {
    // TODO Auto-generated method stub
    return saxophonesDao.updateSaxophones(saxophonesPK, updatedSaxophones);
  }

  public List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK) {         //!!!
    log.info("The fetchAllSaxophonesByCustomer method was called with customerFK", customerFK);
    List<Saxophones> saxophones = saxophonesDao.fetchAllSaxophonesByCustomer(customerFK);
    if(saxophones.isEmpty()) {
      String msg = String.format("We have no saxophones for this customer");
          throw new NoSuchElementException(msg);
    }
    return saxophonesDao.fetchAllSaxophonesByCustomer(customerFK);
  }

  @Override
  public List<Saxophones> createSaxophones(Saxophones saxophones) {
    // TODO Auto-generated method stub
    return null;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Saxophones> fetchSaxophones(SaxophonesType type) {                     //!!!
    log.info("The fetchSaxophones method was called with 'type={}'", type);
         List<Saxophones> saxophones = saxophonesDao.fetchSaxophones(type);
          if(saxophones.isEmpty()) {
            String msg = String.format("We have no saxophones in this type");
                throw new NoSuchElementException(msg);
          }
         // Collections.sort((List<Employee>) employees);
          return saxophones;
  }
  
//  @Transactional(readOnly = true)
//  @Override
//  public List<Employee> fetchEmployees(String firstName, String lastName) {
//    log.info("The fetchEmployees method was called with firstName={} and lastName={}",
//        firstName, lastName);
//    List<Employee> employees = employeeDao.fetchEmployees(firstName, lastName);
//    if(employees.isEmpty()) {
//      String msg = String.format("No employees found with firstName=%s and lastName=%s", firstName, lastName);
//          throw new NoSuchElementException(msg);
//    }
//   // Collections.sort((List<Employee>) employees);
//    return employees;
//  }
 
}
