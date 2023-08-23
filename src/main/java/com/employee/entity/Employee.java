package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String emailId;
	
	
		
}
