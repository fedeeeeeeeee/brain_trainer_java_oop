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

public class MainMenuController {
	 	
		@FXML
		private Button trainingBtn;
		
		@FXML
		private Button progressBtn;
	
		@FXML
		public void startTraining() throws IOException {
		     FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/TrainingAreaSelector.fxml"));
		     Stage stage = (Stage) trainingBtn.getScene().getWindow();
		     Scene scene = new Scene(loader.load());
		     stage.setScene(scene);
		}
	       
		@FXML
		public void showStatistics() {
		    
		}
		
		@FXML
		public void goBack() {
		  System.exit(0);
		}	    
}
