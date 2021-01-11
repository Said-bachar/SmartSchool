package com.ensa.SmartSchool;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ensa.SmartSchool.entity.Admin;
import com.ensa.SmartSchool.entity.Level;
import com.ensa.SmartSchool.entity.Student;
import com.ensa.SmartSchool.service.AdminService;
import com.ensa.SmartSchool.service.LevelService;
import com.ensa.SmartSchool.service.StudentService;

@SpringBootApplication
public class SmartSchoolApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		//StudentService sr = ac.getBean(StudentService.class);
		//AdminService sr = ac.getBean(AdminService.class);
		/*Admin admin = new Admin();
		admin.setUsername("Chiney");
		admin.setPassword("2021");
		sr.create(admin);*/
		/*Student student = new Student();
		 * 
		student.setFirstName("mary");
		student.setLastName("doe");
		student.setPassword("123987");
		student.setEmail("mary@doe.com");
		student.setBirthDate(new Date());
		student.setPhoneNumber("000");*/
		//Student student = sr.getStudent("said","bachar");
		//sr.updateEmail(student,"mary@kjebfkjebgkl.6577");
		//sr.create(student);
		//System.out.println(sr.read());
		LevelService lr =ac.getBean(LevelService.class);
		//Level level1=new Level();
		//level1.setLevelName("gi3");
		//Level level2=new Level();
		//level2.setLevelName("gi4");
		//lr.create(level1);
		//lr.create(level2);
		Level level3=lr.getLevel("gi3");
		lr.updateLevelName(level3, "gil3");
		//Level level4=lr.getLevel("gil3");
		//lr.delete(level4);
		
		
	}
}
