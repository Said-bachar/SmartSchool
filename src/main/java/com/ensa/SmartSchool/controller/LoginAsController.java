package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class LoginAsController {
	
    @FXML
    private Button btn_admin;
    @Autowired @Lazy
    private StageManager stageManager;
	
	@FXML
    void loginAdmin(ActionEvent event) {
        this.stageManager.switchScene(FxmlView.LOGINADMIN);
    }
	@FXML
    void loginStudent(ActionEvent event) {
        this.stageManager.switchScene(FxmlView.LOGINSTUDENT);
    }

}
