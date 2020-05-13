package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.SceneType;

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
        this.getView().switchScene(SceneType.TRAINING_AREA.getFilePath());
    }

    @FXML
    private void showStatistics() throws IOException { // NOPMD
        this.getView().setHandleDataScene(SceneType.STATISTICS.getFilePath());
    }

    @FXML
    private void showInfo() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.HOW_TO_PLAY.getFilePath());
    }
}
