package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saxyrepairtracker.saxophone.dao.ServiceTicketDao;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultServiceTicketService implements ServiceTicketService{

  @Autowired
  private ServiceTicketDao serviceTicketDao;
  
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
