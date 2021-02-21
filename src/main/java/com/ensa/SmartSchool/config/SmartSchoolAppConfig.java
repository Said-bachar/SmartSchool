package com.ensa.SmartSchool.config;

import java.io.IOException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
<<<<<<< HEAD
=======
import org.springframework.web.client.RestTemplate;
>>>>>>> c10a2a4... Add restTemplate and connection to server

import javafx.stage.Stage;

@Configuration
public class SmartSchoolAppConfig {
	
	@Autowired 
    SmartSchoolJavaFxLoader smartSchoolJavaFxLoader;

	@Bean
    public ResourceBundle resourceBundle() {
        return ResourceBundle.getBundle("bundle");
    }
	
	@Bean
<<<<<<< HEAD
=======
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
>>>>>>> c10a2a4... Add restTemplate and connection to server
   @Lazy(value = true) //Stage only created after Spring context bootstap
    public StageManager stageManager(Stage stage) throws IOException {
        return new StageManager(smartSchoolJavaFxLoader, stage);
    }

}
