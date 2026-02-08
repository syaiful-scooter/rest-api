package com.syaiful.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syaiful.api.models.Customer;

@Repository
// evrything by default (CRUD)
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// Custom
	// select * from customer where firstname = ???
	List<Customer> findByFirstName(String firstName);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
