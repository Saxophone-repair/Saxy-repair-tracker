//package com.saxyrepairtracker.saxophone.service;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.NoSuchElementException;
//import org.springframework.stereotype.Service;
//import com.saxyrepairtracker.saxophone.entity.Customer;
//import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
//import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;
//import lombok.extern.slf4j.Slf4j;
//import com.saxyrepairtracker.saxophone.dao.ServiceLineItemDao;
//
//@Slf4j
//@Service
//public class DefaultServiceLineItemService implements ServiceLineItemService {
//
//  @Override
//  public List<ServiceLineItem> fetchAllServiceLineItems() {
//    List<ServiceLineItem> serviceLineItem = serviceLineItemDao.fetchAllServiceLineItem();
//    if(serviceLineItem.isEmpty()) {
//      String msg = String.format("We have no service line items :(");
//          throw new NoSuchElementException(msg);
//    }
//        return serviceLineItem;
//  }
//
//  @Override
//  public List<ServiceLineItem> fetchAServiceLineItem(int serviceFK) {
//    log.info("Fetch Service Line Item within the service layer");
//    
//    List<ServiceLineItem> serviceLineItem = serviceLineItemDao.fetchACustomer(serviceFK);
//          if(serviceLineItem.isEmpty()) {
//              String msg = String.format("No Service line items was found with serviceFK=%s", serviceFK);
//                throw new NoSuchElementException(msg);
//    } 
//       return serviceLineItem;
//  }
//
//  @Override
//  public ServiceLineItem createServiceLineItem(int serviceFK, int employeeFK, String description,
//      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
//      BigDecimal cost) {
//    log.info("create Service Line Item in service layer");
//    return serviceLineItemDao.createServiceLineItem(serviceFK, employeeFK, description, 
//        ServiceLineItemStatus, isComplete, timeForRepair, cost);
//  }
//
//  @Override
//  public ServiceLineItem updateServiceLineItem(int serviceFK, int employeeFK, String description,
//      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
//      BigDecimal cost) {
//    log.info("updates Service Line Item in service layer");
//        return serviceLineItemDao.updateServiceLineItem(serviceFK, employeeFK, description, 
//            ServiceLineItemStatus, isComplete, timeForRepair, cost);
//  }
//
//  @Override
//  public List<ServiceLineItem> fetchAServiceLineItemByStatus(
//      ServiceLineItemStatus ServiceLineItemStatus) {
//    log.info("Fetch Service Line Item in service layer");
//    List<ServiceLineItem> serviceLineItem = serviceLineItemDao.fetchAServiceLineItemByStatus(ServiceLineItemStatus);
//          if(serviceLineItem.isEmpty()) {
//              String msg = String.format("No Service Line Items were found with serviceLineItemStatus=%s", 
//                                                                        ServiceLineItemStatus);
//                throw new NoSuchElementException(msg);
//    } 
//       return serviceLineItem;
//  }
//
//}
