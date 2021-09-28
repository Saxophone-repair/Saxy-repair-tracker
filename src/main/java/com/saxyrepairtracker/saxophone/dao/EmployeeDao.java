package com.saxyrepairtracker.saxophone.dao;

import java.math.BigDecimal;
import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Employee;
//Last version of functions to access database 
//Controller calls Service 
//inturn calls Dao
//interfaces need unimplemented methods that will 
public interface EmployeeDao {
  //Should be fetchAnEmployee fix/rename later
  List<Employee> fetchEmployees(String firstName, String lastName);
  //fetchEmployees orangize by order
  //List<Employees> fetchEmployeesInOrder() 
  //Does it need parameters if it will just fetch the name -no 
  //maybe have a option to have what order they would like i.e. payrate, first name, lastname, 
  //all can be organized by A first or Z first for last or first name? 
  //Payrate option having the option low or highest option of list 
  //Enums seem to be the only ways to do that so the service ticket can be access by the status 
  //enum list with ease but there may be multiple ways to sort this...

  List<Employee> fetchAllEmployees();

  void deleteEmployee(int deleteId);

  List<Employee> createEmployee(String firstName, String lastName, BigDecimal payRate);

  List<Employee> updateEmployee(int id, Employee updatedEmployee);

  //List<Employee> fetchAllEmployees();
  
  //Need 2 more get fetchemployees 
  
  //FetchEmployeesByName 
  //has 2 keys key1 =asc key2 =desc
  
  //FetchEmployeesByPayRate
  //2keys like before but by payrate value asc and desc 
  //DeleteEmployee 
  //CreateEmployee

}


