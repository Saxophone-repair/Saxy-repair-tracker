package com.saxyrepairtracker.saxophone.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/serviceLineItem")
@OpenAPIDefinition(info = @Info(title = "Service Line Item"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
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
  List<ServiceLineItem> fetchAllServiceLineItems(                                                            //!!!
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
  @GetMapping("/An item")
  @ResponseStatus(code = HttpStatus.OK)
  List<ServiceLineItem> fetchAServiceLineItem(                                                               //!!!
      @RequestParam(required = false)
      int serviceFK);    





  
  // @formatter:off
  @Operation(
      summary = "Creates a new Service Line Item",
      description = "Returns the created Service Line Item",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A new Service Line Item has been added",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = ServiceLineItem.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Service Line Item was found",  
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
              description = "The Service ticket number"),
          @Parameter(name = "employeeFK", 
              allowEmptyValue = false, 
              required = false, 
              description = "The employee working on the saxophone"),
          @Parameter(name = "description", 
              allowEmptyValue = false, 
              required = false, 
              description = "The description talking about what it's in for."),
          @Parameter(name = "serviceLineItemStatus", 
              allowEmptyValue = false, 
              required = false, 
              description = "Status of the repair"),
          @Parameter(name = "isComplete", 
              allowEmptyValue = false, 
              required = false, 
              description = "Is the repair completed or not"),
          @Parameter(name = "timeForRepair", 
              allowEmptyValue = false, 
              required = false, 
              description = "The time spent working on the saxophone."),
          @Parameter(name = "cost", 
          allowEmptyValue = true, 
          required = false, 
          description = "The cost of the repair")
          }
//      private int serviceLineItemPK;
//      
//      private int serviceFK;
//      
//      private int employeeFK;
//      
//      private String description;
//      
//      private ServiceLineItemStatus ServiceLineItemStatus;
//      
//      private boolean isComplete;
//      
//      private BigDecimal hours;
//      
//      private BigDecimal cost;
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  ServiceLineItem createServiceLineItem (int serviceFK, int employeeFK, String description, 
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair, 
      BigDecimal cost);                    //!!!
  
  
  
  
  
  // @formatter:off
  @Operation(
      summary = "Updates a Service Line Item",
      description = "Returns the updated Service Line Item",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A new Service Line Item has been updated",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = ServiceLineItem.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Service Line Item was found",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json")),
      },
      parameters = {
            @Parameter(name = "serviceLineItemPK",
              allowEmptyValue = false,
              required = false,
              description = "The key for the service item") //,
//          @Parameter(name = "serviceFK", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "The Service ticket number"),
//          @Parameter(name = "employeeFK", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "The employee working on the saxophone"),
//          @Parameter(name = "description", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "The description talking about what it's in for."),
//          @Parameter(name = "serviceLineItemStatus", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "Status of the repair"),
//          @Parameter(name = "isComplete", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "Is the repair completed or not"),
//          @Parameter(name = "timeForRepair", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "The time spent working on the saxophone."),
//          @Parameter(name = "cost", 
//          allowEmptyValue = false, 
//          required = false, 
//          description = "The cost of the repair")
          }
      )
      @PutMapping
      @ResponseStatus(code = HttpStatus.OK)
      ServiceLineItem updateServiceLineItem (int serviceLineItemPK, ServiceLineItem updatedItem);      

  
  
  
  
  
  // @formatter:off
  @Operation( //!!!
      summary = "Return a Service Line Item by current status",
      description = "Returns a service line item based on it's status",
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
          @Parameter(name = "serviceLineItemStatus", 
              allowEmptyValue = false, 
              required = false, 
              description = "Status of the repair"),
        }
  )
  @GetMapping("/status")
  @ResponseStatus(code = HttpStatus.OK)
  List<ServiceLineItem> fetchAServiceLineItemByStatus(                                                               //!!!
      @RequestParam(required = false)
      ServiceLineItemStatus ServiceLineItemStatus);    
  
}
