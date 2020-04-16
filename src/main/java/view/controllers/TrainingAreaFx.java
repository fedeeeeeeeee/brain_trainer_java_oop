package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import view.ViewScene;

/**
 * Controller for the Training Area selector.
 * 
 */
public class TrainingAreaFx extends SceneController {

	@FXML
	private Button backBtn;
	
	@FXML
	private void areaClicked(MouseEvent event) throws IOException {
		this.getController().setArea(((Button)event.getSource()).getText());
		this.getView().switchScene(ViewScene.GAME_SELECTOR);
	}

	@FXML
	private void goBack() throws IOException {
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}
	
}
