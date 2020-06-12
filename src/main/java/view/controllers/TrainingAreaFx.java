package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    private VBox areasBox;

    @FXML
    private GridPane areasGrid;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        Stage stages = (Stage) backBtn.getScene().getWindow();
        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.areasGrid.getChildren().forEach(b -> {
                ((Button) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.10 * ((Button) b).getWidth())));
            }); 
            this.backBtn.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.08 * ((Button)this.areasGrid.getChildren().get(0)).getWidth())));
        }); 
    }

}
