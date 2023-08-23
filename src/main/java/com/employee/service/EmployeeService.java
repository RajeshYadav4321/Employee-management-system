package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDTO;

public interface EmployeeService {
	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(Integer id);

	EmployeeDTO updateEmployeeById(Integer id, EmployeeDTO employeeDTO);

	void deleteEmployeeById(Integer id);

}
