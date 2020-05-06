package view.controllers;

import java.io.IOException;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
//import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.DifficultyLevel;
import view.ViewScene;

/**
 * The fx controller for the minigame selector and game start scene.
 * 
 */
public class MinigameSelectorFx extends AbstractSceneController {

    @FXML
    private ToggleGroup difficulty;

    @FXML
    private Button homeBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<String> gameComboBox;

    @FXML
    private void initializeCombo() { // NOPMD
        if (this.gameComboBox.getItems().isEmpty()) {
            final ObservableList<String> observable = FXCollections.observableArrayList(this.getGameList());
            gameComboBox.getItems().addAll(observable);
        }
    }

	@FXML
	private void startMiniGame() { // NOPMD
		final RadioButton selectedRadioButton = (RadioButton) difficulty.getSelectedToggle();
		final String difficultyTxt = selectedRadioButton.getText();
		DifficultyLevel difficulty = Arrays.asList(DifficultyLevel.values()).stream()
										.filter(e -> e.name().equals(difficultyTxt)).findAny().get();
		
		if (!difficultyTxt.isEmpty() && !this.gameComboBox.getValue().isEmpty()) {
			this.getController().setMiniGame(gameComboBox.getValue(), difficulty);
			this.getView().viewMinigame("/layouts/" + gameComboBox.getValue().replace(" ", "")+".fxml");
		}
	}

	@FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.TRAINING_AREA);
    }

    @FXML
    private void backHome() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.MAIN_MENU);
    }

}
