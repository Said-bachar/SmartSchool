package com.ensa.SmartSchool;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ensa.SmartSchool.entity.Admin;
import com.ensa.SmartSchool.entity.Level;
import com.ensa.SmartSchool.service.AdminService;
import com.ensa.SmartSchool.service.LevelService;

//import org.springframework.context.ConfigurableApplicationContext;
import javafx.application.Application;

@SpringBootApplication
public class SmartSchoolApplication {
	
	public static void main(String[] args) {
		
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
	}
	
}
