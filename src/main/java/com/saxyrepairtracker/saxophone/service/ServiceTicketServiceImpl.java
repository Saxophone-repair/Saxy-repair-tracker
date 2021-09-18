package com.saxyrepairtracker.saxophone.service;
//Please refer to notes on ServiceTicketService for more clear directions and outline 
//Please refer back to the ServiceTicket entity for the proper use of getters and setters that can be utilized
//to help ease the programming process
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

  public ServiceTicket get(int ServicePk) {
    ServiceTicket ticket = repository.get(ServicePk);
    return(ticket);
  }

  /**
   * Checks the title to make sure it is valServicePk.
   * @param input The title to valServicePkate
   * @return True if valServicePk, false if otherwise.
   */
  protected boolean isValServicePk(ServiceTicket input) {
    if (input.getServicePk() <= 0) {
      return(false);
    }
    if (input.getDescription().isEmpty()) {
      return(false);
    }
    if (input.getStatus().isEmpty()) {
      return(false);
    }
    return(true);
  }
//This create method needs some work, this is a bit lacking in the correct information
  //The input is a multi step procedure and have to be broken down, status, description, estcost etc.
  public ServiceTicket create(ServiceTicket input) {
    if (input == null) return(null);
    
    if (isValServicePk(input)) {
      ServiceTicket existing = repository.get(input.getServicePk());
      if (existing == null) {
        ServiceTicket ticket = repository.create(input);
        return(ticket);
      }
      
      return(update(input.servicePk(), input));
    }
    return(null);
  }

  //need to add input into this to make sense
  public ServiceTicket update(int servicePk, ServiceTicket input) {
    if (servicePk <= 0) {
      servicePk = input.getServicePk();
    }
    
    if (isValServicePk(input)) {
      ServiceTicket existing = repository.get(ServicePk);
      if (existing != null) {
        ServiceTicket ticket = repository.update(ServicePk, input);
        return(ticket);
      }
      
      return(create(input));
    }
    
    return(null);
  }

}

//Need to break this down into bits to properly go through and alter it 
//should update all entities to pural due to the proper practices w/ the help of Lisas excellent article