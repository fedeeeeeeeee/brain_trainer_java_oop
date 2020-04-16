package view.controllers;

import java.io.IOException;

import controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.UserPlayer;
import model.UserPlayerImpl;
import view.ViewScene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * The fx controller for the login scene.
 *
 */

// TODO
// NON DEVE ESTENDERE SCENE CONTROLLER -> SEPARARE I CONCETTI
public class LoginFx extends SceneController {

	@FXML
	private Label errorLbl;
	
	@FXML
	private TextField txtPlayer;
	
	@FXML
	private TextField txtPassword;

	@FXML
	private Button loginBtn;
	
	@FXML
	private Button signUpBtn;
	
	private LoginController loginController = new LoginController();
	
	private boolean checkEmptyFields() {
		return this.txtPassword.getText().isBlank() || this.txtPlayer.getText().isBlank();
	}
	
	private UserPlayer initPlayer() { 
		 try {
			 if(!this.checkEmptyFields()) {
				UserPlayer player = new UserPlayerImpl();
				player.setUsername(this.txtPlayer.getText());
				player.setPassword(this.txtPassword.getText());		
				return player;
			 } else {
				 this.errorLbl.setText("* Fields cannot be empty!");
			   } 	
	     } catch (Exception e) {
	    	 e.printStackTrace();
	     } return null;
	}
	
	private void switchToMenu() {
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}
	
	private void setUserPlayer(UserPlayer player) {
		this.getController().initializePlayer(player);
	}
	
	@FXML
	private void loginPlayer() throws IOException {
		UserPlayer player = this.initPlayer();
		if(this.loginController.isLoggedIn(player)) {
			this.setUserPlayer(player);
			this.switchToMenu();
		} else {
			this.errorLbl.setText("* Incorrect password or non-existent user!");
		}
	}
	
	@FXML
	private void signUpPlayer() {
		UserPlayer player = this.initPlayer();
		if(this.loginController.isRegistered(player)) {
			this.setUserPlayer(player);
			this.switchToMenu();
		} else {
			Alert alert = new Alert(AlertType.ERROR, "Username already exists!", ButtonType.OK);
			alert.showAndWait();
		}
	}

}
