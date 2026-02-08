package com.syaiful.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syaiful.api.models.Customer;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "Hello spring boot";
	}
	
	@GetMapping("/customer")
	public List<Customer> customers(){
		List<Customer> c = List.of(
				new Customer(1, "budi", "Anto", 0),
				new Customer(2, "Andi", "Afrizal",0),
				new Customer(3, "David", "",0)
				);
		return c;
	}
	
}
