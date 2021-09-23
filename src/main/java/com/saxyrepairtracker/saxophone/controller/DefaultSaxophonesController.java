//package com.saxyrepairtracker.saxophone.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//import com.saxyrepairtracker.saxophone.entity.Saxophones;
//import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
//import com.saxyrepairtracker.saxophone.service.SaxophonesService;
//
//@RestController
////@RequestMapping("/saxophone/saxophone") //?
//
//public class DefaultSaxophonesController implements SaxophonesController {
//
//
//  @Autowired
//  private SaxophonesService saxophonesService;
//  
//  // To get all saxophones
////  @RequestMapping(path="/all", method =RequestMethod.GET)
////  public ResponseEntity<Object> getSaxophones () {
////      return new ResponseEntity<Object>(saxophonesService.getSaxophones(), HttpStatus.OK);
////  }
//  
////  // To get a saxophone by its manufacturer
////  @RequestMapping(value = "/{manufacturer}", method=RequestMethod.GET)
////  public ResponseEntity<Object> getSaxophonesByManufacturer(@PathVariable SaxophonesType type) {
////                return new ResponseEntity<Object>(saxophonesService.getSaxophonesBySaxophoneType(type), HttpStatus.OK);
////  }
//  
//  // Create a new Saxophone for the database
////  @RequestMapping(method=RequestMethod.POST)
////  public ResponseEntity<Object> createSaxophones(@RequestBody Saxophones saxophones) throws Exception {
////            return new ResponseEntity<Object>(saxophonesService.createSaxophones(saxophones), HttpStatus.CREATED);
////  }
//
////  @Override
////  public List<Saxophones> fetchSaxophones(SaxophonesType type,
////      @Length @Pattern(regexp = "[\\w\\s]*") String manufacturer) {
////    // TODO Auto-generated method stub
////    return saxophonesService.getSaxophonesBySaxophoneType(type, manufacturer);
////  }
//  
//
////  // Update a saxophone by customer ID
////  @RequestMapping(value="/{saxophones}", method=RequestMethod.PUT)
////  public ResponseEntity<Object> updateSaxophone(@RequestBody Saxophones saxophones, @PathVariable int customerFK, 
////                                                             String series, String manufacturer)
////    throws Exception {
////        try {
////          return new ResponseEntity<Object>(saxophones.updateSaxophones(customerFK, series, manufacturer), HttpStatus.OK);
////        } catch (Exception e) {
////          return new ResponseEntity<Object>("Unable to properly update Saxophone: " + customerFK, HttpStatus.BAD_REQUEST);
////        }
////  }
//
////  @Override
////  public List<Saxophones> fetchSaxophones(Saxophones type,
////      @Length @Pattern(regexp = "[\\w\\s]*") String manufacturer) {
////    // TODO Auto-generated method stub
////    return null;
////  }
//
//  @Override
//  public List<Saxophones> fetchSaxophones(SaxophonesType type) {
//    // TODO Auto-generated method stub
//    return saxophonesService.fetchSaxophones(type);
//  }
//  
//  @Override
//  public List<Saxophones> fetchAllSaxophones() {
//    // TODO Auto-generated method stub
//    return saxophonesService.fetchAllSaxophones();
//    }
//  
//  @Override
//  public List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK) {
//    // TODO Auto-generated method stub
//    return saxophonesService.fetchAllSaxophonesByCustomer(customerFK);
//  }
//  
//  @Override
//  public List<Saxophones> updateSaxophones(int saxophonePK, Saxophones updatedSaxophones) {
//    // TODO Auto-generated method stub
//    return saxophonesService.updateSaxophones(updatedSaxophones);
//  }
//
////  @Override
////  public List<Saxophones> getSaxophonesManufacturer(String manufacturer) {
////    // TODO Auto-generated method stub
////    return saxophonesService.getSaxophonesManufacturer(manufacturer);
////  }
//
//
//
//  @Override
//  public List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
//                                            SaxophonesType type) {
//    // TODO Auto-generated method stub
//    return saxophonesService.createSaxophones(customerFK, manufacturer, series, type);
//    }
//}
