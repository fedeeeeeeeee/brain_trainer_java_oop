package view.controllers;

import java.io.IOException;

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
	
//	@FXML
//	ComboBox gameComboBox; 

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
