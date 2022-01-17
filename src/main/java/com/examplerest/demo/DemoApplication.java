package com.examplerest.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examplerest.demo.dao.UserDao;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private UserDao userdao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//cannot call createtable method here since it is static so used CommandLineRunner 
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userdao.createtable());
		//creating user
		
		//this.createdept();
		//this.updatedept();
		this.deletedept();
	}
	
	public void createdept() throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //to take id 
		System.out.println("Enter Department id:");
		Integer deptId=Integer.parseInt(br.readLine());
		
		System.out.println("Enter Department name:");
		String name=br.readLine();
		
		System.out.println("Enter Description:");
		String description=br.readLine();
		
		int i=this.userdao.insertdept(deptId, name, description);
		System.out.println(i+" department added");
	}
	public void updatedept() throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //to take id 
		System.out.println("Enter Department id:");
		Integer deptId=Integer.parseInt(br.readLine());
		
		System.out.println("Enter Department name:");
		String name=br.readLine();
		
		System.out.println("Enter Description:");
		String description=br.readLine();

		int i=this.userdao.updatedept(deptId, name, description);
		System.out.println(i+" department updated");
		
	}
	public void deletedept() throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //to take id 
		System.out.println("Enter Department id:");
		Integer deptId=Integer.parseInt(br.readLine());
		
		int i=this.userdao.deletedept(deptId);
		System.out.println(i+" department deleted");
		
	}

}
