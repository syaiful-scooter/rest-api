package com.syaiful.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syaiful.api.models.Customer;

@Repository
public interface LoginRepository extends JpaRepository<Customer, Integer>{

}
