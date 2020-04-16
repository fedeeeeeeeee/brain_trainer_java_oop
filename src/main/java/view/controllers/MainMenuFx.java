package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ViewScene;

/** 
 * The fx controller for the main menu scene.
 *
 */
public class MainMenuFx extends SceneController {
	 	
		@FXML
		private Button trainingBtn;
		
		@FXML
		private Button statisticsBtn;
		
		@FXML
		private Button backBtn;
	
		@FXML
		private void startTraining() throws IOException {
			this.getView().switchScene(ViewScene.TRAINING_AREA);
		}
	       
		
		@FXML
		private void showStatistics() throws IOException {
			this.getView().switchScene(ViewScene.STATISTICS);
		}
		
		
		@FXML
		private void goBack() throws IOException {
			this.getView().switchScene(ViewScene.LOGIN);
		}	   
}
