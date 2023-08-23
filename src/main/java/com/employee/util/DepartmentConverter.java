package com.employee.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.employee.dto.DepartmentDTO;
import com.employee.entity.Department;


@Component
public class DepartmentConverter {
	
	//convert from DTO to entity
			public Department convertToDepartmentEntity(DepartmentDTO departmentDTO)
			{
				Department department=new Department();
				if(departmentDTO!=null)
				{
					BeanUtils.copyProperties(departmentDTO, department);
				}
				return department;
			}

			
			//convert from Entity to DTO
			public DepartmentDTO convertToEmployeeDTO(Department department)
			{
				DepartmentDTO departmentDTO=new DepartmentDTO();
				if(department!=null)
				{
					BeanUtils.copyProperties(department, departmentDTO);
				}
			 return departmentDTO;
			}
	

}
