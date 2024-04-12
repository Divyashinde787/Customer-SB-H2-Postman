package com.techhub.service;

import java.util.List;

import com.techhub.model.Customer;

public interface CustomerService {
	
	Customer createCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer getCustomerById(int CustomerId);
	
	void deleteCustomer(int CustomerId);
	
	
	

}
