package com.syaiful.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syaiful.api.dto.CustomerDTO;
import com.syaiful.api.dto.SaldoDTO;
import com.syaiful.api.service.CustomerService;

@RestController
@RequestMapping("/master/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/data")
	public List<CustomerDTO> customerData() {
		List<CustomerDTO> data = service.get();
		return data;
	}

	@GetMapping("/{id}")
	public CustomerDTO customerId(@PathVariable("id") int id) {
		return service.getID(id);
	}
	
	
	@PutMapping("/saldo/update")
	public Map<String, Object> updateSaldo(@RequestBody SaldoDTO saldo){
		service.updateSaldo(saldo);
		return Map.of("status", true, "message", "sukses");
	}

}
