package com.saxyrepairtracker.saxophone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.saxyrepairtracker.saxophone.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  public List<Customer> fetchAllCustomers() {                                                  //!!!
    log.info("In customer.dao.fetchAllCustomers");
    
      // @formatter:off
      String sql = ""
          +"SELECT * "
          + "FROM customer;";
      // @formatter:on  
     
      Map<String, Object> params = new HashMap<>();
      return jdbcTemplate.query(sql,
          new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
              // @formatter:off
              return Customer.builder()
                  .customerPK(rs.getInt("customer_pk"))
                  .firstName(rs.getString("first_name"))
                  .lastName(rs.getString("last_name"))
                  .phone(rs.getString("phone"))
                  .build();
              // @formatter:on
            }});
    }
  
    // Retrieve data from database and return to service layer
  public List<Customer> fetchACustomer(String firstName, String lastName) {                    //!!!
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customer "
        + "WHERE first_name = :first_name AND last_name = :last_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Customer.builder()
                .customerPK(rs.getInt("customer_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .phone(rs.getString("phone"))
                .build();
         // @formatter:on
          }});

  }
  
  public List<Customer> fetchCustomerByFirstName(String firstName) {                           //!!!
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customer "
        + "WHERE first_name = :first_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Customer.builder()
                .customerPK(rs.getInt("customer_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .phone(rs.getString("phone"))
                .build();
         // @formatter:on
          }});
  }

  
  
 

  public Customer createCustomer(String firstName, String lastName, String phone) {            //!!!
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into customer "
        + "(first_name, last_name, phone)" 
        + "VALUES (:first_name, :last_name, :phone)" ;
    sqlparams.source.addValue("first_name", firstName);
    sqlparams.source.addValue("last_name", lastName);
    sqlparams.source.addValue("phone", phone);
    

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Customer.builder()
        .customerPK(keyHolder.getKey().intValue())
        .firstName(firstName)
        .lastName(lastName)
        .phone(phone)
        .build();
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  
  
  
  
  public Customer updateCustomer(int customerPK, Customer updatedCustomer) {                   //!!!
    // @formatter:off
    String sql = ""
        + "UPDATE customer "
        + "SET "
        + "first_name = :first_name, "
        + "last_name = :last_name, "
        + "phone = :phone "
        + "WHERE customer_pk = :customer_pk;";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", updatedCustomer.getFirstName());
    params.put("last_name", updatedCustomer.getLastName());
    params.put("phone", updatedCustomer.getPhone());
    params.put("customer_pk", customerPK);
    
  //  jdbcTemplate.update(sql, params);
      if (jdbcTemplate.update(sql, params) == 0) {
       throw new NoSuchElementException("update failed :( ");
      }
    return Customer.builder()
        .customerPK(customerPK)
        .firstName(updatedCustomer.getFirstName())
        .lastName(updatedCustomer.getLastName())
        .phone(updatedCustomer.getPhone())
        .build();
    
  }
 }



