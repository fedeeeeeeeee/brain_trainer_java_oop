package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.DimensionCalculator;
import view.SceneType;

/**
 * The fx controller for the end game scene.
 */
public class EndGameFx extends AbstractSceneController implements FxController {

    @FXML
    private GridPane grid;
    
    @FXML
    private GridPane homeGrid;
    
    @FXML
    private Label score;
    
    @FXML
    private Button homeBtn;
    
    @FXML
    private Label messageLabel;   
    
    private DimensionCalculator calculator;
    
    @Override
    public void init() {
        final int currentScore = this.getController().getCurrentScore();
        final int bestScore = this.getController().getCurrentMiniGameBest();    
        this.score.setText("Score: " + String.valueOf(currentScore) + "\nBest: " + String.valueOf(bestScore));        
        this.messageLabel.setText(currentScore < bestScore ? "You can do better!" : "Keep it going!");  
        this.resizeNode();       
    }
    
    private void resizeNode() {
        Stage stage = (Stage) homeBtn.getScene().getWindow();
        this.calculator = new DimensionCalculator(stage);              
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.calculator.setNodeFontStyle(grid, 0.08, ((double)newVal / 2));
            this.calculator.setNodeFontStyle(homeGrid, 0.07, (double)newVal/2);
        });     
        
        this.calculator.setActualNodeFontStyle(grid, 0.10);      
        this.calculator.setActualNodeFontStyle(homeGrid, 0.20);
    }
    
    @FXML
    private void backHome() {
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

}
