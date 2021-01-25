package com.ensa.SmartSchool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.config.StageManager;
import com.ensa.SmartSchool.view.FxmlView;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;

@Component
public class SmartSchoolJavaFX extends Application{
	
	@Autowired
	private ConfigurableApplicationContext context;  
    protected StageManager stageManager;
	
	
	@Override
	public void init() throws Exception {
		ApplicationContextInitializer<GenericApplicationContext> initializer = new ApplicationContextInitializer<GenericApplicationContext>() {
			@Override
			public void initialize(GenericApplicationContext genericApplicationContext) {
				genericApplicationContext.registerBean(Application.class, () -> SmartSchoolJavaFX.this);
				genericApplicationContext.registerBean(Parameters.class, () -> getParameters());
				genericApplicationContext.registerBean(HostServices.class, () -> getHostServices());
			}};
		       // this.context = new SpringApplicationBuilder().sources(SmartSchoolApplication.class).initializers(initializer).build()
				   //   .run(getParameters().getRaw().toArray(new String[0]));
			
			 SpringApplicationBuilder builder = new SpringApplicationBuilder().sources(SmartSchoolApplication.class).initializers(initializer);
		     builder.headless(false);
		     this.context=builder.build().run(getParameters().getRaw().toArray(new String[0]));
	
}



	@Override 
	public void start(Stage primaryStage) throws Exception {
		 stageManager = this.context.getBean(StageManager.class, primaryStage);
	      displayInitialScene();
		
	}


	@Override
	public void stop() throws Exception {
		this.context.close();
		Platform.exit();
	}

	protected void displayInitialScene() {
        stageManager.switchScene(FxmlView.LOGINAS);
    }
}