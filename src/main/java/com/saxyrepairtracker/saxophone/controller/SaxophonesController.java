package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/saxophones")
@OpenAPIDefinition(info = @Info(title = "Saxophones Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface SaxophonesController {

  // @formatter:off
  @Operation(
      summary = "Returns the list of Saxophones",
      description = "Returns the list of Saxophones",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Saxophones gets returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Saxophones.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Saxophones were found",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json")),
      }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Saxophones> fetchSaxophones(
      @RequestParam(required = false)
        SaxophonesType type,
        @Length()
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false)
      String trim);
  //@formatter:on

  List<Saxophones> fetchSaxophones(Saxophones type,
      @Length @Pattern(regexp = "[\\w\\s]*") String manufacturer);
}