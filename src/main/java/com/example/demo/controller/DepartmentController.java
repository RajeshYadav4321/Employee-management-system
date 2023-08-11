package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
@RestController
public class DepartmentController {

	@Autowired
	private  DepartmentRepository departmentRepository;
	
	
		//get all department
		@GetMapping("/department")
		public List<Department> getAllDepartment(){
			return departmentRepository.findAll();
		}
		
		// create department rest api
		@PostMapping("/department")
	   public Department createDepartment(@RequestBody Department department) {
		   return departmentRepository.save(department);
	   }
		
		// get department by id rest api
				@GetMapping("/department/{id}")
				public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
					//int department_id;
					Department department = departmentRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" +id));
							return ResponseEntity.ok(department);
				}
		// All dept 
			@DeleteMapping("/department/{id}")
			public void deleteAllDepartment(){
				departmentRepository.deleteAll();
				}
			
			//@GetMapping("/department/{id}")
		    //  public List<Department> getAllDepartments() {
		    //    return departmentRepository.findAll(id);
		   //}
			
			
			}