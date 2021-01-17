package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.entity.Student;
import com.ensa.SmartSchool.service.StudentService;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

@Component
public class LoginStudentController {
	 

	@Autowired
	private StudentService studentService;
	@Autowired @Lazy
    private StageManager stageManager;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private ImageView back;
    @FXML
    private ImageView close;
    @FXML
    void close(MouseEvent event) {
         Platform.exit();
    }
    
    @FXML
    void close1(ActionEvent event) {
    	 Platform.exit();
    }

    @FXML
    void goBack(MouseEvent event) {
    	this.stageManager.switchScene(FxmlView.LOGINAS);
    }
    
    @FXML
    void goBack1(ActionEvent event) {
    	this.stageManager.switchScene(FxmlView.LOGINAS);
    }
		
	@FXML
	 void Login(ActionEvent event) {
		
		if(studentService.authenticate(this.email.getText(), this.password.getText())) {
		        System.out.println("AUTHENTICATED");
		/*Alert alert = new Alert(AlertType.INFORMATION);
		      alert.setTitle("Information Dialog");
		      alert.setHeaderText(null);
		      alert.setContentText("Login with sucess!");
		      alert.showAndWait();*/
		        Student student=studentService.getStudentByEmail(email.getText());
	    		this.stageManager.setStudent(student);
	    		this.stageManager.switchScene(FxmlView.HOMESTUDENT);
		  }
		else {
			System.out.println("false infos");
			Alert alert = new Alert(AlertType.INFORMATION);
		      alert.setTitle("Information Dialog");
		      alert.setHeaderText(null);
		      alert.setContentText("Somthing is wrong !");
		      alert.showAndWait();
			}
	}
	 
}
