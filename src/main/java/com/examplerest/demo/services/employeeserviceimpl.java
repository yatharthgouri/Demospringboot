package com.examplerest.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examplerest.demo.entities.Departments;
@Service   //this is to denote that this is the implementation class of the employeeservice class i.e this class provides service to the above class
public class employeeserviceimpl implements Employeeservice {
	
	List<Departments> list;
	public employeeserviceimpl() {   //making a constructor
		list=new ArrayList<>();
		list.add(new Departments(10,"InvestmentBanking","Maintaining the web portal of tradebook"));
		list.add(new Departments(13,"HR","Hiring and keeping record of employees"));
	}
	@Override
	public List<Departments> getdepartments() { //to list all the departments 
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public Departments getdepartment(long deptId) {  //  to give a single department
		// TODO Auto-generated method stub
		Departments d=null;
		for(Departments dept:list)
		{
			if(dept.getId()==deptId)
			{
				d=dept;
				break;
			}
		}
		return d;
	}
	
	@Override
	public Departments adddepartment(Departments dept) {
		// TODO Auto-generated method stub
		list.add(dept);
		return dept;
	}
	
	@Override
	public Departments updatedepartment(Departments updatedept) {
		// TODO Auto-generated method stub
		for(Departments dept:list)
		{
			if(dept.getId()==updatedept.getId())
			{
				dept.setTitle(updatedept.getTitle());
				dept.setDescription(updatedept.getDescription());
				break;
			}
		}
		return updatedept;
	}
	
	@Override
	public Departments deletedepartment(long deptId) {
		// TODO Auto-generated method stub
		Departments d=null;
		for(Departments dept:list)
		{
			if(dept.getId()==deptId)
			{
				d=dept;
				list.remove(dept);
				break;
			}
		}
		return d;
	}
	

}
