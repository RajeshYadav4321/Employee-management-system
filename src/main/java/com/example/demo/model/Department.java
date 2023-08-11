package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	@Id
	private int department_Id;
	private String department_Name;
	//@OneToOne(mappedBy ="Employee",cascade = CascadeType.ALL)
	//@JoinColumn(name = "Employee")
	//private Employee employee;
	
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
	private List<Employee> employeeList=new ArrayList<>();
	
	public int getDepartment_Id() {
		return department_Id;
	}
	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}
	public String getDepartment_Name() {
		return department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}
	@Override
	public String toString() {
		return "Department [department_Id=" + department_Id + ", department_Name=" + department_Name + "]";
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int department_Id, String department_Name) {
		super();
		this.department_Id = department_Id;
		this.department_Name = department_Name;
	}

}
