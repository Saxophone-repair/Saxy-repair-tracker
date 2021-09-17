package com.saxyrepairtracker.saxophone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.service.SaxophonesService;

@RestController
@RequestMapping("/saxophone/saxophone") //?
public class SaxophonesController {
  
      @Autowired
      private SaxophonesService saxophonesService;
      
      // To get all saxophones
      @RequestMapping(method=RequestMethod.GET)
      public ResponseEntity<Object> getSaxophones () {
          return new ResponseEntity<Object>(saxophonesService.getSaxophones(), HttpStatus.OK);
      }
      
      // To get a saxophone by its manufacturer
      @RequestMapping(value = "/{manufacturer}", method=RequestMethod.GET)
      public ResponseEntity<Object> getSaxophonesByManufacturer(@PathVariable String manufacturer) {
                    return new ResponseEntity<Object>(saxophonesService.getSaxophonesByManufacturer(manufacturer), HttpStatus.OK);
      }
      
      // Create a new Saxophone for the database
      @RequestMapping(method=RequestMethod.POST)
      public ResponseEntity<Object> createSaxophones(@RequestBody Saxophones saxophones) throws Exception {
                return new ResponseEntity<Object>(saxophonesService.createSaxophones(saxophones), HttpStatus.CREATED);
      }
  
      // Update a saxophone by customer ID
//      @RequestMapping(value="/{customer}", method=RequestMethod.PUT)
//      public ResponseEntity<Object> updateSaxophone(@RequestBody Saxophones saxophones, @PathVariable int customer)
//        throws Exception {
//            try {
//              return new ResponseEntity<Object>(customer.updateSaxophones(series , zzz), HttpStatus.OK);
//            } catch (Exception e) {
//              return new ResponseEntity<Object>("Unable to properly update Saxophone: " + zzz, HttpStatus.BAD_REQUEST);
//            }
//      }
}