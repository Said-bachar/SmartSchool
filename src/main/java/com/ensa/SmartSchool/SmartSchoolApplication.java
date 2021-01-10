package com.ensa.SmartSchool;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ensa.SmartSchool.entity.Student;
import com.ensa.SmartSchool.service.StudentService;

@SpringBootApplication
public class SmartSchoolApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		StudentService sr = ac.getBean(StudentService.class);
		/*Student student = new Student();
		student.setFirstName("mary");
		student.setLastName("doe");
		student.setPassword("123987");
		student.setEmail("mary@doe.com");
		student.setBirthDate(new Date());
		student.setPhoneNumber("000");*/
		Student student = sr.getStudent("said","bachar");
		sr.updateEmail(student,"mary@kjebfkjebgkl.6577");
		//sr.create(student);
		System.out.println(sr.read());
		
	}
}
