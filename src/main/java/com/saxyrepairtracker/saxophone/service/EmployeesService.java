package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Employee;

public interface EmployeesService {
    List<Employee> fetchEmployees(String firstName, String lastName);
}
