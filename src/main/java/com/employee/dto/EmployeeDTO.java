package com.employee.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {
	@NotNull
	@Id
	private int id;
	@NotNull
	@Size(min = 3, max = 30)
	private String firstName;
	@NotNull
	private String lastName;
	private String address;
	private String emailId;
}
