package com.ensa.SmartSchool.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Student;

@Component
public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setStudentId(rs.getInt("student_id"));
		student.setFirstName(rs.getString("first_name"));
		student.setLastName(rs.getString("last_name"));
		student.setEmail(rs.getString("email"));
		student.setPassword(rs.getString("password"));
		student.setBirthDate(rs.getDate("birth_date"));
		student.setPhoneNumber(rs.getString("phone_number"));
		student.setMaxAttempts(rs.getInt("max_attempts"));
		return student;
	}

}
