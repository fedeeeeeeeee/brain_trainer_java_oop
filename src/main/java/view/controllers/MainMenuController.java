package view.controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.SceneFactory;
import view.SceneFactoryImpl;
import view.View;
import view.ViewImpl;

public class MainMenuController {
	 	private SceneFactory factory = new SceneFactoryImpl();
	
		@FXML
		private Button trainingBtn;
		
		@FXML
		private Button progressBtn;
	
		@FXML
		public void startTraining() throws IOException {
			Stage stage = (Stage) trainingBtn.getScene().getWindow();
			stage.setScene(factory.createScene("TrainingAreaSelector"));
			
//		     FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/TrainingAreaSelector.fxml"));
//		     Stage stage = (Stage) trainingBtn.getScene().getWindow();
//		     Scene scene = new Scene(loader.load());
//		     stage.setScene(scene);  
		}
	       
		@FXML
		public void showStatistics() throws IOException {
			Stage stage = (Stage) progressBtn.getScene().getWindow();
			stage.setScene(factory.createScene("Statistics"));
		}
		
		@FXML
		public void goBack() throws IOException {
			
		}	    
}
