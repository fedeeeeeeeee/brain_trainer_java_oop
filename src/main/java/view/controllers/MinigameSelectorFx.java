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
import javafx.stage.Stage;
import model.DifficultyLevel;
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
            this.errorLbl.setText("* Please, select all fields to start playing!");
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
        Stage stages = (Stage) backBtn.getScene().getWindow();  
        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.grid.getChildren().forEach(b -> {
                ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.15 * backBtn.getWidth())));
            }); 
        });
        
        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.gridToggle.getChildren().forEach(b -> {
                ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.15 * backBtn.getWidth())));
            }); 
        });
        
        Double sizeScene = backBtn.getScene().getWindow().getScene().getHeight();
        // TODO
        Double sizeBtn = sizeScene / 10;
        this.grid.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.30 * sizeBtn)));
        });

        // TODO è storto !!! 
        this.gridToggle.getChildren().forEach(b -> {
            ((Node) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.40 * sizeBtn)));
        });
        
    }

}
