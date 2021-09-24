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
public class DefaultCustomerDao implements CustomerDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
    // Retrieve data from database and return to service layer
  public List<Customer> fetchACustomer(String firstName, String lastName) {
    log.info("In customer.dao.getCustomer");
    return null;
  }
  
  
  public List<Customer> fetchAllCustomers() {
    log.info("In customer.dao.fetchAllCustomers");
    
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

  public Customer createCustomer(Customer customer) {
    log.info("In customer.dao.getCustomers");
    return customer;
  }
  
  public Customer updateCustomer(Customer customer) {
    log.info("create Customers in service layer");
    return customer;
  }
  
  public List<Customer> fetchCustomerByFirstName(String firstName) { 
    log.info("Pull customers in service layer with certain name");
    return null;
  }

  public List<Customer> fetchMultipleCustomers(String firstName, String lastName) {
    // TODO Auto-generated method stub
    return null;
  }


}
