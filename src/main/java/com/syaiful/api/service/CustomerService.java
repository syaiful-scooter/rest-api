package com.syaiful.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syaiful.api.dto.CustomerDTO;
import com.syaiful.api.dto.SaldoDTO;
import com.syaiful.api.models.Customer;
import com.syaiful.api.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public List<CustomerDTO> get() {
		List<Customer> ls = repo.findAll();
		List<CustomerDTO> lsDTO = new ArrayList<CustomerDTO>();

		for (Customer cs : ls) {

			CustomerDTO csDTO = new CustomerDTO();
			csDTO.setId(cs.getId());
			csDTO.setFirstName(cs.getFirstName());
			csDTO.setLastName(cs.getLastName());

			lsDTO.add(csDTO);
		}
		return lsDTO;
	}

	public Customer get(int id) {
		return repo.findById(id).orElse(null);
	}

	//	public List<Customer> get(){
	//		return repo.findAll();
	//	}
	public CustomerDTO getID(int id) {
		Customer u = repo.findById(id).orElse(null);
		CustomerDTO csDTO = null;
		if (u != null) {
			csDTO = new CustomerDTO();
			csDTO.setId(u.getId());
			csDTO.setFirstName(u.getFirstName());
			csDTO.setLastName(u.getLastName());
			csDTO.setAmount(u.getAmount());
		}
		return csDTO;
	}

	public List<Customer> findByFullName(String fname, String lname) {
		return repo.findByFirstNameAndLastName(fname, lname);
	}

	public void updateSaldo(SaldoDTO saldo) {
		// TODO Auto-generated method stub
		Customer c = get(saldo.getCustomerId());
		if(c != null) {
			double currentSaldo = c.getAmount();
			double newSaldo = currentSaldo + saldo.getAmount();
			c.setAmount(newSaldo);
			
			repo.save(c);
		}
		
	}

}
