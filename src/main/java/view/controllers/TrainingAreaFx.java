package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import view.TrainingArea;
import view.ViewScene;

import java.util.Arrays;


/**
 * Controller for the Training Area selector.
 * 
 */
public class TrainingAreaFx extends SceneController {

	@FXML
	private Button backBtn;
	
	@FXML
	private void areaClicked(MouseEvent event) throws IOException {
		String selectedArea = ((Button)event.getSource()).getText();
		TrainingArea area = Arrays.asList((TrainingArea.values())).stream()
																  .filter(e-> e.getName().equals(selectedArea))
																  .findAny()
																  .get();
		this.getController().setArea(area);
		this.getView().switchScene(ViewScene.GAME_SELECTOR);
	}

	@FXML
	private void goBack() throws IOException {
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}
	
}
