package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import javax.validation.Valid;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;

public class DefaultServiceLineItemStatusService implements ServiceLineItemStatusService {

  @Override
  public List<ServiceLineItemStatus> fetchServiceTicketLineStatus(int updatePK, int serviceFK) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ServiceLineItemStatus> fetchAllServiceTicketLineStatuses() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ServiceLineItemStatus createServiceLineItemStatus(int updatePK, int serviceFK,
      int lineItemFK, String updates) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ServiceLineItemStatus updateServiceLineItemStatus(int updatePK,
      @Valid ServiceLineItemStatus updatedServiceLineItemStatus) {
    // TODO Auto-generated method stub
    return null;
  }

}
