package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * This class represents the Main class of the JavaFX-based application.
 * 
 */
public final class Main extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
    	//attenzione mettere layouts/Login.fxml
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/Login.fxml"));
        final Scene scene = new Scene(root);
          
        // Stage configuration
        stage.setTitle("Brain Trainer");
        stage.setWidth((Screen.getPrimary().getVisualBounds().getWidth()/2 - 100)); 
        stage.setHeight((Screen.getPrimary().getVisualBounds().getHeight() - 100));  
        stage.setScene(scene);
        stage.show();
    }
// modifica
    /**
     * 
     * @param args unused
     */
    public static void main(final String[] args) {
        launch();
    }

}

