package view.controllers;

import java.io.File;
import java.io.IOException;

import controller.LoginControllerImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.UserPlayer;
import model.UserPlayerImpl;
import view.DimensionCalculatorImpl;
import view.SceneType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * The fx controller for the login scene.
 *
 */
public class LoginFxImpl extends AbstractSceneController implements LoginFx, FxNormalScene {

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

    @FXML
    private GridPane grid;

    @FXML
    private GridPane gridFields;

    @FXML
    private GridPane gridBtn;

    @FXML
    private GridPane gridLbl;

    @FXML
    private ImageView logo;

    private DimensionCalculatorImpl calculator;
    private final LoginControllerImpl loginController = new LoginControllerImpl(this);

    /**
     * Enumeration for error message in the login scene.
     *
     */
    private enum MessageError {
        /**
         * String to show when fields are empty.
         */
        EMPTY_FIELD("Fields cannot be empty!"),

        /**
         * String to show when user insert an existing username.
         */
        EXISTING_USERNAME("Username already exists!"),

        /**
         * String to show when password is wrong or the username doesn't exist.
         */
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

    private UserPlayer initPlayer() {
        return new UserPlayerImpl.PlayerBuilder().username(this.txtPlayer.getText())
                .password(this.txtPassword.getText()).build();
    }

    private boolean checkEmptyFields() {
        return this.txtPassword.getText().isBlank() || this.txtPlayer.getText().isBlank();
    }

    private void switchToMenu() {
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    @FXML
    private void loginPlayer() throws IOException { // NOPMD
        if (!this.checkEmptyFields()) {
            final UserPlayer player = this.initPlayer();
            this.loginController.loginUser(player);
        } else {
            this.errorLbl.setText(MessageError.EMPTY_FIELD.toString());
        }
    }

    @FXML
    private void signUpPlayer() { // NOPMD
        if (!this.checkEmptyFields()) {
            final UserPlayer player = this.initPlayer();
            this.loginController.registerUser(player);
        } else {
            this.errorLbl.setText(MessageError.EMPTY_FIELD.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showAlert() {
        final Alert alert = new Alert(AlertType.ERROR, MessageError.EXISTING_USERNAME.toString(), ButtonType.OK);
        alert.showAndWait();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserPlayer(final File userFileName) {
        this.getController().initializePlayer(userFileName);
        this.switchToMenu();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showError() {
        this.errorLbl.setText(MessageError.INCORRECT_ENTRY.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        final Stage stage = (Stage) loginBtn.getScene().getWindow();
        this.calculator = new DimensionCalculatorImpl(stage);

        calculator.setActualNodeFontStyle(grid, 0.15);
        calculator.setActualNodeFontStyle(gridFields, 0.06);
        calculator.setActualNodeFontStyle(gridBtn, 0.20);
        calculator.setActualNodeFontStyle(gridLbl, 0.06);

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            calculator.setNodeFontStyle(grid, 0.15, (double) newVal / 2);
            calculator.setNodeFontStyle(gridFields, 0.05, (double) newVal / 2);
            calculator.setNodeFontStyle(gridBtn, 0.06, (double) newVal / 2);
            calculator.setNodeFontStyle(gridLbl, 0.07, (double) newVal / 2);
            logo.setStyle("-fx-scale-x : " + 0.005 * (double) newVal / 4 + 
                            ";-fx-scale-y : "+ 0.005 * (double) newVal / 4);
        });
    }
}
