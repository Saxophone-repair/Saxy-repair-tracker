package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Customer;

public interface CustomerDao {
  List<Customer> fetchCustoemr(String firstName, String lastName);

  List<Customer> getCustomers();
}
