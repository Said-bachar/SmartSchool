package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

@Component
public class HomeAdminController {

    @FXML
    private Label studentLogin;
    
    @Autowired @Lazy
    private StageManager stageManager;

    @FXML
    private Pane loginPane;

    @FXML
    private Pane home;

    @FXML
    void goMainNotice(MouseEvent event) {
         this.stageManager.switchScene(FxmlView.MAINNOTICEADMIN);
    }

    @FXML
    void goHome(MouseEvent event) {
    	this.stageManager.switchScene(FxmlView.LOGINAS);
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
