package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import javax.validation.Valid;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;

public class DefaultServiceTicketService implements ServiceTicketService{

  @Override
  public List<ServiceTicket> fetchServiceTicketByStatus(Status status) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ServiceTicket> fetchAllServiceTickets() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ServiceTicket> createServiceTicket(@Valid ServiceTicket newServiceTicket) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteServiceTicket(int deleteId) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<ServiceTicket> updateServiceTicket(int id,
      @Valid ServiceTicket updatedServiceTicket) {
    // TODO Auto-generated method stub
    return null;
  }

}
