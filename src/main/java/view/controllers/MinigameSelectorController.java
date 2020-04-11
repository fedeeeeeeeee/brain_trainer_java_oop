package view.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.Callback;
import view.ViewScene;

/** 
 * Controller for the minigame selector and game start scene.
 * 
 */
public class MinigameSelectorController extends SceneController {
	
		@FXML
		Button homeBtn;
		
		@FXML
		Button backBtn;
		
		@FXML
		ComboBox<String> gameComboBox; 
		
		
		@FXML
		private void initializeCombo() {
			if(this.gameComboBox.getItems().isEmpty()) {
				ObservableList<String> observable = FXCollections.observableArrayList(this.getGameList());
				gameComboBox.getItems().addAll(observable);
			}
		}


		@FXML
		private void goBack() throws IOException {	
			this.getView().switchScene(ViewScene.TRAINING_AREA);
		}
		
		
		@FXML
		private void backHome() throws IOException {
			this.getView().switchScene(ViewScene.MAIN_MENU);
		}

}
