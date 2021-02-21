package com.ensa.SmartSchool.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.mappers.ProfessorMapper;

@Component
public class ProfessorDao {
	
JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProfessorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Professor> getProfessors() {	
		return jdbcTemplate.query("select * from professor", new ProfessorMapper());
	}
	
	public Professor getProfessor(String firstName,String lastName) {
		return jdbcTemplate.queryForObject("select * from professor where professor_first_name=? and professor_last_name=?",new ProfessorMapper(),firstName,lastName);	
	}
	
public boolean updateProfessorFirstName(Professor professor,String firstName) {
		String sql="UPDATE professor SET PROFESSOR_FIRST_NAME=? WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,firstName,professor.getProfessorId());
		return true;
	}
	
	public boolean updateProfessorLastName(Professor professor,String lastName) {
		String sql="UPDATE professor SET PROFESSOR_LAST_NAME=? WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,lastName,professor.getProfessorId());
		return true;
	}
	public boolean delete(Professor professor) {
		String sql="DELETE FROM PROFESSOR WHERE PROFESSOR_ID=?";
		jdbcTemplate.update(sql,professor.getProfessorId());
		return true;
	}
	public boolean create(Professor professor) {
		String sql="INSERT INTO professor (professor_first_name,professor_last_name,level_name) VALUES (?,?,?)";
		jdbcTemplate.update(sql,professor.getProfessorFirstName(),professor.getProfessorLastName(),professor.getLevelName());
		return true;	
	}
}
	
