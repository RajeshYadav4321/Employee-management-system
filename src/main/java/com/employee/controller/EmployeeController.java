package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<EmployeeDTO> getAllEmployees(){
		return this.employeeService.getAllEmployees();
	}
	
	// Create to  Employee
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO employee2= employeeService.saveEmployee(employeeDTO);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}
	
	
	// get employee by id

		@GetMapping("/employee/{id}")
		public ResponseEntity<EmployeeDTO> getEmployeeById1(@PathVariable Integer id) {
			EmployeeDTO employee = employeeService.getEmployeeById(id);

			return ResponseEntity.ok(employee);
		}
		
		// update employee rest

		@PutMapping("/employee/{id}")
		public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @PathVariable Integer id, @RequestBody EmployeeDTO employee) {
			EmployeeDTO employeeUpdated = employeeService.updateEmployeeById(id, employee);
			return ResponseEntity.ok(employeeUpdated);

		}
		
		
		// delete employee

		@DeleteMapping("/employee/{id}")
		public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
			employeeService.deleteEmployeeById(id);
			return ResponseEntity.noContent().build();
		}
	
	
	
}
