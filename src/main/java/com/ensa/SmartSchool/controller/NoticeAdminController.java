package com.ensa.SmartSchool.controller;


import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.entity.Notice;
import com.ensa.SmartSchool.service.NoticeService;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

@Component
public class NoticeAdminController {


	@FXML
    private TextField title;

    @FXML
    private DatePicker checkInDatePicker;

    @FXML
    private TextArea message;
    
    @Autowired
	private NoticeService noticeService;
    
	@Autowired @Lazy
    private StageManager stageManager;
	
	 
    @FXML
    void add(ActionEvent event) throws ParseException {
    	String title = this.title.getText();
    	String message = this.message.getText();
    	String pubDate = (String)this.checkInDatePicker.getEditor().getText();
    	Notice notice = new Notice();
    	notice.setTitle(title);
    	notice.setMessage(message);
    	notice.setPublicationDate(pubDate);
    	
    	this.noticeService.create(notice);
    	this.stageManager.switchScene(FxmlView.MAINNOTICEADMIN);
    	
    }
    
    @FXML
    void logout(ActionEvent event) {
       this.stageManager.switchScene(FxmlView.LOGINADMIN);
    }
    
    @FXML
    void logout1(MouseEvent event){
	 this.stageManager.switchScene(FxmlView.LOGINADMIN);
 }

   

}
