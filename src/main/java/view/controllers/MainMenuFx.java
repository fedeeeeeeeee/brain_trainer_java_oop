package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ViewScene;

/**
 * The fx controller for the main menu scene.
 *
 */
public class MainMenuFx extends AbstractSceneController {

    @FXML
    private Button trainingBtn;

    @FXML
    private Button statisticsBtn;

    @FXML
    private Button howToPlayBtn;

    @FXML
    private void startTraining() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.TRAINING_AREA);
    }

    @FXML
    private void showStatistics() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.STATISTICS);
    }

    @FXML
    private void showInfo() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.HOW_TO_PLAY);
    }
}
