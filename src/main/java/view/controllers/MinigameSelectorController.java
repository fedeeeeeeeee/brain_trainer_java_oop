package view.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import view.SceneFactory;
import view.SceneFactoryImpl;

public class MinigameSelectorController {
	private SceneFactory factory = new SceneFactoryImpl();
	
	@FXML
	Button homeBtn;
	
	@FXML
	Button backBtn;
	
	@FXML
	ComboBox<String> gameComboBox; 

	@FXML
	public void initializeCombo() {
		if(this.gameComboBox.getItems().isEmpty()) {
			ObservableList<String> observable = FXCollections.observableArrayList(factory.getGameList());
			gameComboBox.getItems().addAll(observable);
		}
	}
	
	@FXML
	public void goBack() throws IOException {	
		Stage stage = (Stage) backBtn.getScene().getWindow();
		stage.setScene(factory.createScene("TrainingAreaSelector"));
	}
	
	@FXML
	public void backHome() throws IOException {
		Stage stage = (Stage) homeBtn.getScene().getWindow();
		stage.setScene(factory.createScene("MainMenu"));
	}
}
