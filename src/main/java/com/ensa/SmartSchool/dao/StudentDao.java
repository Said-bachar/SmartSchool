package com.ensa.SmartSchool.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Student;
import com.ensa.SmartSchool.mappers.StudentMapper;

@Component
public class StudentDao {

JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StudentDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}


	
	public List<Student> getStudents() {
			
		return jdbcTemplate.query("select * from student", new StudentMapper());
	}
	
	public Student getStudent(String firstName, String lastName) {
		
		return jdbcTemplate.queryForObject("select * from student where first_name = ? and last_name= ? ",new StudentMapper(),
				firstName, lastName);
		
		
	}
	public boolean create(Student student) {
		String sql="INSERT INTO STUDENT(first_name,last_name,email,password,birth_date,phone_number)VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,student.getFirstName(),student.getLastName(),student.getEmail(), student.getPassword(),
				student.getBirthDate(),student.getPhoneNumber());
		return true;
		
	}
	
	public boolean updateEmail(Student student, String email) {
		String sql="UPDATE STUDENT SET EMAIL=? WHERE STUDENT_ID=?";
		jdbcTemplate.update(sql,email,student.getStudentId());
		return true;
	}
	
	public boolean updatePhoneNumber(Student student,String phoneNumber) {
		String sql="UPDATE STUDENT SET PHONE_NUMBER=? WHERE STUDENT_ID=?";
		jdbcTemplate.update(sql,phoneNumber,student.getStudentId());
		return true;
	}
	
	public boolean updatePassword(Student student,String password) {
		String sql="UPDATE STUDENT SET PASSWORD=? WHERE STUDENT_ID=?";
		jdbcTemplate.update(sql,password,student.getStudentId());
		return true;
	}
	public boolean delete(Student student) {
		String sql="DELETE FROM STUDENT WHERE STUDENT_ID=?";
		jdbcTemplate.update(sql, student.getStudentId());
		return true;
	}
	
	public List<Student> read(){
		String sql="SELECT * FROM STUDENT";
		List<Student> list =jdbcTemplate.query(sql,new StudentMapper());
		return list;
	}
	
	public Student findStudentByEmail(String email) {
		String sql="SELECT * FROM STUDENT WHERE EMAIL=?";
		
		return jdbcTemplate.queryForObject(sql, new StudentMapper(),email);
	}

}
