package com.ensa.SmartSchool.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

@Component
public class HomeStudentController implements Initializable{

	@Autowired @Lazy
    private StageManager stageManager;
    @FXML
    private Label studentLogin;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		studentLogin.setText(stageManager.getStudent().getFirstName());
	}
    
	 @FXML
	    void logout(ActionEvent event) {
           this.stageManager.switchScene(FxmlView.LOGINSTUDENT);
	    }
    

}
