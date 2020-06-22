package view.controllers;

import java.io.IOException;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.DifficultyLevel;
import view.DimensionCalculatorImpl;
import view.SceneType;

/**
 * The fx controller for the minigame selector and the game start scene.
 * 
 */
public class MinigameSelectorFx extends AbstractSceneController implements FxNormalScene {

    @FXML
    private ToggleGroup difficulty;

    @FXML
    private Button homeBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label errorLbl;

    @FXML
    private ComboBox<String> gameComboBox;
    
    @FXML
    private GridPane grid;
    
    @FXML
    private GridPane gridToggle;
    
    @FXML
    private GridPane bottomGrid;
    
    private DimensionCalculatorImpl calculator;

    @FXML
    private void initializeCombo() { // NOPMD
        if (this.gameComboBox.getItems().isEmpty()) {
            final ObservableList<String> observable = FXCollections.observableArrayList(this.getGameList());
            gameComboBox.getItems().addAll(observable);
        }
    }

    @FXML
    private void startMiniGame() { // NOPMD
        if (checkFieldsNotNull()) {
            final RadioButton selectedRadioBtn = (RadioButton) difficulty.getSelectedToggle();
            final DifficultyLevel difficulty = Arrays.asList(DifficultyLevel.values()).stream()
                                               .filter(e -> e.name().equals(selectedRadioBtn.getText()))
                                               .findAny()
                                               .get();

            this.getController().setMiniGame(gameComboBox.getValue(), difficulty);
            this.getView().setMiniGameScene("/layouts/minigames/" + gameComboBox.getValue().replace(" ", "") + ".fxml");
        } else {
            this.errorLbl.setText("* Select all fields to start playing!");
        }
    }

    private boolean checkFieldsNotNull() {
        return this.difficulty.getSelectedToggle() != null && this.gameComboBox.getValue() != null;
    }

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.TRAINING_AREA.getFilePath());
    }

    @FXML
    private void backHome() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    @Override
    public void init() {
        final Stage stage = (Stage) backBtn.getScene().getWindow();
        this.calculator = new DimensionCalculatorImpl(stage); 
        
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            calculator.setNodeFontStyle(grid, 0.08, (double)newVal / 2);
            calculator.setNodeFontStyle(gridToggle, 0.08, (double)newVal / 2);
            calculator.setNodeFontStyle(bottomGrid, 0.08, (double)newVal / 2);
        });

        calculator.setActualNodeFontStyle(grid, 0.15);
        calculator.setActualNodeFontStyle(gridToggle, 0.08);
        calculator.setActualNodeFontStyle(bottomGrid, 0.20);
    }

}
