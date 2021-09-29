package com.saxyrepairtracker.saxophone.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;
import com.saxyrepairtracker.saxophone.service.ServiceLineItemService;

@RestController

public class DefaultServiceLineItemController implements ServiceLineItemController{

  @Autowired
  private ServiceLineItemService serviceLineItemService;
  
  @Override
  public List<ServiceLineItem> fetchAllServiceLineItems() {
    return serviceLineItemService.fetchAllServiceLineItems();
  }

  @Override
  public List<ServiceLineItem> fetchAServiceLineItem(int serviceFK) {
    return serviceLineItemService.fetchAServiceLineItem(serviceFK);
  }

  @Override
  public ServiceLineItem createServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost) {
    return serviceLineItemService.createServiceLineItem(serviceFK, employeeFK, description,
        ServiceLineItemStatus, isComplete, timeForRepair, cost);
  }

  @Override
  public ServiceLineItem updateServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost) {
    return serviceLineItemService.updateServiceLineItem(serviceFK, employeeFK, description,
      ServiceLineItemStatus, isComplete, timeForRepair, cost);
  }

  @Override
  public List<ServiceLineItem> fetchAServiceLineItemByStatus(ServiceLineItemStatus ServiceLineItemStatus) {
    return serviceLineItemService.fetchAServiceLineItemByStatus(ServiceLineItemStatus);
  }

}
