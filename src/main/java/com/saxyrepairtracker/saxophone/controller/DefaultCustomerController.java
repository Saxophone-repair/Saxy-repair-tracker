package com.saxyrepairtracker.saxophone.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.Customer;
import com.saxyrepairtracker.saxophone.service.CustomerService;

@RestController
@RequestMapping("/saxophone/customer") //?
public class DefaultCustomerController {

//public class GigController {
    
    @Autowired
    private CustomerService service;
    
    
    // Retrieve all customers
    @RequestMapping(value="/only", method=RequestMethod.GET)
    public ResponseEntity<Object> getCustomers() throws Exception {
        return new ResponseEntity<Object>(service.getCustomers(), HttpStatus.OK);
    }

    //  Create a customer
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Object> createCustomers(@RequestBody Customer customer) throws Exception {
        return new ResponseEntity<Object>(service.createCustomer(customer), HttpStatus.CREATED);
    }
    
    // UPDATE: Update a Customer by customerPK 
    @RequestMapping(value="/{customerPK}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable int customerPK) throws Exception {
        try {
            return new ResponseEntity<Object>(service.updateCustomer(customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
//    
// 
//    
//    // READ:  Read INSTRUMENTS from GigStatus for an existing Gig by GigId
//    @RequestMapping(value="/{id}",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigandGigStatuses(@PathVariable Long id) throws Exception {
//            return new ResponseEntity<Object>(service.getGigAndGigStatusesById(id), HttpStatus.OK);
//    }

    // READ:  Read all Customers that have a requested first name
    //        Print out all Customer info that have the same first name.
    @RequestMapping(value="/{firstName}/customer",method=RequestMethod.GET)
    public ResponseEntity<Object> getCustomerFirstName(@PathVariable String firstName) throws Exception {
            return new ResponseEntity<Object>(service.getCustomerFirstName(firstName), HttpStatus.OK);
    }   
    
//    // UPDATE: Update a Gig/GigStatus by id with a new Status ==> using new UserId
//    @RequestMapping(value="/{id}/users/{userId}/request", method=RequestMethod.PUT)
//    public ResponseEntity<Object> updateGigStatus(@RequestBody GigStatus gigStatus, @PathVariable Long id, @PathVariable Long userId) throws Exception {
//        try {
//            return new ResponseEntity<Object>(service.updateGigStatus(gigStatus, id, userId), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//    
//    // UPDATE: Update a Gig/GigStatus by id with a new Status by ID
//    @RequestMapping(value="/{id}/users/{musicianId}/confirm/{plannerId}", method=RequestMethod.PUT)
//    public ResponseEntity<Object> updateGigStatusConfirm(@RequestBody GigStatus gigStatus, @PathVariable Long id, @PathVariable Long musicianId, @PathVariable Long plannerId) throws Exception {
//        try {
//            return new ResponseEntity<Object>(service.updateGigStatusConfirm(gigStatus, id, musicianId, plannerId), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }   
//    }
//    
//    // READ:  Retrieve gigs with OPEN positions
//    @RequestMapping(value="/open",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigsandGigStatusByOPEN() throws Exception {
//        try {
//            return new ResponseEntity<Object>(service.getGigsAndGigStatusesByOpen(), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//    
//    // READ:  Retrieve gigs with OPEN positions matching /state/{name} 
//    @RequestMapping(value="/open/state/{name}",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigsandGigStatusByStateOpen(
//            @PathVariable String name, 
//            @RequestParam(value = "isOpen", required=false, defaultValue = "true") boolean isOpen) throws Exception {
//        
//        try {
//            return new ResponseEntity<Object>(service.getGigsAndGigStatusesByState(name, isOpen), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//    
//    // READ:  Retrieve gigs with OPEN positions matching /instrument/{name} 
//    @RequestMapping(value="/open/instrument/{name}",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigsandGigStatusByInstrumentOpen(
//            @PathVariable String name, 
//            @RequestParam(value = "isOpen", required=false, defaultValue = "true") boolean isOpen) throws Exception {
//        
//        try {
//            return new ResponseEntity<Object>(service.getGigsAndGigStatusesByInstrumentName(name,isOpen), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }   
//    
//    // READ:  Retrieve gigs with OPEN positions matching /genre/{type} 
//    @RequestMapping(value="/open/genre/{type}",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigsandGigStatusByGenreOPEN(
//            @PathVariable GenreType type, 
//            @RequestParam(value = "isOpen", required=false, defaultValue = "true") boolean isOpen) throws Exception {       
//        try {
//            return new ResponseEntity<Object>(service.getGigsAndGigStatusesByGenreType(type,isOpen), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }       
//
//    
//    // READ:  Retrieve gigs with matching /state/{name} 
//    @RequestMapping(value="/state/{name}",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigsandGigStatusByState(
//            @PathVariable String name, 
//            @RequestParam(value = "isOpen", required=false, defaultValue = "false") boolean isOpen) throws Exception {
//        try {
//            return new ResponseEntity<Object>(service.getGigsAndGigStatusesByState(name, isOpen), HttpStatus.OK);                   
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//        
//    // READ:  Retrieve gigs with matching /instrument/{name} 
//    @RequestMapping(value="/instrument/{name}",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigsandGigStatusByInstrument(
//            @PathVariable String name, 
//            @RequestParam(value = "isOpen", required=false, defaultValue = "false") boolean isOpen) throws Exception {      
//        try {
//            return new ResponseEntity<Object>(service.getGigsAndGigStatusesByInstrumentName(name,isOpen), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }   
//        
//    // READ:  Retrieve gigs with matching /genre/{type} 
//        @RequestMapping(value="/genre/{type}",method=RequestMethod.GET)
//        public ResponseEntity<Object> getGigsandGigStatusByGenre(
//                @PathVariable GenreType type, 
//                @RequestParam(value = "isOpen", required=false, defaultValue = "false") boolean isOpen) throws Exception {      
//            try {
//                return new ResponseEntity<Object>(service.getGigsAndGigStatusesByGenreType(type,isOpen), HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//            }
//        }       
//
//        
//    // READ:  Retrieve gigs by user (userId) assigned to it. 
//    @RequestMapping(value="/users/{userId}",method=RequestMethod.GET)
//    public ResponseEntity<Object> getGigStatusesByUserId(@PathVariable Long userId) throws Exception {
//            return new ResponseEntity<Object>(service.getGigStatusesByUserId(userId), HttpStatus.OK);
//    }
//    
//    
//    // DELETE:  Delete an existing Gig by GigId
//    //          BY DESIGN:  THIS ONLY WORKS if there are no interdependencies
//    //                      We DO NOT want gigs to be deleted, even if they are cancelled. 
//    //                      Instead, we want to set the STATUS to CANCELLED or CLOSED (if the event has happened!)
//    //
//    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//    public ResponseEntity<Object> deleteGig(@PathVariable Long id) throws Exception {
//        try {
//            service.deleteGig(id);
//            return new ResponseEntity<Object>("Successfully deleted gig with id: " + id, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
}
//
