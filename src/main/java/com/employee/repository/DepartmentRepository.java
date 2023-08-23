package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
