package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import javax.validation.Valid;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;
//Please refer back to the ServiceTicket entity for the proper use of getters and setters that can be utilized
//to help ease the programming process
public interface ServiceTicketService {

  List<ServiceTicket> fetchServiceTicketByStatus(Status status);

  List<ServiceTicket> fetchAllServiceTickets();

  List<ServiceTicket> createServiceTicket(@Valid ServiceTicket newServiceTicket);

  void deleteServiceTicket(int deleteId);

  List<ServiceTicket> updateServiceTicket(int id, @Valid ServiceTicket updatedServiceTicket);
  
}

