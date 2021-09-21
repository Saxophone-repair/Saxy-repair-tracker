package com.saxyrepairtracker.saxophone.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.saxyrepairtracker.saxophone.dao.EmployeeDao;
import com.saxyrepairtracker.saxophone.entity.Employee;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEmployeeService implements EmployeesService{
    
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional(readOnly = true)
    @Override
    public List<Employee> fetchEmployees(String firstName, String lastName) {
      log.info("The fetchEmployees method was called with firstName={} and lastName={}",
          firstName, lastName);
      
      List<Employee> employees = employeeDao.fetchEmployees(firstName, lastName);
      
      
      if(employees.isEmpty()) {
        String msg = String.format("No jeeeps found with firstName=%s and lastName=%s", firstName, lastName);
            throw new NoSuchElementException(msg);
      }
      
     // Collections.sort((List<Employee>) employees);
      return employees;
    }

  }



