package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;

@Validated
@RequestMapping("/serviceTickets")
@OpenAPIDefinition(info = @Info(title = "Service Ticket"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})
public interface ServiceTicketController {


  // @formatter:off
  @Operation(
      summary = "Returns a Service Ticket By Status",
      description = "Returns a Employee given a first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "An Service Ticket is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = ServiceTicket.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Employees were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "Status", 
              allowEmptyValue = false, 
              required = false, 
              description = "The Status (i.e., 'Awaiting_Arrival')")
      }
  )
  //this is for gets not deletes, postmapping, deletemapping etc for the methods 
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<ServiceTicket> fetchServiceTicketByStatus(
      @RequestParam(required = false)
      Status Status
    );
  //@formatter:on 


// /all 
// @formatter:off
@Operation(
    summary = "Returns all Service Tickets",
    description = "Returns a List of Service Tickets",
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "A List of all Employees is returned",
            content = @Content(
                mediaType = "application/json", 
                schema = @Schema(implementation = ServiceTicket.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No Employees were found with the input criteria",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.",  
            content = @Content(mediaType = "application/json"))
    }
)
//this is for gets not deletes, postmapping, deletemapping etc for the methods 
      @GetMapping("/all")
      @ResponseStatus(code = HttpStatus.OK)
      List<ServiceTicket> fetchAllServiceTickets();  
 //@formatter:on


//POST
//Create Method ServiceTickets
// @formatter:off
@Operation(
    summary = "Returns a new Service Ticket",
    description = "Returns a Service Ticket given a first and last name",
    responses = {
        @ApiResponse(
            responseCode = "201", 
            description = "A new Employee has been created",
            content = @Content(
                mediaType = "application/json", 
                schema = @Schema(implementation = ServiceTicket.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No Employees component was not found with the input criteria",  
            content = @Content(mediaType = "application/json")),//maybe reword
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.",  
            content = @Content(mediaType = "application/json"))
    }
    
)
      @PostMapping("/id")
      @ResponseStatus(code = HttpStatus.CREATED)
      List<ServiceTicket> createServiceTicket(@Valid @RequestBody ServiceTicket newServiceTicket);
//@formatter:on



//Deletes Employee 
//deleteEmployee
// @formatter:off
@Operation(
    summary = "Deletes an Service Ticket",
    description = "Deletes an Employee given an id",
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Service Ticket was deleted",
            content = @Content(
                mediaType = "application/json", 
                schema = @Schema(implementation = ServiceTicket.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No Employees were found with the input criteria",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.",  
            content = @Content(mediaType = "application/json"))
    },
    parameters = {
        @Parameter(name = "servicePK", 
            allowEmptyValue = false, 
            required = false, 
            description = "servicePK (i.e., 3)"),
    }
)
//this is for gets not deletes, postmapping, deletemapping etc for the methods 
    @DeleteMapping("/servicePK")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteServiceTicket(int deleteId); 

 //@formatter:on


//PUT Update 
//updateServiceTicket
//@formatter:off
@Operation(
  summary = "Returns an updated ServiceTicket",
  description = "Returns a Employee to update given an id",
  responses = {
      @ApiResponse(
          responseCode = "200",
          description = "An updated Service Ticket is returned",
          content = @Content(
              mediaType = "application/json", 
              schema = @Schema(implementation = ServiceTicket.class))),
      @ApiResponse(
          responseCode = "400", 
          description = "The request parameters are invalid",  
          content = @Content(mediaType = "application/json")),
      @ApiResponse(
          responseCode = "404", 
          description = "No Employees were found with the input criteria",  
          content = @Content(mediaType = "application/json")),
      @ApiResponse(
          responseCode = "500", 
          description = "An unplanned error occurred.",  
          content = @Content(mediaType = "application/json"))
  }
)

@PutMapping("/{id}")
@ResponseStatus(code = HttpStatus.OK) 
List<ServiceTicket> updateServiceTicket(
  @PathVariable int id, 
  @Valid @RequestBody ServiceTicket updatedServiceTicket);

//@formatter:on


}


