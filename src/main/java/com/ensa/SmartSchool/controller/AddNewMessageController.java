package com.ensa.SmartSchool.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.entity.ForumMessage;
import com.ensa.SmartSchool.service.ForumMessageService;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

@Component
public class AddNewMessageController {
	
	  @Autowired
	   ForumMessageService forumMessageService;
	  
	  @Autowired @Lazy
	  private StageManager stageManager;
	   
	   @FXML
	    private TextArea message_id;

	    @FXML
	    private TextField topic_id;

	    @FXML
	    void cancel(ActionEvent event) {
	    	message_id.setText("");
	    	topic_id.setText("");
	    	this.stageManager.switchScene(FxmlView.FORUM);

	    }

	    @FXML
	    void send(ActionEvent event) {
	    	
	    	String topic = this.topic_id.getText();
	    	String message = this.message_id.getText();
	    	ForumMessage forumMessage = new ForumMessage();
	    	forumMessage.setTopic(topic);
	    	forumMessage.setContent(message);
	    	forumMessage.setPubDate(new Date());
	    	if(this.stageManager.isUser() == false) {
	    	forumMessage.setMessageWriter(this.stageManager.getStudent().getFirstName() + " " + this.stageManager.getStudent().getLastName());
	    	} else {
	    		forumMessage.setMessageWriter(this.stageManager.getProfessor().getProfessorFirstName()+ " " +this.stageManager.getProfessor().getProfessorLastName());
	    	}
	    	this.forumMessageService.create(forumMessage);
	    	this.stageManager.switchScene(FxmlView.MAINFORUM);
	    	

	    }
	    
	   

	    @FXML
	    void goHomeAdmin(ActionEvent event) {

	    }

	  

	    @FXML
	    void goMainNoticeAdmin(ActionEvent event) {

	    }

	   

	    @FXML
	    void logout(ActionEvent event) {

	    }

	    

	    @FXML
	    void logout1(MouseEvent event) {

	    }

	   

}
