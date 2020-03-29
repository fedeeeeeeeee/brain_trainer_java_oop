package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/** 
 * The controller for Statistics scene.
 *
 */
public class StatisticsController extends SceneController {
	
	@FXML
	private Button backBtn;

	//TODO
	
	@FXML
	private void goBack() throws IOException {
		switchScene(this.backBtn, "MainMenu");
	}	
}
