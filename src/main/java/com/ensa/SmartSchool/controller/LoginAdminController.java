package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.service.AdminService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Component
public class LoginAdminController {
	

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
	
    @FXML
    private Button login_admin;
    
	@Autowired @Lazy
	private AdminService adminService;
	
	@FXML
    public void login(ActionEvent event) {
    	
    	if(this.adminService.authenticate(this.username.getText(), this.password.getText())) {
    	System.out.println("ADMIN AUTHENTICATED");
    	
    	} else {
    		System.out.println("FALSE INFOS");
    	}
    }

}
