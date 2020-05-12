package view.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.ViewScene;

/**
 * The fx controller for Statistics scene.
 *
 */
public class StatisticsFx extends AbstractSceneController {

    @FXML
    private Label statistics;

    @FXML
    private Button backBtn;

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.MAIN_MENU.getFilePath());
    }

    /**
     * Initialize and show the user's progress.
     */
    public void init() {
        final String result = this.getController().getUserPlayer().getProgress().getAverageTrainingAreaScore().entrySet()
                .stream()
                .map(entry -> entry.getKey().toString() + " " + entry.getValue().toString())
                .collect(Collectors.joining("\n"));
        this.statistics.setText(result);
    }
}
