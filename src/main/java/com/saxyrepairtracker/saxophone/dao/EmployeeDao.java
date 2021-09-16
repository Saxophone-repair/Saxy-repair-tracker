package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Employee;

public interface EmployeeDao {
  List<Employee> fetchEmployees(String firstName, String lastName);

}


