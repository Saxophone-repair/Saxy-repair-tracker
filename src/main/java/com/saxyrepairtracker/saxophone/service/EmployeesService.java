package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Employee;
//every interface is just a list of the set of functions for the employees
public interface EmployeesService {
    List<Employee> fetchEmployees(String firstName, String lastName);
}
