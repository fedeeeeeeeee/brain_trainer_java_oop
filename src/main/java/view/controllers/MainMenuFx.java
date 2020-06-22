package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.DimensionCalculatorImpl;
import view.SceneType;

/**
 * The fx controller for the main menu scene.
 *
 */
public class MainMenuFx extends AbstractSceneController implements FxNormalScene {

    @FXML
    private Button trainingBtn;

    @FXML
    private Button statisticsBtn;

    @FXML
    private Button howToPlayBtn;
    
    @FXML
    private GridPane menuGrid;

    private DimensionCalculatorImpl calculator;

    @FXML
    private void startTraining() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.TRAINING_AREA.getFilePath());
    }

    @FXML
    private void showStatistics() throws IOException { // NOPMD
        this.getView().loadProgress(SceneType.STATISTICS.getFilePath());
    }

    @FXML
    private void showInfo() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.HOW_TO_PLAY.getFilePath());
    }

    @Override
    public void init() {
        final Stage stage = (Stage) trainingBtn.getScene().getWindow();
        this.calculator = new DimensionCalculatorImpl(stage);      
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.calculator.setNodeFontStyle(menuGrid, 0.08, (double)newVal / 2); 
        });        
        this.calculator.setActualNodeFontStyle(menuGrid, 0.30);
    }
}
