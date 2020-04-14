package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.ViewScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The controller for the login scene.
 *
 */

// TODO
// NON DEVE ESTENDERE SCENE CONTROLLER -> SEPARARE I CONCETTI
public class LoginController extends SceneController {

	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField txtPlayer;
	
	@FXML
	private TextField txtPassword;

	@FXML
	private Button start;

	// motivazione password: se in futuro il gioco dovessere andare online si avrebbe un livello di protezione
	
	@FXML
	private void showMainMenu() throws IOException {
		if(txtPlayer.getText().equals("user") && txtPassword.getText().contentEquals("pass")) {
			this.getView().switchScene(ViewScene.MAIN_MENU);
		} else {
			lblStatus.setText("Failed");
		}	
	}

}
