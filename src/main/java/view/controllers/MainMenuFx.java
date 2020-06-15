package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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

//    private int calculateButton(numButton ) {
//        numBtton *2 + 2; 
//    }
    @Override
    public void init() {
        Stage stages = (Stage) trainingBtn.getScene().getWindow();  
        stages.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.areasGrid.getChildren().forEach(b -> {
                ((Button) b).setStyle(String.format("-fx-font-size: %dpx;", (int) (0.10 * ((Button) b).getWidth())));
            }); 
        }); 
        
        Double sizeScene= trainingBtn.getScene().getWindow().getScene().getHeight();
        //TODO
        Double sizeBtn = sizeScene/10;
        this.areasGrid.getChildren().forEach(b -> {
            ((Button) b).setStyle(String.format("-fx-font-size: %dpx;",(int) (0.40 * sizeBtn)));
        });  
    }
}
