package com.ensa.SmartSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.dao.StudentDao;
import com.ensa.SmartSchool.entity.Student;

@Component
public class StudentService {

	private StudentDao studentDao;

	@Autowired
	public StudentService(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	public List<Student> getStudents() {

		return this.studentDao.getStudents();
	}

	public Student getStudent(String firstName, String lastName) {
		return this.studentDao.getStudent(firstName, lastName);
	}

	public boolean create(Student student) {

		return studentDao.create(student);
	}

	public boolean updateEmail(Student student, String email) {

		return studentDao.updateEmail(student, email);
	}

	public boolean updatePhoneNumber(Student student, String phoneNumber) {

		return studentDao.updatePhoneNumber(student, phoneNumber);
	}

	public boolean updatePassword(Student student, String password) {

		return studentDao.updatePassword(student, password);
	}
	public boolean delete(Student student) {
		return studentDao.delete(student);
	}
	
	public List<Student> read() {
		return studentDao.read();
	}
	
        public boolean authenticate(String email, String password) {
		
		Student student = studentDao.findStudentByEmail(email);
		
		if(student.equals(null)) {
			return false;
		}
		return student.getPassword().equals(password) ;
	}

}
