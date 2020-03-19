package view.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class MinigameSelectorController extends SceneController {
	
	@FXML
	Button homeBtn;
	
	@FXML
	Button backBtn;
	
	@FXML
	ComboBox<String> gameComboBox; 

	@FXML
	public void initializeCombo() {
		if(this.gameComboBox.getItems().isEmpty()) {
			ObservableList<String> observable = FXCollections.observableArrayList(this.getGameList());
			gameComboBox.getItems().addAll(observable);
		}
	}
	
	@FXML
	public void goBack() throws IOException {	
		switchScene(this.backBtn, "TrainingAreaSelector");
	}
	
	@FXML
	public void backHome() throws IOException {
		switchScene(this.homeBtn, "MainMenu");
	}
}
