package com.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techhub.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	//Customer save(Customer customer);

}
