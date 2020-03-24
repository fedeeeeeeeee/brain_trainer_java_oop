package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class TrainingAreaController extends SceneController {

	@FXML
	private Button backBtn;
	
	@FXML
	public void areaClicked(MouseEvent event) throws IOException {
		Button btn = (Button) event.getSource();
		switchScene(btn, "MiniGameSelector");
	}

	@FXML
	public void goBack() throws IOException {
		switchScene(this.backBtn, "MainMenu");
	}
}
