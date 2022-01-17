package com.examplerest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examplerest.demo.entities.Departments;
import com.examplerest.demo.services.Employeeservice;

@RestController
public class MyController {

	@Autowired    //autowired will make an object for us of imlementation class of this employeeservice class in eservice
	private Employeeservice eservice; //declaring name for my interface class
	@GetMapping("/home")
	public String home() {
		return "Welcome to my first springboot project";
	}
	
	//get the Department data
	@GetMapping("/departments")
	public List<Departments> getdepartments()
	{
		return this.eservice.getdepartments();
	}
	
	@GetMapping("/departments/{deptId}") //Will pass dynamic values in deptid
	public Departments getdepartment(@PathVariable String deptId)
	{
		return this.eservice.getdepartment(Long.parseLong(deptId));
	}
	
	@PostMapping("/departments")
	public Departments adddepartment(@RequestBody Departments dept)
	{
		return this.eservice.adddepartment(dept);
	}
	
	@PutMapping("/departments")
	public Departments updatedepartment(@RequestBody Departments updatedept)
	{
		return this.eservice.updatedepartment(updatedept);
	}
	
	@DeleteMapping("/departments/{deptId}")
	public Departments deletedepartment(@PathVariable String deptId) //fetching the passed id into string
	{
		return this.eservice.deletedepartment(Long.parseLong(deptId));
	}
	
}
