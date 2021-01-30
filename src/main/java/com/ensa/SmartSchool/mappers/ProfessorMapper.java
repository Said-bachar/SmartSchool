package com.ensa.SmartSchool.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Professor;

@Component
public class ProfessorMapper implements RowMapper<Professor> {

	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Professor professor =new Professor();
		professor.setProfessorId(rs.getInt("professor_id"));
		professor.setProfessorFirstName(rs.getString("professor_first_name"));
		professor.setProfessorLastName(rs.getString("professor_last_name"));
		professor.setLevelName(rs.getString("level_name"));
		professor.setPassword(rs.getString("password"));
		return professor;
	}

}
