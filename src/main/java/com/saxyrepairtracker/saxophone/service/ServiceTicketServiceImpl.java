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

  public ServiceTicket get(int id) {
    ServiceTicket ticket = repository.get(id);
    return(ticket);
  }

  /**
   * Checks the title to make sure it is valid.
   * @param input The title to validate
   * @return True if valid, false if otherwise.
   */
  protected boolean isValid(ServiceTicket input) {
    if (input.getid().isEmpty()) {
      return(false);
    }
    if (input.getName().isEmpty()) {
      return(false);
    }
    if (input.getType() <= 0) {
      return(false);
    }
    return(true);
  }

  public ServiceTicket create(ServiceTicket input) {
    if (input == null) return(null);
    
    if (isValid(input)) {
      ServiceTicket existing = repository.get(input.getid());
      if (existing == null) {
        ServiceTicket ticket = repository.create(input);
        return(ticket);
      }
      
      return(update(input.id(), input));
    }
    return(null);
  }

  public ServiceTicket update(int id, ServiceTicket input) {
    if ((id == null) || (id.isEmpty())) {
      id = input.getid();
    }
    
    if (isValid(input)) {
      ServiceTicket existing = repository.get(id);
      if (existing != null) {
        ServiceTicket ticket = repository.update(id, input);
        return(ticket);
      }
      
      return(create(input));
    }
    
    return(null);
  }

}