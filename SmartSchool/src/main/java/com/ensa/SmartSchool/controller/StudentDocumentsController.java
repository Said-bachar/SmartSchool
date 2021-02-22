package com.ensa.SmartSchool.controller;

import java.awt.Dimension;
import java.util.Locale;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.documents.PrintFileGenerator;
import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.service.StudentService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.swing.JRViewer;

@Component
public class StudentDocumentsController {
	
	final private String tuitionCertificate="src/main/resources/jasper/tuition_certificate.jrxml";
	final private String internshipCertificate1="src/main/resources/jasper/internship_certificate.jrxml";
	final private String internshipCertificate2="src/main/resources/jasper/internship_certificate2.jrxml";

	@FXML
    private RadioButton tuition;
    @FXML
    private ToggleGroup certificate;
    @FXML
    private RadioButton internship;
	@Autowired @Lazy
    private StageManager stageManager;
    @FXML
    private Button button_generate;
    @Autowired
    private StudentService studentService;

    @FXML
    void generateFile(ActionEvent event) throws JRException {
		JFrame frame = new JFrame("Attestation");
		JRViewer viewer=null;
		if(!tuition.isSelected() && !internship.isSelected()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Choix manquant");
			alert.setHeaderText(null);
			alert.setContentText("Veuillez choisir un document !");
			alert.showAndWait();
			return;
		}
		if(tuition.isSelected()) {
			System.out.println(stageManager.getStudent().getMaxAttempts());
			if(stageManager.getStudent().getMaxAttempts()>0) {
				viewer = new JRViewer(PrintFileGenerator.generate(stageManager.getStudent(),Locale.FRANCE,tuitionCertificate));
				studentService.updateMaxAttempts(stageManager.getStudent());
				stageManager.getStudent().setMaxAttempts(stageManager.getStudent().getMaxAttempts()-1);
			}
			else {
				Alert alertAttempts = new Alert(AlertType.ERROR);
				alertAttempts.setTitle("Tentatives");
				alertAttempts.setHeaderText(null);
				alertAttempts.setContentText("Vous avez dépassé le nombre de demandes authorisées !");
				alertAttempts.showAndWait();
				return;
			}
		}
		if(internship.isSelected()) {
			viewer = new JRViewer(PrintFileGenerator.generateInternshipCertificate(internshipCertificate1,internshipCertificate2));
		}
		frame.add(viewer);
		frame.setSize(new Dimension(700, 600));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
    }
}
