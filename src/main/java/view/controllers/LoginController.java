package view.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController extends SceneController{

	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField txtPlayer;
	
	@FXML
	private TextField txtPassword;

	@FXML
	private Button start;

	//al posto di "user" ci sarà un playerImpl che prende dal file e mi fa la getName()
	
	@FXML
	public void showMainMenu() throws IOException {
		if(txtPlayer.getText().equals("user") && txtPassword.getText().contentEquals("pass")) {
			this.switchScene(this.start, "MainMenu");
		} else {
			lblStatus.setText("Failed");
		}	
	}

}
