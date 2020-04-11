package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ViewScene;

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
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}	
}
