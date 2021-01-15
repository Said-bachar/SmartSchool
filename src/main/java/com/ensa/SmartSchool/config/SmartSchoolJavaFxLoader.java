package com.ensa.SmartSchool.config;

import java.io.IOException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

@Component
public class SmartSchoolJavaFxLoader {
	
	   private final ResourceBundle resourceBundle;
	   private final ApplicationContext context;

	    @Autowired
	    public SmartSchoolJavaFxLoader(ApplicationContext context, ResourceBundle resourceBundle) {
	        this.resourceBundle = resourceBundle;
	        this.context = context;
	    }
	    
	    public Parent load(String fxmlPath) throws IOException {      
	        FXMLLoader loader = new FXMLLoader();
	        loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
	        loader.setResources(resourceBundle);
	        loader.setLocation(getClass().getResource(fxmlPath));
	        return loader.load();
	    }

}
