package com.examplerest.demo.services;

import java.util.List;

import com.examplerest.demo.entities.*;
public interface Employeeservice {

	public List<Departments> getdepartments();
	
	public Departments getdepartment(long deptId);
	
	public Departments adddepartment(Departments dept);
	
	public Departments updatedepartment(Departments updatedept);
	
	public Departments deletedepartment(long deptId);
	
}
