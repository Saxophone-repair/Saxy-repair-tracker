package com.saxyrepairtracker.saxophone.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  private int employeePk;
  private String firstName;
  private String lastName;
  private BigDecimal payRate;
}

