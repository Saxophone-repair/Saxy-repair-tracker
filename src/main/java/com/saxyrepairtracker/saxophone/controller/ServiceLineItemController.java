package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.saxyrepairtracker.saxophone.entity.Customer;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ServiceLineItemController {

  // @formatter:off
  @Operation(
      summary = "Returns a list of Service line items",
      description = "Returns a list of Customers all first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Customers is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = ServiceLineItem.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Customers were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      }

  )
  @GetMapping("/all")
  @ResponseStatus(code = HttpStatus.OK)
  List<Customer> fetchAllServiceLineItems(                                                            //!!!
    );
 
  
  
  
  
  
  // @formatter:off
  @Operation( //!!!
      summary = "Return a Service Line Item",
      description = "Returns a service line item after given the service ticket",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A service line item is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = ServiceLineItem.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Customers found",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json")),
      },
      parameters = {
          @Parameter(name = "serviceFK",
              allowEmptyValue = false,
              required = false,
              description = "Customer's service ticket for the instrument")
        }
  )
  @GetMapping("/aCustomer")
  @ResponseStatus(code = HttpStatus.OK)
  List<Customer> fetchAServiceLineItem(                                                               //!!!
      @RequestParam(required = false)
      int serviceFK);       
}
