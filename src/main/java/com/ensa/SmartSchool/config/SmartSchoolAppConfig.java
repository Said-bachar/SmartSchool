package com.ensa.SmartSchool.config;

import java.io.IOException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import org.springframework.web.client.RestTemplate;



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
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
   @Lazy(value = true) //Stage only created after Spring context bootstap
    public StageManager stageManager(Stage stage) throws IOException {
        return new StageManager(smartSchoolJavaFxLoader, stage);
    }

}
