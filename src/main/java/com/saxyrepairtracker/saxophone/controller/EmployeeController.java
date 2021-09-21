package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.saxyrepairtracker.saxophone.entity.Employee;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/employees")
@OpenAPIDefinition(info = @Info(title = "Employee"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface EmployeeController {


  // @formatter:off
  @Operation(
      summary = "Returns a list of Employees",
      description = "Returns a list of Employees given an optional first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Employees is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Employee.class))),
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
          @Parameter(name = "firstName", 
              allowEmptyValue = false, 
              required = false, 
              description = "The first name (i.e., 'Jojo')"),
          @Parameter(name = "lastName", 
          allowEmptyValue = false, 
          required = false, 
          description = "The last name (i.e., 'Mel')")
      }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Employee> fetchEmployees(
      @RequestParam(required = false)
      String firstName, 
      //@Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false)
      String lastName);
  //@formatter:on
}

