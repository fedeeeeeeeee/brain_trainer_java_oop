package view.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import view.ViewScene;

/** 
 * The fx controller for the minigame selector and game start scene.
 * 
 */
public class MinigameSelectorFx extends SceneController {
	
		@FXML
		private ToggleGroup difficulty;
		
		@FXML
		private Button homeBtn;
		
		@FXML
		private Button backBtn;
		
		@FXML
		private ComboBox<String> gameComboBox; 
		
		
		@FXML
		private void initializeCombo() { //NOPMD
			if(this.gameComboBox.getItems().isEmpty()) {
				final ObservableList<String> observable = FXCollections.observableArrayList(this.getGameList());
				gameComboBox.getItems().addAll(observable);
			}
		}

		@FXML
		private void startMiniGame() { //NOPMD
//			final RadioButton selectedRadioButton = (RadioButton) difficulty.getSelectedToggle();
//			final String difficulty = selectedRadioButton.getText();
//			if( !difficulty.isEmpty()) { 
//				//fa partire il gioco 
//			}
		}
		

		@FXML
		private void goBack() throws IOException { //NOPMD
			this.getView().switchScene(ViewScene.TRAINING_AREA);
		}
		
		
		@FXML
		private void backHome() throws IOException { //NOPMD
			this.getView().switchScene(ViewScene.MAIN_MENU);
		}

		
}
