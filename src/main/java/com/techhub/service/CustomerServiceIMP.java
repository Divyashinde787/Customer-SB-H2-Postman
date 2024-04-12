package com.techhub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.exception.ResourceNotFoundException;
import com.techhub.model.Customer;
import com.techhub.repository.CustomerRepo;

@Service
public class CustomerServiceIMP implements CustomerService{

	@Autowired CustomerRepo customerrepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerrepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// we need to fetch record from database
		Optional < Customer > customerDb = this.customerrepository.findById(customer.getId()); //getid from itself
//java provide optional class to handle nullpoint exception
		
		//using if else we check custometr is present or not 
        if (customerDb.isPresent()) {
            Customer customerUpdate = customerDb.get();
            customerUpdate.setId(customer.getId());
            customerUpdate.setName(customer.getName());
            customerUpdate.setSalary(customer.getSalary());
            customerUpdate.setCity(customer.getCity());
            customerrepository.save(customerUpdate);
            return customerUpdate;
	}else {
		 throw new ResourceNotFoundException("Record not found with id : " + customer.getId());
	}
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return this.customerrepository.findAll();
	
		
	}

	@Override
	public Customer getCustomerById(int CustomerId) {
		// TODO Auto-generated method stub
		Optional < Customer > customerDb = this.customerrepository.findById(CustomerId);
		if (customerDb.isPresent()) {
            return customerDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + CustomerId);
        }
	}

	@Override
	public void deleteCustomer(int CustomerId) {
		// TODO Auto-generated method stub
		Optional < Customer > customerDb = this.customerrepository.findById(CustomerId);
		if (customerDb.isPresent()) {
            this.customerrepository.delete(customerDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + customerDb);
        }
	}
	
	

}
