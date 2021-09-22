package com.saxyrepairtracker.saxophone.service;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import com.saxyrepairtracker.saxophone.entity.Employee;
//every interface is just a list of the set of functions for the employees
public interface EmployeesService {
    List<Employee> fetchEmployees(String firstName, String lastName);

    List<Employee> fetchAllEmployees();

    void deleteEmployee(int deleteId);

    List<Employee> updateEmployee(int id, @Valid Employee updatedEmployee);

    List<Employee> createEmployee(@Valid Employee newEmployee);

}
