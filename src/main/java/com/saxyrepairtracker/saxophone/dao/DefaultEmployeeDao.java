package com.saxyrepairtracker.saxophone.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.saxyrepairtracker.saxophone.entity.Employee;
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
//new functions implemented in here 
  //May not always need a rowmapper i.e. in delete 
  
  @Override
  public List<Employee> fetchAllEmployees() {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM employee ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Employee.builder()
                .employeePK(rs.getInt("employee_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .payRate(rs.getBigDecimal("pay_rate"))
                .build();
         // @formatter:on
          }});
  }
  @Override
  public List<Employee> createEmployee(String firstName, String lastName, BigDecimal payRate) {
    // @formatter:off
    String sql = ""
        + "INSERT "
        + "INTO employee ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    params.put("pay_rate", payRate);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Employee.builder()
                .employeePK(rs.getInt("employee_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .payRate(rs.getBigDecimal("pay_rate"))
                .build();
         // @formatter:on
          }});

  }
  @Override
  public void deleteEmployee(int deleteId) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM employee "
        + "WHERE employee_pk = :employee_pk;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("employee_pk", deleteId);    
    if (jdbcTemplate.update(sql,  params) == 0) throw new NoSuchElementException();
  }
}