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
public class TrainingAreaFx extends SceneController {

    @FXML
    private Button backBtn;

    @FXML
    private void areaClicked(final MouseEvent event) throws IOException { // NOPMD
        final String selectedArea = ((Button) event.getSource()).getText();
        final TrainingArea area = Arrays.asList(TrainingArea.values()).stream()
                .filter(e -> e.getName().equals(selectedArea)).findAny().get();
        this.getController().setArea(area);
        populateList(selectedArea);
        this.getView().switchScene(ViewScene.GAME_SELECTOR);
    }

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.MAIN_MENU);
    }

    private void populateList(final String selectedArea) {
        this.getGameList().clear();
        this.getGameList().addAll(Arrays.asList(TrainingArea.values()).stream()
                .filter(e -> e.getName().equals(selectedArea)).map(TrainingArea::getMiniGameList).findAny().get());
    }

}
