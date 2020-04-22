package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import view.MiniGame;
import view.TrainingArea;
import view.ViewScene;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * The fx controller for the Training Area selector.
 * 
 */
public class TrainingAreaFx extends SceneController {
	
	@FXML
	private Button backBtn;
	
	
	@FXML
	private void areaClicked(MouseEvent event) throws IOException { //NOPMD
		final String selectedArea = ((Button)event.getSource()).getText();
		final TrainingArea area = Arrays.asList(TrainingArea.values()).stream()
																  .filter(e-> e.getName().equals(selectedArea))
																  .findAny()
																  .get();
		this.getController().setArea(area);
		populateList(selectedArea);
		this.getView().switchScene(ViewScene.GAME_SELECTOR);
	}

	
	@FXML
	private void goBack() throws IOException { //NOPMD
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}
	
	private void populateList(final String selectedArea) {
	     this.getGameList().clear();
	     this.getGameList().addAll(Arrays.asList(MiniGame.values()).stream()
							                              .filter(e-> e.getTrainingArea().getName().equals(selectedArea))
							                              .map(e-> e.toString())
							                              .collect(Collectors.toList()));
	} 
	
}
