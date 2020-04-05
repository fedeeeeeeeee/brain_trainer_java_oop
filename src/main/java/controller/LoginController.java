package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.controllers.SceneController;
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
	
	//al posto di "user" ci sarà un playerImpl che prende dal file e mi fa la getName()
	@FXML
	private void showMainMenu() throws IOException {
		if(txtPlayer.getText().equals("user") && txtPassword.getText().contentEquals("pass")) {
			this.switchScene(this.start, "MainMenu");
		} else {
			lblStatus.setText("Failed");
		}	
	}

}
