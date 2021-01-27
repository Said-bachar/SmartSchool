package com.ensa.SmartSchool;

<<<<<<< HEAD
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======


//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ensa.SmartSchool.entity.Admin;
<<<<<<< HEAD
import com.ensa.SmartSchool.entity.Level;
import com.ensa.SmartSchool.service.AdminService;
import com.ensa.SmartSchool.service.LevelService;
=======

import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.service.AdminService;
import com.ensa.SmartSchool.service.ProfessorService;

>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a

//import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;


@SpringBootApplication
public class SmartSchoolApplication {
	
	public static void main(String[] args) {
		
<<<<<<< HEAD
		//Application.launch(SmartSchoolJavaFX.class, args);
		//ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		//StudentService sr = ac.getBean(StudentService.class);
		ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		/*AdminService adminService=ac.getBean(AdminService.class);
		System.out.println(adminService.getAdmins());
		Admin admin=new Admin();
		admin.setUsername("mahacine");
		admin.setPassword("12365");
		adminService.create(admin);
		Admin admin=adminService.getAdmin("Ghoujdamy");
		System.out.println(admin.getUsername());
		adminService.updateUsername(admin, "Ghoujdamy");
		adminService.delete(admin);*/
		LevelService levelService=ac.getBean(LevelService.class);
		/*System.out.println(levelService.getLevels());
		Level level=new Level();
		level.setLevelName("gil4");
		levelService.create(level);
		System.out.println(levelService.getProfessors("gi4"));
		Level level=levelService.getLevel("gil4");
		levelService.updateLevelName(level, "gil3");*/
		Level level=levelService.getLevel("gil3");
		levelService.delete(level);
=======

		//Application.launch(SmartSchoolJavaFX.class, args);
		//ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		//StudentService sr = ac.getBean(StudentService.class);

  
		ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		//AdminService adminService=ac.getBean(AdminService.class);
		ProfessorService profService = ac.getBean(ProfessorService.class);
		//System.out.println(adminService.getAdmins());
		/*Admin admin=new Admin();
		admin.setUsername("said");
		admin.setPassword("123456789");
		adminService.create(admin);
		System.out.println(adminService.getAdmins());*/
		//Admin admin=adminService.getAdmin("bachar");
		//System.out.println(admin.getUsername());
		//adminService.updateUsername(admin, "bachar");
		//adminService.delete(admin);
		/*Professor prof = new Professor();
		prof.setProfessorFirstName("Ahmed");
		prof.setProfessorLastName("Oukhoya");
		prof.setLevelName("cp2");
		profService.create(prof);*/
		Professor prof = profService.getProfessorByFirstName("Said");
		System.out.println(prof);
		profService.delete(prof);
		System.out.println(profService.getProfessors());
		
						

>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
	}
	
}
