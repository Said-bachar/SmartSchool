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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

@Component
public class HomeStudentController implements Initializable{

	@Autowired @Lazy
    private StageManager stageManager;
    @FXML
    private Label studentLogin;

    @FXML
    private Pane loginPane;
    
    @FXML
    private Pane home;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		studentLogin.setText(stageManager.getStudent().getFirstName() + " " + stageManager.getStudent().getLastName());
		loginPane.setStyle("-fx-background-color: #00ff00; -fx-background-radius: 50%");
	}
    
	 @FXML
	    void logout(ActionEvent event) {
           this.stageManager.switchScene(FxmlView.LOGINSTUDENT);
	    }
	 @FXML
	    void logout1(MouseEvent event){
		 this.stageManager.switchScene(FxmlView.LOGINSTUDENT);
	 }
	 
	    @FXML
	    void goHome(MouseEvent event) {
	    	this.stageManager.switchScene(FxmlView.LOGINAS);
	    }

	    @FXML
	    void goNotices(MouseEvent event) {
	    	this.stageManager.switchScene(FxmlView.NOTICESTUDENT);
	    }
	    

	    @FXML
	    void goCourses(MouseEvent event) {
	    	this.stageManager.switchScene(FxmlView.COURSESSTUDENT1);
	    }
	    
	    @FXML
	    void goDocuments(MouseEvent event) {
	    	this.stageManager.switchScene(FxmlView.STUDENTDOCUMENTS);
	    }
	    
	    @FXML
	    void goForum(MouseEvent event) {
	    	this.stageManager.switchScene(FxmlView.FORUM);
	    }

	    

}
