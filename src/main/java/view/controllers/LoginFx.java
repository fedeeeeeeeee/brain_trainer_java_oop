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
import javafx.scene.layout.VBox;
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
	private VBox box;
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
	

//  @FXML
//  private void autoresizeImage() {
////      this.image.fitWidthProperty().bind(box.widthProperty());
////      this.image.fitHeightProperty().bind(box.heightProperty());
//      this.box.setVgrow(getRoot(), Priority.ALWAYS);
//  }
  
	private LoginController loginController = new LoginController();
	
	private boolean checkEmptyFields() {
		return this.txtPassword.getText().isBlank() || this.txtPlayer.getText().isBlank();
	}
	
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
	private void loginPlayer() throws IOException {
		if(!this.checkEmptyFields()) {
		UserPlayer player = this.initPlayer();
		if(this.loginController.isLoggedIn(player)) {
			this.setUserPlayer(player);
			this.switchToMenu();
		} else {
			this.errorLbl.setText("* Incorrect password or non-existent user!");
		}
		 } else {
	            this.errorLbl.setText(MessageError.EMPTY_FIELD.toString());
	         } 
	}
	
	@FXML
	private void signUpPlayer() {
		 if(!this.checkEmptyFields()) {
		UserPlayer player = this.initPlayer();
		if(this.loginController.isRegistered(player)) {
			this.setUserPlayer(player);
			this.switchToMenu();
		} else {
			Alert alert = new Alert(AlertType.ERROR, "Username already exists!", ButtonType.OK);
			alert.showAndWait();
		}
		 } else {
	            this.errorLbl.setText(MessageError.EMPTY_FIELD.toString());    
	        } 
	    }

	// MEGLIO DELLE COSTANTI O VA BENE LA ENUM ???
	private enum MessageError {
        EMPTY_FIELD("Fields cannot be empty!"),
        EXISTING_USERNAME("Username already exists!"),
        INCORRECT_ENTRY("Incorrect password or non-existent user!");
                
        private String message;
        
        private MessageError(String message) {
            this.message = message;
        }
        
        public String toString() {
            return "*" + this.message;
        }
            
    }
}
