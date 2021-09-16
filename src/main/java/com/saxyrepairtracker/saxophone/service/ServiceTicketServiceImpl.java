package com.saxyrepairtracker.saxophone.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
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
  public List<ServiceTicket> search(String name) {
    return new ArrayList<ServiceTicket>();
  }

  public ServiceTicket get(String id) {
    ServiceTicket model = repository.get(id);
    return(model);
  }

  /**
   * Checks the title to make sure it is valid.
   * @param input The title to validate
   * @return True if valid, false if otherwise.
   */
  protected boolean isValid(ServiceTicket input) {
    if (input.getId().isEmpty()) {
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
      ServiceTicket existing = repository.get(input.getId());
      if (existing == null) {
        ServiceTicket model = repository.create(input);
        return(model);
      }
      
      return(update(input.getId(), input));
    }
    return(null);
  }

  public ServiceTicket update(String id, ServiceTicket input) {
    if ((id == null) || (id.isEmpty())) {
      id = input.getId();
    }
    
    if (isValid(input)) {
      ServiceTicket existing = repository.get(id);
      if (existing != null) {
        ServiceTicket model = repository.update(id, input);
        return(model);
      }
      
      return(create(input));
    }
    
    return(null);
  }

  public ServiceTicket delete(String id) {
    if ((id == null) || (id.isEmpty())) {
      return(null);
    }
    
    ServiceTicket existing = repository.get(id);
    if (existing != null) {
      ServiceTicket model = repository.delete(id);
      return(model);
    }
    return(null);
  }
}
