package com.ensa.SmartSchool.config;

import java.util.Objects;


import static org.slf4j.LoggerFactory.getLogger;

import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.entity.Student;
import com.ensa.SmartSchool.view.FxmlView;
import org.slf4j.Logger;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Data;

@Data 
public class StageManager {
	
	private static final Logger LOG = getLogger(StageManager.class);
    private final Stage primaryStage;
    private final SmartSchoolJavaFxLoader springFXMLLoader;
    
    private Student student;
    private Professor professor;
    private boolean user;
    
    public StageManager(SmartSchoolJavaFxLoader springFXMLLoader, Stage stage) {
        this.springFXMLLoader = springFXMLLoader;
        this.primaryStage = stage;
    }

    public void switchScene(final FxmlView view) {
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
        show(viewRootNodeHierarchy, view.getTitle());
    }
    private void show(final Parent rootnode, String title) {
        Scene scene = prepareScene(rootnode);
        //scene.getStylesheets().add("/styles/Styles.css");
        
        //primaryStage.initStyle(StageStyle.TRANSPARENT); //Not oblg
        // primaryStage.setResizable(false); // desactivate resize of stages
        Image iconApp = new Image("/static/PNG@2_white_icons/icons8_s_128px_2.png");
        primaryStage.getIcons().add(iconApp);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(800.0);
        primaryStage.setMinHeight(700.0);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        
        try {
            primaryStage.show();
        } catch (Exception exception) {
        	
        	 logAndExit ("Unable to show scene for title" + title,  exception);
        
        }
    }
    
    private Scene prepareScene(Parent rootnode){
        Scene scene = primaryStage.getScene();

        if (scene == null) {
            scene = new Scene(rootnode);
        }
        scene.setRoot(rootnode);
        return scene;
    }
    
    private Parent loadViewNodeHierarchy(String fxmlFilePath) {
        Parent rootNode = null;
        try {
            rootNode = springFXMLLoader.load(fxmlFilePath);
            Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
        } catch (Exception exception) {
            logAndExit("Unable to load FXML view " + fxmlFilePath, exception);
        }
        return rootNode;
    }
    
    private void logAndExit(String errorMsg, Exception exception) {
        LOG.error(errorMsg, exception, exception.getCause());
        Platform.exit();
    }

}
