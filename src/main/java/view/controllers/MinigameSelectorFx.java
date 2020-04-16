package view.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.util.Callback;
import view.MiniGame;
import view.ViewScene;

/** 
 * The fx controller for the minigame selector and game start scene.
 * 
 */
public class MinigameSelectorFx extends SceneController {
	
		@FXML
		ToggleGroup difficulty;
		
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
		private void startMiniGame() {
			RadioButton selectedRadioButton = (RadioButton) difficulty.getSelectedToggle();
			String difficulty = selectedRadioButton.getText();
			if( !difficulty.isEmpty()) { 
				//fa partire il gioco 
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
