package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import javax.validation.Valid;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;

public interface ServiceTicketDao {

  List<ServiceTicket> fetchServiceTicketByStatus(Status status);

  List<ServiceTicket> fetchAllServiceTickets();

  List<ServiceTicket> createServiceTicket(@Valid ServiceTicket newServiceTicket);

  void deleteServiceTicket(int deleteId);

  List<ServiceTicket> updateServiceTicket(int id, @Valid ServiceTicket updatedServiceTicket);

}
