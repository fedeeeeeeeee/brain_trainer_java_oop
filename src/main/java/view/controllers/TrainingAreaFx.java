package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import view.TrainingArea;
import view.ViewScene;

import java.util.Arrays;

/**
 * The fx controller for the Training Area selector.
 * 
 */
public class TrainingAreaFx extends AbstractSceneController {

    @FXML
    private Button backBtn;

    @FXML
    private void areaClicked(final MouseEvent event) throws IOException { // NOPMD
        final String selectedArea = ((Button) event.getSource()).getText();
        final TrainingArea area = Arrays.asList(TrainingArea.values()).stream()
                            .filter(e -> e.getName().equals(selectedArea))
                            .findAny()
                            .get();

        this.getController().setArea(area);
        populateList(area);
        this.getView().switchScene(ViewScene.GAME_SELECTOR.getFilePath());
    }

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.MAIN_MENU.getFilePath());
    }

    private void populateList(final TrainingArea selectedArea) {
        this.getGameList().clear();
        this.getGameList().addAll(selectedArea.getMiniGameList());
    }

}
