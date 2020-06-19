package view.controllers;

import java.io.IOException;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.DifficultyLevel;
import utility.Pair;
import view.DimensionCalculator;
import view.SceneType;

/**
 * The fx controller for the minigame selector and the game start scene.
 * 
 */
public class MinigameSelectorFx extends AbstractSceneController {

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
    
    private DimensionCalculator calculator;

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
            DifficultyLevel difficulty = Arrays.asList(DifficultyLevel.values()).stream()
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
        this.calculator = new DimensionCalculator();
        Stage stages = (Stage) backBtn.getScene().getWindow();
        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            calculator.setActualFontStyle2(grid, 0.15, backBtn.getWidth());
        });
        
        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            calculator.setActualFontStyle2(gridToggle, 0.15, backBtn.getWidth());
        });
        
        this.grid.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.25 * calculator.getButtonWidthDimension(calculator.getNumberOfButton(grid), stages))));
        });

        this.gridToggle.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.08 * calculator.getButtonWidthDimension(calculator.getNumberOfButton(gridToggle), stages))));
        });
    }

}
