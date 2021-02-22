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
public class HomeProfessorController implements Initializable{

	@Autowired @Lazy
    private StageManager stageManager;
    @FXML
    private Label professorLogin;
    @FXML
    private Pane loginPane;
    @FXML
    private Pane home;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		professorLogin.setText(stageManager.getProfessor().getProfessorLastName() + " " + stageManager.getProfessor().getProfessorFirstName());
		loginPane.setStyle("-fx-background-color: #00ff00; -fx-background-radius: 50%");
	}

    @FXML
    void goHome(MouseEvent event) {
    	this.stageManager.switchScene(FxmlView.LOGINAS);
    }

    @FXML
    void logout(ActionEvent event) {
    	this.stageManager.switchScene(FxmlView.LOGINPROFESSOR);
    }

    @FXML
    void logout1(MouseEvent event) {
    	this.stageManager.switchScene(FxmlView.LOGINPROFESSOR);
    }

}

