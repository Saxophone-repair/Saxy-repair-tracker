package com.saxyrepairtracker.saxophone.entity;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTicket {

  private int servicePk;
  private int customerFk;
  private String description;
  private Status status;
  private BigDecimal estimatedCost;
  private BigDecimal actualCost;
  


  public List<ServiceTicket> getid() {
    // TODO Auto-generated method stub
    return null;
  }
}   

