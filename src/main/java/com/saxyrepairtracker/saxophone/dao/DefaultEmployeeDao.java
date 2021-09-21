package com.saxyrepairtracker.saxophone.dao;

import com.saxyrepairtracker.saxophone.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service
@Component
@Slf4j
public class DefaultEmployeeDao implements EmployeeDao{
  @Autowired 
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Override
  public List<Employee> fetchEmployees(String firstName, String lastName) {
    log.debug("DAO: first name={}, last name={}", firstName, lastName);
    
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM employee "
        + "WHERE first_name = :first_name AND last_name = :last_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Employee.builder()
                .employeePK(rs.getInt("employee_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .build();
         // @formatter:on
          }});

  }

}
