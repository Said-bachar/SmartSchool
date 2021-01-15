package com.ensa.SmartSchool.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Admin;
import com.ensa.SmartSchool.mappers.AdminMapper;

@Component
public class AdminDao {

JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AdminDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}


	
	public List<Admin> getAdmins() {
			
		return jdbcTemplate.query("select * from ADMIN", new AdminMapper());
	}
	
	public Admin getAdmin(String username) {
		String sql = "SELECT * FROM ADMIN WHERE USERNAME=?";
		return jdbcTemplate.queryForObject(sql, new AdminMapper(),username);
		
		
	}
	public boolean create(Admin admin) {
		String sql="INSERT INTO ADMIN(username,password)VALUES (?,?)";
		jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword());
		return true;
		
	}
	
	public boolean updateUsername(Admin admin, String username) {
		String sql="UPDATE Admin SET Username=? WHERE Username=?";
		jdbcTemplate.update(sql,username,admin.getUsername());
		return true;

	}
	public boolean updatePassword(Admin admin,String password) {
		String sql="UPDATE ADMIN SET PASSWORD=? WHERE username=?";
		jdbcTemplate.update(sql,password,admin.getUsername());
		return true;
	}
	public boolean delete(Admin admin) {
		String sql="DELETE FROM ADMIN WHERE Username=?";
		jdbcTemplate.update(sql,admin.getUsername());
		return true;
	}
	
}


