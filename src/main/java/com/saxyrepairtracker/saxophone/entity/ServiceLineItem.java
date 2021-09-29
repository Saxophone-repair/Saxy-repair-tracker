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
public class ServiceLineItem {

  private int serviceLineItemPK;
  
  private int serviceFK;
  
  private int employeeFK;
  
  private String description;
  
  private ServiceLineItemStatus serviceLineItemStatus;
  
  private boolean isComplete;
  
  private BigDecimal timeForRepair;
  
  private BigDecimal cost;
  
//  5.) Service Line Items
//  Number:          <Service Ticket Number>
//  Order/Line Item: 1 (Sequential number per ticket for each line item)
//  Technician:      Who is doing the work.
//  Action/Task:     Replaced Z key from part 234324-34 located in inventory.
//  Is Complete:     Done (boolean) 
//  Hours:           1.5h
//  Cost:            $234 <Is this just parts, or the does it include labor?
}
