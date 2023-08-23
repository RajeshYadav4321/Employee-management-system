package com.employee.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.controller.excption.ResourceNotFoundException;
import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
    private ModelMapper modelMapper;
	
	
	
	// Get All Employee
      @Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees=this.employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs= employees.stream().map(e-> this.employeeToDTO(e)).collect(Collectors.toList());
		return employeeDTOs;
	}
	
	// Get Employee 
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = this.dtoToEmployee(employeeDTO);
		Employee saveEmployee = employeeRepository.save(employee);
		return this.employeeToDTO(saveEmployee);
	}
	
	// get employee by id

		//@Override
		public EmployeeDTO getEmployeeById1(Integer id) {

			Employee employee = this.employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
			return this.employeeToDTO(employee);
		}
		
		
		
		// delete employee

		@Override
		public void deleteEmployeeById(Integer id){

			Employee employee = this.employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
			this.employeeRepository.delete(employee);

		}
	
	
		// update employee

		@Override
		public EmployeeDTO updateEmployeeById(Integer id, EmployeeDTO employeeDTO) {
			Employee employee = this.employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
			employee.setFirstName(employeeDTO.getFirstName());
			employee.setLastName(employeeDTO.getLastName());
			employee.setAddress(employeeDTO.getAddress());
			employee.setEmailId(employeeDTO.getEmailId());
			Employee updateEmployee=this.employeeRepository.save(employee);
			EmployeeDTO employeeDTO2=this.employeeToDTO(updateEmployee);
			return employeeDTO2;
		   
		
		}

		@Override
		public EmployeeDTO getEmployeeById(Integer id) {
			// TODO Auto-generated method stub
			return null;
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
