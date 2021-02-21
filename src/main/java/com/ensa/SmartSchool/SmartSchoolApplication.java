package com.ensa.SmartSchool;

<<<<<<< HEAD
<<<<<<< HEAD
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======
import org.springframework.boot.SpringApplication;
=======
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
import com.ensa.SmartSchool.entity.Admin;
import com.ensa.SmartSchool.service.AdminService;
=======
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903

>>>>>>> c10a2a4... Add restTemplate and connection to server
//import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;


@SpringBootApplication
public class SmartSchoolApplication {
	
	public static void main(String[] args) {
		
		Application.launch(SmartSchoolJavaFX.class, args);
<<<<<<< HEAD
<<<<<<< HEAD
		//ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		//StudentService sr = ac.getBean(StudentService.class);
						
=======
		/*ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		AdminService adminService=ac.getBean(AdminService.class);
		System.out.println(adminService.getAdmins());
		/*Admin admin=new Admin();
=======
		//ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		//StudentService sr = ac.getBean(StudentService.class);
		//ConfigurableApplicationContext ac= SpringApplication.run(SmartSchoolApplication.class, args);
		/*AdminService adminService=ac.getBean(AdminService.class);
		System.out.println(adminService.getAdmins());
		Admin admin=new Admin();
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
		admin.setUsername("mahacine");
		admin.setPassword("12365");
		adminService.create(admin);
		Admin admin=adminService.getAdmin("Ghoujdamy");
		System.out.println(admin.getUsername());
		adminService.updateUsername(admin, "Ghoujdamy");
		adminService.delete(admin);*/
<<<<<<< HEAD
>>>>>>> c10a2a4... Add restTemplate and connection to server
=======
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
	}
	
}
