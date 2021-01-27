package com.ensa.SmartSchool.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.entity.Student;
import com.ensa.SmartSchool.mappers.StudentMapper;

@Component
public class StudentDao {


	@Autowired
    private RestTemplate restTemplate;

	
	public List<Student> getStudents() {
			
		String StudentResourceUrl = "http://localhost:8081/student/getStudents";
		ResponseEntity<Student[]> response = restTemplate.getForEntity(StudentResourceUrl, Student[].class);
		Student[] studentsTab=response.getBody();
		List<Student> students=Arrays.asList(studentsTab);
		return students;
	}
	
	public Student getStudent(int id) {
		String StudentResourceUrl = "http://localhost:8081/student/getStudent/id="+id;
		 HttpEntity<Integer> request = new HttpEntity<Integer>(id);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
	}
	
	public Student create(Student student) {
		String StudentResourceUrl = "http://localhost:8081/student/create";
		 HttpEntity<Student> request = new HttpEntity<Student>(student);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
		
	}
	
	public Student updateEmail(Student student, String email) {
		
		String StudentResourceUrl = "http://localhost:8081/student/updateEmail/email="+email;
		 HttpEntity<Student> request = new HttpEntity<Student>(student);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
	}
	
	public Student updatePhoneNumber(Student student,String phoneNumber) {
		String StudentResourceUrl = "http://localhost:8081/student/updatePhoneNumber/phoneNumber="+phoneNumber;
		 HttpEntity<Student> request = new HttpEntity<Student>(student);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
	}
	
	public Student updatePassword(Student student,String password) {
		 String StudentResourceUrl = "http://localhost:8081/student/updatePassword/password="+password;
		 HttpEntity<Student> request = new HttpEntity<Student>(student);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
	}
	public Student delete(Student student) {
		String StudentResourceUrl = "http://localhost:8081/student/delete";
		 HttpEntity<Student> request = new HttpEntity<Student>(student);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
	}
	
	
	
	public Student getStudentByEmail(String email) {
		String StudentResourceUrl = "http://localhost:8081/student/getStudentByEmail";
		 HttpEntity<String> request = new HttpEntity<String>(email);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
	}
	
	public Student updateMaxAttempts(Student student) {
		 String StudentResourceUrl = "http://localhost:8081/student/updateMaxAttemps";
		 HttpEntity<Student> request = new HttpEntity<Student>(student);
		 return restTemplate.postForObject(StudentResourceUrl, request, Student.class);
		
	}

}
