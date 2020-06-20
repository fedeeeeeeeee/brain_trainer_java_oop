package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.Pair;
import view.DimensionCalculator;
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
    private GridPane areasGrid;

    private DimensionCalculator calculator;

    @FXML
    private void startTraining() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.TRAINING_AREA.getFilePath());
    }

    @FXML
    private void showStatistics() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.STATISTICS.getFilePath());
    }

    @FXML
    private void showInfo() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.HOW_TO_PLAY.getFilePath());
    }

    @Override
    public void init() {
        Stage stage = (Stage) trainingBtn.getScene().getWindow();
        this.calculator = new DimensionCalculator(stage);
       
        Pair<Integer, Integer> sizeBtn = new Pair<>(calculator.getButtonWidthDimension(calculator.getNumberOfButton(areasGrid)),
                calculator.getButtonHeightDimension(calculator.getNumberOfButton(areasGrid)));

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.calculator.setFontStyleOnAction(areasGrid, 0.15); 
        }); 
        this.calculator.setActualButtonFontStyle(areasGrid, 0.35, sizeBtn); 
    }
}
