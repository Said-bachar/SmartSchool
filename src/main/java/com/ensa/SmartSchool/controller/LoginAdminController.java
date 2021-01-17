package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.service.AdminService;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;

@Component
public class LoginAdminController {
	

	@Autowired
	private AdminService adminService;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button login;
    @FXML
    private ImageView back;
    @Autowired @Lazy
    private StageManager stageManager;
    @FXML
    private ImageView close;
	
	@FXML
    public void login(ActionEvent event) {
    	
    	if(this.adminService.authenticate(this.username.getText(), this.password.getText())) {
    	System.out.println("ADMIN AUTHENTICATED");
    	Alert alert = new Alert(AlertType.INFORMATION);
	      alert.setTitle("Information Dialog");
	      alert.setHeaderText(null);
	      alert.setContentText("Login with sucess!");
	      alert.showAndWait();
    	
    	} else {
    		System.out.println("FALSE INFOS");
    		Alert alert = new Alert(AlertType.INFORMATION);
		      alert.setTitle("Information Dialog");
		      alert.setHeaderText(null);
		      alert.setContentText("Somthing is false!");
		      alert.showAndWait();
    	}
    }
	
	   @FXML
	    void goBack(MouseEvent event) {
	    	this.stageManager.switchScene(FxmlView.LOGINAS);
	    }
	    
	    @FXML
	    void close(MouseEvent event) {
	    	Platform.exit();
	    }
	 
	  
}
