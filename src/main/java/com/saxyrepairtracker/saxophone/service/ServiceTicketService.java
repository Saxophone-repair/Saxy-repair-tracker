package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;
//Please refer back to the ServiceTicket entity for the proper use of getters and setters that can be utilized
//to help ease the programming process
public interface ServiceTicketService {
  /**
   * Searches the titles for any occurrences of the specified name.
   * @param name The regular expression or part of the name we want to search.4
   * @return Returns the matching titles if found, otherwise returns an empty list.
   * List<ServiceTicket> search(String description, Status status);
   *Want to have a search method for status grouping 
   *want to look up per customer 
   *and per id for specific service tickets 
   */
  //It would be nice to add to search by status, or customer 
  List<ServiceTicket> search(Status status);
  
  /**
   * Creates a new service ticket
   * @param We need to make it in a step by step process 
   * 1.) automatically generates an id i.e. the servicepk
   * 2.) should be attached to a customer id 
   * 3.) Along with the customer name because the id should be used to get the name if this was in a 
   *business setting it makes sense to do so 
   * 4.) Status should be inputed, I believe this should be first as not everyone will care to read the 
   *the description and scrolling down to get the status seems like a silly notion 
   *5.) Put an est. cost 
   *6.) Optional actual cost due to the ticket may not being able to have the final numbers 
   *7.)(if implemented this would be before the above (step 6) step current total, basically once 
   *a ticket is continued to have work done on it it keeps a what is due amount or current balance for the 
   *ticket 
   * @return The new title information that was created and/or validated, or returns null if operation failed.
   */
  ServiceTicket create(ServiceTicket newServiceTicket);
  
  /**
   * Deletes or removes a title.
   * @param Delete will not be implemented due to the need to keep the service tickets 
   * @return True if deleted, false if title doesn't exist or deletion failed.
   */
  //ServiceTicket delete(int servicePk);
  
  /**
   * Updates a ticket with new information.
   * @param id The unique id of the title, so it can pull up the specific ticket somehow?
   * @param maybe a title or something to have easy search even tho this will be in house
   * Or customer?
   * 3.) with either  id method should update the status first 
   * 4.) description (like the line items?) 
   * 5.) est, cost should be updated 
   * 6.) current total?
   * 7.) actual cost that can be left null if needed 
   * @return Returns the updated title information, or null if update fails.
   */
  ServiceTicket update(int servicePk, ServiceTicket updatedServiceTicket);
  
  /**
   * Retrieves a single title by id.
   *Maybe this is a better way to get a group of tickets by status, customers, etc.
   * @param id The unique id of the ticket.
   * @return The ticket if found, null if otherwise.
   */
  ServiceTicket get(int servicePk);
}

