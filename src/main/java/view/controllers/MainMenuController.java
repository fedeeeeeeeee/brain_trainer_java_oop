package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/** 
 * The controller for the main menu scene.
 *
 */
public class MainMenuController extends SceneController {
	 	
		@FXML
		private Button trainingBtn;
		
		@FXML
		private Button statisticsBtn;
		
		@FXML
		private Button backBtn;
	
		@FXML
		private void startTraining() throws IOException {
			switchScene(this.trainingBtn, "TrainingAreaSelector");
		}
	       
		
		@FXML
		private void showStatistics() throws IOException {
			switchScene(this.statisticsBtn, "Statistics");
		}
		
		
		@FXML
		private void goBack() throws IOException {
			switchScene(this.backBtn, "Login");
		}	   
}
