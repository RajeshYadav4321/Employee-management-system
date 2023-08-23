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
public class DepartmentDTO {
	@Id
	@NotNull
	private int deptId;
	@NotNull
	@Size(min = 3, max = 30)
	private String deptName;
	

}
