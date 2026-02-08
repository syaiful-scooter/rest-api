package com.syaiful.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDTO {
	private int id;

	@NotBlank
	private String firstName;

	private String lastName;
	
	private double amount;
	
	private String email;
	
	private String password;
}
