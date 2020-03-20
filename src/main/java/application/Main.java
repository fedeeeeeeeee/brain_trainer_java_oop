package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class represent the Main class of the JavaFX-based application.
 */
public final class Main extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
    	
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/Login.fxml"));
        final Scene scene = new Scene(root);
        // Stage configuration
        stage.setTitle("Brain Trainer");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * 
     * @param args unused
     */
    public static void main(final String[] args) {
        launch();
    }

}
