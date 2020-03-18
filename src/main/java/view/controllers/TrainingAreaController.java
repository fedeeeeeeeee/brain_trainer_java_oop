package view.controllers;
import java.util.*;
import java.util.stream.Collectors;

import static view.controllers.TrainingArea.*;
import static view.controllers.MiniGame.*;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.SceneFactory;
import view.SceneFactoryImpl;

public class TrainingAreaController {
	
	private SceneFactory factory = new SceneFactoryImpl();
//	private List<String> gameList = new ArrayList<>(); 
	

	@FXML
	private Button backBtn;
	
	@FXML
	public void areaClicked(MouseEvent event) throws IOException {
		Button btn = (Button) event.getSource();
		
		System.out.println(btn.getText());
		
		factory.createComboBox(btn.getText());
		
		Stage stage = (Stage) btn.getScene().getWindow();
		stage.setScene(factory.createScene("MiniGameSelector"));
	}
	
//	private void createComboBox(String selectedArea) {
//		 this.gameList = Arrays.asList(MiniGame.values()).stream()
//				                                         .filter(e-> e.getTrainingArea().getName().equals(selectedArea))
//				                                         .map(e-> e.toString())
//				                                         .collect(Collectors.toList());
//		 System.out.println(gameList);
//	}

	@FXML
	public void goBack() throws IOException {
		Stage stage = (Stage) backBtn.getScene().getWindow();
		stage.setScene(factory.createScene("MainMenu"));
	}
}
