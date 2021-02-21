package com.ensa.SmartSchool.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.entity.Notice;
import com.ensa.SmartSchool.service.NoticeService;
import com.ensa.SmartSchool.view.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;


@Component
public class MainNoticeAdminController implements Initializable {

	@FXML
    private TableView<Notice> notice_admin_table;

    @FXML
    private TableColumn<Notice, String> publication_date_col;

    @FXML
    private TableColumn<Notice, String> title_col;

    @FXML
    private TableColumn<Notice, String> details_col;

    @FXML
    private TextField pub_by_title;
    
    
    @Autowired
   	private NoticeService noticeService;
       
   	@Autowired @Lazy
    private StageManager stageManager;
    
   	@FXML
    private Button delete_btn;
   	
   	List<Notice> noticeList = new ArrayList<Notice>();
   	
   	@Override
	public void initialize(URL location, ResourceBundle resources) {
   				
   		title_col.setCellValueFactory(new PropertyValueFactory<Notice, String>("title"));
   		publication_date_col.setCellValueFactory(new PropertyValueFactory<Notice, String>("publicationDate"));
   		details_col.setCellValueFactory(new PropertyValueFactory<Notice, String>("message"));
   		noticeList = this.noticeService.getNotices();
   		ObservableList<Notice> observableNoticeList = FXCollections.observableList(noticeList);
   		notice_admin_table.setItems(observableNoticeList);
   			
	}

    @FXML
    void goNoticeAdmin(ActionEvent event) {
    	this.stageManager.switchScene(FxmlView.NOTICEADMIN);
    }
    
    @FXML
    void goMainNotice(MouseEvent event) {
         this.stageManager.switchScene(FxmlView.MAINNOTICEADMIN);
    }
  
    @FXML
    void goHomeAdmin(MouseEvent event) {
        this.stageManager.switchScene(FxmlView.HOMEADMIN);
    }
    
    @FXML
    void logout(ActionEvent event) {
       this.stageManager.switchScene(FxmlView.LOGINADMIN);
    }
    
    @FXML
    void logout1(MouseEvent event){
	 this.stageManager.switchScene(FxmlView.LOGINADMIN);
 }
    
    @FXML
    void search(ActionEvent event) {
    	
    	String title = this.pub_by_title.getText();
    	Notice not = this.noticeService.getNoticeByTitle(title);
    	notice_admin_table.getItems().clear();
    	notice_admin_table.getItems().add(not);
    }
    @FXML
    void updateNotice() {
    	Notice selectedNotice = notice_admin_table.getSelectionModel().getSelectedItem();
    	
    	 // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Place nodes in the pane
        Label l1 = new Label("Notice Modifications");
        l1.setStyle("-fx-font-family: Arial; -fx-effect: dropshadow(three-pass-box, #ff4007, 10, 0, 0, 0); -fx-padding: 5px; -fx-text-alignment : center; -fx-font-size : 17px; -fx-font-weight: 500; -fx-text-fill: #00154f; -fx-background-color: #fff; -fx-background-radius: 8px");
        pane.add(l1, 1, 0);
        Label l2 = new Label("Date of publication: ");
        l2.setStyle("-fx-text-fill: #ff4007; -fx-font-size : 15px; -fx-font-weight: 500;");
        pane.add(l2, 0, 1);
        TextField updatedDate = new TextField(selectedNotice.getPublicationDate());
        updatedDate.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        pane.add(updatedDate, 1, 1);
        Label l3 = new Label("Title: ");
        l3.setStyle("-fx-text-fill: #ff4007; -fx-font-size : 15px; -fx-font-weight: 500;");
        pane.add(l3, 0, 2); 
        TextField updatedTitle = new TextField(selectedNotice.getTitle());
        updatedTitle.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        pane.add(updatedTitle, 1, 2);
        Label l4 = new Label("Message: ");
        l4.setStyle("-fx-text-fill: #ff4007; -fx-font-size : 15px; -fx-font-weight: 500;");
        pane.add(l4, 0, 3);
        TextArea updatedMessage = new TextArea(selectedNotice.getMessage());
        updatedMessage.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        pane.add(updatedMessage, 1, 3);
        Button saveBtn = new Button("Save");
        pane.add(saveBtn, 1, 4);
        saveBtn.setStyle("-fx-background-color: #00154f; -fx-text-fill: #fff; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
        GridPane.setHalignment(saveBtn, HPos.RIGHT);
        pane.add(new Label(""), 0, 4);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Modification of Notice");
        primaryStage.setScene(scene); 
        primaryStage.show(); // Display the stage
        
        // Save onAction
         saveBtn.setOnAction(e ->{
        	 this.noticeService.delete(selectedNotice);
        	 String pubDate = updatedDate.getText();
        	 String notTitle = updatedTitle.getText();
        	 String notMessage = updatedMessage.getText();
        	 Notice notice = new Notice();
        	 notice.setPublicationDate(pubDate);
        	 notice.setTitle(notTitle);
        	 notice.setMessage(notMessage);
        	 this.noticeService.create(notice);
        	 title_col.setCellValueFactory(new PropertyValueFactory<Notice, String>(notTitle));
        	 publication_date_col.setCellValueFactory(new PropertyValueFactory<Notice, String>(pubDate));
        	 details_col.setCellValueFactory(new PropertyValueFactory<Notice, String>(notMessage));
        	 primaryStage.close();
        	 stageManager.switchScene(FxmlView.MAINNOTICEADMIN);
         });
    	
    }
       
 
    @FXML
    void delete(ActionEvent event) {
    
    	Alert alt = new Alert(AlertType.CONFIRMATION);
    	alt.setTitle("Delete Notice");
    	alt.setHeaderText("Are you sure, you want to delete this notice ?");
    	ButtonType yesBtn = new ButtonType("Yes", ButtonData.YES);
    	ButtonType noBtn = new ButtonType("No", ButtonData.NO);
    	alt.getButtonTypes().setAll(yesBtn, noBtn);
    	Optional<ButtonType> res = alt.showAndWait();
    	
    	if(res.get() == yesBtn) {
    	
    	Notice selectedNotice = notice_admin_table.getSelectionModel().getSelectedItem();
    	noticeService.delete(selectedNotice);
    	notice_admin_table.getItems().remove(selectedNotice);
    	stageManager.switchScene(FxmlView.MAINNOTICEADMIN);
    	title_col.setCellValueFactory(new PropertyValueFactory<Notice, String>("title"));
   		publication_date_col.setCellValueFactory(new PropertyValueFactory<Notice, String>("publicationDate"));
   		details_col.setCellValueFactory(new PropertyValueFactory<Notice, String>("message"));

        }
    	else if(res.get() == noBtn){
    		stageManager.switchScene(FxmlView.MAINNOTICEADMIN);
    	}
   }
    
    
    
    
    
}