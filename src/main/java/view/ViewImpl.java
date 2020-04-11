package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ViewImpl extends Application implements View {
	
	 
	 @Override
	    public void start(final Stage stage) throws Exception {
	        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/Login.fxml"));
	        final Scene scene = new Scene(root);
	        
	        
	        // Stage configuration
	        stage.setWidth((Screen.getPrimary().getVisualBounds().getWidth()/2 - 100)); 
	        stage.setHeight((Screen.getPrimary().getVisualBounds().getHeight() - 100));    
	        stage.setTitle("Brain Trainer");
	        stage.setScene(scene);
	        stage.show();
	    }
}
