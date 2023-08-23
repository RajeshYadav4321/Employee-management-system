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

import com.employee.dto.DepartmentDTO;
import com.employee.service.DepartmentService;

import jakarta.validation.Valid;

public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/department")
	public List<DepartmentDTO> getAllDepartments(){
		return this.departmentService.getAllDepartments();
	}
	
	// Create to  Department
	@PostMapping("/department")
	public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
		DepartmentDTO department2= departmentService.saveDepartment(departmentDTO);
		return new ResponseEntity<>(department2, HttpStatus.CREATED);
	}
	
	
	// get department by id

		@GetMapping("/department/{id}")
		public ResponseEntity<DepartmentDTO> getDepartmentById1(@PathVariable Integer id) {
			DepartmentDTO department = departmentService.getDepartmentById(id);

			return ResponseEntity.ok(department);
		}
		
		// update department rest

		@PutMapping("/department/{id}")
		public ResponseEntity<DepartmentDTO> updateDepartment(@Valid @PathVariable Integer id, @RequestBody DepartmentDTO department) {
			DepartmentDTO departmentUpdated = departmentService.updateDepartmentById(id, department);
			return ResponseEntity.ok(departmentUpdated);

		}
		
		
		// delete department

		@DeleteMapping("/department/{id}")
		public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) {
			departmentService.deleteDepartmentById(id);
			return ResponseEntity.noContent().build();
		}
	
	
	
}
