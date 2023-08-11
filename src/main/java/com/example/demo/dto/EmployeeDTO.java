package com.example.demo.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
	
	@NotNull
	
	private long id;
	@NotNull
	@Size(min = 3, max = 30, message="firstName should be minimum 3 characters")
	private String firstName;
	
	@NotNull
    @Size(min = 3, max = 30, message="lastName should be minimum 3 characters")
	private String lastName;
	@jakarta.validation.constraints.Email(message="Email addresss not valid")
	private String emailId;

}
