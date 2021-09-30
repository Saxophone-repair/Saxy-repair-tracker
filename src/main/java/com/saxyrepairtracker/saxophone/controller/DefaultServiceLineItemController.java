package com.saxyrepairtracker.saxophone.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import com.saxyrepairtracker.saxophone.entity.RepairType;
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
  public ServiceLineItem createServiceLineItem(int serviceFK, int saxophonesFK, int employeeFK, String description,
      RepairType RepairType, boolean isComplete, BigDecimal laborHours,
      BigDecimal totalCost) {
    return serviceLineItemService.createServiceLineItem(serviceFK, saxophonesFK, employeeFK, description,
        RepairType, isComplete, laborHours, totalCost);
  }

  @Override
  public ServiceLineItem updateServiceLineItem(int lineItemPK, ServiceLineItem updatedItem) {
    return serviceLineItemService.updateServiceLineItem(lineItemPK, updatedItem);
  }

  @Override
  public List<ServiceLineItem> fetchAServiceLineItemByStatus(RepairType RepairType) {
    return serviceLineItemService.fetchAServiceLineItemByStatus(RepairType);
  }

}
