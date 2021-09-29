package com.saxyrepairtracker.saxophone.service;

import java.math.BigDecimal;
import java.util.List;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;

public interface ServiceLineItemService {

  List<ServiceLineItem> fetchAllServiceLineItems();
  
  List<ServiceLineItem> fetchAServiceLineItem(int serviceFK);
  
  ServiceLineItem createServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost);
  
  ServiceLineItem updateServiceLineItem(int serviceLineItemPK, ServiceLineItem updatedItem);
  
  List<ServiceLineItem> fetchAServiceLineItemByStatus(ServiceLineItemStatus ServiceLineItemStatus);
}
