package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;

public interface ServiceTicketService {
  /**
   * Searches the titles for any occurrences of the specified name.
   * @param name The regular expression or part of the name we want to search.4
   * @return Returns the matching titles if found, otherwise returns an empty list.
   */
  List<ServiceTicket> search(String description, Status status);
  
  /**
   * Creates a new title.
   * @param newTitle The new title information.
   * @return The new title information that was created and/or validated, or returns null if operation failed.
   */
  ServiceTicket create(ServiceTicket newServiceTicket);
  
  /**
   * Deletes or removes a title.
   * @param id The unique id of the title.
   * @return True if deleted, false if title doesn't exist or deletion failed.
   */
  ServiceTicket delete(String description);
  
  /**
   * Updates a title with new information.
   * @param id The unique id of the title.
   * @param updatedTitle The updated or new title information. 
   * @return Returns the updated title information, or null if update fails.
   */
  ServiceTicket update(String description, ServiceTicket updatedServiceTicket);
  
  /**
   * Retrieves a single title by id.
   * @param id The unique id of the title.
   * @return The title if found, null if otherwise.
   */
  ServiceTicket get(String description);
}
}
