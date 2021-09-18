package com.saxyrepairtracker.saxophone.repositories;

import com.saxyrepairtracker.saxophone.entity.ServiceTicket;

public interface ServiceTicketRepository {
  /**
   * Retrieves a single ticket by id.
   * @param id The unique id of the ticket.
   * @return The ticket if found, null if otherwise.
   */
  ServiceTicket get(int id);

  /**
   * Creates a new title.
   * @param input The new ticket 
   * @return The newly created ticket.
   */
  ServiceTicket create(ServiceTicket input);
  
  /**
   * Updates or modifies an existing ticket.
   * @param id The existing id of the ticket to modify
   * @param input The update ticket information
   * @return The updated / modified ticket.
   */
  ServiceTicket update(int id, ServiceTicket input);

  
  //Please refer to detailed notes ServiceTicketService, this repo may or may not be needed.

}
