package com.saxyrepairtracker.saxophone.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
import com.saxyrepairtracker.saxophone.service.SaxophonesService;

@RestController
//@RequestMapping("/saxophone/saxophone") //?

public class DefaultSaxophonesController implements SaxophonesController {


  @Autowired
  private SaxophonesService saxophonesService;
  
  // To get all saxophones
  @RequestMapping(path="/all", method =RequestMethod.GET)
  public ResponseEntity<Object> getSaxophones () {
      return new ResponseEntity<Object>(saxophonesService.getSaxophones(), HttpStatus.OK);
  }
  
//  // To get a saxophone by its manufacturer
//  @RequestMapping(value = "/{manufacturer}", method=RequestMethod.GET)
//  public ResponseEntity<Object> getSaxophonesByManufacturer(@PathVariable SaxophonesType type) {
//                return new ResponseEntity<Object>(saxophonesService.getSaxophonesBySaxophoneType(type), HttpStatus.OK);
//  }
  
  // Create a new Saxophone for the database
  @RequestMapping(method=RequestMethod.POST)
  public ResponseEntity<Object> createSaxophones(@RequestBody Saxophones saxophones) throws Exception {
            return new ResponseEntity<Object>(saxophonesService.createSaxophones(saxophones), HttpStatus.CREATED);
  }

  @Override
  public List<Saxophones> fetchSaxophones(SaxophonesType type,
      @Length @Pattern(regexp = "[\\w\\s]*") String manufacturer) {
    // TODO Auto-generated method stub
    return saxophonesService.getSaxophonesBySaxophoneType(type, manufacturer);
  }
  

  // Update a saxophone by customer ID
  @RequestMapping(value="/{saxophones}", method=RequestMethod.PUT)
  public ResponseEntity<Object> updateSaxophone(@RequestBody Saxophones saxophones, @PathVariable int customerFK, 
                                                             String series, String manufacturer)
    throws Exception {
        try {
          return new ResponseEntity<Object>(saxophones.updateSaxophones(customerFK, series, manufacturer), HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<Object>("Unable to properly update Saxophone: " + customerFK, HttpStatus.BAD_REQUEST);
        }
  }

  @Override
  public List<Saxophones> fetchSaxophones(Saxophones type,
      @Length @Pattern(regexp = "[\\w\\s]*") String manufacturer) {
    // TODO Auto-generated method stub
    return null;
  }

}
