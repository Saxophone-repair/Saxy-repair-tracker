package com.saxyrepairtracker.saxophone.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saxyrepairtracker.saxophone.entity.Customer;
import com.saxyrepairtracker.saxophone.service.CustomerService;

@RestController
//@RequestMapping("/saxophone/customer") //?
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
    

    // READ:  Read all Customers that have a requested first name
    //        Print out all Customer info that have the same first name.
    @RequestMapping(value="/{firstName}/customer",method=RequestMethod.GET)
    public ResponseEntity<Object> getCustomerFirstName(@PathVariable String firstName) throws Exception {
            return new ResponseEntity<Object>(service.getCustomerFirstName(firstName), HttpStatus.OK);
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
}
//
