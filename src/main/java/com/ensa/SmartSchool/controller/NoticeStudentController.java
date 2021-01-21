package com.ensa.SmartSchool.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@Component
public class NoticeStudentController implements Initializable{

    

	@FXML
    private TableView<Notice> notice_student_tab;

    @FXML
    private TableColumn<Notice,String> title_student;

    @FXML
    private TableColumn<Notice,String> pub_date;

    @Autowired
   	private NoticeService noticeService;
       
   	@Autowired @Lazy
    private StageManager stageManager;
   	
   	List<Notice> noticeList = new ArrayList<Notice>();

    
    @FXML
    void logout(ActionEvent event) {
       this.stageManager.switchScene(FxmlView.LOGINSTUDENT);
    }
    
    @FXML
    void logout1(MouseEvent event){
	 this.stageManager.switchScene(FxmlView.LOGINSTUDENT);
 }

    @FXML
    void showMore(ActionEvent event) {
    	Notice selectedNotice = notice_student_tab.getSelectionModel().getSelectedItem();
    	
    	GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
        Label l1 = new Label("Message:");
        l1.setStyle("-fx-font-family: Arial; -fx-text-alignment : center; -fx-font-size : 30px; -fx-font-weight: 500; -fx-text-fill: #ff4007" );
        pane.add(l1, 0, 0);
        
        TextArea Message = new TextArea(selectedNotice.getMessage());
        Message.setStyle("-fx-font-family: Arial;-fx-font-size : 18px; -fx-font-weight: 500; -fx-text-fill: #000; -fx-background-color:#e4e4e4");
        Message.setEditable(false);
        pane.add(Message, 1, 1);
        
        Scene scene = new Scene(pane);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Voir plus"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); // Display the stage
        
        
        
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	title_student.setCellValueFactory(new PropertyValueFactory<Notice, String>("title"));
   		pub_date.setCellValueFactory(new PropertyValueFactory<Notice, String>("publicationDate"));
   		noticeList = this.noticeService.getNotices();
   		ObservableList<Notice> observableNoticeList = FXCollections.observableList(noticeList);
   		notice_student_tab.setItems(observableNoticeList);
		
	}
}
