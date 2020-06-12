package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TrainingArea;
import view.SceneType;

import java.util.Arrays;

/**
 * The fx controller for the Training Area selector.
 * 
 */
public class TrainingAreaFx extends AbstractSceneController {

    @FXML
    private Button backBtn;
    
    @FXML
    private Button memoryBtn;

    @FXML
    private Button attentionBtn;

    @FXML
    private Button reasoningBtn;

    @FXML
    private Button brainSpeedBtn;

    @FXML
    private Button visualSkillBtn;

    @FXML
    private void areaClicked(final MouseEvent event) throws IOException { // NOPMD
        final String selectedArea = ((Button) event.getSource()).getText();
        final TrainingArea area = Arrays.asList(TrainingArea.values()).stream()
                            .filter(e -> e.getName().equals(selectedArea))
                            .findAny()
                            .get();

        this.getController().setArea(area);
        populateList(area);
        this.getView().switchScene(SceneType.GAME_SELECTOR.getFilePath());
    }

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    private void populateList(final TrainingArea selectedArea) {
        this.getGameList().clear();
        this.getGameList().addAll(selectedArea.getMiniGameList());
    }

    @Override
    public void init() {
        Stage stages = (Stage) backBtn.getScene().getWindow();

        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            visualSkillBtn.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.10 * visualSkillBtn.getWidth())));
        });

        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            memoryBtn.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.10 * memoryBtn.getWidth())));
        });

        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            attentionBtn.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.10 * attentionBtn.getWidth())));
        });

        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            reasoningBtn.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.10 * reasoningBtn.getWidth())));
        });

        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            brainSpeedBtn.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.10 * brainSpeedBtn.getWidth())));
        });

        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            backBtn.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.40 * backBtn.getWidth())));
        });
    }

}
