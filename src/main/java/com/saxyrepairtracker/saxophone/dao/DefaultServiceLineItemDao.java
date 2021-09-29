package com.saxyrepairtracker.saxophone.dao;

import java.math.BigDecimal;
import java.util.List;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;

public class DefaultServiceLineItemDao implements ServiceLineItemDao {

  @Override
  public List<ServiceLineItem> fetchAllServiceLineItems() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ServiceLineItem> fetchAServiceLineItem(int serviceFK) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ServiceLineItem createServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ServiceLineItem updateServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ServiceLineItem> fetchAServiceLineItemByStatus(
      ServiceLineItemStatus ServiceLineItemStatus) {
    // TODO Auto-generated method stub
    return null;
  }

}
