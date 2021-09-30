package com.saxyrepairtracker.saxophone.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;

//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//import com.promineotech.jeep.entity.Jeep;
//import com.promineotech.jeep.entity.JeepModel;
//import com.promineotech.jeep.service.JeepSalesService;
//import lombok.extern.slf4j.Slf4j;
//
//
//@RestController
//@Slf4j
//public class DefaultJeepSalesController implements JeepSalesController {
//  
//  @Autowired
//  private JeepSalesService jeepSalesService;
//  
//  @Override
//  public List<Jeep> fetchJeeps(JeepModel model, String trim) {
//    //by default Spring logs by info not debug 
//    log.debug("model={}, trim={}", model, trim);
//    return jeepSalesService.fetchJeeps(model, trim);
//  }
//
//}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.Employee;
import com.saxyrepairtracker.saxophone.service.EmployeesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEmployeeController implements EmployeeController{

//@Autowired
//private JeepSalesService jeepSalesService;
  @Autowired 
  private EmployeesService employeesService;
  //this is what swagger sees this is how 
 // @Override
//public List<Jeep> fetchJeeps(JeepModel model, String trim) {
//  //by default Spring logs by info not debug 
//  log.debug("model={}, trim={}", model, trim);
//  return jeepSalesService.fetchJeeps(model, trim);
  
  //change to employee not fetchemployee 
  @Override
  public List<Employee> fetchEmployees(String firstName, String lastName, BigDecimal payRate) {
    log.debug("firstName={}, lastName={}, payRate={}", firstName, lastName, payRate);
    return employeesService.fetchEmployees(firstName, lastName, payRate);
  }
 
  //Get All Employees 
  @Override
  public List<Employee> fetchAllEmployees() {
    return employeesService.fetchAllEmployees();
  }
  
  //createEmployee

//  public List<Employee> createEmployee(String firstName, String lastName, BigDecimal payRate) {
//    log.debug("firstName={}, lastName={}", firstName, lastName, payRate);
//    return employeesService.createEmployee(firstName, lastName, payRate);
//  }
  
  //updateEmployee //may need to alter due the fact gets id then updates?
//  @Override
//  public List<Employee> updateEmployee(String firstName, String lastName) {
//    log.debug("firstName={}, lastName={}", firstName, lastName);
//    return employeesService.updateEmployee(firstName, lastName);
//  }
  
  //deleteEmployee
    @Override
    public void deleteEmployee(int deleteId) {
    log.debug("employeePK={}", deleteId);
    employeesService.deleteEmployee(deleteId);
    }

    @Override
    public Employee createEmployee(String firstName, String lastName, BigDecimal payRate) {
      return employeesService.createEmployee(firstName, lastName, payRate);
    }

//    @Override
//    public List<Employee> updateEmployee(String firstName, String lastName, BigDecimal payRate) {
//      return employeesService.updateEmployee(firstName, lastName, payRate);
//    }
//    
    @Override
    public Employee updateEmployee(int employeePK, @Valid Employee updatedEmployee) {
      return employeesService.updateEmployee(employeePK, updatedEmployee);
    }
}
