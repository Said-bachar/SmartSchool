package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.service.StudentService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Component
public class LoginStudentController {
	 
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button login_student;
	
	@Autowired @Lazy
	private StudentService studentService;
	
	@FXML
	 void Login(ActionEvent event) {
		
		if(studentService.authenticate(this.username.getText(), this.password.getText()))
		System.out.println("AUTHENTICATED");
		else
			System.out.println("false infos");
	}
		
}
