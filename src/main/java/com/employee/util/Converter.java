package com.employee.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;


@Component
@Configuration
public class Converter {
	public ModelMapper modelMapper=null;
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	// Employee to DTO Converter

			public Employee dtoToEmployee(EmployeeDTO employeeDTO) {

				Employee employee = this.modelMapper.map(employeeDTO, Employee.class);
				return employee;
			}

			// DTO to Employee converter

			public EmployeeDTO employeeToDTO(Employee employee) {
				EmployeeDTO employeeDTO = this.modelMapper.map(employee, EmployeeDTO.class);
				return employeeDTO;
			}

	
	
	}


