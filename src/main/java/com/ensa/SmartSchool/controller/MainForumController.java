package com.ensa.SmartSchool.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.entity.ForumMessage;

import com.ensa.SmartSchool.service.ForumMessageService;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


@Component
public class MainForumController implements Initializable{

	  @FXML
	    private TableView<ForumMessage> forum_message_list;
	  @Autowired
	  ForumMessageService forumMessageService;
	  
		@Autowired @Lazy
	    private StageManager stageManager;
	  

	    @FXML
	    private TableColumn<ForumMessage, String> written_by_col;

	    @FXML
	    private TextField search_by_topic;

	    @FXML
	    private TableColumn<ForumMessage, String> topic_col;

	    @FXML
	    private TableColumn<ForumMessage, Date> publication_date_col;

	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	topic_col.setCellValueFactory(new PropertyValueFactory<ForumMessage, String>("topic"));
	    	written_by_col.setCellValueFactory(new PropertyValueFactory<ForumMessage, String>("messageWriter"));
	    	publication_date_col.setCellValueFactory(new PropertyValueFactory<ForumMessage, Date>("pubDate"));
	    	
	   		ObservableList<ForumMessage> observableNoticeList = FXCollections.observableList(this.forumMessageService.getForumMessages());
	   		forum_message_list.setItems(observableNoticeList);
			
		}
	    
	    @FXML
	    void show(ActionEvent event) {
	    	ForumMessage selectedForumMessage = forum_message_list.getSelectionModel().getSelectedItem();
	    	
	    	GridPane pane = new GridPane();
	        pane.setAlignment(Pos.CENTER);
	        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	        pane.setHgap(5.5);
	        pane.setVgap(5.5);
	        
	        Label l1 = new Label("Content");
	        l1.setStyle("-fx-font-family: Arial; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); -fx-text-alignment : center; -fx-font-size : 20px; -fx-font-weight: 500; -fx-text-fill: #ff4007");
	        pane.add(l1, 1, 0);
	        
	        TextArea Message = new TextArea(selectedForumMessage.getContent());
	        Message.setStyle("-fx-font-family: Arial; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);-fx-font-size : 18px; -fx-font-weight: 500; -fx-text-fill: #00154f; -fx-background-color:#e4e4e4");
	        Message.setEditable(false);
	        pane.add(Message, 1, 1);
	        
	        Scene scene = new Scene(pane);
	        Stage primaryStage = new Stage();
	        primaryStage.setTitle("See More"); 
	        primaryStage.setScene(scene); 
	        primaryStage.show(); // Display the stage

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

	   
	    @FXML
	    void search(ActionEvent event) {
	    	System.out.println(search_by_topic.getText());	  
	    	}

	    @FXML
	    void answer(ActionEvent event) {
	    	
	    	 // Create a pane and set its properties
	        GridPane pane = new GridPane();
	        pane.setAlignment(Pos.CENTER);
	        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	        pane.setHgap(5.5);
	        pane.setVgap(5.5);

	        // Place nodes in the pane
	        Label l1 = new Label("Answer the selected question");
	        l1.setStyle("-fx-font-family: Arial; -fx-effect: dropshadow(three-pass-box, #ff4007, 10, 0, 0, 0); -fx-padding: 5px; -fx-text-alignment : center; -fx-font-size : 17px; -fx-font-weight: 500; -fx-text-fill: #00154f; -fx-background-color: #fff; -fx-background-radius: 8px");
	        pane.add(l1, 1, 0);
	       
	        TextArea answer = new TextArea();
	        answer.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
	        pane.add(answer, 1, 1);
	        
	        Button saveBtn = new Button("Save");
	        pane.add(saveBtn, 1, 3);
	        saveBtn.setStyle("-fx-background-color: #00154f; -fx-text-fill: #fff; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
	        GridPane.setHalignment(saveBtn, HPos.RIGHT);
	        pane.add(new Label(""), 0, 3);
	        
	        // Create a scene and place it in the stage
	        Scene scene = new Scene(pane);
	        Stage primaryStage = new Stage();
	        primaryStage.setTitle("Answer To the Question");
	        primaryStage.setScene(scene); 
	        primaryStage.show(); // Display the stage
	        
	        String username;
	        
	        if (this.stageManager.isUser()) {
	           username = "Pr." + this.stageManager.getProfessor().getProfessorFirstName()+" "+this.stageManager.getProfessor().getProfessorLastName();	
	        }
	        else {
	        	username = this.stageManager.getStudent().getFirstName()+" "+ this.stageManager.getStudent().getLastName();
	        }
	        
	        // Save onAction
	         saveBtn.setOnAction(e ->{
	        	 
	        	 ForumMessage selectedForumMessage = forum_message_list.getSelectionModel().getSelectedItem();
	        	 
	        	 String FinalMessage = selectedForumMessage.getContent() + "\n- Answer of: " +username+ ":\n"+ answer.getText();
	        	 this.forumMessageService.updateContent(selectedForumMessage, FinalMessage);
	        	
	        	 System.out.println(FinalMessage);
	    	   	 primaryStage.close();
	    	   	 this.stageManager.switchScene(FxmlView.MAINFORUM);
	         });
	    	

	    }

	   
}
