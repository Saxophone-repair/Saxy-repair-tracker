package com.saxyrepairtracker.saxophone.repositories;

import com.saxyrepairtracker.saxophone.entity.ServiceTicket;

public interface ServiceTicketRepository {
  /**
   * Retrieves a single title by id.
   * @param id The unique id of the title.
   * @return The title if found, null if otherwise.
   */
  ServiceTicket get(int id);

  /**
   * Creates a new title.
   * @param input The new title information.
   * @return The newly created title.
   */
  ServiceTicket create(ServiceTicket input);
  
  /**
   * Updates or modifies an existing title.
   * @param id The existing id of the title to modify
   * @param input The update title information
   * @return The updated / modified title.
   */
  ServiceTicket update(int id, ServiceTicket input);


}
