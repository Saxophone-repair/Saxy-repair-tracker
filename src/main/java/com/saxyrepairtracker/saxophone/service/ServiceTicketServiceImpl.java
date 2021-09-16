package com.saxyrepairtracker.saxophone.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;
import com.saxyrepairtracker.saxophone.repositories.ServiceTicketRepository;

@Service
public class ServiceTicketServiceImpl implements ServiceTicketService{
  @Autowired
  private ServiceTicketRepository repository;
  
  public ServiceTicketServiceImpl() {
  }

  public ServiceTicketServiceImpl(ServiceTicketRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<ServiceTicket> search(Status status) {
    return new ArrayList<ServiceTicket>();
  }

  public ServiceTicket get(int servicePk) {
    ServiceTicket ticket = repository.get(servicePk);
    return(ticket);
  }

  /**
   * Checks the title to make sure it is valid.
   * @param input The title to validate
   * @return True if valid, false if otherwise.
   */
//  protected boolean isValid(ServiceTicket input) {
//    if (input.getId().isEmpty()) {
//      return(false);
//    }
//    if (input.getName().isEmpty()) {
//      return(false);
//    }
//    if (input.getType() <= 0) {
//      return(false);
//    }
//    return(true);
//  }

  public ServiceTicket create(ServiceTicket input) {
    if (input == null) return(null);
    
    if (isValid(input)) {
      ServiceTicket existing = repository.get(input.getservicePk());
      if (existing == null) {
        ServiceTicket ticket = repository.create(input);
        return(ticket);
      }
      
      return(update(input.getservicePk(), input));
    }
    return(null);
  }

  public ServiceTicket update(int servicePk, ServiceTicket input) {
    if ((servicePk == null) || (servicePk.isEmpty())) {
      servicePk = input.getservicePk();
    }
    
    if (isValid(input)) {
      ServiceTicket existing = repository.get(servicePk);
      if (existing != null) {
        ServiceTicket model = repository.update(servicePk, input);
        return(ticket);
      }
      
      return(create(input));
    }
    
    return(null);
  }

  public ServiceTicket delete(String id) {
    if ((id == null) || (id.isEmpty())) {
      return(null);
    }
    
    ServiceTicket existing = repository.get(servicePk);
    if (existing != null) {
      ServiceTicket ticket = repository.delete(servicePk);
      return(ticket);
    }
    return(null);
  }


}
