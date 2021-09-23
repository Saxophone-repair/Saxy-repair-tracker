package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import javax.validation.Valid;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;

public class DefaultServiceTicketController implements ServiceTicketController{

  @Override
  public List<ServiceTicket> fetchServiceTicketByStatus(Status Status) {
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
