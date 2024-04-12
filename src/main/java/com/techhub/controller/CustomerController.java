package com.techhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.model.Customer;
import com.techhub.service.CustomerService;
import com.techhub.service.CustomerServiceIMP;

@RestController
public class CustomerController {

	@Autowired CustomerService customerService; 
	// here we inject the object of service bcoz we call the service mtd
	
	@GetMapping("/customers")
	ResponseEntity <List<Customer>> getAllCustomer(){
		return ResponseEntity.ok().body(customerService.getAllCustomer());
	}
	
	@GetMapping("/customers/{id}")
    public ResponseEntity < Customer > getCustomerById(@PathVariable int id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping("/customers")
    public ResponseEntity < Customer > createCustomer(@RequestBody Customer customer) // here we pass customer object as parameter
    {
        return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
        //response is set to the Customer object returned by the createCustomer method of customerService
	
    }	
    
    @PutMapping("/customers/{id}")
    public ResponseEntity < Customer > updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
    	customer.setId(id); //setid for path veriable 
        return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
    }

    @DeleteMapping("/customers/{id}")
    public HttpStatus deleteCustomer(@PathVariable int id) {
        this.customerService.deleteCustomer(id);
        return HttpStatus.OK;
}
}
