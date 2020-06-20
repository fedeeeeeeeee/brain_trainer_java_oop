package view.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utility.Pair;
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
        Pair<Integer, Integer> sizeBtn = new Pair<>(calculator.getButtonWidthDimension(calculator.getNumberOfButton(areasGrid)),
                calculator.getButtonHeightDimension(calculator.getNumberOfButton(areasGrid)));
        
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.calculator.setFontStyleOnAction(areasGrid, 0.15);
            this.calculator.setBackBtnSize(backBtn, 0.25);
        });
        
        this.calculator.setActualButtonFontStyle(areasGrid, 0.50, sizeBtn);
    }

}
