package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

@Component
public class ForumController {

	
	@Autowired @Lazy
    private StageManager stageManager;
	
	  @FXML
	    void sendMessage(ActionEvent event) {
		  stageManager.switchScene(FxmlView.ADDNEWMESSAGE);
	    }

	    @FXML
	    void goForum(ActionEvent event) {
	    	stageManager.switchScene(FxmlView.MAINFORUM);
	    }
	    
	    @FXML
	    void goHomeAdmin(MouseEvent event) {

	    }

	  

	   

	    @FXML
	    void goMainNotice(MouseEvent event) {

	    }

	    @FXML
	    void logout(ActionEvent event) {

	    }
	    @FXML
	    void logout1(MouseEvent event) {

	    }

}
