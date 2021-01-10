package com.ensa.SmartSchool.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ensa.SmartSchool.entity.Admin;

public class AdminMapper implements RowMapper<Admin> {
	
	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Admin admin = new Admin();
		admin.setUsername(rs.getNString("username"));
		admin.setPassword(rs.getNString("password"));
		return admin;
	}

}
