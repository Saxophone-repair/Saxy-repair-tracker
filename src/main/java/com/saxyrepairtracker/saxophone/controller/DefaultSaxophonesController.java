package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
import com.saxyrepairtracker.saxophone.service.SaxophonesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RequestMapping("/saxophone/saxophone") //?

public class DefaultSaxophonesController implements SaxophonesController {


  @Autowired
  private SaxophonesService saxophonesService;

  @Override
  public List<Saxophones> fetchSaxophones(SaxophonesType type) {
    log.debug("'type={}'", type);
    return saxophonesService.fetchSaxophones(type);
  }
  
//  @Override
//  public List<Employee> fetchEmployees(String firstName, String lastName) {
//    log.debug("firstName={}, lastName={}", firstName, lastName);
//    return employeesService.fetchEmployees(firstName, lastName);
//  }

  
  
  @Override
  public List<Saxophones> fetchAllSaxophones() {                                               //!!!
    return saxophonesService.fetchAllSaxophones();
    }
  
  @Override
  public List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK) {                       //!!!
    return saxophonesService.fetchAllSaxophonesByCustomer(customerFK);
  }
  
  @Override
  public List<Saxophones> updateSaxophones(int saxophonePK, Saxophones updatedSaxophones) {
    // TODO Auto-generated method stub
    return saxophonesService.updateSaxophones(updatedSaxophones);
  }

//  @Override
//  public List<Saxophones> getSaxophonesManufacturer(String manufacturer) {
//    // TODO Auto-generated method stub
//    return saxophonesService.getSaxophonesManufacturer(manufacturer);
//  }



  @Override                                                                                    //!!!
  public List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
                                            SaxophonesType type) {
    // TODO Auto-generated method stub
    return saxophonesService.createSaxophones(customerFK, manufacturer, series, type);
    }
}
