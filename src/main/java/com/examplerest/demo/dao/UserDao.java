package com.examplerest.demo.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate; //jdbctemplate object
	public UserDao() //constructor
	{
		
	}
	public int showtable()
	{
		String query="show Department";
		int update=this.jdbctemplate.update(query);
		return update;
	}
	public int createtable()
	{
		String query="CREATE TABLE IF NOT EXISTS Department(id int primary key, name varchar(200), description varchar(500))";
		int update=this.jdbctemplate.update(query);
		return update;
	}
	public int insertdept(Integer id, String name,String description)
	{
		String query="insert into Department(id,name,description) values(?,?,?)"; //? is used bcoz dynamic value 
		int update=this.jdbctemplate.update(query,new Object[] {id,name,description});
		return update;
	}

	public int updatedept(Integer id, String name,String description)
	{
		String query="update Department set name=?, description=? where id=?";
		int update=this.jdbctemplate.update(query,new Object[] {name,description,id});
		return update;
	}
	
	public int deletedept(Integer id)
	{
		String query="delete from Department where id=?";
		int update=this.jdbctemplate.update(query,new Object[] {id});
		return update;
	}

}
