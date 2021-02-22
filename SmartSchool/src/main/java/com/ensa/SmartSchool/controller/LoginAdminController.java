package com.ensa.SmartSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.entity.Admin;

import com.ensa.SmartSchool.service.AdminService;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

@Component
public class LoginAdminController {
	

	@Autowired
	private AdminService adminService;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button login;
    @FXML
    private ImageView back;
    @Autowired @Lazy
    private StageManager stageManager;
    @FXML
    private ImageView close;
	
	@FXML
    public void login(ActionEvent event) {
    	
    	if(this.adminService.authenticate(this.username.getText(), this.password.getText())) {
    	System.out.println("ADMIN AUTHENTICATED");
    	/*Alert alert = new Alert(AlertType.INFORMATION);
	      alert.setTitle("Information Dialog");
	      alert.setHeaderText(null);
	      alert.setContentText("Login with sucess!");
	      alert.showAndWait();*/
    	this.stageManager.switchScene(FxmlView.HOMEADMIN);
    	
    	} else {
    		System.out.println("FALSE INFOS");
    		Alert alert = new Alert(AlertType.INFORMATION);
		      alert.setTitle("Information Dialog");
		      alert.setHeaderText(null);
		      alert.setContentText("Somthing is false!");
		      alert.showAndWait();
    	}
    }
	
	   @FXML
	    void goBack(MouseEvent event) {
	    	this.stageManager.switchScene(FxmlView.LOGINAS);
	    }
	    
	    @FXML
	    void close1(MouseEvent event) {
	    	Platform.exit();
	    }
	    
	    @FXML
	    void close(ActionEvent event) {
	    	Platform.exit();
	    }
	    
	    @FXML
	    void cancel(ActionEvent event) {
	         username.setText("");
	         password.setText("");
	    }
	    
	    @FXML
	    void forgetPassword(ActionEvent event) {

	    	System.out.println("Oooops !!");
            
            // Create a pane and set its properties
            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);
            pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            pane.setHgap(5.5);
            pane.setVgap(5.5);

            // Place nodes in the pane
            Label l1 = new Label("Update You Password");
            l1.setStyle("-fx-font-family: Arial; -fx-effect: dropshadow(three-pass-box, #ff4007, 10, 0, 0, 0); -fx-padding: 5px; -fx-text-alignment : center; -fx-font-size : 13px; -fx-font-weight: 500; -fx-text-fill: #00154f; -fx-background-color: #fff; -fx-background-radius: 8px");
            pane.add(l1, 1, 0);
            
            Label l2 = new Label("Your Username *: ");
            l2.setStyle("-fx-text-fill: #ff4007; -fx-font-size : 15px; -fx-font-weight: 500;");
            pane.add(l2, 0, 1);
            TextField username = new TextField();
            username.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
            pane.add(username, 1, 1);
            
            Label l3 = new Label("New Password *: ");
            l3.setStyle("-fx-text-fill: #ff4007; -fx-font-size : 15px; -fx-font-weight: 500;");
            pane.add(l3, 0, 2);
            PasswordField updatedPswd = new PasswordField();
            updatedPswd.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
            pane.add(updatedPswd, 1, 2);
            
            Label l4 = new Label("Confirm New Password *: ");
            l4.setStyle("-fx-text-fill: #ff4007; -fx-font-size : 15px; -fx-font-weight: 500;");
            pane.add(l4, 0, 3); 
            PasswordField updatedConfPswd = new PasswordField();
            updatedConfPswd.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
            pane.add(updatedConfPswd, 1, 3);
           
            Button saveBtn = new Button("Save");
            pane.add(saveBtn, 1, 4);
            saveBtn.setStyle("-fx-background-color: #00154f; -fx-text-fill: #fff; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
            GridPane.setHalignment(saveBtn, HPos.RIGHT);
            
         // Save onAction
            saveBtn.setOnAction(e ->{
           	 String Username = username.getText();
           	 Admin ad = this.adminService.getAdmin(Username);
           	// String oldPswd = s.getPassword();
           	 String s1 = updatedPswd.getText();
           	 String s2 = updatedConfPswd.getText();
           	 if(s1.compareTo(s2) == 0) {
           		 this.adminService.updatePassword(ad, s2);
           		 Alert alert = new Alert(AlertType.INFORMATION);
           		 alert.setTitle("Password Updated");
           		 alert.setHeaderText(null);
           		 alert.setContentText("Your password is updated with success!");
           		 alert.showAndWait();
           		
           	 } else {
           		 Alert alert = new Alert(AlertType.INFORMATION);
           		 alert.setTitle("Password Not Updated");
           		 alert.setHeaderText(null);
           		 alert.setContentText("The confirmed password must be equals to the new one!");

           		 alert.showAndWait();
           	 }
            });
            
            
            // Create a scene and place it in the stage
            Scene scene = new Scene(pane);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Modification of Notice");
            primaryStage.setScene(scene); 
            primaryStage.show(); // Display the stage
	    }
	 
	  
}
