package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.TrainingArea;
import view.DimensionCalculator;
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
    
    private DimensionCalculator calculator;

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
        Stage stage = (Stage) backBtn.getScene().getWindow();
        this.calculator = new DimensionCalculator(stage);    
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.calculator.setNodeFontStyle(areasGrid, 0.07, (double)newVal/2);
            this.calculator.setBackBtnSize(backBtn, 0.07 * (double)newVal/2);
        });        
        this.calculator.setActualNodeFontStyle(areasGrid, 0.50);
        this.calculator.setBackBtnSize(backBtn, 0.20);
    }

}
