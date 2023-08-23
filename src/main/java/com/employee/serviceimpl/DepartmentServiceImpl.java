package com.employee.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.controller.excption.ResourceNotFoundException;
import com.employee.dto.DepartmentDTO;
import com.employee.entity.Department;
import com.employee.repository.DepartmentRepository;
import com.employee.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private ModelMapper modelMapper;
    
	

	// Get All Department
      @Override
	public List<DepartmentDTO> getAllDepartments() {
		List<Department> departments=this.departmentRepository.findAll();
		List<DepartmentDTO> departmentDTOs= departments.stream().map(e-> this.departmentToDTO(e)).collect(Collectors.toList());
		return departmentDTOs;
	}
	
	// Get Department 
	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		Department department = this.dtoToDepartment(departmentDTO);
		Department saveDepartment = departmentRepository.save(department);
		return this.departmentToDTO(saveDepartment);
	}


		// delete department

		@Override
		public void deleteDepartmentById(Integer id){

			Department department = this.departmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Department with id " + id + " not found"));
			this.departmentRepository.delete(department);

		}
	
	
		// update department

		@Override
		public DepartmentDTO updateDepartmentById(Integer id, DepartmentDTO departmentDTO) {
			Department department = this.departmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Department with id " + id + " not found"));
			department.setDeptId(departmentDTO.getDeptId());
			department.setDeptName(departmentDTO.getDeptName());
			Department updateDepartment=this.departmentRepository.save(department);
			DepartmentDTO departmentDTO2=this.departmentToDTO(updateDepartment);
			return departmentDTO2;
		   
		
		}

		@Override
		public DepartmentDTO getDepartmentById(Integer id) {
		Department	department=departmentRepository.findById(id).get();
			DepartmentDTO departmentDTO= this.departmentToDTO(department);
			return  departmentDTO;
		}
	
	
	// Department to DTO Converter

			public Department dtoToDepartment(DepartmentDTO departmentDTO) {

				Department department = this.modelMapper.map(departmentDTO, Department.class);
				return department;
			}

			// DTO to Department converter

			public DepartmentDTO departmentToDTO(Department department) {
				DepartmentDTO departmentDTO = this.modelMapper.map(department, DepartmentDTO.class);
				return departmentDTO;
			}

			


}
