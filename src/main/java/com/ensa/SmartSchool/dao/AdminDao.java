package com.ensa.SmartSchool.dao;

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
	
	public Admin getAdmin () {
		return jdbcTemplate.queryForObject("select * from admin",new AdminMapper());
	}
	

}
