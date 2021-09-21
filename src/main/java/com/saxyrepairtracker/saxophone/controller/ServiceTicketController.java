//package com.saxyrepairtracker.saxophone.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
//import com.saxyrepairtracker.saxophone.entity.Status;
//import com.saxyrepairtracker.saxophone.service.ServiceTicketService;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.info.Info;
//
//@RestController
//@OpenAPIDefinition(info = @Info(title = "Service Ticket Tracker"))
//public class ServiceTicketController {
//
//  @Autowired
//  private ServiceTicketService service;
//  
//  /**
//   * Get a specific title by it's id.
//   * @param id The unique id of the title (i.e. tt234234)
//   * @return A title if found, otherwise null.
//   */
//  @Operation(summary = "Get a service ticket by it's unique id",
//             description = "Gets the title if found, otherwise returns null")
//  @RequestMapping(value = "/serviceticket/{id}", method = RequestMethod.GET)
//  public ServiceTicket getServiceTicketeById(@PathVariable int id) {
//    ServiceTicket title = service.get(id);
//    if (id != null) {
//      return(id);
//    }
//    
//    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
//        String.format("ServiceTicket '%s' was not found", id));
//  }
//  
//  /**
//   * Adds or creates a new title.
//   * @param title The new title information.
//   * @return The newly created if successful, otherwise return null
//   */
//  @Operation(summary = "Adds or creates a new ServiceTicket",
//             description = "Creates a new title if successful, otherwise returns null.")
//  @RequestMapping(value = "/ServiceTicket", method = RequestMethod.POST)
//  public ServiceTicket createTitle(@RequestBody ServiceTicket ticket) {
//    if (ticket != null) {
//      ServiceTicket createdServiceTicket = service.create(ticket);
//      if (createdServiceTicket == null) {
//        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
//            String.format("An unknown error occurred when creating a title. Please try again."));
//      }
//      
//      return(createdServiceTicket);
//    }
//    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
//        String.format("No title was provided. Title is required"));
//  }
//  
//  @RequestMapping(value = "/titles/{title}", method = RequestMethod.PUT)
//  public ServiceTicket update(@PathVariable Status status, @RequestBody ServiceTicket input) {
//    if ((status == null) || (status.isEmpty())) {
//      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
//          "Not title id was specified.");
//    }
//    if (input == null) {
//      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
//          "Title was empty or missing");
//    }
//    
//    ServiceTicket model = service.update(String description, input);
//    if (description != null) {
//      return(description);
//    }
//    
//    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
//        "An internal / unexpect error ocurred creating requested title.");
//  }
//  
//
//}
//  
