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
		private Button backBtn;
	
		@FXML
		public void startTraining() throws IOException {
			this.switchScene(this.trainingBtn, "TrainingAreaSelector");
		}
	       
		@FXML
		public void showStatistics() throws IOException {
			this.switchScene(this.statisticsBtn, "Statistics");
		}
		
		@FXML
		public void goBack() throws IOException {
			this.switchScene(this.backBtn, "Login");
		}	   
}
