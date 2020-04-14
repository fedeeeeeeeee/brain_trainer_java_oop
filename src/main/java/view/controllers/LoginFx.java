package view.controllers;

import java.io.IOException;

import controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.UserPlayer;
import model.UserPlayerImpl;
import view.ViewScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The controller for the login scene.
 *
 */

// TODO
// NON DEVE ESTENDERE SCENE CONTROLLER -> SEPARARE I CONCETTI
public class LoginFx extends SceneController {

	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField txtPlayer;
	
	@FXML
	private TextField txtPassword;

	@FXML
	private Button loginBtn;
	
	@FXML
	private Button signUpBtn;
	
	private LoginController loginController = new LoginController();

	// motivazione password: se in futuro il gioco dovessere andare online si avrebbe un livello di protezione
	
	private UserPlayer initPlayer() {
		UserPlayer player = new UserPlayerImpl();
		player.setUsername(this.txtPlayer.getText());
		player.setPassword(this.txtPassword.getText());
		
		return player;
	}
	
	private void switchToMenu() {
		this.getView().switchScene(ViewScene.MAIN_MENU);
	}
	
	private void setUserPlayer(UserPlayer player) {
		this.getController().initializePlayer(player);
	}
	
	@FXML
	private void showMainMenu() throws IOException {
		UserPlayer player = this.initPlayer();
		if(this.loginController.isLoggedIn(player)) {
			this.setUserPlayer(player);
	}
		this.switchToMenu();
		//--> è un problema di switchScene :( !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! <--
	}
	
	@FXML
	private void signUpPlayer() {
		UserPlayer player = this.initPlayer();
		if(this.loginController.isPlayerRegistered(player)) {
			this.setUserPlayer(player);
		}
		this.switchToMenu();
	}

}
