package com.saxyrepairtracker.saxophone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.saxyrepairtracker.saxophone.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
    // Retrieve data from database and return to service layer
  public static List<Customer> fetchCustomer(String firstName, String lastName) {
    log.info("In customer.dao.getCustomer");
    return null;
  }
  
  
  public List<Customer> getCustomers() {
    log.info("In customer.dao.getCustomers");
    
      // @formatter:off
      String sql = ""
          +"SELECT * "
          + "FROM customers; ";
      // @formatter:on  
      
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

  public static Customer createCustomer(Customer customer) {
    log.info("In customer.dao.getCustomers");
    return customer;
  }
  
  public static Customer updateCustomer(Customer customer) {
    log.info("create Customers in service layer");
    return customer;
  }
  
  public static String getCustomerFirstName(String firstName) { //?
    log.info("Pull customers in service layer with certain name");
    return firstName;
  }
}
