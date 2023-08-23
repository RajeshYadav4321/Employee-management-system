package com.employee.service;

import java.util.List;

import com.employee.dto.DepartmentDTO;

public interface DepartmentService {
	List<DepartmentDTO> getAllDepartments();
	DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
	DepartmentDTO getDepartmentById(Integer id);
	DepartmentDTO updateDepartmentById(Integer id, DepartmentDTO departmentDTO);
	void deleteDepartmentById(Integer id);
	
	

}
