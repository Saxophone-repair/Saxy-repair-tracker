package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.saxyrepairtracker.saxophone.entity.Customer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/customers")
@OpenAPIDefinition(info = @Info(title = "Customer"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CustomerController {


  // @formatter:off
  @Operation(
      summary = "Returns a list of Customers",
      description = "Returns a list of Customers all first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Customers is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))),
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
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Customer> fetchCustomers(
    );
}




