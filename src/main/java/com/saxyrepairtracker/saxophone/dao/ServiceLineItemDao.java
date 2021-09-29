package com.saxyrepairtracker.saxophone.dao;

import java.math.BigDecimal;
import java.util.List;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;

public interface ServiceLineItemDao {

  public List<ServiceLineItem> fetchAllServiceLineItems();
  
  public List<ServiceLineItem> fetchAServiceLineItem(int serviceFK);
  
  public ServiceLineItem createServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost);
  
  public ServiceLineItem updateServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost);
  
  public List<ServiceLineItem> fetchAServiceLineItemByStatus(
      ServiceLineItemStatus ServiceLineItemStatus);
}
