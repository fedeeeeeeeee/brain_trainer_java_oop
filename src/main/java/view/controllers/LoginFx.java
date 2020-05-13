package view.controllers;

import java.io.File;
import java.io.IOException;

import controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.UserPlayer;
import model.UserPlayerImpl;
import view.SceneType;
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
public class LoginFx extends AbstractSceneController {

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

    private final LoginController loginController = new LoginController();

    private boolean checkEmptyFields() {
        return this.txtPassword.getText().isBlank() || this.txtPlayer.getText().isBlank();
    }

    private UserPlayer initPlayer() {
        final UserPlayer player = new UserPlayerImpl();
        player.setUsername(this.txtPlayer.getText());
        player.setPassword(this.txtPassword.getText());

        return player;
    }


    private void switchToMenu() {
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    private void setUserPlayer(final File userFileName) {
        this.getController().initializePlayer(userFileName);
    }

    @FXML
    private void loginPlayer() throws IOException { // NOPMD
        if (!this.checkEmptyFields()) {
            if (this.loginController.isLoggedIn(this.txtPlayer.getText(), this.txtPassword.getText())) {
                this.setUserPlayer(this.loginController.getUserFile());
                this.switchToMenu();
            } else {
                this.errorLbl.setText(MessageError.INCORRECT_ENTRY.toString());
            }
        } else {
            this.errorLbl.setText(MessageError.EMPTY_FIELD.toString());
        }
    }

    @FXML
    private void signUpPlayer() { // NOPMD
        if (!this.checkEmptyFields()) {
            final UserPlayer player = this.initPlayer();
            if (this.loginController.isRegistered(player)) {
                this.setUserPlayer(this.loginController.getUserFile());
                this.switchToMenu();
            } else {
                final Alert alert = new Alert(AlertType.ERROR, MessageError.EXISTING_USERNAME.toString(),
                        ButtonType.OK);
                alert.showAndWait();
            }
        } else {
            this.errorLbl.setText(MessageError.EMPTY_FIELD.toString());
        }
    }

    private enum MessageError {
        EMPTY_FIELD("Fields cannot be empty!"), EXISTING_USERNAME("Username already exists!"),
        INCORRECT_ENTRY("Incorrect password or non-existent user!");

        private String message;

        MessageError(final String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "*" + this.message;
        }
    }
}
