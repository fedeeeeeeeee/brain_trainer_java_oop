package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController extends SceneController {
	 	
		@FXML
		private Button trainingBtn;
		
		@FXML
		private Button statisticsBtn;
	
		@FXML
		public void startTraining() throws IOException {
			switchScene(this.trainingBtn, "TrainingAreaSelector");
		}
	       
		@FXML
		public void showStatistics() throws IOException {
			switchScene(this.statisticsBtn, "Statistics");
		}
		
		@FXML
		public void goBack() throws IOException {
			//TODO
		}	   
}
